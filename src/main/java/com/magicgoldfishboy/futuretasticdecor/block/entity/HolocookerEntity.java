package com.magicgoldfishboy.futuretasticdecor.block.entity;


import org.slf4j.Logger;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;
import com.mojang.logging.LogUtils;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;

public class HolocookerEntity extends AbstractFurnaceBlockEntity {
    public static final Logger LOGGER = LogUtils.getLogger();
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
        return (super.getBurnDuration(fuelValues, stack) * 4);
    }
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new SmokerMenu(id, player, this, this.dataAccess);
    }

    private static final java.lang.reflect.Field COOKING_TIMER_FIELD;
    private static final java.lang.reflect.Field COOKING_TOTAL_TIME_FIELD;
    private static final java.lang.reflect.Field LIT_TIME_REMAINING_FIELD;

    static {
        try {
            COOKING_TIMER_FIELD = AbstractFurnaceBlockEntity.class.getDeclaredField("cookingTimer");
            COOKING_TOTAL_TIME_FIELD = AbstractFurnaceBlockEntity.class.getDeclaredField("cookingTotalTime");
            LIT_TIME_REMAINING_FIELD = AbstractFurnaceBlockEntity.class.getDeclaredField("litTimeRemaining");
            
            COOKING_TIMER_FIELD.setAccessible(true);
            COOKING_TOTAL_TIME_FIELD.setAccessible(true);
            LIT_TIME_REMAINING_FIELD.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, HolocookerEntity furnace) {
        try {
            // Store original cooking total time
            int originalTotalTime = COOKING_TOTAL_TIME_FIELD.getInt(furnace);
            
            // Temporarily set it to 1/4 for this tick
            if (originalTotalTime > 0) {
                COOKING_TOTAL_TIME_FIELD.setInt(furnace, Math.max(1, originalTotalTime / 4));
            }
            
            AbstractFurnaceBlockEntity.serverTick(level, pos, state, furnace);
            
            // Restore the original total time
            COOKING_TOTAL_TIME_FIELD.setInt(furnace, originalTotalTime);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
