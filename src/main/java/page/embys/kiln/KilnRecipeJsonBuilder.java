package page.embys.kiln;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.Nullable;
import page.embys.EmbyTweaks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class KilnRecipeJsonBuilder implements RecipeBuilder {
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    private String group;
    private final Ingredient ingredient;
    private final Item output;
    private final RecipeCategory category;
    private final CookingBookCategory cookingCategory;
    private final float experience;
    private final int cookingTime;
    private final AbstractCookingRecipe.Factory<?> recipeFactory = KilnRecipe::new;

    private KilnRecipeJsonBuilder(
            RecipeCategory category,
            CookingBookCategory cookingCategory,
            ItemLike output,
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
            ItemLike output,
            float experience,
            int cookingTime
    ) {
        return new KilnRecipeJsonBuilder(category, getCookingCategory(output), output, input, experience, cookingTime);
    }

    public static CookingBookCategory getCookingCategory(ItemLike output) {
        if (getCategory(output) == RecipeCategory.BUILDING_BLOCKS) {
            return CookingBookCategory.BLOCKS;
        } else {
            return CookingBookCategory.MISC;
        }
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getResult() {
        return this.output;
    }

    public static RecipeCategory getCategory(ItemLike output) {
        if (output instanceof BlockItem) {
            return RecipeCategory.BUILDING_BLOCKS;
        } else {
            return RecipeCategory.MISC;
        }
    }

    @Override
    public void save(RecipeOutput exporter, ResourceKey<Recipe<?>> recipeKey) {
        this.validate(recipeKey);
        Advancement.Builder builder = exporter.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeKey))
                .rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(recipeKey))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        System.out.println(this.group);
        exporter.accept(recipeKey, this.recipeFactory.create(Objects.requireNonNullElse(this.group, ""), this.cookingCategory, this.ingredient, new ItemStack(this.output), this.experience, this.cookingTime), builder.build(recipeKey.identifier().withPrefix("recipes/" + this.category.getFolderName() + "/")));
    }

    @Override
    public void save(RecipeOutput exporter) {
        System.out.println(ResourceKey.create(Registries.RECIPE, BuiltInRegistries.ITEM.getKey(this.output)));
        this.save(exporter, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, BuiltInRegistries.ITEM.getKey(this.output).getPath() + "_from_kiln")));
    }

    public void validate(ResourceKey<Recipe<?>> recipeKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeKey.identifier());
        }
    }
}
