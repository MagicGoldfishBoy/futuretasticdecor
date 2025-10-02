package com.magicgoldfishboy.futuretasticdecor.registry;

import java.util.Set;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class LootTableDatagen extends BlockLootSubProvider {

    public LootTableDatagen(HolderLookup.Provider lookupProvider) {
        super(
            Set.of(), // explosionResistant items
            FeatureFlags.REGISTRY.allFlags(), // enabledFeatures
            new java.util.HashMap<>(), // loot table builders
            lookupProvider
        );
    }

    @Override
protected Iterable<Block> getKnownBlocks() {
    return FuturetasticDecor.BLOCKS.getEntries()
        .stream()
        .map(e -> (Block) e.value())
        .filter(block -> block.asItem() != Items.AIR)
        .toList();
}

    @Override
protected void generate() {
    FuturetasticDecor.BLOCKS.getEntries().forEach(entry -> {
        Block block = entry.get();

        if (block.asItem() == Items.AIR) {
        return;
}
        if (block.getName().toString().matches(".*slab.*")) {
        this.add(block, this::createSlabItemTable);
        return;
}
        if(block.getName().toString().matches(".*door.*") && !block.getName().toString().matches(".*trapdoor.*")) {
        this.add(block, this::createDoorTable);
        return;
}

        this.dropSelf(block);
    });
}
}
