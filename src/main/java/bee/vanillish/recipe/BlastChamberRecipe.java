package bee.vanillish.recipe;

import bee.vanillish.data.BlastChamberFuel;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

import java.util.List;

public class BlastChamberRecipe extends SingleItemRecipe {
    public static final MapCodec<BlastChamberRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.fieldOf("group").forGetter(BlastChamberRecipe::group),
            Ingredient.CODEC.fieldOf("input").forGetter(BlastChamberRecipe::input),
            ItemStack.CODEC.fieldOf("output").forGetter(BlastChamberRecipe::result),
            Codec.FLOAT.fieldOf("time").forGetter(BlastChamberRecipe::getTime)
    ).apply(instance, BlastChamberRecipe::new));
    private final float time;
    public BlastChamberRecipe(String string, Ingredient ingredient, ItemStack itemStack, float time) {
        super(string, ingredient, itemStack);
        this.time = time;
    }

    public float getTime() {
        return time;
    }

    @Override
    public RecipeSerializer<? extends SingleItemRecipe> getSerializer() {

        return new Serializer();
    }

    @Override
    public RecipeType<? extends SingleItemRecipe> getType() {
        return RecipeType.SMOKING;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.BLAST_FURNACE_MISC;
    }

    public String getGroup() {
        return this.group();
    }

    public static class Serializer implements RecipeSerializer<BlastChamberRecipe> {

        @Override
        public MapCodec<BlastChamberRecipe> codec() {
            return BlastChamberRecipe.CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BlastChamberRecipe> streamCodec() {
            return StreamCodec.composite(ByteBufCodecs.STRING_UTF8, BlastChamberRecipe::getGroup, Ingredient.CONTENTS_STREAM_CODEC, BlastChamberRecipe::input, ItemStack.STREAM_CODEC, BlastChamberRecipe::result, ByteBufCodecs.FLOAT, BlastChamberRecipe::getTime, BlastChamberRecipe::new);
        }
    }

}
