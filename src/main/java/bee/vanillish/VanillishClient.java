package bee.vanillish;

import bee.vanillish.block.entity.SandstoneSlateBlockEntity;
import bee.vanillish.block.entity.renderer.SandstoneSlateBlockEntityRenderer;
import bee.vanillish.client.BlastChamberScreen;
import bee.vanillish.client.renderer.SandstoneSlateSpecialRenderer;
import bee.vanillish.registry.VanillishBlockEntities;
import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishMenuTypes;
import bee.vanillish.registry.VanillishParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.special.SpecialModelRenderers;

public class VanillishClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, VanillishBlocks.STONE_PABBLE, VanillishBlocks.TUFF_PABBLE,
                VanillishBlocks.BASALT_PABBLE, VanillishBlocks.DEEPSLATE_PABBLE, VanillishBlocks.BLACKSTONE_PABBLE,
                VanillishBlocks.CALCITE_PABBLE, VanillishBlocks.DIORITE_PABBLE, VanillishBlocks.DRIPSTONE_PABBLE,
                VanillishBlocks.GRANITE_PABBLE, VanillishBlocks.NETHERRACK_PABBLE, VanillishBlocks.BRASS_GRATE,
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
                VanillishBlocks.DUCKWEED, VanillishBlocks.COPPER_SCAFFOLDING.unaffected(), VanillishBlocks.COPPER_SCAFFOLDING.weathered(),
                VanillishBlocks.COPPER_SCAFFOLDING.exposed(), VanillishBlocks.COPPER_SCAFFOLDING.oxidized(), VanillishBlocks.COPPER_SCAFFOLDING.waxed(),
                VanillishBlocks.COPPER_SCAFFOLDING.waxedWeathered(), VanillishBlocks.COPPER_SCAFFOLDING.waxedExposed(), VanillishBlocks.COPPER_SCAFFOLDING.waxedOxidized());

        MenuScreens.register(VanillishMenuTypes.BLAST_CHAMBER, BlastChamberScreen::new);

        SpecialModelRenderers.ID_MAPPER.put(Vanillish.id("sandstone_slate"), SandstoneSlateSpecialRenderer.Unbaked.MAP_CODEC);


        ParticleFactoryRegistry.getInstance().register(VanillishParticles.BRASS_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(VanillishParticles.STEEL_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(VanillishParticles.ROSE_GOLD_FLAME, FlameParticle.Provider::new);
        ParticleFactoryRegistry.getInstance().register(VanillishParticles.SCRAP_METAL_FLAME, FlameParticle.Provider::new);

        EntityModelLayerRegistry.registerModelLayer(SandstoneSlateBlockEntityRenderer.SANDSTONE_SLATE_BASE, SandstoneSlateBlockEntityRenderer::createBodyLayer);
        BlockEntityRenderers.register(VanillishBlockEntities.SANDSTONE_SLATE, SandstoneSlateBlockEntityRenderer::new);
    }
}
