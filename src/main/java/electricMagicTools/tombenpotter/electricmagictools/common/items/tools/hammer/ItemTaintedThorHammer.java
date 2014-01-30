package electricMagicTools.tombenpotter.electricmagictools.common.items.tools.hammer;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import thaumcraft.common.entities.projectile.EntityAlumentum;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTaintedThorHammer extends ItemThorHammer {

	public ItemTaintedThorHammer(int id) {
		super(id);
		this.setMaxDamage(1000);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:hammer/taintedthorhammer");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,
			EntityPlayer player) {
		player.swingItem();
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX + 8,
				player.posY, player.posZ - 8));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX - 8,
				player.posY, player.posZ + 8));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX - 8,
				player.posY, player.posZ - 8));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX + 8,
				player.posY, player.posZ + 8));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX,
				player.posY + 4, player.posZ));
		world.spawnEntityInWorld(new EntityAlumentum(world, player.posX,
				player.posY + 8, player.posZ));

		if (player.capabilities.isCreativeMode) {
			return itemstack;
		} else {
			itemstack.damageItem(40, player);
			return itemstack;
		}
	}

	@Override
	public boolean hitEntity(ItemStack itemstack,
			EntityLivingBase entityliving, EntityLivingBase attacker) {
		entityliving.attackEntityFrom(
				DamageSource.causePlayerDamage((EntityPlayer) attacker), 2F);
		itemstack.damageItem(1, attacker);
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.add("It was, once, the Hammer of Thor.");
		list.add("It is, now, very dangerous.");
		list.add("Do NOT right-click.");
	}
}
