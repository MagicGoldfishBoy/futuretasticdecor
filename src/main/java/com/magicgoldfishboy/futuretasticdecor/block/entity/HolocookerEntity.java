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
    private static final Component DEFAULT_NAME = Component.translatable("container.smoker");
    
    private static final java.lang.reflect.Field COOKING_TOTAL_TIME_FIELD;
    
    static {
        try {
            COOKING_TOTAL_TIME_FIELD = AbstractFurnaceBlockEntity.class.getDeclaredField("cookingTotalTime");
            COOKING_TOTAL_TIME_FIELD.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public HolocookerEntity(BlockPos pos, BlockState blockState) {
        super(LaboratoryDecorRegistry.HOLOCOOKER_ENTITY.get(), pos, blockState, RecipeType.SMOKING);
    }

    @Override
    protected Component getDefaultName() {
        return DEFAULT_NAME;
    }

    @Override
    protected int getBurnDuration(FuelValues fuelValues, ItemStack stack) {
        return (super.getBurnDuration(fuelValues, stack) / 4);
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new SmokerMenu(id, player, this, this.dataAccess);
    }
    
    @Override
    public void setItem(int index, ItemStack stack, boolean insideTransaction) {
        super.setItem(index, stack, insideTransaction);
        
        // Scale down the cooking total time when a new item is set
        if (index == 0) {
            try {
                int totalTime = COOKING_TOTAL_TIME_FIELD.getInt(this);
                if (totalTime > 0) {
                    COOKING_TOTAL_TIME_FIELD.setInt(this, Math.max(1, totalTime / 4));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, HolocookerEntity furnace) {
        AbstractFurnaceBlockEntity.serverTick(level, pos, state, furnace);
    }
}
