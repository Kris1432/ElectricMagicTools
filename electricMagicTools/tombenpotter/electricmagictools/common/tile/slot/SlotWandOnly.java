package electricMagicTools.tombenpotter.electricmagictools.common.tile.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import thaumcraft.common.items.wands.ItemWandCasting;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.container.ContainerIndustrialWandRecharge;

public class SlotWandOnly extends Slot {
	final ContainerIndustrialWandRecharge charger;

	public SlotWandOnly(ContainerIndustrialWandRecharge indCharger,
			IInventory inv, int par3, int par4, int par5) {
		super(inv, par3, par4, par5);
		this.charger = indCharger;
	}

	@Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		if (!(par1ItemStack.getItem() instanceof ItemWandCasting))
			return false;

		ItemWandCasting wand = (ItemWandCasting) par1ItemStack.getItem();
		return wand.getCap(par1ItemStack).getBaseCostModifier() <= 1F;
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}
}