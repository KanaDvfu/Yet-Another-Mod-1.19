package net.CMKana_AJMC2002.yetanothermod.entity;

import net.CMKana_AJMC2002.yetanothermod.YetAnotherMod;
import net.CMKana_AJMC2002.yetanothermod.entity.custom.ValkyrEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class YetAnotherEntities {
    public static final EntityType<ValkyrEntity> VALKYR = Registry.register(
            Registries.ENTITY_TYPE, YetAnotherMod.id("valkyr"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ValkyrEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 4f)).build());
}
