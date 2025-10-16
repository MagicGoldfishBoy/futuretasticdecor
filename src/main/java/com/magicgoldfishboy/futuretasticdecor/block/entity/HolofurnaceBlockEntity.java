package com.magicgoldfishboy.futuretasticdecor.block.entity;

import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class HolofurnaceBlockEntity extends AbstractFurnaceBlockEntity {
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
}
