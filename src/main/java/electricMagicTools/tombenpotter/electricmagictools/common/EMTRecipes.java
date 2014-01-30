package electricMagicTools.tombenpotter.electricmagictools.common;

import ic2.api.item.Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import cpw.mods.fml.common.registry.GameRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.lib.CraftingAspects;

public class EMTRecipes {

	public static void postInitRecipes() {

		// Infusion Recipes

		thaumiumDrill = ThaumcraftApi.addInfusionCraftingRecipe(
				"Thaumium Drill",
				new ItemStack(ElectricMagicTools.thaumiumDrill),
				5,
				CraftingAspects.thaumiumDrillCrafting,
				new ItemStack(Items.getItem("diamondDrill").getItem(), 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] { new ItemStack(Item.diamond),
						new ItemStack(Item.diamond),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						Items.getItem("denseplateiron") });

		thaumiumChainsaw = ThaumcraftApi.addInfusionCraftingRecipe(
				"Thaumium Chainsaw",
				new ItemStack(ElectricMagicTools.thaumiumChainsaw),
				5,
				CraftingAspects.thaumiumChainsawCrafting,
				new ItemStack(ElectricMagicTools.diamondChainsaw, 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] { new ItemStack(Item.diamond),
						new ItemStack(Item.diamond),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						Items.getItem("denseplateiron") });

		thaumicQuantumHelmet = ThaumcraftApi.addInfusionCraftingRecipe(
				"Quantum Goggles of Revealing",
				new ItemStack(ElectricMagicTools.quantumThaumicHelmet),
				6,
				CraftingAspects.thaumicQuantumHelmetCrafting,
				new ItemStack(Items.getItem("quantumHelmet").getItem(), 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] { new ItemStack(Item.diamond),
						new ItemStack(Item.bucketMilk),
						new ItemStack(ConfigItems.itemGoggles, 1),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						Items.getItem("iridiumPlate"),
						Items.getItem("advancedCircuit") });

		thaumicNanoHelmet = ThaumcraftApi.addInfusionCraftingRecipe(
				"Nanosuit Goggles of Revealing",
				new ItemStack(ElectricMagicTools.nanoThaumicHelmet),
				5,
				CraftingAspects.thaumicNanoHelmetCrafting,
				new ItemStack(Items.getItem("nanoHelmet").getItem(), 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] { new ItemStack(Item.diamond),
						new ItemStack(Item.ingotGold),
						new ItemStack(ConfigItems.itemGoggles, 1),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						Items.getItem("carbonPlate"),
						Items.getItem("electronicCircuit") });

		thaumiumOmnitool = ThaumcraftApi.addInfusionCraftingRecipe(
				"Thaumium Omnitool",
				new ItemStack(ElectricMagicTools.thaumiumOmnitool),
				6,
				CraftingAspects.thaumiumOmnitoolCrafting,
				new ItemStack(ElectricMagicTools.thaumiumChainsaw, 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] {
						new ItemStack(ElectricMagicTools.thaumiumDrill, 1,
								OreDictionary.WILDCARD_VALUE),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						new ItemStack(ElectricMagicTools.thaumiumPlate),
						Items.getItem("carbonPlate"),
						Items.getItem("plateobsidian") });

		explosionFocus = ThaumcraftApi.addInfusionCraftingRecipe(
				"Explosion Focus", new ItemStack(
						ElectricMagicTools.explosionFocus), 6,
				CraftingAspects.laserFocusCrafting, new ItemStack(
						ConfigItems.itemFocusHellbat, 1), new ItemStack[] {
						new ItemStack(Items.getItem("miningLaser").getItem(),
								1, OreDictionary.WILDCARD_VALUE),
						new ItemStack(Item.arrow),
						new ItemStack(Item.gunpowder),
						new ItemStack(Item.fireworkCharge),
						new ItemStack(ConfigItems.itemResource, 1, 1),
						new ItemStack(ConfigItems.itemWispEssence, 1) });

		shieldFocus = ThaumcraftApi.addInfusionCraftingRecipe(
				"Shield Focus",
				new ItemStack(ElectricMagicTools.shieldFocus),
				4,
				CraftingAspects.shieldFocusCrafting,
				new ItemStack(ConfigItems.itemFocusPortableHole, 1),
				new ItemStack[] { Items.getItem("reinforcedStone"),
						Items.getItem("reinforcedGlass"),
						Items.getItem("reinforcedStone"),
						Items.getItem("reinforcedGlass"),
						new ItemStack(Block.slowSand),
						new ItemStack(Block.obsidian),
						new ItemStack(Block.obsidian) });

		potentiaGenerator = ThaumcraftApi.addInfusionCraftingRecipe(
				"Potentia Generator",
				new ItemStack(ElectricMagicTools.potentiaGenerator),
				6,
				CraftingAspects.potentiaGeneratorCrafting,
				Items.getItem("semifluidGenerator"),
				new ItemStack[] { new ItemStack(Item.diamond),
						new ItemStack(ConfigItems.itemFocusTrade),
						new ItemStack(Block.hopperBlock),
						new ItemStack(ConfigBlocks.blockJar),
						Items.getItem("mvTransformer"),
						Items.getItem("advancedMachine"),
						Items.getItem("orewashingplant"),
						Items.getItem("scrap") });

		streamChainsaw = ThaumcraftApi.addInfusionCraftingRecipe(
				"Chainsaw of the Stream",
				new ItemStack(ElectricMagicTools.streamChainsaw),
				6,
				CraftingAspects.streamChaisnawCrafting,
				new ItemStack(ElectricMagicTools.thaumiumChainsaw, 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] {
						new ItemStack(Item.bucketWater),
						new ItemStack(ConfigItems.itemAxeElemental),
						new ItemStack(ConfigBlocks.blockMagicalLog),
						new ItemStack(Items.getItem("lapotronCrystal")
								.getItem(), 1, OreDictionary.WILDCARD_VALUE),
						Items.getItem("compressedPlantBall"),
						Items.getItem("iridiumPlate"),
						Items.getItem("overclockerUpgrade") });

		rockbreakerDrill = ThaumcraftApi.addInfusionCraftingRecipe(
				"Drill of the Rockbreaker",
				new ItemStack(ElectricMagicTools.rockbreakerDrill),
				6,
				CraftingAspects.rockbreakerDrillCrafting,
				new ItemStack(ElectricMagicTools.thaumiumDrill, 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] {
						new ItemStack(Item.flintAndSteel),
						new ItemStack(Item.fireballCharge),
						new ItemStack(ConfigItems.itemPickElemental),
						new ItemStack(ConfigItems.itemShovelElemental),
						new ItemStack(Items.getItem("lapotronCrystal")
								.getItem(), 1, OreDictionary.WILDCARD_VALUE),
						Items.getItem("reinforcedStone"),
						Items.getItem("iridiumPlate"),
						Items.getItem("overclockerUpgrade") });

		thorHammer = ThaumcraftApi.addInfusionCraftingRecipe(
				"Mjolnir",
				new ItemStack(ElectricMagicTools.thorHammer),
				7,
				CraftingAspects.thorHammerCrafting,
				new ItemStack(ElectricMagicTools.taintedThorHammer, 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] {
						new ItemStack(ElectricMagicTools.lightningSummoner),
						new ItemStack(ElectricMagicTools.lightningSummoner),
						new ItemStack(ConfigItems.itemSwordElemental),
						new ItemStack(ConfigItems.itemResource, 1, 1),
						new ItemStack(ConfigItems.itemFocusShock),
						Items.getItem("rubber") });

		superchargedThorHammer = ThaumcraftApi.addInfusionCraftingRecipe(
				"Supercharged Mjolnir",
				new ItemStack(ElectricMagicTools.electricThorHammer),
				10,
				CraftingAspects.superchargedThorHammerCrafting,
				new ItemStack(ElectricMagicTools.thorHammer, 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] {
						new ItemStack(ElectricMagicTools.lightningSummoner),
						new ItemStack(ElectricMagicTools.lightningSummoner),
						new ItemStack(Block.web),
						new ItemStack(ConfigItems.itemFocusHellbat),
						new ItemStack(ConfigItems.itemSwordElemental),
						new ItemStack(Items.getItem("lapotronCrystal")
								.getItem(), 1, OreDictionary.WILDCARD_VALUE),
						Items.getItem("iridiumPlate"),
						Items.getItem("iridiumPlate"),
						new ItemStack(Items.getItem("nanoSaber").getItem(), 1,
								OreDictionary.WILDCARD_VALUE) });

		wandRecharger = ThaumcraftApi.addInfusionCraftingRecipe(
				"Industrial Wand Charging Station",
				new ItemStack(ElectricMagicTools.industrialRecharger),
				10,
				CraftingAspects.wandCharger,
				new ItemStack(ConfigBlocks.blockStoneDevice, 1, 5),
				new ItemStack[] { Items.getItem("replicator"),
						Items.getItem("tradeOMat"),
						Items.getItem("iridiumPlate"),
						new ItemStack(Block.blockDiamond),
						new ItemStack(ConfigItems.itemShard, 1, 5),
						new ItemStack(ConfigBlocks.blockJar) });

		solarHelmetRevealing = ThaumcraftApi
				.addInfusionCraftingRecipe(
						"Solar Helmet of Revealing",
						new ItemStack(ElectricMagicTools.solarHelmetRevealing),
						5,
						CraftingAspects.solarHelmetRevealing,
						new ItemStack(ElectricMagicTools.quantumThaumicHelmet),
						new ItemStack[] {
								new ItemStack(
										ElectricMagicTools.doubleCompressedSolar),
								Items.getItem("glassFiberCableItem"),
								new ItemStack(Items.getItem("lapotronCrystal")
										.getItem(), 1,
										OreDictionary.WILDCARD_VALUE),
								new ItemStack(ConfigItems.itemShard, 1, 4) });

		electricBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe(
				"Electric Boots of the Traveller", new ItemStack(
						ElectricMagicTools.electricBootsTraveller), 2,
				CraftingAspects.electricBootsTravel, new ItemStack(
						ConfigItems.itemBootsTraveller), new ItemStack[] {
						new ItemStack(Item.diamond),
						Items.getItem("elemotor"),
						Items.getItem("coil"),
						Items.getItem("hazmatBoots"),
						new ItemStack(Items.getItem("advBattery").getItem(), 1,
								OreDictionary.WILDCARD_VALUE),
						new ItemStack(ConfigItems.itemWispEssence) });

		nanoBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe(
				"Nano Boots of the Traveller", new ItemStack(
						ElectricMagicTools.nanoBootsTraveller), 2,
				CraftingAspects.nanoBootsTravel, new ItemStack(
						ElectricMagicTools.electricBootsTraveller, 1,
						OreDictionary.WILDCARD_VALUE), new ItemStack[] {
						new ItemStack(Item.diamond),
						Items.getItem("nanoBoots"),
						new ItemStack(Items.getItem("energyCrystal").getItem(),
								1, OreDictionary.WILDCARD_VALUE),
						new ItemStack(ConfigItems.itemWispEssence),
						new ItemStack(ConfigItems.itemWispEssence) });

		quantumBootsTravel = ThaumcraftApi.addInfusionCraftingRecipe(
				"Quantum Boots of the Traveller",
				new ItemStack(ElectricMagicTools.quantumBootsTraveller),
				2,
				CraftingAspects.quantumBootsTravel,
				new ItemStack(ElectricMagicTools.nanoBootsTraveller, 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] {
						new ItemStack(Block.blockDiamond),
						Items.getItem("quantumBoots"),
						new ItemStack(Items.getItem("lapotronCrystal")
								.getItem(), 1, OreDictionary.WILDCARD_VALUE),
						Items.getItem("iridiumPlate"),
						new ItemStack(ConfigItems.itemWispEssence),
						new ItemStack(ConfigItems.itemWispEssence),
						new ItemStack(ConfigItems.itemWispEssence) });

		// Arcane Worktable Recipes

		diamondOmnitool = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
				"Diamond Omnitool", new ItemStack(
						ElectricMagicTools.diamondOmnitool),
				CraftingAspects.diamondOmnitoolCrafting, new ItemStack(
						ElectricMagicTools.diamondChainsaw, 1,
						OreDictionary.WILDCARD_VALUE), new ItemStack(Items
						.getItem("diamondDrill").getItem(), 1,
						OreDictionary.WILDCARD_VALUE));

