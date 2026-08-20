package bee.vanillish.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class MetalScaffoldingItem extends BlockItem {
    public MetalScaffoldingItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean canPlace(BlockPlaceContext blockPlaceContext, BlockState blockState) {
        boolean bl = false;
        Level level = blockPlaceContext.getLevel();
        BlockPos pos = blockPlaceContext.getClickedPos();

        for (Direction direction : Direction.values()) {
            if (direction.equals(Direction.UP)) continue;

            if (level.getBlockState(pos.relative(direction)).is(this.getBlock())) {
                bl = true;
            }

        }

        if (level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP)) return true;

        return bl;

    }

    public @Nullable BlockPlaceContext updatePlacementContext(BlockPlaceContext blockPlaceContext) {
        BlockPos pos = blockPlaceContext.getClickedPos();
        Level level = blockPlaceContext.getLevel();

        if (blockPlaceContext.getClickedFace().equals(Direction.UP) && level.getBlockState(pos.below()).is(this.getBlock())) {
            Direction direction = blockPlaceContext.getHorizontalDirection();
            if (level.getBlockState(pos.relative(direction).below()).canBeReplaced()) {
                return BlockPlaceContext.at(blockPlaceContext, pos.relative(direction).below(), direction);
            }

        }


        return blockPlaceContext;

    }
}
