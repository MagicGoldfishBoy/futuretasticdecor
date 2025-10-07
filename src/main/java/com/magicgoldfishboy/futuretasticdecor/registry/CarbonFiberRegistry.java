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

public class CarbonFiberRegistry {


    public static DeferredItem<Item> CARBON_POWDER;

    public static DeferredItem<Item> CARBON_FIBER_TOW;

    public static DeferredBlock<Block> UNBAKED_CARBON_FIBER_POLYMER_BLOCK;

    public static DeferredItem<BlockItem> UNBAKED_CARBON_FIBER_POLYMER_ITEM;

    public static DeferredBlock<Block> CARBON_FIBER_POLYMER_BLOCK;

    public static DeferredItem<BlockItem> CARBON_FIBER_POLYMER_ITEM;

    public static void registerCarbonFiber() {

        CARBON_POWDER = FuturetasticDecor.ITEMS.registerSimpleItem(
            "carbon_powder", 
            new Item.Properties()
        );

        CARBON_FIBER_TOW = FuturetasticDecor.ITEMS.registerSimpleItem(
            "carbon_fiber_tow",
            new Item.Properties()
                .fireResistant()
        );

        UNBAKED_CARBON_FIBER_POLYMER_BLOCK = FuturetasticDecor.BLOCKS.register(
            "unbaked_carbon_fiber_polymer_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(5.5f, 9.75f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.PACKED_MUD)
            )
        );
        UNBAKED_CARBON_FIBER_POLYMER_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            UNBAKED_CARBON_FIBER_POLYMER_BLOCK
        );

        CARBON_FIBER_POLYMER_BLOCK = FuturetasticDecor.BLOCKS.register(
            "carbon_fiber_polymer_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(5.75f, 10.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.IRON)
            )
        );
        CARBON_FIBER_POLYMER_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            CARBON_FIBER_POLYMER_BLOCK
        );
    }
    
}
