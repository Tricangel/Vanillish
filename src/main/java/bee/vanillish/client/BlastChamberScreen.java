package bee.vanillish.client;

import bee.vanillish.Vanillish;
import bee.vanillish.client.recipebook.BlastChamberRecipeBook;
import bee.vanillish.menu.BlastChamberMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.navigation.ScreenPosition;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class BlastChamberScreen extends AbstractRecipeBookScreen<BlastChamberMenu> {
    public static final RecipeBookComponent.TabInfo TABS = new RecipeBookComponent.TabInfo(SearchRecipeBookCategory.BLAST_CHAMBER);
    public BlastChamberScreen(BlastChamberMenu recipeBookMenu, Inventory inventory, Component component) {
        super(recipeBookMenu, new BlastChamberRecipeBook(recipeBookMenu, List.of(TABS), Component.translatable("gui.recipebook.toggleRecipes.blastable")), inventory, component);
    }

    @Override
    protected @NonNull ScreenPosition getRecipeBookButtonPosition() {
        return new ScreenPosition(this.leftPos + 20, this.height / 2 - 49);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        int k = this.leftPos;
        int l = this.topPos;
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, Vanillish.id("textures/gui/container/blast_chamber.png"), k, l, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
    }
}
