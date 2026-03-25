package page.embys.lodestone_compass_clone;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CustomRecipe.Serializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.Level;

public class CompassCloneRecipe extends CustomRecipe {

    public CompassCloneRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingInput input, Level world) {
        if (input.ingredientCount() != 3) {
            return false;
        }
        boolean lodestoneCompassFound = false;
        boolean amethystShardFound = false;
        int compassCount = 0;
        for (int i = 0; i < input.size(); ++i) {
            ItemStack itemStack = input.getItem(i);
            if (itemStack.isEmpty()) continue;
            if (itemStack.is(Items.COMPASS)) {
                if (compassCount > 2) {
                    return false;
                }
                compassCount += 1;
                continue;
            }
            if (itemStack.is(Items.AMETHYST_SHARD)) {
                if (amethystShardFound) {
                    return false;
                }
                amethystShardFound = true;
                continue;
            }
            if (itemStack.has(DataComponents.LODESTONE_TRACKER)) {
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
    public ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        ItemStack itemStack = ItemStack.EMPTY;
        boolean amethystShardFound = false;
        int compassCount = 0;
        for (int i = 0; i < input.size(); ++i) {
            ItemStack inputSlotItem = input.getItem(i);
            if (inputSlotItem.has(DataComponents.LODESTONE_TRACKER)) {
                if (!itemStack.isEmpty()) {
                    return ItemStack.EMPTY;
                }
                itemStack = inputSlotItem;
                continue;
            }
            if (inputSlotItem.is(Items.COMPASS)) {
                if (compassCount > 2) {
                    return ItemStack.EMPTY;
                }
                compassCount += 1;
                continue;
            }
            if (inputSlotItem.is(Items.AMETHYST_SHARD)) {
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
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return new Serializer<>(CompassCloneRecipe::new);
    }
}
