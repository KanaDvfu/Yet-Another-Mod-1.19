package net.CMKana_AJMC2002.yetanothermod;

import net.CMKana_AJMC2002.yetanothermod.entity.ModEntities;
import net.CMKana_AJMC2002.yetanothermod.entity.client.ValkyrRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class YetAnotherModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.VALKYR, ValkyrRenderer::new);
    }
}
