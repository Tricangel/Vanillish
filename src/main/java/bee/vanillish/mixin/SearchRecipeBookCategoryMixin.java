package bee.vanillish.mixin;

import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SearchRecipeBookCategory.class)
public enum SearchRecipeBookCategoryMixin {
    BLAST_CHAMBER(RecipeBookCategories.BLAST_FURNACE_MISC);


    SearchRecipeBookCategoryMixin(RecipeBookCategory... recipeBookCategory) {
    }
}