		christmasFocus = ThaumcraftApi.addArcaneCraftingRecipe(
				"Kris-tmas Focus", new ItemStack(
						ElectricMagicTools.christmasFocus),
				CraftingAspects.christmasFocusCrafting, "XYX", "YZY", "XYX",
				'X', new ItemStack(Block.blockSnow), 'Y', new ItemStack(
						Block.pumpkin), 'Z', new ItemStack(
						ConfigItems.itemFocusFrost));

		electricGoggles = ThaumcraftApi.addArcaneCraftingRecipe(
				"Electric Goggles", new ItemStack(
						ElectricMagicTools.electricGoggles),
				CraftingAspects.electricGogglesCrafting, " Y ", "AZA", "BXB",
				'Z', new ItemStack(ConfigItems.itemGoggles), 'X', Items
						.getItem("electronicCircuit"), 'Y', new ItemStack(
						Item.helmetDiamond), 'A',
				new ItemStack(Items.getItem("chargedReBattery").getItem(), 1,
						OreDictionary.WILDCARD_VALUE), 'B',
				Item.redstoneRepeater);

		shieldBlock = ThaumcraftApi.addArcaneCraftingRecipe("Shield Block",
				new ItemStack(ElectricMagicTools.shield, 8),
				CraftingAspects.shieldBlockCrafting, "XYX", "X X", "XYX", 'X',
				new ItemStack(Block.glass), 'Y', new ItemStack(Block.obsidian));

