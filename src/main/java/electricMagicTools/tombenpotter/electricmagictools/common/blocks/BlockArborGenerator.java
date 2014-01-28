package electricMagicTools.tombenpotter.electricmagictools.common.blocks;

import java.util.Random;

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
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityArborGenerator;

public class BlockArborGenerator extends BlockContainer {

	public BlockArborGenerator(int id, Material par2Material) {
		super(id, Material.iron);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(4.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityArborGenerator();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int i, int j) {
		world.removeBlockTileEntity(x, y, z);
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
				.registerIcon("electricmagictools:essentiagenerator/arborfront");
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
			return side == metadata ? frontIcon : side == 3 ? topIcon
					: side == 1 ? sideIcon : sideIcon;
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

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random) {
		int l = par1World.getBlockMetadata(par2, par3, par4);
		float f = (float) par2 + 0.5F;
		float f1 = (float) par3 + 1.0F;
		float f2 = (float) par4 + 0.5F;
		float f3 = 0.52F;
		float f4 = par5Random.nextFloat() * 0.6F - 0.3F;
		par1World.spawnParticle("largesmoke", f, f1, f2, 0.0D, 0.0D, 0.0D);
	}
}