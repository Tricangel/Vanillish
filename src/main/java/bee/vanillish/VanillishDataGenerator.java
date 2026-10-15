package bee.vanillish;

import bee.vanillish.datagen.*;
import bee.vanillish.registry.VanillishEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.VanillaEnchantmentTagsProvider;

public class VanillishDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(VanillishModelGen::new);
		pack.addProvider(VanillishBlockTagGen::new);
		pack.addProvider(VanillishItemTagGen::new);
		pack.addProvider(VanillishLangGen::new);
		pack.addProvider(VanillishRecipeGen::new);
		pack.addProvider(VanillishBlockLoot::new);
		pack.addProvider(VanillishEnchantmentGen::new);
		pack.addProvider(VanillishEnchantmentTagProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.ENCHANTMENT, VanillishEnchantmentGen::bootstrap);
	}
}
