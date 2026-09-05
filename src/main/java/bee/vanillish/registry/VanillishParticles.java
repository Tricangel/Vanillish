package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class VanillishParticles {

    public static final SimpleParticleType BRASS_FLAME = FabricParticleTypes.simple();
    public static final SimpleParticleType ROSE_GOLD_FLAME = FabricParticleTypes.simple();
    public static final SimpleParticleType STEEL_FLAME = FabricParticleTypes.simple();
    public static final SimpleParticleType SCRAP_METAL_FLAME = FabricParticleTypes.simple();


    public static void init() {

        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Vanillish.id("brass_flame"), BRASS_FLAME);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Vanillish.id("rose_gold_flame"), ROSE_GOLD_FLAME);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Vanillish.id("steel_flame"), STEEL_FLAME);
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Vanillish.id("scrap_metal_flame"), SCRAP_METAL_FLAME);


    }

}
