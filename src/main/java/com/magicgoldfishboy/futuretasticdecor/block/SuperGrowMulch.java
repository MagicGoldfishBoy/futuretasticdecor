package com.magicgoldfishboy.futuretasticdecor.block;

import org.slf4j.Logger;

import com.magicgoldfishboy.futuretasticdecor.Config;
import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.mojang.logging.LogUtils;
import java.util.Random;
import javax.annotation.Nonnull;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class SuperGrowMulch extends Block {
    
    public SuperGrowMulch(Properties properties) {
        super(properties);
    }
    
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final int SPREAD_INTERVAL = 3000; // 1 second (20 ticks)
    Random randomDirectionNumber = new Random();
    
    @Override
    public void onPlace(@Nonnull BlockState state, @Nonnull Level level, @Nonnull BlockPos pos, @Nonnull BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        
        if (!level.isClientSide()) {
            if (!oldState.is(this)) {
                level.scheduleTick(pos, this, 1);
            }
            
            for (net.minecraft.core.Direction direction : net.minecraft.core.Direction.Plane.HORIZONTAL) {
                BlockPos neighborPos = pos.relative(direction);
                BlockState neighborState = level.getBlockState(neighborPos);
                //LOGGER.info("Checking {} neighbor at {}: {}", direction, neighborPos, neighborState.getBlock());
                if (neighborState.getBlock() instanceof SuperGrowMulch) {
                    level.scheduleTick(neighborPos, neighborState.getBlock(), 1);
                }
            }
        }
    }
    
    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerLevel level, @Nonnull BlockPos pos, @Nonnull RandomSource random) {
        
        BlockState aboveState = level.getBlockState(pos.above());
        
        if (aboveState.getBlock() instanceof FlowerBlock || aboveState.getBlock() instanceof TallFlowerBlock) {
            int randomDirectionNumber1 = randomDirectionNumber.nextInt(5);
            switch (randomDirectionNumber1) {
                case 1: checkEastForMulch(state, level, pos, random);
                    
                    break;

                case 2: checkWestForMulch(state, level, pos, random);

                    break;

                case 3: checkNorthForMulch(state, level, pos, random);

                    break;

                case 4: checkSouthForMulch(state, level, pos, random);

                    break;
            
                default: checkEastForMulch(state, level, pos, random);
                    break;
            }  
        }

        level.scheduleTick(pos, this, SPREAD_INTERVAL);
    }    
    
    private void checkEastForMulch(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState eastState = level.getBlockState(pos.east());
        
        if (eastState.getBlock() instanceof SuperGrowMulch) {
            BlockPos targetPos = pos.east().above();
            BlockState targetState = level.getBlockState(targetPos);
            BlockState flowerState = level.getBlockState(pos.above());
            
            if (targetState.isAir() && level.getBlockState(targetPos.above()).isAir()) {
                if (flowerState.getBlock() instanceof TallFlowerBlock) {
                    level.setBlock(targetPos, flowerState.setValue(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER), 3);
                    level.setBlock(targetPos.above(), flowerState.setValue(TallFlowerBlock.HALF, DoubleBlockHalf.UPPER), 3);
                } else {
                    level.setBlock(targetPos, flowerState, 3);
                }
            }
        }
    }
    private void checkWestForMulch(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState westState = level.getBlockState(pos.west());
        
        if (westState.getBlock() instanceof SuperGrowMulch) {
            
            BlockPos targetPos = pos.west().above();
            BlockState targetState = level.getBlockState(targetPos);
            BlockState flowerState = level.getBlockState(pos.above());
            
            if (targetState.isAir() && level.getBlockState(targetPos.above()).isAir()) {
                if (flowerState.getBlock() instanceof TallFlowerBlock) {
                    level.setBlock(targetPos, flowerState.setValue(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER), 3);
                    level.setBlock(targetPos.above(), flowerState.setValue(TallFlowerBlock.HALF, DoubleBlockHalf.UPPER), 3);
                } else {
                    level.setBlock(targetPos, flowerState, 3);
                }
            }
        }
    }
    private void checkNorthForMulch(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState northState = level.getBlockState(pos.north());
        
        if (northState.getBlock() instanceof SuperGrowMulch) {
            
            BlockPos targetPos = pos.north().above();
            BlockState targetState = level.getBlockState(targetPos);
            BlockState flowerState = level.getBlockState(pos.above());
            
            if (targetState.isAir() && level.getBlockState(targetPos.above()).isAir()) {
                if (flowerState.getBlock() instanceof TallFlowerBlock) {
                    level.setBlock(targetPos, flowerState.setValue(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER), 3);
                    level.setBlock(targetPos.above(), flowerState.setValue(TallFlowerBlock.HALF, DoubleBlockHalf.UPPER), 3);
                } else {
                    level.setBlock(targetPos, flowerState, 3);
                }
            }
        }
    }
    private void checkSouthForMulch(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState southState = level.getBlockState(pos.south());
        
        if (southState.getBlock() instanceof SuperGrowMulch) {
            
            BlockPos targetPos = pos.south().above();
            BlockState targetState = level.getBlockState(targetPos);
            BlockState flowerState = level.getBlockState(pos.above());
            
            if (targetState.isAir() && level.getBlockState(targetPos.above()).isAir()) {
                if (flowerState.getBlock() instanceof TallFlowerBlock) {
                    level.setBlock(targetPos, flowerState.setValue(TallFlowerBlock.HALF, DoubleBlockHalf.LOWER), 3);
                    level.setBlock(targetPos.above(), flowerState.setValue(TallFlowerBlock.HALF, DoubleBlockHalf.UPPER), 3);
                } else {
                    level.setBlock(targetPos, flowerState, 3);
                }
            }
        }
    }

}