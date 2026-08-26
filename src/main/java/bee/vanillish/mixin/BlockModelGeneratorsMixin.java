package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishBlocks;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(BlockModelGenerators.class)
public abstract class BlockModelGeneratorsMixin  {


	@ModifyExpressionValue(method = "family(Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/client/data/models/BlockModelGenerators$BlockFamilyProvider;", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/data/models/model/TexturedModel$Provider;get(Lnet/minecraft/world/level/block/Block;)Lnet/minecraft/client/data/models/model/TexturedModel;"))
	private static TexturedModel geepgorp(TexturedModel original, Block block) {

		if (block.equals(VanillishBlocks.CUT_DARK_SANDSTONE)) {
			return TexturedModel.TOP_BOTTOM_WITH_WALL.get(VanillishBlocks.SMOOTH_DARK_SANDSTONE).updateTextures(m -> m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block)));
		}



		if (block.equals(VanillishBlocks.DARK_SANDSTONE)) {
			return TexturedModel.TOP_BOTTOM_WITH_WALL.get(block);
		}

		return original;
	}



}
