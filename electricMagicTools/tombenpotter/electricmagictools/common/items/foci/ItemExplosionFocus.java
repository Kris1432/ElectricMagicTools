package electricMagicTools.tombenpotter.electricmagictools.common.items.foci;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.common.items.wands.ItemWandCasting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.EntityLaser;

public class ItemExplosionFocus extends ItemBaseFocus {

	private static final AspectList visCost = new AspectList().add(Aspect.FIRE,
			200).add(Aspect.ENTROPY, 200);

	public ItemExplosionFocus(int id) {
		super(id);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:explosionfocus");
	}

	@Override
	public int getFocusColor() {
		return 9990;
	}

	@Override
	public AspectList getVisCost() {
		return visCost;
	}

	@Override
	public String getSortingHelper(ItemStack itemstack) {
		return "EXPLOSION";
	}

	@Override
    public ItemStack onFocusRightClick(ItemStack itemstack, World world, EntityPlayer player, MovingObjectPosition movingobjectposition) {
        ItemWandCasting wand = (ItemWandCasting)itemstack.getItem();
        if (wand.consumeAllVis(itemstack, player, getVisCost(), true)) {
            if(!world.isRemote)
            {
                    EntityLaser laser;
                    laser = new EntityLaser(world, player, 2);
            world.spawnEntityInWorld(laser);
            }
        }
                return itemstack;
    }	
}
