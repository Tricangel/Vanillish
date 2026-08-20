package bee.vanillish.registry;

import bee.vanillish.Vanillish;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;


public class VanillishAttachments {

    public static final AttachmentType<Integer> WARDING_TIME = AttachmentRegistry.create(Vanillish.id("warding_time"));

    public static void init() {}

}
