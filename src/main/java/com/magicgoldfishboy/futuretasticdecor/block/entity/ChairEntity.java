package com.magicgoldfishboy.futuretasticdecor.block.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;

public class ChairEntity extends Entity {
    public ChairEntity(EntityType<?> type, Level world) {
        super(type, world);
    }

    @SuppressWarnings("null")
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    @SuppressWarnings("null")
    @Override
    public boolean hurtServer(ServerLevel world, DamageSource source, float amount) {
        return false;
    }

    @SuppressWarnings("null")
    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {
    }

    @SuppressWarnings("null")
    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {
    }

    protected void kill(){
        this.remove(RemovalReason.KILLED);
        this.gameEvent(GameEvent.ENTITY_DIE);
    }

    @SuppressWarnings("null")
    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        this.kill();
    }

    @SuppressWarnings("null")
    @Override
    public boolean canRide(Entity rider) {
        return true;
    }

    @SuppressWarnings("null")
    @Override
    public boolean canAddPassenger(Entity passenger) {
        return this.getPassengers().isEmpty();
    }

    @SuppressWarnings("null")
    @Override
    public void positionRider(Entity passenger, MoveFunction callback) {
        if (this.hasPassenger(passenger)) {
            callback.accept(passenger, this.getX(), this.getY() - 0.4, this.getZ());
        }
    }
    @Override
    public void tick() {
        super.tick();
        
        if (this.getPassengers().isEmpty()) {
            this.kill();
        }
        this.setDeltaMovement(Vec3.ZERO);
    }
}
