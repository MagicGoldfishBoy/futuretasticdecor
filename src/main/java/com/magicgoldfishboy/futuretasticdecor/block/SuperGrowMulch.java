package com.magicgoldfishboy.futuretasticdecor.block;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SuperGrowMulch extends Block {
    
    public SuperGrowMulch(Properties properties) {
        super(properties);
    }
    
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final int SPREAD_INTERVAL = 20; // 1 second (20 ticks)
    
    @Override
    public void onPlace(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide() && !oldState.is(this)) {
            level.scheduleTick(pos, this, SPREAD_INTERVAL);
        }
    }
    
    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        LOGGER.info("supermulch ticked");
        
        if (level.getBlockState(pos.above()).getBlock() instanceof FlowerBlock) {
            if (level.getBlockState(pos.east()).getBlock() instanceof SuperGrowMulch) {
                BlockState flowerState = level.getBlockState(pos.above());
                BlockPos targetPos = pos.east().above();
                if (level.getBlockState(targetPos).isAir()) {
                    level.setBlock(targetPos, flowerState, 3);
                }
            }
        }
        
        // Schedule next tick
        level.scheduleTick(pos, this, SPREAD_INTERVAL);
    }
}