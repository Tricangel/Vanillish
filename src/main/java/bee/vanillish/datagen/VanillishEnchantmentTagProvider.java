package bee.vanillish.datagen;

import bee.vanillish.registry.VanillishEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.concurrent.CompletableFuture;

public class VanillishEnchantmentTagProvider extends FabricTagProvider<Enchantment> {
    public VanillishEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ENCHANTMENT, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        builder(EnchantmentTags.NON_TREASURE)
                .add(VanillishEnchantments.TRAINED)
                .add(VanillishEnchantments.ENERGIZED)
                .add(VanillishEnchantments.BULKY);
    }
}
