package bee.vanillish;

import bee.vanillish.client.BlastChamberScreen;
import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class VanillishClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(VanillishBlocks.BRASS_GRATE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.BRASS_BARS, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.BRASS_CHAIN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.BRASS_LANTERN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.BRASS_CHAIN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.BRASS_SCAFFOLDING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.BRASS_LADDER, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(VanillishBlocks.SCRAP_METAL_GRATE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.SCRAP_METAL_BARS, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.SCRAP_METAL_CHAIN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.SCRAP_METAL_LANTERN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.SCRAP_METAL_CHAIN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.SCRAP_METAL_LADDER, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(VanillishBlocks.ROSE_GOLD_GRATE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ROSE_GOLD_BARS, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ROSE_GOLD_CHAIN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ROSE_GOLD_LANTERN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ROSE_GOLD_CHAIN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ROSE_GOLD_SCAFFOLDING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ROSE_GOLD_LADDER, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(VanillishBlocks.STEEL_GRATE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.STEEL_BARS, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.STEEL_CHAIN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.STEEL_LANTERN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.STEEL_CHAIN, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.STEEL_SCAFFOLDING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.STEEL_LADDER, ChunkSectionLayer.CUTOUT);

        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_STOP_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_BOUNCY_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_DETECTOR_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ALGAE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.DUCKWEED, ChunkSectionLayer.CUTOUT);

        MenuScreens.register(VanillishMenuTypes.BLAST_CHAMBER, BlastChamberScreen::new);


    }
}
