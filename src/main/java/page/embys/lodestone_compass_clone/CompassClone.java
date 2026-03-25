package page.embys.lodestone_compass_clone;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import page.embys.EmbyTweaks;

public class CompassClone {
	public static void initialize() {
		Registry.register(BuiltInRegistries.RECIPE_TYPE, Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "compass_clone"), new RecipeType<CompassCloneRecipe>() {
			@Override
			public String toString() {
				return "compass_clone";
			}
		});
		Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "compass_clone"), new CustomRecipe.Serializer<>(CompassCloneRecipe::new));
		System.out.println("compass_clone was loaded");
	}
}