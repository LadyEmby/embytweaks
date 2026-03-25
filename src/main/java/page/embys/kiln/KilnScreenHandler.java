package page.embys.kiln;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;

public class KilnScreenHandler extends AbstractFurnaceMenu {
    public KilnScreenHandler(int i, Inventory playerInventory) {
        super(KilnMain.KILN_SCREEN_HANDLER, KilnMain.KILN_RECIPE_TYPE, RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, i, playerInventory);
    }

    public KilnScreenHandler(int i, Inventory playerInventory, Container inventory, ContainerData propertyDelegate) {
        super(KilnMain.KILN_SCREEN_HANDLER, KilnMain.KILN_RECIPE_TYPE, RecipePropertySet.FURNACE_INPUT, RecipeBookType.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}
