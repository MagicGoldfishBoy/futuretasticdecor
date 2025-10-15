package com.magicgoldfishboy.futuretasticdecor.block;

import java.util.List;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StarmetalTrampoline extends Block {

    public static final MapCodec<StarmetalTrampoline> CODEC = simpleCodec(StarmetalTrampoline::new);    

    public StarmetalTrampoline(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.or(
            Block.box(1, 0, 1, 3, 11, 3),
            Block.box(1, 0, 13, 3, 11, 15),
            Block.box(13, 0, 1, 15, 11, 3),
            Block.box(13, 0, 13, 15, 11, 15),
            Block.box(0, 11, 1, 1, 13, 15),
            Block.box(1, 11, 0, 15, 13, 1),
            Block.box(1, 11, 1, 15, 13, 15),
            Block.box(1, 11, 15, 15, 13, 16),
            Block.box(15, 11, 1, 16, 13, 15),
            Block.box(3, 5, 13.5, 13, 7, 14.5),
            Block.box(3, 10.25, 13.5, 13, 11, 14.5),
            Block.box(3, 5, 1.5, 13, 7, 2.5),
            Block.box(3, 10.25, 1.5, 13, 11, 2.5),
            Block.box(1.5, 5, 3, 2.5, 7, 13),
            Block.box(1.5, 10.25, 3, 2.5, 11, 13),
            Block.box(13.5, 5, 3, 14.5, 7, 13),
            Block.box(13.5, 10.25, 3, 14.5, 11, 13)
        );
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        super.fallOn(level, state, pos, entity, fallDistance * 0.5);
    }

    @Override
    public void updateEntityMovementAfterFallOn(BlockGetter level, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityMovementAfterFallOn(level, entity);
        } else {
            this.bounceUp(entity);
        }
    }

    private void bounceUp(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < 0.0) {
            double d0 = entity instanceof LivingEntity ? 2.0 : 0.8;
            entity.setDeltaMovement(vec3.x, -vec3.y * 0.66F * d0, vec3.z);
        }
    }
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltips, TooltipFlag flags) {
        tooltips.add(Component.translatable("block.futuretasticdecor.starmetal_trampoline.tooltip"));
    }
}
