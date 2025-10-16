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
    
    private int lastScaledTotalTime = -1;

    public HolocookerEntity(BlockPos pos, BlockState blockState) {
        super(LaboratoryDecorRegistry.HOLOCOOKER_ENTITY.get(), pos, blockState, RecipeType.SMOKING);
    }

    @Override
    protected Component getDefaultName() {
        return DEFAULT_NAME;
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new SmokerMenu(id, player, this, this.dataAccess);
    }
    

    public static void serverTick(ServerLevel level, BlockPos pos, BlockState state, HolocookerEntity furnace) {
        for (int i = 0; i < 2; i++) {
            AbstractFurnaceBlockEntity.serverTick(level, pos, state, furnace);
        }
    }
}
