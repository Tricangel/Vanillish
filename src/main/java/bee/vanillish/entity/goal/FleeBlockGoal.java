package bee.vanillish.entity.goal;

import bee.vanillish.Vanillish;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import oshi.util.tuples.Pair;

import java.util.stream.Stream;

public class FleeBlockGoal extends Goal {
    private final PathfinderMob mob;
    private final Block toflee;
    private @Nullable Pair<BlockPos, BlockState> fleeing;
    private @Nullable Path path;
    private int distance;

    public FleeBlockGoal(PathfinderMob mob, Block block, int distance) {
        this.mob = mob;
        this.toflee = block;
        this.distance = distance;
    }

    @Override
    public boolean canUse() {
        Level level = mob.level();
        Pair<BlockPos, BlockState> closestBlock = Vanillish.getClosestBlockState(toflee, level, mob.getBoundingBox().inflate(distance), mob.getOnPos());

        if (closestBlock == null) return false;

        fleeing = closestBlock;

        Vec3 pos = DefaultRandomPos.getPosAway(this.mob, 16, 7, Vec3.atCenterOf(this.fleeing.getA()));
        if (pos == null) {
            return false;
        }

        path = mob.getNavigation().createPath(pos.x, pos.y, pos.z, 0);

        return path != null;
    }

    @Override
    public boolean canContinueToUse() {
        return !mob.getNavigation().isDone();
    }

    @Override
    public void stop() {
        this.fleeing = null;
    }

    @Override
    public void tick() {
        this.mob.getNavigation().setSpeedModifier(2);
    }
}
