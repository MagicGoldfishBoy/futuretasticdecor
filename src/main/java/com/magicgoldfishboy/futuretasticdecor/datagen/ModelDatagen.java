package com.magicgoldfishboy.futuretasticdecor.datagen;

import com.magicgoldfishboy.futuretasticdecor.FuturetasticDecor;
import com.magicgoldfishboy.futuretasticdecor.registry.CraftingMaterialRegistry;
import com.magicgoldfishboy.futuretasticdecor.registry.MetalRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import javax.annotation.Nonnull;

public class ModelDatagen extends ModelProvider {
    public ModelDatagen(PackOutput output) {
        super(output, FuturetasticDecor.MODID);
    }

    @Override
    protected void registerModels(@Nonnull BlockModelGenerators blockModels, @Nonnull ItemModelGenerators itemModels) {
        registerMaterialModels(blockModels, itemModels);
        registerMetalModels(blockModels, itemModels);
    }

    protected void registerMaterialModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(CraftingMaterialRegistry.COKE.get(), ModelTemplates.FLAT_ITEM);
    }

    protected void registerMetalModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModels.createTrivialCube(MetalRegistry.STEEL_BLOCK.get());
    }
}
