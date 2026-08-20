package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import bee.vanillish.effect.ProtectedEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

public class VanillishEffects {

    public static final Holder<MobEffect> PROTECTED = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Vanillish.id("protected"), new ProtectedEffect(1));

    public static void init() {}

}
