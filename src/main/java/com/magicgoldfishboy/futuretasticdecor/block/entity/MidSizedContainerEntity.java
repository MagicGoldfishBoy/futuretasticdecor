package com.magicgoldfishboy.futuretasticdecor.block.entity;

import com.magicgoldfishboy.futuretasticdecor.block.MidSizedContainer;
import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class MidSizedContainerEntity extends RandomizableContainerBlockEntity {
    
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    private static final int CONTAINER_SIZE = 27;

    public MidSizedContainerEntity(BlockPos pos, BlockState blockState) {
        super(LaboratoryDecorRegistry.HOLOBARREL_ENTITY.get(), pos, blockState); 
    }
    
    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            MidSizedContainerEntity.this.playSound(state, SoundEvents.BARREL_OPEN);
            MidSizedContainerEntity.this.updateBlockState(state, true);
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state) {
            MidSizedContainerEntity.this.playSound(state, SoundEvents.BARREL_CLOSE);
            MidSizedContainerEntity.this.updateBlockState(state, false);
        }

        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int oldCount, int newCount) {
        }

        @Override
        public boolean isOwnContainer(Player player) {
            if (player.containerMenu instanceof ChestMenu chestMenu) {
                Container container = chestMenu.getContainer();
                return container == MidSizedContainerEntity.this;
            }
            return false;
        }
    };

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        if (!this.trySaveLootTable(output)) {
            ContainerHelper.saveAllItems(output, this.items);
        }
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            ContainerHelper.loadAllItems(input, this.items);
        }
    }

    @Override
    public int getContainerSize() {
        return CONTAINER_SIZE;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.barrel");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return ChestMenu.threeRows(id, playerInventory, this);
    }
    
    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    void updateBlockState(BlockState state, boolean open) {
        if (this.level != null) {
            this.level.setBlock(this.getBlockPos(), state.setValue(MidSizedContainer.OPEN, open), 3);
        }
    }

    void playSound(BlockState state, SoundEvent sound) {
        if (this.level != null) {
            Vec3i vec3i = state.getValue(MidSizedContainer.FACING).getUnitVec3i();
            double d0 = this.worldPosition.getX() + 0.5 + vec3i.getX() / 2.0;
            double d1 = this.worldPosition.getY() + 0.5 + vec3i.getY() / 2.0;
            double d2 = this.worldPosition.getZ() + 0.5 + vec3i.getZ() / 2.0;
            this.level.playSound(null, d0, d1, d2, sound, SoundSource.BLOCKS, 0.5F, 
                this.level.random.nextFloat() * 0.1F + 0.9F);
        }
    }
}