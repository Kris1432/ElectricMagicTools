package electricMagicTools.tombenpotter.electricmagictools.common.tile;

import ic2.api.energy.prefab.BasicSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.tiles.TileJarFillable;
import electricMagicTools.tombenpotter.electricmagictools.common.ElectricMagicTools;

public class TileEntityEssentiaGenerator extends TileEntity {

	public int xSide;
	public int zSide;
	private int speedyTime;
	private int speedyDelay;
	private int drainCounter;
	int jarXCoord;
	int jarYCoord;
	int jarZCoord;
	int jar;

	public TileEntityEssentiaGenerator() {
		jarXCoord = 0x7fffffff;
		jarYCoord = 0;
		jarZCoord = 0;
		jar = 0;
	}

	private BasicSource ic2EnergySource = new BasicSource(this, 1000, 1);

	@Override
	public void invalidate() {
		ic2EnergySource.invalidate();
		super.invalidate();
	}

	@Override
	public void onChunkUnload() {
		ic2EnergySource.onChunkUnload();
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		ic2EnergySource.readFromNBT(tag);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		ic2EnergySource.writeToNBT(tag);
	}

	@Override
	public void updateEntity() {
		ic2EnergySource.updateEntity();
		ic2EnergySource.addEnergy(32);
		if (xSide == -5) {
			sideFacing();
		}
		if (!super.worldObj.isRemote) {
			if (speedyDelay > 0) {
				speedyDelay--;
			}
			if (speedyTime > 0) {
				speedyTime--;
			}
			if (speedyTime <= 0 && speedyDelay == 0) {
				speedyDelay = 120;
				createEnergyWithEssentia();
				if (drainCounter > 0) {
					drainCounter--;
					Thaumcraft.proxy.essentiaTrailFx(super.worldObj, jarXCoord,
							jarYCoord, jarZCoord, super.xCoord + xSide,
							super.yCoord, super.zCoord + zSide, jar,
							Aspect.ENERGY.getColor(),
							(float) (drainCounter * drainCounter) / 100F);
				}
			} else {
				return;
			}
		}
	}

	private boolean drawEssentiaFromJar(TileJarFillable jar) {
		if (jar.doesContainerContainAmount(Aspect.ENERGY, 1)) {
			jarXCoord = ((TileEntity) (jar)).xCoord;
			jarYCoord = ((TileEntity) (jar)).yCoord;
			jarZCoord = ((TileEntity) (jar)).zCoord;
			if (!super.worldObj.isRemote) {
				jar.takeFromContainer(Aspect.ENERGY, 1);
				speedyTime = 100;
				speedyDelay = 0;
				super.worldObj.addBlockEvent(super.xCoord, super.yCoord,
						super.zCoord, ElectricMagicTools.essentiaGeneratorID,
						5, 0);
			}
			return true;
		} else {
			return false;
		}
	}

	public void createEnergyWithEssentia() {

		if (jarXCoord != 0x7fffffff) {
			TileEntity te = super.worldObj.getBlockTileEntity(jarXCoord,
					jarYCoord, jarZCoord);
			if (te != null && (te instanceof TileJarFillable)) {
				if (drawEssentiaFromJar((TileJarFillable) te)) {
					return;
				}
				jarXCoord = 0x7fffffff;
			}
		}
		int xx = 0;
		int yy = 0;
		int zz = 0;
		for (int y = -5; y <= 5; y++) {
			for (int bb = -5; bb <= 5; bb++) {
				for (int cc = 2; cc < 12; cc++) {
					xx = super.xCoord;
					yy = super.yCoord + y;
					zz = super.zCoord;
					if (xSide == 0) {
						xx += bb;
						zz += cc * zSide;
					} else {
						zz += bb;
						xx += cc * xSide;
					}
					TileEntity te = super.worldObj.getBlockTileEntity(xx, yy,
							zz);
					if (te != null && (te instanceof TileJarFillable)
							&& drawEssentiaFromJar((TileJarFillable) te)) {
						return;
					}
				}
			}
		}
	}

	private void sideFacing() {
		xSide = 0;
		zSide = 0;
		if (super.worldObj.getBlockId(super.xCoord - 1, super.yCoord,
				super.zCoord) == ElectricMagicTools.essentiaGeneratorID
				&& super.worldObj.getBlockMetadata(super.xCoord - 1,
						super.yCoord, super.zCoord) == 10) {
			xSide = -1;
		} else if (super.worldObj.getBlockId(super.xCoord + 1, super.yCoord,
				super.zCoord) == ElectricMagicTools.essentiaGeneratorID
				&& super.worldObj.getBlockMetadata(super.xCoord + 1,
						super.yCoord, super.zCoord) == 10) {
			xSide = 1;
		} else if (super.worldObj.getBlockId(super.xCoord, super.yCoord,
				super.zCoord - 1) == ElectricMagicTools.essentiaGeneratorID
				&& super.worldObj.getBlockMetadata(super.xCoord, super.yCoord,
						super.zCoord - 1) == 10) {
			zSide = -1;
		} else {
			zSide = 1;
		}
	}
}