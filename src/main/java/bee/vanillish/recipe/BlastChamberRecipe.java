package bee.vanillish.recipe;

import bee.vanillish.registry.VanillishRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public class BlastChamberRecipe extends SingleItemRecipe {
    public static final MapCodec<BlastChamberRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.fieldOf("group").forGetter(BlastChamberRecipe::group),
            Ingredient.CODEC.fieldOf("input").forGetter(BlastChamberRecipe::input),
            ItemStack.CODEC.fieldOf("output").forGetter(BlastChamberRecipe::result),
            Codec.INT.fieldOf("time").forGetter(BlastChamberRecipe::getTime)
    ).apply(instance, BlastChamberRecipe::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, BlastChamberRecipe> STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, BlastChamberRecipe::getGroup, Ingredient.CONTENTS_STREAM_CODEC, BlastChamberRecipe::input, ItemStack.STREAM_CODEC, BlastChamberRecipe::result, ByteBufCodecs.INT, BlastChamberRecipe::getTime, BlastChamberRecipe::new);
    private final int time;
    public BlastChamberRecipe(String string, Ingredient ingredient, ItemStack itemStack, int time) {
        super(string, ingredient, itemStack);
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    @Override
    public RecipeSerializer<? extends SingleItemRecipe> getSerializer() {
        return VanillishRecipes.BLAST_CHAMBER_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<? extends SingleItemRecipe> getType() {
        return VanillishRecipes.BLAST_CHAMBER_RECIPE_TYPE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.BLAST_FURNACE_MISC;
    }

    public String getGroup() {
        return this.group();
    }


}
