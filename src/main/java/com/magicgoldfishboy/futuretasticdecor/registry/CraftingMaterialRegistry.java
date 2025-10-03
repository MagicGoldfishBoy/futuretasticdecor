package com.magicgoldfishboy.futuretasticdecor.registry;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class CraftingMaterialRegistry {

    public static DeferredItem<Item> COKE;


    public static DeferredItem<Item> STARDUST_POWDER;

    public static DeferredItem<Item> RED_STARDUST_POWDER;

    public static DeferredItem<Item> ORANGE_STARDUST_POWDER;

    public static DeferredItem<Item> YELLOW_STARDUST_POWDER;

    public static DeferredItem<Item> LIME_STARDUST_POWDER;

    public static DeferredItem<Item> GREEN_STARDUST_POWDER;

    public static DeferredItem<Item> CYAN_STARDUST_POWDER;

    public static DeferredItem<Item> LIGHT_BLUE_STARDUST_POWDER;

    public static DeferredItem<Item> BLUE_STARDUST_POWDER;

    public static DeferredItem<Item> PURPLE_STARDUST_POWDER;

    public static DeferredItem<Item> MAGENTA_STARDUST_POWDER;

    public static DeferredItem<Item> PINK_STARDUST_POWDER;


    public static DeferredItem<Item> ANTI_GRAV_ALLOY;

    public static DeferredItem<Item> ANTI_GRAV_INGOT;

    public static DeferredItem<Item> ANTI_GRAV_NUGGET;

    public static DeferredBlock<Block> ANTI_GRAV_BLOCK;

    public static DeferredItem<BlockItem> ANTI_GRAV_BLOCK_ITEM;

    public static void registerCraftingMaterials() {

        COKE = FuturetasticDecor.ITEMS.registerSimpleItem(
            "coke", 
            new Item.Properties()
        );


        STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "stardust_powder", 
            new Item.Properties()
        );

        RED_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "red_stardust_powder", 
            new Item.Properties()
        );

        ORANGE_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "orange_stardust_powder", 
            new Item.Properties()
        );

        YELLOW_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "yellow_stardust_powder", 
            new Item.Properties()
        );

        LIME_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "lime_stardust_powder", 
            new Item.Properties()
        );

        GREEN_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "green_stardust_powder", 
            new Item.Properties()
        );

        CYAN_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "cyan_stardust_powder", 
            new Item.Properties()
        );

        LIGHT_BLUE_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "light_blue_stardust_powder", 
            new Item.Properties()
        );

        BLUE_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "blue_stardust_powder", 
            new Item.Properties()
        );

        PURPLE_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "purple_stardust_powder", 
            new Item.Properties()
        );

        MAGENTA_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "magenta_stardust_powder", 
            new Item.Properties()
        );

        PINK_STARDUST_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "pink_stardust_powder", 
            new Item.Properties()
        );


        ANTI_GRAV_ALLOY = FuturetasticDecor.ITEMS.registerSimpleItem(
            "anti_grav_alloy", 
            new Item.Properties()
        );

        ANTI_GRAV_INGOT = FuturetasticDecor.ITEMS.registerSimpleItem(
            "anti_grav_ingot", 
            new Item.Properties()
        );

        ANTI_GRAV_NUGGET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "anti_grav_nugget", 
            new Item.Properties()
        );

        ANTI_GRAV_BLOCK = FuturetasticDecor.BLOCKS.register(
            "anti_grav_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(5.75f, 10.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.GILDED_BLACKSTONE)
                .friction(0.5f)
            )
        ); 
        ANTI_GRAV_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "anti_grav_block", 
            ANTI_GRAV_BLOCK
        ); 
    }
    
}
