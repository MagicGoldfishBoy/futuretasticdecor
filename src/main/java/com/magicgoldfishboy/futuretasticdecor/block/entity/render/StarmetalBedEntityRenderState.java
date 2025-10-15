package com.magicgoldfishboy.futuretasticdecor.block.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.DyeColor;

public class StarmetalBedEntityRenderState extends BlockEntityRenderState {

    Direction facing;
    public DyeColor color;
    public boolean isHead;
    


    public static LayerDefinition createHeadLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
            .texOffs(0, 0).addBox(-8.0F, -3.0F, -8.0F, 16.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(-14, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
            .texOffs(0, 0).addBox(-8.0F, -6.0F, -8.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), 
            
            PartPose.offsetAndRotation(8.0F, 8.0F, 0.0F, -Mth.PI / 2F, 0.0F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 16, 16);
    }
}
