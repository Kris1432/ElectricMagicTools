package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class CreativeTab {
	
	 public static void load()
     {
     LanguageRegistry.instance().addStringLocalization("itemGroup.tabMain", "en_US", "Electric Thaumic Tools");
     }
     
     
 public static CreativeTabs tabMain = new CreativeTabs("tabMain") {
     public ItemStack getIconItemStack() {
            return new ItemStack(ElectricMagicTools.thaumiumDrill);}};
}

