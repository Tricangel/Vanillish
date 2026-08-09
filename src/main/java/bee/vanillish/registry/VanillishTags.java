package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

public class VanillishTags {

    public static final TagKey<Block> SCAFFOLDING = TagKey.create(Registries.BLOCK, Vanillish.id("scaffolding"));


}
