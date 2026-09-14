package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishTags;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.InterpolationHandler;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.entity.vehicle.minecart.MinecartBehavior;
import net.minecraft.world.entity.vehicle.minecart.NewMinecartBehavior;
import net.minecraft.world.entity.vehicle.minecart.OldMinecartBehavior;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractMinecart.class)
public abstract class AbstractMinecartMixin extends VehicleEntity {

	@Shadow
	public abstract BlockPos getCurrentBlockPosOrRailBelow();

	@Shadow
	public abstract boolean isOnRails();

	@Unique
    MinecartBehavior newBehavior, oldBehavior = null;

	@Unique
	boolean wasOnAdvancedRailsLast = false;

	public AbstractMinecartMixin(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	@Inject(method = "tick", at = @At("HEAD"))
	private void tick(CallbackInfo ci) {
		if (level().getBlockState(getCurrentBlockPosOrRailBelow()).is(VanillishTags.ADVANCED_RAILS)) {
			wasOnAdvancedRailsLast = true;
		} else if (level().getBlockState(getCurrentBlockPosOrRailBelow()).is(BlockTags.RAILS)) {
			wasOnAdvancedRailsLast = false;
		}
	}

	@WrapOperation(method = "getMotionDirection", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;getMotionDirection()Lnet/minecraft/core/Direction;"))
	private Direction getMotionDirection(MinecartBehavior instance, Operation<Direction> original) {
		return getTrueBehavior().getMotionDirection();
	}

	@WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;tick()V"))
	private void tick(MinecartBehavior instance, Operation<Void> original) {
		getTrueBehavior().tick();
	}

	@WrapOperation(method = "getMaxSpeed", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;getMaxSpeed(Lnet/minecraft/server/level/ServerLevel;)D"))
	private double getMaxSpeed(MinecartBehavior instance, ServerLevel serverLevel, Operation<Double> original) {
		return getTrueBehavior().getMaxSpeed(serverLevel);
	}

	@WrapOperation(method = "getKnownMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;getKnownMovement(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;"))
	private Vec3 getKnownMovement(MinecartBehavior instance, Vec3 vec3, Operation<Vec3> original) {
		return getTrueBehavior().getKnownMovement(vec3);
	}

	@WrapOperation(method = "getInterpolation", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;getInterpolation()Lnet/minecraft/world/entity/InterpolationHandler;"))
	private InterpolationHandler getInterpolation(MinecartBehavior instance, Operation<Void> original) {
		return getTrueBehavior().getInterpolation();
	}

	@WrapOperation(method = "recreateFromPacket", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;lerpMotion(Lnet/minecraft/world/phys/Vec3;)V"))
	private void recreateFromPacket(MinecartBehavior instance, Vec3 vec3, Operation<Void> original) {
		getTrueBehavior().lerpMotion(vec3);
	}

	@WrapOperation(method = "lerpMotion", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;lerpMotion(Lnet/minecraft/world/phys/Vec3;)V"))
	private void lerpMotion(MinecartBehavior instance, Vec3 vec3, Operation<Void> original) {
		getTrueBehavior().lerpMotion(vec3);
	}

	@WrapOperation(method = "moveAlongTrack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;moveAlongTrack(Lnet/minecraft/server/level/ServerLevel;)V"))
	private void moveAlongTrack(MinecartBehavior instance, ServerLevel serverLevel, Operation<Void> original) {
		getTrueBehavior().moveAlongTrack(serverLevel);
	}

	@WrapOperation(method = "makeStepAlongTrack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;stepAlongTrack(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/properties/RailShape;D)D"))
	private double makeStepAlongTrack(MinecartBehavior instance, BlockPos pos, RailShape railShape, double v, Operation<Double> original) {
		return getTrueBehavior().stepAlongTrack(pos, railShape, v);
	}

	@WrapOperation(method = "move", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;pushAndPickupEntities()Z"))
	private boolean move(MinecartBehavior instance, Operation<Void> original) {
		return getTrueBehavior().pushAndPickupEntities();
	}

	@WrapOperation(method = "applyNaturalSlowdown", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/vehicle/minecart/MinecartBehavior;getSlowdownFactor()D"))
	private double applyNaturalSlowdown(MinecartBehavior instance, Operation<Void> original) {
		return getTrueBehavior().getSlowdownFactor();
	}

	@WrapMethod(method = "getBehavior")
	private MinecartBehavior getBehavior(Operation<MinecartBehavior> original) {
		return getTrueBehavior();
	}

	@Unique
    private MinecartBehavior getTrueBehavior() {

		if (newBehavior == null || oldBehavior == null) {
			AbstractMinecart minecart = (AbstractMinecart) (Object) this;
			newBehavior = new NewMinecartBehavior(minecart);
			oldBehavior = new OldMinecartBehavior(minecart);
		}

		if (level().getBlockState(getCurrentBlockPosOrRailBelow()).is(VanillishTags.ADVANCED_RAILS) || wasOnAdvancedRailsLast) {
			return newBehavior;
		}
		return oldBehavior;
	}


}
