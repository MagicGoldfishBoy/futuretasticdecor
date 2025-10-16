package com.magicgoldfishboy.futuretasticdecor.datagen;

import java.util.concurrent.CompletableFuture;

import com.magicgoldfishboy.futuretasticdecor.registry.CarbonFiberRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.CraftingMaterialRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.GlassRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.GlowBlockRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.LaboratoryDecorRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.MetalRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.PlasticRegistry;

import net.minecraft.client.resources.model.Material;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class RecipeDatagen extends RecipeProvider {

    protected RecipeDatagen(Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static final TagKey<Item> COALS_TAG = ItemTags.create(
        ResourceLocation.fromNamespaceAndPath("minecraft", "coals")
    );

    @Override
    protected void buildRecipes() {
        registerMaterialRecipes();
        registerPlasticRecipes();
        registerCarbonFiberRecipes();
        registerMetalRecipes();
        registerGlowBlockRecipes();
        registerGlassBlockRecipes();
        registerLabDecorRecipes();
    }

    protected void registerMaterialRecipes() {

        SimpleCookingRecipeBuilder.smelting(
            this.tag(COALS_TAG),
            RecipeCategory.MISC, 
            CraftingMaterialRegistry.COKE.get(),
            0.1f,
            150
        )
        .unlockedBy("has_coal", has(Items.COAL))
        .unlockedBy("has_charcoal", has(Items.CHARCOAL))
        .save(this.output, "coke_from_smelting");

        SimpleCookingRecipeBuilder.blasting(
            this.tag(COALS_TAG),
            RecipeCategory.MISC, 
            CraftingMaterialRegistry.COKE.get(),
            0.1f,
            100
        )
        .unlockedBy("has_coal", has(Items.COAL))
        .unlockedBy("has_charcoal", has(Items.CHARCOAL))
        .save(this.output, "coke_from_blasting");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.STARDUST_POWDER.get(), 4)
            .pattern("%#%")
            .pattern("#$#")
            .pattern("%#%")
            .define('#', Items.GLOWSTONE_DUST)
            .define('$', Items.SOUL_SAND)
            .define('%', Items.MAGMA_BLOCK)
            .unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST))
            .unlockedBy("has_soul_sand", has(Items.SOUL_SAND))
            .unlockedBy("has_magma_block", has(Items.MAGMA_BLOCK))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.RED_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.RED_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_red_dye", has(Items.RED_DYE))
            .save(this.output, "red_stardust_powder_from_stardust_and_red_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.ORANGE_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.ORANGE_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_orange_dye", has(Items.ORANGE_DYE))
            .save(this.output, "orange_stardust_powder_from_stardust_and_orange_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.YELLOW_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.YELLOW_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_yellow_dye", has(Items.YELLOW_DYE))
            .save(this.output, "yellow_stardust_powder_from_stardust_and_yellow_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.LIME_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.LIME_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_lime_dye", has(Items.LIME_DYE))
            .save(this.output, "lime_stardust_powder_from_stardust_and_lime_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.GREEN_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.GREEN_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_green_dye", has(Items.GREEN_DYE))
            .save(this.output, "green_stardust_powder_from_stardust_and_green_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.CYAN_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.CYAN_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_cyan_dye", has(Items.CYAN_DYE))
            .save(this.output, "cyan_stardust_powder_from_stardust_and_cyan_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.LIGHT_BLUE_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.LIGHT_BLUE_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_light_blue_dye", has(Items.LIGHT_BLUE_DYE))
            .save(this.output, "light_blue_stardust_powder_from_stardust_and_light_blue_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.BLUE_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.BLUE_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_blue_dye", has(Items.BLUE_DYE))
            .save(this.output, "blue_stardust_powder_from_stardust_and_blue_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.PURPLE_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.PURPLE_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_purple_dye", has(Items.PURPLE_DYE))
            .save(this.output, "purple_stardust_powder_from_stardust_and_purple_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.MAGENTA_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.MAGENTA_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_magenta_dye", has(Items.MAGENTA_DYE))
            .save(this.output, "magenta_stardust_powder_from_stardust_and_magenta_dye");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.PINK_STARDUST_POWDER.get())
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.PINK_DYE)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_pink_dye", has(Items.PINK_DYE))
            .save(this.output, "pink_stardust_powder_from_stardust_and_pink_dye");



        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.ANTI_GRAV_ALLOY.get(), 2)
            .pattern("%#%")
            .pattern("#$#")
            .pattern("%#%")
            .define('#', Items.RAW_GOLD)
            .define('$', Items.ENDER_EYE)
            .define('%', Items.CRYING_OBSIDIAN)
            .unlockedBy("has_raw_gold", has(Items.RAW_GOLD))
            .unlockedBy("has_ender_eye", has(Items.ENDER_EYE))
            .unlockedBy("has_crying_obsidian", has(Items.CRYING_OBSIDIAN))
            .save(this.output);


        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(CraftingMaterialRegistry.ANTI_GRAV_ALLOY.get()),
            RecipeCategory.MISC, 
            CraftingMaterialRegistry.ANTI_GRAV_INGOT.get(),
            1.0f,
            500
        )
        .unlockedBy("has_anti_grav_alloy", has(CraftingMaterialRegistry.ANTI_GRAV_ALLOY.get()))
        .save(this.output, "anti_grav_ingot_from_smelting");

        SimpleCookingRecipeBuilder.blasting(
            Ingredient.of(CraftingMaterialRegistry.ANTI_GRAV_ALLOY.get()),
            RecipeCategory.MISC, 
            CraftingMaterialRegistry.ANTI_GRAV_INGOT.get(),
            1.0f,
            250
        )
        .unlockedBy("has_anti_grav_alloy", has(CraftingMaterialRegistry.ANTI_GRAV_ALLOY.get()))
        .save(this.output, "anti_grav_ingot_from_blasting");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.ANTI_GRAV_INGOT.get(), 9)
            .requires(CraftingMaterialRegistry.ANTI_GRAV_BLOCK_ITEM.get())
            .unlockedBy("has_anti_grav_block", has(CraftingMaterialRegistry.ANTI_GRAV_BLOCK.get()))
            .save(this.output, "anti_grav_ingot_from_anti_grav_block");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.ANTI_GRAV_INGOT.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', CraftingMaterialRegistry.ANTI_GRAV_NUGGET.get())
            .unlockedBy("has_anti_grav_nugget", has(CraftingMaterialRegistry.ANTI_GRAV_NUGGET.get()))
            .save(this.output, "anti_grav_ingot_from_anti_grav_nugget");


        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CraftingMaterialRegistry.ANTI_GRAV_NUGGET.get(), 9)
            .requires(CraftingMaterialRegistry.ANTI_GRAV_INGOT.get())
            .unlockedBy("has_anti_grav_ingot", has(CraftingMaterialRegistry.ANTI_GRAV_INGOT.get()))
            .save(this.output, "anti_grav_nugget_from_anti_grav_ingot");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, CraftingMaterialRegistry.ANTI_GRAV_BLOCK.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', CraftingMaterialRegistry.ANTI_GRAV_INGOT.get())
            .unlockedBy("has_anti_grav_ingot", has(CraftingMaterialRegistry.ANTI_GRAV_INGOT.get()))
            .save(this.output, "anti_grav_block_from_anti_grav_ingot");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, CraftingMaterialRegistry.SUPER_GROW_MULCH_ITEM.get(), 6)
            .requires(Items.DIRT)
            .requires(Items.BONE)
            .requires(Items.SOUL_SOIL)
            .unlockedBy("has_dirt", has(Items.DIRT))
            .unlockedBy("has_bone", has(Items.BONE))
            .unlockedBy("has_soul_soil", has(Items.SOUL_SOIL))
            .save(this.output);


    }
    protected void registerPlasticRecipes() {

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_WHITE_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.WHITE_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_white_dye", has(Items.WHITE_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_RED_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.RED_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_red_dye", has(Items.RED_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_ORANGE_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.ORANGE_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_orange_dye", has(Items.ORANGE_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_YELLOW_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.YELLOW_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_yellow_dye", has(Items.YELLOW_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_LIME_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.LIME_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_lime_dye", has(Items.LIME_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_GREEN_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.GREEN_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_green_dye", has(Items.GREEN_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_CYAN_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.CYAN_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_cyan_dye", has(Items.CYAN_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_LIGHT_BLUE_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.LIGHT_BLUE_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_light_blue_dye", has(Items.LIGHT_BLUE_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_BLUE_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.BLUE_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_blue_dye", has(Items.BLUE_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_PURPLE_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.PURPLE_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_purple_dye", has(Items.PURPLE_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_MAGENTA_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.MAGENTA_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_magenta_dye", has(Items.MAGENTA_DYE))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RAW_PINK_PLASTIC.get(), 6)
            .requires(CarbonFiberRegistry.CARBON_POWDER.get())
            .requires(Items.MAGMA_CREAM)
            .requires(Items.PINK_DYE)
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .unlockedBy("has_magma_cream", has(Items.MAGMA_CREAM))
            .unlockedBy("has_pink_dye", has(Items.PINK_DYE))
            .save(this.output);


        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_WHITE_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.WHITE_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_white_plastic", has(PlasticRegistry.RAW_WHITE_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_RED_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.RED_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_red_plastic", has(PlasticRegistry.RAW_RED_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_ORANGE_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.ORANGE_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_orange_plastic", has(PlasticRegistry.RAW_ORANGE_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_YELLOW_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.YELLOW_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_yellow_plastic", has(PlasticRegistry.RAW_YELLOW_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_LIME_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.LIME_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_lime_plastic", has(PlasticRegistry.RAW_LIME_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_GREEN_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.GREEN_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_green_plastic", has(PlasticRegistry.RAW_GREEN_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_CYAN_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.CYAN_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_cyan_plastic", has(PlasticRegistry.RAW_CYAN_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_LIGHT_BLUE_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.LIGHT_BLUE_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_light_blue_plastic", has(PlasticRegistry.RAW_LIGHT_BLUE_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_BLUE_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.BLUE_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_blue_plastic", has(PlasticRegistry.RAW_BLUE_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_PURPLE_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.PURPLE_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_purple_plastic", has(PlasticRegistry.RAW_PURPLE_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_MAGENTA_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.MAGENTA_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_magenta_plastic", has(PlasticRegistry.RAW_MAGENTA_PLASTIC.get()))
            .save(this.output);

        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(PlasticRegistry.RAW_PINK_PLASTIC.get()), 
            RecipeCategory.MISC, 
            PlasticRegistry.PINK_PLASTIC_PELLET.get(), 
            0.5f, 
            100)
            .unlockedBy("has_raw_pink_plastic", has(PlasticRegistry.RAW_PINK_PLASTIC.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.WHITE_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.WHITE_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.WHITE_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.RED_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.RED_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.RED_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.ORANGE_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.ORANGE_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.ORANGE_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.YELLOW_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.YELLOW_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.YELLOW_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.LIME_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.LIME_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.LIME_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.GREEN_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.GREEN_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.GREEN_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.CYAN_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.CYAN_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.CYAN_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.LIGHT_BLUE_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.LIGHT_BLUE_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.LIGHT_BLUE_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.BLUE_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.BLUE_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.BLUE_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.PURPLE_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.PURPLE_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.PURPLE_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.MAGENTA_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.MAGENTA_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.MAGENTA_PLASTIC_PELLET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, PlasticRegistry.PINK_PLASTIC_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', PlasticRegistry.PINK_PLASTIC_PELLET.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.PINK_PLASTIC_PELLET.get()))
            .save(this.output);

    }
    protected void registerCarbonFiberRecipes() {

        SingleItemRecipeBuilder.stonecutting(tag(COALS_TAG), RecipeCategory.MISC, CarbonFiberRegistry.CARBON_POWDER, 2)
            .unlockedBy("has_coal", has(Items.COAL))
            .unlockedBy("has_charcoal", has(Items.CHARCOAL))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CarbonFiberRegistry.CARBON_FIBER_TOW.get())
            .pattern("##")
            .pattern("##")
            .define('#', CarbonFiberRegistry.CARBON_POWDER.get())
            .unlockedBy("has_carbon_powder", has(CarbonFiberRegistry.CARBON_POWDER.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, CarbonFiberRegistry.UNBAKED_CARBON_FIBER_POLYMER_ITEM.get())
            .pattern("$#$")
            .pattern("#$#")
            .pattern("$#$")
            .define('#', PlasticRegistry.WHITE_PLASTIC_PELLET.get())
            .define('$', CarbonFiberRegistry.CARBON_FIBER_TOW.get())
            .unlockedBy("has_plastic_pellet", has(PlasticRegistry.WHITE_PLASTIC_PELLET.get()))
            .unlockedBy("has_carbon_tow", has(CarbonFiberRegistry.CARBON_FIBER_TOW.get()))
            .save(this.output);


        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(CarbonFiberRegistry.UNBAKED_CARBON_FIBER_POLYMER_ITEM.get()), 
            RecipeCategory.MISC, 
            CarbonFiberRegistry.CARBON_FIBER_POLYMER_ITEM.get(), 
            0.75f, 
            200)
            .unlockedBy("has_unbaked_carbon_fiber_polymer_item", has(CarbonFiberRegistry.UNBAKED_CARBON_FIBER_POLYMER_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, CarbonFiberRegistry.CARBON_FIBER_PLANTER_ITEM.get())
            .pattern("#$#")
            .pattern("###")
            .pattern("# #")
            .define('#', CarbonFiberRegistry.CARBON_FIBER_TOW.get())
            .define('$', CraftingMaterialRegistry.SUPER_GROW_MULCH_ITEM.get())
            .unlockedBy("has_carbon_fiber_tow", has(CarbonFiberRegistry.CARBON_FIBER_TOW.get()))
            .unlockedBy("has_super_grow_mulch", has(CraftingMaterialRegistry.SUPER_GROW_MULCH_ITEM.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, CarbonFiberRegistry.FLOATING_CARBON_FIBER_PLANTER_ITEM.get())
            .pattern("#")
            .pattern("$")
            .pattern("%")
            .define('#', Items.REDSTONE)
            .define('$', CarbonFiberRegistry.CARBON_FIBER_PLANTER_ITEM.get())
            .define('%', CraftingMaterialRegistry.ANTI_GRAV_INGOT.get())
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_carbon_fiber_planter", has(CarbonFiberRegistry.CARBON_FIBER_PLANTER_ITEM.get()))
            .unlockedBy("has_anti_grav_ingot", has(CraftingMaterialRegistry.ANTI_GRAV_INGOT.get()))
            .save(this.output);
    }

    protected void registerMetalRecipes() {
        registerSteelRecipes();
        registerStarMetalRecipes();
    }
    protected void registerSteelRecipes() {

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STEEL_ALLOY.get(), 2)
            .requires(CraftingMaterialRegistry.COKE.get())
            .requires(Items.RAW_IRON)
            .unlockedBy("has_coke", has(CraftingMaterialRegistry.COKE.get()))
            .unlockedBy("has_raw_iron", has(Items.RAW_IRON))
            .save(this.output, "steel_alloy_from_coke_and_iron_ingot");


        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(MetalRegistry.STEEL_ALLOY.get()),
            RecipeCategory.MISC, 
            MetalRegistry.STEEL_INGOT.get(),
            0.1f,
            200
        )
        .unlockedBy("has_steel_alloy", has(MetalRegistry.STEEL_ALLOY.get()))
        .save(this.output, "steel_ingot_from_smelting");

        SimpleCookingRecipeBuilder.blasting(
            Ingredient.of(MetalRegistry.STEEL_ALLOY.get()),
            RecipeCategory.MISC, 
            MetalRegistry.STEEL_INGOT.get(),
            0.1f,
            100
        )
        .unlockedBy("has_steel_alloy", has(MetalRegistry.STEEL_ALLOY.get()))
        .save(this.output, "steel_ingot_from_blasting");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STEEL_INGOT.get(), 9)
            .requires(MetalRegistry.STEEL_BLOCK.get())
            .unlockedBy("has_steel_block", has(MetalRegistry.STEEL_BLOCK.get()))
            .save(this.output, "steel_ingot_from_steel_block");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STEEL_INGOT.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_NUGGET.get())
            .unlockedBy("has_steel_nugget", has(MetalRegistry.STEEL_NUGGET.get()))
            .save(this.output, "steel_ingot_from_steel_nugget");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STEEL_BLOCK.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .save(this.output, "steel_block_from_steel_ingot");


        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STEEL_NUGGET.get(), 9)
            .requires(MetalRegistry.STEEL_INGOT.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .save(this.output, "steel_nugget_from_steel_ingot");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STEEL_SLAB.get(), 6)
            .pattern("###")
            .define('#', MetalRegistry.STEEL_BLOCK.get())
            .unlockedBy("has_steel_block", has(MetalRegistry.STEEL_BLOCK.get()))
            .save(this.output, "steel_slab_from_steel_block");
        
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MetalRegistry.STEEL_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STEEL_SLAB.get(), 2)
            .unlockedBy("has_steel_block", has(MetalRegistry.STEEL_BLOCK.get()))
            .save(this.output, "steel_slab_from_steel_block_stonecutter");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STEEL_STAIRS.get(), 4)
            .pattern("#  ")
            .pattern("## ")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_BLOCK.get())
            .unlockedBy("has_steel_block", has(MetalRegistry.STEEL_BLOCK.get()))
            .save(this.output, "steel_stairs_from_steel_block");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MetalRegistry.STEEL_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STEEL_STAIRS.get(), 1)
            .unlockedBy("has_steel_block", has(MetalRegistry.STEEL_BLOCK.get()))
            .save(this.output, "steel_stairs_from_steel_block_stonecutter");      


        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, MetalRegistry.STEEL_BUTTON_ITEM.get())
            .requires(MetalRegistry.STEEL_BLOCK_ITEM.get())
            .unlockedBy("has_steel_block", has(MetalRegistry.STEEL_BLOCK.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STEEL_DOOR_ITEM.get(), 3)
            .pattern("##")
            .pattern("##")
            .pattern("##")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STEEL_TABLE_ITEM.get(), 2)
            .pattern("###")
            .pattern("# #")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STEEL_CHAIR_ITEM.get(), 4)
            .pattern("  #")
            .pattern("###")
            .pattern("# #")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STEEL_SHELF_ITEM.get(), 4)
            .pattern("###")
            .pattern("$ $")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', MetalRegistry.STEEL_NUGGET.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_steel_nugget", has(MetalRegistry.STEEL_NUGGET.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .save(this.output, "glowing_steel_block_from_steel_block_and_stardust");

        // ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.CONNECTABLE_GLOWING_STEEL_BLOCK_ITEM.get())
        //     .requires(MetalRegistry.GLOWING_STEEL_BLOCK_ITEM.get())
        //     .unlockedBy("has_glowing_steel_block", has(MetalRegistry.GLOWING_STEEL_BLOCK_ITEM.get()))
        //     .save(this.output);

        // ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.GLOWING_STEEL_BLOCK_ITEM.get())
        //     .requires(MetalRegistry.CONNECTABLE_GLOWING_STEEL_BLOCK_ITEM.get())
        //     .unlockedBy("has_connectable_glowing_steel_block", has(MetalRegistry.CONNECTABLE_GLOWING_STEEL_BLOCK_ITEM.get()))
        //     .save(this.output, "glowing_steel_block_from_connectable_glowing_steel_block");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.RED_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.RED_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_red_stardust_powder", has(CraftingMaterialRegistry.RED_STARDUST_POWDER.get()))
            .save(this.output, "red_glowing_steel_block_from_steel_block_and_red_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.ORANGE_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.ORANGE_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_orange_stardust_powder", has(CraftingMaterialRegistry.ORANGE_STARDUST_POWDER.get()))
            .save(this.output, "orange_glowing_steel_block_from_steel_block_and_orange_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.YELLOW_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.YELLOW_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_yellow_stardust_powder", has(CraftingMaterialRegistry.YELLOW_STARDUST_POWDER.get()))
            .save(this.output, "yellow_glowing_steel_block_from_steel_block_and_yellow_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.LIME_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.LIME_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_lime_stardust_powder", has(CraftingMaterialRegistry.LIME_STARDUST_POWDER.get()))
            .save(this.output, "lime_glowing_steel_block_from_steel_block_and_lime_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.GREEN_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.GREEN_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_green_stardust_powder", has(CraftingMaterialRegistry.GREEN_STARDUST_POWDER.get()))
            .save(this.output, "green_glowing_steel_block_from_steel_block_and_green_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.CYAN_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.CYAN_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_cyan_stardust_powder", has(CraftingMaterialRegistry.CYAN_STARDUST_POWDER.get()))
            .save(this.output, "cyan_glowing_steel_block_from_steel_block_and_cyan_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.LIGHT_BLUE_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.LIGHT_BLUE_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_light_blue_stardust_powder", has(CraftingMaterialRegistry.LIGHT_BLUE_STARDUST_POWDER.get()))
            .save(this.output, "light_blue_glowing_steel_block_from_steel_block_and_light_blue_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.BLUE_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.BLUE_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_blue_stardust_powder", has(CraftingMaterialRegistry.BLUE_STARDUST_POWDER.get()))
            .save(this.output, "blue_glowing_steel_block_from_steel_block_and_blue_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.PURPLE_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.PURPLE_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_purple_stardust_powder", has(CraftingMaterialRegistry.PURPLE_STARDUST_POWDER.get()))
            .save(this.output, "purple_glowing_steel_block_from_steel_block_and_purple_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.MAGENTA_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.MAGENTA_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_magenta_stardust_powder", has(CraftingMaterialRegistry.MAGENTA_STARDUST_POWDER.get()))
            .save(this.output, "magenta_glowing_steel_block_from_steel_block_and_magenta_glowstone");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.PINK_GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.PINK_STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_pink_stardust_powder", has(CraftingMaterialRegistry.PINK_STARDUST_POWDER.get()))
            .save(this.output, "pink_glowing_steel_block_from_steel_block_and_pink_glowstone");

        
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STEEL_PLANTER_ITEM.get())
            .pattern("#$#")
            .pattern("###")
            .pattern("# #")
            .define('#', MetalRegistry.STEEL_INGOT)
            .define('$', CraftingMaterialRegistry.SUPER_GROW_MULCH_ITEM.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_super_grow_mulch", has(CraftingMaterialRegistry.SUPER_GROW_MULCH_ITEM.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.FLOATING_STEEL_PLANTER_ITEM.get())
            .pattern("#")
            .pattern("$")
            .pattern("%")
            .define('#', Items.REDSTONE)
            .define('$', MetalRegistry.STEEL_PLANTER_ITEM.get())
            .define('%', CraftingMaterialRegistry.ANTI_GRAV_INGOT.get())
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_steel_planter", has(MetalRegistry.STEEL_PLANTER_ITEM.get()))
            .unlockedBy("has_anti_grav_ingot", has(CraftingMaterialRegistry.ANTI_GRAV_INGOT.get()))
            .save(this.output);
    
    }
    protected void registerStarMetalRecipes() {

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STARMETAL_ALLOY.get(), 4)
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .requires(Items.RAW_GOLD)
            .requires(CraftingMaterialRegistry.COKE.get())
            .requires(Items.BLAZE_POWDER)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_raw_gold", has(Items.RAW_GOLD))
            .unlockedBy("has_coke", has(CraftingMaterialRegistry.COKE.get()))
            .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
            .save(this.output);


        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(MetalRegistry.STARMETAL_ALLOY.get()),
            RecipeCategory.MISC, 
            MetalRegistry.STARMETAL_INGOT.get(),
            1.0f,
            400
        )
        .unlockedBy("has_star_metal_alloy", has(MetalRegistry.STARMETAL_ALLOY.get()))
        .save(this.output, "star_metal_ingot_from_smelting");

        SimpleCookingRecipeBuilder.blasting(
            Ingredient.of(MetalRegistry.STARMETAL_ALLOY.get()),
            RecipeCategory.MISC, 
            MetalRegistry.STARMETAL_INGOT.get(),
            1.0f,
            200
        )
        .unlockedBy("has_star_metal_alloy", has(MetalRegistry.STARMETAL_ALLOY.get()))
        .save(this.output, "star_metal_ingot_from_blasting");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STARMETAL_INGOT.get(), 9)
            .requires(MetalRegistry.STARMETAL_BLOCK_ITEM.get())
            .unlockedBy("has_star_metal_block", has(MetalRegistry.STARMETAL_BLOCK_ITEM.get()))
            .save(this.output, "star_metal_ingot_from_star_metal_block");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STARMETAL_INGOT.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', MetalRegistry.STARMETAL_NUGGET.get())
            .unlockedBy("has_star_metal_nugget", has(MetalRegistry.STARMETAL_NUGGET.get()))
            .save(this.output, "star_metal_ingot_from_star_metal_nugget");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STARMETAL_BLOCK_ITEM.get())
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', MetalRegistry.STARMETAL_INGOT.get())
            .unlockedBy("has_star_metal_ingot", has(MetalRegistry.STARMETAL_INGOT.get()))
            .save(this.output, "star_metal_block_from_steel_ingot");


        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STARMETAL_NUGGET.get(), 9)
            .requires(MetalRegistry.STARMETAL_INGOT.get())
            .unlockedBy("has_star_metal_ingot", has(MetalRegistry.STARMETAL_INGOT.get()))
            .save(this.output, "star_metal_nugget_from_steel_ingot");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STARMETAL_SLAB_ITEM.get(), 6)
            .pattern("###")
            .define('#', MetalRegistry.STARMETAL_BLOCK_ITEM.get())
            .unlockedBy("has_starmetal_block", has(MetalRegistry.STARMETAL_BLOCK_ITEM.get()))
            .save(this.output, "starmetal_slab_by_crafting");
        
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MetalRegistry.STARMETAL_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STARMETAL_SLAB_ITEM.get(), 2)
            .unlockedBy("has_starmetal_block", has(MetalRegistry.STARMETAL_BLOCK_ITEM.get()))
            .save(this.output, "starmetal_slab_by_stonecutting");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STARMETAL_STAIRS_ITEM.get(), 4)
            .pattern("#  ")
            .pattern("## ")
            .pattern("###")
            .define('#', MetalRegistry.STARMETAL_BLOCK_ITEM.get())
            .unlockedBy("has_starmetal_block", has(MetalRegistry.STARMETAL_BLOCK_ITEM.get()))
            .save(this.output, "starmetal_stairs_by_crafting");
        
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MetalRegistry.STARMETAL_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STARMETAL_STAIRS_ITEM.get())
            .unlockedBy("has_starmetal_block", has(MetalRegistry.STARMETAL_BLOCK_ITEM.get()))
            .save(this.output, "starmetal_stairs_by_stonecutting");


        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, MetalRegistry.STARMETAL_BUTTON_ITEM.get())
            .requires(MetalRegistry.STARMETAL_BLOCK_ITEM.get())
            .unlockedBy("has_starmetal_block", has(MetalRegistry.STARMETAL_BLOCK_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STARMETAL_BARS_BLOCK_ITEM.get(), 4)
            .pattern("###")
            .pattern("# #")
            .pattern("###")
            .define('#', MetalRegistry.STARMETAL_BARS_ITEM.get())
            .unlockedBy("has_starmetal_bars", has(MetalRegistry.STARMETAL_BARS_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STARMETAL_BARS_ITEM.get(), 16)
            .pattern("###")
            .pattern("###")
            .define('#', MetalRegistry.STARMETAL_INGOT.get())
            .unlockedBy("has_starmetal_ingot", has(MetalRegistry.STARMETAL_INGOT.get()))
            .save(this.output);



        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STARMETAL_LAMP_ITEM.get())
            .requires(MetalRegistry.STARMETAL_BARS_BLOCK_ITEM.get())
            .requires(Items.GLOWSTONE)
            .unlockedBy("has_starmetal_bars_block", has(MetalRegistry.STARMETAL_BARS_BLOCK_ITEM.get()))
            .unlockedBy("has_glowstone", has(Items.GLOWSTONE))
            .save(this.output);



        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MetalRegistry.STARMETAL_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.STARMETAL_PILLAR_ITEM.get())
            .unlockedBy("has_starmetal_block", has(MetalRegistry.STARMETAL_BLOCK_ITEM.get()))
            .save(this.output);



        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STARMETAL_TABLE_ITEM.get(), 2)
            .pattern("###")
            .pattern("# #")
            .define('#', MetalRegistry.STARMETAL_INGOT.get())
            .unlockedBy("has_starmetal_ingot", has(MetalRegistry.STARMETAL_INGOT.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STARMETAL_CHAIR_ITEM.get(), 4)
            .pattern("  #")
            .pattern("###")
            .pattern("# #")
            .define('#', MetalRegistry.STARMETAL_INGOT.get())
            .unlockedBy("has_starmetal_ingot", has(MetalRegistry.STARMETAL_INGOT.get()))
            .save(this.output);



        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STARMETAL_SHELF_ITEM.get(), 4)
            .pattern("###")
            .pattern("$ $")
            .define('#', MetalRegistry.STARMETAL_INGOT.get())
            .define('$', MetalRegistry.STARMETAL_NUGGET.get())
            .unlockedBy("has_starmetal_ingot", has(MetalRegistry.STARMETAL_INGOT.get()))
            .unlockedBy("has_starmetal_nugget", has(MetalRegistry.STARMETAL_NUGGET.get()))
            .save(this.output);


        // ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STARMETAL_BED_ITEM.get())
        //     .pattern("###")
        //     .pattern("$$$")
        //     .pattern("% %")
        //     .define('#', Items.YELLOW_WOOL)
        //     .define('$', MetalRegistry.STARMETAL_SLAB_ITEM.get())
        //     .define('%', MetalRegistry.STARMETAL_INGOT.get())
        //     .unlockedBy("has_yellow_wool", has(Items.YELLOW_WOOL))
        //     .unlockedBy("has_starmetal_slab", has(MetalRegistry.STARMETAL_SLAB_ITEM.get()))
        //     .unlockedBy("has_starmetal_ingot", has(MetalRegistry.STARMETAL_INGOT.get()))
        //     .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, MetalRegistry.STARMETAL_TRAMPOLINE.get())
            .pattern("###")
            .pattern("$%$")
            .pattern("$ $")
            .define('#', MetalRegistry.STARMETAL_SLAB_ITEM.get())
            .define('$', MetalRegistry.STARMETAL_INGOT.get())
            .define('%', CraftingMaterialRegistry.ANTI_GRAV_INGOT.get())
            .unlockedBy("has_starmetal_slab", has(MetalRegistry.STARMETAL_SLAB_ITEM.get()))
            .unlockedBy("has_starmetal_ingot", has(MetalRegistry.STARMETAL_INGOT.get()))
            .unlockedBy("has_anti_grav_ingot", has(CraftingMaterialRegistry.ANTI_GRAV_INGOT.get()))
            .save(this.output);
    }


    protected void registerGlowBlockRecipes() {

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.RED_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.RED_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_red_stardust_powder", has(CraftingMaterialRegistry.RED_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.ORANGE_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.ORANGE_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_orange_stardust_powder", has(CraftingMaterialRegistry.ORANGE_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.YELLOW_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.YELLOW_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_yellow_stardust_powder", has(CraftingMaterialRegistry.YELLOW_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.LIME_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.LIME_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_lime_stardust_powder", has(CraftingMaterialRegistry.LIME_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.GREEN_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.GREEN_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_green_stardust_powder", has(CraftingMaterialRegistry.GREEN_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.CYAN_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.CYAN_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_cyan_stardust_powder", has(CraftingMaterialRegistry.CYAN_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.LIGHT_BLUE_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.LIGHT_BLUE_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_light_blue_stardust_powder", has(CraftingMaterialRegistry.LIGHT_BLUE_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.BLUE_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.BLUE_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_blue_stardust_powder", has(CraftingMaterialRegistry.BLUE_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.PURPLE_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.PURPLE_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_purple_stardust_powder", has(CraftingMaterialRegistry.PURPLE_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.MAGENTA_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.MAGENTA_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_magenta_stardust_powder", has(CraftingMaterialRegistry.MAGENTA_STARDUST_POWDER.get()))
            .save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.PINK_GLOW_BLOCK_ITEM.get(), 4)
            .requires(Items.REDSTONE_LAMP)
            .requires(Items.REDSTONE)
            .requires(CraftingMaterialRegistry.PINK_STARDUST_POWDER.get())
            .unlockedBy("has_redstone_lamp", has(Items.REDSTONE_LAMP))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_pink_stardust_powder", has(CraftingMaterialRegistry.PINK_STARDUST_POWDER.get()))
            .save(this.output);


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.GLOW_PANEL.get(), 4)
            .unlockedBy("has_glow_block", has(GlowBlockRegistry.GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.RED_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.RED_GLOW_PANEL.get(), 4)
            .unlockedBy("has_red_glow_block", has(GlowBlockRegistry.RED_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.ORANGE_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.ORANGE_GLOW_PANEL.get(), 4)
            .unlockedBy("has_orange_glow_block", has(GlowBlockRegistry.ORANGE_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.YELLOW_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.YELLOW_GLOW_PANEL.get(), 4)
            .unlockedBy("has_yellow_glow_block", has(GlowBlockRegistry.YELLOW_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.LIME_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.LIME_GLOW_PANEL.get(), 4)
            .unlockedBy("has_lime_glow_block", has(GlowBlockRegistry.LIME_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.GREEN_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.GREEN_GLOW_PANEL.get(), 4)
            .unlockedBy("has_green_glow_block", has(GlowBlockRegistry.GREEN_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.CYAN_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.CYAN_GLOW_PANEL.get(), 4)
            .unlockedBy("has_cyan_glow_block", has(GlowBlockRegistry.CYAN_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.LIGHT_BLUE_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.LIGHT_BLUE_GLOW_PANEL.get(), 4)
            .unlockedBy("has_light_blue_glow_block", has(GlowBlockRegistry.LIGHT_BLUE_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.BLUE_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.BLUE_GLOW_PANEL.get(), 4)
            .unlockedBy("has_blue_glow_block", has(GlowBlockRegistry.BLUE_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.PURPLE_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.PURPLE_GLOW_PANEL.get(), 4)
            .unlockedBy("has_purple_glow_block", has(GlowBlockRegistry.PURPLE_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.MAGENTA_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.MAGENTA_GLOW_PANEL.get(), 4)
            .unlockedBy("has_magenta_glow_block", has(GlowBlockRegistry.MAGENTA_GLOW_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlowBlockRegistry.PINK_GLOW_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, GlowBlockRegistry.PINK_GLOW_PANEL.get(), 4)
            .unlockedBy("has_pink_glow_block", has(GlowBlockRegistry.PINK_GLOW_BLOCK_ITEM.get()))
            .save(this.output);
    }
    protected void registerGlassBlockRecipes() {

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlassRegistry.HOLOGLASS_BLOCK_ITEM.get(), 6)
            .pattern("#$#")
            .pattern("#%#")
            .pattern("#$#")
            .define('#', Items.GLASS)
            .define('$', Items.REDSTONE)
            .define('%', CraftingMaterialRegistry.STARDUST_POWDER.get())
            .unlockedBy("has_glass", has(Items.GLASS))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, GlassRegistry.HOLOGLASS_PANE_ITEM.get(), 16)
            .pattern("###")
            .pattern("###")
            .define('#', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_hologlass_block_item", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);

    }
    protected void registerLabDecorRecipes() {
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get(), 8)
            .pattern("#$")
            .pattern("$#")
            .define('#', Items.QUARTZ_BLOCK)
            .define('$', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_quartz_block", has(Items.QUARTZ_BLOCK))
            .unlockedBy("has_hologlass_block", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOTILES_SLAB_ITEM.get(), 6)
            .pattern("###")
            .define('#', LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get())
            .unlockedBy("has_holotiles_block_item", has(LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get()))
            .save(this.output, "holotiles_slab_by_crafting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOTILES_SLAB_ITEM.get(), 2)
            .unlockedBy("has_holotiles_block_item", has(LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get()))
            .save(this.output, "holotiles_slab_by_stonecutting");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOTILES_STAIRS_ITEM.get(), 4)
            .pattern("#  ")
            .pattern("## ")
            .pattern("###")
            .define('#', LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get())
            .unlockedBy("has_holotiles_block_item", has(LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get()))
            .save(this.output, "holotiles_stairs_by_crafting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOTILES_STAIRS_ITEM.get())
            .unlockedBy("has_holotiles_block_item", has(LaboratoryDecorRegistry.HOLOTILES_BLOCK_ITEM.get()))
            .save(this.output, "holotiles_stairs_by_stonecutting");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOWALLPAPER_ITEM.get(), 8)
            .pattern("$#")
            .pattern("$#")
            .define('#', Items.QUARTZ_BLOCK)
            .define('$', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_quartz_block", has(Items.QUARTZ_BLOCK))
            .unlockedBy("has_hologlass_block", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get(), 8)
            .pattern("##")
            .pattern("$$")
            .define('#', Items.QUARTZ_BLOCK)
            .define('$', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_quartz_block", has(Items.QUARTZ_BLOCK))
            .unlockedBy("has_hologlass_block", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOBRICKS_SLAB_ITEM.get(), 6)
            .pattern("###")
            .define('#', LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get())
            .unlockedBy("has_holobricks_item", has(LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get()))
            .save(this.output, "holobricks_slab_by_crafting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOBRICKS_SLAB_ITEM.get(), 2)
            .unlockedBy("has_holobricks_item", has(LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get()))
            .save(this.output, "holobricks_slab_by_stonecutting");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOBRICKS_STAIRS_ITEM.get(), 4)
            .pattern("#  ")
            .pattern("## ")
            .pattern("###")
            .define('#', LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get())
            .unlockedBy("has_holobricks_item", has(LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get()))
            .save(this.output, "holobricks_stairs_by_crafting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOBRICKS_STAIRS_ITEM.get())
            .unlockedBy("has_holobricks_item", has(LaboratoryDecorRegistry.HOLOBRICKS_ITEM.get()))
            .save(this.output, "holobricks_stairs_by_stonecutting");


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOCEILING_ITEM.get(), 8)
            .pattern("$#")
            .pattern("#$")
            .define('#', Items.QUARTZ_BLOCK)
            .define('$', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_quartz_block", has(Items.QUARTZ_BLOCK))
            .unlockedBy("has_hologlass_block", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.WHITE_SLIDING_DOOR_ITEM.get(), 3)
            .pattern("##")
            .pattern("$$")
            .pattern("##")
            .define('#', PlasticRegistry.WHITE_PLASTIC_BLOCK_ITEM.get())
            .define('$', GlassRegistry.HOLOGLASS_BLOCK_ITEM)
            .unlockedBy("has_white_plastic_block", has(PlasticRegistry.WHITE_PLASTIC_BLOCK_ITEM.get()))
            .unlockedBy("has_white_hologlass_block", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, LaboratoryDecorRegistry.HOLOTABLE_ITEM.get(), 2)
            .pattern("#$#")
            .pattern("# #")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_hologlass", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, LaboratoryDecorRegistry.HOLOCHAIR_ITEM.get(), 4)
            .pattern("  #")
            .pattern("#$#")
            .pattern("# #")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_hologlass", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, LaboratoryDecorRegistry.HOLOBARREL_ITEM.get(), 2)
            .pattern("#$#")
            .pattern("#%#")
            .pattern("#$#")
            .define('#', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .define('$', GlassRegistry.HOLOGLASS_PANE_ITEM.get())
            .define('%', Items.REDSTONE)
            .unlockedBy("has_hologlass", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .unlockedBy("has_hologlass_pane", has(GlassRegistry.HOLOGLASS_PANE_ITEM.get()))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, LaboratoryDecorRegistry.HOLOSHELF_ITEM.get(), 4)
            .pattern("###")
            .pattern("$ $")
            .define('#', GlassRegistry.HOLOGLASS_PANE_ITEM.get())
            .define('$', MetalRegistry.STEEL_NUGGET.get())
            .unlockedBy("has_hologlass_pane", has(GlassRegistry.HOLOGLASS_PANE_ITEM.get()))
            .unlockedBy("has_steel_nugget", has(MetalRegistry.STEEL_NUGGET.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, LaboratoryDecorRegistry.HOLOTV_ITEM.get())
            .pattern("#$%")
            .pattern("$&$")
            .pattern("%$#")
            .define('#', CraftingMaterialRegistry.STARDUST_POWDER.get())
            .define('$', MetalRegistry.STEEL_NUGGET.get())
            .define('%', Items.GOLD_NUGGET)
            .define('&', Items.REDSTONE_BLOCK)
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .unlockedBy("has_steel_nugget", has(MetalRegistry.STEEL_NUGGET.get()))
            .unlockedBy("has_gold_nugget", has(Items.GOLD_NUGGET))
            .unlockedBy("has_redstone_block", has(Items.REDSTONE_BLOCK))
            .save(this.output);


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOCRAFTINGTABLE_ITEM.get())
            .unlockedBy("has_hologlass_block", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, LaboratoryDecorRegistry.HOLOLIGHT_ITEM.get(), 4)
            .pattern("#$#")
            .pattern(" % ")
            .define('#', MetalRegistry.STEEL_NUGGET.get())
            .define('$', Items.REDSTONE)
            .define('%', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_steel_nugget", has(MetalRegistry.STEEL_NUGGET.get()))
            .unlockedBy("has_redstone", has(Items.REDSTONE))
            .unlockedBy("has_hologlass", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, LaboratoryDecorRegistry.HOLO_DESK_LAMP_ITEM.get())
            .pattern("#")
            .pattern("$")
            .define('#', LaboratoryDecorRegistry.HOLOLIGHT_ITEM.get())
            .define('$', MetalRegistry.STEEL_BLOCK_ITEM.get())
            .unlockedBy("has_hololight", has(LaboratoryDecorRegistry.HOLOLIGHT_ITEM.get()))
            .unlockedBy("has_steel_block", has(MetalRegistry.STEEL_BLOCK_ITEM.get()))
            .save(this.output);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOBEAKER_ITEM.get())
            .unlockedBy("has_holobeaker_item", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, LaboratoryDecorRegistry.HOLOCUTTER_ITEM.get())
            .pattern(" #$")
            .pattern(" $$")
            .define('$', MetalRegistry.STEEL_INGOT.get())
            .define('#', GlassRegistry.HOLOGLASS_BLOCK_ITEM.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_hologlass", has(GlassRegistry.HOLOGLASS_BLOCK_ITEM.get()))
            .save(this.output);
    }
    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(@javax.annotation.Nonnull HolderLookup.Provider registries, @javax.annotation.Nonnull RecipeOutput output) {
            return new RecipeDatagen(registries, output);
        }

        @Override
        @javax.annotation.Nonnull
        public String getName() {
            return "SpooktasticDecor Recipes";
        }
    }
}
