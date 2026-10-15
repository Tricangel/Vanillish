package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishItems;
import bee.vanillish.util.BlockFamilyHelper;
import bee.vanillish.util.VanillishBlockFamily;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.concurrent.CompletableFuture;

public class VanillishBlockLoot extends FabricBlockLootTableProvider {
    public VanillishBlockLoot(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        BlockFamilyHelper.families.forEach(family -> {
            family.blocks.forEach((variant, block) -> {
                if (variant.equals(VanillishBlockFamily.Variant.SLAB)) add(block, createSlabItemTable(block));
                else dropSelf(block);
            });
        });

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
        VanillishBlocks.COPPER_SCAFFOLDING.forEach(this::dropSelf);
        dropSelf(VanillishBlocks.CHARRED_BUTTON);
        dropSelf(VanillishBlocks.CHARRED_DOOR);
        dropSelf(VanillishBlocks.CHARRED_LOG);
        dropSelf(VanillishBlocks.STRIPPED_CHARRED_LOG);
        dropSelf(VanillishBlocks.STRIPPED_CHARRED_WOOD);
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
        createMultifaceBlockDrops(VanillishBlocks.SCRAP_METAL_TRAPDOOR);
        dropOther(VanillishBlocks.SCRAP_METAL_TORCH, VanillishItems.SCRAP_METAL_TORCH);
        dropOther(VanillishBlocks.SCRAP_METAL_WALL_TORCH, VanillishItems.SCRAP_METAL_TORCH);

//        dropSelf(VanillishBlocks.SCORCH_STONE);
//        dropSelf(VanillishBlocks.SCORCH_STONE_STAIRS);
//        dropSelf(VanillishBlocks.SCORCH_STONE_SLAB);
//        dropSelf(VanillishBlocks.SCORCH_STONE_WALL);
//
//        dropSelf(VanillishBlocks.SMOOTH_SCORCH_STONE);
//        dropSelf(VanillishBlocks.SMOOTH_SCORCH_STONE_STAIRS);
//        dropSelf(VanillishBlocks.SMOOTH_SCORCH_STONE_SLAB);
//        dropSelf(VanillishBlocks.SMOOTH_SCORCH_STONE_WALL);
//
//        dropSelf(VanillishBlocks.POLISHED_SCORCH_STONE);
//        dropSelf(VanillishBlocks.POLISHED_SCORCH_STONE_STAIRS);
//        dropSelf(VanillishBlocks.POLISHED_SCORCH_STONE_SLAB);
//        dropSelf(VanillishBlocks.POLISHED_SCORCH_STONE_WALL);
//
//        dropSelf(VanillishBlocks.SCORCH_STONE_BRICKS);
//        dropSelf(VanillishBlocks.SCORCH_STONE_BRICK_STAIRS);
//        dropSelf(VanillishBlocks.SCORCH_STONE_BRICK_SLAB);
//        dropSelf(VanillishBlocks.SCORCH_STONE_BRICK_WALL);

        add(VanillishBlocks.ALGAE, createShearsOrSilkTouchOnlyDrop(VanillishItems.ALGAE));
        add(VanillishBlocks.DUCKWEED, createShearsOrSilkTouchOnlyDrop(VanillishItems.DUCKWEED));


        add(VanillishBlocks.SANDSTONE_SLATE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(VanillishBlocks.SANDSTONE_SLATE).apply(CopyComponentsFunction.copyComponentsFromBlockEntity(LootContextParams.BLOCK_ENTITY).include(DataComponents.POT_DECORATIONS)))));
    }
}
