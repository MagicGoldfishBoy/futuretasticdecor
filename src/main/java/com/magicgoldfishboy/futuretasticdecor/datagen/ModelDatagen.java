package com.magicgoldfishboy.futuretasticdecor.datagen;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.block.ConnectableGlowBlock;
import com.magicgoldfishboy.futuretasticdecor.block.Hologlass;
import com.magicgoldfishboy.futuretasticdecor.block.HologlassBlock;
import com.magicgoldfishboy.futuretasticdecor.block.Panel;
import com.magicgoldfishboy.futuretasticdecor.block.Wallpaper;
import com.magicgoldfishboy.futuretasticdecor.registry.CarbonFiberRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.CraftingMaterialRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.GlassRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.GlowBlockRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.MetalRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.PlasticRegistry;
import com.mojang.datafixers.types.templates.List;

import net.minecraft.client.renderer.block.model.multipart.CombinedCondition;
import net.minecraft.client.renderer.block.model.multipart.Condition;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.BiConsumer;

import javax.annotation.Nonnull;

public class ModelDatagen extends ModelProvider {
    public ModelDatagen(PackOutput output) {
        super(output, FuturetasticDecor.MODID);
    }

    // public final ItemModelOutput itemModelOutput;
    // public final BiConsumer<ResourceLocation, ModelInstance> modelOutput;

    @Override
    protected void registerModels(@Nonnull BlockModelGenerators blockModels, @Nonnull ItemModelGenerators itemModels) {
        registerMaterialModels(blockModels, itemModels);
        registerPlasticModels(blockModels, itemModels);
        registerCarbonFiberModels(blockModels, itemModels);
        registerMetalModels(blockModels, itemModels);
        registerGlowBlockModels(blockModels, itemModels);
        registerPlanterModels(blockModels, itemModels);
        registerGlassModels(blockModels, itemModels);
        registerLabDecorModels(blockModels, itemModels);
    }

