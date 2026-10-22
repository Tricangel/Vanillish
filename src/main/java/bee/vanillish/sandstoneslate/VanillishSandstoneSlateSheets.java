package bee.vanillish.sandstoneslate;

import bee.vanillish.Vanillish;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;


import org.jspecify.annotations.Nullable;

import java.util.Map;

public class VanillishSandstoneSlateSheets {
    public static final ResourceKey<SandstoneSlateSheet> BLANK = create("blank");
    public static final ResourceKey<SandstoneSlateSheet> ANGLER = create("angler");
    public static final ResourceKey<SandstoneSlateSheet> ARCHER = create("archer");
    public static final ResourceKey<SandstoneSlateSheet> ARMS_UP = create("arms_up");
    public static final ResourceKey<SandstoneSlateSheet> BLADE = create("blade");
    public static final ResourceKey<SandstoneSlateSheet> BREWER = create("brewer");
    public static final ResourceKey<SandstoneSlateSheet> BURN = create("burn");
    public static final ResourceKey<SandstoneSlateSheet> DANGER = create("danger");
    public static final ResourceKey<SandstoneSlateSheet> EXPLORER = create("explorer");
    public static final ResourceKey<SandstoneSlateSheet> FLOW = create("flow");
    public static final ResourceKey<SandstoneSlateSheet> FRIEND = create("friend");
    public static final ResourceKey<SandstoneSlateSheet> GUSTER = create("guster");
    public static final ResourceKey<SandstoneSlateSheet> HEART = create("heart");
    public static final ResourceKey<SandstoneSlateSheet> HEARTBREAK = create("heartbreak");
    public static final ResourceKey<SandstoneSlateSheet> HOWL = create("howl");
    public static final ResourceKey<SandstoneSlateSheet> MINER = create("miner");
    public static final ResourceKey<SandstoneSlateSheet> MOURNER = create("mourner");
    public static final ResourceKey<SandstoneSlateSheet> PLENTY = create("plenty");
    public static final ResourceKey<SandstoneSlateSheet> PRIZE = create("prize");
    public static final ResourceKey<SandstoneSlateSheet> SCRAPE = create("scrape");
    public static final ResourceKey<SandstoneSlateSheet> SHEAF = create("sheaf");
    public static final ResourceKey<SandstoneSlateSheet> SHELTER = create("shelter");
    public static final ResourceKey<SandstoneSlateSheet> SKULL = create("skull");
    public static final ResourceKey<SandstoneSlateSheet> SNORT = create("snort");
    private static final Map<Item, ResourceKey<SandstoneSlateSheet>> ITEM_TO_POT_TEXTURE = Map.ofEntries(
            Map.entry(Items.BRICK, BLANK),
            Map.entry(Items.ANGLER_POTTERY_SHERD, ANGLER),
            Map.entry(Items.ARCHER_POTTERY_SHERD, ARCHER),
            Map.entry(Items.ARMS_UP_POTTERY_SHERD, ARMS_UP),
            Map.entry(Items.BLADE_POTTERY_SHERD, BLADE),
            Map.entry(Items.BREWER_POTTERY_SHERD, BREWER),
            Map.entry(Items.BURN_POTTERY_SHERD, BURN),
            Map.entry(Items.DANGER_POTTERY_SHERD, DANGER),
            Map.entry(Items.EXPLORER_POTTERY_SHERD, EXPLORER),
            Map.entry(Items.FLOW_POTTERY_SHERD, FLOW),
            Map.entry(Items.FRIEND_POTTERY_SHERD, FRIEND),
            Map.entry(Items.GUSTER_POTTERY_SHERD, GUSTER),
            Map.entry(Items.HEART_POTTERY_SHERD, HEART),
            Map.entry(Items.HEARTBREAK_POTTERY_SHERD, HEARTBREAK),
            Map.entry(Items.HOWL_POTTERY_SHERD, HOWL),
            Map.entry(Items.MINER_POTTERY_SHERD, MINER),
            Map.entry(Items.MOURNER_POTTERY_SHERD, MOURNER),
            Map.entry(Items.PLENTY_POTTERY_SHERD, PLENTY),
            Map.entry(Items.PRIZE_POTTERY_SHERD, PRIZE),
            Map.entry(Items.SCRAPE_POTTERY_SHERD, SCRAPE),
            Map.entry(Items.SHEAF_POTTERY_SHERD, SHEAF),
            Map.entry(Items.SHELTER_POTTERY_SHERD, SHELTER),
            Map.entry(Items.SKULL_POTTERY_SHERD, SKULL),
            Map.entry(Items.SNORT_POTTERY_SHERD, SNORT)
    );

