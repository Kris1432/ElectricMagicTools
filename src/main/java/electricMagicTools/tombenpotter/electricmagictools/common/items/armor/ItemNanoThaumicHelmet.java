package electricMagicTools.tombenpotter.electricmagictools.common.items.armor;

import ic2.api.item.ElectricItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemNanoThaumicHelmet extends ItemQuantumThaumicHelmet {

	public int maxCharge = 100000;

	public ItemNanoThaumicHelmet(int id, int par3, int par4) {
		super(id, par3, par4);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxDamage(27);
		this.setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:nanothaumichelmet");
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			int layer) {
		return "electricmagictools:textures/models/thaumicnanohelmet.png";
	}

	@Override
	public int getVisDiscount() {
		return 6;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return maxCharge;
	}

	public int getEnergyPerDamage() {
		return 1000;
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player,
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
	}
	
	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 100;
	}
}