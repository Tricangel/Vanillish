package bee.vanillish.block.entity;

import bee.vanillish.block.GazerBlock;
import bee.vanillish.registry.VanillishBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.skeleton.WitherSkeleton;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class GazerBlockEntity extends BlockEntity {
    public GazerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(VanillishBlockEntities.GAZER, blockPos, blockState);
    }

    public void tick() {
        AABB aabb = AABB.encapsulatingFullBlocks(worldPosition, worldPosition.relative(getBlockState().getValue(BlockStateProperties.FACING), 3));
        List<Entity> entities = getEntityType(aabb);

        if (!entities.isEmpty()) level.setBlockAndUpdate(worldPosition, getBlockState().setValue(GazerBlock.POWERED, true));
        else level.setBlockAndUpdate(worldPosition, getBlockState().setValue(GazerBlock.POWERED, false));
    }

    public List<Entity> getEntityType(AABB aabb) {
        BlockState state = level.getBlockState(worldPosition.above());
        if (state.is(Blocks.SKELETON_SKULL) || state.is(Blocks.SKELETON_WALL_SKULL)) {
            return level.getEntities((Entity) null, aabb, entity -> entity.getType() == EntityType.SKELETON);
        }
        if (state.is(Blocks.WITHER_SKELETON_SKULL) || state.is(Blocks.WITHER_SKELETON_WALL_SKULL)) {
            return level.getEntities((Entity) null, aabb, entity -> entity.getType() == EntityType.WITHER_SKELETON);
        }
        if (state.is(Blocks.ZOMBIE_HEAD) || state.is(Blocks.ZOMBIE_WALL_HEAD)) {
            return level.getEntities((Entity) null, aabb, entity -> entity.getType() == EntityType.ZOMBIE);
        }
        if (state.is(Blocks.CREEPER_HEAD) || state.is(Blocks.CREEPER_WALL_HEAD)) {
            return level.getEntities((Entity) null, aabb, entity -> entity.getType() == EntityType.CREEPER);
        }
        if (state.is(Blocks.PIGLIN_HEAD) || state.is(Blocks.PIGLIN_WALL_HEAD)) {
            return level.getEntities((Entity) null, aabb, entity -> entity.getType() == EntityType.PIGLIN);
        }
        if (state.is(Blocks.PLAYER_HEAD) || state.is(Blocks.PLAYER_WALL_HEAD)) {
            return level.getEntities((Entity) null, aabb, entity -> {
                if (level.getBlockEntity(worldPosition.above()) instanceof SkullBlockEntity entity1) {
                    if (entity1.getOwnerProfile() == null) return entity.getType() == EntityType.PLAYER;
                    return entity1.getOwnerProfile().partialProfile().id().equals(entity.getUUID());
                }
                return false;
            });
        }
        return level.getEntities(null, aabb);
    }

}
