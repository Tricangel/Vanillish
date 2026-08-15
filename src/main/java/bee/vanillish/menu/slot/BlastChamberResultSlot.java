package bee.vanillish.menu.slot;

import bee.vanillish.data.BlastChamberFuel;
import bee.vanillish.menu.BlastChamberMenu;
import bee.vanillish.registry.VanillishRegistries;
import net.minecraft.core.Registry;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;

public class BlastChamberResultSlot extends Slot {
    public BlastChamberResultSlot(Container container, int i, int j, int k, BlastChamberMenu menu) {
        super(container, i, j, k);
    }

    @Override
    public boolean mayPlace(@NonNull ItemStack itemStack) {
        return false;
    }


}
