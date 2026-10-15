package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.sandstoneslate.SandstoneSlateSheet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.entity.DecoratedPotPattern;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;

import static net.minecraft.core.registries.BuiltInRegistries.registerSimple;

public class VanillishRegistries {

    public static final ResourceKey<Registry<SandstoneSlateSheet>> SANDSTONE_SLATE_SHEET_KEY = ResourceKey.createRegistryKey(Vanillish.id("sandstone_slate_sheet"));

    public static final Registry<SandstoneSlateSheet> SANDSTONE_SLATE_SHEET = registerSimple(SANDSTONE_SLATE_SHEET_KEY, b -> VanillishSandstoneSlateSheets.BLANK_SHEET);

    public static void init() {}

}
