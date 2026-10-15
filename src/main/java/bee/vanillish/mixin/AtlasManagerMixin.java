package bee.vanillish.mixin;

import bee.vanillish.Vanillish;
import bee.vanillish.registry.VanillishSheets;
import net.minecraft.client.resources.model.AtlasManager;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(AtlasManager.class)
public abstract class AtlasManagerMixin implements PreparableReloadListener, MaterialSet, AutoCloseable {

    @Shadow
    @Final
    private static List<AtlasManager.AtlasConfig> KNOWN_ATLASES;

    static {
        KNOWN_ATLASES = new ArrayList<>(KNOWN_ATLASES);
        KNOWN_ATLASES.add(new AtlasManager.AtlasConfig(VanillishSheets.SANDSTONE_SLATE_SHEET, Vanillish.id("sandstone_slate"), false));
        KNOWN_ATLASES = List.copyOf(KNOWN_ATLASES);
    }

}
