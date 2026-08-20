package bee.vanillish.datagen;

import bee.vanillish.Vanillish;
import bee.vanillish.block.AlgaeBlock;
import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishModelTemplates;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class VanillishModelGen extends FabricModelProvider {
    public VanillishModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createActiveRail(VanillishBlocks.ADVANCED_RAIL);
        blockModelGenerators.createActiveRail(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL);
        blockModelGenerators.createActiveRail(VanillishBlocks.ADVANCED_DETECTOR_RAIL);
        blockModelGenerators.createActiveRail(VanillishBlocks.ADVANCED_BOUNCY_RAIL);
        blockModelGenerators.createActiveRail(VanillishBlocks.ADVANCED_STOP_RAIL);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.BRASS_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_BLOCK);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_BRICKS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_GRATE);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_TILES);
        createAlgae(VanillishBlocks.ALGAE, blockModelGenerators);
        blockModelGenerators.createFurnace(VanillishBlocks.BLAST_CHAMBER, TexturedModel.ORIENTABLE_ONLY_TOP);
        this.createScaffolding(VanillishBlocks.BRASS_SCAFFOLDING, blockModelGenerators);

        blockModelGenerators.woodProvider(VanillishBlocks.CHARRED_LOG).logWithHorizontal(VanillishBlocks.CHARRED_LOG).wood(VanillishBlocks.CHARRED_WOOD);
        blockModelGenerators.woodProvider(VanillishBlocks.STRIPPED_CHARRED_LOG).logWithHorizontal(VanillishBlocks.STRIPPED_CHARRED_LOG).wood(VanillishBlocks.STRIPPED_CHARRED_WOOD);
        blockModelGenerators.createShelf(VanillishBlocks.CHARRED_SHELF, VanillishBlocks.STRIPPED_CHARRED_LOG);
        blockModelGenerators.createDoor(VanillishBlocks.CHARRED_DOOR);
        blockModelGenerators.createTrapdoor(VanillishBlocks.CHARRED_TRAPDOOR);
        blockModelGenerators.family(VanillishBlocks.CHARRED_PLANKS)
                .stairs(VanillishBlocks.CHARRED_STAIRS)
                .slab(VanillishBlocks.CHARRED_SLAB)
                .fence(VanillishBlocks.CHARRED_FENCE)
                .fenceGate(VanillishBlocks.CHARRED_FENCE_GATE)
                .button(VanillishBlocks.CHARRED_BUTTON)
                .pressurePlate(VanillishBlocks.CHARRED_PRESSURE_PLATE);





    }

    private void createAlgae(Block block, BlockModelGenerators generators) {
        TextureMapping small = TextureMapping.defaultTexture(Vanillish.id("block/small_algae"));
        TextureMapping medium = TextureMapping.defaultTexture(Vanillish.id("block/medium_algae"));
        TextureMapping large = TextureMapping.defaultTexture(Vanillish.id("block/large_algae"));
        MultiVariant smallVariant = plainVariant(VanillishModelTemplates.ALGAE.createWithSuffix(block, "_small", small, generators.modelOutput));
        Identifier mediumVariant = VanillishModelTemplates.ALGAE.createWithSuffix(block, "_medium", medium, generators.modelOutput);
        MultiVariant largeVariant = plainVariant(VanillishModelTemplates.ALGAE.createWithSuffix(block, "_large", large, generators.modelOutput));


        generators.registerSimpleItemModel(block, mediumVariant);
        generators.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(AlgaeBlock.SIZE).select(1, smallVariant).select(2, plainVariant(mediumVariant)).select(3, largeVariant)));

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
