package net.CMKana_AJMC2002.yetanothermod;

import net.CMKana_AJMC2002.yetanothermod.block.YetAnotherBlocks;
import net.CMKana_AJMC2002.yetanothermod.entity.YetAnotherEntities;
import net.CMKana_AJMC2002.yetanothermod.entity.custom.ValkyrEntity;
import net.CMKana_AJMC2002.yetanothermod.item.YetAnotherItems;
import net.CMKana_AJMC2002.yetanothermod.world.gen.YetAnotherWorldgen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.GeckoLib;
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
		YetAnotherBlocks.register();
		YetAnotherItems.register();
		YetAnotherWorldgen.register();

		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(YetAnotherEntities.VALKYR,
				ValkyrEntity.setAttributes());
	}
}
