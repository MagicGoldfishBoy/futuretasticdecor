package com.magicgoldfishboy.futuretasticdecor.registry;

import java.util.function.Supplier;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.container.HoloCraftingTableMenu;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MenuRegistry {
    public static final Supplier<MenuType<HoloCraftingTableMenu>> HOLO_CRAFTING_MENU = 
        FuturetasticDecor.MENUS.register("holo_crafting_menu", 
        () -> new MenuType<>(HoloCraftingTableMenu::new, FeatureFlags.DEFAULT_FLAGS));
    
    public static void registerAll() {
    }
}
