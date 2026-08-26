package bee.vanillish.datagen;

import bee.vanillish.Vanillish;
import bee.vanillish.block.AlgaeBlock;
import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishItems;
import bee.vanillish.registry.VanillishModelTemplates;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.core.Direction;
import net.minecraft.data.BlockFamily;
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

        blockModelGenerators.createTrivialBlock(VanillishBlocks.CHISELED_DARK_SANDSTONE, block -> TexturedModel.TOP_BOTTOM_WITH_WALL.get(VanillishBlocks.SMOOTH_DARK_SANDSTONE).updateTextures(m -> m.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block))));
        blockModelGenerators.createTrivialCube(VanillishBlocks.DARK_SILT);
        blockModelGenerators.createTrivialCube(VanillishBlocks.DEEP_GRIT);



        blockModelGenerators.family(VanillishBlocks.SMOOTH_DARK_SANDSTONE)
                .stairs(VanillishBlocks.SMOOTH_DARK_SANDSTONE_STAIRS)
                .slab(VanillishBlocks.SMOOTH_DARK_SANDSTONE_SLAB)
                .wall(VanillishBlocks.SMOOTH_DARK_SANDSTONE_WALL);

        blockModelGenerators.family(VanillishBlocks.DARK_SANDSTONE)
                .stairs(VanillishBlocks.DARK_SANDSTONE_STAIRS)
                .slab(VanillishBlocks.DARK_SANDSTONE_SLAB)
                .wall(VanillishBlocks.DARK_SANDSTONE_WALL);

        blockModelGenerators.family(VanillishBlocks.CUT_DARK_SANDSTONE)
                        .slab(VanillishBlocks.CUT_DARK_SANDSTONE_SLAB);



        blockModelGenerators.createActiveRail(VanillishBlocks.ADVANCED_POWERED_RAIL);
        this.createDirectionalRail(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL, blockModelGenerators);
        blockModelGenerators.createPassiveRail(VanillishBlocks.ADVANCED_RAIL);
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
        blockModelGenerators.family(VanillishBlocks.BRASS_BRICKS).slab(VanillishBlocks.BRASS_BRICK_SLAB).stairs(VanillishBlocks.BRASS_BRICK_STAIRS);
        blockModelGenerators.family(VanillishBlocks.BRASS_TILES).slab(VanillishBlocks.BRASS_TILE_SLAB).stairs(VanillishBlocks.BRASS_TILE_STAIRS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BRASS_GRATE);
        this.createScaffolding(VanillishBlocks.BRASS_SCAFFOLDING, blockModelGenerators);

        blockModelGenerators.createTrivialCube(VanillishBlocks.CARVED_ROSE_GOLD);
        createLadder(VanillishBlocks.ROSE_GOLD_LADDER, blockModelGenerators);
        createChain(VanillishBlocks.ROSE_GOLD_CHAIN, blockModelGenerators);
        blockModelGenerators.createLantern(VanillishBlocks.ROSE_GOLD_LANTERN);
        blockModelGenerators.createNormalTorch(VanillishBlocks.ROSE_GOLD_TORCH, VanillishBlocks.ROSE_GOLD_WALL_TORCH);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.ROSE_GOLD_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.ROSE_GOLD_BLOCK);
        blockModelGenerators.createTrivialCube(VanillishBlocks.ROSE_GOLD_GRATE);
        blockModelGenerators.family(VanillishBlocks.ROSE_GOLD_TILES).slab(VanillishBlocks.ROSE_GOLD_TILE_SLAB).stairs(VanillishBlocks.ROSE_GOLD_TILE_STAIRS);
        this.createScaffolding(VanillishBlocks.ROSE_GOLD_SCAFFOLDING, blockModelGenerators);

        createLadder(VanillishBlocks.STEEL_LADDER, blockModelGenerators);
        createChain(VanillishBlocks.STEEL_CHAIN, blockModelGenerators);
        blockModelGenerators.createLantern(VanillishBlocks.STEEL_LANTERN);
        blockModelGenerators.createNormalTorch(VanillishBlocks.STEEL_TORCH, VanillishBlocks.STEEL_WALL_TORCH);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.STEEL_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.STEEL_BLOCK);
        blockModelGenerators.createTrivialCube(VanillishBlocks.STEEL_GRATE);
        blockModelGenerators.family(VanillishBlocks.STEEL_BRICKS).slab(VanillishBlocks.STEEL_BRICK_SLAB).stairs(VanillishBlocks.STEEL_BRICK_STAIRS);
        blockModelGenerators.family(VanillishBlocks.STEEL_TILES).slab(VanillishBlocks.STEEL_TILE_SLAB).stairs(VanillishBlocks.STEEL_TILE_STAIRS);
        this.createScaffolding(VanillishBlocks.STEEL_SCAFFOLDING, blockModelGenerators);

        blockModelGenerators.createTrivialCube(VanillishBlocks.CARVED_SCRAP_METAL);
        blockModelGenerators.createTrivialCube(VanillishBlocks.SCRAP_METAL);
        createLadder(VanillishBlocks.SCRAP_METAL_LADDER, blockModelGenerators);
        createChain(VanillishBlocks.SCRAP_METAL_CHAIN, blockModelGenerators);
        blockModelGenerators.createLantern(VanillishBlocks.SCRAP_METAL_LANTERN);
        blockModelGenerators.createNormalTorch(VanillishBlocks.SCRAP_METAL_TORCH, VanillishBlocks.SCRAP_METAL_WALL_TORCH);
        blockModelGenerators.createBarsAndItem(VanillishBlocks.SCRAP_METAL_BARS);
        blockModelGenerators.createTrivialCube(VanillishBlocks.SCRAP_METAL_GRATE);
        blockModelGenerators.family(VanillishBlocks.SCRAP_METAL_BRICKS).slab(VanillishBlocks.SCRAP_METAL_BRICK_SLAB).stairs(VanillishBlocks.SCRAP_METAL_BRICK_STAIRS);
        blockModelGenerators.family(VanillishBlocks.SCRAP_METAL_TILES).slab(VanillishBlocks.SCRAP_METAL_TILE_SLAB).stairs(VanillishBlocks.SCRAP_METAL_TILE_STAIRS);

        blockModelGenerators.createDoor(VanillishBlocks.SCRAP_METAL_DOOR);
        blockModelGenerators.createTrapdoor(VanillishBlocks.SCRAP_METAL_TRAPDOOR);

        createAlgae(VanillishBlocks.ALGAE, blockModelGenerators);
        blockModelGenerators.createTrivialCube(VanillishBlocks.BLOCK_OF_KELP);
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

    public void createDirectionalRail(Block block, BlockModelGenerators generators) {
        MultiVariant multiVariant = plainVariant(generators.createSuffixedVariant(block, "", ModelTemplates.RAIL_FLAT, TextureMapping::rail));
        MultiVariant multiVariant2 = plainVariant(generators.createSuffixedVariant(block, "", ModelTemplates.RAIL_RAISED_NE, TextureMapping::rail));
        MultiVariant multiVariant3 = plainVariant(generators.createSuffixedVariant(block, "", ModelTemplates.RAIL_RAISED_SW, TextureMapping::rail));
        MultiVariant multiVariant4 = plainVariant(generators.createSuffixedVariant(block, "_on", ModelTemplates.RAIL_FLAT, TextureMapping::rail));
        MultiVariant multiVariant5 = plainVariant(generators.createSuffixedVariant(block, "_on", ModelTemplates.RAIL_RAISED_NE, TextureMapping::rail));
        MultiVariant multiVariant6 = plainVariant(generators.createSuffixedVariant(block, "_on", ModelTemplates.RAIL_RAISED_SW, TextureMapping::rail));
        generators.registerSimpleFlatItemModel(block);
        generators.blockStateOutput
                .accept(
                        MultiVariantGenerator.dispatch(block)
                                .with(PropertyDispatch.initial(BlockStateProperties.POWERED, BlockStateProperties.RAIL_SHAPE_STRAIGHT, BlockStateProperties.INVERTED).generate((boolean_, railShape, inverted) -> {
                                    MultiVariant variant = switch (railShape) {
                                        case NORTH_SOUTH -> {
                                            var temp = boolean_ ? multiVariant4 : multiVariant;
                                            if (!inverted) temp = temp.with(Y_ROT_180);
                                            yield temp;
                                        }
                                        case EAST_WEST -> {
                                            var temp = (boolean_ ? multiVariant4 : multiVariant).with(Y_ROT_90);
                                            if (inverted) temp = temp.with(Y_ROT_270);
                                            yield temp;
                                        }
                                        case ASCENDING_EAST -> {
                                            var temp = (boolean_ ? multiVariant5 : multiVariant2).with(Y_ROT_90);
                                            if (inverted) temp = temp.with(Y_ROT_270);
                                            yield temp;
                                        }
                                        case ASCENDING_WEST -> {
                                            var temp = (boolean_ ? multiVariant6 : multiVariant3).with(Y_ROT_90);
                                            if (inverted) temp = temp.with(Y_ROT_270);
                                            yield temp;
                                        }
                                        case ASCENDING_NORTH -> {
                                            var temp = boolean_ ? multiVariant5 : multiVariant2;
                                            if (!inverted) temp = temp.with(Y_ROT_180);
                                            yield temp;
                                        }
                                        case ASCENDING_SOUTH -> {
                                            var temp = boolean_ ? multiVariant6 : multiVariant3;
                                            if (!inverted) temp = temp.with(Y_ROT_180);
                                            yield temp;
                                        }
                                        default -> throw new UnsupportedOperationException("Fix you generator!");
                                    };

                                    return variant;
                                }))
                );


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


        generators.registerSimpleFlatItemModel(block);
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

        itemModelGenerators.generateFlatItem(VanillishItems.BRASS_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(VanillishItems.ROSE_GOLD_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(VanillishItems.STEEL_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(VanillishItems.STEEL_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(VanillishItems.BRASS_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(VanillishItems.ROSE_GOLD_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(VanillishItems.SCRAP_METAL_SHARD, ModelTemplates.FLAT_ITEM);

    }
}
