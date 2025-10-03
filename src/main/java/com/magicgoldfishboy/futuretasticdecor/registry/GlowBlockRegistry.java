package com.magicgoldfishboy.futuretasticdecor.registry;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.Panel;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class GlowBlockRegistry {

    public static DeferredBlock<Block> GLOW_BLOCK;
    public static DeferredItem<BlockItem> GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> RED_GLOW_BLOCK;
    public static DeferredItem<BlockItem> RED_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> ORANGE_GLOW_BLOCK;
    public static DeferredItem<BlockItem> ORANGE_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> YELLOW_GLOW_BLOCK;
    public static DeferredItem<BlockItem> YELLOW_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> LIME_GLOW_BLOCK;
    public static DeferredItem<BlockItem> LIME_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> GREEN_GLOW_BLOCK;
    public static DeferredItem<BlockItem> GREEN_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> CYAN_GLOW_BLOCK;
    public static DeferredItem<BlockItem> CYAN_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> LIGHT_BLUE_GLOW_BLOCK;
    public static DeferredItem<BlockItem> LIGHT_BLUE_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> BLUE_GLOW_BLOCK;
    public static DeferredItem<BlockItem> BLUE_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> PURPLE_GLOW_BLOCK;
    public static DeferredItem<BlockItem> PURPLE_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> MAGENTA_GLOW_BLOCK;
    public static DeferredItem<BlockItem> MAGENTA_GLOW_BLOCK_ITEM;

    public static DeferredBlock<Block> PINK_GLOW_BLOCK;
    public static DeferredItem<BlockItem> PINK_GLOW_BLOCK_ITEM;


    public static DeferredBlock<Panel> GLOW_PANEL;
    public static DeferredItem<BlockItem> GLOW_PANEL_ITEM;


    private static Float GLOW_DESTROY_TIME = 2.25f;
    private static Float GLOW_EXPLOSION_RESISTANCE = 3.25f;   

    public static void registerGlowBlocks() {

        GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "glow_block", 
            GLOW_BLOCK
        );

        RED_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "red_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        RED_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "red_glow_block", 
            RED_GLOW_BLOCK
        );

        ORANGE_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "orange_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        ORANGE_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "orange_glow_block", 
            ORANGE_GLOW_BLOCK
        );

        YELLOW_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "yellow_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        YELLOW_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "yellow_glow_block", 
            YELLOW_GLOW_BLOCK
        );

        LIME_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "lime_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        LIME_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "lime_glow_block", 
            LIME_GLOW_BLOCK
        );

        GREEN_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "green_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        GREEN_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "green_glow_block", 
            GREEN_GLOW_BLOCK
        );

        CYAN_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "cyan_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        CYAN_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "cyan_glow_block", 
            CYAN_GLOW_BLOCK
        );

        LIGHT_BLUE_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "light_blue_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        LIGHT_BLUE_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "light_blue_glow_block", 
            LIGHT_BLUE_GLOW_BLOCK
        );

        BLUE_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "blue_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        BLUE_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "blue_glow_block", 
            BLUE_GLOW_BLOCK
        );

        PURPLE_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "purple_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        PURPLE_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "purple_glow_block", 
            PURPLE_GLOW_BLOCK
        );

        MAGENTA_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "magenta_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        MAGENTA_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "magenta_glow_block", 
            MAGENTA_GLOW_BLOCK
        );

        PINK_GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "pink_glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(GLOW_DESTROY_TIME, GLOW_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        PINK_GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "pink_glow_block", 
            PINK_GLOW_BLOCK
        );


        GLOW_PANEL = FuturetasticDecor.BLOCKS.register(
            "glow_panel", 
            registryName -> new Panel(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(1.0f, 1.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
                .noOcclusion()
            )
        );
        GLOW_PANEL_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "glow_panel", 
            GLOW_PANEL
        );

    }
    
}
