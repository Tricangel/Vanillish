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

        add(VanillishBlocks.STONE_PABBLE, createMultifaceBlockDrops(VanillishBlocks.TUFF_PABBLE));
        add(VanillishBlocks.BASALT_PABBLE, createMultifaceBlockDrops(VanillishBlocks.BASALT_PABBLE));
        add(VanillishBlocks.DEEPSLATE_PABBLE, createMultifaceBlockDrops(VanillishBlocks.DEEPSLATE_PABBLE));
        add(VanillishBlocks.BLACKSTONE_PABBLE, createMultifaceBlockDrops(VanillishBlocks.BLACKSTONE_PABBLE));
        add(VanillishBlocks.CALCITE_PABBLE, createMultifaceBlockDrops(VanillishBlocks.CALCITE_PABBLE));
        add(VanillishBlocks.DIORITE_PABBLE, createMultifaceBlockDrops(VanillishBlocks.DIORITE_PABBLE));
        add(VanillishBlocks.DRIPSTONE_PABBLE, createMultifaceBlockDrops(VanillishBlocks.DRIPSTONE_PABBLE));
        add(VanillishBlocks.GRANITE_PABBLE, createMultifaceBlockDrops(VanillishBlocks.GRANITE_PABBLE));
        add(VanillishBlocks.NETHERRACK_PABBLE, createMultifaceBlockDrops(VanillishBlocks.NETHERRACK_PABBLE));
        dropSelf(VanillishBlocks.GAZER);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_BUTTON);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_DOOR);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_LOG);
        createMultifaceBlockDrops(VanillishBlocks.STRIPPED_CHARRED_LOG);
        createMultifaceBlockDrops(VanillishBlocks.STRIPPED_CHARRED_WOOD);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_FENCE);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_PLANKS);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_SHELF);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_SLAB);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_WOOD);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_FENCE_GATE);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_PRESSURE_PLATE);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_STAIRS);
        createMultifaceBlockDrops(VanillishBlocks.CHARRED_TRAPDOOR);
        
        createMultifaceBlockDrops(VanillishBlocks.ADVANCED_RAIL);
        createMultifaceBlockDrops(VanillishBlocks.ADVANCED_POWERED_RAIL);
        createMultifaceBlockDrops(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL);
        createMultifaceBlockDrops(VanillishBlocks.ADVANCED_STOP_RAIL);
        createMultifaceBlockDrops(VanillishBlocks.ADVANCED_BOUNCY_RAIL);
        createMultifaceBlockDrops(VanillishBlocks.ADVANCED_DETECTOR_RAIL);
        createMultifaceBlockDrops(VanillishBlocks.BLOCK_OF_KELP);
        createMultifaceBlockDrops(VanillishBlocks.BLAST_CHAMBER);
        createMultifaceBlockDrops(VanillishBlocks.WARDING_STONE);
        createMultifaceBlockDrops(VanillishBlocks.REDSTONE_RANDOMIZER);

        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_BLOCK);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_GRATE);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_TILES);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_TILE_STAIRS);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_TILE_SLAB);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_BARS);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_CHAIN);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_LANTERN);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_LADDER);
        createMultifaceBlockDrops(VanillishBlocks.ROSE_GOLD_SCAFFOLDING);
        dropOther(VanillishBlocks.ROSE_GOLD_TORCH, VanillishItems.ROSE_GOLD_TORCH);
        dropOther(VanillishBlocks.ROSE_GOLD_WALL_TORCH, VanillishItems.ROSE_GOLD_TORCH);

        createMultifaceBlockDrops(VanillishBlocks.BRASS_BLOCK);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_BRICKS);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_BRICK_STAIRS);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_BRICK_SLAB);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_GRATE);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_TILES);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_TILE_STAIRS);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_TILE_SLAB);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_BARS);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_CHAIN);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_LANTERN);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_LADDER);
        createMultifaceBlockDrops(VanillishBlocks.BRASS_SCAFFOLDING);
        dropOther(VanillishBlocks.BRASS_TORCH, VanillishItems.BRASS_TORCH);
        dropOther(VanillishBlocks.BRASS_WALL_TORCH, VanillishItems.BRASS_TORCH);

        createMultifaceBlockDrops(VanillishBlocks.STEEL_BLOCK);
        createMultifaceBlockDrops(VanillishBlocks.CARVED_SCRAP_METAL);
        createMultifaceBlockDrops(VanillishBlocks.CARVED_ROSE_GOLD);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_BRICKS);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_BRICK_STAIRS);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_BRICK_SLAB);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_GRATE);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_TILES);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_TILE_STAIRS);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_TILE_SLAB);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_BARS);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_CHAIN);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_LANTERN);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_LADDER);
        createMultifaceBlockDrops(VanillishBlocks.STEEL_SCAFFOLDING);
        dropOther(VanillishBlocks.STEEL_TORCH, VanillishItems.STEEL_TORCH);
        dropOther(VanillishBlocks.STEEL_WALL_TORCH, VanillishItems.STEEL_TORCH);

        add(VanillishBlocks.SCRAP_METAL_DOOR, createDoorTable(VanillishBlocks.SCRAP_METAL_DOOR));
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_BRICKS);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_BRICK_STAIRS);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_BRICK_SLAB);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_GRATE);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_TILES);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_TILE_STAIRS);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_TILE_SLAB);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_BARS);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_CHAIN);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_LANTERN);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_LADDER);
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_TRAPDOOR);
        dropOther(VanillishBlocks.SCRAP_METAL_TORCH, VanillishItems.SCRAP_METAL_TORCH);
        dropOther(VanillishBlocks.SCRAP_METAL_WALL_TORCH, VanillishItems.SCRAP_METAL_TORCH);

        add(VanillishBlocks.ALGAE, createShearsOrSilkTouchOnlyDrop(VanillishItems.ALGAE));
        add(VanillishBlocks.DUCKWEED, createShearsOrSilkTouchOnlyDrop(VanillishItems.DUCKWEED));
    }
}
