package com.magicgoldfishboy.futuretasticdecor;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = FuturetasticDecor.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = FuturetasticDecor.MODID, value = Dist.CLIENT)
public class FuturetasticDecorClient {
    public FuturetasticDecorClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        FuturetasticDecor.LOGGER.info("HELLO FROM CLIENT SETUP");
        FuturetasticDecor.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    // @SubscribeEvent
    // public static void registerAdditionalModels(ModelEvent.RegisterAdditional event) {
    //     // Register your bed models so they're loaded
    //     event.register(ResourceLocation.fromNamespaceAndPath("yourmodid", "block/custom_bed_head"));
    //     event.register(ResourceLocation.fromNamespaceAndPath("yourmodid", "block/custom_bed_foot"));
    // }
}
