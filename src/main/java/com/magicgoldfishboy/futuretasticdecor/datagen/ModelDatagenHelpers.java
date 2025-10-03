package com.magicgoldfishboy.futuretasticdecor.datagen;


import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.Panel;

import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.DirectionalBlock;

public class ModelDatagenHelpers extends ModelProvider {
    public ModelDatagenHelpers(PackOutput output) {
        super(output, FuturetasticDecor.MODID);
    }

    public static void createPanelModel(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Panel panel, Variant panel_variant) {
        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(
                panel,
                BlockModelGenerators.variant(panel_variant)
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
