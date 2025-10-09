package com.magicgoldfishboy.futuretasticdecor.block;

import java.util.Map;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SlidingDoor extends DoorBlock {

    //private static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(Block.boxZ(16.0, 13.0, 16.0));
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


    public SlidingDoor(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        // Direction direction = state.getValue(FACING);
        // Direction direction1 = state.getValue(OPEN)
        //     ? (state.getValue(HINGE) == DoorHingeSide.RIGHT ? direction.getCounterClockWise() : direction.getClockWise())
        //     : direction;
        // return SHAPES.get(direction1);
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
