package bee.vanillish.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FloatingWaterBlock extends VegetationBlock {
    public FloatingWaterBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return Shapes.box(0, 0, 0, 1, 0.2, 1);
    }

    @Override
    protected MapCodec<? extends VegetationBlock> codec() {
        return simpleCodec(FloatingWaterBlock::new);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        FluidState fluidState = blockGetter.getFluidState(blockPos);
        FluidState fluidState2 = blockGetter.getFluidState(blockPos.above());
        return (fluidState.getType() == Fluids.WATER || blockState.getBlock() instanceof IceBlock) && fluidState2.getType() == Fluids.EMPTY;
    }
}
