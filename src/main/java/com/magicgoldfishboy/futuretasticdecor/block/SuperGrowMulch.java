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
        LOGGER.info("onPlace called at {} (isClientSide: {}, oldState: {})", pos, level.isClientSide(), oldState.getBlock());
        
        if (!level.isClientSide()) {
            // Always schedule a tick when placed (not when updating)
            if (!oldState.is(this)) {
                LOGGER.info("Scheduling initial tick at {}", pos);
                level.scheduleTick(pos, this, 1); // Start immediately
            }
            
            // Also notify neighboring mulch blocks to start ticking if they have flowers
            for (net.minecraft.core.Direction direction : net.minecraft.core.Direction.Plane.HORIZONTAL) {
                BlockPos neighborPos = pos.relative(direction);
                BlockState neighborState = level.getBlockState(neighborPos);
                LOGGER.info("Checking {} neighbor at {}: {}", direction, neighborPos, neighborState.getBlock());
                if (neighborState.getBlock() instanceof SuperGrowMulch) {
                    // Restart the neighbor's tick cycle
                    LOGGER.info("Found neighboring mulch, scheduling tick");
                    level.scheduleTick(neighborPos, neighborState.getBlock(), 1);
                }
            }
        }
    }
    
    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        //LOGGER.info("supermulch ticked at {}", pos);
        
        BlockState aboveState = level.getBlockState(pos.above());
        //LOGGER.info("Block above: {}", aboveState.getBlock());
        
        if (aboveState.getBlock() instanceof FlowerBlock) {
            //LOGGER.info("Found flower above!");
            
            BlockState eastState = level.getBlockState(pos.east());
            //LOGGER.info("Block to east: {}", eastState.getBlock());
            
            if (eastState.getBlock() instanceof SuperGrowMulch) {
                //LOGGER.info("Found mulch to east!");
                
                BlockPos targetPos = pos.east().above();
                BlockState targetState = level.getBlockState(targetPos);
                //LOGGER.info("Target position: {}, Target block: {}", targetPos, targetState.getBlock());
                
                if (targetState.isAir()) {
                    LOGGER.info("Target is air, placing flower!");
                    level.setBlock(targetPos, aboveState, 3);
                } else {
                    LOGGER.info("Target is not air");
                }
            }
        }
        
        // Schedule next tick
        level.scheduleTick(pos, this, SPREAD_INTERVAL);
    }
}