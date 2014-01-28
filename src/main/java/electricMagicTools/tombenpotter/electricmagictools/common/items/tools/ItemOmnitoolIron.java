package electricMagicTools.tombenpotter.electricmagictools.common.items.tools;

import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemOmnitoolIron extends ItemPickaxe implements IElectricItem{

	public int maxCharge = 20000;
	private final int cost = 100;
	private final int hitCost = 125;
	private final int snowCost = 150;

	public ItemOmnitoolIron(int id) {
		super(id, EnumToolMaterial.EMERALD);
		this.efficiencyOnProperMaterial = 13F;
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:ironomnitool");
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
		return 200;
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
		return Item.axeIron.canHarvestBlock(block)
				|| Item.swordIron.canHarvestBlock(block)
				|| Item.pickaxeIron.canHarvestBlock(block)
				|| Item.shovelIron.canHarvestBlock(block)
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
			EntityLivingBase entityliving, EntityLivingBase attacker) {
		if (ElectricItem.manager.use(itemstack, hitCost, attacker)) {
			entityliving
					.attackEntityFrom(DamageSource
							.causePlayerDamage((EntityPlayer) attacker), 8F);
		}
		return false;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, 
            float xOffset, float yOffset, float zOffset)
    {
        for(int i = 0; i < player.inventory.mainInventory.length; i++)
        {
            ItemStack torchStack = player.inventory.mainInventory[i];
            if(torchStack == null || !torchStack.getUnlocalizedName().toLowerCase().contains("torch"))
            {
                continue;
            }
            Item item = torchStack.getItem();
            if(!(item instanceof ItemBlock))
            {
                continue;
            }
            int oldMeta = torchStack.getItemDamage();
            int oldSize = torchStack.stackSize;
            boolean result = torchStack.tryPlaceItemIntoWorld(player, world, x, y, z, side, xOffset, yOffset, zOffset);
            if(player.capabilities.isCreativeMode)
            {
                torchStack.setItemDamage(oldMeta);
                torchStack.stackSize = oldSize;
            } else
            if(torchStack.stackSize <= 0)
            {
                ForgeEventFactory.onPlayerDestroyItem(player, torchStack);
                player.inventory.mainInventory[i] = null;
            }
            if(result)
            {
                return true;
            }
        }

        return super.onItemUse(stack, player, world, x, y, z, side, xOffset, yOffset, zOffset);
    }
}
