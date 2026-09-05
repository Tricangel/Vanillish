package bee.vanillish.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.equine.AbstractHorse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractHorse.class)
public class AbstractHorseMixin {

    @ModifyReturnValue(at = @At(value = "RETURN"), method = "createBaseHorseAttributes")
    private static AttributeSupplier.Builder init(AttributeSupplier.Builder original) {
        return original.add(Attributes.STEP_HEIGHT, 1.2);
    }

}
