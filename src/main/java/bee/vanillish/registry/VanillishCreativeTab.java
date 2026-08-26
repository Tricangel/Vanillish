package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;

public class VanillishCreativeTab {

    public static ArrayList<Item> ITEMS = new ArrayList<>();

    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Vanillish.id("creative_tab")
    );

    public static final CreativeModeTab VANILLISH_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VanillishItems.STEEL_INGOT)).title(Component.translatable("vanillish.creative_tab"))
            .displayItems(((itemDisplayParameters, output) -> {

                ITEMS.forEach(output::accept);

            })).build();


    public static void init() {

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_TAB_KEY, VANILLISH_TAB);

    }

}
