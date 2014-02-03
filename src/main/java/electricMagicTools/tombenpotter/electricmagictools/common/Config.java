package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

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
	public static int electricScribingToolsID;

	public static boolean capesOn;

	public static void create(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());

		config.load();

		// Random Booleans
		capesOn = config.get(Configuration.CATEGORY_GENERAL,
				"Enable showing capes", true).getBoolean(capesOn);

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
		electricScribingToolsID = config.getItem("Electric Scribing Tools",
				4024).getInt();

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
}