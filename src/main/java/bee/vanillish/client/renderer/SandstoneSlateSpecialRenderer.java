package bee.vanillish.client.renderer;

import bee.vanillish.block.entity.renderer.SandstoneSlateBlockEntityRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.DecoratedPotRenderer;
import net.minecraft.client.renderer.special.DecoratedPotSpecialRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.PotDecorations;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

public class SandstoneSlateSpecialRenderer implements SpecialModelRenderer<PotDecorations> {
    private final SandstoneSlateBlockEntityRenderer renderer;
    public SandstoneSlateSpecialRenderer(SandstoneSlateBlockEntityRenderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void submit(@Nullable PotDecorations object, ItemDisplayContext itemDisplayContext, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int i, int j, boolean bl, int k) {
        this.renderer.submit(poseStack, submitNodeCollector, object == null ? PotDecorations.EMPTY : object, j, i, null);
    }

    @Override
    public void getExtents(Consumer<Vector3fc> consumer) {
        this.renderer.getExtents(consumer);
    }

    @Override
    public @Nullable PotDecorations extractArgument(ItemStack itemStack) {
        return itemStack.get(DataComponents.POT_DECORATIONS);
    }

    @Environment(EnvType.CLIENT)
    public record Unbaked() implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<SandstoneSlateSpecialRenderer.Unbaked> MAP_CODEC = MapCodec.unit(new SandstoneSlateSpecialRenderer.Unbaked());

        @Override
        public MapCodec<SandstoneSlateSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(SpecialModelRenderer.BakingContext bakingContext) {
            return new SandstoneSlateSpecialRenderer(new SandstoneSlateBlockEntityRenderer(bakingContext));
        }
    }
}
