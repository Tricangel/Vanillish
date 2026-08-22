package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

public class VanillishRecipeBookCategories {

    public static final RecipeBookCategory BLAST_CHAMBER = Registry.register(BuiltInRegistries.RECIPE_BOOK_CATEGORY, Vanillish.id("blast_chamber"), new RecipeBookCategory());

    public static void init() {}

}
