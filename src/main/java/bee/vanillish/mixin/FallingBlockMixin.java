package bee.vanillish.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.happyghast.HappyGhast;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FallingBlock.class)
public abstract class FallingBlockMixin extends Block implements Fallable {

    private FallingBlockMixin(Properties properties) {
        super(properties);
    }

    @Shadow
    protected abstract int getDelayAfterPlace();

    @ModifyExpressionValue(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/FallingBlock;isFree(Lnet/minecraft/world/level/block/state/BlockState;)Z"), method = "tick")
    private boolean init(boolean original, final BlockState state, final ServerLevel level, final BlockPos pos, final RandomSource random) {


        for (Entity entity : level.getEntities(null, new AABB(pos))) {

            if (entity instanceof HappyGhast) {

                level.scheduleTick(pos, this, this.getDelayAfterPlace() * 2);
                return false;


            }
        }

        for (Entity entity : level.getEntities(null, new AABB(pos.below()))) {

            if (entity instanceof HappyGhast) {
                level.scheduleTick(pos, this, this.getDelayAfterPlace() * 2);
                return false;
            }
        }



        return original;
    }
}