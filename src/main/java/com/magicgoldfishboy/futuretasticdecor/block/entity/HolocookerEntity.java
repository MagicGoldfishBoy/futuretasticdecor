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
    private static final Component DEFAULT_NAME = Component.translatable("container.holocooker");
    
    private static final java.lang.reflect.Field COOKING_TOTAL_TIME_FIELD;
    
    private int lastScaledTotalTime = -1;

    public HolocookerEntity(BlockPos pos, BlockState blockState) {
        super(LaboratoryDecorRegistry.HOLOCOOKER_ENTITY.get(), pos, blockState, RecipeType.SMOKING);
    }

    @Override
    protected Component getDefaultName() {
        return DEFAULT_NAME;
    }

    @Override
    protected int getBurnDuration(FuelValues fuelValues, ItemStack stack) {
        scaleDownCookingTime();
        return (super.getBurnDuration(fuelValues, stack));
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new SmokerMenu(id, player, this, this.dataAccess);
    }
    
    @Override
    public void setItem(int index, ItemStack stack, boolean insideTransaction) {
        // Only scale if we're putting a NEW item in
        // if (!stack.isEmpty() && this.getItem(index).isEmpty()) {
        //     scaleDownCookingTime();
        // }
        super.setItem(index, stack, insideTransaction);
    }

static {
    try {
        COOKING_TOTAL_TIME_FIELD = AbstractFurnaceBlockEntity.class.getDeclaredField("cookingTotalTime");
        COOKING_TOTAL_TIME_FIELD.setAccessible(true);
    } catch (NoSuchFieldException e) {
        throw new RuntimeException(e);
    }
}

private int originalTotalTime = -1;

private void scaleDownCookingTime() {
    try {
        int totalTime = COOKING_TOTAL_TIME_FIELD.getInt(this);
        if (totalTime > 0 && totalTime != originalTotalTime) {
            originalTotalTime = totalTime;
            int scaledTime = Math.max(1, totalTime / 2);
            COOKING_TOTAL_TIME_FIELD.setInt(this, scaledTime);
        }
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
}

@Override
public void onLoad() {
    super.onLoad();
    originalTotalTime = -1;
}

public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, HolocookerEntity furnace) {
    // Advance cooking twice per tick
    for (int i = 0; i < 2; i++) {
        AbstractFurnaceBlockEntity.serverTick(level, pos, state, furnace);
    }
}
}
