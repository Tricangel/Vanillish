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

public class BlastChamberFuelSlot extends Slot {
    final BlastChamberMenu menu;
    public BlastChamberFuelSlot(Container container, int i, int j, int k, BlastChamberMenu menu) {
        super(container, i, j, k);
        this.menu = menu;
    }

    @Override
    public boolean mayPlace(@NonNull ItemStack itemStack) {
        Level level = menu.level;
        Registry<BlastChamberFuel> fuelRegistry = level.registryAccess().lookupOrThrow(VanillishRegistries.BLAST_CHAMBER_FUEL);

        for (BlastChamberFuel fuel : fuelRegistry.stream().toList()) {

            if (fuel.item().contains(itemStack.getItemHolder())) {
                return true;
            }

        }

        return false;
    }
}
