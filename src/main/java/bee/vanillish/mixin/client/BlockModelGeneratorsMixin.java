package bee.vanillish.mixin.client;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.util.BlockFamilyHelper;
import bee.vanillish.util.VanillishBlockFamily;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

import java.util.function.BiConsumer;

@Mixin(BlockModelGenerators.class)
public abstract class BlockModelGeneratorsMixin  {


	@Shadow
	@Final
	public BiConsumer<Identifier, ModelInstance> modelOutput;

	@ModifyExpressionValue(method = "family(Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/client/data/models/BlockModelGenerators$BlockFamilyProvider;", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/data/models/model/TexturedModel$Provider;get(Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/client/data/models/model/TexturedModel;"))
	private TexturedModel geepgorp(TexturedModel original, Block block) {

		if (block.equals(VanillishBlocks.CUT_DARK_SANDSTONE)) {
			return TexturedModel.TOP_BOTTOM_WITH_WALL.get(VanillishBlocks.SMOOTH_DARK_SANDSTONE).updateTextures(m -> m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block)));
		}

		if (block.equals(VanillishBlocks.DARK_SANDSTONE)) {
			return TexturedModel.TOP_BOTTOM_WITH_WALL.get(block);
		}

		if (block.equals(Blocks.POLISHED_BASALT)) {
			return TexturedModel.COLUMN_WITH_WALL.get(block).updateTextures(m -> m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block).withSuffix("_side")));
		}


		return original;
	}

	@WrapMethod(method = "family")
	private BlockModelGenerators.BlockFamilyProvider family(Block block, Operation<BlockModelGenerators.BlockFamilyProvider> original) {

		for (VanillishBlockFamily family : BlockFamilyHelper.families) {
			//if (family.fullBlock() == block) return new BlockModelGenerators.BlockFamilyProvider(TextureMapping.cube(block));
		}
		return original.call(block);
	}




}
