package bee.vanillish.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MetalScaffolding extends Block implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;
    private static final VoxelShape SHAPE_STABLE = Shapes.or(Block.column(16.0F, 14.0F, 16.0F), Shapes.rotateHorizontal(Block.box(0.0F, 0.0F, 0.0F, 2.0F, 16.0F, 2.0F)).values().stream().reduce(Shapes.empty(), Shapes::or));
    private static final VoxelShape SHAPE_UNSTABLE_BOTTOM = Block.column(16.0F, 0.0F, 2.0F);
    VoxelShape SHAPE_UNSTABLE = Shapes.or(SHAPE_STABLE, SHAPE_UNSTABLE_BOTTOM, Shapes.rotateHorizontal(Block.boxZ(16.0F, 0.0F, 2.0F, 0.0F, 2.0F)).values().stream().reduce(Shapes.empty(), Shapes::or));
    VoxelShape SHAPE_BELOW_BLOCK = Shapes.block().move(0.0F, -1.0F, 0.0F).optimize();

    public MetalScaffolding(Properties properties) {
        super(properties);
        registerDefaultState(this.getStateDefinition().any().setValue(BOTTOM, false));
    }



    public boolean update(Level level, BlockPos pos, Direction direction, ArrayList<BlockPos> original) {
        if (level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP)) {
            return true;
        }

        boolean output = false;
        for (Direction direction1 : Direction.Plane.HORIZONTAL) {
            if (direction1.equals(direction)) continue;

            if (original.contains(pos.relative(direction1))) continue;

            BlockState neighbour = level.getBlockState(pos.relative(direction));

            if (neighbour.getBlock() instanceof MetalScaffolding scaffolding) {
                if (!original.contains(pos)) original.add(pos);

                boolean bl = scaffolding.update(level, pos.relative(direction1), direction1.getOpposite(), original);

                if (bl) output = true;
            }

        }

        return output;

    }



    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, @Nullable Orientation orientation, boolean wawa) {

        if (level.getBlockState(blockPos.below()).isFaceSturdy(level, blockPos.below(), Direction.UP) || level.getBlockState(blockPos.below()).is(this)) return;
        boolean bl = true;
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockState neighbour = level.getBlockState(blockPos.relative(direction));

            if (neighbour.getBlock() instanceof MetalScaffolding scaffolding) {
                boolean temp = scaffolding.update(level, blockPos.relative(direction), direction.getOpposite(), new ArrayList<>(List.of(blockPos)));
                if (temp) bl = false;
            }

        }

        if (bl) {

            level.destroyBlock(blockPos, true);
        }

    }

    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (!collisionContext.isHoldingItem(blockState.getBlock().asItem())) {
            return blockState.getValue(BOTTOM) ? SHAPE_UNSTABLE : SHAPE_STABLE;
        } else {
            return Shapes.block();
        }
    }


    protected VoxelShape getInteractionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return Shapes.block();
    }

    protected VoxelShape getCollisionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        if (collisionContext.isPlacement()) {
            return Shapes.empty();
        } else if (collisionContext.isAbove(Shapes.block(), blockPos, true) && !collisionContext.isDescending()) {
            return SHAPE_STABLE;
        } else {
            return blockState.getValue(BOTTOM) && collisionContext.isAbove(SHAPE_BELOW_BLOCK, blockPos, true) ? SHAPE_UNSTABLE_BOTTOM : Shapes.empty();
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(WATERLOGGED, BOTTOM);
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        Level level = blockPlaceContext.getLevel();
        return this.defaultBlockState().setValue(WATERLOGGED, level.getFluidState(blockPos).getType() == Fluids.WATER).setValue(BOTTOM, this.isBottom(level, blockPos));
    }

    private boolean isBottom(BlockGetter blockGetter, BlockPos blockPos) {
        return !blockGetter.getBlockState(blockPos.below()).is(this) && blockGetter.getBlockState(blockPos.below()).isAir();
    }

    @Override
    protected FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }
}
