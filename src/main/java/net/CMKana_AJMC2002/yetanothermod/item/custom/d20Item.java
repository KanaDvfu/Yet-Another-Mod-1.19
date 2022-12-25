package net.CMKana_AJMC2002.yetanothermod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class d20Item extends Item {
    public d20Item(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            outputD20Number(user);
            user.getItemCooldownManager().set(this,20);
        }
        return super.use(world, user, hand);
    }

    private void outputD20Number(PlayerEntity player) {
        player.sendMessage(Text.literal("" + getD20Number()));
    }

    private int getD20Number() {
        return Random.createLocal().nextInt(20) + 1;
    }
}
