package bee.vanillish.sandstoneslate;

import bee.vanillish.Vanillish;
import net.minecraft.client.renderer.MaterialMapper;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import java.util.Map;
import java.util.stream.Collectors;

public class VanillishSheets {
    public static final Identifier SANDSTONE_SLATE_SHEET = Vanillish.id("textures/atlas/sandstone_slate.png");

    public static final MaterialMapper SANDSTONE_SLATE_MAPPER = new MaterialMapper(SANDSTONE_SLATE_SHEET, "entity/sandstone_slate");

    public static final Map<ResourceKey<SandstoneSlateSheet>, Material> SANDSTONE_SLATE_MATERIALS = VanillishRegistries.SANDSTONE_SLATE_SHEET
            .listElements()
            .collect(Collectors.toMap(Holder.Reference::key, reference -> SANDSTONE_SLATE_MAPPER.apply(reference.value().identifier())));
    
    public static final Material SANDSTONE_SLATE_BASE = SANDSTONE_SLATE_MAPPER.apply(Vanillish.id("sandstone_slate_base"));
    public static final Material SANDSTONE_SLATE_SIDE = SANDSTONE_SLATE_MAPPER.apply(Vanillish.id("sandstone_slate_side"));


    public static void init() {}

}
