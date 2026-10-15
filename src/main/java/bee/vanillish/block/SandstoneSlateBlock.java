package bee.vanillish.block;

import bee.vanillish.block.entity.SandstoneSlateBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class SandstoneSlateBlock extends BaseEntityBlock {
    public SandstoneSlateBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {

        if (level.getBlockEntity(blockPos) instanceof SandstoneSlateBlockEntity sandstoneSlateBlockEntity) {

            if (itemStack.is(ItemTags.DECORATED_POT_SHERDS)) {

             if (sandstoneSlateBlockEntity.changeSherd(blockHitResult.getDirection(), itemStack.getItem())) {
                 itemStack.shrink(1);
                 level.playSound(null, blockPos, SoundEvents.DECORATED_POT_HIT, SoundSource.BLOCKS);
                 return InteractionResult.SUCCESS;
             }
            }

            if (itemStack.is(Items.BRUSH)) {
                Optional<Item> item = sandstoneSlateBlockEntity.getSide(blockHitResult.getDirection());
                if (item.isPresent()) {
                    level.playSound(null, blockPos, SoundEvents.BRUSH_GENERIC, SoundSource.BLOCKS);
                    Vec3 pos = blockPos.getCenter().relative(blockHitResult.getDirection(), 0.6);
                    Containers.dropItemStack(level, pos.x(), pos.y(), pos.z, item.get().getDefaultInstance());
                    sandstoneSlateBlockEntity.setSide(blockHitResult.getDirection(), Optional.empty());
                    return InteractionResult.SUCCESS;
                }
            }
        }




        return super.useItemOn(itemStack, blockState, level, blockPos, player, interactionHand, blockHitResult);
    }



    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(SandstoneSlateBlock::new);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SandstoneSlateBlockEntity(blockPos, blockState);
    }
}
