package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CreativeTab {
	
	 public static void load()
     {
     LanguageRegistry.instance().addStringLocalization("itemGroup.tabTombenpotter", "en_US", "Electric Magic Tools");
     }
     
     
 public static CreativeTabs tabTombenpotter = new CreativeTabs("tabTombenpotter") {
     public ItemStack getIconItemStack() {
            return new ItemStack(ElectricMagicTools.thaumiumDrill);}};
}

