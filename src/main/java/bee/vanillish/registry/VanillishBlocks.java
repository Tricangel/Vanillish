package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.block.*;
import bee.vanillish.item.MetalScaffoldingItem;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.function.Function;

public class VanillishBlocks {

    //Components
    public static final Block BLAST_CHAMBER = register("blast_chamber", BlastChamberBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE), true);
    public static final Block WARDING_STONE = register("warding_stone", WardingStoneBlock::new, BlockBehaviour.Properties.of(), true);
    public static final Block REDSTONE_RANDOMIZER = register("redstone_randomizer", RedstoneRandomizer::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK), true);

    //Brass family

    public static final Block BRASS_BLOCK = register("brass_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block BRASS_BRICKS = register("brass_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block BRASS_GRATE = register("brass_grate", WaterloggedTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE), true);
    public static final Block BRASS_TILES = register("brass_tiles", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block BRASS_BARS = register("brass_bars", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS), true);
    public static final Block BRASS_CHAIN = register("brass_chain", ChainBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN), true);
    public static final Block BRASS_LANTERN = register("brass_lantern", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), true);
    public static final Block BRASS_TORCH = register("brass_torch", properties -> new TorchBlock(ParticleTypes.FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block BRASS_WALL_TORCH = register("brass_wall_torch", properties -> new WallTorchBlock(ParticleTypes.FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block BRASS_LADDER = register("brass_ladder", MetalLadderBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER), true);
    public static final Block BRASS_SCAFFOLDING = registerScaffolding("brass_scaffolding", MetalScaffolding::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCAFFOLDING));

    public static final Block CARVED_ROSE_GOLD = register("carved_rose_gold", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block ROSE_GOLD_BLOCK = register("rose_gold_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block ROSE_GOLD_GRATE = register("rose_gold_grate", WaterloggedTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE), true);
    public static final Block ROSE_GOLD_TILES = register("rose_gold_tiles", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block ROSE_GOLD_BARS = register("rose_gold_bars", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS), true);
    public static final Block ROSE_GOLD_CHAIN = register("rose_gold_chain", ChainBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN), true);
    public static final Block ROSE_GOLD_LANTERN = register("rose_gold_lantern", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), true);
    public static final Block ROSE_GOLD_TORCH = register("rose_gold_torch", properties -> new TorchBlock(ParticleTypes.FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block ROSE_GOLD_WALL_TORCH = register("rose_gold_wall_torch", properties -> new WallTorchBlock(ParticleTypes.FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block ROSE_GOLD_LADDER = register("rose_gold_ladder", MetalLadderBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER), true);
    public static final Block ROSE_GOLD_SCAFFOLDING = registerScaffolding("rose_gold_scaffolding", MetalScaffolding::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCAFFOLDING));

    public static final Block CARVED_STEEL = register("carved_steel", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block STEEL_BLOCK = register("steel_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block STEEL_GRATE = register("steel_grate", WaterloggedTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE), true);
    public static final Block STEEL_TILES = register("steel_tiles", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block STEEL_BARS = register("steel_bars", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS), true);
    public static final Block STEEL_CHAIN = register("steel_chain", ChainBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN), true);
    public static final Block STEEL_LANTERN = register("steel_lantern", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), true);
    public static final Block STEEL_TORCH = register("steel_torch", properties -> new TorchBlock(ParticleTypes.FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block STEEL_WALL_TORCH = register("steel_wall_torch", properties -> new WallTorchBlock(ParticleTypes.FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block STEEL_LADDER = register("steel_ladder", MetalLadderBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER), true);
    public static final Block STEEL_SCAFFOLDING = registerScaffolding("steel_scaffolding", MetalScaffolding::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCAFFOLDING));

    public static final Block CARVED_SCRAP_METAL = register("carved_scrap_metal", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block SCRAP_METAL_BLOCK = register("scrap_metal_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block SCRAP_METAL_BRICKS = register("scrap_metal_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block SCRAP_METAL_GRATE = register("scrap_metal_grate", WaterloggedTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE), true);
    public static final Block SCRAP_METAL_TILES = register("scrap_metal_tiles", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block SCRAP_METAL_BARS = register("scrap_metal_bars", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS), true);
    public static final Block SCRAP_METAL_CHAIN = register("scrap_metal_chain", ChainBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_CHAIN), true);
    public static final Block SCRAP_METAL_LANTERN = register("scrap_metal_lantern", LanternBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LANTERN), true);
    public static final Block SCRAP_METAL_TORCH = register("scrap_metal_torch", properties -> new TorchBlock(ParticleTypes.FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block SCRAP_METAL_WALL_TORCH = register("scrap_metal_wall_torch", properties -> new WallTorchBlock(ParticleTypes.FLAME, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH), false);
    public static final Block SCRAP_METAL_LADDER = register("scrap_metal_ladder", MetalLadderBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LADDER), true);
    //public static final Block SCRAP_METAL_SCAFFOLDING = registerScaffolding("scrap_metal_scaffolding", MetalScaffolding::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCAFFOLDING));

    public static final Block SCRAP_METAL_DOOR = register("carved_scrap_door", properties -> new DoorBlock(new BlockSetType("scrap_metal"), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR), true);
    public static final Block SCRAP_METAL_TRAPDOOR = register("carved_scrap_trapdoor", properties -> new TrapDoorBlock(new BlockSetType("scrap_metal"), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR), true);


    //public static final WeatheringCopperBlocks COPPER_SCAFFOLDING = WeatheringCopperBlocks.create("copper_scaffolding", VanillishBlocks::registerScaffolding, MetalScaffolding::new, WeatheringCopperScaffolding::new, p -> BlockBehaviour.Properties.ofFullCopy(VanillishBlocks.BRASS_SCAFFOLDING));

    //Brass components

    public static final Block ADVANCED_RAIL = register("advanced_rail", PoweredRailBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POWERED_RAIL), true);
    public static final Block ADVANCED_STOP_RAIL = register("advanced_stop_rail", PoweredRailBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POWERED_RAIL), true);
    //add function to this
    public static final Block ADVANCED_BOUNCY_RAIL = register("advanced_bouncy_rail", PoweredRailBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POWERED_RAIL), true);
    //...
    public static final Block ADVANCED_DIRECTIONAL_RAIL = register("advanced_directional_rail", DirectionalRailBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POWERED_RAIL), true);
    public static final Block ADVANCED_DETECTOR_RAIL = register("advanced_detector_rail", DetectorRailBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.DETECTOR_RAIL), true);






    //Wood

    public static final BlockSetType CHARRED_WOOD_SET_TYPE = new BlockSetType("charred_wood");
    public static final WoodType CHARRED_WOOD_TYPE = new WoodType("charred_wood", CHARRED_WOOD_SET_TYPE);

    public static final Block CHARRED_LOG = register("charred_log", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG), true);
    public static final Block CHARRED_WOOD = register("charred_wood", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD), true);
    public static final Block STRIPPED_CHARRED_LOG = register("stripped_charred_log", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LOG), true);
    public static final Block STRIPPED_CHARRED_WOOD = register("stripped_charred_wood", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD), true);
    public static final Block CHARRED_PLANKS = register("charred_planks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS), true);
    public static final Block CHARRED_STAIRS = register("charred_stairs", properties -> new StairBlock(CHARRED_PLANKS.defaultBlockState(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_STAIRS), true);
    public static final Block CHARRED_SLAB = register("charred_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SLAB), true);
    public static final Block CHARRED_PRESSURE_PLATE = register("charred_pressure_plate", properties -> new PressurePlateBlock(CHARRED_WOOD_SET_TYPE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PRESSURE_PLATE), true);
    public static final Block CHARRED_BUTTON = register("charred_button", properties -> new ButtonBlock(CHARRED_WOOD_SET_TYPE, 30, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_BUTTON), true);
    public static final Block CHARRED_FENCE = register("charred_fence", FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE), true);
    public static final Block CHARRED_FENCE_GATE = register("charred_fence_gate", properties -> new FenceGateBlock(CHARRED_WOOD_TYPE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_FENCE_GATE), true);
    public static final Block CHARRED_SHELF = register("charred_shelf", ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SHELF), true);
    public static final Block CHARRED_DOOR = register("charred_door", properties -> new DoorBlock(CHARRED_WOOD_SET_TYPE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_DOOR), true);
    public static final Block CHARRED_TRAPDOOR = register("charred_trapdoor", properties -> new TrapDoorBlock(CHARRED_WOOD_SET_TYPE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_TRAPDOOR), true);

    //Vegetation

    public static final Block BLOCK_OF_KELP = register("block_of_kelp", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.KELP), true);

    //Water Vegetation
    public static final Block ALGAE = register("algae", AlgaeBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK), false);
    public static final Block DUCKWEED = register("duckweed", FloatingWaterBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK), false);














    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return registerScaffolding(name, factory, properties);
    }

    private static Block registerScaffolding(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        ResourceKey<Item> itemKey = keyOfItem(name);
        BlockItem blockItem = new MetalScaffoldingItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Vanillish.id(name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Vanillish.id(name));
    }

    public static void init() {
    }

}
