package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import electricMagicTools.tombenpotter.electricmagictools.client.gui.GuiIndustrialWandRecharger;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.container.ContainerIndustrialWandRecharge;

public class CommonProxy implements IGuiHandler {

	public void load() {
		registerRenders();
	}

	public void registerRenders() {
		/* Empty in common proxy */
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		switch (ID) {
		case 0:
			if (entity != null
					&& entity instanceof TileEntityIndustrialWandRecharge) {
				return new ContainerIndustrialWandRecharge(player.inventory,
						(TileEntityIndustrialWandRecharge) entity);
			} else {
				return null;
			}

		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		switch (ID) {
		case 0:
			if (entity != null
					&& entity instanceof TileEntityIndustrialWandRecharge) {
				return new GuiIndustrialWandRecharger(player.inventory,
						(TileEntityIndustrialWandRecharge) entity);
			} else {
				return null;
			}
		default:
			return null;

		}
	}
}