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

    private static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(Block.boxZ(16.0, 13.0, 16.0));
    
    public SlidingDoor(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        Direction direction1 = state.getValue(OPEN)
            ? (state.getValue(HINGE) == DoorHingeSide.RIGHT ? direction.getCounterClockWise() : direction.getClockWise())
            : direction;
        return SHAPES.get(direction1);
    }
    
}
