package page.embys.kiln;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import page.embys.datagen_common.RecipeProvider;

import java.util.AbstractMap;
import java.util.List;
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

    public KilnRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                createShaped(RecipeCategory.MISC, KilnMain.KILN_ITEM.asItem(), 1)
                        .pattern(" B ")
                        .pattern("BFB")
                        .pattern(" B ")
                        .input('B', Items.BRICK)
                        .input('F', Items.FURNACE)
                        .criterion(hasItem(Items.BRICKS), conditionsFromItem(Items.BRICKS))
                        .criterion(hasItem(Items.FURNACE), conditionsFromItem(Items.FURNACE))
                        .offerTo(exporter, "kiln_crafting");

                for (Item key : itemMap.keySet()) {
                    KilnRecipeJsonBuilder.create(Ingredient.ofItem(key), KilnRecipeJsonBuilder.getCategory(itemMap.get(key)), itemMap.get(key), 0.1f, 100)
                            .criterion(hasItem(key), conditionsFromItem(key))
                            .offerTo(exporter);
                }

                for (TagKey<Item> key : tagMap.keySet()) {
                    KilnRecipeJsonBuilder.create(Ingredient.ofTag(itemLookup.getOrThrow(key)), KilnRecipeJsonBuilder.getCategory(tagMap.get(key)), tagMap.get(key), 0.1f, 100)
                            .criterion("has_logs", conditionsFromTag(key))
                            .offerTo(exporter);
                }
            }
        };
    }

    @Override
    public String getName() {
        return "KilnRecipeProvider";
    }
}
