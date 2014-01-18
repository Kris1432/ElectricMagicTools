package electricMagicTools.tombenpotter.electricmagictools.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.ElectricMagicTools;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge;

public class BlockIndustrialWandRecharge extends BlockContainer {

	public BlockIndustrialWandRecharge(int id, Material par2Material) {
		super(id, Material.iron);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(4.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityIndustrialWandRecharge();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(ElectricMagicTools.instance, 0, world, x, y, z);
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		dropItems(world, x, y, z);
		world.removeBlockTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
	}

	private void dropItems(World world, int x, int y, int z) {
		Random rand = new Random();

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if (!(tileEntity instanceof IInventory)) {
			return;
		}
		IInventory inventory = (IInventory) tileEntity;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack item = inventory.getStackInSlot(i);

			if (item != null && item.stackSize > 0) {
				float rx = rand.nextFloat() * 0.8F + 0.1F;
				float ry = rand.nextFloat() * 0.8F + 0.1F;
				float rz = rand.nextFloat() * 0.8F + 0.1F;

				EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z
						+ rz, new ItemStack(item.itemID, item.stackSize,
						item.getItemDamage()));

				if (item.hasTagCompound()) {
					entityItem.getEntityItem().setTagCompound(
							(NBTTagCompound) item.getTagCompound().copy());
				}

				float factor = 0.05F;
				entityItem.motionX = rand.nextGaussian() * factor;
				entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
				entityItem.motionZ = rand.nextGaussian() * factor;
				world.spawnEntityInWorld(entityItem);
				item.stackSize = 0;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static Icon topIcon;
	@SideOnly(Side.CLIENT)
	public static Icon bottomIcon;
	@SideOnly(Side.CLIENT)
	public static Icon sideIcon;
	@SideOnly(Side.CLIENT)
	public static Icon frontIcon;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		topIcon = icon.registerIcon("electricmagictools:essentiagenerator/top");
		bottomIcon = icon
				.registerIcon("electricmagictools:essentiagenerator/bottom");
		sideIcon = icon
				.registerIcon("electricmagictools:essentiagenerator/side");
		frontIcon = icon
				.registerIcon("electricmagictools:essentiagenerator/wandcharger");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if (side == 3) {
			return frontIcon;
		} else if (side == 1) {
			return topIcon;
		} else {
			return sideIcon;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTexture(IBlockAccess blockAccess, int x, int y, int z,
			int side) {
		TileEntity te = blockAccess.getBlockTileEntity(x, y, z);
		int metadata = blockAccess.getBlockMetadata(x, y, z);
		if (te != null) {
			return side == metadata ? frontIcon : side == 1 ? topIcon
					: side == 3 ? sideIcon : sideIcon;
		}
		return null;
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if (!world.isRemote) {
			int zNeg = world.getBlockId(x, y, z - 1);
			int zPos = world.getBlockId(x, y, z + 1);
			int xNeg = world.getBlockId(x - 1, y, z);
			int xPos = world.getBlockId(x + 1, y, z);
			byte meta = 3;

			if (Block.opaqueCubeLookup[xNeg] && !Block.opaqueCubeLookup[xPos])
				meta = 5;
			if (Block.opaqueCubeLookup[xPos] && !Block.opaqueCubeLookup[xNeg])
				meta = 4;
			if (Block.opaqueCubeLookup[zNeg] && !Block.opaqueCubeLookup[zPos])
				meta = 3;
			if (Block.opaqueCubeLookup[zPos] && !Block.opaqueCubeLookup[zNeg])
				meta = 2;
			world.setBlockMetadataWithNotify(x, y, z, meta, 2);
		}
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entity, ItemStack itemstack) {
		int rotation = MathHelper
				.floor_double((double) (entity.rotationYaw * 4F / 360F) + 0.5D) & 3;

		if (rotation == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if (rotation == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if (rotation == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if (rotation == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}
}