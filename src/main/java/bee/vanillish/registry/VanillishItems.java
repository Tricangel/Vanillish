package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.item.MetalScaffoldingItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;

import java.util.function.Function;

public class VanillishItems {

    public static final Item BRASS_SCAFFOLDING = register("brass_scaffolding", properties -> new MetalScaffoldingItem(VanillishBlocks.BRASS_SCAFFOLDING, properties), new Item.Properties());
    public static final BlockItem ALGAE = registerBlockItem("algae", properties -> new PlaceOnWaterBlockItem(VanillishBlocks.ALGAE, properties), new Item.Properties());
    public static final BlockItem DUCKWEED = registerBlockItem("duckweed", properties -> new PlaceOnWaterBlockItem(VanillishBlocks.DUCKWEED, properties), new Item.Properties());

    public static void init() {
    }

    public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Vanillish.id(name));
        GenericItem item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static <GenericItem extends BlockItem> GenericItem registerBlockItem(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Vanillish.id(name));
        GenericItem item = itemFactory.apply(settings.setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
}
