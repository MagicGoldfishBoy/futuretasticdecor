package com.magicgoldfishboy.futuretasticdecor.block;

import javax.annotation.Nonnull;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class Pillar extends RotatedPillarBlock {

    public static final MapCodec<Pillar> CODEC = simpleCodec(Pillar::new);

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;

    public Pillar(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y).setValue(UP, false).setValue(DOWN, false)
        .setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, UP, DOWN, NORTH, EAST, SOUTH, WEST);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState aboveState = blockgetter.getBlockState(blockpos.above());
        BlockState belowState = blockgetter.getBlockState(blockpos.below());
        BlockState northState = blockgetter.getBlockState(blockpos.north());
        BlockState eastState = blockgetter.getBlockState(blockpos.east());
        BlockState southState = blockgetter.getBlockState(blockpos.south());
        BlockState westState = blockgetter.getBlockState(blockpos.west());
        
        return super.getStateForPlacement(context)
            .setValue(AXIS, context.getClickedFace().getAxis())
            .setValue(UP, aboveState.getBlock() instanceof Pillar)
            .setValue(DOWN, belowState.getBlock() instanceof Pillar)
            .setValue(NORTH, northState.getBlock() instanceof Pillar)
            .setValue(EAST, eastState.getBlock() instanceof Pillar)
            .setValue(SOUTH, southState.getBlock() instanceof Pillar)
            .setValue(WEST, westState.getBlock() instanceof Pillar);
    }


    @Override
    public void onPlace(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide() && !oldState.is(this)) {
            updateNeighborPillars(level, pos);
        }
    }

    @Override
    protected BlockState updateShape(@Nonnull BlockState state, @Nonnull net.minecraft.world.level.LevelReader level, @Nonnull ScheduledTickAccess scheduledTickAccess, @Nonnull BlockPos pos, @Nonnull Direction direction, @Nonnull BlockPos neighborPos, @Nonnull BlockState neighborState, @Nonnull net.minecraft.util.RandomSource random) {
        if (direction == Direction.UP) {
            return state.setValue(UP, neighborState.getBlock() instanceof Pillar);
        } else if (direction == Direction.DOWN) {
            return state.setValue(DOWN, neighborState.getBlock() instanceof Pillar);
        } else if (direction == Direction.NORTH) {
            return state.setValue(NORTH, neighborState.getBlock() instanceof Pillar);
        } else if (direction == Direction.EAST) {
            return state.setValue(EAST, neighborState.getBlock() instanceof Pillar);
        } else if (direction == Direction.SOUTH) {
            return state.setValue(SOUTH, neighborState.getBlock() instanceof Pillar);
        } else if (direction == Direction.WEST) {
            return state.setValue(WEST, neighborState.getBlock() instanceof Pillar);
        }
        return state;
    }

    private void updateNeighborPillars(Level level, BlockPos pos) {
        for (Direction direction : Direction.Plane.VERTICAL) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);
            if (neighborState.getBlock() instanceof Pillar) {
                BlockState aboveState = level.getBlockState(neighborPos.above());
                BlockState belowState = level.getBlockState(neighborPos.below());
                BlockState newState = neighborState
                    .setValue(UP, aboveState.getBlock() instanceof Pillar)
                    .setValue(DOWN, belowState.getBlock() instanceof Pillar);
                level.setBlock(neighborPos, newState, 3);
            }
        }
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);
            if (neighborState.getBlock() instanceof Pillar) {
                BlockState northState = level.getBlockState(neighborPos.north());
                BlockState eastState = level.getBlockState(neighborPos.east());
                BlockState southState = level.getBlockState(neighborPos.south());
                BlockState westState = level.getBlockState(neighborPos.west());
                BlockState newState = neighborState
                    .setValue(NORTH, northState.getBlock() instanceof Pillar)
                    .setValue(EAST, eastState.getBlock() instanceof Pillar)
                    .setValue(SOUTH, southState.getBlock() instanceof Pillar)
                    .setValue(WEST, westState.getBlock() instanceof Pillar);
                level.setBlock(neighborPos, newState, 3);
            }
        }
    }
    
}
