package com.magicgoldfishboy.futuretasticdecor.block;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Panel extends DirectionalBlock {

    public static final MapCodec<Panel> CODEC = simpleCodec(Panel::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;

    public Panel(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(@SuppressWarnings("null") StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public VoxelShape getShape(@SuppressWarnings("null") BlockState state, @SuppressWarnings("null") BlockGetter world, @SuppressWarnings("null") BlockPos pos, @SuppressWarnings("null") net.minecraft.world.phys.shapes.CollisionContext context) {
        VoxelShape facing = switch (state.getValue(FACING)) {
            case Direction.NORTH -> Shapes.box(0.0, 0.0, 0.94, 1.0, 1.0, 1.0);
            case Direction.EAST -> Shapes.box(0.0, 0.0, 0.0, 0.06, 1.0, 1.0);
            case Direction.SOUTH -> Shapes.box(0.0, 0.0, 0.0, 1.0, 1.0, 0.06);
            case Direction.WEST -> Shapes.box(0.94, 0.0, 0.0, 1.0, 1.0, 1.0);
            case Direction.UP -> Shapes.box(0.0, 0.0, 0.0, 1.0, 0.06, 1.0);
            case Direction.DOWN -> Shapes.box(0.0, 0.94, 0.0, 1.0, 1.0, 1.0);
            default -> Shapes.box(0.0, 0.5, 0.0, 1.0, 1.0, 1.0);
        };
        return facing;
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(@SuppressWarnings("null") BlockPlaceContext pContext) {
       return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }
    
}
