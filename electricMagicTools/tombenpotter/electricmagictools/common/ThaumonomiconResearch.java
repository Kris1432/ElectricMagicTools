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
		 research = new EMTResearchItem("Thaumium Drill", "EMT", ResearchAspects.thaumiumDrillResearch, -1, -2, 6, new ItemStack(ElectricMagicTools.thaumiumDrill)).setParents("Electric Magic Tools").setConcealed().setComplexity(2).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumiumDrill));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumium Chainsaw","EMT", ResearchAspects.thaumiumChainsawResearch, -2, -2, 6, new ItemStack(ElectricMagicTools.thaumiumChainsaw)).setParents("Electric Magic Tools").setConcealed().setComplexity(2).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumiumChainsaw));
		 
		 text = "1";
		 research = new EMTResearchItem("Electric Goggles", "EMT", ResearchAspects.electricGogglesResearch, 1, -2, 3, new ItemStack(ElectricMagicTools.electricGoggles)).setParents("Electric Magic Tools").setConcealed().setComplexity(2).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.electricGoggles));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumic Nanosuit Helmet", "EMT", ResearchAspects.thaumicNanoHelmet, 2, -2, 3, new ItemStack(ElectricMagicTools.nanoThaumicHelmet)).setParents("Electric Goggles").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumicNanoHelmet));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumic Quantum Helmet", "EMT", ResearchAspects.thaumicQuantumHelmet, 3, -2, 3, new ItemStack(ElectricMagicTools.quantumThaumicHelmet)).setParents("Thaumic Nanosuit Helmet").setConcealed().setComplexity(4).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumicQuantumHelmet));
		 
		 text = "1";
		 research = new EMTResearchItem("Iron Omnitool", "EMT", new AspectList(), -2, 0, -5, new ItemStack(ElectricMagicTools.ironOmnitool)).setParents("Electric Magic Tools").setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.ironOmnitool));
		 
		 text = "1";
		 research = new EMTResearchItem("Diamond Omnitool", "EMT", ResearchAspects.diamondOmnitoolResearch, -4, 0, -5, new ItemStack(ElectricMagicTools.diamondOmnitool)).setParents("Electric Magic Tools").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.diamondOmnitool));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumium Omnitool", "EMT", ResearchAspects.thaumiumOmnitoolResearch, -6, 0, 5, new ItemStack(ElectricMagicTools.thaumiumOmnitool)).setParentsHidden("Thaumium Drill", "Thaumium Chainsaw").setParents("Diamond Omnitool").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumiumOmnitool));
		 
		 text = "1";
		 research = new EMTResearchItem("Explosion Focus", "EMT", ResearchAspects.laserFocusResearch, 2, 3, -2, new ItemStack(ElectricMagicTools.explosionFocus)).setParents("Electric Magic Tools").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.explosionFocus));
		 
		 text = "1";
		 research = new EMTResearchItem("Kris-tmas Focus", "EMT", ResearchAspects.christmasFocusResearch, 3, 3, -2, new ItemStack(ElectricMagicTools.christmasFocus)).setParents("Electric Magic Tools").setConcealed().setComplexity(2).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.christmasFocus));
		 
		 text = "1";
		 research = new EMTResearchItem("Shield Focus", "EMT", ResearchAspects.shieldFocusResearch, 4, 3, -2, new ItemStack(ElectricMagicTools.shieldFocus)).setParents("Electric Magic Tools").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.shieldFocus));
		 
		 text = "1";
		 research = new EMTResearchItem("Potentia Generator", "EMT", ResearchAspects.potentiaGeneratorResearch, -2, 3, -3, new ItemStack(ElectricMagicTools.potentiaGenerator)).setParents("Electric Magic Tools").setConcealed().setComplexity(5).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.potentiaGenerator));
		 
		 text ="1";
		 research = new EMTResearchItem("Ignis Generator", "EMT", ResearchAspects.ignisGeneratorResearch, -3, 4, -3, new ItemStack(ElectricMagicTools.ignisGenerator)).setParents("Potentia Generator").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.ignisGenerator));
		 
		 text ="1";
		 research = new EMTResearchItem("Auram Generator", "EMT", ResearchAspects.auramGeneratorResearch, -1, 4, -3, new ItemStack(ElectricMagicTools.auramGenerator)).setParents("Potentia Generator").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.auramGenerator));
		 
		 text = "1";
		 research = new EMTResearchItem("Chainsaw of the Stream", "EMT", ResearchAspects.streamChainsawResearch, -4, -2, 6, new ItemStack(ElectricMagicTools.streamChainsaw)).setParents("Thaumium Chainsaw").setConcealed().setComplexity(5).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.streamChainsaw));
	 }
}