    protected void registerMaterialModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(CraftingMaterialRegistry.COKE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(CraftingMaterialRegistry.STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.RED_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.ORANGE_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.YELLOW_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.LIME_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.GREEN_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.CYAN_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.LIGHT_BLUE_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.BLUE_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.PURPLE_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.MAGENTA_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.PINK_STARDUST_POWDER.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(CraftingMaterialRegistry.ANTI_GRAV_ALLOY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.ANTI_GRAV_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CraftingMaterialRegistry.ANTI_GRAV_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        blockModels.createTrivialCube(CraftingMaterialRegistry.ANTI_GRAV_BLOCK.get());


        blockModels.createTrivialCube(CraftingMaterialRegistry.SUPER_GROW_MULCH_BLOCK.get());

    }

    protected void registerPlasticModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(PlasticRegistry.RAW_WHITE_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_RED_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_ORANGE_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_YELLOW_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_LIME_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_GREEN_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_CYAN_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_LIGHT_BLUE_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_BLUE_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_PURPLE_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_MAGENTA_PLASTIC.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RAW_PINK_PLASTIC.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(PlasticRegistry.WHITE_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.RED_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.ORANGE_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.YELLOW_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.LIME_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.GREEN_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.CYAN_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.LIGHT_BLUE_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.BLUE_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.PURPLE_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.MAGENTA_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(PlasticRegistry.PINK_PLASTIC_PELLET.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(PlasticRegistry.WHITE_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.RED_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.ORANGE_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.YELLOW_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.LIME_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.GREEN_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.CYAN_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.LIGHT_BLUE_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.BLUE_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.PURPLE_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.MAGENTA_PLASTIC_BLOCK.get());
        blockModels.createTrivialCube(PlasticRegistry.PINK_PLASTIC_BLOCK.get());

    }
    protected void registerCarbonFiberModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(CarbonFiberRegistry.CARBON_POWDER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CarbonFiberRegistry.CARBON_FIBER_TOW.get(), ModelTemplates.FLAT_ITEM);
        blockModels.createTrivialCube(CarbonFiberRegistry.UNBAKED_CARBON_FIBER_POLYMER_BLOCK.get());
        blockModels.createTrivialCube(CarbonFiberRegistry.CARBON_FIBER_POLYMER_BLOCK.get());
    }
    protected void registerMetalModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(MetalRegistry.STEEL_ALLOY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MetalRegistry.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MetalRegistry.STEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(MetalRegistry.STEEL_BLOCK.get());

        blockModels.familyWithExistingFullBlock(MetalRegistry.STEEL_BLOCK.get())
            .slab(MetalRegistry.STEEL_SLAB.get())
            .button(MetalRegistry.STEEL_BUTTON.get())
            .stairs(MetalRegistry.STEEL_STAIRS.get());

        blockModels.createDoor(MetalRegistry.STEEL_DOOR.get());

        blockModels.createTrivialCube(MetalRegistry.GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.RED_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.ORANGE_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.YELLOW_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.LIME_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.GREEN_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.CYAN_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.LIGHT_BLUE_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.BLUE_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.PURPLE_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.MAGENTA_GLOWING_STEEL_BLOCK.get());

        blockModels.createTrivialCube(MetalRegistry.PINK_GLOWING_STEEL_BLOCK.get());
    }
    protected void registerGlowBlockModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        blockModels.createTrivialCube(GlowBlockRegistry.GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.RED_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.ORANGE_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.YELLOW_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.LIME_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.GREEN_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.CYAN_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.LIGHT_BLUE_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.BLUE_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.PURPLE_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.MAGENTA_GLOW_BLOCK.get());

        blockModels.createTrivialCube(GlowBlockRegistry.PINK_GLOW_BLOCK.get());



        Panel glow_panel = GlowBlockRegistry.GLOW_PANEL.get();
        Variant glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, glow_panel, glow_panel_variant);


        Panel red_glow_panel = GlowBlockRegistry.RED_GLOW_PANEL.get();
        Variant red_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(red_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, red_glow_panel, red_glow_panel_variant);


        Panel orange_glow_panel = GlowBlockRegistry.ORANGE_GLOW_PANEL.get();
        Variant orange_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(orange_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, orange_glow_panel, orange_glow_panel_variant);


        Panel yellow_glow_panel = GlowBlockRegistry.YELLOW_GLOW_PANEL.get();
        Variant yellow_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(yellow_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, yellow_glow_panel, yellow_glow_panel_variant);


        Panel lime_glow_panel = GlowBlockRegistry.LIME_GLOW_PANEL.get();
        Variant lime_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(lime_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, lime_glow_panel, lime_glow_panel_variant);


        Panel green_glow_panel = GlowBlockRegistry.GREEN_GLOW_PANEL.get();
        Variant green_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(green_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, green_glow_panel, green_glow_panel_variant);


        Panel cyan_glow_panel = GlowBlockRegistry.CYAN_GLOW_PANEL.get();
        Variant cyan_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(cyan_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, cyan_glow_panel, cyan_glow_panel_variant);


        Panel light_blue_glow_panel = GlowBlockRegistry.LIGHT_BLUE_GLOW_PANEL.get();
        Variant light_blue_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(light_blue_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, light_blue_glow_panel, light_blue_glow_panel_variant);


        Panel blue_glow_panel = GlowBlockRegistry.BLUE_GLOW_PANEL.get();
        Variant blue_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(blue_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, blue_glow_panel, blue_glow_panel_variant);


        Panel purple_glow_panel = GlowBlockRegistry.PURPLE_GLOW_PANEL.get();
        Variant purple_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(purple_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, purple_glow_panel, purple_glow_panel_variant);


        Panel magenta_glow_panel = GlowBlockRegistry.MAGENTA_GLOW_PANEL.get();
        Variant magenta_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(magenta_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, magenta_glow_panel, magenta_glow_panel_variant);


        Panel pink_glow_panel = GlowBlockRegistry.PINK_GLOW_PANEL.get();
        Variant pink_glow_panel_variant = new Variant(ModelLocationUtils.getModelLocation(pink_glow_panel));

        ModelDatagenHelpers.createPanelModel(blockModels, itemModels, pink_glow_panel, pink_glow_panel_variant);

        // ConnectableGlowBlock connectable_glowing_steel_block = MetalRegistry.CONNECTABLE_GLOWING_STEEL_BLOCK.get();
        // MultiVariant plain = new MultiVariant(WeightedList.of(block_variant_plain));
        // MultiVariant line = new MultiVariant(WeightedList.of(block_variant_line));
        // MultiVariant corner = new MultiVariant(WeightedList.of(block_variant_corner));

    }
    protected void registerGlassModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        HologlassBlock hologlass_block = GlassRegistry.HOLOGLASS_BLOCK.get();
        Variant hologlass_block_closed = new Variant(ModelLocationUtils.getModelLocation(hologlass_block));
        Variant hologlass_block_open = new Variant(modLocation("block/hologlass_block_open"));
        MultiVariant hologlass_block_closed_multi = new MultiVariant(WeightedList.of(hologlass_block_closed));
        MultiVariant hologlass_block_open_multi = new MultiVariant(WeightedList.of(hologlass_block_open));

        blockModels.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(hologlass_block).with(
                PropertyDispatch.initial(BlockStateProperties.OPEN)
                    .select(false, hologlass_block_closed_multi)
                    .select(true, hologlass_block_open_multi)
            )
        );
        Hologlass hologlass_pane = GlassRegistry.HOLOGLASS_PANE.get();
        TextureMapping texturemapping = TextureMapping.pane(hologlass_block, hologlass_pane);

