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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class Table extends Block {
    public static final MapCodec<Table> CODEC = simpleCodec(Table::new);

    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;   

    public Table(Properties properties) {
        super(properties);
        this.registerDefaultState(
            this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false).setValue(SOUTH, false).setValue(WEST, false)
        );
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    public void onPlace(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide() && !oldState.is(this)) {
            updateNeighborTables(level, pos);
        }
    }

    @Override
    protected BlockState updateShape(@Nonnull BlockState state, @Nonnull net.minecraft.world.level.LevelReader level, @Nonnull ScheduledTickAccess scheduledTickAccess, @Nonnull BlockPos pos, @Nonnull Direction direction, @Nonnull BlockPos neighborPos, @Nonnull BlockState neighborState, @Nonnull net.minecraft.util.RandomSource random) {
        if (direction == Direction.NORTH) {
            return state.setValue(NORTH, neighborState.getBlock() instanceof Table);
        } else if (direction == Direction.EAST) {
            return state.setValue(EAST, neighborState.getBlock() instanceof Table);
        } else if (direction == Direction.SOUTH) {
            return state.setValue(SOUTH, neighborState.getBlock() instanceof Table);
        } else if (direction == Direction.WEST) {
            return state.setValue(WEST, neighborState.getBlock() instanceof Table);
        }
        return state;
    }

    private void updateNeighborTables(Level level, BlockPos pos) {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);
            if (neighborState.getBlock() instanceof Table) {
                BlockState northState = level.getBlockState(neighborPos.north());
                BlockState eastState = level.getBlockState(neighborPos.east());
                BlockState southState = level.getBlockState(neighborPos.south());
                BlockState westState = level.getBlockState(neighborPos.west());
                BlockState newState = neighborState
                    .setValue(NORTH, northState.getBlock() instanceof Table)
                    .setValue(EAST, eastState.getBlock() instanceof Table)
                    .setValue(SOUTH, southState.getBlock() instanceof Table)
                    .setValue(WEST, westState.getBlock() instanceof Table);
                level.setBlock(neighborPos, newState, 3);
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState northState = blockgetter.getBlockState(blockpos.north());
        BlockState eastState = blockgetter.getBlockState(blockpos.east());
        BlockState southState = blockgetter.getBlockState(blockpos.south());
        BlockState westState = blockgetter.getBlockState(blockpos.west());
        
        return super.getStateForPlacement(context)
            .setValue(NORTH, northState.getBlock() instanceof Table)
            .setValue(EAST, eastState.getBlock() instanceof Table)
            .setValue(SOUTH, southState.getBlock() instanceof Table)
            .setValue(WEST, westState.getBlock() instanceof Table);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST);
    }
    
}
