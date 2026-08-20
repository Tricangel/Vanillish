package bee.vanillish.mixin;

import bee.vanillish.entity.goal.FleeBlockGoal;
import bee.vanillish.registry.VanillishBlocks;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Zombie.class)
public abstract class MobMixin extends Monster {


    protected MobMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("HEAD"), method = "registerGoals")
    private void addPanicGoal(CallbackInfo ci) {

        if (this instanceof Enemy) {

            this.goalSelector.addGoal(2, new FleeBlockGoal((Zombie) (Object) this, VanillishBlocks.WARDING_STONE, 45));

        }

    }

}
