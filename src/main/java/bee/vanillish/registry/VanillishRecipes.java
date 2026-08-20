package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.recipe.BlastChamberRecipe;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class VanillishRecipes {

    public static final ResourceKey<RecipePropertySet> BLAST_CHAMBER_KEY = ResourceKey.create(RecipePropertySet.TYPE_KEY, Vanillish.id("blast_chamber"));

    public static final RecipeSerializer<BlastChamberRecipe> BLAST_CHAMBER_RECIPE_SERIALIZER = Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER,
            Vanillish.id("blast_chamber"),
            new RecipeSerializer<>() {
                @Override
                public MapCodec<BlastChamberRecipe> codec() {
                    return BlastChamberRecipe.CODEC;
                }

                @Override
                public StreamCodec<RegistryFriendlyByteBuf, BlastChamberRecipe> streamCodec() {
                    return BlastChamberRecipe.STREAM_CODEC;
                }
            }
    );

    public static final RecipeType<BlastChamberRecipe> BLAST_CHAMBER_RECIPE_TYPE = Registry.register(
            BuiltInRegistries.RECIPE_TYPE,
            Vanillish.id("blast_chamber"),
            new RecipeType<BlastChamberRecipe>() { }
    );



    public static void init() {

        RecipeSynchronization.synchronizeRecipeSerializer(BLAST_CHAMBER_RECIPE_SERIALIZER);

    }

}
