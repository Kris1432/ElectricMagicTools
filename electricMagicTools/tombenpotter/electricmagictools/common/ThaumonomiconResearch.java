package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import cpw.mods.fml.common.registry.LanguageRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.lib.ResearchAspects;

public class ThaumonomiconResearch {
	
	 public static void addResearchTab()
     {
              ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");
      ResearchCategories.registerCategory("EMT", new ResourceLocation("electricmagictools:textures/tabs/emt.png"), background);
      LanguageRegistry.instance().addStringLocalization("tc.research_category.EMT", "Electric Magic Tools");
     }
	 
	 public static void addResearch() {
		 ResearchItem research; 
		 String text;
         String text2;
		 
         text = "1";
		 research = new EMTResearchItem("Electric Magic Tools", "EMT", new AspectList(), 0, 0, 0, new ResourceLocation("electricmagictools:textures/tabs/emt.png")).setRound().setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.diamondChainsaw));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumium Drill", "EMT", ResearchAspects.thaumiumDrillResearch, -2, -3, 6, new ItemStack(ElectricMagicTools.thaumiumDrill)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumiumDrill));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumium Chainsaw","EMT", ResearchAspects.thaumiumChainsawResearch, -2, 3, 6, new ItemStack(ElectricMagicTools.thaumiumChainsaw)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumiumChainsaw));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumic Nanosuit Helmet", "EMT", ResearchAspects.thaumicNanoHelmet, 1, -2, 3, new ItemStack(ElectricMagicTools.nanoThaumicHelmet)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumicNanoHelmet));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumic Quantum Helmet", "EMT", ResearchAspects.thaumicQuantumHelmet, 3, -2, 3, new ItemStack(ElectricMagicTools.quantumThaumicHelmet)).setParents("Thaumic Nanosuit Helmet").setConcealed().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumicQuantumHelmet));
		 
		 text = "1";
		 research = new EMTResearchItem("Iron Omnitool", "EMT", new AspectList(), -3, 0, -5, new ItemStack(ElectricMagicTools.ironOmnitool)).setParents("Electric Magic Tools").setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.ironOmnitool));
		 
		 text = "1";
		 research = new EMTResearchItem("Diamond Omnitool", "EMT", ResearchAspects.diamondOmnitoolResearch, -6, 0, -5, new ItemStack(ElectricMagicTools.diamondOmnitool)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.diamondOmnitool));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumium Omnitool", "EMT", ResearchAspects.thaumiumOmnitoolResearch, -9, 0, 5, new ItemStack(ElectricMagicTools.thaumiumOmnitool)).setParents("Thaumium Drill", "Thaumium Chainsaw", "Diamond Omnitool").setConcealed().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumiumOmnitool));
		 
		 text = "1";
		 research = new EMTResearchItem("Laser Focus", "EMT", ResearchAspects.laserFocusResearch, 2, 3, -2, new ItemStack(ElectricMagicTools.laserFocus)).setParents("Electric Magic Tools").setConcealed().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.laserFocus));
	 }

}
