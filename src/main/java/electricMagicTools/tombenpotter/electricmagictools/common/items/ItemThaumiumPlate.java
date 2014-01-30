package electricMagicTools.tombenpotter.electricmagictools.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import electricMagicTools.tombenpotter.electricmagictools.common.CreativeTab;

public class ItemThaumiumPlate extends Item {

	public ItemThaumiumPlate(int id) {
		super(id);
		this.setCreativeTab(CreativeTab.tabTombenpotter);
		this.setMaxDamage(0);
		this.setMaxStackSize(64);
		OreDictionary.registerOre("plateThaumium", this);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.itemIcon = iconRegister
				.registerIcon("electricmagictools:thaumiumplate");
	}
}
