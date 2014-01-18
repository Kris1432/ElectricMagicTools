package electricMagicTools.tombenpotter.electricmagictools.common;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EntityLivingHandler {

	@ForgeSubscribe
	public void onEntityLivingUpdate(LivingUpdateEvent event) {

	}

	@ForgeSubscribe
	public void onEntityLivingDeath(LivingDeathEvent event) {
		if (event.entityLiving instanceof EntityCreeper) {
			EntityCreeper creeper = (EntityCreeper) event.entityLiving;
			if (creeper.getPowered()) {
				event.entityLiving.dropItem(
						ElectricMagicTools.lightningSummoner.itemID, 1);
			}
		}
	}

}
