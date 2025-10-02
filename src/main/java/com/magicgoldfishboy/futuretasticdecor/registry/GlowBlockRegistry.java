package com.magicgoldfishboy.futuretasticdecor.registry;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;

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

    private static Float glow_DESTROY_TIME = 2.25f;
    private static Float glow_EXPLOSION_RESISTANCE = 3.25f;   

    public static void registerGlowBlocks() {

        GLOW_BLOCK = FuturetasticDecor.BLOCKS.register(
            "glow_block", 
            registryName -> new Block(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(glow_DESTROY_TIME, glow_EXPLOSION_RESISTANCE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .lightLevel(state -> 13)
            )
        );
        GLOW_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            "glow_block", 
            GLOW_BLOCK
        ); 

    }
    
}
