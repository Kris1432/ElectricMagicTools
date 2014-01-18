package electricMagicTools.tombenpotter.electricmagictools.common.entities;

import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArcher extends RenderSnowMan {

	private static final ResourceLocation texture = new ResourceLocation(
			"electricmagictools:entities/entityarcher.png");

	public RenderArcher() {
		super();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}