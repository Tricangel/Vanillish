package bee.vanillish.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.redstone.Orientation;
import org.jspecify.annotations.Nullable;

public class RedstoneRandomizer extends Block {
    public static final IntegerProperty POWER = BlockStateProperties.POWER;
    public RedstoneRandomizer(Properties properties) {
        super(properties);
    }

    public @Nullable BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(POWER, blockPlaceContext.getLevel().hasNeighborSignal(blockPlaceContext.getClickedPos()) ? 15 : 0);
    }

    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, @Nullable Orientation orientation, boolean bl) {
        if (!level.isClientSide()) {
            if (level.hasNeighborSignal(blockPos)) {
                level.setBlockAndUpdate(blockPos, blockState.setValue(POWER, RandomSource.create().nextInt(1, 15)));
            } else {
                level.setBlockAndUpdate(blockPos, blockState.setValue(POWER, 0));
            }

        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }


    protected int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return blockState.getValue(POWER);
    }

    @Override
    protected int getDirectSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return blockState.getValue(POWER);
    }

    @Override
    protected boolean isSignalSource(BlockState blockState) {
        return true;
    }

}
