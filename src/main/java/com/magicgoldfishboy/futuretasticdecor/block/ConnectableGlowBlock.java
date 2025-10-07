package com.magicgoldfishboy.futuretasticdecor.block;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class ConnectableGlowBlock extends PipeBlock {

    public static final MapCodec<ConnectableGlowBlock> CODEC = simpleCodec(ConnectableGlowBlock::new);
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
   // public static final EnumProperty<?> SHAPE = BlockStateProperties.CONN
    public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf(
        Maps.newEnumMap(
            Map.of(Direction.NORTH, NORTH, Direction.EAST, EAST, Direction.SOUTH, SOUTH, Direction.WEST, WEST, Direction.UP, UP, Direction.DOWN, DOWN)
        )
    );

    public ConnectableGlowBlock(Properties properties) {
        super(16.0f, properties);
    }

    @Override
    protected MapCodec<? extends PipeBlock> codec() {
        return CODEC;
    }

    public boolean connectsTo(BlockState state, Direction direction) {
        Block block = state.getBlock();
        boolean flag = block instanceof ConnectableGlowBlock;
        return !isExceptionForConnection(state) && flag;
    }

    public enum Shapestate {
        CIRCLE,
        CORNER,
        LINE
    }

    public Enum<?> shapeIs(BlockState state, Direction direction) {
        if (!state.getValue(ConnectableGlowBlock.UP) && !state.getValue(ConnectableGlowBlock.DOWN)) {
            if (!state.getValue(ConnectableGlowBlock.EAST) && !state.getValue(ConnectableGlowBlock.WEST)) {
                return Shapestate.CIRCLE;
            }
            else {
                return Shapestate.LINE;
            }
        }
        return Shapestate.CORNER;
    }

    @Override
    protected void createBlockStateDefinition(@SuppressWarnings("null") StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, UP, DOWN);
    }

    @Override
    protected BlockState updateShape(
        BlockState state,
        LevelReader level,
        ScheduledTickAccess scheduledTickAccess,
        BlockPos pos,
        Direction direction,
        BlockPos neighborPos,
        BlockState neighborState,
        RandomSource random
    ) {
        if (PROPERTY_BY_DIRECTION.containsKey(direction)) {
            return state.setValue(
                PROPERTY_BY_DIRECTION.get(direction),
                this.connectsTo(neighborState, direction.getOpposite())
            );
        }
        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockPos blockpos5 = blockpos.above();
        BlockPos blockpos6 = blockpos.below();
        BlockState blockstate = blockgetter.getBlockState(blockpos1);
        BlockState blockstate1 = blockgetter.getBlockState(blockpos2);
        BlockState blockstate2 = blockgetter.getBlockState(blockpos3);
        BlockState blockstate3 = blockgetter.getBlockState(blockpos4);
        BlockState blockstate4 = blockgetter.getBlockState(blockpos5);
        BlockState blockstate5 = blockgetter.getBlockState(blockpos6);
        return super.getStateForPlacement(context)
            .setValue(NORTH, this.connectsTo(blockstate, Direction.SOUTH))
            .setValue(EAST, this.connectsTo(blockstate1, Direction.WEST))
            .setValue(SOUTH, this.connectsTo(blockstate2, Direction.NORTH))
            .setValue(WEST, this.connectsTo(blockstate3, Direction.EAST))
            .setValue(UP, this.connectsTo(blockstate4, Direction.DOWN))
            .setValue(DOWN, this.connectsTo(blockstate5, Direction.UP));
    }
    
}
