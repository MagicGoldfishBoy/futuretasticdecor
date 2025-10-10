package com.magicgoldfishboy.futuretasticdecor.block;

import com.magicgoldfishboy.futuretasticdecor.container.HoloCraftingTableMenu;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class HoloCraftingTable extends Block {

    public static final MapCodec<CraftingTableBlock> CODEC = simpleCodec(CraftingTableBlock::new);

    public HoloCraftingTable(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<? extends CraftingTableBlock> codec() {
        return CODEC;
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            player.openMenu(state.getMenuProvider(level, pos));
            player.awardStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider(
            (id, inventory, player) -> new HoloCraftingTableMenu(id, inventory, ContainerLevelAccess.create(level, pos)),
            Component.translatable("container.holo_crafting_table")
        );
    }


}
