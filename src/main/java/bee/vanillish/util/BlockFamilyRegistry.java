package bee.vanillish.util;

import bee.vanillish.Vanillish;
import bee.vanillish.registry.VanillishCreativeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class BlockFamilyRegistry {

    public static Block registerBlock(Identifier id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            registerBlockItem(id, block);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    public static Item registerBlockItem(Identifier id, Block block) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        VanillishCreativeTab.ITEMS.add(blockItem);

        return Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
    }




}
