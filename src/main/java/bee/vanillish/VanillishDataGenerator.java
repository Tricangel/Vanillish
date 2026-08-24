package bee.vanillish;

import bee.vanillish.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

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
	}
}
