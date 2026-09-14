package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishTags;
import bee.vanillish.util.MinecartUtil;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.entity.vehicle.minecart.MinecartBehavior;
import net.minecraft.world.entity.vehicle.minecart.NewMinecartBehavior;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NewMinecartBehavior.class)
public abstract class NewMinecartBehaviourMixin extends MinecartBehavior {
	@Shadow
	protected abstract void setRotation(float f, float g);

	private NewMinecartBehaviourMixin(AbstractMinecart abstractMinecart) {
		super(abstractMinecart);
	}

	@WrapMethod(method = "calculateBoostTrackSpeed")
	private Vec3 addRailFunctionality(Vec3 vec3, BlockPos blockPos, BlockState blockState, Operation<Vec3> original) {

		double delta = this.getDeltaMovement().length();
		Vec3 newDelta;

		double movementBonus = blockState.getValueOrElse(BlockStateProperties.POWERED, false) ? 0.03 : 0.01;

		if (vec3.length() > 0.01) {
			newDelta = vec3.normalize().scale(vec3.length() + movementBonus);
		} else {
			Vec3 vec32 = MinecartUtil.getRedstoneDirection(level(), blockPos);
			if (vec32.lengthSqr() <= 0.0) newDelta = vec3;
			else newDelta = vec32.scale(vec3.length() + 0.2);
		}

		if (blockState.is(VanillishTags.ADVANCED_RAILS) && !blockState.getValueOrElse(BlockStateProperties.POWERED, false)) {
			if (delta > .5) return vec3;
			return newDelta;
		}


		if (blockState.is(VanillishBlocks.ADVANCED_STOP_RAIL)) {
			return vec3.scale(0.5);
		}

		if (blockState.is(VanillishBlocks.ADVANCED_POWERED_RAIL)) {
			return newDelta;
		}

		if (blockState.is(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL)) {
			boolean inverted = level().getBlockState(this.minecart.getCurrentBlockPosOrRailBelow()).getValueOrElse(BlockStateProperties.INVERTED, false);

			double xDelta = (newDelta.x > 0 && inverted) || (newDelta.x < 0 && !inverted) ? -newDelta.x : newDelta.x;
			double zDelta = (newDelta.z > 0 && inverted) || (newDelta.z < 0 && !inverted) ? -newDelta.z : newDelta.z;

			return new Vec3(xDelta, newDelta.y, zDelta);


		}

		if (blockState.is(VanillishBlocks.ADVANCED_BOUNCY_RAIL)) {
			return newDelta;
		}

		return original.call(vec3, blockPos, blockState);
	}

	@WrapMethod(method = "getMaxSpeed")
	private double maxSpeed(ServerLevel serverLevel, Operation<Double> original) {
		BlockState state = serverLevel.getBlockState(this.minecart.getCurrentBlockPosOrRailBelow());
		if (state.is(VanillishTags.ADVANCED_RAILS)) {

            return this.minecart.isInWater() ? 0.4 : 0.9;

		}
		return this.minecart.isInWater() ? 0.2 : 0.4;
	}



}
