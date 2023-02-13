package net.CMKana_AJMC2002.yetanothermod.item;

import net.CMKana_AJMC2002.yetanothermod.YetAnotherMod;

import net.CMKana_AJMC2002.yetanothermod.item.custom.CernosItem;
import net.CMKana_AJMC2002.yetanothermod.item.custom.d20Item;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class YetAnotherItems {
        private YetAnotherItems() {}

        public static final Item ADRIANIUM =
                        registerItem("adrianium", new Item(new Item.Settings()));

        public static final Item EUGENIUM = registerItem("eugenium", new Item(new Item.Settings()));

        public static final Item Cernos =
                        registerItem("cernos", new CernosItem(new Item.Settings().maxCount(1)));

        public static final Item Sarofang =
                        registerItem("sarofang", new AxeItem(ToolMaterials.NETHERITE, 6f, -2f,
                                        new Item.Settings().maxCount(1)));

        public static final Item D20 =
                        registerItem("d20", new d20Item(new Item.Settings().maxCount(1)));

        private static Item registerItem(String name, Item item) {
                ItemGroupEvents.modifyEntriesEvent(YetAnotherItemGroup.YetAnotherModGroup)
                                .register(entries -> entries.add(item));
                return Registry.register(Registries.ITEM,
                                new Identifier(YetAnotherMod.MOD_ID, name), item);
        }

        public static void register() {
                YetAnotherMod.LOGGER.debug("Registering Mod Items for " + YetAnotherMod.MOD_ID);
        }
}
