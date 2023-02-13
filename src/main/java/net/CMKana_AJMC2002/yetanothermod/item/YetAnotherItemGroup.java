package net.CMKana_AJMC2002.yetanothermod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class YetAnotherItemGroup {
    private YetAnotherItemGroup() {}

    public static final ItemGroup YetAnotherModGroup = FabricItemGroup.builder(
            new Identifier(net.CMKana_AJMC2002.yetanothermod.YetAnotherMod.MOD_ID))
            .displayName(Text.literal("Yet Another Mod"))
            .icon(() -> new ItemStack(YetAnotherItems.ADRIANIUM))
            .build();
}
