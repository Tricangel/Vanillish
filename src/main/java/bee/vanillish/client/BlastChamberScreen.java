package bee.vanillish.client;

import bee.vanillish.Vanillish;
import bee.vanillish.client.recipebook.BlastChamberRecipeBook;
import bee.vanillish.menu.BlastChamberMenu;
import bee.vanillish.registry.VanillishItems;
import bee.vanillish.registry.VanillishRecipeBookCategories;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.navigation.ScreenPosition;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class BlastChamberScreen extends AbstractRecipeBookScreen<BlastChamberMenu> {
    public static final List<RecipeBookComponent.TabInfo> TABS = List.of(
            new RecipeBookComponent.TabInfo(SearchRecipeBookCategory.BLAST_CHAMBER),
            new RecipeBookComponent.TabInfo(VanillishItems.STEEL_INGOT, VanillishRecipeBookCategories.BLAST_CHAMBER)
    );
    public BlastChamberScreen(BlastChamberMenu recipeBookMenu, Inventory inventory, Component component) {
        super(recipeBookMenu, new BlastChamberRecipeBook(recipeBookMenu, TABS, Component.translatable("gui.recipebook.toggleRecipes.blastable")), inventory, component);
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

        if (this.menu.isLit()) {

            int n = Mth.ceil(this.menu.getLitProgress() * 13.0F) + 1;
            guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Vanillish.id("container/gunpowder"), 16, 16, 0, 14 - n, k + 55, l + 35 + 14 - n, 14, n);
        }


        int n = Mth.ceil(this.menu.getBurnProgress() * 24.0F);
        guiGraphics.blitSprite(RenderPipelines.GUI_TEXTURED, Identifier.withDefaultNamespace("container/furnace/burn_progress"), 24, 16, 0, 0, k + 79, l + 34, n, 16);

    }
}
