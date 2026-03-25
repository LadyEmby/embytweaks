package page.embys.kiln;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;

public class KilnRecipe extends AbstractCookingRecipe {
    public KilnRecipe(String group, CookingBookCategory category, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(group, category, input, output, experience, cookTime);
    }

    @Override
    public RecipeSerializer<KilnRecipe> getSerializer() {
        return KilnMain.KILN_RECIPE_SERIALIZER;
    }

    @Override
    public RecipeType<KilnRecipe> getType() {
        return KilnMain.KILN_RECIPE_TYPE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return switch (this.category()) {
            case CookingBookCategory.BLOCKS -> RecipeBookCategories.FURNACE_BLOCKS;
            case CookingBookCategory.FOOD -> RecipeBookCategories.FURNACE_FOOD;
            case CookingBookCategory.MISC -> RecipeBookCategories.FURNACE_MISC;
        };
    }

    @Override
    protected Item furnaceIcon() {
        return KilnMain.KILN_ITEM;
    }
}
