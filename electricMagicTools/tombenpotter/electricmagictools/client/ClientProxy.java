package electricMagicTools.tombenpotter.electricmagictools.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import electricMagicTools.tombenpotter.electricmagictools.common.CommonProxy;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.EntityArcher;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.EntityLaser;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.RenderArcher;
import electricMagicTools.tombenpotter.electricmagictools.common.entities.RenderLaser;

public class ClientProxy extends CommonProxy {

	@Override
	public void load() {
		registerRenders();
	}

	public void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class,
				new RenderLaser());
		RenderingRegistry.registerEntityRenderingHandler(EntityArcher.class,
				new RenderArcher());
	}
}
