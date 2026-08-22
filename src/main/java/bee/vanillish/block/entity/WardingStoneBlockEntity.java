package bee.vanillish.block.entity;

import bee.vanillish.registry.VanillishAttachments;
import bee.vanillish.registry.VanillishBlockEntities;
import bee.vanillish.registry.VanillishEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class WardingStoneBlockEntity extends BlockEntity {
    public WardingStoneBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(VanillishBlockEntities.WARDING_STONE, blockPos, blockState);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, WardingStoneBlockEntity entity) {
        AABB aabb = new AABB(blockPos).inflate(32);

        List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class, aabb);

        for (LivingEntity livingEntity : list) {

            if (livingEntity instanceof Enemy && livingEntity instanceof PathfinderMob pathfinderMob) {
                PathNavigation navigation = pathfinderMob.getNavigation();
                Vec3 fleePos = DefaultRandomPos.getPosAway(pathfinderMob, 32, 7, blockPos.getBottomCenter());

                if (fleePos == null) return;

                Path path = navigation.createPath(fleePos.x, fleePos.y, fleePos.z, 0);

                if (navigation.isInProgress()) {
                    BlockPos pos = navigation.getTargetPos();

                    if (aabb.contains(pos.getBottomCenter())) {
                        navigation.stop();
                        navigation.moveTo(path, pathfinderMob.getSpeed() * 1.15);
                    }

                } else {

                    navigation.moveTo(path, 2.2);
                }

            } else {
                livingEntity.addEffect(new MobEffectInstance(VanillishEffects.PROTECTED, 20, 0, true, false));
            }

        }

    }

}
