package bee.vanillish.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.happyghast.HappyGhast;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.*;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

    @Shadow
    @Nullable
    public LocalPlayer player;

    @Shadow
    @Nullable
    public MultiPlayerGameMode gameMode;

    @Shadow
    private int rightClickDelay;

    @Shadow
    @Nullable
    public ClientLevel level;

    @Shadow
    @Nullable
    public HitResult hitResult;

    @Shadow
    @Final
    public GameRenderer gameRenderer;

    @Inject(at = @At("HEAD"), method = "startUseItem", cancellable = true)
    private void init(CallbackInfo ci) {

        if (!this.gameMode.isDestroying()) {
            this.rightClickDelay = 4;

            if (!this.player.isHandsBusy()) {

                for (InteractionHand hand : InteractionHand.values()) {
                    ItemStack heldItem = this.player.getItemInHand(hand);
                    if (!heldItem.isItemEnabled(this.level.enabledFeatures())) {
                        return;
                    }

                    if (this.hitResult != null) {

                        if (this.hitResult instanceof EntityHitResult hitResult && hitResult.getEntity() instanceof HappyGhast entity && player.isCrouching() && entity.isOnStillTimeout()) {

                            Vec3 pos = hitResult.getLocation();
                            double y = pos.y;


                            AABB ghastBox = entity.getBoundingBox();

                            AABB top = new AABB(
                                    new Vec3(ghastBox.minX, ghastBox.maxY - .1, ghastBox.minZ),
                                    new Vec3(ghastBox.maxX, ghastBox.maxY, ghastBox.maxZ)
                            );

                            y = Mth.ceil(pos.y);

                            if (top.contains(new Vec3(pos.x, y, pos.z))) {
                                y += 1;
                            }

                            BlockHitResult blockHit = new BlockHitResult(
                                    new Vec3(pos.x, y, pos.z), player.getNearestViewDirection(), BlockPos.containing(pos.x, y, pos.z), player.getBoundingBox().contains(pos)
                            );

                            int oldCount = heldItem.getCount();
                            InteractionResult useResult = this.gameMode.useItemOn(this.player, hand, blockHit);
                            if (useResult instanceof InteractionResult.Success success) {
                                if (success.swingSource() == InteractionResult.SwingSource.CLIENT) {
                                    this.player.swing(hand);
                                    if (!heldItem.isEmpty() && (heldItem.getCount() != oldCount || this.player.hasInfiniteMaterials())) {
                                        this.gameRenderer.itemInHandRenderer.itemUsed(hand);
                                    }
                                }

                                ci.cancel();
                            }

                        }

                    }
                }
            }
        }
    }
}