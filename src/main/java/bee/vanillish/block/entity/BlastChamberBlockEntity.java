package bee.vanillish.block.entity;

import bee.vanillish.menu.BlastChamberMenu;
import bee.vanillish.registry.VanillishBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlastChamberBlockEntity extends BaseContainerBlockEntity {
    NonNullList<ItemStack> itemStacks;
    public BlastChamberBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(VanillishBlockEntities.BLAST_CHAMBER, blockPos, blockState);
        this.itemStacks = NonNullList.withSize(3, ItemStack.EMPTY);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("vanillish.block.blast_chamber");
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
        return new BlastChamberMenu(i, inventory, this);
    }

    @Override
    public int getContainerSize() {
        return 3;
    }
}
