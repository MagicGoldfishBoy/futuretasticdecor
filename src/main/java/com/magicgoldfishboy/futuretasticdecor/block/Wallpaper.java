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

public class Wallpaper extends Block {
    public static final MapCodec<Wallpaper> CODEC = simpleCodec(Wallpaper::new);
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;

    public Wallpaper(Properties properties) {
        super(properties);
        this.registerDefaultState(
            this.stateDefinition.any().setValue(UP, false).setValue(DOWN, false)
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
            updateNeighborWallpapers(level, pos);
        }
    }

    @Override
    protected BlockState updateShape(@Nonnull BlockState state, @Nonnull net.minecraft.world.level.LevelReader level, @Nonnull ScheduledTickAccess scheduledTickAccess, @Nonnull BlockPos pos, @Nonnull Direction direction, @Nonnull BlockPos neighborPos, @Nonnull BlockState neighborState, @Nonnull net.minecraft.util.RandomSource random) {
        if (direction == Direction.UP) {
            return state.setValue(UP, neighborState.getBlock() instanceof Wallpaper);
        } else if (direction == Direction.DOWN) {
            return state.setValue(DOWN, neighborState.getBlock() instanceof Wallpaper);
        }
        return state;
    }

    private void updateNeighborWallpapers(Level level, BlockPos pos) {
        for (Direction direction : Direction.Plane.VERTICAL) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);
            if (neighborState.getBlock() instanceof Wallpaper) {
                BlockState aboveState = level.getBlockState(neighborPos.above());
                BlockState belowState = level.getBlockState(neighborPos.below());
                BlockState newState = neighborState
                    .setValue(UP, aboveState.getBlock() instanceof Wallpaper)
                    .setValue(DOWN, belowState.getBlock() instanceof Wallpaper);
                level.setBlock(neighborPos, newState, 3);
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState aboveState = blockgetter.getBlockState(blockpos.above());
        BlockState belowState = blockgetter.getBlockState(blockpos.below());
        
        return super.getStateForPlacement(context)
            .setValue(UP, aboveState.getBlock() instanceof Wallpaper)
            .setValue(DOWN, belowState.getBlock() instanceof Wallpaper);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN);
    }
}