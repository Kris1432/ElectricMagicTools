package electricMagicTools.tombenpotter.electricmagictools.common.items.tools;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemThaumiumDrill extends ItemPickaxe implements IElectricItem {

	public ItemThaumiumDrill(int id) {
		super(id, EnumToolMaterial.EMERALD);
		this.efficiencyOnProperMaterial = 20F;
		this.setCreativeTab(CreativeTab.tabMain);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
	}

	public int maxCharge = 60000;
	private final int cost = 250;
	private final int snowCost = 150;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:thaumiumdrill");
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return false;
	}

	@Override
	public int getChargedItemId(ItemStack itemStack) {
		return this.itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack) {
		return this.itemID;
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
	public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World,
			int par3, int par4, int par5, int par6,
			EntityLivingBase par7EntityLivingBase) {
		ElectricItem.manager.use(par1ItemStack, cost, par7EntityLivingBase);
		return true;
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack) {
		return Item.pickaxeDiamond.canHarvestBlock(block)
				|| Item.shovelDiamond.canHarvestBlock(block);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block, int meta) {
		if (!ElectricItem.manager.canUse(stack, cost)) {
			return 1.0F;
		}

		if (Item.pickaxeWood.getStrVsBlock(stack, block, meta) > 1.0F
				|| Item.shovelWood.getStrVsBlock(stack, block, meta) > 1.0F) {
			return efficiencyOnProperMaterial;
		} else {
			return super.getStrVsBlock(stack, block, meta);
		}
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
	public boolean hitEntity(ItemStack itemstack,
			EntityLivingBase entityliving, EntityLivingBase entityliving1) {
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		if (ElectricItem.manager.canUse(par1ItemStack, snowCost)) {
			if (!par2World.isRemote) {
				EntitySnowball snowball;
				snowball = new EntitySnowball(par2World, par3EntityPlayer);
				par2World.spawnEntityInWorld(snowball);
			}
			ElectricItem.manager.use(par1ItemStack, snowCost, par3EntityPlayer);
		}
		return par1ItemStack;
	}
}