package net.CMKana_AJMC2002.yetanothermod;

import net.CMKana_AJMC2002.yetanothermod.block.YetAnotherBlocks;
import net.CMKana_AJMC2002.yetanothermod.item.YetAnotherItems;
import net.CMKana_AJMC2002.yetanothermod.world.gen.YetAnotherWorldgen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YetAnotherMod implements ModInitializer {
	public static final String MOD_ID = "yetanothermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		YetAnotherItems.registerModItem();
		YetAnotherBlocks.registerModBlocks();
		YetAnotherWorldgen.register();
	}
}
