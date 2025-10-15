package com.magicgoldfishboy.futuretasticdecor.block.entity.render;

import javax.annotation.Nullable;

import com.magicgoldfishboy.futuretasticdecor.block.entity.BedEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.core.Direction;
import net.minecraft.util.Unit;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

public class StarmetalBedRenderer implements BlockEntityRenderer<BedEntity, StarmetalBedEntityRenderState> {
    private final MaterialSet materials;
    private final Model.Simple headModel;
    private final Model.Simple footModel;

    public StarmetalBedRenderer(BlockEntityRendererProvider.Context context) {
        this.materials = context.materials();
        EntityModelSet modelSet = context.entityModelSet();
        // You can use vanilla bed models or create your own
        this.headModel = new Model.Simple(modelSet.bakeLayer(ModelLayers.BED_HEAD), RenderType::entitySolid);
        this.footModel = new Model.Simple(modelSet.bakeLayer(ModelLayers.BED_FOOT), RenderType::entitySolid);
    }

    @Override
    public StarmetalBedEntityRenderState createRenderState() {
        return new StarmetalBedEntityRenderState();
    }

    @Override
    public void extractRenderState(BedEntity blockEntity, StarmetalBedEntityRenderState renderState, 
                                   float partialTick, Vec3 cameraPos, 
                                   @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, renderState, partialTick, cameraPos, crumblingOverlay);
        BlockState blockState = blockEntity.getBlockState();
        renderState.facing = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        renderState.isHead = blockState.getValue(BedBlock.PART) == BedPart.HEAD;
    }
    @Override
    public void submit(StarmetalBedEntityRenderState renderState, PoseStack poseStack, 
                      SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        // Get the material for your bed (you can use a custom color or texture)
        Material material = Sheets.getBedMaterial(DyeColor.PURPLE); // Change to your desired color
        
        poseStack.pushPose();
        preparePose(poseStack, renderState.facing);
        
        // Submit the model for rendering
        Model.Simple model = renderState.isHead ? this.headModel : this.footModel;
        
        submitNodeCollector.submitModel(
            model,
            Unit.INSTANCE,
            poseStack,
            material.renderType(RenderType::entitySolid),
            renderState.lightCoords,
            OverlayTexture.NO_OVERLAY,
            -1,
            this.materials.get(material),
            0,
            renderState.breakProgress
        );
        
        poseStack.popPose();
    }
    
    private static void preparePose(PoseStack poseStack, Direction direction) {
        poseStack.translate(0.0F, 0.5625F, 0.0F);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F + direction.toYRot()));
        poseStack.translate(-0.5F, -0.5F, -0.5F);
    }
}