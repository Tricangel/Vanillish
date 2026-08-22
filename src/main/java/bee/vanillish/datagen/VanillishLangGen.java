package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
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

        translationBuilder.add(VanillishBlocks.BRASS_BLOCK, "Brass Block");
        translationBuilder.add(VanillishBlocks.BRASS_BRICKS, "Brass Bricks");
        translationBuilder.add(VanillishBlocks.BRASS_GRATE, "Brass Grate");
        translationBuilder.add(VanillishBlocks.BRASS_TILES, "Brass Tiles");
        translationBuilder.add(VanillishBlocks.BRASS_BARS, "Brass Bars");
        translationBuilder.add(VanillishBlocks.BRASS_CHAIN, "Brass Chain");
        translationBuilder.add(VanillishBlocks.BRASS_LANTERN, "Brass Lantern");
        translationBuilder.add(VanillishItems.BRASS_TORCH, "Brass Torch");
        translationBuilder.add(VanillishBlocks.BRASS_LADDER, "Brass Ladder");
        translationBuilder.add(VanillishBlocks.BRASS_SCAFFOLDING, "Brass Scaffolding");

        translationBuilder.add(VanillishBlocks.STEEL_BLOCK, "Steel Block");
        translationBuilder.add(VanillishBlocks.CARVED_STEEL, "Carved Steel");
        translationBuilder.add(VanillishBlocks.STEEL_GRATE, "Steel Grate");
        translationBuilder.add(VanillishBlocks.STEEL_TILES, "Steel Tiles");
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
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_BARS, "Rose Gold Bars");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_CHAIN, "Rose Gold Chain");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_LANTERN, "Rose Gold Lantern");
        translationBuilder.add(VanillishItems.ROSE_GOLD_TORCH, "Rose Gold Torch");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_LADDER, "Rose Gold Ladder");
        translationBuilder.add(VanillishBlocks.ROSE_GOLD_SCAFFOLDING, "Rose Gold Scaffolding");

        translationBuilder.add(VanillishBlocks.SCRAP_METAL_BLOCK, "Scrap Metal Block");
        translationBuilder.add(VanillishBlocks.CARVED_SCRAP_METAL, "Carved Scrap Metal");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_BRICKS, "Scrap Metal Bricks");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_GRATE, "Scrap Metal Grate");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_TILES, "Scrap Metal Tiles");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_BARS, "Scrap Metal Bars");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_CHAIN, "Scrap Metal Chain");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_LANTERN, "Scrap Metal Lantern");
        translationBuilder.add(VanillishItems.SCRAP_METAL_TORCH, "Scrap Metal Torch");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_LADDER, "Scrap Metal Ladder");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_DOOR, "Scrap Metal Door");
        translationBuilder.add(VanillishBlocks.SCRAP_METAL_TRAPDOOR, "Scrap Metal Trapdoor");


        translationBuilder.add(VanillishBlocks.ADVANCED_RAIL, "Advanced Rail");
        translationBuilder.add(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL, "Advanced Directional Rail");
        translationBuilder.add(VanillishBlocks.ADVANCED_DETECTOR_RAIL, "Advanced Detector Rail");
        translationBuilder.add(VanillishBlocks.ADVANCED_STOP_RAIL, "Advanced Stop Rail");
    }
}
