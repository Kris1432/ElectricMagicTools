package electricMagicTools.tombenpotter.electricmagictools.common.items.armor;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;

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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemQuantumThaumicHelmet extends ItemArmor implements
		IElectricItem, IVisDiscounter, IGoggles, IRevealer, IMetalArmor,
		ISpecialArmor {
	private static final Map potionCost = new HashMap();

	public ItemQuantumThaumicHelmet(int id, int par3, int par4) {
		super(id, EnumArmorMaterial.DIAMOND, par3, par4);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);

		potionCost.put(Integer.valueOf(Potion.poison.id),
				Integer.valueOf(10000));
		potionCost.put(Integer.valueOf(Potion.wither.id),
				Integer.valueOf(15000));
		potionCost.put(Integer.valueOf(Potion.confusion.id),
				Integer.valueOf(5000));
	}

	public int maxCharge = 10000000;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:quantumthaumichelmet");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			int layer) {
		return "electricmagictools:textures/models/thaumicquantumhelmet.png";
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return false;
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
		return 2;
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player,
			ItemStack itemStack) {
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
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 10000;
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
	public int getItemEnchantability() {
		return 0;
	}

	@Override
	public boolean isRepairable() {
		return false;
	}

	@Override
	public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
		return false;
	}

	@Override
	public int getVisDiscount() {
		return 8;
	}

	@Override
	public boolean showNodes(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean showIngamePopups(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean isMetalArmor(ItemStack itemstack, EntityPlayer player) {
		return true;
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

	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.add(StatCollector.translateToLocal("tc.visdiscount") + ": "
				+ getVisDiscount() + "%");
	}
}
