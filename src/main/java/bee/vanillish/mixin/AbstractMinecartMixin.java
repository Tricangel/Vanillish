package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.VehicleEntity;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.entity.vehicle.minecart.MinecartBehavior;
import net.minecraft.world.entity.vehicle.minecart.NewMinecartBehavior;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.RailShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractMinecart.class)
public abstract class AbstractMinecartMixin extends VehicleEntity {

	@Shadow
	public abstract BlockPos getCurrentBlockPosOrRailBelow();

	public AbstractMinecartMixin(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	@Inject(at = @At("HEAD"), method = "getMaxSpeed", cancellable = true)
	private void maxSpeed(ServerLevel serverLevel, CallbackInfoReturnable<Double> cir) {
		BlockState state = serverLevel.getBlockState(getCurrentBlockPosOrRailBelow());
		if (state.is(VanillishTags.ADVANCED_RAILS)) {
			double speed = this.isInWater() ? 0.3 : 0.7;

			if (state.getValueOrElse(BlockStateProperties.RAIL_SHAPE, RailShape.EAST_WEST).isSlope()) {

			}

			cir.setReturnValue(speed);

		}
	}

	@Inject(at = @At("HEAD"), method = "getBehavior", cancellable = true)
	private void changeBehaviour(CallbackInfoReturnable<MinecartBehavior> cir) {
		AbstractMinecart minecart = (AbstractMinecart) (Object) this;
		BlockState state = level().getBlockState(getCurrentBlockPosOrRailBelow());

	}
}
