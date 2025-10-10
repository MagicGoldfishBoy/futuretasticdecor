package com.magicgoldfishboy.futuretasticdecor.block;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Hololight extends DirectionalBlock {

    public static final MapCodec<Hololight> CODEC = simpleCodec(Hololight::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public Hololight(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.or(
            Block.box(7, 0, 7, 9, 1, 9), Block.box(7.25, 1, 7.25, 8.75, 1.25, 8.75)
        );
    }
    
    @Override
    @Nullable
    public BlockState getStateForPlacement(@SuppressWarnings("null") BlockPlaceContext pContext) {
       return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }

    @SuppressWarnings("null")
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    @SuppressWarnings({ "null", "unused" })
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level instanceof ClientLevel clientLevel && player.isCrouching()) {
            clientLevel.playLocalSound(pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 100.0f, 1.0f, false);
        }
        if (level instanceof ServerLevel serverLevel) {
            if (player.isCrouching()) {
                
                level.setBlock(pos, state.setValue(OPEN, !state.getValue(OPEN)), 3);

                return InteractionResult.CONSUME;
            }
        }
         return InteractionResult.PASS;
    }
    
}
