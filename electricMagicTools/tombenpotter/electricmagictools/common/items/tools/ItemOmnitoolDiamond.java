package electricMagicTools.tombenpotter.electricmagictools.common.items.tools;

import ic2.api.item.ElectricItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemOmnitoolDiamond extends ItemOmnitoolIron{
	
	public int maxCharge = 70000;
	private final int cost = 200;
	private final int hitCost = 250;

	public ItemOmnitoolDiamond(int id) {
		super(id);
		this.efficiencyOnProperMaterial = 16F;
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:diamondomnitool");
	}
	
	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}
	
	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 400;
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
		return Item.axeDiamond.canHarvestBlock(block)
				|| Item.swordDiamond.canHarvestBlock(block)
				|| Item.pickaxeDiamond.canHarvestBlock(block)
				|| Item.shovelDiamond.canHarvestBlock(block)
				|| Item.shears.canHarvestBlock(block);
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block, int meta) {
		if (!ElectricItem.manager.canUse(stack, cost)) {
			return 1.0F;
		}

		if (Item.axeWood.getStrVsBlock(stack, block, meta) > 1.0F
				|| Item.swordWood.getStrVsBlock(stack, block, meta) > 1.0F
				|| Item.pickaxeWood.getStrVsBlock(stack, block, meta) > 1.0F
				|| Item.shovelWood.getStrVsBlock(stack, block, meta) > 1.0F
				|| Item.shears.getStrVsBlock(stack, block, meta) > 1.0F) {
			return efficiencyOnProperMaterial;
		} else {
			return super.getStrVsBlock(stack, block, meta);
		}
	}
	
	@Override
	public boolean hitEntity(ItemStack itemstack,
			EntityLivingBase entityliving, EntityLivingBase attacker) {
		if (ElectricItem.manager.use(itemstack, hitCost, attacker)) {
			entityliving
					.attackEntityFrom(DamageSource
							.causePlayerDamage((EntityPlayer) attacker), 10F);
		}
		return false;
	}
	
}
