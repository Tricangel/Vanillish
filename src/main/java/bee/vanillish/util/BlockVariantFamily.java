package bee.vanillish.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockVariantFamily {
    public final ImmutableMap<Variant, VanillishBlockFamily> blocks;
    public final ImmutableList<TagKey<Block>> tags;
    public BlockVariantFamily(ImmutableMap<Variant, VanillishBlockFamily> blocks, ImmutableList<TagKey<Block>> tags) {
        this.blocks = blocks;
        this.tags = tags;
    }

    public VanillishBlockFamily base() {
        return blocks.get(Variant.BASE);
    }

    public VanillishBlockFamily bricks() {
        return blocks.get(Variant.BRICKS);
    }

    public VanillishBlockFamily tiles() {
        return blocks.get(Variant.TILES);
    }

    public VanillishBlockFamily chiseled() {
        return blocks.get(Variant.CHISELED);
    }

    public VanillishBlockFamily carved() {
        return blocks.get(Variant.CARVED);
    }

    public static class Builder {
        final String nameSpace;
        final String name;
        Map<Variant, VanillishBlockFamily> blocks = new HashMap<>();
        ArrayList<TagKey<Block>> tagKeys = new ArrayList<>();

        public Builder(String name, String nameSpace) {
            this.name = name;
            this.nameSpace = nameSpace;
        }

        public Builder base(BlockBehaviour.Properties properties, VanillishBlockFamily.Variant... variants) {
            VanillishBlockFamily.Builder family = BlockFamilyHelper.of(name, nameSpace).fullBlock(properties);

            family.variants(variants);

            this.blocks.put(Variant.BASE, family.build());
            return this;
        }

        public Builder polished(BlockBehaviour.Properties properties, VanillishBlockFamily.Variant... variants) {
            VanillishBlockFamily.Builder family = BlockFamilyHelper.of("polished_" + name, nameSpace).fullBlock(properties);

            family.variants(variants);

            this.blocks.put(Variant.POLISHED, family.build());
            return this;
        }

        public Builder smooth(BlockBehaviour.Properties properties, VanillishBlockFamily.Variant... variants) {
            VanillishBlockFamily.Builder family = BlockFamilyHelper.of("smooth_" + name, nameSpace).fullBlock(properties);

            family.variants(variants);

            this.blocks.put(Variant.SMOOTH, family.build());
            return this;
        }

        public Builder bricks(BlockBehaviour.Properties properties, VanillishBlockFamily.Variant... variants) {
            VanillishBlockFamily.Builder family = BlockFamilyHelper.of(name + "_brick", nameSpace).fullBlock(properties, name + "_bricks");

            family.variants(variants);

            this.blocks.put(Variant.BRICKS, family.build());
            return this;
        }

        public Builder tiles(BlockBehaviour.Properties properties, VanillishBlockFamily.Variant... variants) {
            VanillishBlockFamily.Builder family = BlockFamilyHelper.of(name + "_tile", nameSpace).fullBlock(properties, name + "_tiles");

            family.variants(variants);

            this.blocks.put(Variant.TILES, family.build());
            return this;
        }

        public Builder chiseled(BlockBehaviour.Properties properties, VanillishBlockFamily.Variant... variants) {
            VanillishBlockFamily.Builder family = BlockFamilyHelper.of("chiseled_" + name, nameSpace).fullBlock(properties);

            family.variants(variants);

            this.blocks.put(Variant.CHISELED, family.build());
            return this;
        }

        public Builder carved(BlockBehaviour.Properties properties, VanillishBlockFamily.Variant... variants) {
            VanillishBlockFamily.Builder family = BlockFamilyHelper.of("carved_" + name, nameSpace).fullBlock(properties);

            family.variants(variants);
            this.blocks.put(Variant.CARVED, family.build());
            return this;
        }

        public Builder tag(TagKey<Block> tagKey) {
            tagKeys.add(tagKey);
            return this;
        }

        public BlockVariantFamily build() {
            return new BlockVariantFamily(ImmutableMap.copyOf(blocks), ImmutableList.copyOf(tagKeys));
        }

        private Identifier id(String nameSpace, String name) {
            return Identifier.fromNamespaceAndPath(nameSpace, name);
        }

    }


    public enum Variant implements StringRepresentable {
        BASE("base"),
        POLISHED("polished"),
        SMOOTH("smooth"),
        BRICKS("bricks"),
        TILES("tiles"),
        CHISELED("chiseled"),
        CARVED("carved");

        final String name;

        Variant(String name) {
            this.name = name;
        }


        @Override
        public @NonNull String getSerializedName() {
            return name;
        }
    }


}
