package net.CMKana_AJMC2002.yetanothermod.world.gen;

import net.CMKana_AJMC2002.yetanothermod.YetAnotherMod;
import net.CMKana_AJMC2002.yetanothermod.world.gen.chunk.YetAnotherChunkGenerator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface YetAnotherWorldgen {
	public static void register() {
		Registry.register(Registries.CHUNK_GENERATOR, YetAnotherMod.id("room_generator"),
				YetAnotherChunkGenerator.CODEC);
	}
}
