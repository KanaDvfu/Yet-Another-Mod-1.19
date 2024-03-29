package net.CMKana_AJMC2002.yetanothermod.world.gen.chunk;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.SharedConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ChunkRegion;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.chunk.ProtoChunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.Blender;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.VerticalBlockSample;
import net.minecraft.world.gen.noise.NoiseConfig;

public class YetAnotherChunkGenerator extends ChunkGenerator {
	public static final Codec<YetAnotherChunkGenerator> CODEC =
			RecordCodecBuilder.create(instance -> instance
					.group(BiomeSource.CODEC.fieldOf("biome_source")
							.forGetter(YetAnotherChunkGenerator::getBiomeSource))
					.apply(instance, YetAnotherChunkGenerator::new));
	// same for x and z
	private static final int SEA_LEVEL = 0;
	private static final int MINIMUM_Y = SEA_LEVEL - 32;
	private static final int WORLD_HEIGHT =
			SEA_LEVEL + YetAnotherRooms.NUM_FLOORS * YetAnotherRooms.ROOM_HEIGHT - MINIMUM_Y;

	public YetAnotherChunkGenerator(BiomeSource biomeSource) {
		super(biomeSource);
	}

	@Override
	public void carve(ChunkRegion chunkRegion, long seed, NoiseConfig noiseConfig,
			BiomeAccess biomeAccess, StructureAccessor structureAccessor, Chunk chunk,
			GenerationStep.Carver carverStep) {}

	@Override
	public void buildSurface(ChunkRegion region, StructureAccessor structures,
			NoiseConfig noiseConfig, Chunk chunk) {}

	@Override
	public void populateEntities(ChunkRegion region) {}

	@Override
	public int getWorldHeight() {
		return WORLD_HEIGHT;
	}

	@Override
	public int getSeaLevel() {
		return SEA_LEVEL;
	}

	@Override
	public int getMinimumY() {
		return MINIMUM_Y;
	}

	@Override
	public int getHeight(int x, int z, Heightmap.Type heightmap, HeightLimitView world,
			NoiseConfig noiseConfig) {
		return WORLD_HEIGHT;
	}

	@Override
	public VerticalBlockSample getColumnSample(int x, int z, HeightLimitView world,
			NoiseConfig noiseConfig) {
		BlockState[] blockStates = new BlockState[WORLD_HEIGHT];
		for (int y = MINIMUM_Y; y < MINIMUM_Y + WORLD_HEIGHT + 1; y++) {
			blockStates[y - MINIMUM_Y] = this.getBlock(new BlockPos(x, y, z)).getDefaultState();
		}
		return new VerticalBlockSample(MINIMUM_Y, blockStates);
	}

	@Override
	public void getDebugHudText(List<String> text, NoiseConfig noiseConfig, BlockPos pos) {}

	@Override
	protected Codec<? extends ChunkGenerator> getCodec() {
		return CODEC;
	}

	@Override
	public CompletableFuture<Chunk> populateNoise(Executor executor, Blender blender,
			NoiseConfig noiseConfig, StructureAccessor structureAccessor, Chunk chunk) {
		int l = chunk.getSectionIndex(WORLD_HEIGHT - 1 + MINIMUM_Y);
		int m = chunk.getSectionIndex(MINIMUM_Y);
		HashSet<ChunkSection> set = Sets.newHashSet();
		for (int n = l; n >= m; --n) {
			ChunkSection chunkSection = chunk.getSection(n);
			chunkSection.lock();
			set.add(chunkSection);
		}
		return CompletableFuture.supplyAsync(
				Util.debugSupplier("init_world",
						() -> this.buildChunk(blender, noiseConfig, structureAccessor, chunk)),
				Util.getMainWorkerExecutor()).whenCompleteAsync((chunk2, throwable) -> {
					for (ChunkSection chunkSection : set) {
						chunkSection.unlock();
					}
				}, executor);
	}

	private final Chunk buildChunk(Blender blender, NoiseConfig noiseConfig,
			StructureAccessor structureAccessor, Chunk chunk) {
		final int xOffset = chunk.getPos().x * 16;
		final int zOffset = chunk.getPos().z * 16;
		Heightmap oceanFloorHeightmap = chunk.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG);
		Heightmap worldSurfaceHeightmap = chunk.getHeightmap(Heightmap.Type.WORLD_SURFACE_WG);
		BlockPos.Mutable mutablePos = new BlockPos.Mutable();
		for (int x = 0; x < 16; x++) {
			mutablePos.setX(x + xOffset);
			for (int z = 0; z < 16; z++) {
				mutablePos.setZ(z + zOffset);
				for (int y = MINIMUM_Y; y < MINIMUM_Y + WORLD_HEIGHT + 1; y++) {
					mutablePos.setY(y);
					BlockState blockState = getBlock(mutablePos.toImmutable()).getDefaultState();

					if (blockState == Blocks.AIR.getDefaultState()
							|| SharedConstants.isOutsideGenerationArea(chunk.getPos()))
						continue;

					if (blockState == Blocks.SEA_LANTERN.getDefaultState()) {
						((ProtoChunk) chunk).addLightSource(mutablePos);
					}

					int chunkSectionIndex = chunk.getSectionIndex(y);
					ChunkSection chunkSection = chunk.getSection(chunkSectionIndex);
					chunkSection.setBlockState(x & 0xf, y & 0xf, z & 0xf, blockState, false);

					oceanFloorHeightmap.trackUpdate(x, y, z, blockState);
					worldSurfaceHeightmap.trackUpdate(x, y, z, blockState);

					if (blockState.getFluidState().isEmpty())
						continue;

					chunk.markBlockForPostProcessing(mutablePos);
				}
			}
		}
		return chunk;
	}

	private final Block getBlock(BlockPos blockPos) {
		final int x = blockPos.getX();
		final int y = blockPos.getY();
		final int z = blockPos.getZ();
		final int relX = Math.floorMod(x, YetAnotherRooms.ROOM_WIDTH);
		final int relY = Math.floorMod(y, YetAnotherRooms.ROOM_HEIGHT);
		final int relZ = Math.floorMod(z, YetAnotherRooms.ROOM_WIDTH);
		if (y >= SEA_LEVEL) {
			// Floor
			if (relY == 0) {
				if (relX == 3 && relZ == 3)
					return Blocks.SEA_LANTERN;
				if (relX == 3 || relZ == 3)
					return Blocks.DEEPSLATE_TILES;
				return Blocks.SMOOTH_STONE;
			}
			// Ceiling
			if (relY == YetAnotherRooms.ROOM_HEIGHT - 1)
				return Blocks.IRON_BLOCK;
			// Room
			final boolean[][] room = YetAnotherRooms.getRoom(x, y, z);
			if (room[relX][relZ])
				return Blocks.POLISHED_DIORITE;
			// Air
			return Blocks.AIR;
		}
		return Blocks.WATER;
	}
}
