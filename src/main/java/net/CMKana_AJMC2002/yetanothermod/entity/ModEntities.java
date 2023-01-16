package net.CMKana_AJMC2002.yetanothermod.entity;

import net.CMKana_AJMC2002.yetanothermod.YetAnotherMod;
import net.CMKana_AJMC2002.yetanothermod.entity.custom.ValkyrEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<ValkyrEntity> VALKYR = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(YetAnotherMod.MOD_ID, "valkyr"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ValkyrEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 4f)).build());
}
