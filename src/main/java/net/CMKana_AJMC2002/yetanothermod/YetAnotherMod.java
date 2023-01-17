package net.CMKana_AJMC2002.yetanothermod;

import net.CMKana_AJMC2002.yetanothermod.block.ModBlocks;
import net.CMKana_AJMC2002.yetanothermod.entity.ModEntities;
import net.CMKana_AJMC2002.yetanothermod.entity.custom.ValkyrEntity;
import net.CMKana_AJMC2002.yetanothermod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class YetAnotherMod implements ModInitializer {
	public static final String MOD_ID = "yetanothermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItem();
		ModBlocks.registerModBlocks();

		GeckoLib.initialize();

		FabricDefaultAttributeRegistry.register(ModEntities.VALKYR, ValkyrEntity.setAttributes());
	}
}
