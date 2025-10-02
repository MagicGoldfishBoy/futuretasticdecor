package com.magicgoldfishboy.futuretasticdecor.datagen;

import java.rmi.registry.Registry;
import java.util.concurrent.CompletableFuture;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.magicgoldfishboy.futuretasticdecor.registry.CraftingMaterialRegistry;
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
