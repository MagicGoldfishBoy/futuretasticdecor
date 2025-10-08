package com.magicgoldfishboy.futuretasticdecor.registry;

import java.rmi.registry.Registry;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.Hologlass;
import com.magicgoldfishboy.futuretasticdecor.block.HologlassBlock;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class GlassRegistry {

    public static DeferredBlock<HologlassBlock> HOLOGLASS_BLOCK;
    public static DeferredItem<BlockItem> HOLOGLASS_BLOCK_ITEM;

    public static DeferredBlock<Hologlass> HOLOGLASS_PANE;
    public static DeferredItem<BlockItem> HOLOGLASS_PANE_ITEM;

    public static void registerglass() {
        HOLOGLASS_BLOCK = FuturetasticDecor.BLOCKS.register(
            "hologlass_block", 
            registryName -> new HologlassBlock(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(1.0f, 1.5f)
                .noOcclusion()
                .sound(SoundType.GLASS)
                .lightLevel(state -> 10)
            )
        );
        HOLOGLASS_BLOCK_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOGLASS_BLOCK
        );

        HOLOGLASS_PANE = FuturetasticDecor.BLOCKS.register(
            "hologlass_pane", 
            registryName -> new Hologlass(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, registryName))
                .strength(0.75f, 1.25f)
                .noOcclusion()
                .sound(SoundType.GLASS)
                .lightLevel(state -> 8)
            )
        );
        HOLOGLASS_PANE_ITEM = FuturetasticDecor.ITEMS.registerSimpleBlockItem(
            HOLOGLASS_PANE
        );
    }
    
}