		tinyUranium = ThaumcraftApi.addShapelessArcaneCraftingRecipe(
				"Tiny Uranium", new ItemStack(Items.getItem("smallUran235")
						.getItem(), 7), CraftingAspects.tinyUraniumCrafting,
				Items.getItem("Uran238"));

		compressedSolar = ThaumcraftApi.addArcaneCraftingRecipe(
				"Compressed Solars", new ItemStack(
						ElectricMagicTools.compressedSolar),
				CraftingAspects.compressedSolars, "XXX", "XXX", "XXX", 'X',
				Items.getItem("solarPanel"));

		doubleCompressedSolar = ThaumcraftApi.addArcaneCraftingRecipe(
				"Compressed Solars", new ItemStack(
						ElectricMagicTools.doubleCompressedSolar),
				CraftingAspects.compressedSolars, "XXX", "XXX", "XXX", 'X',
				new ItemStack(ElectricMagicTools.compressedSolar));

		// Crucible Recipes

		ignisGenerator = ThaumcraftApi.addCrucibleRecipe("Ignis Generator",
				new ItemStack(ElectricMagicTools.ignisGenerator),
				new ItemStack(ElectricMagicTools.potentiaGenerator),
				CraftingAspects.ignisGeneratorCrafting);

		auramGenerator = ThaumcraftApi.addCrucibleRecipe("Auram Generator",
				new ItemStack(ElectricMagicTools.auramGenerator),
				new ItemStack(ElectricMagicTools.potentiaGenerator),
				CraftingAspects.auramGeneratorCrafting);

