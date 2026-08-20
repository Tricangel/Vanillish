package bee.vanillish.effect;

import bee.vanillish.Vanillish;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.monster.Enemy;

public class ProtectedEffect extends MobEffect {
    public ProtectedEffect(int i) {
        super(MobEffectCategory.BENEFICIAL, i);
    }

}
