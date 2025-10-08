package com.magicgoldfishboy.futuretasticdecor.block;

import javax.annotation.Nonnull;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
        
        if (!level.isClientSide()) {
            if (!oldState.is(this)) {
                level.scheduleTick(pos, this, 1);
            }
            
            for (net.minecraft.core.Direction direction : net.minecraft.core.Direction.Plane.VERTICAL) {
                BlockPos neighborPos = pos.relative(direction);
                BlockState neighborState = level.getBlockState(neighborPos);
                if (neighborState.getBlock() instanceof Wallpaper) {
                    level.updateNeighborsAt(neighborPos, neighborState.getBlock());
                }
            }
        }
    }

    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        Block block = state.getBlock();
        boolean flag = block instanceof Wallpaper;
        return !isExceptionForConnection(state) && isSideSolid || flag;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockgetter = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockPos blockpos1 = blockpos.above();
        BlockPos blockpos2 = blockpos.below();
        BlockState blockstate = blockgetter.getBlockState(blockpos1);
        BlockState blockstate1 = blockgetter.getBlockState(blockpos2);
        return super.getStateForPlacement(context)
            .setValue(UP, this.connectsTo(blockstate, blockstate.isFaceSturdy(blockgetter, blockpos1, Direction.UP), Direction.UP))
            .setValue(DOWN, this.connectsTo(blockstate1, blockstate1.isFaceSturdy(blockgetter, blockpos2, Direction.DOWN), Direction.DOWN));
    }
    

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN);
    }
    
}
