package electricMagicTools.tombenpotter.electricmagictools.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityCompressedSolar;

public class BlockCompressedSolar extends BlockContainer {

	public BlockCompressedSolar(int par1) {
		super(par1, Material.iron);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(4.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityCompressedSolar();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
		world.removeBlockTileEntity(x, y, z);
		super.breakBlock(world, x, y, z, par5, par6);
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
		topIcon = icon
				.registerIcon("electricmagictools:essentiagenerator/solartop");
		bottomIcon = icon
				.registerIcon("electricmagictools:essentiagenerator/bottom");
		sideIcon = icon
				.registerIcon("electricmagictools:essentiagenerator/side");
		frontIcon = icon
				.registerIcon("electricmagictools:essentiagenerator/front");
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
