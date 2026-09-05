package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishEffects;
import bee.vanillish.registry.VanillishItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class VanillishLangGen extends FabricLanguageProvider {
    public VanillishLangGen(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {

        translationBuilder.add(VanillishBlocks.BLAST_CHAMBER, "Blast Chamber");
        translationBuilder.add(VanillishBlocks.WARDING_STONE, "Warding Stone");
        translationBuilder.add(VanillishBlocks.REDSTONE_RANDOMIZER, "Redstone Randomizer");
        translationBuilder.add(VanillishBlocks.BLOCK_OF_KELP, "Kelp Block");
        translationBuilder.add(VanillishBlocks.ALGAE, "Algae");

        translationBuilder.add(VanillishItems.PUTRID_LEATHER, "Putrid Leather");

        translationBuilder.add(VanillishBlocks.BRASS_BLOCK, "Brass Block");
        translationBuilder.add(VanillishBlocks.BRASS_BRICKS, "Brass Bricks");
        translationBuilder.add(VanillishBlocks.BRASS_BRICK_STAIRS, "Brass Brick Stairs");
        translationBuilder.add(VanillishBlocks.BRASS_BRICK_SLAB, "Brass Brick Slab");
        translationBuilder.add(VanillishBlocks.BRASS_GRATE, "Brass Grate");
        translationBuilder.add(VanillishBlocks.BRASS_TILES, "Brass Tiles");
        translationBuilder.add(VanillishBlocks.BRASS_TILE_STAIRS, "Brass Tile Stairs");
        translationBuilder.add(VanillishBlocks.BRASS_TILE_SLAB, "Brass Tile Slab");
        translationBuilder.add(VanillishBlocks.BRASS_BARS, "Brass Bars");
        translationBuilder.add(VanillishBlocks.BRASS_CHAIN, "Brass Chain");
        translationBuilder.add(VanillishBlocks.BRASS_LANTERN, "Brass Lantern");
        translationBuilder.add(VanillishItems.BRASS_TORCH, "Brass Torch");
        translationBuilder.add(VanillishBlocks.BRASS_LADDER, "Brass Ladder");
        translationBuilder.add(VanillishBlocks.BRASS_SCAFFOLDING, "Brass Scaffolding");

        translationBuilder.add(VanillishBlocks.STEEL_BLOCK, "Steel Block");
        translationBuilder.add(VanillishBlocks.STEEL_BRICKS, "Steel Bricks");
        translationBuilder.add(VanillishBlocks.STEEL_BRICK_STAIRS, "Steel Brick Stairs");
        translationBuilder.add(VanillishBlocks.STEEL_BRICK_SLAB, "Steel Brick Slab");
        translationBuilder.add(VanillishBlocks.STEEL_GRATE, "Steel Grate");
        translationBuilder.add(VanillishBlocks.STEEL_TILES, "Steel Tiles");
        translationBuilder.add(VanillishBlocks.STEEL_TILE_STAIRS, "Steel Tile Stairs");
        translationBuilder.add(VanillishBlocks.STEEL_TILE_SLAB, "Steel Tile Slab");
        translationBuilder.add(VanillishBlocks.STEEL_BARS, "Steel Bars");
        translationBuilder.add(VanillishBlocks.STEEL_CHAIN, "Steel Chain");
        translationBuilder.add(VanillishBlocks.STEEL_LANTERN, "Steel Lantern");
        translationBuilder.add(VanillishItems.STEEL_TORCH, "Steel Torch");
        translationBuilder.add(VanillishBlocks.STEEL_LADDER, "Steel Ladder");
        translationBuilder.add(VanillishBlocks.STEEL_SCAFFOLDING, "Steel Scaffolding");

        translationBuilder.add(VanillishBlocks.ROSE_GOLD_BLOCK, "Rose Gold Block");
        translationBuilder.add(VanillishBlocks.CARVED_ROSE_GOLD, "Carved Rose Gold");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_GRATE, "Rose Gold Grate");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_TILES, "Rose Gold Tiles");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_TILE_STAIRS, "Rose Gold Tile Stairs");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_TILE_SLAB, "Rose Gold Tile Slab");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_BARS, "Rose Gold Bars");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_CHAIN, "Rose Gold Chain");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_LANTERN, "Rose Gold Lantern");
        translationBuilder.add(VanillishItems.ROSE_GOLD_TORCH, "Rose Gold Torch");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_LADDER, "Rose Gold Ladder");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_SCAFFOLDING, "Rose Gold Scaffolding");

        translationBuilder.add(VanillishBlocks.CARVED_SCRAP_METAL, "Carved Scrap Metal");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL, "Scrap Metal");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_BRICKS, "Scrap Metal Bricks");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_BRICK_STAIRS, "Scrap Metal Brick Stairs");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_BRICK_SLAB, "Scrap Metal Brick Slab");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_GRATE, "Scrap Metal Grate");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_TILES, "Scrap Metal Tiles");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_TILE_STAIRS, "Scrap Metal Tile Stairs");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_TILE_SLAB, "Scrap Metal Tile Slab");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_BARS, "Scrap Metal Bars");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_CHAIN, "Scrap Metal Chain");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_LANTERN, "Scrap Metal Lantern");
        translationBuilder.add(VanillishItems.SCRAP_METAL_TORCH, "Scrap Metal Torch");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_LADDER, "Scrap Metal Ladder");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_DOOR, "Scrap Metal Door");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_TRAPDOOR, "Scrap Metal Trapdoor");

        translationBuilder.add(VanillishBlocks.CHARRED_BUTTON, "Charred Button");
        translationBuilder.add(VanillishBlocks.CHARRED_DOOR, "Charred Door");
        translationBuilder.add(VanillishBlocks.CHARRED_LOG, "Charred Log");
        translationBuilder.add(VanillishBlocks.STRIPPED_CHARRED_LOG, "Stripped Charred Log");
        translationBuilder.add(VanillishBlocks.STRIPPED_CHARRED_WOOD, "Stripped Charred Wood");
        translationBuilder.add(VanillishBlocks.CHARRED_FENCE, "Charred Fence");
        translationBuilder.add(VanillishBlocks.CHARRED_PLANKS, "Charred Planks");
        translationBuilder.add(VanillishBlocks.CHARRED_SHELF, "Charred Shelf");
        translationBuilder.add(VanillishBlocks.CHARRED_SLAB, "Charred Slab");
        translationBuilder.add(VanillishBlocks.CHARRED_WOOD, "Charred Wood");
        translationBuilder.add(VanillishBlocks.CHARRED_FENCE_GATE, "Charred Fence Gate");
        translationBuilder.add(VanillishBlocks.CHARRED_PRESSURE_PLATE, "Charred Pressure Plate");
        translationBuilder.add(VanillishBlocks.CHARRED_STAIRS, "Charred Stairs");
        translationBuilder.add(VanillishBlocks.CHARRED_TRAPDOOR, "Charred Trapdoor");


        translationBuilder.add(VanillishBlocks.ADVANCED_RAIL, "Advanced Rail");
        translationBuilder.add(VanillishBlocks.ADVANCED_POWERED_RAIL, "Advanced Powered Rail");
        translationBuilder.add(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL, "Advanced Directional Rail");
        translationBuilder.add(VanillishBlocks.ADVANCED_DETECTOR_RAIL, "Advanced Detector Rail");
        translationBuilder.add(VanillishBlocks.ADVANCED_STOP_RAIL, "Advanced Stop Rail");

        translationBuilder.add(VanillishItems.STEEL_INGOT, "Steel Ingot");
        translationBuilder.add(VanillishItems.BRASS_INGOT, "Brass Ingot");
        translationBuilder.add(VanillishItems.ROSE_GOLD_INGOT, "Rose Gold Ingot");
        translationBuilder.add(VanillishItems.STEEL_NUGGET, "Steel Nugget");
        translationBuilder.add(VanillishItems.BRASS_NUGGET, "Brass Nugget");
        translationBuilder.add(VanillishItems.ROSE_GOLD_NUGGET, "Rose Gold Nugget");
        translationBuilder.add(VanillishItems.SCRAP_METAL_SHARD, "Scrap Metal Shard");

        translationBuilder.add(VanillishBlocks.DARK_SANDSTONE, "Dark Sandstone");
        translationBuilder.add(VanillishBlocks.DARK_SANDSTONE_STAIRS, "Dark Sandstone Stairs");
        translationBuilder.add(VanillishBlocks.DARK_SANDSTONE_SLAB, "Dark Sandstone Slab");
        translationBuilder.add(VanillishBlocks.DARK_SANDSTONE_WALL, "Dark Sandstone Wall");
        translationBuilder.add(VanillishBlocks.SMOOTH_DARK_SANDSTONE, "Smooth Dark Sandstone");
        translationBuilder.add(VanillishBlocks.SMOOTH_DARK_SANDSTONE_STAIRS, "Smooth Dark Sandstone");
        translationBuilder.add(VanillishBlocks.SMOOTH_DARK_SANDSTONE_SLAB, "Smooth Dark Sandstone");
        translationBuilder.add(VanillishBlocks.SMOOTH_DARK_SANDSTONE_WALL, "Smooth Dark Sandstone");
        translationBuilder.add(VanillishBlocks.CHISELED_DARK_SANDSTONE, "Chiseled Dark Sandstone");
        translationBuilder.add(VanillishBlocks.CUT_DARK_SANDSTONE, "Cut Dark Sandstone");
        translationBuilder.add(VanillishBlocks.CUT_DARK_SANDSTONE_SLAB, "Cut Dark Sandstone Slab");

        translationBuilder.add(VanillishBlocks.DARK_SILT, "Dark Silt");
        translationBuilder.add(VanillishBlocks.DEEP_GRIT, "Deep Grit");

        translationBuilder.add(VanillishEffects.PROTECTED.value(), "Protected");


        translationBuilder.add("vanillish.creative_tab", "Vanillish");
    }
}
