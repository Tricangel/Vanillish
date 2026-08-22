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
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.*;

public class VanillishModelGen extends FabricModelProvider {
    public static final PropertyDispatch<VariantMutator> HORIZONTAL_FACING = PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING).select(Direction.EAST, Y_ROT_90).select(Direction.SOUTH, Y_ROT_180).select(Direction.WEST, Y_ROT_270).select(Direction.NORTH, NOP);
    public static final PropertyDispatch<VariantMutator> ROTATION_FACING = PropertyDispatch.modify(BlockStateProperties.FACING).select(Direction.DOWN, X_ROT_90).select(Direction.UP, X_ROT_270).select(Direction.NORTH, NOP).select(Direction.SOUTH, Y_ROT_180).select(Direction.WEST, Y_ROT_270).select(Direction.EAST, Y_ROT_90);
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
        blockModelGenerators.createTrivialCube(VanillishBlocks.WARDING_STONE);
        createRandomizer(VanillishBlocks.REDSTONE_RANDOMIZER, blockModelGenerators);

        createLadder(VanillishBlocks.BRASS_LADDER, blockModelGenerators);
        createChain(VanillishBlocks.BRASS_CHAIN, blockModelGenerators);
        blockModelGenerators.createLantern(VanillishBlocks.BRASS_LANTERN);
        blockModelGenerators.createNormalTorch(VanillishBlocks.BRASS_TORCH, VanillishBlocks.BRASS_WALL_TORCH);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.BRASS_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_BLOCK);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_BRICKS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_GRATE);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_TILES);
        this.createScaffolding(VanillishBlocks.BRASS_SCAFFOLDING, blockModelGenerators);

        blockModelGenerators.createTrivialCube(VanillishBlocks.CARVED_ROSE_GOLD);
        createLadder(VanillishBlocks.ROSE_GOLD_LADDER, blockModelGenerators);
        createChain(VanillishBlocks.ROSE_GOLD_CHAIN, blockModelGenerators);
        blockModelGenerators.createLantern(VanillishBlocks.ROSE_GOLD_LANTERN);
        blockModelGenerators.createNormalTorch(VanillishBlocks.ROSE_GOLD_TORCH, VanillishBlocks.ROSE_GOLD_WALL_TORCH);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.ROSE_GOLD_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.ROSE_GOLD_BLOCK);
        blockModelGenerators.createTrivialCube(VanillishBlocks.ROSE_GOLD_GRATE);
        blockModelGenerators.createTrivialCube(VanillishBlocks.ROSE_GOLD_TILES);
        this.createScaffolding(VanillishBlocks.ROSE_GOLD_SCAFFOLDING, blockModelGenerators);

        blockModelGenerators.createTrivialCube(VanillishBlocks.CARVED_STEEL);
        createLadder(VanillishBlocks.STEEL_LADDER, blockModelGenerators);
        createChain(VanillishBlocks.STEEL_CHAIN, blockModelGenerators);
        blockModelGenerators.createLantern(VanillishBlocks.STEEL_LANTERN);
        blockModelGenerators.createNormalTorch(VanillishBlocks.STEEL_TORCH, VanillishBlocks.STEEL_WALL_TORCH);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.STEEL_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.STEEL_BLOCK);
        blockModelGenerators.createTrivialCube(VanillishBlocks.STEEL_GRATE);
        blockModelGenerators.createTrivialCube(VanillishBlocks.STEEL_TILES);
        this.createScaffolding(VanillishBlocks.STEEL_SCAFFOLDING, blockModelGenerators);

        blockModelGenerators.createTrivialCube(VanillishBlocks.CARVED_SCRAP_METAL);
        createLadder(VanillishBlocks.SCRAP_METAL_LADDER, blockModelGenerators);
        createChain(VanillishBlocks.SCRAP_METAL_CHAIN, blockModelGenerators);
        blockModelGenerators.createLantern(VanillishBlocks.SCRAP_METAL_LANTERN);
        blockModelGenerators.createNormalTorch(VanillishBlocks.SCRAP_METAL_TORCH, VanillishBlocks.SCRAP_METAL_WALL_TORCH);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.SCRAP_METAL_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.SCRAP_METAL_BLOCK);
        blockModelGenerators.createTrivialCube(VanillishBlocks.SCRAP_METAL_GRATE);
        blockModelGenerators.createTrivialCube(VanillishBlocks.SCRAP_METAL_BRICKS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.SCRAP_METAL_TILES);

        blockModelGenerators.createDoor(VanillishBlocks.SCRAP_METAL_DOOR);
        blockModelGenerators.createTrapdoor(VanillishBlocks.SCRAP_METAL_TRAPDOOR);

        createAlgae(VanillishBlocks.ALGAE, blockModelGenerators);
        blockModelGenerators.createFurnace(VanillishBlocks.BLAST_CHAMBER, TexturedModel.ORIENTABLE_ONLY_TOP);

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

    public final void createRandomizer(Block block, BlockModelGenerators generators) {
        Identifier texture = TextureMapping.getBlockTexture(block);

        TextureMapping off = new TextureMapping().put(TextureSlot.ALL, texture).put(TextureSlot.NORTH, texture.withSuffix("_front"));
        TextureMapping on = new TextureMapping().put(TextureSlot.ALL, texture.withSuffix("_on")).put(TextureSlot.NORTH, texture.withSuffix("_front"));
        Identifier template = VanillishModelTemplates.CUBE_NORTH.create(block, off, generators.modelOutput);
        Identifier templateOn = VanillishModelTemplates.CUBE_NORTH.createWithSuffix(block, "_on", on, generators.modelOutput);


        generators.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(createEmptyOrFullDispatch(BlockStateProperties.POWER, 0, plainVariant(template), plainVariant(templateOn))).with(ROTATION_FACING));
        generators.registerSimpleItemModel(block, template);
    }

    private void createChain(Block block, BlockModelGenerators generators) {
        generators.createAxisAlignedPillarBlockCustomModel(block, plainVariant(TexturedModel.CHAIN.create(block, generators.modelOutput)));
        generators.registerSimpleFlatItemModel(block, "_item");
    }

    private void createLadder(Block block, BlockModelGenerators generators) {
        TextureMapping mapping = TextureMapping.defaultTexture(block);
        generators.blockStateOutput.accept(MultiVariantGenerator.dispatch(block, plainVariant(VanillishModelTemplates.LADDER.create(block, mapping, generators.modelOutput))).with(HORIZONTAL_FACING));
        generators.registerSimpleFlatItemModel(block);
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
