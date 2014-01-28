package electricMagicTools.tombenpotter.electricmagictools.common.items.armor;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;
import ic2.api.item.IMetalArmor;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import thaumcraft.api.IVisDiscounter;
import thaumcraft.common.lib.Utils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemElectricBootsTraveller extends ItemArmor implements
		IElectricItem, IVisDiscounter, IMetalArmor, ISpecialArmor {

	public int maxCharge = 10000;
	public static List<String> playersWith1Step = new ArrayList();

	public ItemElectricBootsTraveller(int id, int par3, int par4) {
		super(id, EnumArmorMaterial.DIAMOND, par3, par4);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		if (ticks())
			MinecraftForge.EVENT_BUS.register(this);
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

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:electricboots");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			int layer) {
		return "electricmagictools:textures/models/electricboots.png";
	}

	@Override
	public int getVisDiscount() {
		return 2;
	}

	boolean ticks() {
		return true;
	}

	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack armor = player.getCurrentArmor(3 - armorType);
			if (armor != null && armor.getItem() == this)
				tickPlayer(player);
		}
	}

	void tickPlayer(EntityPlayer player) {
		if (player.worldObj.isRemote)
			player.stepHeight = player.isSneaking() ? 0.5F : 1F;
		Utils.setWalkSpeed(player.capabilities,
				Utils.getWalkSpeed(player.capabilities) + 0.05F);
		player.jumpMovementFactor = player.isSprinting() ? 0.05F : 0.04F;
		player.fallDistance = 0F;
		int x = (int) player.posX;
		int y = (int) player.posY - 1;
		int z = (int) player.posZ;
		if (player.worldObj.getBlockId(x, y, z) == Block.dirt.blockID)
			player.worldObj.setBlock(x, y, z, Block.grass.blockID, 0, 2);
	}

	@ForgeSubscribe
	public void onPlayerJump(LivingJumpEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			boolean hasArmor = player.getCurrentArmor(0) != null
					&& player.getCurrentArmor(0).itemID == itemID;

			if (hasArmor)
				player.motionY += 0.3;
		}
	}

	@ForgeSubscribe(priority = EventPriority.HIGH)
	public void onLivingUpdate(LivingUpdateEvent event) {
		if (event.entityLiving instanceof EntityPlayer
				&& event.entityLiving.worldObj.isRemote) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;

			boolean highStepListed = playersWith1Step.contains(player.username);
			boolean hasHighStep = player.getCurrentArmor(0) != null
					&& player.getCurrentArmor(0).itemID == itemID;

			if (hasHighStep && !highStepListed)
				playersWith1Step.add(player.username);

			if (!hasHighStep && highStepListed) {
				playersWith1Step.remove(player.username);
				player.stepHeight = 0.5F;
			}
		}
	}

	@Override
	public boolean isMetalArmor(ItemStack itemstack, EntityPlayer player) {
		return true;
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
	public int getTransferLimit(ItemStack itemStack) {
		return 100;
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

	public int getEnergyPerDamage() {
		return 100;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player,
			ItemStack armor, DamageSource source, double damage, int slot) {
		if (source.isUnblockable()) {
			return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(
					0, 0.0D, 3);
		} else {
			double absorptionRatio = getBaseAbsorptionRatio()
					* getDamageAbsorptionRatio();
			int energyPerDamage = getEnergyPerDamage();
			int damageLimit = energyPerDamage <= 0 ? 0
					: (25 * ElectricItem.manager.getCharge(armor))
							/ energyPerDamage;
			return new net.minecraftforge.common.ISpecialArmor.ArmorProperties(
					3, absorptionRatio, damageLimit);
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

	private double getBaseAbsorptionRatio() {
		return 0.14999999999999999D;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.add(StatCollector.translateToLocal("tc.visdiscount") + ": "
				+ getVisDiscount() + "%");
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player,
			ItemStack itemStack) {
	}
}