package net.CMKana_AJMC2002.yetanothermod.item;

import net.CMKana_AJMC2002.yetanothermod.YetAnotherMod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //Adrianium test item
    public static final Item ADRIANIUM = registerItem(
            "adrianium",
            new Item(new Item.Settings())
    );
    //Eugenium 2nd test item
    public static final Item EUGENIUM = registerItem(
            "eugenium",
            new Item(new Item.Settings())
    );


    private static Item registerItem(String name, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.YetAnotherModGroup).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(YetAnotherMod.MOD_ID, name), item);
    }
    public static void registerModItem() {
        YetAnotherMod.LOGGER.debug("Registering Mod Items for " + YetAnotherMod.MOD_ID);
    }
}
