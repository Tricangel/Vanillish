package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishItems;
import bee.vanillish.registry.VanillishTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class VanillishBlockTagGen extends FabricTagProvider.BlockTagProvider {
    public VanillishBlockTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {


        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(VanillishBlocks.CHARRED_BUTTON)
                .add(VanillishBlocks.CHARRED_DOOR)
                .add(VanillishBlocks.CHARRED_LOG)
                .add(VanillishBlocks.CHARRED_FENCE)
                .add(VanillishBlocks.CHARRED_PLANKS)
                .add(VanillishBlocks.CHARRED_SHELF)
                .add(VanillishBlocks.CHARRED_SLAB)
                .add(VanillishBlocks.CHARRED_WOOD)
                .add(VanillishBlocks.CHARRED_FENCE_GATE)
                .add(VanillishBlocks.CHARRED_PRESSURE_PLATE)
                .add(VanillishBlocks.CHARRED_STAIRS)
                .add(VanillishBlocks.CHARRED_TRAPDOOR);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(VanillishBlocks.BLAST_CHAMBER)
        .add(VanillishBlocks.WARDING_STONE)
        .add(VanillishBlocks.REDSTONE_RANDOMIZER)

        .add(VanillishBlocks.ROSE_GOLD_BLOCK)
        .add(VanillishBlocks.ROSE_GOLD_GRATE)
        .add(VanillishBlocks.ROSE_GOLD_TILES)
        .add(VanillishBlocks.ROSE_GOLD_TILE_STAIRS)
        .add(VanillishBlocks.ROSE_GOLD_TILE_SLAB)
        .add(VanillishBlocks.ROSE_GOLD_BARS)
        .add(VanillishBlocks.ROSE_GOLD_CHAIN)
        .add(VanillishBlocks.ROSE_GOLD_LANTERN)
        .add(VanillishBlocks.ROSE_GOLD_LADDER)
        .add(VanillishBlocks.ROSE_GOLD_SCAFFOLDING)

        .add(VanillishBlocks.BRASS_BLOCK)
        .add(VanillishBlocks.BRASS_BRICKS)
        .add(VanillishBlocks.BRASS_BRICK_STAIRS)
        .add(VanillishBlocks.BRASS_BRICK_SLAB)
        .add(VanillishBlocks.BRASS_GRATE)
        .add(VanillishBlocks.BRASS_TILES)
        .add(VanillishBlocks.BRASS_TILE_STAIRS)
        .add(VanillishBlocks.BRASS_TILE_SLAB)
        .add(VanillishBlocks.BRASS_BARS)
        .add(VanillishBlocks.BRASS_CHAIN)
        .add(VanillishBlocks.BRASS_LANTERN)
        .add(VanillishBlocks.BRASS_LADDER)
        .add(VanillishBlocks.BRASS_SCAFFOLDING)

        .add(VanillishBlocks.STEEL_BLOCK)
        .add(VanillishBlocks.CARVED_SCRAP_METAL)
        .add(VanillishBlocks.CARVED_ROSE_GOLD)
        .add(VanillishBlocks.STEEL_BRICKS)
        .add(VanillishBlocks.STEEL_BRICK_STAIRS)
        .add(VanillishBlocks.STEEL_BRICK_SLAB)
        .add(VanillishBlocks.STEEL_GRATE)
        .add(VanillishBlocks.STEEL_TILES)
        .add(VanillishBlocks.STEEL_TILE_STAIRS)
        .add(VanillishBlocks.STEEL_TILE_SLAB)
        .add(VanillishBlocks.STEEL_BARS)
        .add(VanillishBlocks.STEEL_CHAIN)
        .add(VanillishBlocks.STEEL_LANTERN)
        .add(VanillishBlocks.STEEL_LADDER)
        .add(VanillishBlocks.STEEL_SCAFFOLDING)

                .add(VanillishBlocks.SCRAP_METAL_DOOR)
        .add(VanillishBlocks.SCRAP_METAL_BRICKS)
        .add(VanillishBlocks.SCRAP_METAL_BRICK_STAIRS)
        .add(VanillishBlocks.SCRAP_METAL_BRICK_SLAB)
        .add(VanillishBlocks.SCRAP_METAL_GRATE)
        .add(VanillishBlocks.SCRAP_METAL_TILES)
        .add(VanillishBlocks.SCRAP_METAL_TILE_STAIRS)
        .add(VanillishBlocks.SCRAP_METAL_TILE_SLAB)
        .add(VanillishBlocks.SCRAP_METAL_BARS)
        .add(VanillishBlocks.SCRAP_METAL_CHAIN)
        .add(VanillishBlocks.SCRAP_METAL_LANTERN)
        .add(VanillishBlocks.SCRAP_METAL_LADDER)
        .add(VanillishBlocks.SCRAP_METAL_TRAPDOOR);


        valueLookupBuilder(BlockTags.RAILS)
                .add(VanillishBlocks.ADVANCED_RAIL)
                .add(VanillishBlocks.ADVANCED_STOP_RAIL)
                .add(VanillishBlocks.ADVANCED_DETECTOR_RAIL)
                .add(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL)
                .add(VanillishBlocks.ADVANCED_BOUNCY_RAIL)
                .add(VanillishBlocks.ADVANCED_POWERED_RAIL);

        valueLookupBuilder(VanillishTags.ADVANCED_RAILS)
                .add(VanillishBlocks.ADVANCED_RAIL)
                .add(VanillishBlocks.ADVANCED_STOP_RAIL)
                .add(VanillishBlocks.ADVANCED_DETECTOR_RAIL)
                .add(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL)
                .add(VanillishBlocks.ADVANCED_BOUNCY_RAIL)
                .add(VanillishBlocks.ADVANCED_POWERED_RAIL);

        valueLookupBuilder(BlockTags.CLIMBABLE)
                .add(VanillishBlocks.BRASS_LADDER)
                .add(VanillishBlocks.ROSE_GOLD_LADDER)
                .add(VanillishBlocks.SCRAP_METAL_LADDER)
                .add(VanillishBlocks.STEEL_LADDER)
                .add(VanillishBlocks.ROSE_GOLD_SCAFFOLDING)
                .add(VanillishBlocks.STEEL_SCAFFOLDING)
                .add(VanillishBlocks.BRASS_SCAFFOLDING);

        valueLookupBuilder(VanillishTags.SCAFFOLDING)
                .add(VanillishBlocks.ROSE_GOLD_SCAFFOLDING)
                .add(VanillishBlocks.STEEL_SCAFFOLDING)
                .add(VanillishBlocks.BRASS_SCAFFOLDING)
                .add(Blocks.SCAFFOLDING);
    }
}