    public static @Nullable ResourceKey<SandstoneSlateSheet> getPatternFromItem(Item item) {
        return ITEM_TO_POT_TEXTURE.get(item);
    }

    private static ResourceKey<SandstoneSlateSheet> create(String string) {
        return ResourceKey.create(VanillishRegistries.SANDSTONE_SLATE_SHEET_KEY, Vanillish.id(string));
    }
    
    public static final SandstoneSlateSheet ANGLER_SHEET = register(ANGLER, "sandstone_slate_angler");
    public static final SandstoneSlateSheet ARCHER_SHEET = register(ARCHER, "sandstone_slate_archer");
    public static final SandstoneSlateSheet ARMS_UP_SHEET = register(ARMS_UP, "sandstone_slate_arms_up");
    public static final SandstoneSlateSheet BLADE_SHEET = register(BLADE, "sandstone_slate_blade");
    public static final SandstoneSlateSheet BREWER_SHEET = register(BREWER, "sandstone_slate_brewer");
    public static final SandstoneSlateSheet BURN_SHEET = register(BURN, "sandstone_slate_burn");
    public static final SandstoneSlateSheet DANGER_SHEET = register(DANGER, "sandstone_slate_danger");
    public static final SandstoneSlateSheet EXPLORER_SHEET = register(EXPLORER, "sandstone_slate_explorer");
    public static final SandstoneSlateSheet FLOW_SHEET = register(FLOW, "sandstone_slate_flow");
    public static final SandstoneSlateSheet FRIEND_SHEET = register(FRIEND, "sandstone_slate_friend");
    public static final SandstoneSlateSheet GUSTER_SHEET = register(GUSTER, "sandstone_slate_guster");
    public static final SandstoneSlateSheet HEART_SHEET = register(HEART, "sandstone_slate_heart");
    public static final SandstoneSlateSheet HEARTBREAK_SHEET = register(HEARTBREAK, "sandstone_slate_heartbreak");
    public static final SandstoneSlateSheet HOWL_SHEET = register(HOWL, "sandstone_slate_howl");
    public static final SandstoneSlateSheet MINER_SHEET = register(MINER, "sandstone_slate_miner");
    public static final SandstoneSlateSheet MOURNER_SHEET = register(MOURNER, "sandstone_slate_mourner");
    public static final SandstoneSlateSheet PLENTY_SHEET = register(PLENTY, "sandstone_slate_plenty");
    public static final SandstoneSlateSheet PRIZE_SHEET = register(PRIZE, "sandstone_slate_prize");
    public static final SandstoneSlateSheet SCRAPE_SHEET = register(SCRAPE, "sandstone_slate_scrape");
    public static final SandstoneSlateSheet SHEAF_SHEET = register(SHEAF, "sandstone_slate_sheaf");
    public static final SandstoneSlateSheet SHELTER_SHEET = register(SHELTER, "sandstone_slate_shelter");
    public static final SandstoneSlateSheet SKULL_SHEET = register(SKULL, "sandstone_slate_skull");
    public static final SandstoneSlateSheet SNORT_SHEET = register(SNORT, "sandstone_slate_snort");
    public static final SandstoneSlateSheet BLANK_SHEET = register(BLANK, "sandstone_slate_side");


    private static SandstoneSlateSheet register(ResourceKey<SandstoneSlateSheet> resourceKey, String string) {
        return Registry.register(VanillishRegistries.SANDSTONE_SLATE_SHEET, resourceKey, new SandstoneSlateSheet(Vanillish.id(string)));
    }

    public static void init() {}

}
