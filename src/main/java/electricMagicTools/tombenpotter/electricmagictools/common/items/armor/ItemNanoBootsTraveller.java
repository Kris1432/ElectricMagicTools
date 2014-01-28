package electricMagicTools.tombenpotter.electricmagictools.common.items.armor;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import thaumcraft.common.lib.Utils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNanoBootsTraveller extends ItemElectricBootsTraveller {

	public int maxCharge = 500000;

	public ItemNanoBootsTraveller(int id, int par3, int par4) {
		super(id, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:nanobootstravel");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			int layer) {
		return "electricmagictools:textures/models/nanobootstravel.png";
	}

	@Override
	public int getVisDiscount() {
		return 4;
	}

	@Override
	void tickPlayer(EntityPlayer player) {
		if (player.worldObj.isRemote)
			player.stepHeight = player.isSneaking() ? 0.5F : 1F;
		Utils.setWalkSpeed(player.capabilities,
				Utils.getWalkSpeed(player.capabilities) + 0.25F);
		player.jumpMovementFactor = player.isSprinting() ? 0.05F : 0.04F;
		player.fallDistance = 0F;
		int x = (int) player.posX;
		int y = (int) player.posY - 1;
		int z = (int) player.posZ;
		if (player.worldObj.getBlockId(x, y, z) == Block.dirt.blockID)
			player.worldObj.setBlock(x, y, z, Block.grass.blockID, 0, 2);
	}

	@ForgeSubscribe
	@Override
	public void onPlayerJump(LivingJumpEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack armor = player.getCurrentArmor(3 - armorType);
			boolean hasArmor = player.getCurrentArmor(0) != null
					&& player.getCurrentArmor(0).itemID == itemID;

			if (hasArmor) {
				player.motionY += 0.65;
			}
		}
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 1000;
	}

	public int getEnergyPerDamage() {
		return 200;
	}
}
