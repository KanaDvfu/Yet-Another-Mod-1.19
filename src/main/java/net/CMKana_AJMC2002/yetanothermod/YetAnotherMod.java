package net.CMKana_AJMC2002.yetanothermod;

import net.CMKana_AJMC2002.yetanothermod.block.ModBlocks;
import net.CMKana_AJMC2002.yetanothermod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YetAnotherMod implements ModInitializer {
	public static final String MOD_ID = "yetanothermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItem();
		ModBlocks.registerModBlocks();
	}
}
