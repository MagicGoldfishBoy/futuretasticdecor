package com.magicgoldfishboy.futuretasticdecor.registry;

import java.rmi.registry.Registry;

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

public class MetalRegistry {

    public static DeferredItem<Item> STEEL_ALLOY;
    public static DeferredItem<Item> STEEL_INGOT;
    public static DeferredItem<Item> STEEL_NUGGET;

    public static DeferredBlock<Block> STEEL_BLOCK;
    public static DeferredItem<BlockItem> STEEL_BLOCK_ITEM;



    public static void registerMetals() {
        registerSteel();
    }

    private static Float STEEL_DESTROY_TIME = 4.25f;
    private static Float STEEL_EXPLOSION_RESISTANCE = 7.25f;    

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

    }
    
}
