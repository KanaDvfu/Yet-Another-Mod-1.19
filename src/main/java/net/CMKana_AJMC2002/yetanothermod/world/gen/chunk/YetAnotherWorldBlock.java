package net.CMKana_AJMC2002.yetanothermod.world.gen.chunk;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public enum YetAnotherWorldBlock {
	WATER(Blocks.WATER.getDefaultState()), AIR(Blocks.AIR.getDefaultState()), FLOOR1(
			Blocks.STONE_BRICKS.getDefaultState()), FLOOR2(
					Blocks.ACACIA_PLANKS.getDefaultState()), FLOOR3(
							Blocks.PURPLE_WOOL.getDefaultState());

	private YetAnotherWorldBlock(final BlockState blockState) {
		this.blockState = blockState;
	}

	private final BlockState blockState;

	public BlockState getBlockState() {
		return blockState;
	}
}
