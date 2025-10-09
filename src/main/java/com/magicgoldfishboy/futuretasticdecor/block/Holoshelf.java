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

public class Holoshelf extends HorizontalDirectionalBlock {

    public static final MapCodec<Holoshelf> CODEC = simpleCodec(Holoshelf::new);

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(0, 13, 0, 16, 16, 12), Block.box(14, 11, 14, 16, 16, 16), Block.box(0, 11, 14, 2, 16, 16)
    );
    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(4, 13, 0, 16, 16, 16), Block.box(0, 11, 0, 2, 16, 2), Block.box(0, 11, 14, 2, 16, 16)
    );
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(0, 13, 4, 16, 16, 16), Block.box(14, 11, 0, 16, 16, 2), Block.box(0, 11, 0, 2, 16, 2)
    );
    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(0, 13, 0, 12, 16, 16), Block.box(14, 11, 0, 16, 16, 2), Block.box(14, 11, 14, 16, 16, 16)
    );

    public Holoshelf(Properties properties) {
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
