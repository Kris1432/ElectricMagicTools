package thaumcraftextras.api.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ExampleChargeableCrystal extends Item{

	public ExampleChargeableCrystal(int id) {
		super(id);
		setMaxStackSize(1);
		setMaxDamage(50);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean id)
	{		
		list.add("Chargeable Crystal");
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs tabs, List list)
	{
		list.add(new ItemStack(id, 1, 50));      
	}
	
}