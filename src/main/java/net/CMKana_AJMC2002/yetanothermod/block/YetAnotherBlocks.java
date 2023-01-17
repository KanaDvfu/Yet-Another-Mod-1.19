package net.CMKana_AJMC2002.yetanothermod.block;

import net.CMKana_AJMC2002.yetanothermod.YetAnotherMod;
import net.CMKana_AJMC2002.yetanothermod.item.YetAnotherItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class YetAnotherBlocks {
    public static final Block EUGENIUM_BLOCK = registerBlock(
            "eugenium_block",
            new Block(FabricBlockSettings.of(
                    Material.METAL).strength(4f).requiresTool()));

    public static final Block ADRIANIUM_BLOCK = registerBlock(
            "adrianium_block",
            new Block(FabricBlockSettings.of(
                    Material.AMETHYST).strength(4f).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(YetAnotherMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        ItemGroupEvents.modifyEntriesEvent(YetAnotherItemGroup.YetAnotherModGroup).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(YetAnotherMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        YetAnotherMod.LOGGER.debug("Registering ModBlocks for " + YetAnotherMod.MOD_ID);
    }
}