package bee.vanillish.client.recipebook;

import bee.vanillish.menu.BlastChamberMenu;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.screens.recipebook.GhostSlots;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.RecipeCollection;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.crafting.display.FurnaceRecipeDisplay;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class BlastChamberRecipeBook extends RecipeBookComponent<BlastChamberMenu> {
    private final Component recipeFilterName;
    private static final WidgetSprites FILTER_SPRITES = new WidgetSprites(Identifier.withDefaultNamespace("recipe_book/blast_chamber_filter_enabled"), Identifier.withDefaultNamespace("recipe_book/blast_chamber_filter_disabled"), Identifier.withDefaultNamespace("recipe_book/blast_chamber_filter_enabled_highlighted"), Identifier.withDefaultNamespace("recipe_book/blast_chamber_filter_disabled_highlighted"));

    public BlastChamberRecipeBook(BlastChamberMenu recipeBookMenu, List<TabInfo> list, Component recipeFilterName) {
        super(recipeBookMenu, list);
        this.recipeFilterName = recipeFilterName;
    }

    @Override
    protected @NonNull WidgetSprites getFilterButtonTextures() {
        return FILTER_SPRITES;
    }

    @Override
    protected boolean isCraftingSlot(Slot slot) {
        return slot.index == 1;
    }

    @Override
    protected void selectMatchingRecipes(RecipeCollection recipeCollection, StackedItemContents stackedItemContents) {
        recipeCollection.selectRecipes(stackedItemContents, recipeDisplay -> recipeDisplay instanceof FurnaceRecipeDisplay);
    }

    @Override
    protected @NonNull Component getRecipeFilterName() {
        return recipeFilterName;
    }

    @Override
    protected void fillGhostRecipe(GhostSlots ghostSlots, RecipeDisplay recipeDisplay, ContextMap contextMap) {
        ghostSlots.setResult(menu.getResultSlot(), contextMap, recipeDisplay.result());
        if (recipeDisplay instanceof FurnaceRecipeDisplay furnaceRecipeDisplay) {
            ghostSlots.setInput(this.menu.slots.get(0), contextMap, furnaceRecipeDisplay.ingredient());
            Slot slot = this.menu.slots.get(1);
            if (slot.getItem().isEmpty()) {
                ghostSlots.setInput(slot, contextMap, furnaceRecipeDisplay.fuel());
            }
        }
    }
}
