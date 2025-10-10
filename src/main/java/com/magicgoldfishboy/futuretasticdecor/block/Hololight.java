package com.magicgoldfishboy.futuretasticdecor.block;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Hololight extends DirectionalBlock {

    public static final MapCodec<Hololight> CODEC = simpleCodec(Hololight::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(7, 7, 15, 9, 9, 16), Block.box(7.25, 7.25, 14.75, 8.75, 8.75, 15)
    );
    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(0, 7, 7, 1, 9, 9), Block.box(1, 7.25, 7.25, 1.25, 8.75, 8.75)
    );
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(7, 7, 0, 9, 9, 1), Block.box(7.25, 7.25, 1, 8.75, 8.75, 1.25)
    );
    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(15, 7, 7, 16, 9, 9), Block.box(14.75, 7.25, 7.25, 15, 8.75, 8.75)
    );
    private static final VoxelShape SHAPE_UP = Shapes.or(
            Block.box(7, 0, 7, 9, 1, 9), Block.box(7.25, 1, 7.25, 8.75, 1.25, 8.75)
    );
    private static final VoxelShape SHAPE_DOWN = Shapes.or(
            Block.box(7, 15, 7, 9, 16, 9), Block.box(7.25, 14.75, 7.25, 8.75, 15, 8.75)
    );

    public Hololight(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends DirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape facing = switch (state.getValue(FACING)) {
            case Direction.NORTH -> SHAPE_NORTH;
            case Direction.EAST -> SHAPE_EAST;
            case Direction.SOUTH -> SHAPE_SOUTH;
            case Direction.WEST -> SHAPE_WEST;
            case Direction.UP -> SHAPE_UP;
            case Direction.DOWN -> SHAPE_DOWN;
            default -> SHAPE_SOUTH;
        };
        return facing;
    }
    
    @Override
    @Nullable
    public BlockState getStateForPlacement(@SuppressWarnings("null") BlockPlaceContext pContext) {
       return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }

    @SuppressWarnings("null")
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    @SuppressWarnings({ "null", "unused" })
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level instanceof ClientLevel clientLevel && player.isCrouching()) {
            clientLevel.playLocalSound(pos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 100.0f, 1.0f, false);
        }
        if (level instanceof ServerLevel serverLevel) {
            if (player.isCrouching()) {
                
                level.setBlock(pos, state.setValue(OPEN, !state.getValue(OPEN)), 3);

                return InteractionResult.CONSUME;
            }
        }
         return InteractionResult.PASS;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getValue(OPEN) ? 15 : 0;
    }
    
}
