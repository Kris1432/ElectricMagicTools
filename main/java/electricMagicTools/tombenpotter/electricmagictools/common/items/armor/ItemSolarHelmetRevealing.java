package electricMagicTools.tombenpotter.electricmagictools.common.items.armor;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import thaumcraft.api.IGoggles;
import thaumcraft.api.IVisDiscounter;
import thaumcraft.api.nodes.IRevealer;

import com.google.common.collect.MapMaker;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemSolarHelmetRevealing extends ItemArmor implements
		ISpecialArmor, IRevealer, IVisDiscounter, IGoggles, IElectricItem {

	private class PlayerState {
		boolean canRain;
	}

	public int maxCharge = 10000000;

	private static Map<EntityPlayer, PlayerState> playerState = new MapMaker()
			.weakKeys().makeMap();
	private static final Map potionCost = new HashMap();

	public ItemSolarHelmetRevealing(int id, int par3, int par4) {
		super(id, EnumArmorMaterial.IRON, par3, par4);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.tabTombenpotter);

		potionCost.put(Integer.valueOf(Potion.poison.id),
				Integer.valueOf(10000));
		potionCost.put(Integer.valueOf(Potion.wither.id),
				Integer.valueOf(15000));
		potionCost.put(Integer.valueOf(Potion.confusion.id),
				Integer.valueOf(5000));
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String layerType) {
		return "electricmagictools:textures/models/solarrevealinghelmet.png";
	}

	@Override
	public void onArmorTickUpdate(World worldObj, EntityPlayer player,
			ItemStack itemStack) {
		
		if (ElectricItem.manager.canUse(itemStack, 1 / 1000)) {

			int x = MathHelper.floor_double(player.posX);
			int z = MathHelper.floor_double(player.posZ);
			int y = MathHelper.floor_double(player.posY);

			int lightlevel = player.worldObj.getBlockLightValue(x, y, z);
			if (lightlevel >= 0)
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id,
						300, -3));
			ElectricItem.manager.use(itemStack, 1 / 1000, player);
		} else {
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 300,
					0, true));
		}

		if (worldObj.isRemote || worldObj.provider.hasNoSky) {
			return;
		}

		int xCoord = MathHelper.floor_double(player.posX);
		int zCoord = MathHelper.floor_double(player.posZ);

		boolean isRaining = false;
		if (!this.playerState.containsKey(player)) {
			this.playerState.put(player, new PlayerState());
		}
		PlayerState state = playerState.get(player);
		if (worldObj.getTotalWorldTime() % 20 == 0) {
			boolean canRain = worldObj.getWorldChunkManager()
					.getBiomeGenAt(xCoord, zCoord).getIntRainfall() > 0;
			state.canRain = canRain;
		}
		isRaining = state.canRain
				&& (worldObj.isRaining() || worldObj.isThundering());
		boolean theSunIsVisible = worldObj.isDaytime()
				&& !isRaining
				&& worldObj.canBlockSeeTheSky(xCoord,
						MathHelper.floor_double(player.posY) + 1, zCoord);

		if (!theSunIsVisible) {
			return;
		}

		boolean ret = false;
		if (player.inventory.armorInventory[2] != null
				&& (player.inventory.armorInventory[2].getItem() instanceof IElectricItem)) {
			{
				ret = ElectricItem.manager.charge(
						player.inventory.armorInventory[2], 128, 0x7fffffff,
						true, false) > 0;
			}
			if (ret) {
				player.inventoryContainer.detectAndSendChanges();
			}
		}

		int refill = player.getAir();
		if (ElectricItem.manager.canUse(itemStack, 1000) && refill < 100) {
			player.setAir(refill + 200);
			ElectricItem.manager.use(itemStack, 1000, null);
		}

		Iterator i$ = (new LinkedList(player.getActivePotionEffects()))
				.iterator();
		do {
			if (!i$.hasNext()) {
				break;
			}
			{
				PotionEffect effect = (PotionEffect) i$.next();
				int id = effect.getPotionID();
				Integer cost = (Integer) potionCost.get(Integer.valueOf(id));
				if (cost != null) {
					cost = Integer.valueOf(cost.intValue()
							* (effect.getAmplifier() + 1));
					if (ElectricItem.manager.canUse(itemStack, cost.intValue())) {
						ElectricItem.manager.use(itemStack, cost.intValue(),
								null);
						ItemStack milk = (new ItemStack(Item.bucketMilk));
						player.curePotionEffects(milk);
					}
				}
			}
		} while (true);
	}

	public static void clearRaining() {
		ItemSolarHelmetRevealing.playerState.clear();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:solarrevealinghelmet");
	}

	@Override
	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public int getVisDiscount() {
		return 7;
	}

	@Override
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.add(StatCollector.translateToLocal("tc.visdiscount") + ": "
				+ getVisDiscount() + "%");
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player,
			ItemStack armor, DamageSource source, double damage, int slot) {
		if (source.isUnblockable()) {
			return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(
					0, 0.0D, 0);
		} else {
			double absorptionRatio = getBaseAbsorptionRatio()
					* getDamageAbsorptionRatio();
			int energyPerDamage = getEnergyPerDamage();
			int damageLimit = energyPerDamage <= 0 ? 0
					: (25 * ElectricItem.manager.getCharge(armor))
							/ energyPerDamage;
			return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(
					0, absorptionRatio, damageLimit);
		}
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		if (ElectricItem.manager.getCharge(armor) >= getEnergyPerDamage()) {
			return (int) Math.round(20D * getBaseAbsorptionRatio()
					* getDamageAbsorptionRatio());
		} else {
			return 0;
		}
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack,
			DamageSource source, int damage, int slot) {
		ElectricItem.manager.discharge(stack, damage * getEnergyPerDamage(),
				0x7fffffff, true, false);
	}

	public double getDamageAbsorptionRatio() {
		return 1.1000000000000001D;
	}

	public int getEnergyPerDamage() {
		return 10000;
	}

	private double getBaseAbsorptionRatio() {
		return 0.14999999999999999D;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs,
			List itemList) {
		ItemStack itemStack = new ItemStack(this, 1);

		if (getChargedItemId(itemStack) == this.itemID) {
			ItemStack charged = new ItemStack(this, 1);
			ElectricItem.manager.charge(charged, 2147483647, 2147483647, true,
					false);
			itemList.add(charged);
		}

		if (getEmptyItemId(itemStack) == this.itemID)
			itemList.add(new ItemStack(this, 1, getMaxDamage()));
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return true;
	}

	@Override
	public int getChargedItemId(ItemStack itemStack) {
		return itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack) {
		return itemID;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return 1;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 1000;
	}
}
