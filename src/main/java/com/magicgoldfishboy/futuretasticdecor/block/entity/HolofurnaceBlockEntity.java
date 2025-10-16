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
    private static final java.lang.reflect.Field COOKING_TOTAL_TIME_FIELD;
    static {
        try {
            COOKING_TOTAL_TIME_FIELD = AbstractFurnaceBlockEntity.class.getDeclaredField("cookingTotalTime");
            COOKING_TOTAL_TIME_FIELD.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    
    private int lastScaledTotalTime = -1;
    
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
    
    @Override
    protected int getBurnDuration(FuelValues fuelValues, ItemStack stack) {
        scaleDownCookingTime();
        return super.getBurnDuration(fuelValues, stack);
    }
    
    @Override
    public void setItem(int index, ItemStack stack, boolean insideTransaction) {
        super.setItem(index, stack, insideTransaction);
        scaleDownCookingTime();
    }
    
    @Override
    public void onLoad() {
        super.onLoad();
        lastScaledTotalTime = -1;
        scaleDownCookingTime();
    }
    
    private void scaleDownCookingTime() {
        try {
            int totalTime = COOKING_TOTAL_TIME_FIELD.getInt(this);
            if (totalTime > 0 && totalTime != lastScaledTotalTime) {
                int scaledTime = Math.max(1, totalTime / 2);
                COOKING_TOTAL_TIME_FIELD.setInt(this, scaledTime);
                lastScaledTotalTime = scaledTime;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    
    public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, HolofurnaceBlockEntity furnace) {
        AbstractFurnaceBlockEntity.serverTick(level, pos, state, furnace);
        furnace.scaleDownCookingTime();
    }
}
