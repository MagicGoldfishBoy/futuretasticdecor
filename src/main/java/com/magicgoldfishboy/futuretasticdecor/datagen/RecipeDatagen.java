package com.magicgoldfishboy.futuretasticdecor.datagen;

import java.rmi.registry.Registry;
import java.util.concurrent.CompletableFuture;

import com.magicgoldfishboy.futuretasticdecor.registry.CraftingMaterialRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.MetalRegistry;

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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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
    }

    protected void registerMetalRecipes() {
        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MetalRegistry.STEEL_ALLOY.get(), 2)
            .requires(CraftingMaterialRegistry.COKE.get())
            .requires(Items.RAW_IRON)
            .unlockedBy("has_coke", has(CraftingMaterialRegistry.COKE.get()))
            .unlockedBy("has_raw_iron", has(Items.RAW_IRON))
            .save(this.output, "steel_alloy_from_coke_and_iron_ingot");
    
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
