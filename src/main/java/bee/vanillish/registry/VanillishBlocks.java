package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.block.BlastChamberBlock;
import bee.vanillish.block.MetalScaffolding;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class VanillishBlocks {

    //Components
    public static final Block BLAST_CHAMBER = register("blast_chamber", BlastChamberBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE), true);


    //Brass family

    public static final Block BRASS_BLOCK = register("brass_block", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block BRASS_BRICKS = register("brass_bricks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block BRASS_GRATE = register("brass_grate", WaterloggedTransparentBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_GRATE), true);
    public static final Block BRASS_TILES = register("brass_tiles", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), true);
    public static final Block BRASS_BARS = register("brass_bars", IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS), true);
    public static final Block BRASS_SCAFFOLDING = register("brass_scaffolding", MetalScaffolding::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SCAFFOLDING), false);

    //Brass components

    public static final Block BRASS_RAILS = register("brass_rails", PoweredRailBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.POWERED_RAIL), true);

















    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Vanillish.id(name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Vanillish.id(name));
    }

    public static void init() {
    }

}
