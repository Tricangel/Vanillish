package bee.vanillish.registry;

import bee.vanillish.recipe.BlastChamberRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class VanillishSerializers {

    public static final RecipeSerializer<BlastChamberRecipe> BLAST_CHAMBER = RecipeSerializer.register("blast_chamber", new BlastChamberRecipe.Serializer());

    public static void init() {}
}
