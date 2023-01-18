package net.CMKana_AJMC2002.yetanothermod.entity.client;

import net.CMKana_AJMC2002.yetanothermod.YetAnotherMod;
import net.CMKana_AJMC2002.yetanothermod.entity.custom.ValkyrEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ValkyrRenderer extends GeoEntityRenderer<ValkyrEntity> {
    public ValkyrRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GeoModel<>() {
            @Override
            public Identifier getModelResource(ValkyrEntity object) {
                return YetAnotherMod.id("geo/valkyr.geo.json");
            }

            @Override
            public Identifier getTextureResource(ValkyrEntity object) {
                return YetAnotherMod.id("textures/valkyr_texture.png");
            }

            @Override
            public Identifier getAnimationResource(ValkyrEntity animatable) {
                return YetAnotherMod.id("animations/valkyr.animation.json");
            }
        });
        this.shadowRadius = 1.0f;
    }

    @Override
    public Identifier getTexture(ValkyrEntity instance) {
        return YetAnotherMod.id("textures/valkyr_texture.png");
    }
}
