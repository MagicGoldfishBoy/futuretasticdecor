package com.magicgoldfishboy.futuretasticdecor.block;

import javax.annotation.Nullable;

import com.magicgoldfishboy.futuretasticdecor.block.entity.HolocookerEntity;
import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class Holocooker extends AbstractFurnaceBlock {
    public static final MapCodec<Holocooker> CODEC = simpleCodec(Holocooker::new);

    @Override
    public MapCodec<Holocooker> codec() {
        return CODEC;
    }

    public Holocooker(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HolocookerEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) return null;
        if (blockEntityType != LaboratoryDecorRegistry.HOLOCOOKER_ENTITY.get()) return null;
        return (BlockEntityTicker<T>) (lvl, pos, st, entity) -> HolocookerEntity.serverTick((ServerLevel) lvl, pos, st, (HolocookerEntity) entity);
    }

    // @Nullable
    // @Override
    // public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
    //     return createFurnaceTicker(level, blockEntityType, LaboratoryDecorRegistry.HOLOCOOKER_ENTITY.get());
    // }

    /**
     * Called to open this furnace's container.
     *
     * @see #use
     */
    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        if (blockentity instanceof HolocookerEntity) {
            player.openMenu((MenuProvider)blockentity);
            player.awardStat(Stats.INTERACT_WITH_SMOKER);
        }
    }

    /**
     * Called periodically clientside on blocks near the player to show effects (like furnace fire particles).
     */
    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            double d0 = pos.getX() + 0.5;
            double d1 = pos.getY();
            double d2 = pos.getZ() + 0.5;
            if (random.nextDouble() < 0.1) {
                level.playLocalSound(d0, d1, d2, SoundEvents.SMOKER_SMOKE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            level.addParticle(ParticleTypes.SMOKE, d0, d1 + 1.1, d2, 0.0, 0.0, 0.0);
        }
    }
}
