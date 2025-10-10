package com.magicgoldfishboy.futuretasticdecor.registry;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.ConnectableGlowBlock;

import net.minecraft.client.gui.components.Button;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class MetalRegistry {

    public static DeferredItem<Item> STEEL_ALLOY;
    public static DeferredItem<Item> STEEL_INGOT;
    public static DeferredItem<Item> STEEL_NUGGET;

    public static DeferredBlock<Block> STEEL_BLOCK;
    public static DeferredItem<BlockItem> STEEL_BLOCK_ITEM;

    public static DeferredBlock<SlabBlock> STEEL_SLAB;
    public static DeferredItem<BlockItem> STEEL_SLAB_ITEM;

    public static DeferredBlock<StairBlock> STEEL_STAIRS;
    public static DeferredItem<BlockItem> STEEL_STAIRS_ITEM;

    public static DeferredBlock<ButtonBlock> STEEL_BUTTON;
    public static DeferredItem<BlockItem> STEEL_BUTTON_ITEM;

    public static DeferredBlock<DoorBlock> STEEL_DOOR;
    public static DeferredItem<BlockItem> STEEL_DOOR_ITEM;


    public static DeferredBlock<Block> GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<ConnectableGlowBlock> CONNECTABLE_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> CONNECTABLE_GLOWING_STEEL_BLOCK_ITEM;


    public static DeferredBlock<Block> RED_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> RED_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> ORANGE_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> ORANGE_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> YELLOW_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> YELLOW_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> LIME_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> LIME_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> GREEN_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> GREEN_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> CYAN_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> CYAN_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> LIGHT_BLUE_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> LIGHT_BLUE_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> BLUE_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> BLUE_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> PURPLE_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> PURPLE_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> MAGENTA_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> MAGENTA_GLOWING_STEEL_BLOCK_ITEM;

    public static DeferredBlock<Block> PINK_GLOWING_STEEL_BLOCK;
    public static DeferredItem<BlockItem> PINK_GLOWING_STEEL_BLOCK_ITEM;


    public static DeferredBlock<Block> STEEL_PLANTER;
    public static DeferredItem<BlockItem> STEEL_PLANTER_ITEM;

    public static DeferredBlock<Block> FLOATING_STEEL_PLANTER;
    public static DeferredItem<BlockItem> FLOATING_STEEL_PLANTER_ITEM;



    public static DeferredItem<Item> STARMETAL_ALLOY;
    public static DeferredItem<Item> STARMETAL_INGOT;
    public static DeferredItem<Item> STARMETAL_NUGGET;

    public static DeferredBlock<Block> STARMETAL_BLOCK;
    public static DeferredItem<BlockItem> STARMETAL_BLOCK_ITEM;


    public static void registerMetals() {
        registerSteel();
        registerStarMetal();
    }

    private static Float STEEL_DESTROY_TIME = 4.25f;
    private static Float STEEL_EXPLOSION_RESISTANCE = 7.25f;    

    private static Float STARMETAL_DESTROY_TIME = 8.5f;
    private static Float STARMETAL_EXPLOSION_RESISTANCE = 14.5f;    

    public static void registerSteel() {

        STEEL_ALLOY = FuturetasticDecor.ITEMS.registerSimpleItem(
            "steel_alloy", 
            new Item.Properties()
        );
        STEEL_INGOT = FuturetasticDecor.ITEMS.registerSimpleItem(
            "steel_ingot", 
            new Item.Properties()
        );
        STEEL_NUGGET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "steel_nugget", 
            new Item.Properties()
        );
        
        STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        ); 
        STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "steel_block", 
            STEEL_BLOCK
        ); 

        STEEL_SLAB = FuturetasticDecor.BLOCKS.register(
            "steel_slab", 
            registryName -> new SlabBlock(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME / 2, STEEL_EXPLOSION_RESISTANCE / 2)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        ); 
        STEEL_SLAB_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "steel_slab", 
            STEEL_SLAB
        );

        STEEL_STAIRS = FuturetasticDecor.BLOCKS.register(
            "steel_stairs", 
            registryName -> new StairBlock(MetalRegistry.STEEL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME / 1.5f, STEEL_EXPLOSION_RESISTANCE / 1.5f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        STEEL_STAIRS_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "steel_stairs", 
            STEEL_STAIRS
        );

        STEEL_BUTTON = FuturetasticDecor.BLOCKS.register(
            "steel_button", 
            registryName -> new ButtonBlock(BlockSetType.IRON, 25, BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(0.5f, 0.5f)
                .instabreak()
                .noOcclusion()
                .sound(SoundType.METAL)
            )
        );
        STEEL_BUTTON_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            STEEL_BUTTON
        );

        STEEL_DOOR = FuturetasticDecor.BLOCKS.register(
            "steel_door", 
            registryName -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME / 1.5f, STEEL_EXPLOSION_RESISTANCE / 1.5f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .noOcclusion()
            )
        );
        STEEL_DOOR_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            STEEL_DOOR
        );

        GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 12)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            GLOWING_STEEL_BLOCK
        );

        RED_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "red_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 9)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        RED_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "red_glowing_steel_block", 
            RED_GLOWING_STEEL_BLOCK
        );

        ORANGE_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "orange_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 10)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        ORANGE_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "orange_glowing_steel_block", 
            ORANGE_GLOWING_STEEL_BLOCK
        );

        YELLOW_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "yellow_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 11)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        YELLOW_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "yellow_glowing_steel_block", 
            YELLOW_GLOWING_STEEL_BLOCK
        );

        LIME_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "lime_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 12)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        LIME_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "lime_glowing_steel_block", 
            LIME_GLOWING_STEEL_BLOCK
        );

        GREEN_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "green_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 13)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        GREEN_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "green_glowing_steel_block", 
            GREEN_GLOWING_STEEL_BLOCK
        );

        CYAN_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "cyan_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 10)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        CYAN_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "cyan_glowing_steel_block", 
            CYAN_GLOWING_STEEL_BLOCK
        );

        LIGHT_BLUE_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "light_blue_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 11)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        LIGHT_BLUE_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "light_blue_glowing_steel_block", 
            LIGHT_BLUE_GLOWING_STEEL_BLOCK
        );

        BLUE_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "blue_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 12)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        BLUE_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "blue_glowing_steel_block", 
            BLUE_GLOWING_STEEL_BLOCK
        );

        PURPLE_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "purple_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 13)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        PURPLE_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "purple_glowing_steel_block", 
            PURPLE_GLOWING_STEEL_BLOCK
        );

        MAGENTA_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "magenta_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 14)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        MAGENTA_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "magenta_glowing_steel_block", 
            MAGENTA_GLOWING_STEEL_BLOCK
        );

        PINK_GLOWING_STEEL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "pink_glowing_steel_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME, STEEL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 15)
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        );
        PINK_GLOWING_STEEL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "pink_glowing_steel_block", 
            PINK_GLOWING_STEEL_BLOCK
        );


        STEEL_PLANTER = FuturetasticDecor.BLOCKS.register(
            "steel_planter",
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME / 1.5f, STEEL_EXPLOSION_RESISTANCE / 1.5f)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 5)
                .sound(SoundType.METAL)
                .noOcclusion()
            )
        );
        STEEL_PLANTER_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            STEEL_PLANTER
        );

        FLOATING_STEEL_PLANTER = FuturetasticDecor.BLOCKS.register(
            "floating_steel_planter", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STEEL_DESTROY_TIME / 1.5f, STEEL_EXPLOSION_RESISTANCE / 1.5f)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 5)
                .sound(SoundType.METAL)
                .noOcclusion()
            )
        );
        FLOATING_STEEL_PLANTER_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            FLOATING_STEEL_PLANTER
        );
    }
    public static void registerStarMetal() {

        STARMETAL_ALLOY = FuturetasticDecor.ITEMS.registerSimpleItem(
            "starmetal_alloy", 
            new Item.Properties()
        );
        STARMETAL_INGOT = FuturetasticDecor.ITEMS.registerSimpleItem(
            "starmetal_ingot", 
            new Item.Properties()
        );
        STARMETAL_NUGGET = FuturetasticDecor.ITEMS.registerSimpleItem(
            "starmetal_nugget", 
            new Item.Properties()
        );
        
        STARMETAL_BLOCK = FuturetasticDecor.BLOCKS.register(
            "starmetal_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(STARMETAL_DESTROY_TIME, STARMETAL_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .friction(0.5f)
            )
        ); 
        STARMETAL_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "starmetal_block", 
            STARMETAL_BLOCK
        ); 
    }
    
}
