package com.magicgoldfishboy.futuretasticdecor.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HoloDeskLamp extends Block {

    public static final MapCodec<HoloDeskLamp> CODEC = simpleCodec(HoloDeskLamp::new);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    public HoloDeskLamp(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.or(
            Block.box(5, 0, 7, 6, 2, 9), Block.box(4, 2, 7, 5, 6, 9), Block.box(5, 2, 6, 6, 6, 10),
            Block.box(7, 0, 5, 9, 2, 6), Block.box(6, 0, 6, 10, 2, 10), Block.box(7, 0, 10, 9, 2, 11),
            Block.box(7, 2, 4, 9, 6, 5), Block.box(6, 2, 5, 10, 6, 11), Block.box(7, 2, 11, 9, 6, 12),
            Block.box(10, 0, 7, 11, 2, 9), Block.box(10, 2, 6, 11, 6, 10), Block.box(11, 2, 7, 12, 6, 9),
            Block.box(6, 6, 7, 7, 8, 9), Block.box(7, 6, 6, 9, 8, 10), Block.box(7, 8, 7, 9, 9, 7.25),
            Block.box(7, 8, 7.25, 7.25, 9, 8.75), Block.box(7.25, 8, 7.25, 8.75, 9.25, 8.75), 
            Block.box(8.75, 8, 7.25, 9, 9, 8.75), Block.box(7, 8, 8.75, 9, 9, 9), Block.box(9, 6, 7, 10, 8, 9)
        );
    }

    @SuppressWarnings("null")
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @SuppressWarnings({ "null", "unused" })
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level instanceof ClientLevel clientLevel && player.isCrouching()) {
            clientLevel.playLocalSound(pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 100.0f, 1.0f, false);
        }
        if (level instanceof ServerLevel serverLevel) {
            if (player.isCrouching()) {
                
                level.setBlock(pos, state.setValue(LIT, !state.getValue(LIT)), 3);

                return InteractionResult.CONSUME;
            }
        }
         return InteractionResult.PASS;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(LIT) ? 15 : 0;
    }
    
}
