package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class VanillishBlockLoot extends FabricBlockLootTableProvider {
    public VanillishBlockLoot(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        
        dropSelf(VanillishBlocks.CHARRED_BUTTON);
        dropSelf(VanillishBlocks.CHARRED_DOOR);
        dropSelf(VanillishBlocks.CHARRED_LOG);
        dropSelf(VanillishBlocks.CHARRED_FENCE);
        dropSelf(VanillishBlocks.CHARRED_PLANKS);
        dropSelf(VanillishBlocks.CHARRED_SHELF);
        dropSelf(VanillishBlocks.CHARRED_SLAB);
        dropSelf(VanillishBlocks.CHARRED_WOOD);
        dropSelf(VanillishBlocks.CHARRED_FENCE_GATE);
        dropSelf(VanillishBlocks.CHARRED_PRESSURE_PLATE);
        dropSelf(VanillishBlocks.CHARRED_STAIRS);
        dropSelf(VanillishBlocks.CHARRED_TRAPDOOR);
        
        dropSelf(VanillishBlocks.ADVANCED_RAIL);
        dropSelf(VanillishBlocks.ADVANCED_POWERED_RAIL);
        dropSelf(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL);
        dropSelf(VanillishBlocks.ADVANCED_STOP_RAIL);
        dropSelf(VanillishBlocks.ADVANCED_BOUNCY_RAIL);
        dropSelf(VanillishBlocks.ADVANCED_DETECTOR_RAIL);
        dropSelf(VanillishBlocks.BLOCK_OF_KELP);
        dropSelf(VanillishBlocks.BLAST_CHAMBER);
        dropSelf(VanillishBlocks.WARDING_STONE);
        dropSelf(VanillishBlocks.REDSTONE_RANDOMIZER);

        dropSelf(VanillishBlocks.ROSE_GOLD_BLOCK);
        dropSelf(VanillishBlocks.ROSE_GOLD_GRATE);
        dropSelf(VanillishBlocks.ROSE_GOLD_TILES);
        dropSelf(VanillishBlocks.ROSE_GOLD_TILE_STAIRS);
        dropSelf(VanillishBlocks.ROSE_GOLD_TILE_SLAB);
        dropSelf(VanillishBlocks.ROSE_GOLD_BARS);
        dropSelf(VanillishBlocks.ROSE_GOLD_CHAIN);
        dropSelf(VanillishBlocks.ROSE_GOLD_LANTERN);
        dropSelf(VanillishBlocks.ROSE_GOLD_LADDER);
        dropSelf(VanillishBlocks.ROSE_GOLD_SCAFFOLDING);
        dropOther(VanillishBlocks.ROSE_GOLD_TORCH, VanillishItems.ROSE_GOLD_TORCH);
        dropOther(VanillishBlocks.ROSE_GOLD_WALL_TORCH, VanillishItems.ROSE_GOLD_TORCH);

        dropSelf(VanillishBlocks.BRASS_BLOCK);
        dropSelf(VanillishBlocks.BRASS_BRICKS);
        dropSelf(VanillishBlocks.BRASS_BRICK_STAIRS);
        dropSelf(VanillishBlocks.BRASS_BRICK_SLAB);
        dropSelf(VanillishBlocks.BRASS_GRATE);
        dropSelf(VanillishBlocks.BRASS_TILES);
        dropSelf(VanillishBlocks.BRASS_TILE_STAIRS);
        dropSelf(VanillishBlocks.BRASS_TILE_SLAB);
        dropSelf(VanillishBlocks.BRASS_BARS);
        dropSelf(VanillishBlocks.BRASS_CHAIN);
        dropSelf(VanillishBlocks.BRASS_LANTERN);
        dropSelf(VanillishBlocks.BRASS_LADDER);
        dropSelf(VanillishBlocks.BRASS_SCAFFOLDING);
        dropOther(VanillishBlocks.BRASS_TORCH, VanillishItems.BRASS_TORCH);
        dropOther(VanillishBlocks.BRASS_WALL_TORCH, VanillishItems.BRASS_TORCH);

        dropSelf(VanillishBlocks.STEEL_BLOCK);
        dropSelf(VanillishBlocks.CARVED_SCRAP_METAL);
        dropSelf(VanillishBlocks.CARVED_ROSE_GOLD);
        dropSelf(VanillishBlocks.STEEL_BRICKS);
        dropSelf(VanillishBlocks.STEEL_BRICK_STAIRS);
        dropSelf(VanillishBlocks.STEEL_BRICK_SLAB);
        dropSelf(VanillishBlocks.STEEL_GRATE);
        dropSelf(VanillishBlocks.STEEL_TILES);
        dropSelf(VanillishBlocks.STEEL_TILE_STAIRS);
        dropSelf(VanillishBlocks.STEEL_TILE_SLAB);
        dropSelf(VanillishBlocks.STEEL_BARS);
        dropSelf(VanillishBlocks.STEEL_CHAIN);
        dropSelf(VanillishBlocks.STEEL_LANTERN);
        dropSelf(VanillishBlocks.STEEL_LADDER);
        dropSelf(VanillishBlocks.STEEL_SCAFFOLDING);
        dropOther(VanillishBlocks.STEEL_TORCH, VanillishItems.STEEL_TORCH);
        dropOther(VanillishBlocks.STEEL_WALL_TORCH, VanillishItems.STEEL_TORCH);

        add(VanillishBlocks.SCRAP_METAL_DOOR, createDoorTable(VanillishBlocks.SCRAP_METAL_DOOR));
        dropSelf(VanillishBlocks.SCRAP_METAL_BRICKS);
        dropSelf(VanillishBlocks.SCRAP_METAL_BRICK_STAIRS);
        dropSelf(VanillishBlocks.SCRAP_METAL_BRICK_SLAB);
        dropSelf(VanillishBlocks.SCRAP_METAL_GRATE);
        dropSelf(VanillishBlocks.SCRAP_METAL_TILES);
        dropSelf(VanillishBlocks.SCRAP_METAL_TILE_STAIRS);
        dropSelf(VanillishBlocks.SCRAP_METAL_TILE_SLAB);
        dropSelf(VanillishBlocks.SCRAP_METAL_BARS);
        dropSelf(VanillishBlocks.SCRAP_METAL_CHAIN);
        dropSelf(VanillishBlocks.SCRAP_METAL_LANTERN);
        dropSelf(VanillishBlocks.SCRAP_METAL_LADDER);
        dropSelf(VanillishBlocks.SCRAP_METAL_TRAPDOOR);
        dropOther(VanillishBlocks.SCRAP_METAL_TORCH, VanillishItems.SCRAP_METAL_TORCH);
        dropOther(VanillishBlocks.SCRAP_METAL_WALL_TORCH, VanillishItems.SCRAP_METAL_TORCH);

        add(VanillishBlocks.ALGAE, createShearsOrSilkTouchOnlyDrop(VanillishItems.ALGAE));
        add(VanillishBlocks.DUCKWEED, createShearsOrSilkTouchOnlyDrop(VanillishItems.DUCKWEED));
    }
}
