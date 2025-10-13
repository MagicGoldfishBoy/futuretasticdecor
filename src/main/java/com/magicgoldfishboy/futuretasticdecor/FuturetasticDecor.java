package com.magicgoldfishboy.futuretasticdecor;

import javax.swing.text.html.parser.Entity;

import org.slf4j.Logger;

import com.magicgoldfishboy.futuretasticdecor.datagen.Datagen;
import com.magicgoldfishboy.futuretasticdecor.registry.CarbonFiberRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.CraftingMaterialRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.EntityRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.GlassRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.GlowBlockRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.MetalRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.PlasticRegistry;
import com.mojang.logging.LogUtils;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(FuturetasticDecor.MODID)
public class FuturetasticDecor {

    //public static Integer SUPER_MULCH_SPREAD_INTERVAL;
    
    public static final String MODID = "futuretasticdecor";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FuturetasticDecor.MODID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, FuturetasticDecor.MODID);
    
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, FuturetasticDecor.MODID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("futuretastic_decor", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.futuretasticdecor"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> MetalRegistry.STEEL_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.acceptAll(
                ITEMS.getEntries().stream()
                    .map(sup -> sup.get().getDefaultInstance())
                    .filter(itemStack -> itemStack != null && !itemStack.isEmpty())
                    .toList()
            );
            }).build());

    public FuturetasticDecor(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        modEventBus.addListener(this::onClientSetup);

        modEventBus.addListener(this::onRegisterRenderers);


        BLOCKS.register(modEventBus);

        ITEMS.register(modEventBus);

        CREATIVE_MODE_TABS.register(modEventBus);

        ENTITIES.register(modEventBus);

        BLOCK_ENTITIES.register(modEventBus);

        MENUS.register(modEventBus);


        EntityRegistry.init(modEventBus);

        CraftingMaterialRegistry.registerCraftingMaterials();

        PlasticRegistry.registerPlastics();

        CarbonFiberRegistry.registerCarbonFiber();

        MetalRegistry.registerMetals();

        GlowBlockRegistry.registerGlowBlocks();

        GlassRegistry.registerglass();

        LaboratoryDecorRegistry.registerAll();


        NeoForge.EVENT_BUS.register(this);
        NeoForge.EVENT_BUS.register(TooltipHandler.class);

        modEventBus.addListener(this::gatherData);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        
    }
    
    private void commonSetup(FMLCommonSetupEvent event) {

        LOGGER.info("HELLO FROM COMMON SETUP");

        //SUPER_MULCH_SPREAD_INTERVAL = Integer.parseInt(Config.SUPER_MULCH_SPREAD_INTERVAL.toString());

        // if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
        //     LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
        // }

        // LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());

        // Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    public void gatherData(GatherDataEvent.Client event) {
        Datagen datagen = new Datagen();
        datagen.gatherData(event);
    }


    public class TooltipHandler {

        @SubscribeEvent
        public static void onItemTooltip(ItemTooltipEvent event) {
           // LOGGER.info("Adding Tooltips");
            if (event.getItemStack().getItem() == GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()) {
                event.getToolTip().add(Component.translatable("block.futuretasticdecor.hologlass_block.tooltip"));
            }
            if (event.getItemStack().getItem() == GlassRegistry.HOLOGLASS_PANE_ITEM.get()) {
                event.getToolTip().add(Component.translatable("block.futuretasticdecor.hologlass_pane.tooltip"));
            }
        }
    }


    public void onClientSetup(FMLClientSetupEvent event)
    {
        LOGGER.info("Setting Render Layers");
        ItemBlockRenderTypes.setRenderLayer(GlassRegistry.HOLOGLASS_BLOCK.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(GlassRegistry.HOLOGLASS_PANE.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STEEL_DOOR.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(LaboratoryDecorRegistry.HOLOTABLE.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(LaboratoryDecorRegistry.HOLOCHAIR.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(LaboratoryDecorRegistry.HOLOSHELF.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(LaboratoryDecorRegistry.HOLOTV.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(LaboratoryDecorRegistry.WHITE_SLIDING_DOOR.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(LaboratoryDecorRegistry.HOLOCRAFTINGTABLE.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(LaboratoryDecorRegistry.HOLOLIGHT.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(LaboratoryDecorRegistry.HOLO_DESK_LAMP.get(), ChunkSectionLayer.TRANSLUCENT);

        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STARMETAL_BLOCK.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STARMETAL_BARS_BLOCK.get(), ChunkSectionLayer.CUTOUT_MIPPED);
        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STARMETAL_BARS.get(), ChunkSectionLayer.CUTOUT_MIPPED);
        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STARMETAL_LAMP.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STARMETAL_PILLAR.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STARMETAL_TABLE.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STARMETAL_CHAIR.get(), ChunkSectionLayer.TRANSLUCENT);
        ItemBlockRenderTypes.setRenderLayer(MetalRegistry.STARMETAL_SHELF.get(), ChunkSectionLayer.TRANSLUCENT);
    }

    public void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.CHAIR_ENTITY.get(), NoopRenderer::new);
        //event.registerEntityRenderer(EntityRegistry.BED_ENTITY.get(), NoopRenderer::new);
    }
}
