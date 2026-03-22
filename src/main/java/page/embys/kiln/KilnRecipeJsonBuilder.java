package page.embys.kiln;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.component.ComponentType;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import page.embys.EmbyTweaks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class KilnRecipeJsonBuilder implements CraftingRecipeJsonBuilder {
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();
    private String group;
    private final Ingredient ingredient;
    private final Item output;
    private final RecipeCategory category;
    private final CookingRecipeCategory cookingCategory;
    private final float experience;
    private final int cookingTime;
    private final AbstractCookingRecipe.RecipeFactory<?> recipeFactory = KilnRecipe::new;

    private KilnRecipeJsonBuilder(
            RecipeCategory category,
            CookingRecipeCategory cookingCategory,
            ItemConvertible output,
            Ingredient input,
            float experience,
            int cookingTime
    ) {
        this.category = category;
        this.cookingCategory = cookingCategory;
        this.output = output.asItem();
        this.ingredient = input;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public static <T extends AbstractCookingRecipe> KilnRecipeJsonBuilder create(
            Ingredient input,
            RecipeCategory category,
            ItemConvertible output,
            float experience,
            int cookingTime
    ) {
        return new KilnRecipeJsonBuilder(category, getCookingCategory(output), output, input, experience, cookingTime);
    }

    public static CookingRecipeCategory getCookingCategory(ItemConvertible output) {
        if (getCategory(output) == RecipeCategory.BUILDING_BLOCKS) {
            return CookingRecipeCategory.BLOCKS;
        } else {
            return CookingRecipeCategory.MISC;
        }
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return this.output;
    }

    public static RecipeCategory getCategory(ItemConvertible output) {
        if (output instanceof BlockItem) {
            return RecipeCategory.BUILDING_BLOCKS;
        } else {
            return RecipeCategory.MISC;
        }
    }

    @Override
    public void offerTo(RecipeExporter exporter, RegistryKey<Recipe<?>> recipeKey) {
        this.validate(recipeKey);
        Advancement.Builder builder = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeKey))
                .rewards(AdvancementRewards.Builder.recipe(recipeKey))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criteria.forEach(builder::criterion);
        System.out.println(this.group);
        exporter.accept(recipeKey, this.recipeFactory.create(Objects.requireNonNullElse(this.group, ""), this.cookingCategory, this.ingredient, new ItemStack(this.output), this.experience, this.cookingTime), builder.build(recipeKey.getValue().withPrefixedPath("recipes/" + this.category.getName() + "/")));
    }

    @Override
    public void offerTo(RecipeExporter exporter) {
        System.out.println(RegistryKey.of(RegistryKeys.RECIPE, Registries.ITEM.getId(this.output)));
        this.offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(EmbyTweaks.MOD_ID, Registries.ITEM.getId(this.output).getPath() + "_from_kiln")));
    }

    public void validate(RegistryKey<Recipe<?>> recipeKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeKey.getValue());
        }
    }
}
