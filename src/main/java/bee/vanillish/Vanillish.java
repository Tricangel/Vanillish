package bee.vanillish;

import bee.vanillish.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.util.tuples.Pair;

public class Vanillish implements ModInitializer {
	public static final String MOD_ID = "vanillish";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		VanillishBlocks.init();
		VanillishBlockEntities.init();
		VanillishMenuTypes.init();
		VanillishItems.init();
		VanillishRecipes.init();
		VanillishAttachments.init();
		VanillishEffects.init();
		VanillishRecipeBookCategories.init();

		BlockEntityType.SHELF.addSupportedBlock(VanillishBlocks.CHARRED_SHELF);

		StrippableBlockRegistry.register(VanillishBlocks.CHARRED_LOG, VanillishBlocks.STRIPPED_CHARRED_LOG);
		StrippableBlockRegistry.register(VanillishBlocks.CHARRED_WOOD, VanillishBlocks.STRIPPED_CHARRED_WOOD);
	}

	public static @Nullable Pair<BlockPos, BlockState> getClosestBlockState(Block block, LevelReader levelReader, AABB aabb, BlockPos startingPos) {
		BlockPos closestPos = null;
		for (BlockPos pos : BlockPos.betweenClosedStream(aabb).toList()) {

			if (levelReader.getBlockState(pos).is(block)) {

				if (closestPos == null || pos.distManhattan(startingPos) < closestPos.distManhattan(startingPos)) {

					closestPos = pos;

				}

			}

		}

		if (closestPos == null) return null;

		return new Pair<>(closestPos, levelReader.getBlockState(closestPos));

	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
