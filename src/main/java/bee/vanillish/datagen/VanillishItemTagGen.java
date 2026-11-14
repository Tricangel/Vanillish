package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishItems;
import bee.vanillish.registry.VanillishTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class VanillishItemTagGen extends FabricTagProvider.ItemTagProvider {
    public VanillishItemTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {



        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(VanillishItems.BRASS_INGOT)
                .add(VanillishItems.STEEL_INGOT)
                .add(VanillishItems.SCRAP_METAL_SHARD)
                .add(VanillishItems.ROSE_GOLD_INGOT);

        valueLookupBuilder(VanillishTags.SADDLES)
                .add(Items.SADDLE).forceAddTag(ItemTags.HARNESSES);

        valueLookupBuilder(VanillishTags.CHARRED_WOOD)
                .add(VanillishBlocks.CHARRED_LOG.asItem())
                .add(VanillishBlocks.STRIPPED_CHARRED_WOOD.asItem())
                .add(VanillishBlocks.STRIPPED_CHARRED_LOG.asItem())
                .add(VanillishBlocks.CHARRED_WOOD.asItem());

        valueLookupBuilder(VanillishTags.FUEL)
                .add(Items.GUNPOWDER)
                .add(Blocks.TNT.asItem());

        valueLookupBuilder(ItemTags.PLANKS)
                .add(VanillishBlocks.CHARRED_PLANKS.asItem());

        valueLookupBuilder(ItemTags.LOGS)
                .add(VanillishBlocks.CHARRED_LOG.asItem())
                .add(VanillishBlocks.STRIPPED_CHARRED_LOG.asItem());

        valueLookupBuilder(ConventionalItemTags.CHAINS)
                .add(VanillishBlocks.BRASS_CHAIN.asItem())
                .add(VanillishBlocks.ROSE_GOLD_CHAIN.asItem())
                .add(VanillishBlocks.STEEL_CHAIN.asItem())
                .add(VanillishBlocks.SCRAP_METAL_CHAIN.asItem());

    }
}
