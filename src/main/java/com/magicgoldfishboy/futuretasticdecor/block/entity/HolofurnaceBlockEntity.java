package com.magicgoldfishboy.futuretasticdecor.block.entity;

import org.slf4j.Logger;

import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;
import com.mojang.logging.LogUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;

public class HolofurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final Component DEFAULT_NAME = Component.translatable("container.furnace");
    
    public HolofurnaceBlockEntity(BlockPos pos, BlockState blockState) {
        super(LaboratoryDecorRegistry.HOLOFURNACE_BLOCK_ENTITY.get(), pos, blockState, RecipeType.SMELTING);
    }
    
    @Override
    protected Component getDefaultName() {
        return DEFAULT_NAME;
    }
    
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new FurnaceMenu(id, player, this, this.dataAccess);
    }
    
    public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, HolofurnaceBlockEntity furnace) {
        for (int i = 0; i < 2; i++) {
            AbstractFurnaceBlockEntity.serverTick(level, pos, state, furnace);
        }
    }
}
