package electricMagicTools.tombenpotter.electricmagictools.common.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import electricMagicTools.tombenpotter.electricmagictools.common.Config;

public class ItemBlockCompressedSolar extends ItemBlock {

	public ItemBlockCompressedSolar(int id) {
		super(id);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player,
			List list, boolean par4) {
		list.add(Config.compressedSolarOutput + " EU/T");
	}
}
