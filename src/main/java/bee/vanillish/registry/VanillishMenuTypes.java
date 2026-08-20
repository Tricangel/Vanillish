package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.menu.BlastChamberMenu;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class VanillishMenuTypes {

    public static final MenuType<BlastChamberMenu> BLAST_CHAMBER = register("blast_chamber", BlastChamberMenu::new);

    private static <T extends AbstractContainerMenu> MenuType<T> register(String string, MenuType.MenuSupplier<T> menuSupplier) {
        return Registry.register(BuiltInRegistries.MENU, Vanillish.id(string), new MenuType<T>(menuSupplier, FeatureFlags.VANILLA_SET));
    }

    public static void init() {
    }
}
