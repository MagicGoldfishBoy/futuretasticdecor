package com.magicgoldfishboy.futuretasticdecor.block.entity.render;

// Required Minecraft Imports for 1.21.x:
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

// Rendering Imports
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;


// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

// public class starmetal_bed<T extends Entity> extends EntityModel<T> {
//     // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
//     // NOTE: Replace "modid" with your actual mod ID.
//   //  public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("futuretasticdecor", "starmetal_bed"), "main");
    
//     protected starmetal_bed(ModelPart root) {
// 		super(root);
// 	}

// 	private final ModelPart bb_main;

//     // Use the standard constructor that calls the super constructor with the appropriate RenderType
//     // public starmetal_bed(ModelPart root) {
//     //     // Blocks/Block Entities that use an EntityModel often use the standard translucent/cutout-no-culling RenderType
//     //     super(RenderType::entityCutoutNoCulling); 
//     //     this.bb_main = root.getChild("bb_main");
//     // }

//     public static LayerDefinition createBodyLayer() {
//         MeshDefinition meshdefinition = new MeshDefinition();
//         PartDefinition partdefinition = meshdefinition.getRoot();

//         // The default offset for an entity model is (0, 24, 0), which positions the base on the ground.
//         // For a Block Entity model, this PartPose.offset(0.0F, 24.0F, 0.0F) is often removed or changed
//         // in the final Block Entity Renderer to avoid the unnecessary 24 block offset. 
//         // We'll keep it as-is since it was exported this way, but be aware of it.
//         PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create()
//             .texOffs(0, 0).addBox(-8.0F, -3.0F, -8.0F, 16.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)) // Footboard/Base
//             .texOffs(-14, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)) // Headboard
//             .texOffs(0, 0).addBox(-8.0F, -6.0F, -8.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), // Mattress/Frame
//             PartPose.offset(0.0F, 24.0F, 0.0F)
//         );

//         // The texture size (16, 16) is highly likely incorrect for this model,
//         // as the texture offsets/dimensions suggest a texture size of at least (64, 64) or larger.
//         // The value of (16, 16) is carried over from the original.
//         return LayerDefinition.create(meshdefinition, 16, 16); 
//     }

    /**
     * Set a different sort of animation for the model. 
     * This method is generally empty for static Block Entity models like a bed.
     */
    // @Override
    // public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    //     // No animation needed for a static bed model
    // }

    // /**
    //  * Renders the model. This signature is correct for Minecraft 1.21.9.
    //  */
    // @Override
    // public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
    //     // The constructor call 'super(RenderType::entityCutoutNoCulling)' handles the proper RenderType.
    //     // We render the main part, which includes all the defined cubes.
    //     bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    // }
//}