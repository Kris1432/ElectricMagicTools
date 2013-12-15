package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockEssentiaGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.EntityLaser;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.RenderLaser;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemNanoThaumicHelmet;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemQuantumThaumicHelmet;
import electricMagicTools.tombenpotter.electricmagictools.common.items.foci.ItemLaserFocus;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemDiamondChainsaw;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolDiamond;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolIron;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemOmnitoolThaumium;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemThaumiumChainsaw;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.ItemThaumiumDrill;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityEssentiaGenerator;

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
	public static Item laserFocus;

	public static Block essentiaGenerator;

	public static int thaumiumDrillID;
	public static int thaumiumChainsawID;
	public static int quantumThaumicHelmetID;
	public static int diamondChainsawID;
	public static int ironOmnitoolID;
	public static int diamondOmnitoolID;
	public static int thaumiumOmnitoolID;
	public static int nanoThaumicHelmetID;
	public static int laserFocusID;
	public static int essentiaGeneratorID;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());

		config.load();

		// Item IDs
		thaumiumDrillID = config.getItem("Thaumium Drill", 4000).getInt();
		thaumiumChainsawID = config.getItem("Thaumium Chainsaw", 4001).getInt();
		quantumThaumicHelmetID = config.getItem("Quantum Thaumic Helmet", 4002)
				.getInt();
		diamondChainsawID = config.getItem("Diamond Chainsaw", 4003).getInt();
		ironOmnitoolID = config.getItem("Iron Omnitool", 4004).getInt();
		diamondOmnitoolID = config.getItem("Diamond Omnitool", 4005).getInt();
		thaumiumOmnitoolID = config.getItem("Thaumium Omnitool", 4006).getInt();
		nanoThaumicHelmetID = config.getItem("Nanosuit Thaumic Helmet", 4007)
				.getInt();
		laserFocusID = config.getItem("Laser Focus", 4008).getInt();

		// Block IDs
		essentiaGeneratorID = config.getBlock("Essentia Generator", 4000)
				.getInt();

		config.save();

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		/** Loading Proxy Load */
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
		laserFocus = new ItemLaserFocus(laserFocusID)
				.setUnlocalizedName("laserfocus");

		LanguageRegistry.addName(thaumiumDrill, "Thaumium Drill");
		LanguageRegistry.addName(thaumiumChainsaw, "Thaumium Chainsaw");
		LanguageRegistry
				.addName(quantumThaumicHelmet, "Quantum Thaumic Helmet");
		LanguageRegistry.addName(diamondChainsaw, "Diamond Chainsaw");
		LanguageRegistry.addName(ironOmnitool, "Omnitool");
		LanguageRegistry.addName(diamondOmnitool, "Diamond Omnitool");
		LanguageRegistry.addName(thaumiumOmnitool, "Thaumium Omnitool");
		LanguageRegistry.addName(nanoThaumicHelmet, "Nanosuit Thaumic Helmet");
		LanguageRegistry.addName(laserFocus, "WandFocus: Laser");
		EMTRecipes.initRecipes();

		EntityRegistry.registerModEntity(EntityLaser.class, "entityLaser", 1,
				this, 80, 3, true);
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class,
				new RenderLaser());
		LanguageRegistry.instance().addStringLocalization(
				"entity.Tombenpotter_ElectricMagicTools.EntityLaser.name",
				"Laser");

		essentiaGenerator = new BlockEssentiaGenerator(essentiaGeneratorID, Material.iron);
		GameRegistry.registerBlock(essentiaGenerator, "essentiagenerator");
		GameRegistry.registerTileEntity(TileEntityEssentiaGenerator.class, "tileentityessentiagenerator");
		LanguageRegistry.addName(essentiaGenerator, "Essentia Generator");
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		EMTRecipes.postInitRecipes();
		ThaumonomiconResearch.addResearchTab();
		ThaumonomiconResearch.addResearch();
	}
}
