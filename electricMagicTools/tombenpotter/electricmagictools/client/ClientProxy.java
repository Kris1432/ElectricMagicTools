package electricMagicTools.tombenpotter.electricmagictools.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.CommonProxy;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.EntityLaser;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.RenderLaser;

public class ClientProxy extends CommonProxy {

	@Override
	public void load() {
		registerRenders();
	}

	public void registerRenders() {
	//	EntityRegistry.registerGlobalEntityID(EntityLaser.class, "entityLaser", 1);
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class,
				new RenderLaser());
	}
}
