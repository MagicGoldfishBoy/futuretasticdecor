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
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.data.PackOutput;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class ModelDatagenHelpers extends ModelProvider {
    public ModelDatagenHelpers(PackOutput output) {
        super(output, FuturetasticDecor.MODID);
    }

    public static void createBasicDeskLampModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block, Variant lamp_off, Variant lamp_on) {

        MultiVariant off_multivariant = new MultiVariant(WeightedList.of(lamp_off));
        MultiVariant on_multivariant = new MultiVariant(WeightedList.of(lamp_on));

        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(block).with(
                PropertyDispatch.initial(BlockStateProperties.LIT)
                    .select(false, off_multivariant)
                    .select(true, on_multivariant)
            )
        );
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
    public static void createHorizontalRotationModel(BlockModelGenerators blockModels, ItemModelGenerators itemModels, HorizontalDirectionalBlock block, Variant variant) {
        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(
                block,
                BlockModelGenerators.variant(variant)
            ).with(
                PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                    .select(Direction.SOUTH, BlockModelGenerators.NOP)
                    .select(Direction.NORTH, BlockModelGenerators.Y_ROT_180)
                    .select(Direction.WEST, BlockModelGenerators.Y_ROT_90)
                    .select(Direction.EAST, BlockModelGenerators.Y_ROT_270)
            )
        );
    }
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
    public static void createRotatableStorageBlock(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block,
    Variant closed_variant, Variant open_variant) {

        MultiVariant closed_multivariant = new MultiVariant(WeightedList.of(closed_variant));
        MultiVariant open_multivariant = new MultiVariant(WeightedList.of(open_variant));

        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(block).with(
                PropertyDispatch.initial(BlockStateProperties.OPEN)
                    .select(false, closed_multivariant)
                    .select(true, open_multivariant)
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
    public static void createDeviceBlock(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block,
    Variant closed_variant, Variant open_variant) {

        MultiVariant closed_multivariant = new MultiVariant(WeightedList.of(closed_variant));
        MultiVariant open_multivariant = new MultiVariant(WeightedList.of(open_variant));

        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(block).with(
                PropertyDispatch.initial(BlockStateProperties.OPEN)
                    .select(false, closed_multivariant)
                    .select(true, open_multivariant)
            ).with(
            PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.SOUTH, BlockModelGenerators.NOP)
                .select(Direction.NORTH, BlockModelGenerators.Y_ROT_180)
                .select(Direction.WEST, BlockModelGenerators.Y_ROT_90)
                .select(Direction.EAST, BlockModelGenerators.Y_ROT_270)
            )
        );
    }

    public static void createSlidingDoor(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block, Variant closed_top,
    Variant open_top_left, Variant open_top_right, Variant closed_bottom, Variant open_bottom_left, Variant open_bottom_right) {

        MultiVariant closed_top_multivariant = new MultiVariant(WeightedList.of(closed_top));
        MultiVariant open_top_left_multivariant = new MultiVariant(WeightedList.of(open_top_left));
        MultiVariant open_top_right_multivariant = new MultiVariant(WeightedList.of(open_top_right));

        MultiVariant closed_bottom_multivariant = new MultiVariant(WeightedList.of(closed_bottom));
        MultiVariant open_bottom_left_multivariant = new MultiVariant(WeightedList.of(open_bottom_left));
        MultiVariant open_bottom_right_multivariant = new MultiVariant(WeightedList.of(open_bottom_right));

        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(block).with(
                PropertyDispatch.initial(                        
                       BlockStateProperties.HORIZONTAL_FACING,
                        BlockStateProperties.DOUBLE_BLOCK_HALF,
                        BlockStateProperties.DOOR_HINGE,
                        BlockStateProperties.OPEN)

                    .select(Direction.EAST, DoubleBlockHalf.LOWER, DoorHingeSide.LEFT, false, closed_bottom_multivariant.with(BlockModelGenerators.Y_ROT_90))
                    .select(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHingeSide.LEFT, false, closed_bottom_multivariant.with(BlockModelGenerators.Y_ROT_180))
                    .select(Direction.WEST, DoubleBlockHalf.LOWER, DoorHingeSide.LEFT, false, closed_bottom_multivariant.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHingeSide.LEFT, false, closed_bottom_multivariant)//.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.EAST, DoubleBlockHalf.LOWER, DoorHingeSide.RIGHT, false, closed_bottom_multivariant.with(BlockModelGenerators.Y_ROT_90))
                    .select(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHingeSide.RIGHT, false, closed_bottom_multivariant.with(BlockModelGenerators.Y_ROT_180))
                    .select(Direction.WEST, DoubleBlockHalf.LOWER, DoorHingeSide.RIGHT, false, closed_bottom_multivariant.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHingeSide.RIGHT, false, closed_bottom_multivariant)//.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.EAST, DoubleBlockHalf.LOWER, DoorHingeSide.LEFT, true, open_bottom_left_multivariant.with(BlockModelGenerators.Y_ROT_90))
                    .select(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHingeSide.LEFT, true, open_bottom_left_multivariant.with(BlockModelGenerators.Y_ROT_180))
                    .select(Direction.WEST, DoubleBlockHalf.LOWER, DoorHingeSide.LEFT, true, open_bottom_left_multivariant.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHingeSide.LEFT, true, open_bottom_left_multivariant)
                    .select(Direction.EAST, DoubleBlockHalf.LOWER, DoorHingeSide.RIGHT, true, open_bottom_right_multivariant.with(BlockModelGenerators.Y_ROT_90))
                    .select(Direction.SOUTH, DoubleBlockHalf.LOWER, DoorHingeSide.RIGHT, true, open_bottom_right_multivariant.with(BlockModelGenerators.Y_ROT_180))
                    .select(Direction.WEST, DoubleBlockHalf.LOWER, DoorHingeSide.RIGHT, true, open_bottom_right_multivariant.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.NORTH, DoubleBlockHalf.LOWER, DoorHingeSide.RIGHT, true, open_bottom_right_multivariant)//.with(BlockModelGenerators.Y_ROT_180))

                    .select(Direction.EAST, DoubleBlockHalf.UPPER, DoorHingeSide.LEFT, false, closed_top_multivariant.with(BlockModelGenerators.Y_ROT_90))
                    .select(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHingeSide.LEFT, false, closed_top_multivariant.with(BlockModelGenerators.Y_ROT_180))
                    .select(Direction.WEST, DoubleBlockHalf.UPPER, DoorHingeSide.LEFT, false, closed_top_multivariant.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHingeSide.LEFT, false, closed_top_multivariant)//.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.EAST, DoubleBlockHalf.UPPER, DoorHingeSide.RIGHT, false, closed_top_multivariant.with(BlockModelGenerators.Y_ROT_90))
                    .select(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHingeSide.RIGHT, false, closed_top_multivariant.with(BlockModelGenerators.Y_ROT_180))
                    .select(Direction.WEST, DoubleBlockHalf.UPPER, DoorHingeSide.RIGHT, false, closed_top_multivariant.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHingeSide.RIGHT, false, closed_top_multivariant)//.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.EAST, DoubleBlockHalf.UPPER, DoorHingeSide.LEFT, true, open_top_left_multivariant.with(BlockModelGenerators.Y_ROT_90))
                    .select(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHingeSide.LEFT, true, open_top_left_multivariant.with(BlockModelGenerators.Y_ROT_180))
                    .select(Direction.WEST, DoubleBlockHalf.UPPER, DoorHingeSide.LEFT, true, open_top_left_multivariant.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHingeSide.LEFT, true, open_top_left_multivariant)
                    .select(Direction.EAST, DoubleBlockHalf.UPPER, DoorHingeSide.RIGHT, true, open_top_right_multivariant.with(BlockModelGenerators.Y_ROT_90))
                    .select(Direction.SOUTH, DoubleBlockHalf.UPPER, DoorHingeSide.RIGHT, true, open_top_right_multivariant.with(BlockModelGenerators.Y_ROT_180))
                    .select(Direction.WEST, DoubleBlockHalf.UPPER, DoorHingeSide.RIGHT, true, open_top_right_multivariant.with(BlockModelGenerators.Y_ROT_270))
                    .select(Direction.NORTH, DoubleBlockHalf.UPPER, DoorHingeSide.RIGHT, true, open_top_right_multivariant)//.with(BlockModelGenerators.Y_ROT_180))
            )
        );

    }

    public static void createWallpaperModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block, Variant up_variant, Variant middle_variant, 
    Variant down_variant, Variant single_variant) {

            MultiVariant holowallpaper_up_multi = new MultiVariant(WeightedList.of(up_variant));
            MultiVariant holowallpaper_middle_multi = new MultiVariant(WeightedList.of(middle_variant));
            MultiVariant holowallpaper_down_multi = new MultiVariant(WeightedList.of(down_variant));
            MultiVariant holowallpaper_single_multi = new MultiVariant(WeightedList.of(single_variant));

        blockModels.blockStateOutput.accept(
            MultiPartGenerator.multiPart(block)
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.UP, true).term(BlockStateProperties.DOWN, false),
                    holowallpaper_down_multi
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.UP, false).term(BlockStateProperties.DOWN, false),
                    holowallpaper_single_multi
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.UP, true).term(BlockStateProperties.DOWN, true),
                    holowallpaper_middle_multi
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.UP, false).term(BlockStateProperties.DOWN, true),
                    holowallpaper_up_multi
                )
        );
    }

