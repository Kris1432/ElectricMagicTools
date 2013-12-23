package electricMagicTools.tombenpotter.electricmagictools.common.tile;

import ic2.api.energy.prefab.BasicSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.tiles.TileJarFillable;
import electricMagicTools.tombenpotter.electricmagictools.common.ElectricMagicTools;

public class TileEntityAuramGenerator extends TileEntity {
	int x;
	int y;
	int z;
	public ForgeDirection orientation;
	private BasicSource energySource;

	public TileEntityAuramGenerator() {
		this.energySource = new BasicSource(this, 1000000000, 2);
		orientation = ForgeDirection.getOrientation(1);
	}

	@Override
	public void updateEntity() {
		energySource.updateEntity();

		findIgnis();
		TileEntity potentia = super.worldObj.getBlockTileEntity(x, y, z);
		if (potentia != null && (potentia instanceof TileJarFillable)) {
			if (checkIgnis((TileJarFillable) potentia)) {
				energySource.addEnergy(6400);
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
	}

	private boolean checkIgnis(TileJarFillable jar) {
		if (jar.doesContainerContainAmount(Aspect.AURA, 1)) {
			x = ((TileEntity) (jar)).xCoord;
			y = ((TileEntity) (jar)).yCoord;
			z = ((TileEntity) (jar)).zCoord;
			if (!super.worldObj.isRemote) {
				jar.takeFromContainer(Aspect.AURA, 1);
				super.worldObj.addBlockEvent(super.xCoord, super.yCoord,
						super.zCoord, ElectricMagicTools.auramGeneratorID,
						5, 0);
			}
			return true;
		} else {
			return false;
		}
	}

	public void findIgnis() {
		if (x != 0x7fffffff) {
			TileEntity ja = super.worldObj.getBlockTileEntity(x, y, z);
			if (ja != null && (ja instanceof TileJarFillable)) {
				if (checkIgnis((TileJarFillable) ja)) {
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
							&& checkIgnis((TileJarFillable) te)) {
						return;
					}
				}
			}
		}
	}
}