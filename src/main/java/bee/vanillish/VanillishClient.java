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
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_STOP_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_BOUNCY_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ADVANCED_DETECTOR_RAIL, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.BRASS_SCAFFOLDING, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.ALGAE, ChunkSectionLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(VanillishBlocks.DUCKWEED, ChunkSectionLayer.CUTOUT);

        MenuScreens.register(VanillishMenuTypes.BLAST_CHAMBER, BlastChamberScreen::new);


    }
}
