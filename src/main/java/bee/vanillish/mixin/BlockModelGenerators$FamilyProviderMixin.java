package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.util.BlockFamilyHelper;
import bee.vanillish.util.VanillishBlockFamily;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockModelGenerators.BlockFamilyProvider.class)
public abstract class BlockModelGenerators$FamilyProviderMixin {



	@WrapMethod(method = "fullBlock")
	private BlockModelGenerators.BlockFamilyProvider fullBlock(Block block, ModelTemplate modelTemplate, Operation<BlockModelGenerators.BlockFamilyProvider> original) {



		for (VanillishBlockFamily family : BlockFamilyHelper.families) {
			if (family.inherited && family.fullBlock() == block) return (BlockModelGenerators.BlockFamilyProvider) (Object) this;
		}
		return original.call(block, modelTemplate);
	}




}
