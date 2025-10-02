package com.magicgoldfishboy.futuretasticdecor.registry;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class CraftingMaterialRegistry {

    public static DeferredItem<Item> COKE;

    public static void registerCraftingMaterials() {

        COKE = FuturetasticDecor.ITEMS.registerSimpleItem(
            "coke", 
            new Item.Properties()
        );

    }
    
}
