package page.embys.lodestone_compass_clone;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialCraftingRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public class CompassCloneRecipe extends SpecialCraftingRecipe {

    public CompassCloneRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        if (input.getStackCount() != 3) {
            return false;
        }
        boolean lodestoneCompassFound = false;
        boolean amethystShardFound = false;
        int compassCount = 0;
        for (int i = 0; i < input.size(); ++i) {
            ItemStack itemStack = input.getStackInSlot(i);
            if (itemStack.isEmpty()) continue;
            if (itemStack.isOf(Items.COMPASS)) {
                if (compassCount > 2) {
                    return false;
                }
                compassCount += 1;
                continue;
            }
            if (itemStack.isOf(Items.AMETHYST_SHARD)) {
                if (amethystShardFound) {
                    return false;
                }
                amethystShardFound = true;
                continue;
            }
            if (itemStack.contains(DataComponentTypes.LODESTONE_TRACKER)) {
                if (lodestoneCompassFound) {
                    return false;
                }
                lodestoneCompassFound = true;
                continue;
            }
            return false;
        }
        return compassCount == 2 && amethystShardFound;
    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        ItemStack itemStack = ItemStack.EMPTY;
        boolean amethystShardFound = false;
        int compassCount = 0;
        for (int i = 0; i < input.size(); ++i) {
            ItemStack inputSlotItem = input.getStackInSlot(i);
            if (inputSlotItem.contains(DataComponentTypes.LODESTONE_TRACKER)) {
                if (!itemStack.isEmpty()) {
                    return ItemStack.EMPTY;
                }
                itemStack = inputSlotItem;
                continue;
            }
            if (inputSlotItem.isOf(Items.COMPASS)) {
                if (compassCount > 2) {
                    return ItemStack.EMPTY;
                }
                compassCount += 1;
                continue;
            }
            if (inputSlotItem.isOf(Items.AMETHYST_SHARD)) {
                if (amethystShardFound) {
                    return ItemStack.EMPTY;
                }
                amethystShardFound = true;
            }
        }
        if (amethystShardFound) {
            return itemStack.copyWithCount(2);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<? extends SpecialCraftingRecipe> getSerializer() {
        return new SpecialRecipeSerializer<>(CompassCloneRecipe::new);
    }
}
