package com.magicgoldfishboy.futuretasticdecor.block;

import java.util.Map;

import javax.annotation.Nullable;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.entity.ChairEntity;
import com.magicgoldfishboy.futuretasticdecor.registry.EntityRegistry;
import com.mojang.math.OctahedralGroup;
import com.mojang.math.Quadrant;
import com.mojang.serialization.MapCodec;

import net.minecraft.Util;
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
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SteelChair extends HorizontalDirectionalBlock {

    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;

    public static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(
        Shapes.or(Block.box(12, 0, 12, 15, 6, 15),
Block.box(12, 0, 1, 15, 6, 4),
Block.box(1, 0, 12, 4, 6, 15),
Block.box(1, 0, 1, 4, 6, 4),
Block.box(0, 6, 0, 16, 9, 15),
Block.box(1, 6, 15, 15, 9, 16),
Block.box(0, 9, 0, 2, 26, 3),
Block.box(1, 26, 0, 2, 27, 3),
Block.box(2, 9, 0, 14, 11, 3),
Block.box(2, 13, 0, 14, 15, 3),
Block.box(2, 17, 0, 14, 19, 3),
Block.box(2, 21, 0, 14, 23, 3),
Block.box(2, 25, 0, 14, 28, 3),
Block.box(4, 28, 0, 12, 29, 3),
Block.box(14, 9, 0, 16, 26, 3),
Block.box(14, 26, 0, 15, 27, 3)
)
    );

    public static final MapCodec<SteelChair> CODEC = simpleCodec(SteelChair::new);

    public SteelChair(Properties settings) {
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
    // @Override
    // public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
    //     return SHAPES;
    // }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING).getOpposite());
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
