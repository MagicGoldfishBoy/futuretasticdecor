package com.magicgoldfishboy.futuretasticdecor.registry;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class PlasticRegistry {

    public static DeferredItem<Item> RAW_WHITE_PLASTIC;
    public static DeferredItem<Item> RAW_RED_PLASTIC;
    public static DeferredItem<Item> RAW_ORANGE_PLASTIC;
    public static DeferredItem<Item> RAW_YELLOW_PLASTIC;
    public static DeferredItem<Item> RAW_LIME_PLASTIC;
    public static DeferredItem<Item> RAW_GREEN_PLASTIC;
    public static DeferredItem<Item> RAW_CYAN_PLASTIC;
    public static DeferredItem<Item> RAW_LIGHT_BLUE_PLASTIC;
    public static DeferredItem<Item> RAW_BLUE_PLASTIC;
    public static DeferredItem<Item> RAW_PURPLE_PLASTIC;
    public static DeferredItem<Item> RAW_MAGENTA_PLASTIC;
    public static DeferredItem<Item> RAW_PINK_PLASTIC;

    public static DeferredItem<Item> WHITE_PLASTIC_PELLET;
    public static DeferredItem<Item> RED_PLASTIC_PELLET;
    public static DeferredItem<Item> ORANGE_PLASTIC_PELLET;
    public static DeferredItem<Item> YELLOW_PLASTIC_PELLET;
    public static DeferredItem<Item> LIME_PLASTIC_PELLET;
    public static DeferredItem<Item> GREEN_PLASTIC_PELLET;
    public static DeferredItem<Item> CYAN_PLASTIC_PELLET;
    public static DeferredItem<Item> LIGHT_BLUE_PLASTIC_PELLET;
    public static DeferredItem<Item> BLUE_PLASTIC_PELLET;
    public static DeferredItem<Item> PURPLE_PLASTIC_PELLET;
    public static DeferredItem<Item> MAGENTA_PLASTIC_PELLET;
    public static DeferredItem<Item> PINK_PLASTIC_PELLET;

    public static DeferredBlock<Block> WHITE_PLASTIC_BLOCK;
    public static DeferredBlock<Block> RED_PLASTIC_BLOCK;
    public static DeferredBlock<Block> ORANGE_PLASTIC_BLOCK;
    public static DeferredBlock<Block> YELLOW_PLASTIC_BLOCK;
    public static DeferredBlock<Block> LIME_PLASTIC_BLOCK;
    public static DeferredBlock<Block> GREEN_PLASTIC_BLOCK;
    public static DeferredBlock<Block> CYAN_PLASTIC_BLOCK;
    public static DeferredBlock<Block> LIGHT_BLUE_PLASTIC_BLOCK;
    public static DeferredBlock<Block> BLUE_PLASTIC_BLOCK;
    public static DeferredBlock<Block> PURPLE_PLASTIC_BLOCK;
    public static DeferredBlock<Block> MAGENTA_PLASTIC_BLOCK;
    public static DeferredBlock<Block> PINK_PLASTIC_BLOCK;

    public static DeferredItem<BlockItem> WHITE_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> RED_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> ORANGE_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> YELLOW_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> LIME_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> GREEN_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> CYAN_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> LIGHT_BLUE_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> BLUE_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> PURPLE_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> MAGENTA_PLASTIC_BLOCK_ITEM;
    public static DeferredItem<BlockItem> PINK_PLASTIC_BLOCK_ITEM;

    public static void registerPlastics() {

        RAW_WHITE_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_white_plastic"
        );
        RAW_RED_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_red_plastic"
        );
        RAW_ORANGE_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_orange_plastic"
        );
        RAW_YELLOW_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_yellow_plastic"
        );
        RAW_LIME_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_lime_plastic"
        );
        RAW_GREEN_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_green_plastic"
        );
        RAW_CYAN_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_cyan_plastic"
        );
        RAW_LIGHT_BLUE_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_light_blue_plastic"
        );
        RAW_BLUE_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_blue_plastic"
        );
        RAW_PURPLE_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_purple_plastic"
        );
        RAW_MAGENTA_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_magenta_plastic"
        );
        RAW_PINK_PLASTIC = FuturetasticDecor.ITEMS.registerSimpleItem(
            "raw_pink_plastic"
        );

        WHITE_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "white_plastic_pellet"
        );
        RED_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "red_plastic_pellet"
        );
        ORANGE_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "orange_plastic_pellet"
        );
        YELLOW_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "yellow_plastic_pellet"
        );
        LIME_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "lime_plastic_pellet"
        );
        GREEN_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "green_plastic_pellet"
        );
        CYAN_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "cyan_plastic_pellet"
        );
        LIGHT_BLUE_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "light_blue_plastic_pellet"
        );
        BLUE_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "blue_plastic_pellet"
        );
        PURPLE_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "purple_plastic_pellet"
        );
        MAGENTA_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "magenta_plastic_pellet"
        );
        PINK_PLASTIC_PELLET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "pink_plastic_pellet"
        );

        WHITE_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "white_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        WHITE_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            WHITE_PLASTIC_BLOCK
        );

        RED_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "red_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        RED_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            RED_PLASTIC_BLOCK
        );

        ORANGE_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "orange_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        ORANGE_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            ORANGE_PLASTIC_BLOCK
        );

        YELLOW_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "yellow_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        YELLOW_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            YELLOW_PLASTIC_BLOCK
        );

        LIME_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "lime_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        LIME_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            LIME_PLASTIC_BLOCK
        );

        GREEN_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "green_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        GREEN_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            GREEN_PLASTIC_BLOCK
        );

        CYAN_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "cyan_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        CYAN_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            CYAN_PLASTIC_BLOCK
        );

        LIGHT_BLUE_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "light_blue_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        LIGHT_BLUE_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            LIGHT_BLUE_PLASTIC_BLOCK
        );

        BLUE_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "blue_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        BLUE_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            BLUE_PLASTIC_BLOCK
        );

        PURPLE_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "purple_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        PURPLE_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            PURPLE_PLASTIC_BLOCK
        );

        MAGENTA_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "magenta_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        MAGENTA_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            MAGENTA_PLASTIC_BLOCK
        );

        PINK_PLASTIC_BLOCK = FuturetasticDecor.BLOCKS.registerSimpleBlock(
            "pink_plastic_block",
            BlockBehaviour.Properties.of()
                .strength(2.75f, 4.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.TUFF)
        );
        PINK_PLASTIC_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            PINK_PLASTIC_BLOCK
        );

    }
    
}
