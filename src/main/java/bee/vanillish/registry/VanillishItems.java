package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.item.MetalScaffoldingItem;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class VanillishItems {

    public static final Item BRASS = register("brass", Item::new, new Item.Properties());
    public static final Item ROSE_GOLD = register("rose_gold", Item::new, new Item.Properties());
    public static final Item STEEL = register("steel", Item::new, new Item.Properties());
    public static final Item BRASS_NUGGET = register("brass_nugget", Item::new, new Item.Properties());
    public static final Item ROSE_GOLD_NUGGET = register("rose_gold_nugget", Item::new, new Item.Properties());
    public static final Item STEEL_NUGGET = register("steel_nugget", Item::new, new Item.Properties());
    public static final Item SCRAP_METAL_SHARD = register("scrap_metal_shard", Item::new, new Item.Properties());

    public static final BlockItem ALGAE = registerBlockItem("algae", properties -> new PlaceOnWaterBlockItem(VanillishBlocks.ALGAE, properties), new Item.Properties());
    public static final BlockItem DUCKWEED = registerBlockItem("duckweed", properties -> new PlaceOnWaterBlockItem(VanillishBlocks.DUCKWEED, properties), new Item.Properties());

    public static final BlockItem BRASS_TORCH = registerBlockItem("brass_torch", properties -> new StandingAndWallBlockItem(VanillishBlocks.BRASS_TORCH, VanillishBlocks.BRASS_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final BlockItem SCRAP_METAL_TORCH = registerBlockItem("scrap_metal_torch", properties -> new StandingAndWallBlockItem(VanillishBlocks.SCRAP_METAL_BLOCK, VanillishBlocks.SCRAP_METAL_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final BlockItem ROSE_GOLD_TORCH = registerBlockItem("rose_gold_torch", properties -> new StandingAndWallBlockItem(VanillishBlocks.ROSE_GOLD_TORCH, VanillishBlocks.ROSE_GOLD_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());
    public static final BlockItem STEEL_TORCH = registerBlockItem("steel_torch", properties -> new StandingAndWallBlockItem(VanillishBlocks.STEEL_TORCH, VanillishBlocks.STEEL_WALL_TORCH, Direction.DOWN, properties), new Item.Properties());

    public static void init() {
    }

    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Vanillish.id(name));
        GenericItem item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static BlockItem registerBlockItem(String name, Function<Item.Properties, BlockItem> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Vanillish.id(name));
        BlockItem item = itemFactory.apply(settings.setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }
}
