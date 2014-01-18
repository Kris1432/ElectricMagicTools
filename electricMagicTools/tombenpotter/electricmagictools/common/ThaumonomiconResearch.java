package electricMagicTools.tombenpotter.electricmagictools.common;

import ic2.api.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigItems;
import cpw.mods.fml.common.registry.LanguageRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.lib.ResearchAspects;

public class ThaumonomiconResearch {
	
	 public static void addResearchTab()
     {
              ResourceLocation background = new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png");
      ResearchCategories.registerCategory("EMT", new ResourceLocation("electricmagictools:textures/misc/emt.png"), background);
      LanguageRegistry.instance().addStringLocalization("tc.research_category.EMT", "Electric Magic Tools");
     }
	 
	 public static void addResearch() {
		 ResearchItem research; 
		 String text;
         String text2;
		 
         text = "1";
		 research = new EMTResearchItem("Electric Magic Tools", "EMT", new AspectList(), 0, 0, 0, new ResourceLocation("electricmagictools:textures/misc/emt.png")).setRound().setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumiumPlate));
		 
		 text = "1";
		 research = new EMTResearchItem("Diamond Chainsaw", "EMT", new AspectList(), 5, -6, 5, new ItemStack(ElectricMagicTools.diamondChainsaw)).setRound().setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.diamondChainsaw));
		 
		 text = "1";
		 research = new EMTResearchItem("Thaumium Plate", "EMT", new AspectList(), 6, -6, -5, new ItemStack(ElectricMagicTools.thaumiumPlate)).setRound().setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumiumPlate));
		 
		 text = "1";
		 research = new EMTResearchItem("Macerating Native Ore Clusters", "EMT", new AspectList(), 5, -7, 5, Items.getItem("smallGoldDust")).setRound().setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text));
		 
		 text = "1";
		 research = new EMTResearchItem("The Legend", "EMT", new AspectList(), 5, -5, 5, new ItemStack(ElectricMagicTools.taintedThorHammer)).setRound().setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text));
		 
		 text = "1";
		 research = new EMTResearchItem("Lightning Summoner", "EMT", new AspectList(), 6, -5, 5, new ItemStack(ElectricMagicTools.lightningSummoner)).setRound().setAutoUnlock().registerResearchItem();
		 research.setPages(new ResearchPage(text));
		 
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
		 research = new EMTResearchItem("Nanosuit Goggles of Revealing", "EMT", ResearchAspects.thaumicNanoHelmet, 2, -2, 3, new ItemStack(ElectricMagicTools.nanoThaumicHelmet)).setParents("Electric Goggles").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thaumicNanoHelmet));
		 
		 text = "1";
		 research = new EMTResearchItem("Quantum Goggles of Revealing", "EMT", ResearchAspects.thaumicQuantumHelmet, 3, -2, 3, new ItemStack(ElectricMagicTools.quantumThaumicHelmet)).setParents("Nanosuit Goggles of Revealing").setConcealed().setComplexity(4).registerResearchItem();
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
		 
		 text = "1";
		 research = new EMTResearchItem("Ignis Generator", "EMT", ResearchAspects.ignisGeneratorResearch, -3, 4, -3, new ItemStack(ElectricMagicTools.ignisGenerator)).setParents("Potentia Generator").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.ignisGenerator));
		 
		 text = "1";
		 research = new EMTResearchItem("Auram Generator", "EMT", ResearchAspects.auramGeneratorResearch, -1, 4, -3, new ItemStack(ElectricMagicTools.auramGenerator)).setParents("Potentia Generator").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.auramGenerator));
		 
		 text = "1";
		 research = new EMTResearchItem("Arbor Generator",  "EMT", ResearchAspects.arborGeneratorResearch, -2, 5, -3, new ItemStack(ElectricMagicTools.arborGenerator)).setParents("Potentia Generator").setConcealed().setComplexity(3).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.arborGenerator));
		 
		 text = "1";
		 research = new EMTResearchItem("Chainsaw of the Stream", "EMT", ResearchAspects.streamChainsawResearch, -3, -4, 6, new ItemStack(ElectricMagicTools.streamChainsaw)).setParents("Thaumium Chainsaw").setConcealed().setComplexity(6).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.streamChainsaw));
		 
		 text = "1";
		 research = new EMTResearchItem("Drill of the Rockbreaker", "EMT", ResearchAspects.rockbreakerDrillResearch, 0, -4, 6, new ItemStack(ElectricMagicTools.rockbreakerDrill)).setParents("Thaumium Drill").setConcealed().setComplexity(6).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.rockbreakerDrill));
		 
		 text = "1";
		 research = new EMTResearchItem("Shield Block", "EMT", ResearchAspects.shieldBlockResearch, 4, 5, -2, new ItemStack(ElectricMagicTools.shield)).setParents("Shield Focus").setConcealed().setComplexity(2).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.shieldBlock));
		 
		 text = "1";
		 research = new EMTResearchItem("Tiny Uranium", "EMT", ResearchAspects.tinyUraniumResearch, -5, -5, 5, Items.getItem("Uran238")).setParentsHidden("Electric Magic Tools").setConcealed().setComplexity(1).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.tinyUranium));
		 
		 text = "1";
		 research = new EMTResearchItem("Mjolnir", "EMT", ResearchAspects.thorHammerResearch, -5, 5, 5, new ItemStack(ElectricMagicTools.thorHammer)).setParentsHidden("Electric Magic Tools").setConcealed().setComplexity(5).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.thorHammer));
		 
		 text = "1";
		 research = new EMTResearchItem("Supercharged Mjolnir", "EMT", ResearchAspects.superchargedThorHammerResearch, -6, 6, 5, new ItemStack(ElectricMagicTools.electricThorHammer)).setParents("Mjolnir").setLost().setComplexity(7).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.superchargedThorHammer));
		 
		 text = "1";
		 research = new EMTResearchItem("Industrial Wand Charging Station", "EMT", ResearchAspects.wandCharger, -4, 2, -3, new ItemStack(ElectricMagicTools.industrialRecharger)).setParents("Potentia Generator").setConcealed().setComplexity(7).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.wandRecharger));
		 
		 text = "1";
		 research = new EMTResearchItem("Compressed Solars", "EMT", ResearchAspects.compressedSolars, -4, -5, 2, new ItemStack(ElectricMagicTools.compressedSolar)).setParentsHidden("Potentia Generator").setConcealed().setComplexity(4).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.compressedSolar), new ResearchPage(EMTRecipes.doubleCompressedSolar));
		 
		 text = "1";
		 research = new EMTResearchItem("Solar Helmet of Revealing", "EMT", ResearchAspects.solarHelmetRevealing, -3, -6, 2, new ItemStack(ElectricMagicTools.solarHelmetRevealing)).setParents("Compressed Solars").setConcealed().setComplexity(6).registerResearchItem();
		 research.setPages(new ResearchPage(text), new ResearchPage(EMTRecipes.solarHelmetRevealing));
	 }
}