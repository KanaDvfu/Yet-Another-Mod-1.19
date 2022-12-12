package net.cmkana_lemosque.yetanothermod;

import net.cmkana_lemosque.yetanothermod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YetAnotherMod implements ModInitializer {
	public static final String MOD_ID = "yetanothermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItem();
	}
}
