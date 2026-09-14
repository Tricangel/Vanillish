package bee.vanillish.mixin;

import bee.vanillish.registry.VanillishRecipeBookCategories;
import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(SearchRecipeBookCategory.class)
public enum SearchRecipeBookCategoryMixin {
    BLAST_CHAMBER(VanillishRecipeBookCategories.BLAST_CHAMBER);

    SearchRecipeBookCategoryMixin(final RecipeBookCategory... recipeBookCategory) {

    }
}
