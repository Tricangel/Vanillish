package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class VanillishItemTagGen extends FabricTagProvider.ItemTagProvider {
    public VanillishItemTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        valueLookupBuilder(VanillishTags.CHARRED_WOOD)
                .add(VanillishBlocks.CHARRED_LOG.asItem())
                .add(VanillishBlocks.STRIPPED_CHARRED_WOOD.asItem())
                .add(VanillishBlocks.STRIPPED_CHARRED_LOG.asItem())
                .add(VanillishBlocks.CHARRED_WOOD.asItem());

        valueLookupBuilder(VanillishTags.FUEL)
                .add(Items.GUNPOWDER)
                .add(Blocks.TNT.asItem());

    }
}
