package bee.vanillish.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import java.util.List;

public record BlastChamberFuel(List<Holder<Item>> item, int duration) {
    public static final Codec<BlastChamberFuel> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Item.CODEC.listOf().fieldOf("item").forGetter(BlastChamberFuel::item),
            Codec.INT.fieldOf("duration").forGetter(BlastChamberFuel::duration)
    ).apply(instance, BlastChamberFuel::new));
}
