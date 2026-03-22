package page.embys.lodestone_compass_clone;

import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import page.embys.EmbyTweaks;

public class CompassClone {
	public static void initialize() {
		Registry.register(Registries.RECIPE_TYPE, Identifier.of(EmbyTweaks.MOD_ID, "compass_clone"), new RecipeType<CompassCloneRecipe>() {
			@Override
			public String toString() {
				return "compass_clone";
			}
		});
		Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(EmbyTweaks.MOD_ID, "compass_clone"), new SpecialCraftingRecipe.SpecialRecipeSerializer<>(CompassCloneRecipe::new));
		System.out.println("compass_clone was loaded");
	}
}