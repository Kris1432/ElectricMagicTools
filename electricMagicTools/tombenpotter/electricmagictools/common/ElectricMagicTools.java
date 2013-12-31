package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockAuramGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockIgnisGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockPotentiaGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockShield;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.EntityLaser;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemElectricGoggles;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemNanoThaumicHelmet;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemQuantumThaumicHelmet;
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemChristmasFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemExplosionFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemShieldFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemDiamondChainsaw;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolDiamond;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolIron;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolThaumium;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemRockbreakerDrill;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemStreamChainsaw;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemThaumiumChainsaw;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemThaumiumDrill;

@Mod(modid = ElectricMagicTools.modid, name = "Electric Magic Tools", version = "1.0.4", dependencies = "required-after:Thaumcraft ; required-after:IC2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class ElectricMagicTools {

	@SidedProxy(clientSide = "electricMagicTools.tombenpotter.electricmagictools.client.ClientProxy", serverSide = "electricMagicTools.tombenpotter.electricmagictools.common.CommonProxy")
	public static CommonProxy proxy;

	public static final String modid = "Tombenpotter's ElectricMagicTools";

	public static Item thaumiumDrill;
	public static Item thaumiumChainsaw;
	public static Item quantumThaumicHelmet;
	public static Item diamondChainsaw;
	public static Item ironOmnitool;
	public static Item diamondOmnitool;
	public static Item thaumiumOmnitool;
	public static Item nanoThaumicHelmet;
	public static Item explosionFocus;
	public static Item christmasFocus;
	public static Item shieldFocus;
	public static Item electricGoggles;
	public static Item streamChainsaw;
	public static Item rockbreakerDrill;

	public static Block potentiaGenerator;
	public static Block shield;
	public static Block ignisGenerator;
	public static Block auramGenerator;

	public static int thaumiumDrillID;
	public static int thaumiumChainsawID;
	public static int quantumThaumicHelmetID;
	public static int diamondChainsawID;
	public static int ironOmnitoolID;
	public static int diamondOmnitoolID;
	public static int thaumiumOmnitoolID;
	public static int nanoThaumicHelmetID;
	public static int explosionFocusID;
	public static int potentiaGeneratorID;
	public static int christmasFocusID;
	public static int shieldFocusID;
	public static int shieldID;
	public static int electricGogglesID;
	public static int ignisGeneratorID;
	public static int auramGeneratorID;
	public static int streamChainsawID;
	public static int rockbreakerDrillID;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());

		config.load();

		// Item IDs
		thaumiumDrillID = config.getItem("Thaumium Drill", 4000).getInt();
		thaumiumChainsawID = config.getItem("Thaumium Chainsaw", 4001).getInt();
		quantumThaumicHelmetID = config.getItem("Quantum Goggles of Revealing",
				4002).getInt();
		diamondChainsawID = config.getItem("Diamond Chainsaw", 4003).getInt();
		ironOmnitoolID = config.getItem("Iron Omnitool", 4004).getInt();
		diamondOmnitoolID = config.getItem("Diamond Omnitool", 4005).getInt();
		thaumiumOmnitoolID = config.getItem("Thaumium Omnitool", 4006).getInt();
		nanoThaumicHelmetID = config.getItem("Nanosuit Goggles of Revealing",
				4007).getInt();
		explosionFocusID = config.getItem("Explosion Focus", 4008).getInt();
		christmasFocusID = config.getItem("Kris-tmas Focus", 4009).getInt();
		shieldFocusID = config.getItem("Shield Focus", 4010).getInt();
		electricGogglesID = config.getItem("Electric Goggles of Revealing",
				4011).getInt();
		streamChainsawID = config.getItem("Chainsaw of the Stream", 4012)
				.getInt();
		rockbreakerDrillID = config.getItem("Drill of the Rockbreaker", 4013)
				.getInt();

		// Block IDs
		potentiaGeneratorID = config.getBlock("Potentia Generator", 1500)
				.getInt();
		shieldID = config.getBlock("Shield", 1501).getInt();
		ignisGeneratorID = config.getBlock("Ignis Generator", 1502).getInt();
		auramGeneratorID = config.getBlock("Auram Generator", 1503).getInt();

		config.save();

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.load();

		CreativeTab.load();
		thaumiumDrill = new ItemThaumiumDrill(thaumiumDrillID)
				.setUnlocalizedName("thaumiumdrill");
		thaumiumChainsaw = new ItemThaumiumChainsaw(thaumiumChainsawID)
				.setUnlocalizedName("thaumiumchainsaw");
		quantumThaumicHelmet = new ItemQuantumThaumicHelmet(
				quantumThaumicHelmetID, 3, 0)
				.setUnlocalizedName("quantumthaumichelmet");
		diamondChainsaw = new ItemDiamondChainsaw(diamondChainsawID)
				.setUnlocalizedName("diamondchainsaw");
		ironOmnitool = new ItemOmnitoolIron(ironOmnitoolID)
				.setUnlocalizedName("ironomnitool");
		diamondOmnitool = new ItemOmnitoolDiamond(diamondOmnitoolID)
				.setUnlocalizedName("diamondomnitool");
		thaumiumOmnitool = new ItemOmnitoolThaumium(thaumiumOmnitoolID)
				.setUnlocalizedName("thaumiumomnitool");
		nanoThaumicHelmet = new ItemNanoThaumicHelmet(nanoThaumicHelmetID, 3, 0)
				.setUnlocalizedName("nanothaumichelmet");
		explosionFocus = new ItemExplosionFocus(explosionFocusID)
				.setUnlocalizedName("laserfocus");
		christmasFocus = new ItemChristmasFocus(christmasFocusID)
				.setUnlocalizedName("christmasfocus");
		shieldFocus = new ItemShieldFocus(shieldFocusID)
				.setUnlocalizedName("shieldfocus");
		electricGoggles = new ItemElectricGoggles(electricGogglesID, 3, 0)
				.setUnlocalizedName("electricgoggles");
		streamChainsaw = new ItemStreamChainsaw(streamChainsawID)
				.setUnlocalizedName("streamchainsaw");
		rockbreakerDrill = new ItemRockbreakerDrill(rockbreakerDrillID)
				.setUnlocalizedName("rockbreakerdrill");

		LanguageRegistry.addName(thaumiumDrill, "Thaumium Drill");
		LanguageRegistry.addName(thaumiumChainsaw, "Thaumium Chainsaw");
		LanguageRegistry.addName(quantumThaumicHelmet,
				"Quantum Goggles of Revealing");
		LanguageRegistry.addName(diamondChainsaw, "Diamond Chainsaw");
		LanguageRegistry.addName(ironOmnitool, "Omnitool");
		LanguageRegistry.addName(diamondOmnitool, "Diamond Omnitool");
		LanguageRegistry.addName(thaumiumOmnitool, "Thaumium Omnitool");
		LanguageRegistry.addName(nanoThaumicHelmet,
				"Nanosuit Goggles of Revealing");
		LanguageRegistry.addName(explosionFocus, "Wand Focus: Explosion");
		LanguageRegistry.addName(christmasFocus, "Wand Focus : Kris-tmas");
		LanguageRegistry.addName(shieldFocus, "Wand Focus : Shield");
		LanguageRegistry.addName(electricGoggles,
				"Electric Goggles of Revealing");
		LanguageRegistry.addName(streamChainsaw, "Chainsaw of the Stream");
		LanguageRegistry.addName(rockbreakerDrill, "Drill of the Rockbreaker");

		potentiaGenerator = new BlockPotentiaGenerator(potentiaGeneratorID,
				Material.iron).setUnlocalizedName("potentiagenerator");
		shield = new BlockShield(shieldID).setUnlocalizedName("shield");
		ignisGenerator = new BlockIgnisGenerator(ignisGeneratorID,
				Material.iron).setUnlocalizedName("ignisgenerator");
		auramGenerator = new BlockAuramGenerator(auramGeneratorID,
				Material.iron).setUnlocalizedName("auramgenerator");

		GameRegistry.registerBlock(potentiaGenerator, "Potentia Generator");
		GameRegistry.registerBlock(shield, "Shield Block");
		GameRegistry.registerBlock(ignisGenerator, "Ignis Generator");
		GameRegistry.registerBlock(auramGenerator, "Auram Generator");

		GameRegistry
				.registerTileEntity(
						electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityPotentiaGenerator.class,
						"tileentityessentiagenerator");
		GameRegistry
				.registerTileEntity(
						electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIgnisGenerator.class,
						"tileentityignisgenerator");
		GameRegistry
				.registerTileEntity(
						electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityAuramGenerator.class,
						"tileentityauramgenerator");

		LanguageRegistry.addName(potentiaGenerator, "Potentia Generator");
		LanguageRegistry.addName(shield, "Shield Block");
		LanguageRegistry.addName(ignisGenerator, "Ignis Generator");
		LanguageRegistry.addName(auramGenerator, "Auram Generator");

		EMTRecipes.initRecipes();

		EntityRegistry.registerModEntity(EntityLaser.class, "entityLaser", 1,
				this, 80, 3, true);

		LanguageRegistry.instance().addStringLocalization(
				"entity.Tombenpotter_ElectricMagicTools.EntityLaser.name",
				"Laser");

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		EMTRecipes.postInitRecipes();
		ThaumonomiconResearch.addResearchTab();
		ThaumonomiconResearch.addResearch();
	}
}
