package page.embys.datagen_common;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.flag.FeatureFlagSet;
import page.embys.EmbyTweaks;
import page.embys.EmbyTweaksClient;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;

import java.util.concurrent.CompletableFuture;

public abstract class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void generateBlockSetRecipes(BlockSet blockSet, RecipeOutput exporter, net.minecraft.data.recipes.RecipeProvider recipeGenerator) {
        if (blockSet instanceof WoodBlockSet woodBlockSet) {
            recipeGenerator.generateRecipes(EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet), FeatureFlagSet.of(FeatureFlags.VANILLA));
        } else if (blockSet instanceof StoneBlockSet stoneBlockSet) {
//            EmbyTweaks.LOGGER.info("creating recipes for '" + blockSet.getIdentifier() + "'");
            recipeGenerator.generateRecipes(EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet), FeatureFlagSet.of(FeatureFlags.VANILLA));
        }
    }

    public String getName() {
        return this.getClass().getName();
    }
}
