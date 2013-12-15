package electricMagicTools.tombenpotter.electricmagictools.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityEssentiaGenerator;

public class BlockEssentiaGenerator extends BlockContainer {

	public BlockEssentiaGenerator(int id, Material par2Material) {
		super(id, Material.iron);
		this.setCreativeTab(CreativeTab.tabMain);
		this.setHardness(4.0F);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = iconRegister
				.registerIcon("electricmagictools:essentiagenerator");
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityEssentiaGenerator();
	}
}