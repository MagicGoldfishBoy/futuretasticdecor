package com.magicgoldfishboy.futuretasticdecor.datagen;


import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.Panel;
import com.magicgoldfishboy.futuretasticdecor.block.Wallpaper;
import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;

import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
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
    // public static void createWallpaperModel(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
    //     blockModels.createTrivialCube(LaboratoryDecorRegistry.HOLOTILES_BLOCK.get());

    //         Wallpaper holowallpaper = LaboratoryDecorRegistry.HOLOWALLPAPER.get();
    //         Variant holowallpaper_up = new Variant(modLocation("block/holowallpaper_up"));
    //         Variant holowallpaper_middle = new Variant(modLocation("block/holowallpaper_middle"));
    //         Variant holowallpaper_down = new Variant(modLocation("block/holowallpaper_down"));
    //         Variant holowallpaper_single = new Variant(modLocation("block/holowallpaper_single"));

    //         MultiVariant holowallpaper_up_multi = new MultiVariant(WeightedList.of(holowallpaper_up));
    //         MultiVariant holowallpaper_middle_multi = new MultiVariant(WeightedList.of(holowallpaper_middle));
    //         MultiVariant holowallpaper_down_multi = new MultiVariant(WeightedList.of(holowallpaper_down));
    //         MultiVariant holowallpaper_single_multi = new MultiVariant(WeightedList.of(holowallpaper_single));

    //     blockModels.blockStateOutput.accept(
    //         MultiPartGenerator.multiPart(holowallpaper)
    //             .with(
    //                 BlockModelGenerators.condition().term(BlockStateProperties.UP, true).term(BlockStateProperties.DOWN, false),
    //                 holowallpaper_down_multi
    //             )
    //             .with(
    //                 BlockModelGenerators.condition().term(BlockStateProperties.UP, false).term(BlockStateProperties.DOWN, false),
    //                 holowallpaper_single_multi
    //             )
    //             .with(
    //                 BlockModelGenerators.condition().term(BlockStateProperties.UP, true).term(BlockStateProperties.DOWN, true),
    //                 holowallpaper_middle_multi
    //             )
    //             .with(
    //                 BlockModelGenerators.condition().term(BlockStateProperties.UP, false).term(BlockStateProperties.DOWN, true),
    //                 holowallpaper_up_multi
    //             )
    //     );
    //     itemModels.itemModelOutput.accept(
    //         LaboratoryDecorRegistry.HOLOWALLPAPER_ITEM.get(),
    //         ItemModelUtils.plainModel(modLocation("block/holowallpaper_single"))
    //     );
    // }

    public static void createTableModel(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block, Variant single,
        Variant center, Variant north, Variant east, Variant south, Variant west, Variant north_and_south, Variant east_and_north, Variant east_and_south, 
        Variant east_and_west, Variant west_and_north, Variant west_and_south, Variant north_east_south, Variant north_west_south, Variant east_south_west,
        Variant north_east_west) {

            MultiVariant single_multi = new MultiVariant(WeightedList.of(single));

            MultiVariant center_multi = new MultiVariant(WeightedList.of(center));

            MultiVariant north_multi = new MultiVariant(WeightedList.of(north));
            MultiVariant north_and_south_multi = new MultiVariant(WeightedList.of(north_and_south));

            MultiVariant east_multi = new MultiVariant(WeightedList.of(east));
            MultiVariant east_and_north_multi = new MultiVariant(WeightedList.of(east_and_north));
            MultiVariant east_and_south_multi = new MultiVariant(WeightedList.of(east_and_south));
            MultiVariant east_and_west_multi = new MultiVariant(WeightedList.of(east_and_west));

            MultiVariant south_multi = new MultiVariant(WeightedList.of(south));
            
            MultiVariant west_multi = new MultiVariant(WeightedList.of(west));
            MultiVariant west_and_north_multi = new MultiVariant(WeightedList.of(west_and_north));
            MultiVariant west_and_south_multi = new MultiVariant(WeightedList.of(west_and_south));

            MultiVariant north_east_south_multi = new MultiVariant(WeightedList.of(north_east_south));
            MultiVariant north_west_south_multi = new MultiVariant(WeightedList.of(north_west_south));
            MultiVariant east_south_west_multi = new MultiVariant(WeightedList.of(east_south_west));
            MultiVariant north_east_west_multi = new MultiVariant(WeightedList.of(north_east_west));

            blockModels.blockStateOutput.accept(
                MultiPartGenerator.multiPart(block)
                    .with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false)
                        .term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false),
                        single_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, true)
                        .term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, true),
                        center_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, false)
                        .term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false),
                        north_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, false)
                        .term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, false),
                        north_and_south_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, true)
                        .term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false),
                        east_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, true)
                        .term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, false),
                        east_and_north_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, true)
                        .term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, false),
                        east_and_south_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, true)
                        .term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, true),
                        east_and_west_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false)
                        .term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, false),
                        south_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false)
                        .term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, true),
                        west_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, false)
                        .term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, true),
                        west_and_north_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, false)
                        .term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, true),
                        west_and_south_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, true)
                        .term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, false),
                        north_east_south_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, false)
                        .term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, true),
                        north_west_south_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.EAST, true)
                        .term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.WEST, true),
                        east_south_west_multi
                    ).with(
                        BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.EAST, true)
                        .term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.WEST, true),
                        north_east_west_multi
                    )
            );
    }

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