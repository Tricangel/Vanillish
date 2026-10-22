package bee.vanillish.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.*;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jspecify.annotations.NonNull;

import java.util.*;

import static bee.vanillish.util.BlockFamilyHelper.id;

public class VanillishBlockFamily {
    public final ImmutableList<TagKey<Block>> blockTags;
    public final String name;
    public final String nameSpace;
    public final boolean shouldGenerateStonecutterRecipes;
    public final boolean inherited;
    public final ImmutableMap<Variant, Block> blocks;

    private VanillishBlockFamily(ImmutableList<TagKey<Block>> blockTags, ImmutableMap<Variant, Block> blocks, String name, String nameSpace, boolean bl, boolean inherited) {
        this.blockTags = blockTags;
        this.blocks = blocks;
        this.name = name;
        this.nameSpace = nameSpace;
        this.inherited = inherited;
        this.shouldGenerateStonecutterRecipes = bl;
    }


    public Block fullBlock() {
        return blocks.get(Variant.FULL_BLOCK);
    }

    public Block stairs() {
        return blocks.get(Variant.STAIRS);
    }

    public Block slab() {
        return blocks.get(Variant.SLAB);
    }

    public Block wall() {
        return blocks.get(Variant.WALL);
    }

    public void genLang(FabricLanguageProvider.TranslationBuilder translationBuilder) {

        blocks.forEach((variant, block) -> {
            if (!(inherited && variant.equals(Variant.FULL_BLOCK))) {

                String str = this.name.replace('_', ' ');

                String[] strings = str.split(" ");
                StringBuilder capital = new StringBuilder();

                for (String string : strings) {
                    capital.append(" ").append(BlockFamilyHelper.capital(string));
                }

                capital.delete(0, 1);

                String name = variant.equals(Variant.FULL_BLOCK) ? capital.toString() : capital + " " + BlockFamilyHelper.capital(variant.name);

                translationBuilder.add(block, name);
            }

        });

    }

    public void genModels(BlockModelGenerators blockModelGenerators) {
        Block fullBlock = this.fullBlock();


        BlockModelGenerators.BlockFamilyProvider familyProvider;
        TextureMapping mapping = TextureMapping.cube(fullBlock);
        ModelTemplate template = ModelTemplates.CUBE_ALL;
        if (nameSpace.equals("minecraft")) {
            if (fullBlock.equals(Blocks.POLISHED_BASALT)) {
                mapping = TextureMapping.columnWithWall(fullBlock).put(TextureSlot.SIDE, TextureMapping.getBlockTexture(fullBlock).withSuffix("_side"));
                template = ModelTemplates.CUBE_COLUMN;
            }

            familyProvider = blockModelGenerators.new BlockFamilyProvider(mapping);
        } else familyProvider = blockModelGenerators.family(fullBlock);



        if (blocks.get(Variant.STAIRS) != null) familyProvider.stairs(stairs());
        if (blocks.get(Variant.SLAB) != null) slab(slab(), blockModelGenerators, familyProvider, mapping, template);
        if (blocks.get(Variant.WALL) != null) familyProvider.wall(wall());

    }