		arborGenerator = ThaumcraftApi.addCrucibleRecipe("Arbor Generator",
				new ItemStack(ElectricMagicTools.arborGenerator),
				new ItemStack(ElectricMagicTools.potentiaGenerator),
				CraftingAspects.arborGeneratorCrafting);

		// IC2 Stuff related recipes

		// Ore Clusters Macerator Recipes
		ItemStack ironClusterRecipe = Items.getItem("smallIronDust").copy();
		ironClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(
				ConfigItems.itemNugget, 1, 16)), null, ironClusterRecipe);

		ItemStack goldClusterRecipe = Items.getItem("smallGoldDust").copy();
		goldClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(
				ConfigItems.itemNugget, 1, 31)), null, goldClusterRecipe);

		ItemStack copperClusterRecipe = Items.getItem("smallCopperDust").copy();
		copperClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(
				ConfigItems.itemNugget, 1, 17)), null, copperClusterRecipe);

		ItemStack tinClusterRecipe = Items.getItem("smallTinDust").copy();
		tinClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(
				ConfigItems.itemNugget, 1, 18)), null, tinClusterRecipe);

		ItemStack silverClusterRecipe = Items.getItem("smallSilverDust").copy();
		silverClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(
				ConfigItems.itemNugget, 1, 19)), null, silverClusterRecipe);

		ItemStack leadClusterRecipe = Items.getItem("smallLeadDust").copy();
		leadClusterRecipe.stackSize = 22;
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(
				ConfigItems.itemNugget, 1, 20)), null, leadClusterRecipe);

		// Thaumium Plates Recipes
		thaumiumPlate = GameRegistry.addShapedRecipe(new ItemStack(
				ElectricMagicTools.thaumiumPlate), "X", "Y", "Z", 'Y',
				new ItemStack(ConfigItems.itemResource, 1, 2), 'X',
				new ItemStack(Items.getItem("ForgeHammer").getItem(), 1,
						OreDictionary.WILDCARD_VALUE), 'Z', new ItemStack(
						Block.obsidian));

		Recipes.metalformerRolling.addRecipe(new RecipeInputItemStack(
				new ItemStack(ConfigItems.itemResource, 1, 2)), null,
				new ItemStack(ElectricMagicTools.thaumiumPlate));

	}

	public static void initRecipes() {

		// Crafting Recipes

		ironOmnitool = GameRegistry.addShapedRecipe(new ItemStack(
				ElectricMagicTools.ironOmnitool), "X", "Z", "Y", 'X',
				new ItemStack(Items.getItem("chainsaw").getItem(), 1,
						OreDictionary.WILDCARD_VALUE), 'Y', new ItemStack(Items
						.getItem("miningDrill").getItem(), 1,
						OreDictionary.WILDCARD_VALUE), 'Z', Items
						.getItem("plateiron"));

		diamondChainsaw = GameRegistry.addShapedRecipe(new ItemStack(
				ElectricMagicTools.diamondChainsaw), " X ", "XYX", 'X',
				new ItemStack(Item.diamond), 'Y',
				new ItemStack(Items.getItem("chainsaw").getItem(), 1,
						OreDictionary.WILDCARD_VALUE));
	}

	public static InfusionRecipe thaumiumDrill;
	public static InfusionRecipe thaumiumChainsaw;
	public static InfusionRecipe thaumicQuantumHelmet;
	public static InfusionRecipe thaumiumOmnitool;
	public static InfusionRecipe thaumicNanoHelmet;
	public static InfusionRecipe explosionFocus;
	public static InfusionRecipe shieldFocus;
	public static InfusionRecipe potentiaGenerator;
	public static InfusionRecipe streamChainsaw;
	public static InfusionRecipe rockbreakerDrill;
	public static InfusionRecipe thorHammer;
	public static InfusionRecipe superchargedThorHammer;
	public static InfusionRecipe wandRecharger;
	public static InfusionRecipe solarHelmetRevealing;
	public static InfusionRecipe electricBootsTravel;
	public static InfusionRecipe nanoBootsTravel;
	public static InfusionRecipe quantumBootsTravel;

	public static ShapelessArcaneRecipe diamondOmnitool;
	public static ShapelessArcaneRecipe tinyUranium;
	public static ShapedArcaneRecipe christmasFocus;
	public static ShapedArcaneRecipe electricGoggles;
	public static ShapedArcaneRecipe shieldBlock;
	public static ShapedArcaneRecipe compressedSolar;
	public static ShapedArcaneRecipe doubleCompressedSolar;

	public static CrucibleRecipe ignisGenerator;
	public static CrucibleRecipe auramGenerator;
	public static CrucibleRecipe arborGenerator;

	public static IRecipe ironOmnitool;
	public static IRecipe diamondChainsaw;
	public static IRecipe thaumiumPlate;
}