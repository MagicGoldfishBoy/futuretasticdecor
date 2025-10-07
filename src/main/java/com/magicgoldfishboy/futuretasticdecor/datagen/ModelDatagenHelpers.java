package com.magicgoldfishboy.futuretasticdecor.datagen;


import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.Panel;

import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

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
    // Generates blockstates for a connectable "pipe-like" block with line/corner/plain variants based on connections.
    public static void createConnectableBlock(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block,
                                              Variant block_variant_plain, Variant block_variant_line, Variant block_variant_corner) {

        MultiVariant plain = new MultiVariant(WeightedList.of(block_variant_plain));
        MultiVariant line = new MultiVariant(WeightedList.of(block_variant_line));
        MultiVariant corner = new MultiVariant(WeightedList.of(block_variant_corner));

        // Assumes the block has boolean properties for connections in each direction (NORTH, SOUTH, EAST, WEST, UP, DOWN)
blockModels.blockStateOutput.accept(
    MultiVariantGenerator.dispatch(block).with(
        PropertyDispatch.initial(
            BlockStateProperties.DOWN, 
            BlockStateProperties.EAST, 
            BlockStateProperties.WEST, 
            BlockStateProperties.UP
        )
        // Now define all 64 possible combinations (2^6 = 64)
        .select(false, false, false, false, plain)
        // Lines (opposite connections)
        .select(true, false, false, false, line)
        .select(false, true, true, false, line)
        .select(false, false, true, true, line)
        // Corners (adjacent connections)
        .select(true, false, true, false,corner)
        .select(true, false, false, true,corner)
    )
);
    }
    
}

    //     SoulBrassBarrel soul_brass_barrel = MetalRegistry.SOUL_BRASS_BARREL.get();
    //     Variant soul_brass_barrel_closed = new Variant(ModelLocationUtils.getModelLocation(soul_brass_barrel));
    //     Variant soul_brass_barrel_open = new Variant(modLocation("block/soul_brass_barrel_open"));
    //     MultiVariant soul_brass_barrel_closed_multi = new MultiVariant(WeightedList.of(soul_brass_barrel_closed));
    //     MultiVariant soul_brass_barrel_open_multi = new MultiVariant(WeightedList.of(soul_brass_barrel_open));

    //     blockModels.blockStateOutput.accept(
    //         MultiVariantGenerator.dispatch(soul_brass_barrel).with(
    //             PropertyDispatch.initial(BlockStateProperties.OPEN)
    //                 .select(false, soul_brass_barrel_closed_multi)
    //                 .select(true, soul_brass_barrel_open_multi)
    //         ).with(
    //         PropertyDispatch.modify(DirectionalBlock.FACING)
    //             .select(Direction.SOUTH, BlockModelGenerators.NOP)
    //             .select(Direction.NORTH, BlockModelGenerators.Y_ROT_180)
    //             .select(Direction.WEST, BlockModelGenerators.Y_ROT_90)
    //             .select(Direction.EAST, BlockModelGenerators.Y_ROT_270)
    //             .select(Direction.UP, BlockModelGenerators.X_ROT_90)
    //             .select(Direction.DOWN, BlockModelGenerators.X_ROT_270)
    //         )
    //    );