    public void slab(Block block, BlockModelGenerators blockModelGenerators, BlockModelGenerators.BlockFamilyProvider familyProvider, TextureMapping mapping, ModelTemplate template) {
        Identifier identifier = this.getOrCreateModel(ModelTemplates.SLAB_BOTTOM, block, blockModelGenerators, familyProvider, "", mapping);
        MultiVariant multiVariant = BlockModelGenerators.plainVariant(this.getOrCreateModel(ModelTemplates.SLAB_TOP, block, blockModelGenerators, familyProvider, "", mapping));
        MultiVariant fullBlock = BlockModelGenerators.plainVariant(this.getOrCreateModel(template, block, blockModelGenerators, familyProvider, "_full", mapping));
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSlab(block, BlockModelGenerators.plainVariant(identifier), multiVariant, fullBlock));
        blockModelGenerators.registerSimpleItemModel(block, identifier);

    }

    private Identifier getOrCreateModel(ModelTemplate modelTemplate, Block block, BlockModelGenerators blockModelGenerators, BlockModelGenerators.BlockFamilyProvider familyProvider, String s, TextureMapping mapping) {
        return (Identifier)familyProvider.models.computeIfAbsent(modelTemplate, (modelTemplatex) -> modelTemplatex.createWithSuffix(block, s, mapping, blockModelGenerators.modelOutput));
    }



    public static class Builder {
        List<TagKey<Block>> tags = new ArrayList<>();
        final String nameSpace;
        final String name;
        boolean inherited = false;
        boolean shouldGenerateStonecutterRecipes = false;
        Map<Variant, Block> blocks = new HashMap<>();

        public Builder(String name, String nameSpace) {
            this.name = name;
            this.nameSpace = nameSpace;
        }

        public Builder(String name, String nameSpace, Block fullBlock) {
            this.name = name;
            this.nameSpace = nameSpace;
            this.blocks.put(Variant.FULL_BLOCK, fullBlock);
        }

        public Builder variants(Variant... variants) {
            for (Variant variant : variants) {
                switch (variant) {
                    case STAIRS -> stairs();
                    case SLAB -> slab();
                    case WALL -> wall();
                    case FENCE -> fence();
                    case BARS -> bars();
                }
            }
            return this;
        }

        public Builder fullBlock(BlockBehaviour.Properties properties) {
            Block baseBlock = BlockFamilyRegistry.registerBlock(id(nameSpace, name), Block::new, properties, true);
            this.blocks.put(Variant.FULL_BLOCK, baseBlock);
            return this;
        }

        public Builder fullBlock(BlockBehaviour.Properties properties, String name) {
            Block baseBlock = BlockFamilyRegistry.registerBlock(id(nameSpace, name), Block::new, properties, true);
            this.blocks.put(Variant.FULL_BLOCK, baseBlock);
            return this;
        }

        public Builder stairs() {
            Block baseBlock = blocks.get(Variant.FULL_BLOCK);
            Block stairs = BlockFamilyRegistry.registerBlock(id(nameSpace, name + "_stairs"), p -> new StairBlock(baseBlock.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(baseBlock), true);
            this.blocks.put(Variant.STAIRS, stairs);
            return this;
        }

        public Builder slab() {
            Block slab = BlockFamilyRegistry.registerBlock(id(nameSpace, name + "_slab"), SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(blocks.get(Variant.FULL_BLOCK)), true);
            this.blocks.put(Variant.SLAB, slab);
            return this;
        }

        public Builder wall() {
            Block wall = BlockFamilyRegistry.registerBlock(id(nameSpace, name + "_wall"), WallBlock::new, BlockBehaviour.Properties.ofFullCopy(blocks.get(Variant.FULL_BLOCK)), true);
            this.blocks.put(Variant.WALL, wall);
            return this;
        }

        public Builder fence() {
            Block fence = BlockFamilyRegistry.registerBlock(id(nameSpace, name + "_fence"), FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(blocks.get(Variant.FULL_BLOCK)), true);
            this.blocks.put(Variant.FENCE, fence);
            return this;
        }

        public Builder bars() {
            Block bars = BlockFamilyRegistry.registerBlock(id(nameSpace, name + "_bars"), IronBarsBlock::new, BlockBehaviour.Properties.ofFullCopy(blocks.get(Variant.FULL_BLOCK)), true);
            this.blocks.put(Variant.BARS, bars);
            return this;
        }

        public Builder generateStonecutter() {
            shouldGenerateStonecutterRecipes = true;
            return this;
        }

        public Builder tag(TagKey<Block> tagKey) {
            tags.add(tagKey);
            return this;
        }

        public Builder inherited() {
            inherited = true;
            return this;
        }

        public VanillishBlockFamily build() {
            VanillishBlockFamily family = new VanillishBlockFamily(ImmutableList.copyOf(tags), ImmutableMap.copyOf(blocks), name, nameSpace, shouldGenerateStonecutterRecipes, inherited);
            BlockFamilyHelper.families.add(family);
            return family;
        }


    }

    public enum Variant implements StringRepresentable {
        FULL_BLOCK("full_block"),
        STAIRS("stairs"),
        SLAB("slab"),
        WALL("wall"),
        FENCE("fence"),
        BARS("bars");

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
