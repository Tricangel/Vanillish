package bee.vanillish.datagen;

import bee.vanillish.Vanillish;
import bee.vanillish.registry.VanillishEnchantments;
import bee.vanillish.registry.VanillishTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;

import java.util.concurrent.CompletableFuture;

public class VanillishEnchantmentGen extends FabricDynamicRegistryProvider {
    public VanillishEnchantmentGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        entries.addAll(provider.lookupOrThrow(Registries.ENCHANTMENT));
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.identifier()));
    }

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        register(context, VanillishEnchantments.TRAINED,
                Enchantment.enchantment(Enchantment.definition(
                                context.lookup(Registries.ITEM).getOrThrow(VanillishTags.SADDLES),
                                25,
                                3,
                                Enchantment.dynamicCost(1, 5),
                                Enchantment.dynamicCost(1, 10),
                                5,
                                EquipmentSlotGroup.SADDLE, EquipmentSlotGroup.BODY
                        ))
                        .withEffect(
                                EnchantmentEffectComponents.ATTRIBUTES,
                                new EnchantmentAttributeEffect(Vanillish.id("trained"),
                                        Attributes.FLYING_SPEED,
                                        LevelBasedValue.perLevel(0.015f),
                                        AttributeModifier.Operation.ADD_VALUE)
                        ).withEffect(
                                EnchantmentEffectComponents.ATTRIBUTES,
                                new EnchantmentAttributeEffect(Vanillish.id("trained"),
                                        Attributes.MOVEMENT_SPEED,
                                        LevelBasedValue.perLevel(0.05f),
                                        AttributeModifier.Operation.ADD_VALUE)
                        ));

        register(context, VanillishEnchantments.BULKY,
                Enchantment.enchantment(Enchantment.definition(
                                context.lookup(Registries.ITEM).getOrThrow(VanillishTags.SADDLES),
                                25,
                                3,
                                Enchantment.dynamicCost(1, 5),
                                Enchantment.dynamicCost(1, 10),
                                5,
                                EquipmentSlotGroup.SADDLE, EquipmentSlotGroup.BODY
                        ))
                        .withEffect(
                                EnchantmentEffectComponents.ATTRIBUTES,
                                new EnchantmentAttributeEffect(Vanillish.id("bulky"),
                                        Attributes.MAX_HEALTH,
                                        LevelBasedValue.perLevel(2f),
                                        AttributeModifier.Operation.ADD_VALUE)
                        ));


        register(context, VanillishEnchantments.ENERGIZED,
                Enchantment.enchantment(Enchantment.definition(
                                context.lookup(Registries.ITEM).getOrThrow(VanillishTags.SADDLES),
                                25,
                                3,
                                Enchantment.dynamicCost(1, 5),
                                Enchantment.dynamicCost(1, 10),
                                5,
                                EquipmentSlotGroup.SADDLE
                        ))
                        .withEffect(
                                EnchantmentEffectComponents.ATTRIBUTES,
                                new EnchantmentAttributeEffect(Vanillish.id("energized"),
                                        Attributes.JUMP_STRENGTH,
                                        LevelBasedValue.perLevel(0.05f),
                                        AttributeModifier.Operation.ADD_VALUE)
                        ));
    }

    @Override
    public String getName() {
        return "gay enchantments";
    }
}
