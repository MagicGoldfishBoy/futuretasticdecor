package com.magicgoldfishboy.futuretasticdecor.block;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.entity.ChairEntity;
import com.magicgoldfishboy.futuretasticdecor.registry.EntityRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Chair extends HorizontalDirectionalBlock {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            Block.box(0, 0, 13, 3, 6, 16), Block.box(13, 0, 13, 16, 6, 16), Block.box(0, 0, 0, 3, 6, 3), Block.box(13, 0, 0, 16, 6, 3),
            Block.box(0, 6, 13, 16, 9, 16), Block.box(0, 6, 3, 3, 9, 13), Block.box(3, 6, 3, 13, 9, 13), Block.box(13, 6, 3, 16, 9, 13),
            Block.box(0, 6, 0, 16, 9, 3), Block.box(0, 9, 13, 3, 29, 16), Block.box(3, 9, 13, 13, 26, 16), Block.box(3, 26, 13, 13, 29, 16),
            Block.box(13, 9, 13, 16, 29, 16)
    );
    private static final VoxelShape SHAPE_EAST = Shapes.or(
            Block.box(0, 0, 0, 3, 6, 3), Block.box(0, 0, 13, 3, 6, 16), Block.box(13, 0, 0, 16, 6, 3), Block.box(13, 0, 13, 16, 6, 16), 
            Block.box(0, 6, 0, 3, 9, 16), Block.box(3, 6, 0, 13, 9, 3), Block.box(3, 6, 3, 13, 9, 13), Block.box(3, 6, 13, 13, 9, 16),
            Block.box(13, 6, 0, 16, 9, 16), Block.box(0, 9, 0, 3, 29, 3), Block.box(0, 9, 3, 3, 26, 13), Block.box(0, 26, 3, 3, 29, 13),
            Block.box(0, 9, 13, 3, 29, 16)
    );
    private static final VoxelShape SHAPE_SOUTH = Shapes.or(
            Block.box(0, 0, 0, 3, 6, 3), Block.box(13, 0, 0, 16, 6, 3), Block.box(0, 0, 13, 3, 6, 16), Block.box(13, 0, 13, 16, 6, 16),
            Block.box(0, 6, 0, 16, 9, 3), Block.box(0, 6, 3, 3, 9, 13), Block.box(3, 6, 3, 13, 9, 13), Block.box(13, 6, 3, 16, 9, 13),
            Block.box(0, 6, 13, 16, 9, 16), Block.box(0, 9, 0, 3, 29, 3), Block.box(3, 9, 0, 13, 26, 3), Block.box(3, 26, 0, 13, 29, 3),
            Block.box(13, 9, 0, 16, 29, 3)
    );
    private static final VoxelShape SHAPE_WEST = Shapes.or(
            Block.box(13, 0, 0, 16, 6, 3), Block.box(13, 0, 13, 16, 6, 16), Block.box(0, 0, 0, 3, 6, 3), Block.box(0, 0, 13, 3, 6, 16),
            Block.box(13, 6, 0, 16, 9, 16), Block.box(3, 6, 0, 13, 9, 3), Block.box(3, 6, 3, 13, 9, 13), Block.box(3, 6, 13, 13, 9, 16),
            Block.box(0, 6, 0, 3, 9, 16), Block.box(13, 9, 0, 16, 29, 3), Block.box(13, 9, 3, 16, 26, 13), Block.box(13, 26, 3, 16, 29, 13),
            Block.box(13, 9, 13, 16, 29, 16)
    );
    public static final MapCodec<Chair> CODEC = simpleCodec(Chair::new);
    public Chair(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

@Override
protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
    if(!level.isClientSide()) {
        //FuturetasticDecor.LOGGER.info("Right-clicking chair on server side");
        
        if (player.isPassenger()) {
            //FuturetasticDecor.LOGGER.info("Player is already riding something");
            return InteractionResult.PASS;
        }
        
        try {
            ChairEntity entity = new ChairEntity(EntityRegistry.CHAIR_ENTITY.get(), level);
            
            double x = pos.getX() + 0.5;
            double y = pos.getY() + 0.3;
            double z = pos.getZ() + 0.5;
            
            entity.setPos(x, y, z);
            level.addFreshEntity(entity);
            
            level.getServer().execute(() -> {
                // FuturetasticDecor.LOGGER.info("=== DETAILED RIDE DEBUG ===");
                // FuturetasticDecor.LOGGER.info("Player can ride entity: " + entity.canRide(player));
                // FuturetasticDecor.LOGGER.info("Entity can add passenger: " + entity.canAddPassenger(player));
                // FuturetasticDecor.LOGGER.info("Player is passenger: " + player.isPassenger());
                // FuturetasticDecor.LOGGER.info("Entity is alive: " + entity.isAlive());
                // FuturetasticDecor.LOGGER.info("Entity is removed: " + entity.isRemoved());
                // FuturetasticDecor.LOGGER.info("Same level: " + (player.level() == entity.level()));
                // FuturetasticDecor.LOGGER.info("Entity passenger count: " + entity.getPassengers().size());
                
                try {
                    java.lang.reflect.Method addPassengerMethod = Entity.class.getDeclaredMethod("addPassenger", Entity.class);
                    addPassengerMethod.setAccessible(true);
                    addPassengerMethod.invoke(entity, player);
                    FuturetasticDecor.LOGGER.info("Reflection ride success: " + player.isPassenger());
                } catch (Exception e) {
                    FuturetasticDecor.LOGGER.error("Reflection failed: " + e.getMessage());
                }
                
                boolean rideSuccess = player.startRiding(entity);
               // FuturetasticDecor.LOGGER.info("Standard ride attempt: " + rideSuccess);
            });
            
        } catch (Exception e) {
            FuturetasticDecor.LOGGER.error("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    return InteractionResult.SUCCESS;
}
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape facing = switch (state.getValue(FACING)) {
            case Direction.NORTH -> SHAPE_NORTH;
            case Direction.EAST -> SHAPE_EAST;
            case Direction.SOUTH -> SHAPE_SOUTH;
            case Direction.WEST -> SHAPE_WEST;
            default -> SHAPE_SOUTH;
        };
        return facing;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}