public static void createPillarModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block, 
    Variant up_variant, Variant middle_variant, Variant down_variant, Variant single_variant) {
    MultiVariant up_multivariant = new MultiVariant(WeightedList.of(up_variant));
    MultiVariant middle_multivariant = new MultiVariant(WeightedList.of(middle_variant));
    MultiVariant down_multivariant = new MultiVariant(WeightedList.of(down_variant));
    MultiVariant single_multivariant = new MultiVariant(WeightedList.of(single_variant));
    
    blockModels.blockStateOutput.accept(
        MultiPartGenerator.multiPart(block)
            // Y-axis connections (no rotation needed)
            .with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.UP, true)
                    .term(BlockStateProperties.DOWN, false)
                    .term(BlockStateProperties.AXIS, Axis.Y),
                down_multivariant
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.UP, false)
                    .term(BlockStateProperties.DOWN, false)
                    .term(BlockStateProperties.AXIS, Axis.Y),
                single_multivariant
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.UP, true)
                    .term(BlockStateProperties.DOWN, true)
                    .term(BlockStateProperties.AXIS, Axis.Y),
                middle_multivariant
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.UP, false)
                    .term(BlockStateProperties.DOWN, true)
                    .term(BlockStateProperties.AXIS, Axis.Y),
                up_multivariant
            )
            // X-axis connections (rotate 90° around X, then 90° around Y)
            .with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.EAST, true)
                    .term(BlockStateProperties.WEST, false)
                    .term(BlockStateProperties.AXIS, Axis.X),
                down_multivariant.with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.Y_ROT_90)
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.EAST, false)
                    .term(BlockStateProperties.WEST, false)
                    .term(BlockStateProperties.AXIS, Axis.X),
                single_multivariant.with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.Y_ROT_90)
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.EAST, true)
                    .term(BlockStateProperties.WEST, true)
                    .term(BlockStateProperties.AXIS, Axis.X),
                middle_multivariant.with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.Y_ROT_90)
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.EAST, false)
                    .term(BlockStateProperties.WEST, true)
                    .term(BlockStateProperties.AXIS, Axis.X),
                up_multivariant.with(BlockModelGenerators.X_ROT_90).with(BlockModelGenerators.Y_ROT_90)
            )
            // Z-axis connections (rotate 90° around X)
            .with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.NORTH, true)
                    .term(BlockStateProperties.SOUTH, false)
                    .term(BlockStateProperties.AXIS, Axis.Z),
                down_multivariant.with(BlockModelGenerators.X_ROT_90)
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.NORTH, false)
                    .term(BlockStateProperties.SOUTH, false)
                    .term(BlockStateProperties.AXIS, Axis.Z),
                single_multivariant.with(BlockModelGenerators.X_ROT_90)
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.NORTH, true)
                    .term(BlockStateProperties.SOUTH, true)
                    .term(BlockStateProperties.AXIS, Axis.Z),
                middle_multivariant.with(BlockModelGenerators.X_ROT_90)
            ).with(
                BlockModelGenerators.condition()
                    .term(BlockStateProperties.NORTH, false)
                    .term(BlockStateProperties.SOUTH, true)
                    .term(BlockStateProperties.AXIS, Axis.Z),
                up_multivariant.with(BlockModelGenerators.X_ROT_90)
            )
    );
}
    
    public static void createConnectableBlock(BlockModelGenerators blockModels, ItemModelGenerators itemModels, Block block,
        Variant block_variant_plain, Variant block_variant_line, Variant block_variant_corner) {

        MultiVariant plain = new MultiVariant(WeightedList.of(block_variant_plain));
        MultiVariant line = new MultiVariant(WeightedList.of(block_variant_line));
        MultiVariant corner = new MultiVariant(WeightedList.of(block_variant_corner));


        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(block).with(
                PropertyDispatch.initial(
                    BlockStateProperties.DOWN, 
                    BlockStateProperties.EAST, 
                    BlockStateProperties.WEST, 
                    BlockStateProperties.UP
                )

                .select(false, false, false, false, plain)

                .select(true, false, false, false, line)
                .select(false, true, true, false, line)
                .select(false, false, true, true, line)

                .select(true, false, true, false,corner)
                .select(true, false, false, true,corner)
            )
        );
    }
    
}

