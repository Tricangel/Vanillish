package bee.vanillish.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
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
        BlockPos pos = blockPlaceContext.getClickedPos().relative(blockPlaceContext.getClickedFace().getOpposite());
        Level level = blockPlaceContext.getLevel();
        BlockState state = level.getBlockState(pos);

        if (!state.is(this.getBlock())) return blockPlaceContext;

        Direction direction = blockPlaceContext.getClickedFace() == Direction.UP ? blockPlaceContext.getHorizontalDirection() : Direction.UP;


        int i = 0;

        BlockPos.MutableBlockPos blockPos = pos.mutable().move(direction);

        while (i < 10) {

            if (blockPlaceContext.getPlayer() instanceof ServerPlayer serverPlayer && !level.isInWorldBounds(blockPos)) {
                serverPlayer.sendSystemMessage(Component.translatable("build.tooHigh", level.getMaxY()).withStyle(ChatFormatting.RED), true);
                break;
            }

            state = level.getBlockState(blockPos);
            if (!state.is(this.getBlock())) {
                if (state.canBeReplaced(blockPlaceContext)) {
                    return BlockPlaceContext.at(blockPlaceContext, blockPos, direction);
                }
                break;
            }

            blockPos.move(direction);
            if (direction.getAxis().isHorizontal()) {
                ++i;
            }

        }


        return blockPlaceContext;

    }
}
