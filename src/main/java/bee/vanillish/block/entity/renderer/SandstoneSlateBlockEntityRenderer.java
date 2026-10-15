package bee.vanillish.block.entity.renderer;

import bee.vanillish.Vanillish;
import bee.vanillish.block.entity.SandstoneSlateBlockEntity;
import bee.vanillish.registry.VanillishSandstoneSlateSheets;
import bee.vanillish.registry.VanillishSheets;
import bee.vanillish.sandstoneslate.SandstoneSlateSheet;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.DecoratedPotPatterns;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3fc;
import org.jspecify.annotations.Nullable;

import java.util.Optional;
import java.util.function.Consumer;

public class SandstoneSlateBlockEntityRenderer implements BlockEntityRenderer<SandstoneSlateBlockEntity, SandstoneSlateRenderState> {
    public static final ModelLayerLocation SANDSTONE_SLATE_BASE = new ModelLayerLocation(Vanillish.id("sandstone_slate"), "main");
    private final MaterialSet materials;
    private final ModelPart down;
    private final ModelPart up;
    private final ModelPart right;
    private final ModelPart front;
    private final ModelPart back;
    private final ModelPart left;

    public SandstoneSlateBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this(context.entityModelSet(), context.materials());
    }

    public SandstoneSlateBlockEntityRenderer(SpecialModelRenderer.BakingContext bakingContext) {
        this(bakingContext.entityModelSet(), bakingContext.materials());
    }

    public SandstoneSlateBlockEntityRenderer(EntityModelSet entityModelSet, MaterialSet materialSet) {
        this.materials = materialSet;
        ModelPart modelPart = entityModelSet.bakeLayer(SANDSTONE_SLATE_BASE);
        this.down = modelPart.getChild("down");
        this.up = modelPart.getChild("up");
        this.right = modelPart.getChild("right");
        this.front = modelPart.getChild("front");
        this.back = modelPart.getChild("back");
        this.left = modelPart.getChild("left");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition down = partdefinition.addOrReplaceChild("down", CubeListBuilder.create(), PartPose.offset(7.0F, 24.0F, -7.0F));

        PartDefinition cube_r1 = down.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-16, 0).addBox(-15.0F, 0.0F, -1.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, 3.1416F, 0.0F, 0.0F));

        PartDefinition up = partdefinition.addOrReplaceChild("up", CubeListBuilder.create().texOffs(-16, 0).addBox(-15.0F, -16.0F, -1.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 24.0F, -7.0F));

        PartDefinition right = partdefinition.addOrReplaceChild("right", CubeListBuilder.create(), PartPose.offset(7.0F, 8.0F, -7.0F));

        PartDefinition cube_r2 = right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, -16).addBox(1.0F, 0.0F, -1.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 16.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition front = partdefinition.addOrReplaceChild("front", CubeListBuilder.create(), PartPose.offset(7.0F, 24.0F, 9.0F));

        PartDefinition cube_r3 = front.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 0.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, -16.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r4 = back.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, 0.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 7.0F, 0.0F, 3.1416F, -3.1416F));

        PartDefinition left = partdefinition.addOrReplaceChild("left", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r5 = left.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, -16).addBox(1.0F, 0.0F, -1.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 7.0F, 3.1416F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public SandstoneSlateRenderState createRenderState() {
        return new SandstoneSlateRenderState();
    }

    private static Material getSideMaterial(Optional<Item> optional) {
        if (optional.isPresent()) {
            Material material = VanillishSheets.SANDSTONE_SLATE_MATERIALS.get(VanillishSandstoneSlateSheets.getPatternFromItem(optional.get()));
            if (material != null && !optional.get().equals(Items.BRICK)) {
                return material;
            }
        }

        return VanillishSheets.SANDSTONE_SLATE_SIDE;
    }

    @Override
    public void extractRenderState(SandstoneSlateBlockEntity blockEntity, SandstoneSlateRenderState blockEntityRenderState, float f, Vec3 vec3, ModelFeatureRenderer.@Nullable CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, blockEntityRenderState, f, vec3, crumblingOverlay);
        blockEntityRenderState.decorations = blockEntity.decorations;
    }

    @Override
    public void submit(SandstoneSlateRenderState blockEntityRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        int j = OverlayTexture.NO_OVERLAY;
        int i = blockEntityRenderState.lightCoords;
        PotDecorations potDecorations = blockEntityRenderState.decorations;

        this.submit(poseStack, submitNodeCollector, potDecorations, j, i, blockEntityRenderState.breakProgress);

    }
    
    public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, PotDecorations potDecorations, int j, int i, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        poseStack.pushPose();

        poseStack.translate(0.5, -0.5, 0.5);

        RenderType renderType = VanillishSheets.SANDSTONE_SLATE_BASE.renderType(RenderTypes::entitySolid);
        TextureAtlasSprite textureAtlasSprite = this.materials.get(VanillishSheets.SANDSTONE_SLATE_BASE);

        submitNodeCollector.submitModelPart(this.up, poseStack, renderType, i, j, textureAtlasSprite, false, false, -1, breakProgress, 0);
        submitNodeCollector.submitModelPart(this.down, poseStack, renderType, i, j, textureAtlasSprite, false, false, -1, breakProgress, 0);

        Material material = getSideMaterial(potDecorations.front());
        submitNodeCollector.submitModelPart(
                this.front, poseStack, material.renderType(RenderTypes::entitySolid), i, j, this.materials.get(material), false, false, -1, breakProgress, 0
        );
        Material material2 = getSideMaterial(potDecorations.back());
        submitNodeCollector.submitModelPart(
                this.back, poseStack, material2.renderType(RenderTypes::entitySolid), i, j, this.materials.get(material2), false, false, -1, breakProgress, 0
        );
        Material material3 = getSideMaterial(potDecorations.left());
        submitNodeCollector.submitModelPart(
                this.left, poseStack, material3.renderType(RenderTypes::entitySolid), i, j, this.materials.get(material3), false, false, -1, breakProgress, 0
        );
        Material material4 = getSideMaterial(potDecorations.right());
        submitNodeCollector.submitModelPart(
                this.right, poseStack, material4.renderType(RenderTypes::entitySolid), i, j, this.materials.get(material4), false, false, -1, breakProgress, 0
        );



        poseStack.popPose();
    }


    public void getExtents(Consumer<Vector3fc> consumer) {
        PoseStack poseStack = new PoseStack();
        this.up.getExtentsForGui(poseStack, consumer);
        this.down.getExtentsForGui(poseStack, consumer);
    }
}
