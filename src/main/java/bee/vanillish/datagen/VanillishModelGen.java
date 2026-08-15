package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishModelTemplates;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.createBooleanModelDispatch;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class VanillishModelGen extends FabricModelProvider {
    public VanillishModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createActiveRail(VanillishBlocks.BRASS_RAILS);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.BRASS_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_BLOCK);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_BRICKS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_GRATE);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_TILES);
        this.createScaffolding(VanillishBlocks.BRASS_SCAFFOLDING, blockModelGenerators);


    }

    private void createScaffolding(Block block, BlockModelGenerators generators) {
        TextureMapping mappings = VanillishModelTemplates.getScaffoldingTexture(block);
        TextureMapping unstableMappings = VanillishModelTemplates.getUnstableScaffoldingTexture(block);
        Identifier stableIdentifier = VanillishModelTemplates.SCAFFOLDING_STABLE.create(block, mappings, generators.modelOutput);
        MultiVariant multiVariant = plainVariant(stableIdentifier);
        Identifier unstableIdentifier = VanillishModelTemplates.SCAFFOLDING_UNSTABLE.createWithSuffix(block, "_unstable", unstableMappings, generators.modelOutput);
        MultiVariant multiVariant2 = plainVariant(unstableIdentifier);
        generators.registerSimpleItemModel(block, stableIdentifier);
        generators.blockStateOutput
                .accept(MultiVariantGenerator.dispatch(block).with(createBooleanModelDispatch(BlockStateProperties.BOTTOM, multiVariant2, multiVariant)));
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
