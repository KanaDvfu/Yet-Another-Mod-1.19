package net.CMKana_AJMC2002.yetanothermod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ValkyrEntity extends HostileEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ValkyrEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return HostileEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0f)
                .add(EntityAttributes.GENERIC_ARMOR, 10D)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100D)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(3, new WanderAroundGoal(this, 1f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true));
    }

    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenLoop("animation.valkyr.idle");
    private static final RawAnimation WALK_ANIM = RawAnimation.begin().thenLoop("animation.valkyr.walk");
    private static final RawAnimation ATTACK_ANIM = RawAnimation.begin().thenPlay("animation.valkyr.attack");

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, "Walk/Idle", 5, state -> state.setAndContinue(state.isMoving() ? WALK_ANIM : IDLE_ANIM)),
                DefaultAnimations.genericAttackAnimation(this, ATTACK_ANIM)
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {return SoundEvents.ENTITY_GENERIC_HURT;}

    @Override
    protected SoundEvent getDeathSound() {return SoundEvents.ENTITY_GENERIC_DEATH;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.07f, 1.0f);}
}
