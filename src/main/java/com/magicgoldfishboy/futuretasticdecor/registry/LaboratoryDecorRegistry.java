package com.magicgoldfishboy.futuretasticdecor.registry;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.Chair;
import com.magicgoldfishboy.futuretasticdecor.block.Holoshelf;
import com.magicgoldfishboy.futuretasticdecor.block.Holotv;
import com.magicgoldfishboy.futuretasticdecor.block.MidSizedContainer;
import com.magicgoldfishboy.futuretasticdecor.block.SlidingDoor;
import com.magicgoldfishboy.futuretasticdecor.block.Table;
import com.magicgoldfishboy.futuretasticdecor.block.Wallpaper;
import com.magicgoldfishboy.futuretasticdecor.block.entity.MidSizedContainerEntity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class LaboratoryDecorRegistry {

    public static DeferredBlock<Block> HOLOTILES_BLOCK;
    public static DeferredItem<BlockItem> HOLOTILES_BLOCK_ITEM;

    public static DeferredBlock<SlabBlock> HOLOTILES_SLAB;
    public static DeferredItem<BlockItem> HOLOTILES_SLAB_ITEM;

    public static DeferredBlock<StairBlock> HOLOTILES_STAIRS;
    public static DeferredItem<BlockItem> HOLOTILES_STAIRS_ITEM;


    public static DeferredBlock<Wallpaper> HOLOWALLPAPER;
    public static DeferredItem<BlockItem> HOLOWALLPAPER_ITEM;


    public static DeferredBlock<Block> HOLOBRICKS;
    public static DeferredItem<BlockItem> HOLOBRICKS_ITEM;


    public static DeferredBlock<Block> HOLOCEILING;
    public static DeferredItem<BlockItem> HOLOCEILING_ITEM;

    
    public static DeferredBlock<SlidingDoor> WHITE_SLIDING_DOOR;
    public static DeferredItem<BlockItem> WHITE_SLIDING_DOOR_ITEM;


    public static DeferredBlock<Table> HOLOTABLE;
    public static DeferredItem<BlockItem> HOLOTABLE_ITEM;


    public static DeferredBlock<Chair> HOLOCHAIR;
    public static DeferredItem<BlockItem> HOLOCHAIR_ITEM; 


    public static DeferredBlock<MidSizedContainer> HOLOBARREL;
    public static Supplier<BlockEntityType<MidSizedContainerEntity>> HOLOBARREL_ENTITY;
    public static DeferredItem<BlockItem> HOLOBARREL_ITEM;


    public static DeferredBlock<Holoshelf> HOLOSHELF;
    public static DeferredItem<BlockItem> HOLOSHELF_ITEM;


    public static DeferredBlock<Holotv> HOLOTV;
    public static DeferredItem<BlockItem> HOLOTV_ITEM;


    public static void registerAll() {

        HOLOTILES_BLOCK = FuturetasticDecor.BLOCKS.register(
            "holotiles_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(7.5f, 7.5f)
                .lightLevel(state -> 5)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF_BRICKS)
            )
        );
        HOLOTILES_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOTILES_BLOCK
        );

        HOLOTILES_SLAB = FuturetasticDecor.BLOCKS.register(
            "holotiles_slab", 
            registryName -> new SlabBlock(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(6.5f, 7.5f)
                .lightLevel(state -> 4)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF_BRICKS)
            )
        );
        HOLOTILES_SLAB_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOTILES_SLAB
        );

        HOLOTILES_STAIRS = FuturetasticDecor.BLOCKS.register(
            "holotiles_stairs", 
            registryName -> new StairBlock(LaboratoryDecorRegistry.HOLOTILES_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(7.5f, 7.5f)
                .lightLevel(state -> 5)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF_BRICKS)
            )
        );
        HOLOTILES_STAIRS_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOTILES_STAIRS
        );

        HOLOWALLPAPER = FuturetasticDecor.BLOCKS.register(
            "holowallpaper", 
            registryName -> new Wallpaper(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(5.5f, 6.75f)
                .lightLevel(state -> 5)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
            )
        );
        HOLOWALLPAPER_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOWALLPAPER
        );

        HOLOBRICKS = FuturetasticDecor.BLOCKS.register(
            "holobricks", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(6.5f, 7.75f)
                .lightLevel(state -> 5)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
            )
        );
        HOLOBRICKS_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOBRICKS
        );

        HOLOCEILING = FuturetasticDecor.BLOCKS.register(
            "holoceiling", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(7.5f, 7.5f)
                .lightLevel(state -> 5)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
            )
        );
        HOLOCEILING_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOCEILING
        );

        WHITE_SLIDING_DOOR = FuturetasticDecor.BLOCKS.register(
            "white_sliding_door", 
            registryName -> new SlidingDoor(BlockSetType.COPPER, BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(7.5f, 7.5f)
                .lightLevel(state -> 5)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
            )
        );
        WHITE_SLIDING_DOOR_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            WHITE_SLIDING_DOOR
        );

        HOLOTABLE = FuturetasticDecor.BLOCKS.register(
            "holotable",
            registryName -> new Table(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(5.25f, 5.75f)
                .lightLevel(state -> 5)
                .requiresCorrectToolForDrops()
                .sound(SoundType.POLISHED_TUFF)
                .noOcclusion()
            )
        );
        HOLOTABLE_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOTABLE
        );

        HOLOCHAIR = FuturetasticDecor.BLOCKS.register(
            "holochair", 
            registryName -> new Chair(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(5.0f, 5.5f)
                .lightLevel(state -> 3)
                .requiresCorrectToolForDrops()
                .sound(SoundType.POLISHED_TUFF)
                .noOcclusion()
            )
        );
        HOLOCHAIR_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOCHAIR
        );

        HOLOBARREL = FuturetasticDecor.BLOCKS.register(
            "holobarrel", 
            registryName -> new MidSizedContainer(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(5.0f, 5.5f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.POLISHED_TUFF)
            )
        );
        HOLOBARREL_ENTITY = FuturetasticDecor.BLOCK_ENTITIES.register(
            "holobarrel_entity",
            () -> new BlockEntityType<>(
                MidSizedContainerEntity::new,
                false,
                HOLOBARREL.get())
        );
        HOLOBARREL_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOBARREL
        );

        HOLOSHELF = FuturetasticDecor.BLOCKS.register(
            "holoshelf", 
            registryName -> new Holoshelf(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(4.0f, 4.5f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.POLISHED_TUFF)
                .noOcclusion()
            )
        );
        HOLOSHELF_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOSHELF
        );

        HOLOTV = FuturetasticDecor.BLOCKS.register(
            "holotv", 
            registryName -> new Holotv(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(4.0f, 4.5f)
                .instabreak()
                .explosionResistance(1.0f)
                .sound(SoundType.POLISHED_TUFF)
                .noOcclusion()
                .lightLevel(state -> 8)
            )
        );
        HOLOTV_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOTV
        );

    }
    
}
