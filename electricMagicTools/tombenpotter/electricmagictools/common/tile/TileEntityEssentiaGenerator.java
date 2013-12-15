package electricMagicTools.tombenpotter.electricmagictools.common.tile;

import ic2.api.energy.prefab.BasicSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.tiles.TileJarFillable;
import electricMagicTools.tombenpotter.electricmagictools.common.ElectricMagicTools;

public class TileEntityEssentiaGenerator extends TileEntity {

	public int facingX;
	public int facingZ;
	private int speedyTime;
	private int speedyDelay;
	private int drainCounter;
	int jx;
	int jy;
	int jz;
	int jr;

	public TileEntityEssentiaGenerator() {
		jx = 0x7fffffff;
		jy = 0;
		jz = 0;
		jr = 0;
	}

	private BasicSource ic2EnergySource = new BasicSource(this, 1000, 1);

	@Override
	public void invalidate() {
		ic2EnergySource.invalidate(); // notify the energy source
		super.invalidate(); // this is important for mc!
	}

	@Override
	public void onChunkUnload() {
		ic2EnergySource.onChunkUnload(); // notify the energy source
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
		doStuff();
		ic2EnergySource.updateEntity();
		ic2EnergySource.addEnergy(5);
	}

	public boolean doStuff() {
		if (facingX == -5) {
			getFacing();
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
				findEssentia();
				if (drainCounter > 0) {
					drainCounter--;
					Thaumcraft.proxy.essentiaTrailFx(super.worldObj, jx, jy,
							jz, super.xCoord + facingX, super.yCoord,
							super.zCoord + facingZ, jr,
							Aspect.ENERGY.getColor(),
							(float) (drainCounter * drainCounter) / 100F);
				}
			}
		}
		return true;
	}

	private boolean checkJar(TileJarFillable jar) {
		if (jar.doesContainerContainAmount(Aspect.ENERGY, 1)) {
			jx = ((TileEntity) (jar)).xCoord;
			jy = ((TileEntity) (jar)).yCoord;
			jz = ((TileEntity) (jar)).zCoord;
			if (!super.worldObj.isRemote) {
				jar.takeFromContainer(Aspect.ENERGY, 1);
				speedyTime = 300;
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

	public void findEssentia() {
		if (jx != 0x7fffffff) {
			TileEntity te = super.worldObj.getBlockTileEntity(jx, jy, jz);
			if (te != null && (te instanceof TileJarFillable)) {
				if (checkJar((TileJarFillable) te)) {
					return;
				}
				jx = 0x7fffffff;
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
					if (facingX == 0) {
						xx += bb;
						zz += cc * facingZ;
					} else {
						zz += bb;
						xx += cc * facingX;
					}
					TileEntity te = super.worldObj.getBlockTileEntity(xx, yy,
							zz);
					if (te != null && (te instanceof TileJarFillable)
							&& checkJar((TileJarFillable) te)) {
						return;
					}
				}
			}
		}
	}

	private void getFacing() {
		facingX = 0;
		facingZ = 0;
		if (super.worldObj.getBlockId(super.xCoord - 1, super.yCoord,
				super.zCoord) == ElectricMagicTools.essentiaGeneratorID
				&& super.worldObj.getBlockMetadata(super.xCoord - 1,
						super.yCoord, super.zCoord) == 10) {
			facingX = -1;
		} else if (super.worldObj.getBlockId(super.xCoord + 1, super.yCoord,
				super.zCoord) == ElectricMagicTools.essentiaGeneratorID
				&& super.worldObj.getBlockMetadata(super.xCoord + 1,
						super.yCoord, super.zCoord) == 10) {
			facingX = 1;
		} else if (super.worldObj.getBlockId(super.xCoord, super.yCoord,
				super.zCoord - 1) == ElectricMagicTools.essentiaGeneratorID
				&& super.worldObj.getBlockMetadata(super.xCoord, super.yCoord,
						super.zCoord - 1) == 10) {
			facingZ = -1;
		} else {
			facingZ = 1;
		}
	}
}