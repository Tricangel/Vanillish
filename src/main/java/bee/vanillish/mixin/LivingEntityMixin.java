package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishEffects;
import bee.vanillish.registry.VanillishTags;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.Holder;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Attackable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.waypoints.WaypointTransmitter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable, WaypointTransmitter {


	@Shadow
	public abstract boolean hasEffect(Holder<MobEffect> holder);

	public LivingEntityMixin(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"), method = "handleOnClimbable")
	private boolean init(BlockState instance, Block block, Operation<Boolean> original) {

		if (block.equals(Blocks.SCAFFOLDING)) {
			return instance.is(VanillishTags.SCAFFOLDING);
		}

		return original.call(instance, block);
	}

	@ModifyReturnValue(at = @At("RETURN"), method = "getVisibilityPercent")
	private double protection(double original) {
		if (this.hasEffect(VanillishEffects.PROTECTED)) {

			if ((LivingEntity) (Object) this instanceof Player) {
				return original * 0.05;
			} else return 0.0;

		}


		return original;
	}



}
