package net.CMKana_AJMC2002.yetanothermod.worldpreset;

import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.FlatChunkGenerator;
import net.minecraft.world.gen.chunk.FlatChunkGeneratorConfig;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.world.gen.WorldPresets;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(WorldPresets.Registrar.class)
public abstract class WorldPreset {
    // defining our registry key. this key provides an Identifier for our preset, that we can use for our lang files and data elements.
    private static final RegistryKey<WorldPreset> VOID_WORLD = RegistryKey.of(Registry.WORLD_PRESET_KEY, new Identifier("wiki-example", "void_world"));
    @Shadow protected abstract RegistryEntry<WorldPreset> register(RegistryKey<WorldPreset> key, DimensionOptions dimensionOptions);
    @Shadow
    protected abstract DimensionOptions createOverworldOptions(ChunkGenerator chunkGenerator);
 
    @Inject(method = "initAndGetDefault", at = @At("RETURN"))
    private void addPresets(CallbackInfoReturnable<RegistryEntry<WorldPreset>> cir) {
        // the register() method is shadowed from the target class
        this.register(VOID_WORLD, this.createOverworldOptions(
                // a FlatChunkGenerator is the easiest way to get a void world, but you can replace this FlatChunkGenerator constructor with a NoiseChunkGenerator, or your own custom ChunkGenerator.
                new FlatChunkGenerator(
                        // passing null will use the default structure set
                        null,
                        new FlatChunkGeneratorConfig(
                                // we don't need to overwrite the structure set
                                Optional.empty(),
                                BuiltinRegistries.BIOME)
                        )
                )
        );
    }
}