package bee.vanillish.datagen;

import bee.vanillish.Vanillish;
import bee.vanillish.registry.VanillishBlocks;
import bee.vanillish.registry.VanillishItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
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

                shaped(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.WARDING_STONE)
                        .pattern("brb")
                        .pattern("rcr")
                        .pattern("brb")
                        .define('b', Blocks.STONE_BRICKS)
                        .define('r', VanillishItems.ROSE_GOLD)
                        .define('c', Blocks.AMETHYST_CLUSTER)
                        .save(recipeOutput, ResourceKey.create(Registries.RECIPE, Vanillish.id("warding_stone")));



                shaped(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.BLAST_CHAMBER)
                        .pattern("ibi")
                        .pattern("rfr")
                        .pattern("ddd")
                        .define('i', Items.IRON_INGOT)
                        .define('b', Blocks.IRON_BLOCK)
                        .define('r', Items.REDSTONE)
                        .define('f', Blocks.BLAST_FURNACE)
                        .define('d', Blocks.DEEPSLATE_BRICKS)
                        .save(recipeOutput, ResourceKey.create(Registries.RECIPE, Vanillish.id("blast_chamber")));



                shaped(RecipeCategory.BUILDING_BLOCKS, VanillishBlocks.REDSTONE_RANDOMIZER)
                        .pattern("bsb")
                        .pattern("srs")
                        .pattern("bsb")
                        .define('b', VanillishItems.BRASS)
                        .define('s', VanillishItems.STEEL)
                        .define('r', Items.REDSTONE)
                        .save(recipeOutput, ResourceKey.create(Registries.RECIPE, Vanillish.id("redstone_randomizer")));




            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
