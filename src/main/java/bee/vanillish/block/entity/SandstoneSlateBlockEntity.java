package bee.vanillish.block.entity;

import bee.vanillish.registry.VanillishBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class SandstoneSlateBlockEntity extends BlockEntity {
    public PotDecorations decorations = PotDecorations.EMPTY;
    public SandstoneSlateBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(VanillishBlockEntities.SANDSTONE_SLATE, blockPos, blockState);
    }

    public boolean changeSherd(Direction direction, Item item) {
        Optional<Item> optional = getSide(direction);
        optional.ifPresent(item1 -> {
            if (item.equals(item1)) return;
            Vec3 pos = worldPosition.getCenter().relative(direction, 0.6);
            Containers.dropItemStack(level, pos.x(), pos.y(), pos.z, item1.getDefaultInstance());
        });
        return setSide(direction, item);
    }

    public boolean setSide(Direction direction, Item item) {
        return setSide(direction, Optional.of(item));
    }

    public boolean setSide(Direction direction, Optional<Item> item) {

        switch (direction) {
            case NORTH -> {
                if (!decorations.front().equals(item)) {
                    decorations = new PotDecorations(decorations.back(), decorations.left(), decorations.right(), item);
                    this.setChanged();
                    return true;
                }
            }
            case SOUTH -> {
                if (!decorations.back().equals(item)) {
                    decorations = new PotDecorations(item, decorations.left(), decorations.right(), decorations.front());
                    this.setChanged();
                    return true;
                }
            }
            case WEST -> {
                if (!decorations.left().equals(item)) {
                    decorations = new PotDecorations(decorations.back(), item, decorations.right(), decorations.front());
                    this.setChanged();
                    return true;
                }
            }
            case EAST -> {
                if (!decorations.right().equals(item)) {
                    decorations = new PotDecorations(decorations.back(), decorations.left(), item, decorations.front());
                    this.setChanged();
                    return true;
                }
            }
        }

        return false;
    }

    public Optional<Item> getSide(Direction direction) {
        return switch (direction) {
            case NORTH -> decorations.front();
            case SOUTH -> decorations.back();
            case EAST -> decorations.right();
            case WEST -> decorations.left();
            default -> Optional.empty();
        };
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder builder) {
        super.collectImplicitComponents(builder);
        builder.set(DataComponents.POT_DECORATIONS, decorations);
    }

    @Override
    protected void applyImplicitComponents(DataComponentGetter dataComponentGetter) {
        super.applyImplicitComponents(dataComponentGetter);
        this.decorations = dataComponentGetter.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        return saveWithoutMetadata(provider);
    }

    @Override
    protected void saveAdditional(ValueOutput valueOutput) {
        super.saveAdditional(valueOutput);
        valueOutput.store("decorations", PotDecorations.CODEC, decorations);
    }

    @Override
    protected void loadAdditional(ValueInput valueInput) {
        super.loadAdditional(valueInput);
        valueInput.read("decorations", PotDecorations.CODEC).ifPresent(potDecorations -> decorations = potDecorations);
    }
}
