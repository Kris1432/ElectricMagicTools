package electricMagicTools.tombenpotter.electricmagictools.common.items.foci;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChristmasFocus extends ItemBaseFocus {

	private static final AspectList visCost = new AspectList().add(
			Aspect.ORDER, 500).add(Aspect.AIR, 500);

	public ItemChristmasFocus(int id) {
		super(id);
	}

	@Override
	public int getFocusColor() {
		return 99999999;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:christmasfocus");
	}

	@Override
	public AspectList getVisCost() {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "CHRISTMAS";
	}

	@Override
	public ItemStack onFocusRightClick(ItemStack itemstack, World world,
			EntityPlayer player, MovingObjectPosition movingobjectposition) {
		ItemWandCasting wand = (ItemWandCasting) itemstack.getItem();
		if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
			if (!world.isRemote) {
				EntitySnowman snowman;
				snowman = new EntitySnowman(world);
				snowman.setPosition(player.posX +2, player.posY +1, player.posZ +2);
				world.spawnEntityInWorld(snowman);
			}
		}
		return itemstack;
	}

}