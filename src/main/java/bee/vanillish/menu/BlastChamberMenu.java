package bee.vanillish.menu;

import bee.vanillish.Vanillish;
import bee.vanillish.data.BlastChamberFuel;
import bee.vanillish.menu.slot.BlastChamberFuelSlot;
import bee.vanillish.menu.slot.BlastChamberResultSlot;
import bee.vanillish.registry.VanillishMenuTypes;
import bee.vanillish.registry.VanillishRecipes;
import bee.vanillish.registry.VanillishTags;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class BlastChamberMenu extends RecipeBookMenu {
    public Level level;
    public Player player;
    private final RecipePropertySet acceptedInputs;
    private final ContainerData data;
    public BlastChamberMenu(int i, Inventory inventory) {
        this(i, inventory, new SimpleContainer(3), new SimpleContainerData(4));
    }

    public BlastChamberMenu(int i, Inventory inventory, Container container, ContainerData data) {
        super(VanillishMenuTypes.BLAST_CHAMBER, i);
        this.level = inventory.player.level();
        this.player = inventory.player;
        checkContainerSize(container, 3);
        checkContainerDataCount(data, 4);
        this.data = data;
        this.acceptedInputs = level.recipeAccess().propertySet(VanillishRecipes.BLAST_CHAMBER_KEY);
        this.addSlot(new Slot(container, 0, 56, 17));
        this.addSlot(new BlastChamberFuelSlot(container, 1, 56, 53, this));
        this.addSlot(new BlastChamberResultSlot(container, 2, 116, 35, this));
        this.addStandardInventorySlots(inventory, 8, 84);
        this.addDataSlots(data);
        container.startOpen(player);
    }

    public Slot getResultSlot() {
        return slots.get(2);
    }

    @Override
    public PostPlaceAction handlePlacement(boolean bl, boolean bl2, RecipeHolder<?> recipeHolder, ServerLevel serverLevel, Inventory inventory) {
        return PostPlaceAction.PLACE_GHOST_RECIPE;
    }

    @Override
    public void fillCraftSlotsStackedContents(StackedItemContents stackedItemContents) {



    }

    public boolean isLit() {
        return data.get(2) > 0;
    }

    public float getBurnProgress() {

        int i = data.get(0);
        int j = data.get(1);

        if (i == 0 | j == 0) return 0;

        return Mth.clamp((float)i / (float)j, 0.0F, 1.0F);
    }

    public float getLitProgress() {
        int i = this.data.get(3);
        if (i == 0) {
            i = 200;
        }

        return Mth.clamp((float)this.data.get(2) / (float)i, 0.0F, 1.0F);
    }

    @Override
    public RecipeBookType getRecipeBookType() {
        return RecipeBookType.BLAST_FURNACE;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.getSlot(i);

        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemStack = itemStack.copy();

            if (i == 2) {

                if (moveItemStackTo(stack, 2, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(stack, itemStack);

            } else if (i != 1 && i != 0) {
                if (this.canSmelt(stack)) {
                    if (!this.moveItemStackTo(stack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(stack.getItem())) {
                    if (!this.moveItemStackTo(stack, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (i >= 3 && i < 30) {
                    if (!this.moveItemStackTo(stack, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (i >= 30 && i < 39 && !this.moveItemStackTo(stack, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }

            } else if (!this.moveItemStackTo(stack, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stack.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stack);

        }
        return itemStack;
    }


    public boolean canSmelt(ItemStack stack) {
        return acceptedInputs.test(stack);
    }

    public boolean isFuel(Item item) {
        return item.getDefaultInstance().is(VanillishTags.FUEL);

    }

    @Override
    public boolean stillValid(@NonNull Player player) {
        return true;
    }
}
