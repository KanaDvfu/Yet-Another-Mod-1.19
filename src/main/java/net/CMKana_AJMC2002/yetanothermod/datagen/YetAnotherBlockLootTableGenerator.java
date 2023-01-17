package net.CMKana_AJMC2002.yetanothermod.datagen;

import net.CMKana_AJMC2002.yetanothermod.block.YetAnotherBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class YetAnotherBlockLootTableGenerator extends FabricBlockLootTableProvider {
	public YetAnotherBlockLootTableGenerator(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(YetAnotherBlocks.ADRIANIUM_BLOCK);
		addDrop(YetAnotherBlocks.EUGENIUM_BLOCK);
	}

}

