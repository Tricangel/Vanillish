package bee.vanillish.datagen;

import bee.vanillish.Vanillish;
import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishItems;
import bee.vanillish.registry.VanillishTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmokingRecipe;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class VanillishRecipeGen extends FabricRecipeProvider {
    public VanillishRecipeGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, Items.KELP, RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.BLOCK_OF_KELP.asItem(), "kelp_from_block", "kelp"
                );

                shaped(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.WARDING_STONE)
                        .pattern("brb")
                        .pattern("rcr")
                        .pattern("brb")
                        .define('b', Blocks.STONE_BRICKS)
                        .define('r', VanillishItems.ROSE_GOLD_INGOT)
                        .define('c', Blocks.AMETHYST_CLUSTER)
                        .unlockedBy("warding_stone", has(Items.AMETHYST_CLUSTER))
                        .save(recipeOutput, key("warding_stone"));



                shaped(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.BLAST_CHAMBER)
                        .pattern("ibi")
                        .pattern("rfr")
                        .pattern("ddd")
                        .define('i', Items.IRON_INGOT)
                        .define('b', Blocks.IRON_BLOCK)
                        .define('r', Items.REDSTONE)
                        .define('f', Blocks.BLAST_FURNACE)
                        .define('d', Blocks.DEEPSLATE_BRICKS)
                        .unlockedBy("warding_stone", has(Items.REDSTONE))
                        .save(recipeOutput, key("blast_chamber"));

                shapeless(RecipeCategory.BUILDING_BLOCKS, VanillishItems.ALGAE)
                        .requires(Items.MOSS_CARPET)
                        .unlockedBy("algay", has(Items.MOSS_CARPET))
                        .save(recipeOutput, key("algae"));

                shapeless(RecipeCategory.BUILDING_BLOCKS, VanillishItems.DUCKWEED)
                        .requires(VanillishItems.ALGAE)
                        .unlockedBy("algadcy", has(Items.MOSS_CARPET))
                        .save(recipeOutput, key("duckweed_from_algae"));

                shapeless(RecipeCategory.BUILDING_BLOCKS, VanillishItems.ALGAE)
                        .requires(VanillishItems.DUCKWEED)
                        .unlockedBy("algaydisc", has(Items.MOSS_CARPET))
                        .save(recipeOutput, key("algae_from_duckweed"));

                shaped(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.REDSTONE_RANDOMIZER)
                        .pattern("bsb")
                        .pattern("srs")
                        .pattern("bsb")
                        .define('b', VanillishItems.BRASS_INGOT)
                        .define('s', VanillishItems.STEEL_INGOT)
                        .define('r', Items.REDSTONE)
                        .unlockedBy("redstoy", has(Items.REDSTONE))
                        .save(recipeOutput, key("redstone_randomizer"));

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, VanillishItems.BRASS_INGOT, RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.BRASS_BLOCK.asItem(), "brass_from_block", "brass"
                );

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, VanillishItems.BRASS_NUGGET, RecipeCategory.BUILDING_BLOCKS, VanillishItems.BRASS_INGOT, "brass_nugget_from_brass", "brass_nuget"
                );

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, VanillishItems.SCRAP_METAL_SHARD, RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.SCRAP_METAL.asItem(), "scrap_from_block", "scrap"
                );

                shapeless(RecipeCategory.MISC, VanillishItems.BRASS_INGOT, 3)
                        .requires(Items.COPPER_INGOT, 2)
                        .requires(Items.IRON_INGOT, 2)
                        .unlockedBy("jumpsacre", has(Items.COPPER_INGOT))
                        .save(recipeOutput, key("brass_ingott"));

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.BRASS_BLOCK, VanillishBlocks.BRASS_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.BRASS_BLOCK, VanillishBlocks.BRASS_TILES);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.BRASS_BLOCK, VanillishBlocks.BRASS_GRATE);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.BRASS_INGOT, VanillishBlocks.BRASS_LADDER);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.BRASS_INGOT, VanillishBlocks.BRASS_BARS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.BRASS_INGOT, VanillishBlocks.BRASS_SCAFFOLDING);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.BRASS_INGOT, VanillishBlocks.BRASS_CHAIN);

                this.shaped(RecipeCategory.DECORATIONS, VanillishBlocks.BRASS_LANTERN)
                        .define('#', VanillishItems.BRASS_TORCH)
                        .define('X', Items.IRON_NUGGET)
                        .pattern("XXX")
                        .pattern("X#X")
                        .pattern("XXX")
                        .unlockedBy("has_brass_torch", this.has(VanillishItems.BRASS_TORCH))
                        .save(this.output, key("brass_lantern"));

                this.shaped(RecipeCategory.DECORATIONS, VanillishItems.BRASS_TORCH, 4)
                        .define('X', Ingredient.of(Items.COAL, Items.CHARCOAL))
                        .define('#', Items.STICK)
                        .define('C', VanillishItems.BRASS_NUGGET)
                        .pattern("C")
                        .pattern("X")
                        .pattern("#")
                        .unlockedBy("has_brass_nugget", this.has(VanillishItems.BRASS_NUGGET))
                        .save(this.output);

                //----

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, VanillishItems.ROSE_GOLD_INGOT, RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.ROSE_GOLD_BLOCK.asItem(), "rose_gold_from_block", "rose_gold"
                );

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, VanillishItems.ROSE_GOLD_NUGGET, RecipeCategory.BUILDING_BLOCKS, VanillishItems.ROSE_GOLD_INGOT, "rose_gold_from_nugget", "rose_gold_nuget"
                );

                shapeless(RecipeCategory.MISC, VanillishItems.ROSE_GOLD_INGOT, 4)
                        .requires(Items.AMETHYST_SHARD, 2)
                        .requires(Items.QUARTZ, 2)
                        .requires(Items.GOLD_INGOT, 2)
                        .unlockedBy("jumpsacre2", has(Items.COPPER_INGOT))
                        .save(recipeOutput, key("roseegold_ingott"));

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.ROSE_GOLD_BLOCK, VanillishBlocks.CARVED_ROSE_GOLD);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.ROSE_GOLD_BLOCK, VanillishBlocks.ROSE_GOLD_TILES);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.ROSE_GOLD_BLOCK, VanillishBlocks.ROSE_GOLD_GRATE);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.ROSE_GOLD_INGOT, VanillishBlocks.ROSE_GOLD_LADDER);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.ROSE_GOLD_INGOT, VanillishBlocks.ROSE_GOLD_BARS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.ROSE_GOLD_INGOT, VanillishBlocks.ROSE_GOLD_SCAFFOLDING);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.ROSE_GOLD_INGOT, VanillishBlocks.ROSE_GOLD_CHAIN);

                this.shaped(RecipeCategory.DECORATIONS, VanillishBlocks.ROSE_GOLD_LANTERN)
                        .define('#', VanillishItems.ROSE_GOLD_TORCH)
                        .define('X', Items.IRON_NUGGET)
                        .pattern("XXX")
                        .pattern("X#X")
                        .pattern("XXX")
                        .unlockedBy("has_brass_torch", this.has(VanillishItems.ROSE_GOLD_TORCH))
                        .save(this.output, key("rose_gold_lantern"));

                this.shaped(RecipeCategory.DECORATIONS, VanillishItems.ROSE_GOLD_TORCH, 4)
                        .define('X', Ingredient.of(Items.COAL, Items.CHARCOAL))
                        .define('#', Items.STICK)
                        .define('C', VanillishItems.ROSE_GOLD_NUGGET)
                        .pattern("C")
                        .pattern("X")
                        .pattern("#")
                        .unlockedBy("has_rose_nugget", this.has(VanillishItems.ROSE_GOLD_INGOT))
                        .save(this.output);

                //----

                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, VanillishItems.STEEL_INGOT, RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.STEEL_BLOCK.asItem(), "steel_from_block", "steel"
                );
                nineBlockStorageRecipesRecipesWithCustomUnpacking(
                        RecipeCategory.MISC, VanillishItems.STEEL_NUGGET, RecipeCategory.BUILDING_BLOCKS, VanillishItems.STEEL_INGOT, "steel_from_nuge", "steel_nugget"
                );


                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.STEEL_BLOCK, VanillishBlocks.STEEL_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.STEEL_BLOCK, VanillishBlocks.STEEL_TILES);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.STEEL_BLOCK, VanillishBlocks.STEEL_GRATE);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.STEEL_INGOT, VanillishBlocks.STEEL_LADDER);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.STEEL_INGOT, VanillishBlocks.STEEL_BARS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.STEEL_INGOT, VanillishBlocks.STEEL_SCAFFOLDING);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.STEEL_INGOT, VanillishBlocks.STEEL_CHAIN);

                this.shaped(RecipeCategory.DECORATIONS, VanillishBlocks.STEEL_LANTERN)
                        .define('#', VanillishItems.STEEL_TORCH)
                        .define('X', Items.IRON_NUGGET)
                        .pattern("XXX")
                        .pattern("X#X")
                        .pattern("XXX")
                        .unlockedBy("has_steel_torch", this.has(VanillishItems.STEEL_TORCH))
                        .save(this.output, key("steel_lantern"));

                this.shaped(RecipeCategory.DECORATIONS, VanillishItems.STEEL_TORCH, 4)
                        .define('X', Ingredient.of(Items.COAL, Items.CHARCOAL))
                        .define('#', Items.STICK)
                        .define('C', VanillishItems.STEEL_NUGGET)
                        .pattern("C")
                        .pattern("X")
                        .pattern("#")
                        .unlockedBy("has_steel_nugget", this.has(VanillishItems.STEEL_NUGGET))
                        .save(this.output);

                //----

                shapeless(RecipeCategory.MISC, VanillishBlocks.SCRAP_METAL, 3)
                        .requires(Items.IRON_NUGGET, 2)
                        .requires(VanillishItems.STEEL_NUGGET, 2)
                        .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                        .save(recipeOutput, key("scrap_metal_from_iron_and_copper"));

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.SCRAP_METAL, VanillishBlocks.CARVED_SCRAP_METAL);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.SCRAP_METAL, VanillishBlocks.SCRAP_METAL_TILES);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.SCRAP_METAL, VanillishBlocks.SCRAP_METAL_GRATE);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.SCRAP_METAL_SHARD, VanillishBlocks.SCRAP_METAL_LADDER);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.SCRAP_METAL_SHARD, VanillishBlocks.SCRAP_METAL_DOOR);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.SCRAP_METAL_SHARD, VanillishBlocks.SCRAP_METAL_TRAPDOOR);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.SCRAP_METAL_SHARD, VanillishBlocks.SCRAP_METAL_BARS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, VanillishItems.SCRAP_METAL_SHARD, VanillishBlocks.SCRAP_METAL_CHAIN);

                this.shaped(RecipeCategory.DECORATIONS, VanillishBlocks.SCRAP_METAL_LANTERN)
                        .define('#', VanillishItems.SCRAP_METAL_TORCH)
                        .define('X', Items.IRON_NUGGET)
                        .pattern("XXX")
                        .pattern("X#X")
                        .pattern("XXX")
                        .unlockedBy("has_scrap_metal_torch", this.has(VanillishItems.SCRAP_METAL_TORCH))
                        .save(this.output, key("scrap_metal_lantern"));

                this.shaped(RecipeCategory.DECORATIONS, VanillishItems.SCRAP_METAL_TORCH, 4)
                        .define('X', Ingredient.of(Items.COAL, Items.CHARCOAL))
                        .define('#', Items.STICK)
                        .define('C', VanillishItems.SCRAP_METAL_SHARD)
                        .pattern("C")
                        .pattern("X")
                        .pattern("#")
                        .unlockedBy("has_scrap_metal_nugget", this.has(VanillishItems.SCRAP_METAL_SHARD))
                        .save(this.output, key("gayasstwink"));

                shaped(RecipeCategory.REDSTONE, VanillishBlocks.ADVANCED_RAIL, 16)
                        .pattern("b b")
                        .pattern("sis")
                        .pattern("b b")
                        .define('b', VanillishItems.BRASS_INGOT)
                        .define('s', VanillishItems.STEEL_INGOT)
                        .define('i', Items.STICK)
                        .unlockedBy("has_redstone", has(Items.REDSTONE))
                        .save(recipeOutput);

                shaped(RecipeCategory.REDSTONE, VanillishBlocks.ADVANCED_POWERED_RAIL, 16)
                        .pattern("brb")
                        .pattern("sis")
                        .pattern("brb")
                        .define('b', VanillishItems.BRASS_INGOT)
                        .define('s', VanillishItems.STEEL_INGOT)
                        .define('r', Items.REDSTONE)
                        .define('i', Items.STICK)
                        .unlockedBy("has_redstone", has(Items.REDSTONE))
                        .save(recipeOutput);

                shaped(RecipeCategory.REDSTONE, VanillishBlocks.ADVANCED_DETECTOR_RAIL, 16)
                        .pattern("brb")
                        .pattern("sis")
                        .pattern("brb")
                        .define('b', VanillishItems.BRASS_INGOT)
                        .define('s', VanillishItems.STEEL_INGOT)
                        .define('r', Items.REDSTONE)
                        .define('i', Items.STONE_PRESSURE_PLATE)
                        .unlockedBy("has_redstone", has(Items.REDSTONE))
                        .save(recipeOutput);

                shaped(RecipeCategory.REDSTONE, VanillishBlocks.ADVANCED_STOP_RAIL, 16)
                        .pattern("brb")
                        .pattern("sss")
                        .pattern("brb")
                        .define('b', VanillishItems.BRASS_INGOT)
                        .define('s', VanillishItems.STEEL_INGOT)
                        .define('r', Items.REDSTONE)
                        .unlockedBy("has_redstone", has(Items.REDSTONE))
                        .save(recipeOutput);

                shaped(RecipeCategory.REDSTONE, VanillishBlocks.ADVANCED_DIRECTIONAL_RAIL, 16)
                        .pattern("brb")
                        .pattern("sis")
                        .pattern("brb")
                        .define('b', VanillishItems.BRASS_INGOT)
                        .define('s', VanillishItems.STEEL_INGOT)
                        .define('r', Items.REDSTONE)
                        .define('i', Items.LEVER)
                        .unlockedBy("has_redstone", has(Items.REDSTONE))
                        .save(recipeOutput);

                BlockFamilies.familyBuilder(VanillishBlocks.CHARRED_PLANKS)
                        .button(VanillishBlocks.CHARRED_BUTTON)
                        .fence(VanillishBlocks.CHARRED_FENCE)
                        .fenceGate(VanillishBlocks.CHARRED_FENCE_GATE)
                        .trapdoor(VanillishBlocks.CHARRED_DOOR)
                        .trapdoor(VanillishBlocks.CHARRED_TRAPDOOR)
                        .pressurePlate(VanillishBlocks.CHARRED_PRESSURE_PLATE)
                        .stairs(VanillishBlocks.CHARRED_STAIRS)
                        .slab(VanillishBlocks.CHARRED_SLAB);

                woodFromLogs(VanillishBlocks.CHARRED_WOOD, VanillishBlocks.CHARRED_LOG);
                woodFromLogs(VanillishBlocks.STRIPPED_CHARRED_WOOD, VanillishBlocks.STRIPPED_CHARRED_LOG);

                planksFromLog(VanillishBlocks.CHARRED_PLANKS, VanillishTags.CHARRED_WOOD, 4);


                provider.lookupOrThrow(Registries.ITEM).getOrThrow(ItemTags.LOGS_THAT_BURN).unwrap().ifRight(itemlist -> {
                    for (Holder<Item> item : itemlist) {

                        if (item.getRegisteredName().contains("wood")) {
                            simpleCookingRecipe("smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100, item.value(), VanillishBlocks.CHARRED_WOOD.asItem(), 0.45f);

                        } else {
                            simpleCookingRecipe("smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100, item.value(), VanillishBlocks.CHARRED_LOG.asItem(), 0.45f);

                        }

                    }
                });



            }
        };
    }

    @Override
    public String getName() {
        return "Recipe gendering";
    }

    private static ResourceKey<Recipe<?>> key(String string) {
        return ResourceKey.create(Registries.RECIPE, Vanillish.id(string));
    }
}
