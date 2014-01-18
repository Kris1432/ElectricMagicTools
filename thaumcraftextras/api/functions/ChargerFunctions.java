package thaumcraftextras.api.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;

public class ChargerFunctions {

	public static Map<Item, Integer> isFuel = new HashMap<Item, Integer>();

	public static ArrayList<Item> isChargeAble = new ArrayList<Item>();

	
	public static void addChargeAble(Item item)
	{
		isChargeAble.add(item);
	}
	
	public static void removeChargeAble(Item item)
	{
		isChargeAble.remove(item);
	}

	public static void addFuel(Item item, int energy)
	{
		isFuel.put(item, energy);
	}
	
	public static void removeFuel(Item item)
	{
		isFuel.remove(item);
	}
}
