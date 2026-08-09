package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishTags;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {


	@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"), method = "handleOnClimbable")
	private boolean init(BlockState instance, Block block, Operation<Boolean> original) {

		if (block.equals(Blocks.SCAFFOLDING)) {
			return instance.is(VanillishTags.SCAFFOLDING);
		}

		return original.call(instance, block);
	}
}
