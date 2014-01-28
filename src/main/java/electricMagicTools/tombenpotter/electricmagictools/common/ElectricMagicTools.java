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
import net.minecraftforge.common.Configuration;
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

	public static Block potentiaGenerator;
	public static Block shield;
	public static Block ignisGenerator;
	public static Block auramGenerator;
	public static Block arborGenerator;
	public static Block industrialRecharger;
	public static Block compressedSolar;
	public static Block doubleCompressedSolar;

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
	public static int thaumiumPlateID;
	public static int arborGeneratorID;
	public static int solarHelmetRevealingID;
	public static int industrialRechargerID;
	public static int thorHammerID;
	public static int taintedThorHammerID;
	public static int lightningSummonerID;
	public static int compressedSolarID;
	public static int electricThorHammerID;
	public static int doubleCompressedSolarID;
	public static int electricBootsTravellerID;
	public static int quantumBootsTravellerID;
	public static int nanoBootsTravellerID;

	// Entity Stuff
	private static int startEID = 300;
	private static int entityIDs = 0;
	private static final Class<? extends EntityLiving> ARCHER_CLASS = EntityArcher.class;

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
		thaumiumPlateID = config.getItem("Thauium Plate", 4014).getInt();
		solarHelmetRevealingID = config.getItem("Solar Helmet of Revealing",
				4015).getInt();
		thorHammerID = config.getItem("Mjolnir", 4016).getInt();
		taintedThorHammerID = config.getItem("Broken Relic of Mjolnir", 4017)
				.getInt();
		lightningSummonerID = config.getItem("Lightning Summoner", 4018)
				.getInt();
		electricThorHammerID = config.getItem("Supercharged Mjolnir", 4020)
				.getInt();
		electricBootsTravellerID = config.getItem(
				"Electric Boots of the Traveller", 4021).getInt();
		nanoBootsTravellerID = config.getItem("Nano Boots of the Traveller",
				4022).getInt();
		quantumBootsTravellerID = config.getItem(
				"Quantum Boots of the Traveller", 4023).getInt();

		// Block IDs
		potentiaGeneratorID = config.getBlock("Potentia Generator", 1500)
				.getInt();
		shieldID = config.getBlock("Shield", 1501).getInt();
		ignisGeneratorID = config.getBlock("Ignis Generator", 1502).getInt();
		auramGeneratorID = config.getBlock("Auram Generator", 1503).getInt();
		arborGeneratorID = config.getBlock("Arbor Generator", 1504).getInt();
		industrialRechargerID = config.getBlock(
				"Industrial Wand Charging Station", 1505).getInt();
		compressedSolarID = config.getBlock("Compressed Solar Panel", 1505)
				.getInt();
		doubleCompressedSolarID = config.getBlock(
				"Double Compressed Solar Panel", 1506).getInt();

		config.save();

	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.load();
		MinecraftForge.EVENT_BUS.register(new EntityLivingHandler());
		CreativeTab.load();

		// Items Registry
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
		thaumiumPlate = new ItemThaumiumPlate(thaumiumPlateID)
				.setUnlocalizedName("thaumiumplate");
		solarHelmetRevealing = new ItemSolarHelmetRevealing(
				solarHelmetRevealingID, 3, 0)
				.setUnlocalizedName("solarhelmetrevealing");
		thorHammer = new ItemThorHammer(thorHammerID)
				.setUnlocalizedName("hammerthor");
		taintedThorHammer = new ItemTaintedThorHammer(taintedThorHammerID)
				.setUnlocalizedName("taintedthorhammer");
		lightningSummoner = new ItemLightningSummoner(lightningSummonerID)
				.setUnlocalizedName("lightningsummoner");
		electricThorHammer = new ItemElectricThorHammer(electricThorHammerID)
				.setUnlocalizedName("electricthorhammer");
		electricBootsTraveller = new ItemElectricBootsTraveller(
				electricBootsTravellerID, 3, 3)
				.setUnlocalizedName("electricboots");
		nanoBootsTraveller = new ItemNanoBootsTraveller(nanoBootsTravellerID,
				3, 3).setUnlocalizedName("nanobootstraveller");
		quantumBootsTraveller = new ItemQuantumBootsTraveller(
				quantumBootsTravellerID, 3, 3)
				.setUnlocalizedName("quantumbootstraveller");

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

		// Blocks registry
		potentiaGenerator = new BlockPotentiaGenerator(potentiaGeneratorID,
				Material.iron).setUnlocalizedName("potentiagenerator");
		shield = new BlockShield(shieldID).setUnlocalizedName("shield");
		ignisGenerator = new BlockIgnisGenerator(ignisGeneratorID,
				Material.iron).setUnlocalizedName("ignisgenerator");
		auramGenerator = new BlockAuramGenerator(auramGeneratorID,
				Material.iron).setUnlocalizedName("auramgenerator");
		arborGenerator = new BlockArborGenerator(arborGeneratorID,
				Material.iron).setUnlocalizedName("arborgenerator");
		industrialRecharger = new BlockIndustrialWandRecharge(
				industrialRechargerID, Material.iron)
				.setUnlocalizedName("industrialwandrecharger");
		compressedSolar = new BlockCompressedSolar(compressedSolarID)
				.setUnlocalizedName("compressedsolar");
		doubleCompressedSolar = new BlockDoubleCompressedSolar(
				doubleCompressedSolarID)
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
		 if (event.getSide() == Side.CLIENT)
         {
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
