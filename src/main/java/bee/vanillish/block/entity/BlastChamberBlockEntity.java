package bee.vanillish.block.entity;

import bee.vanillish.Vanillish;
import bee.vanillish.menu.BlastChamberMenu;
import bee.vanillish.recipe.BlastChamberRecipe;
import bee.vanillish.registry.VanillishBlockEntities;
import bee.vanillish.registry.VanillishRecipes;
import bee.vanillish.registry.VanillishTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import java.util.Optional;

public class BlastChamberBlockEntity extends BaseContainerBlockEntity {
    private final RecipeManager.CachedCheck<SingleRecipeInput, BlastChamberRecipe> quickCheck;
    private final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int i) {
            return switch (i) {
                case 0 -> cookTime;
                case 1 -> totalCookTime;
                case 2 -> litTime;
                case 3 -> totalLitTime;
                default -> 0;
            };
        }

        @Override
        public void set(int i, int j) {
            switch (i) {
                case 0 -> BlastChamberBlockEntity.this.cookTime = j;
                case 1 -> BlastChamberBlockEntity.this.totalCookTime = j;
                case 2 -> BlastChamberBlockEntity.this.litTime = j;
                case 3 -> BlastChamberBlockEntity.this.totalLitTime = j;
            };
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    NonNullList<ItemStack> itemStacks;
    int cookTime = 0;
    int litTime = 0;
    int totalCookTime = 0;
    int totalLitTime = 0;
    public BlastChamberBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(VanillishBlockEntities.BLAST_CHAMBER, blockPos, blockState);
        this.itemStacks = NonNullList.withSize(3, ItemStack.EMPTY);
        this.quickCheck = RecipeManager.createCheck(VanillishRecipes.BLAST_CHAMBER_RECIPE_TYPE);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("block.vanillish.blast_chamber");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.itemStacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {
        this.itemStacks = nonNullList;
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return new BlastChamberMenu(i, inventory, this, dataAccess);
    }

    @Override
    public int getContainerSize() {
        return 3;
    }

    @Override
    protected void saveAdditional(ValueOutput valueOutput) {
        super.saveAdditional(valueOutput);
        ContainerHelper.saveAllItems(valueOutput, itemStacks);
        valueOutput.putInt("cook_time", cookTime);
        valueOutput.putInt("lit_time", litTime);
        valueOutput.putInt("total_cook_time", totalCookTime);
        valueOutput.putInt("total_lit_time", totalLitTime);
    }

    @Override
    protected void loadAdditional(ValueInput valueInput) {
        super.loadAdditional(valueInput);
        ContainerHelper.loadAllItems(valueInput, itemStacks);
        cookTime = valueInput.getIntOr("cook_time", 0);
        litTime = valueInput.getIntOr("lit_time", 0);
        totalCookTime = valueInput.getIntOr("total_cook_time", 0);
        totalLitTime = valueInput.getIntOr("total_lit_time", 0);
    }


    public static boolean canCookItem(BlastChamberBlockEntity entity, ServerLevel serverLevel) {
        if (!entity.itemStacks.getFirst().isEmpty()) {
            SingleRecipeInput input = new SingleRecipeInput(entity.itemStacks.getFirst());

            Optional<? extends RecipeHolder<BlastChamberRecipe>> recipe = entity.quickCheck.getRecipeFor(input, serverLevel);

            if (recipe.isEmpty()) return false;

            ItemStack output = recipe.get().value().assemble(input, serverLevel.registryAccess());
            ItemStack slot = entity.itemStacks.get(2);

            if (slot.isEmpty()) return true;

            if (!ItemStack.isSameItemSameComponents(output, slot)) return false;

            if (slot.getCount() >= slot.getMaxStackSize()) return false;

            return slot.getCount() + output.getCount() <= slot.getMaxStackSize();
        }

        return false;

    }

    public static void cookItem(BlastChamberBlockEntity entity, ServerLevel serverLevel) {
        ItemStack inputItem = entity.itemStacks.getFirst();
        SingleRecipeInput input = new SingleRecipeInput(inputItem);
        RecipeHolder<BlastChamberRecipe> recipe = entity.quickCheck.getRecipeFor(input, serverLevel).get();

        ItemStack output = recipe.value().assemble(input, serverLevel.registryAccess());
        ItemStack slot = entity.itemStacks.get(2);

        if (slot.isEmpty()) entity.itemStacks.set(2, output.copy());

        else if (ItemStack.isSameItemSameComponents(slot, output)) {
            if (output.getMaxStackSize() > slot.getCount()) {
                slot.setCount(slot.getCount() + output.getCount());
                entity.itemStacks.set(2, slot);
            }
        }
        inputItem.shrink(1);
        entity.getItems().set(0, inputItem);
        entity.cookTime = 0;
        entity.totalCookTime = 0;


    }

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, BlastChamberBlockEntity entity) {
        if (level instanceof ServerLevel serverLevel) {
            ItemStack fuel = entity.itemStacks.get(1);

            if (entity.litTime > 0) {
                entity.litTime--;
                level.setBlockAndUpdate(blockPos, blockState.setValue(BlockStateProperties.LIT, true));
            };
            if (entity.litTime == 0) {
                level.setBlockAndUpdate(blockPos, blockState.setValue(BlockStateProperties.LIT, false));
                if (!fuel.is(VanillishTags.FUEL)) {
                    entity.totalLitTime = 0;
                    if (entity.cookTime > 0) {
                        entity.cookTime--;
                    } else entity.totalCookTime = 0;
                    return;
                }
            }

            if (canCookItem(entity, serverLevel)) {
                if (fuel.is(VanillishTags.FUEL) && entity.litTime == 0) {
                    if (fuel.is(Items.TNT)) {
                        level.explode(null,blockPos.getX(), blockPos.getY(), blockPos.getZ(), 2, Level.ExplosionInteraction.BLOCK);
                        return;
                    }
                    entity.litTime = 400;
                    entity.totalLitTime = 400;
                    fuel.shrink(1);
                    entity.itemStacks.set(1, fuel);
                }

                if (entity.litTime > 0) {
                    Optional<RecipeHolder<BlastChamberRecipe>> output = entity.quickCheck.getRecipeFor(new SingleRecipeInput(entity.itemStacks.getFirst()), serverLevel);
                    if (output.isEmpty()) {
                        Vanillish.LOGGER.error("Missing recipe for {}", entity.itemStacks.getFirst().getItem());
                        return;
                    }
                    if (entity.totalCookTime == 0) {

                        entity.totalCookTime = output.get().value().getTime();

                    }

                        entity.cookTime++;

                    if (entity.cookTime > output.get().value().getTime()) {

                        cookItem(entity, serverLevel);

                    }
                }

            }


        }
    }


}
