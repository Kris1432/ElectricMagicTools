package electricMagicTools.tombenpotter.electricmagictools.common.tile;

import ic2.api.energy.prefab.BasicSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.tiles.TileJarFillable;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;

public class TileEntityArborGenerator extends TileEntity {
	int x;
	int y;
	int z;
	public ForgeDirection orientation;

	public TileEntityArborGenerator() {
		orientation = ForgeDirection.getOrientation(1);
	}

	private BasicSource energySource = new BasicSource(this, 1000000000, 3);

	@Override
	public void updateEntity() {
		energySource.updateEntity();

		findPotentia();
		TileEntity arbor = super.worldObj.getBlockTileEntity(x, y, z);
		if (arbor != null && (arbor instanceof TileJarFillable)) {
			if (checkArbor((TileJarFillable) arbor)) {
				energySource.addEnergy(325);
			}
		}
	}

	private boolean checkArbor(TileJarFillable jar) {
		if (jar.doesContainerContainAmount(Aspect.TREE, 1)) {
			x = ((TileEntity) (jar)).xCoord;
			y = ((TileEntity) (jar)).yCoord;
			z = ((TileEntity) (jar)).zCoord;
			if (!super.worldObj.isRemote) {
				jar.takeFromContainer(Aspect.TREE, 1);
				super.worldObj.addBlockEvent(super.xCoord, super.yCoord,
						super.zCoord, Config.potentiaGeneratorID, 5, 0);
			}
			return true;
		} else {
			return false;
		}
	}

	public void findPotentia() {
		if (x != 0x7fffffff) {
			TileEntity ja = super.worldObj.getBlockTileEntity(x, y, z);
			if (ja != null && (ja instanceof TileJarFillable)) {
				if (checkArbor((TileJarFillable) ja)) {
					return;
				}
				x = 0x7fffffff;
			}
		}
		int xx = 0;
		int yy = 0;
		int zz = 0;
		for (int y = -5; y <= 5; y++) {
			for (int bb = -5; bb <= 5; bb++) {
				for (int cc = 1; cc < 6; cc++) {
					xx = super.xCoord;
					yy = super.yCoord + y;
					zz = super.zCoord;
					if (orientation.getOpposite().offsetX == 0) {
						xx += bb;
						zz += cc * orientation.getOpposite().offsetZ;
					} else {
						zz += bb;
						xx += cc * orientation.getOpposite().offsetX;
					}
					TileEntity te = super.worldObj.getBlockTileEntity(xx, yy,
							zz);
					if (te != null && (te instanceof TileJarFillable)
							&& checkArbor((TileJarFillable) te)) {
						return;
					}
				}
			}
		}
	}

	@Override
	public void onChunkUnload() {
		energySource.onChunkUnload();
	}

	@Override
	public void invalidate() {
		energySource.invalidate();
		super.invalidate();
		onChunkUnload();
	}
}