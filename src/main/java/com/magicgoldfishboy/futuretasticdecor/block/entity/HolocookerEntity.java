package com.magicgoldfishboy.futuretasticdecor.block.entity;

import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;

public class HolocookerEntity extends AbstractFurnaceBlockEntity {
    private static final Component DEFAULT_NAME = Component.translatable("container.smoker");

    public HolocookerEntity(BlockPos pos, BlockState blockState) {
        super(LaboratoryDecorRegistry.HOLOCOOKER_ENTITY.get(), pos, blockState, RecipeType.SMOKING);
    }

    @Override
    protected Component getDefaultName() {
        return DEFAULT_NAME;
    }

    @Override
    protected int getBurnDuration(FuelValues fuelValues, ItemStack stack) {
        return super.getBurnDuration(fuelValues, stack) / 2;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new SmokerMenu(id, player, this, this.dataAccess);
    }
}
