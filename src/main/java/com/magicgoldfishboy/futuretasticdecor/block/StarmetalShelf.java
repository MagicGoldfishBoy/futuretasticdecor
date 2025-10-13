package com.magicgoldfishboy.futuretasticdecor.block;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StarmetalShelf extends HorizontalDirectionalBlock {

    public static final MapCodec<StarmetalShelf> CODEC = simpleCodec(StarmetalShelf::new);

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NORTH = Shapes.or(
        Block.box(13, 10, 15.5, 16, 12.5, 16), Block.box(0, 10, 15.5, 3, 12.5, 16), Block.box(13, 11, 15, 16, 12, 15.5),
        Block.box(0, 11, 15, 3, 12, 15.5), Block.box(13, 11.5, 14.5, 16, 12.5, 15), Block.box(0, 11.5, 14.5, 3, 12.5, 15),
        Block.box(13, 12.5, 15, 16, 14, 16), Block.box(3, 12.5, 15, 13, 13, 16), Block.box(12, 13, 15, 13, 13.5, 16),
        Block.box(3, 13, 15, 4, 13.5, 16), Block.box(3, 13.5, 15, 13, 14, 16), Block.box(0, 12.5, 15, 3, 14, 16),
        Block.box(13, 12.5, 14, 16, 13, 15), Block.box(0, 12.5, 14, 3, 13, 15), Block.box(13, 12.5, 13.5, 16, 14, 14),
        Block.box(0, 12.5, 13.5, 3, 14, 14), Block.box(0, 14, 15, 16, 15, 16), Block.box(0, 14, 13, 16, 16, 15),
        Block.box(14, 13, 0, 16, 15, 0.5), Block.box(2, 13, 0, 14, 14, 0.5), Block.box(0, 13, 0, 2, 15, 0.5),
        Block.box(0, 13.5, 0.5, 16, 14, 2), Block.box(0, 14, 1.5, 16, 14.5, 2), Block.box(0, 14.5, 1.5, 16, 15, 2.5),
        Block.box(0, 15, 0, 16, 16, 13)
    );
    private static final VoxelShape SHAPE_EAST = Shapes.or(
        Block.box(0, 10, 13, 0.5, 12.5, 16), Block.box(0, 10, 0, 0.5, 12.5, 3), Block.box(0.5, 11, 13, 1, 12, 16),
        Block.box(0.5, 11, 0, 1, 12, 3), Block.box(1, 11.5, 13, 1.5, 12.5, 16), Block.box(1, 11.5, 0, 1.5, 12.5, 3),
        Block.box(0, 12.5, 13, 1, 14, 16), Block.box(0, 12.5, 3, 1, 13, 13), Block.box(0, 13, 12, 1, 13.5, 13),
        Block.box(0, 13, 3, 1, 13.5, 4), Block.box(0, 13.5, 3, 1, 14, 13), Block.box(0, 12.5, 0, 1, 14, 3),
        Block.box(1, 12.5, 13, 2, 13, 16), Block.box(1, 12.5, 0, 2, 13, 3), Block.box(2, 12.5, 13, 2.5, 14, 16),
        Block.box(2, 12.5, 0, 2.5, 14, 3), Block.box(0, 14, 0, 1, 15, 16), Block.box(1, 14, 0, 3, 16, 16),
        Block.box(15.5, 13, 14, 16, 15, 16), Block.box(15.5, 13, 2, 16, 14, 14), Block.box(15.5, 13, 0, 16, 15, 2),
        Block.box(14, 13.5, 0, 15.5, 14, 16), Block.box(14, 14, 0, 14.5, 14.5, 16), Block.box(13.5, 14.5, 0, 14.5, 15, 16),
        Block.box(3, 15, 0, 16, 16, 16)
    );
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
        Block.box(0, 10, 0, 3, 12.5, 0.5), Block.box(13, 10, 0, 16, 12.5, 0.5), Block.box(0, 11, 0.5, 3, 12, 1),
        Block.box(13, 11, 0.5, 16, 12, 1), Block.box(0, 11.5, 1, 3, 12.5, 1.5), Block.box(13, 11.5, 1, 16, 12.5, 1.5),
        Block.box(0, 12.5, 0, 3, 14, 1), Block.box(3, 12.5, 0, 13, 13, 1), Block.box(3, 13, 0, 4, 13.5, 1),
        Block.box(12, 13, 0, 13, 13.5, 1), Block.box(3, 13.5, 0, 13, 14, 1), Block.box(13, 12.5, 0, 16, 14, 1),
        Block.box(0, 12.5, 1, 3, 13, 2), Block.box(13, 12.5, 1, 16, 13, 2), Block.box(0, 12.5, 2, 3, 14, 2.5),
        Block.box(13, 12.5, 2, 16, 14, 2.5), Block.box(0, 14, 0, 16, 15, 1), Block.box(0, 14, 1, 16, 16, 3),
        Block.box(0, 13, 15.5, 2, 15, 16), Block.box(2, 13, 15.5, 14, 14, 16), Block.box(14, 13, 15.5, 16, 15, 16),
        Block.box(0, 13.5, 14, 16, 14, 15.5), Block.box(0, 14, 14, 16, 14.5, 14.5), Block.box(0, 14.5, 13.5, 16, 15, 14.5),
        Block.box(0, 15, 3, 16, 16, 16)
    );
    private static final VoxelShape SHAPE_WEST = Shapes.or(
        Block.box(15.5, 10, 0, 16, 12.5, 3), Block.box(15.5, 10, 13, 16, 12.5, 16), Block.box(15, 11, 0, 15.5, 12, 3),
        Block.box(15, 11, 13, 15.5, 12, 16), Block.box(14.5, 11.5, 0, 15, 12.5, 3), Block.box(14.5, 11.5, 13, 15, 12.5, 16),
        Block.box(15, 12.5, 0, 16, 14, 3), Block.box(15, 12.5, 3, 16, 13, 13), Block.box(15, 13, 3, 16, 13.5, 4),
        Block.box(15, 13, 12, 16, 13.5, 13), Block.box(15, 13.5, 3, 16, 14, 13), Block.box(15, 12.5, 13, 16, 14, 16),
        Block.box(14, 12.5, 0, 15, 13, 3), Block.box(14, 12.5, 13, 15, 13, 16), Block.box(13.5, 12.5, 0, 14, 14, 3),
        Block.box(13.5, 12.5, 13, 14, 14, 16), Block.box(15, 14, 0, 16, 15, 16), Block.box(13, 14, 0, 15, 16, 16),
        Block.box(0, 13, 0, 0.5, 15, 2), Block.box(0, 13, 2, 0.5, 14, 14), Block.box(0, 13, 14, 0.5, 15, 16),
        Block.box(0.5, 13.5, 0, 2, 14, 16), Block.box(1.5, 14, 0, 2, 14.5, 16), Block.box(1.5, 14.5, 0, 2.5, 15, 16),
        Block.box(0, 15, 0, 13, 16, 16)
    );

    public StarmetalShelf(Properties properties) {
        super(properties);
    }


    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @SuppressWarnings("null")
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }
    @SuppressWarnings("null")
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @SuppressWarnings("null")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape facing = switch (state.getValue(FACING)) {
            case Direction.NORTH -> SHAPE_NORTH;
            case Direction.EAST -> SHAPE_EAST;
            case Direction.SOUTH -> SHAPE_SOUTH;
            case Direction.WEST -> SHAPE_WEST;
            default -> SHAPE_SOUTH;
        };
        return facing;
    }
    
}
