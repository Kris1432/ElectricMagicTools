package electricMagicTools.tombenpotter.electricmagictools.common;

import ic2.api.item.Items;
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
						new ItemStack(ConfigItems.itemResource, 1, 2),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						Items.getItem("denseplateiron") });

		thaumiumChainsaw = ThaumcraftApi.addInfusionCraftingRecipe(
				"Thaumium Chainsaw",
				new ItemStack(ElectricMagicTools.thaumiumChainsaw),
				5,
				CraftingAspects.thaumiumChainsawCrafting,
				new ItemStack(Items.getItem("chainsaw").getItem(), 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] { new ItemStack(Item.diamond),
						new ItemStack(Item.diamond),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						Items.getItem("denseplateiron") });

		thaumicQuantumHelmet = ThaumcraftApi.addInfusionCraftingRecipe(
				"Thaumic Quantum Helmet",
				new ItemStack(ElectricMagicTools.quantumThaumicHelmet),
				6,
				CraftingAspects.thaumicQuantumHelmetCrafting,
				new ItemStack(Items.getItem("quantumHelmet").getItem(), 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] { new ItemStack(Item.diamond),
						new ItemStack(Item.bucketMilk),
						new ItemStack(ConfigItems.itemGoggles, 1),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						Items.getItem("iridiumPlate"),
						Items.getItem("advancedCircuit") });

		thaumicNanoHelmet = ThaumcraftApi.addInfusionCraftingRecipe(
				"Thaumic Nanosuit Helmet",
				new ItemStack(ElectricMagicTools.nanoThaumicHelmet),
				5,
				CraftingAspects.thaumicNanoHelmetCrafting,
				new ItemStack(Items.getItem("nanoHelmet").getItem(), 1,
						OreDictionary.WILDCARD_VALUE),
				new ItemStack[] { new ItemStack(Item.diamond),
						new ItemStack(Item.ingotGold),
						new ItemStack(ConfigItems.itemGoggles, 1),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						new ItemStack(ConfigItems.itemResource, 1, 2),
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
						new ItemStack(ConfigItems.itemResource, 1, 2),
						new ItemStack(ConfigItems.itemResource, 1, 2),
						new ItemStack(ConfigItems.itemResource, 1, 2),
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

		// Crucible Recipes

		ignisGenerator = ThaumcraftApi.addCrucibleRecipe("Ignis Generator",
				new ItemStack(ElectricMagicTools.ignisGenerator),
				new ItemStack(ElectricMagicTools.potentiaGenerator),
				CraftingAspects.ignisGeneratorCrafting);

		auramGenerator = ThaumcraftApi.addCrucibleRecipe("Auram Generator",
				new ItemStack(ElectricMagicTools.auramGenerator),
				new ItemStack(ElectricMagicTools.potentiaGenerator),
				CraftingAspects.auramGeneratorCrafting);

	}

	public static void initRecipes() {

		// Crafting Recipes

		ironOmnitool = GameRegistry.addShapedRecipe(new ItemStack(
				ElectricMagicTools.ironOmnitool), "X", "Y", 'X', new ItemStack(
				Items.getItem("chainsaw").getItem(), 1,
				OreDictionary.WILDCARD_VALUE), 'Y', new ItemStack(Items
				.getItem("miningDrill").getItem(), 1,
				OreDictionary.WILDCARD_VALUE));

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
	public static ShapelessArcaneRecipe diamondOmnitool;
	public static ShapedArcaneRecipe christmasFocus;
	public static ShapedArcaneRecipe electricGoggles;
	public static ShapedArcaneRecipe shieldBlock;
	public static CrucibleRecipe ignisGenerator;
	public static CrucibleRecipe auramGenerator;
	public static IRecipe ironOmnitool;
	public static IRecipe diamondChainsaw;
}
