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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SlidingDoor extends DoorBlock {

    //private static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(Block.boxZ(16.0, 13.0, 16.0));
    private static final VoxelShape SHAPE_LEFT_OPEN = Shapes.or(
            Block.box(-14, 0, 7, 2, 16, 9)
    );
    private static final VoxelShape SHAPE_RIGHT_OPEN = Shapes.or(
            Block.box(14, 0, 7, 30, 16, 9)
    );
    private static final VoxelShape SHAPE_CLOSED = Shapes.or(
            Block.box(0, 0, 7, 16, 16, 9)
    );

    public SlidingDoor(BlockSetType type, Properties properties) {
        super(type, properties);
    }

    private static final Map<Direction, VoxelShape> SHAPE_CLOSED_MAP = Shapes.rotateHorizontal(SHAPE_CLOSED, new Vec3(0.5, 0.5, 0.5));
    private static final Map<Direction, VoxelShape> SHAPE_LEFT_OPEN_MAP = Shapes.rotateHorizontal(SHAPE_LEFT_OPEN, new Vec3(0.5, 0.5, 0.5));
    private static final Map<Direction, VoxelShape> SHAPE_RIGHT_OPEN_MAP = Shapes.rotateHorizontal(SHAPE_RIGHT_OPEN, new Vec3(0.5, 0.5, 0.5));

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        
        if (state.getValue(OPEN)) {
            if (state.getValue(HINGE) == DoorHingeSide.LEFT) {
                return SHAPE_LEFT_OPEN_MAP.get(facing);
            } else {
                return SHAPE_RIGHT_OPEN_MAP.get(facing);
            }
        } else {
            return SHAPE_CLOSED_MAP.get(facing);
        }
    }
}
