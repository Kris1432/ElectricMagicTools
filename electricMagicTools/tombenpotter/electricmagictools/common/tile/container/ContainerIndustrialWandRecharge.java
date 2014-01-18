package electricMagicTools.tombenpotter.electricmagictools.common.tile.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.TileEntityIndustrialWandRecharge;
import electricMagicTools.tombenpotter.electricmagictools.common.tile.slot.SlotWandOnly;

public class ContainerIndustrialWandRecharge extends Container {

	TileEntityIndustrialWandRecharge charger;
	SlotWandOnly wandSlot;

	public ContainerIndustrialWandRecharge(InventoryPlayer invPlayer,
			TileEntityIndustrialWandRecharge entity) {
		this.charger = entity;

		for (int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(invPlayer, x, 8 + x * 18, 142));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(invPlayer, 9 + x + y * 9,
						8 + x * 18, 84 + y * 18));
			}
		}

		this.addSlotToContainer(this.wandSlot = new SlotWandOnly(this, entity,
				0, 80, 35));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return charger.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		Slot slot = getSlot(i);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack = slot.getStack();
			ItemStack result = itemstack.copy();

			if (i >= 36) {
				if (!mergeItemStack(itemstack, 0, 36, false)) {
					return null;
				}
			} else if (!mergeItemStack(itemstack, 36,
					36 + charger.getSizeInventory(), false)) {
				return null;
			}

			if (itemstack.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			slot.onPickupFromSlot(player, itemstack);
			return result;
		}
		return null;
	}
}