package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.entity.vehicle.minecart.MinecartBehavior;
import net.minecraft.world.entity.vehicle.minecart.OldMinecartBehavior;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OldMinecartBehavior.class)
public abstract class OldMinecartBehaviourMixin extends MinecartBehavior {
	private OldMinecartBehaviourMixin(AbstractMinecart abstractMinecart) {
		super(abstractMinecart);
	}

	@Inject(at = @At("HEAD"), method = "moveAlongTrack")
	private void addRailFunctionality(ServerLevel serverLevel, CallbackInfo ci) {
		BlockPos blockPos = this.minecart.getCurrentBlockPosOrRailBelow();
		BlockState blockState = this.level().getBlockState(blockPos);
		Vec3 delta = this.getDeltaMovement();
		double velocity = delta.horizontalDistance();

		if (blockState.is(VanillishTags.ADVANCED_RAILS) && !blockState.getValueOrElse(BlockStateProperties.POWERED, false)) {
			this.setDeltaMovement(delta.add(delta.x / velocity * 0.01, 0.0F, delta.z / velocity * 0.01));
			return;
		}


		if (blockState.is(VanillishBlocks.ADVANCED_STOP_RAIL)) {
			this.setDeltaMovement(this.getDeltaMovement().scale(.5));
		}

		if (blockState.is(VanillishBlocks.ADVANCED_POWERED_RAIL)) {
			this.setDeltaMovement(delta.add(delta.x / velocity * 0.06, 0.0F, delta.z / velocity * 0.06));
		}

		if (blockState.is(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL)) {
			boolean inverted = level().getBlockState(this.minecart.getCurrentBlockPosOrRailBelow()).getValueOrElse(BlockStateProperties.INVERTED, false);

			double xDelta = (delta.x > 0 && inverted) || (delta.x < 0 && !inverted) ? -delta.x : delta.x;
			double zDelta = (delta.z > 0 && inverted) || (delta.z < 0 && !inverted) ? -delta.z : delta.z;

			this.setDeltaMovement(delta.add(xDelta / velocity * 0.06, 0.0F, zDelta / velocity * 0.06));


		}

		if (blockState.is(VanillishBlocks.ADVANCED_BOUNCY_RAIL)) {


		}

	}



}
