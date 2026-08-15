package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.data.BlastChamberFuel;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class VanillishRegistries {

    public static final ResourceKey<Registry<BlastChamberFuel>> BLAST_CHAMBER_FUEL = ResourceKey.createRegistryKey(Vanillish.id("blast_chamber_fuel"));

    public static void init() {
        DynamicRegistries.registerSynced(BLAST_CHAMBER_FUEL, BlastChamberFuel.CODEC, DynamicRegistries.SyncOption.SKIP_WHEN_EMPTY);
    }
}
