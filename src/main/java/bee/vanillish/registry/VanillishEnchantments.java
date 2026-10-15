package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class VanillishEnchantments {

    public static final ResourceKey<Enchantment> TRAINED = key("trained");
    public static final ResourceKey<Enchantment> BULKY = key("bulky");
    public static final ResourceKey<Enchantment> ENERGIZED = key("energized");



    private static ResourceKey<Enchantment> key(String path) {
        return ResourceKey.create(Registries.ENCHANTMENT, Vanillish.id(path));
    }

}
