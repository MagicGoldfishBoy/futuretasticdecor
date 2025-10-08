package com.magicgoldfishboy.futuretasticdecor.registry;

import java.rmi.registry.Registry;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.Wallpaper;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class LaboratoryDecorRegistry {

    public static DeferredBlock<Block> HOLOTILES_BLOCK;

    public static DeferredItem<BlockItem> HOLOTILES_BLOCK_ITEM;


    public static DeferredBlock<Wallpaper> HOLOWALLPAPER;

    public static DeferredItem<BlockItem> HOLOWALLPAPER_ITEM;

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

        HOLOWALLPAPER = FuturetasticDecor.BLOCKS.register(
            "holowallpaper", 
            registryName -> new Wallpaper(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
            )
        );
        HOLOWALLPAPER_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOWALLPAPER
        );

    }
    
}
