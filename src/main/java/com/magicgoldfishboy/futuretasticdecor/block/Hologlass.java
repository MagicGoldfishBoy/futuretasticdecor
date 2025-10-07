package com.magicgoldfishboy.futuretasticdecor.block;

import java.util.List;

import com.mojang.serialization.MapCodec;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class Hologlass extends IronBarsBlock {
    public static final MapCodec<Hologlass> CODEC = simpleCodec(Hologlass::new);
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public Hologlass(Properties properties) {
        super(properties);
        // this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false)
        // .setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false)
        // .setValue(OPEN, false);
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, false).setValue(EAST, false)
        .setValue(SOUTH, false).setValue(WEST, false).setValue(WATERLOGGED, false).setValue(OPEN, false));
    }

    @SuppressWarnings("null")
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
         return InteractionResult.SUCCESS;
    }

    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add(Component.translatable("block.futuretasticdecor.hologlass.tooltip"));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(OPEN, NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
}
