package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import electricMagicTools.tombenpotter.electricmagictools.client.CapeEventHandler;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockArborGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockAuramGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockDoubleCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockIgnisGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockIndustrialWandRecharge;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockPotentiaGenerator;
import electricMagicTools.tombenpotter.electricmagictools.common.blocks.BlockShield;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.EntityArcher;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.EntityLaser;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemBlockCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemBlockDoubleCompressedSolar;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemElectricScribingTools;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemLightningSummoner;
import electricMagicTools.tombenpotter.electricmagictools.common.items.ItemThaumiumPlate;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemElectricBootsTraveller;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemElectricGoggles;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemNanoBootsTraveller;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemNanoThaumicHelmet;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemQuantumBootsTraveller;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemQuantumThaumicHelmet;
import electricMagicTools.tombenpotter.electricmagictools.common.items.armor.ItemSolarHelmetRevealing;
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
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.hammer.ItemElectricThorHammer;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.hammer.ItemTaintedThorHammer;
import electricMagicTools.tombenpotter.electricmagictools.common.items.tools.hammer.ItemThorHammer;

@Mod(modid = ElectricMagicTools.modid, name = "Electric Magic Tools", version = "1.0.6", dependencies = "required-after:Thaumcraft ; required-after:IC2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { ElectricMagicTools.modid })
public class ElectricMagicTools {

	@SidedProxy(clientSide = "electricMagicTools.tombenpotter.electricmagictools.client.ClientProxy", serverSide = "electricMagicTools.tombenpotter.electricmagictools.common.CommonProxy")
	public static CommonProxy proxy;
	@Instance(ElectricMagicTools.modid)
	public static ElectricMagicTools instance;

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
	public static Item thaumiumPlate;
	public static Item solarHelmetRevealing;
	public static Item thorHammer;
	public static Item taintedThorHammer;
	public static Item electricThorHammer;
	public static Item lightningSummoner;
	public static Item electricBootsTraveller;
	public static Item quantumBootsTraveller;
	public static Item nanoBootsTraveller;
	public static Item electricScribingTools;

	public static Block potentiaGenerator;
	public static Block shield;
	public static Block ignisGenerator;
	public static Block auramGenerator;
	public static Block arborGenerator;
	public static Block industrialRecharger;
	public static Block compressedSolar;
	public static Block doubleCompressedSolar;

	// Entity Stuff
	private static int startEID = 300;
	private static int entityIDs = 0;
	private static final Class<? extends EntityLiving> ARCHER_CLASS = EntityArcher.class;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.create(event);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.load();
		MinecraftForge.EVENT_BUS.register(new EntityLivingHandler());
		CreativeTab.load();

		// Items Registry
		thaumiumDrill = new ItemThaumiumDrill(Config.thaumiumDrillID)
				.setUnlocalizedName("thaumiumdrill");
		thaumiumChainsaw = new ItemThaumiumChainsaw(Config.thaumiumChainsawID)
				.setUnlocalizedName("thaumiumchainsaw");
		quantumThaumicHelmet = new ItemQuantumThaumicHelmet(
				Config.quantumThaumicHelmetID, 3, 0)
				.setUnlocalizedName("quantumthaumichelmet");
		diamondChainsaw = new ItemDiamondChainsaw(Config.diamondChainsawID)
				.setUnlocalizedName("diamondchainsaw");
		ironOmnitool = new ItemOmnitoolIron(Config.ironOmnitoolID)
				.setUnlocalizedName("ironomnitool");
		diamondOmnitool = new ItemOmnitoolDiamond(Config.diamondOmnitoolID)
				.setUnlocalizedName("diamondomnitool");
		thaumiumOmnitool = new ItemOmnitoolThaumium(Config.thaumiumOmnitoolID)
				.setUnlocalizedName("thaumiumomnitool");
		nanoThaumicHelmet = new ItemNanoThaumicHelmet(
				Config.nanoThaumicHelmetID, 3, 0)
				.setUnlocalizedName("nanothaumichelmet");
		explosionFocus = new ItemExplosionFocus(Config.explosionFocusID)
				.setUnlocalizedName("laserfocus");
		christmasFocus = new ItemChristmasFocus(Config.christmasFocusID)
				.setUnlocalizedName("christmasfocus");
		shieldFocus = new ItemShieldFocus(Config.shieldFocusID)
				.setUnlocalizedName("shieldfocus");
		electricGoggles = new ItemElectricGoggles(Config.electricGogglesID, 3,
				0).setUnlocalizedName("electricgoggles");
		streamChainsaw = new ItemStreamChainsaw(Config.streamChainsawID)
				.setUnlocalizedName("streamchainsaw");
		rockbreakerDrill = new ItemRockbreakerDrill(Config.rockbreakerDrillID)
				.setUnlocalizedName("rockbreakerdrill");
		thaumiumPlate = new ItemThaumiumPlate(Config.thaumiumPlateID)
				.setUnlocalizedName("thaumiumplate");
		solarHelmetRevealing = new ItemSolarHelmetRevealing(
				Config.solarHelmetRevealingID, 3, 0)
				.setUnlocalizedName("solarhelmetrevealing");
		thorHammer = new ItemThorHammer(Config.thorHammerID)
				.setUnlocalizedName("hammerthor");
		taintedThorHammer = new ItemTaintedThorHammer(
				Config.taintedThorHammerID)
				.setUnlocalizedName("taintedthorhammer");
		lightningSummoner = new ItemLightningSummoner(
				Config.lightningSummonerID)
				.setUnlocalizedName("lightningsummoner");
		electricThorHammer = new ItemElectricThorHammer(
				Config.electricThorHammerID)
				.setUnlocalizedName("electricthorhammer");
		electricBootsTraveller = new ItemElectricBootsTraveller(
				Config.electricBootsTravellerID, 3, 3)
				.setUnlocalizedName("electricboots");
		nanoBootsTraveller = new ItemNanoBootsTraveller(
				Config.nanoBootsTravellerID, 3, 3)
				.setUnlocalizedName("nanobootstraveller");
		quantumBootsTraveller = new ItemQuantumBootsTraveller(
				Config.quantumBootsTravellerID, 3, 3)
				.setUnlocalizedName("quantumbootstraveller");
		electricScribingTools = new ItemElectricScribingTools(
				Config.electricScribingToolsID)
				.setUnlocalizedName("electricscribingtools");

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
		LanguageRegistry.addName(thaumiumPlate, "Thaumium Plate");
		LanguageRegistry.addName(solarHelmetRevealing,
				"Quantum Solar Helmet of Revealing");
		LanguageRegistry.addName(thorHammer, "Mjolnir");
		LanguageRegistry.addName(taintedThorHammer, "Broken Relic of Mjolnir");
		LanguageRegistry.addName(lightningSummoner, "Lightning Summoner");
		LanguageRegistry.addName(electricThorHammer, "Supercharged Mjolnir");
		LanguageRegistry.addName(electricBootsTraveller,
				"Electric Boots of the Traveller");
		LanguageRegistry.addName(nanoBootsTraveller,
				"Nano Boots of the Traveller");
		LanguageRegistry.addName(quantumBootsTraveller,
				"Quantum Boots of the Traveller");
		LanguageRegistry.addName(electricScribingTools,
				"Electric Scribing Tools");

		// Blocks registry
		potentiaGenerator = new BlockPotentiaGenerator(
				Config.potentiaGeneratorID, Material.iron)
				.setUnlocalizedName("potentiagenerator");
		shield = new BlockShield(Config.shieldID).setUnlocalizedName("shield");
		ignisGenerator = new BlockIgnisGenerator(Config.ignisGeneratorID,
				Material.iron).setUnlocalizedName("ignisgenerator");
		auramGenerator = new BlockAuramGenerator(Config.auramGeneratorID,
				Material.iron).setUnlocalizedName("auramgenerator");
		arborGenerator = new BlockArborGenerator(Config.arborGeneratorID,
				Material.iron).setUnlocalizedName("arborgenerator");
		industrialRecharger = new BlockIndustrialWandRecharge(
				Config.industrialRechargerID, Material.iron)
				.setUnlocalizedName("industrialwandrecharger");
		compressedSolar = new BlockCompressedSolar(Config.compressedSolarID)
				.setUnlocalizedName("compressedsolar");
		doubleCompressedSolar = new BlockDoubleCompressedSolar(
				Config.doubleCompressedSolarID)
				.setUnlocalizedName("doublecompressedsolar");

		GameRegistry.registerBlock(potentiaGenerator, "Potentia Generator");
		GameRegistry.registerBlock(shield, "Shield Block");
		GameRegistry.registerBlock(ignisGenerator, "Ignis Generator");
		GameRegistry.registerBlock(auramGenerator, "Auram Generator");
		GameRegistry.registerBlock(arborGenerator, "Arbor Generator");
		GameRegistry.registerBlock(industrialRecharger,
				"Industrial Wand Charging Station");
		GameRegistry.registerBlock(compressedSolar,
				ItemBlockCompressedSolar.class, "Compressed Solar Panel");
		GameRegistry.registerBlock(doubleCompressedSolar,
				ItemBlockDoubleCompressedSolar.class,
				"Double Compressed Solar Panel");

		LanguageRegistry.addName(potentiaGenerator, "Potentia Generator");
		LanguageRegistry.addName(shield, "Shield Block");
		LanguageRegistry.addName(ignisGenerator, "Ignis Generator");
		LanguageRegistry.addName(auramGenerator, "Auram Generator");
		LanguageRegistry.addName(arborGenerator, "Arbor Generator");
		LanguageRegistry.addName(industrialRecharger,
				"Industrial Wand Charging Station");
		LanguageRegistry.addName(compressedSolar, "Compressed Solar Panel");
		LanguageRegistry.addName(doubleCompressedSolar,
				"Double Compressed Solar Panel");

		// Generating in dungeon chests
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(
						ElectricMagicTools.taintedThorHammer), 1, 1, 5));

		// Tileentity registry
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
		GameRegistry
				.registerTileEntity(
						electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityArborGenerator.class,
						"tileentityarborgenerator");
		GameRegistry
				.registerTileEntity(
						electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge.class,
						"tileentityindustrialwandrecharge");
		GameRegistry
				.registerTileEntity(
						electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityCompressedSolar.class,
						"tileentitycompressedsolar");
		GameRegistry
				.registerTileEntity(
						electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityDoubleCompressedSolar.class,
						"tileentitydoublecompressedsolar");

		// Entity Registry
		EntityRegistry.registerModEntity(EntityLaser.class, "entityLaser",
				entityIDs++, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization(
				"entity.Tombenpotter's ElectricMagicTools.entityLaser.name",
				"Laser");
		EntityRegistry.registerModEntity(EntityArcher.class, "entityArcher",
				entityIDs++, this, 80, 3, true);
		LanguageRegistry.instance().addStringLocalization(
				"entity.Tombenpotter's ElectricMagicTools.entityArcher.name",
				"Guardian Snowman");

		registerEntityEgg(ARCHER_CLASS, 0x99111F, 0xE5685);

		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		EMTRecipes.initRecipes();

		if (event.getSide() == Side.CLIENT && Config.capesOn == true) {
			MinecraftForge.EVENT_BUS.register(new CapeEventHandler());
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		EMTRecipes.postInitRecipes();
		ThaumonomiconResearch.addResearchTab();
		ThaumonomiconResearch.addResearch();
	}

	private static int getUniqueEntityID() {

		do {
			startEID++;
		} while (EntityList.getStringFromID(startEID) != null);

		return startEID;
	}

	public static void registerEntityEgg(Class<? extends Entity> entity,
			int colPrim, int colSec) {
		int id = getUniqueEntityID();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, colPrim, colSec));
		return;
	}
}
