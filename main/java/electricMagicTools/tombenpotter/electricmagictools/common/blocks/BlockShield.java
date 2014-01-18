package electricMagicTools.tombenpotter.electricmagictools.common.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockShield extends Block{

	public BlockShield(int id) {
		super(id, Material.rock);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setHardness(1F);
		this.setResistance(200000000F);
	}

	@Override
	 public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.blockIcon = iconRegister
				.registerIcon("electricmagictools:shield");
	}
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@Override
	 protected boolean canSilkHarvest()
    {
        return false;
    }
}
