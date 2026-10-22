package bee.vanillish.mixin.client;

import bee.vanillish.util.BlockFamilyHelper;
import bee.vanillish.util.VanillishBlockFamily;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockModelGenerators.BlockFamilyProvider.class)
public abstract class BlockModelGenerators$FamilyProviderMixin  {


	@Shadow
	private @Nullable Variant fullBlock;

	@WrapMethod(method = "fullBlock")
	private BlockModelGenerators.BlockFamilyProvider fullBlock(Block block, ModelTemplate modelTemplate, Operation<BlockModelGenerators.BlockFamilyProvider> original) {

		for (VanillishBlockFamily family : BlockFamilyHelper.families) {

			if (family.inherited && family.fullBlock() == block) return (BlockModelGenerators.BlockFamilyProvider) (Object) this;
		}
		return original.call(block, modelTemplate);
	}




}
