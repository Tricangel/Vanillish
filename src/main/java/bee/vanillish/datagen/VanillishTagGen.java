package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class VanillishTagGen extends FabricTagProvider.BlockTagProvider {
    public VanillishTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {



        valueLookupBuilder(BlockTags.RAILS)
                .add(VanillishBlocks.BRASS_RAILS);

        valueLookupBuilder(BlockTags.CLIMBABLE)
                .add(VanillishBlocks.BRASS_SCAFFOLDING);

        valueLookupBuilder(VanillishTags.SCAFFOLDING)
                .add(VanillishBlocks.BRASS_SCAFFOLDING)
                .add(Blocks.SCAFFOLDING);
    }
}
