package page.embys.kiln;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import org.jspecify.annotations.NonNull;

import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class KilnRecipeProvider extends FabricRecipeProvider {
    Map<Item, Item> itemMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(Items.BLACK_TERRACOTTA, Items.BLACK_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.BLUE_TERRACOTTA, Items.BLUE_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.CLAY_BALL, Items.BRICK),
            new AbstractMap.SimpleEntry<>(Items.BROWN_TERRACOTTA, Items.BROWN_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.DEEPSLATE_BRICKS, Items.CRACKED_DEEPSLATE_BRICKS),
            new AbstractMap.SimpleEntry<>(Items.DEEPSLATE_TILES, Items.CRACKED_DEEPSLATE_TILES),
            new AbstractMap.SimpleEntry<>(Items.NETHER_BRICKS, Items.CRACKED_NETHER_BRICKS),
            new AbstractMap.SimpleEntry<>(Items.POLISHED_BLACKSTONE_BRICKS, Items.CRACKED_POLISHED_BLACKSTONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Items.STONE_BRICKS, Items.CRACKED_STONE_BRICKS),
            new AbstractMap.SimpleEntry<>(Items.CYAN_TERRACOTTA, Items.CYAN_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.COBBLED_DEEPSLATE, Items.DEEPSLATE),
            new AbstractMap.SimpleEntry<>(Items.GRAY_TERRACOTTA, Items.GRAY_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.GREEN_TERRACOTTA, Items.GREEN_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.LIGHT_BLUE_TERRACOTTA, Items.LIGHT_BLUE_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.LIGHT_GRAY_TERRACOTTA, Items.LIGHT_GRAY_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.LIME_TERRACOTTA, Items.LIME_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.MAGENTA_TERRACOTTA, Items.MAGENTA_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.NETHERRACK, Items.NETHER_BRICK),
            new AbstractMap.SimpleEntry<>(Items.ORANGE_TERRACOTTA, Items.ORANGE_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.PINK_TERRACOTTA, Items.PINK_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.PURPLE_TERRACOTTA, Items.PURPLE_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.RED_TERRACOTTA, Items.RED_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.BASALT, Items.SMOOTH_BASALT),
            new AbstractMap.SimpleEntry<>(Items.QUARTZ_BLOCK, Items.SMOOTH_QUARTZ),
            new AbstractMap.SimpleEntry<>(Items.RED_SANDSTONE, Items.SMOOTH_RED_SANDSTONE),
            new AbstractMap.SimpleEntry<>(Items.SANDSTONE, Items.SMOOTH_SANDSTONE),
            new AbstractMap.SimpleEntry<>(Items.STONE, Items.SMOOTH_STONE),
            new AbstractMap.SimpleEntry<>(Items.CLAY, Items.TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.WHITE_TERRACOTTA, Items.WHITE_GLAZED_TERRACOTTA),
            new AbstractMap.SimpleEntry<>(Items.YELLOW_TERRACOTTA, Items.YELLOW_GLAZED_TERRACOTTA)
            );

    Map<TagKey<Item>, Item> tagMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(ItemTags.LOGS, Items.CHARCOAL),
            new AbstractMap.SimpleEntry<>(ItemTags.SAND, Items.GLASS)
    );

    public KilnRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider registryLookup, @NonNull RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                shaped(RecipeCategory.MISC, KilnMain.KILN_ITEM.asItem(), 1)
                        .pattern(" B ")
                        .pattern("BFB")
                        .pattern(" B ")
                        .define('B', Items.BRICK)
                        .define('F', Items.FURNACE)
                        .unlockedBy(getHasName(Items.BRICKS), has(Items.BRICKS))
                        .unlockedBy(getHasName(Items.FURNACE), has(Items.FURNACE))
                        .save(output, "kiln_crafting");

                for (Item key : itemMap.keySet()) {
                    KilnRecipeJsonBuilder.create(Ingredient.of(key), KilnRecipeJsonBuilder.getCategory(itemMap.get(key)), itemMap.get(key), 0.1f, 100)
                            .unlockedBy(getHasName(key), has(key))
                            .save(output);
                }

                for (TagKey<Item> key : tagMap.keySet()) {
                    KilnRecipeJsonBuilder.create(Ingredient.of(itemLookup.getOrThrow(key)), KilnRecipeJsonBuilder.getCategory(tagMap.get(key)), tagMap.get(key), 0.1f, 100)
                            .unlockedBy("has_logs", has(key))
                            .save(output);
                }
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "KilnRecipeProvider";
    }
}
