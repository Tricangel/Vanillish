package bee.vanillish;

import bee.vanillish.client.BlastChamberScreen;
import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishMenuTypes;
import bee.vanillish.registry.VanillishParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class VanillishClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, VanillishBlocks.GRANITE_PABBLE, VanillishBlocks.NETHERRACK_PABBLE, VanillishBlocks.BRASS_GRATE,
                VanillishBlocks.BRASS_BARS, VanillishBlocks.BRASS_CHAIN, VanillishBlocks.BRASS_LANTERN,
                VanillishBlocks.BRASS_SCAFFOLDING, VanillishBlocks.BRASS_LADDER, VanillishBlocks.SCRAP_METAL_GRATE,
                VanillishBlocks.SCRAP_METAL_BARS, VanillishBlocks.SCRAP_METAL_CHAIN, VanillishBlocks.SCRAP_METAL_LANTERN,
                VanillishBlocks.SCRAP_METAL_LADDER, VanillishBlocks.ROSE_GOLD_GRATE, VanillishBlocks.ROSE_GOLD_BARS,
                VanillishBlocks.ROSE_GOLD_CHAIN, VanillishBlocks.ROSE_GOLD_LANTERN, VanillishBlocks.ROSE_GOLD_SCAFFOLDING,
                VanillishBlocks.ROSE_GOLD_LADDER, VanillishBlocks.STEEL_GRATE, VanillishBlocks.STEEL_BARS,
                VanillishBlocks.STEEL_CHAIN, VanillishBlocks.STEEL_LANTERN, VanillishBlocks.STEEL_CHAIN,
                VanillishBlocks.STEEL_SCAFFOLDING, VanillishBlocks.STEEL_LADDER, VanillishBlocks.ADVANCED_RAIL,
                VanillishBlocks.ADVANCED_POWERED_RAIL, VanillishBlocks.ADVANCED_STOP_RAIL, VanillishBlocks.ADVANCED_BOUNCY_RAIL,
                VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL, VanillishBlocks.ADVANCED_DETECTOR_RAIL, VanillishBlocks.ALGAE,
                VanillishBlocks.DUCKWEED);

        MenuScreens.register(VanillishMenuTypes.BLAST_CHAMBER, BlastChamberScreen::new);


        ParticleFactoryRegistry.getInstance().register(VanillishParticles.BRASS_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(VanillishParticles.STEEL_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(VanillishParticles.ROSE_GOLD_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(VanillishParticles.SCRAP_METAL_FLAME, FlameParticle.Provider::new);


    }
}
