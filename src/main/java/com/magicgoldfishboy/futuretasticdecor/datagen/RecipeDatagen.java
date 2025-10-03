package com.magicgoldfishboy.futuretasticdecor.datagen;

import java.rmi.registry.Registry;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.magicgoldfishboy.futuretasticdecor.registry.CraftingMaterialRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.GlowBlockRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.MetalRegistry;

import net.minecraft.WorldVersion.Simple;
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
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.neoforged.neoforge.common.Tags;

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
        registerMetalRecipes();
        registerGlowBlockRecipes();
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
    }
    protected void registerMetalRecipes() {

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



        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, MetalRegistry.GLOWING_STEEL_BLOCK.get())
            .pattern("###")
            .pattern("#$#")
            .pattern("###")
            .define('#', MetalRegistry.STEEL_INGOT.get())
            .define('$', CraftingMaterialRegistry.STARDUST_POWDER.get())
            .unlockedBy("has_steel_ingot", has(MetalRegistry.STEEL_INGOT.get()))
            .unlockedBy("has_stardust_powder", has(CraftingMaterialRegistry.STARDUST_POWDER.get()))
            .save(this.output, "glowing_steel_block_from_steel_block_and_glowstone");

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
