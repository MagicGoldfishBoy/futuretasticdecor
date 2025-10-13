package com.magicgoldfishboy.futuretasticdecor.block.entity;

import com.magicgoldfishboy.futuretasticdecor.registry.EntityRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BedEntity extends BlockEntity {
    private final DyeColor color;

    public BedEntity(BlockPos pos, BlockState blockState) {
        this(pos, blockState, ((BedBlock)blockState.getBlock()).getColor());
    }

    public BedEntity(BlockPos pos, BlockState blockState, DyeColor color) {
        super(EntityRegistry.BED_BLOCK_ENTITY.get(), pos, blockState);
        this.color = color;
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public DyeColor getColor() {
        return this.color;
    }
}

