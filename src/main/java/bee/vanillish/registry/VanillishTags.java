package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class VanillishTags {

    public static final TagKey<Block> SCAFFOLDING = TagKey.create(Registries.BLOCK, Vanillish.id("scaffolding"));
    public static final TagKey<Block> ADVANCED_RAILS = TagKey.create(Registries.BLOCK, Vanillish.id("advanced_rails"));

    public static final TagKey<Item> FUEL = TagKey.create(Registries.ITEM, Vanillish.id("fuel"));


}
