package com.magicgoldfishboy.futuretasticdecor.block;

import java.util.Map;

import javax.annotation.Nullable;

import com.ibm.icu.text.AlphabeticIndex.Bucket;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Beaker extends HorizontalDirectionalBlock {
    public static final MapCodec<Beaker> CODEC = simpleCodec(Beaker::new);
    public static final EnumProperty<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty LEVEL_CAULDRON = BlockStateProperties.LEVEL_CAULDRON;
    
    public static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(
        Shapes.or(
            Block.box(6, 0, 6.5, 6.25, 5, 9.5),
            Block.box(6.5, 0, 6, 9.5, 5, 6.25),
            Block.box(6.25, 0, 6.5, 6.5, 0.5, 9.5),
            Block.box(6.5, 0, 6.25, 9.5, 0.5, 9.75),
            Block.box(9.5, 0, 6.5, 9.75, 0.5, 9.5),
            Block.box(6.5, 0, 9.75, 7.5, 4, 10),
            Block.box(7.5, 0, 9.75, 8.5, 4, 10),
            Block.box(8.5, 0, 9.75, 9.5, 4, 10),
            Block.box(6.5, 4, 9.75, 7.5, 5, 10),
            Block.box(7.5, 4, 10, 7.75, 4.25, 10.25),
            Block.box(7.75, 4, 10, 8.25, 4.25, 10.25),
            Block.box(8.25, 4, 10, 8.5, 4.25, 10.25),
            Block.box(7.5, 4.25, 10, 7.75, 5, 10.25),
            Block.box(7.75, 4.25, 10.25, 8.25, 5, 10.5),
            Block.box(8.25, 4.25, 10, 8.5, 5, 10.25),
            Block.box(8.5, 4, 9.75, 9.5, 5, 10),
            Block.box(9.5, 0, 9.5, 9.75, 5, 9.75),
            Block.box(9.5, 0, 6.25, 9.75, 5, 6.5),
            Block.box(6.25, 0, 6.25, 6.5, 5, 6.5),
            Block.box(6.25, 0, 9.5, 6.5, 5, 9.75),
            Block.box(9.75, 0, 6.5, 10, 5, 9.5)
        )
    );
    
    // Water container shape - the actual beaker bowl
    public static final Map<Direction, VoxelShape> WATER_SHAPES = Shapes.rotateHorizontal(
        Block.box(6.5, 0.5, 6.25, 9.5, 4, 9.75)
    );
    
    public Beaker(Properties properties) {
        super(properties);
    }
    
    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
    
    @SuppressWarnings("null")
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
            .setValue(FACING, ctx.getHorizontalDirection().getOpposite())
            .setValue(LEVEL_CAULDRON, 1);
    }
    
    @SuppressWarnings("null")
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(LEVEL_CAULDRON);
    }
    
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING).getOpposite());
    }
    
    @Override
    protected VoxelShape getInteractionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return WATER_SHAPES.get(state.getValue(FACING).getOpposite());
    }
    
    @Override
    protected InteractionResult useItemOn(
        ItemStack stack, BlockState state, Level level, BlockPos pos,
        Player player, InteractionHand hand, BlockHitResult hitResult
    ) {
        if (stack.getItem() == Items.WATER_BUCKET) {
            if (level.isClientSide()) {
                return InteractionResult.SUCCESS;
            }
            
            int fillLevel = state.getValue(BlockStateProperties.LEVEL_CAULDRON);
            
            if (fillLevel < 3) {
                level.setBlock(pos, state.setValue(BlockStateProperties.LEVEL_CAULDRON, 3), 3);
                
                if (!player.isCreative()) {
                    stack.shrink(1);
                    player.addItem(new ItemStack(Items.BUCKET));
                }
                level.playSound(player, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
    
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        // Prevent default water bucket behavior on client side
        if (level.isClientSide()) {
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
}
