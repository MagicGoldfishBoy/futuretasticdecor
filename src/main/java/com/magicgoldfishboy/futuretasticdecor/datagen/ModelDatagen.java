package com.magicgoldfishboy.futuretasticdecor.datagen;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.Panel;
import com.magicgoldfishboy.futuretasticdecor.registry.CraftingMaterialRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.GlowBlockRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.MetalRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.Nonnull;

public class ModelDatagen extends ModelProvider {
    public ModelDatagen(PackOutput output) {
        super(output, FuturetasticDecor.MODID);
    }

    @Override
    protected void registerModels(@Nonnull BlockModelGenerators blockModels, @Nonnull ItemModelGenerators itemModels) {
        registerMaterialModels(blockModels, itemModels);
        registerMetalModels(blockModels, itemModels);
        registerGlowBlockModels(blockModels, itemModels);
    }

    protected void registerMaterialModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(CraftingMaterialRegistry.COKE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(CraftingMaterialRegistry.STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.RED_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.ORANGE_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.YELLOW_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.LIME_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.GREEN_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.CYAN_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.LIGHT_BLUE_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.BLUE_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.PURPLE_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.MAGENTA_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.PINK_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
    }

    protected void registerMetalModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(MetalRegistry.STEEL_ALLOY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MetalRegistry.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MetalRegistry.STEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(MetalRegistry.STEEL_BLOCK.get());

        blockModels.familyWithExistingFullBlock(MetalRegistry.STEEL_BLOCK.get())
            .slab(MetalRegistry.STEEL_SLAB.get())
            .stairs(MetalRegistry.STEEL_STAIRS.get())
        ;

        blockModels.createTrivialCube(MetalRegistry.GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.RED_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.ORANGE_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.YELLOW_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.LIME_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.GREEN_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.CYAN_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.LIGHT_BLUE_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.BLUE_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.PURPLE_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.MAGENTA_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.PINK_GLOWING_STEEL_BLOCK.get());
    }
    protected void registerGlowBlockModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        blockModels.createTrivialCube(GlowBlockRegistry.GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.RED_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.ORANGE_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.YELLOW_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.LIME_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.GREEN_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.CYAN_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.LIGHT_BLUE_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.BLUE_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.PURPLE_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.MAGENTA_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.PINK_GLOW_BLOCK.get());



        Panel glow_panel = GlowBlockRegistry.GLOW_PANEL.get();
        Variant glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(glow_panel));

        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(
                glow_panel,
                BlockModelGenerators.variant(glow_panel_variant)
            ).with(
                PropertyDispatch.modify(DirectionalBlock.FACING)
                    .select(Direction.SOUTH, BlockModelGenerators.NOP)
                    .select(Direction.NORTH, BlockModelGenerators.Y_ROT_180)
                    .select(Direction.WEST, BlockModelGenerators.Y_ROT_90)
                    .select(Direction.EAST, BlockModelGenerators.Y_ROT_270)
                    .select(Direction.UP, BlockModelGenerators.X_ROT_90)
                    .select(Direction.DOWN, BlockModelGenerators.X_ROT_270)
            )
        );

    }
}
