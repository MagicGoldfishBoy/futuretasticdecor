package com.magicgoldfishboy.futuretasticdecor.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;
import java.util.function.Supplier;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.StarmetalBed;
import com.magicgoldfishboy.futuretasticdecor.block.entity.BedEntity;
import com.magicgoldfishboy.futuretasticdecor.block.entity.ChairEntity;

public class EntityRegistry {

    public static final DeferredRegister.Entities ENTITY_TYPES = DeferredRegister.createEntities(FuturetasticDecor.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, FuturetasticDecor.MODID);

    public static void init(IEventBus bus) {
        ENTITY_TYPES.register(bus);
        BLOCK_ENTITIES.register(bus);
    }            

    public static final Supplier<EntityType<ChairEntity>> CHAIR_ENTITY =
        ENTITY_TYPES.registerEntityType(
            "chair_entity",
            ChairEntity::new,
            MobCategory.MISC,
            builder -> builder
                .sized(0.8f, 0.8f)
                .clientTrackingRange(10)
                .updateInterval(10)
    );

    public static final Supplier<BlockEntityType<BedBlockEntity>> BED_BLOCK_ENTITY =
        BLOCK_ENTITIES.register(
            "bed_block_entity",
            () -> new BlockEntityType<>(
                BedBlockEntity::new,
                Set.of(MetalRegistry.STARMETAL_BED.get())
            )
        );
}
