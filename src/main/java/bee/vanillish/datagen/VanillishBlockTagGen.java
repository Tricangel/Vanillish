package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
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



        valueLookupBuilder(BlockTags.RAILS)
                .add(VanillishBlocks.ADVANCED_STOP_RAIL)
                .add(VanillishBlocks.ADVANCED_DETECTOR_RAIL)
                .add(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL)
                .add(VanillishBlocks.ADVANCED_BOUNCY_RAIL)
                .add(VanillishBlocks.ADVANCED_RAIL);

        valueLookupBuilder(VanillishTags.ADVANCED_RAILS)
                .add(VanillishBlocks.ADVANCED_STOP_RAIL)
                .add(VanillishBlocks.ADVANCED_DETECTOR_RAIL)
                .add(VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL)
                .add(VanillishBlocks.ADVANCED_BOUNCY_RAIL)
                .add(VanillishBlocks.ADVANCED_RAIL);

        valueLookupBuilder(BlockTags.CLIMBABLE)
                .add(VanillishBlocks.BRASS_SCAFFOLDING);

        valueLookupBuilder(VanillishTags.SCAFFOLDING)
                .add(VanillishBlocks.BRASS_SCAFFOLDING)
                .add(Blocks.SCAFFOLDING);
    }
}
