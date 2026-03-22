package page.embys.datagen_common;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import page.embys.EmbyTweaks;
import page.embys.EmbyTweaksClient;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;

import java.util.concurrent.CompletableFuture;

public abstract class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void generateBlockSetRecipes(BlockSet blockSet, RecipeExporter exporter, RecipeGenerator recipeGenerator) {
        if (blockSet instanceof WoodBlockSet woodBlockSet) {
            recipeGenerator.generateFamily(EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet), FeatureSet.of(FeatureFlags.VANILLA));
        } else if (blockSet instanceof StoneBlockSet stoneBlockSet) {
//            EmbyTweaks.LOGGER.info("creating recipes for '" + blockSet.getIdentifier() + "'");
            recipeGenerator.generateFamily(EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet), FeatureSet.of(FeatureFlags.VANILLA));
        }
    }

    public String getName() {
        return this.getClass().getName();
    }
}
