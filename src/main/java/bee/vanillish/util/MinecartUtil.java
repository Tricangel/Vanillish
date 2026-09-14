package bee.vanillish.util;

import bee.vanillish.registry.VanillishTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.phys.Vec3;

public class MinecartUtil {

    public static Vec3 getRedstoneDirection(Level level, BlockPos blockPos) {
        BlockState blockState = level.getBlockState(blockPos);
        if (blockState.is(VanillishTags.ADVANCED_RAILS)) {
            RailShape railShape = blockState.getValue(((BaseRailBlock)blockState.getBlock()).getShapeProperty());
            if (railShape == RailShape.EAST_WEST) {
                if (isRedstoneConductor(level, blockPos.west())) {
                    return new Vec3(1.0, 0.0, 0.0);
                }

                if (isRedstoneConductor(level, blockPos.east())) {
                    return new Vec3(-1.0, 0.0, 0.0);
                }
            } else if (railShape == RailShape.NORTH_SOUTH) {
                if (isRedstoneConductor(level, blockPos.north())) {
                    return new Vec3(0.0, 0.0, 1.0);
                }

                if (isRedstoneConductor(level, blockPos.south())) {
                    return new Vec3(0.0, 0.0, -1.0);
                }
            }

        }
        return Vec3.ZERO;
    }

    public static boolean isRedstoneConductor(Level level, BlockPos blockPos) {
        return level.getBlockState(blockPos).isRedstoneConductor(level, blockPos);
    }

}