        Variant hologlass_pane_closed = new Variant(ModelLocationUtils.getModelLocation(hologlass_pane));
        MultiVariant multivariant_closed = BlockModelGenerators.plainVariant(ModelTemplates.STAINED_GLASS_PANE_POST.create(hologlass_pane, texturemapping, blockModels.modelOutput));
        MultiVariant multivariant1_closed = BlockModelGenerators.plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE.create(hologlass_pane, texturemapping, blockModels.modelOutput));
        MultiVariant multivariant2_closed = BlockModelGenerators.plainVariant(ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.create(hologlass_pane, texturemapping, blockModels.modelOutput));
        MultiVariant multivariant3_closed = BlockModelGenerators.plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE.create(hologlass_pane, texturemapping, blockModels.modelOutput));
        MultiVariant multivariant4_closed = BlockModelGenerators.plainVariant(ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.create(hologlass_pane, texturemapping, blockModels.modelOutput));

        Variant hologlass_pane_open_post = new Variant(modLocation("block/opaque_hologlass_glass_pane_post"));
        Variant hologlass_pane_open_side = new Variant(modLocation("block/opaque_hologlass_glass_pane_side"));
        Variant hologlass_pane_open_side_alt = new Variant(modLocation("block/opaque_hologlass_pane_side_alt"));
        Variant hologlass_pane_open_noside = new Variant(modLocation("block/opaque_hologlass_glass_pane_noside"));
        Variant hologlass_pane_open_noside_alt = new Variant(modLocation("block/opaque_hologlass_glass_pane_noside_alt"));

        MultiVariant multivariant_open = BlockModelGenerators.variant(hologlass_pane_open_post);
        MultiVariant multivariant1_open = BlockModelGenerators.variant(hologlass_pane_open_side);
        MultiVariant multivariant2_open = BlockModelGenerators.variant(hologlass_pane_open_side_alt);
        MultiVariant multivariant3_open = BlockModelGenerators.variant(hologlass_pane_open_noside);
        MultiVariant multivariant4_open = BlockModelGenerators.variant(hologlass_pane_open_noside_alt);

        Item item = hologlass_pane.asItem();
        blockModels.registerSimpleItemModel(item, blockModels.createFlatItemModelWithBlockTexture(item, hologlass_block));

        blockModels.blockStateOutput.accept(
            MultiPartGenerator.multiPart(hologlass_pane)
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.OPEN, false),
                    multivariant_closed
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.OPEN, false),
                    multivariant1_closed
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(BlockStateProperties.OPEN, false),
                    multivariant1_closed.with(BlockModelGenerators.Y_ROT_90)
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.OPEN, false),
                    multivariant2_closed
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(BlockStateProperties.OPEN, false),
                    multivariant2_closed.with(BlockModelGenerators.Y_ROT_90)
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.OPEN, false),
                    multivariant3_closed
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.EAST, false).term(BlockStateProperties.OPEN, false),
                    multivariant4_closed
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.OPEN, false),
                    multivariant4_closed.with(BlockModelGenerators.Y_ROT_90)
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.WEST, false).term(BlockStateProperties.OPEN, false),
                    multivariant3_closed.with(BlockModelGenerators.Y_ROT_270)
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.OPEN, true),
                    multivariant_open
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.NORTH, true).term(BlockStateProperties.OPEN, true),
                    multivariant1_open
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.EAST, true).term(BlockStateProperties.OPEN, true),
                    multivariant1_open.with(BlockModelGenerators.Y_ROT_90)
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, true).term(BlockStateProperties.OPEN, true),
                    multivariant2_open
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.WEST, true).term(BlockStateProperties.OPEN, true),
                    multivariant2_open.with(BlockModelGenerators.Y_ROT_90)
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.NORTH, false).term(BlockStateProperties.OPEN, true),
                    multivariant3_open
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.EAST, false).term(BlockStateProperties.OPEN, true),
                    multivariant4_open
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.SOUTH, false).term(BlockStateProperties.OPEN, true),
                    multivariant4_open.with(BlockModelGenerators.Y_ROT_90)
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.WEST, false).term(BlockStateProperties.OPEN, true),
                    multivariant3_open.with(BlockModelGenerators.Y_ROT_270)
                )
            );
    }
    protected void registerLabDecorModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(LaboratoryDecorRegistry.HOLOTILES_BLOCK.get());

            Wallpaper holowallpaper = LaboratoryDecorRegistry.HOLOWALLPAPER.get();
            Variant holowallpaper_up = new Variant(modLocation("block/holowallpaper_up"));
            Variant holowallpaper_middle = new Variant(modLocation("block/holowallpaper_middle"));
            Variant holowallpaper_down = new Variant(modLocation("block/holowallpaper_down"));
            Variant holowallpaper_single = new Variant(modLocation("block/holowallpaper_single"));

            MultiVariant holowallpaper_up_multi = new MultiVariant(WeightedList.of(holowallpaper_up));
            MultiVariant holowallpaper_middle_multi = new MultiVariant(WeightedList.of(holowallpaper_middle));
            MultiVariant holowallpaper_down_multi = new MultiVariant(WeightedList.of(holowallpaper_down));
            MultiVariant holowallpaper_single_multi = new MultiVariant(WeightedList.of(holowallpaper_single));

        blockModels.blockStateOutput.accept(
            MultiPartGenerator.multiPart(holowallpaper)
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.UP, true).term(BlockStateProperties.DOWN, false),
                    holowallpaper_down_multi
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.UP, false).term(BlockStateProperties.DOWN, false),
                    holowallpaper_single_multi
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.UP, true).term(BlockStateProperties.DOWN, true),
                    holowallpaper_middle_multi
                )
                .with(
                    BlockModelGenerators.condition().term(BlockStateProperties.UP, false).term(BlockStateProperties.DOWN, true),
                    holowallpaper_up_multi
                )
        );
        itemModels.itemModelOutput.accept(
            LaboratoryDecorRegistry.HOLOWALLPAPER_ITEM.get(),
            ItemModelUtils.plainModel(modLocation("block/holowallpaper_single"))
        );
    }
    protected void registerPlanterModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        LOGGER.info("Creating Planter Models");

        for (DeferredHolder<Block, ? extends Block> holder : FuturetasticDecor.BLOCKS.getEntries()) {
            String rawName = holder.getId().getPath();
            if (rawName.contains("planter")) {
                String name = "block/" + rawName;

                LOGGER.info("Generating model for: {}", name);

                ResourceLocation planter = modLocation(name);
                Variant plantervariant = new Variant(planter);

                blockModels.blockStateOutput.accept(
                    MultiVariantGenerator.dispatch(
                        holder.get(),
                        BlockModelGenerators.variant(plantervariant)
                    )
                );
            }
        }

        for (DeferredHolder<Item, ? extends Item> holder : FuturetasticDecor.ITEMS.getEntries()) {
            String rawName = holder.getId().getPath();
            if (rawName.contains("planter")) {
                String name = "block/" + rawName;

                LOGGER.info("Generating model for: {}", name);

                itemModels.itemModelOutput.accept(
                holder.get(),
                ItemModelUtils.plainModel(modLocation(name))
            );
            }
        }
    }
}
