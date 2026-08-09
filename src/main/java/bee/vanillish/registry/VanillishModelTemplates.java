package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class VanillishModelTemplates {

    public static final ModelTemplate SCAFFOLDING_STABLE = create("template_scaffolding_stable", TextureSlot.PARTICLE, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);
    public static final ModelTemplate SCAFFOLDING_UNSTABLE = create("template_scaffolding_unstable", TextureSlot.PARTICLE, TextureSlot.TOP, TextureSlot.SIDE, TextureSlot.BOTTOM);

    private static ModelTemplate create(String string, TextureSlot... textureSlots) {
        return new ModelTemplate(Optional.of(Vanillish.id("block/" + string)), Optional.empty(), textureSlots);
    }

    public static TextureMapping getScaffoldingTexture(Block block) {
        Identifier top = getBlockTexture(block, "_top");
        Identifier side = getBlockTexture(block, "_side");
        Identifier bottom = getBlockTexture(block, "_bottom");

        return new TextureMapping().put(TextureSlot.TOP, top).put(TextureSlot.SIDE, side).put(TextureSlot.BOTTOM, bottom).put(TextureSlot.PARTICLE, top);
    }
    public static TextureMapping getUnstableScaffoldingTexture(Block block) {
        Identifier top = getBlockTexture(block, "_top");
        Identifier side = getBlockTexture(block, "_unstable_side");
        Identifier bottom = getBlockTexture(block, "_bottom");

        return new TextureMapping().put(TextureSlot.TOP, top).put(TextureSlot.SIDE, side).put(TextureSlot.BOTTOM, bottom).put(TextureSlot.PARTICLE, top);
    }


    public static Identifier getBlockTexture(Block block, String string) {
        Identifier identifier = BuiltInRegistries.BLOCK.getKey(block);
        return identifier.withPath((string2) -> "block/" + string2 + string);
    }
}
