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
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;
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

		laserFocus = ThaumcraftApi.addInfusionCraftingRecipe("Laser Focus",
				new ItemStack(ElectricMagicTools.laserFocus), 6,
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

	public static void maceratorRecipes() {
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(
				ConfigItems.itemNugget, 16)), null, Items.getItem("smallIronDust"));
	}

	public static InfusionRecipe thaumiumDrill;
	public static InfusionRecipe thaumiumChainsaw;
	public static InfusionRecipe thaumicQuantumHelmet;
	public static InfusionRecipe thaumiumOmnitool;
	public static InfusionRecipe thaumicNanoHelmet;
	public static InfusionRecipe laserFocus;
	public static InfusionRecipe shieldFocus;
	public static ShapelessArcaneRecipe diamondOmnitool;
	public static ShapedArcaneRecipe christmasFocus;
	public static IRecipe ironOmnitool;
	public static IRecipe diamondChainsaw;
}
