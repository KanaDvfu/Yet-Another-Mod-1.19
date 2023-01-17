package net.CMKana_AJMC2002.yetanothermod.entity.client;

import net.CMKana_AJMC2002.yetanothermod.YetAnotherMod;
import net.CMKana_AJMC2002.yetanothermod.entity.custom.ValkyrEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ValkyrRenderer extends GeoEntityRenderer<ValkyrEntity> {
    public ValkyrRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new GeoModel<>() {
            @Override
            public Identifier getModelResource(ValkyrEntity object) {
                return new Identifier(YetAnotherMod.MOD_ID, "geo/valkyr.geo.json");
            }

            @Override
            public Identifier getTextureResource(ValkyrEntity object) {
                return new Identifier(YetAnotherMod.MOD_ID, "textures/valkyr_texture.png");
            }

            @Override
            public Identifier getAnimationResource(ValkyrEntity animatable) {
                return new Identifier(YetAnotherMod.MOD_ID, "animations/valkyr.animation.json");
            }
        });
        this.shadowRadius = 1.0f;
    }

    @Override
    public Identifier getTexture(ValkyrEntity instance) {
        return new Identifier(YetAnotherMod.MOD_ID, "textures/valkyr_texture.png");
    }
}
