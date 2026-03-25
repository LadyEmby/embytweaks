package page.embys.kiln;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.SearchRecipeBookCategory;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import page.embys.EmbyTweaks;

import java.util.List;

@Environment(EnvType.CLIENT)
public class KilnScreen extends AbstractFurnaceScreen<KilnScreenHandler> {
    private static final Identifier LIT_PROGRESS_TEXTURE = Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "container/kiln/lit_progress");
    private static final Identifier BURN_PROGRESS_TEXTURE = Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "container/kiln/burn_progress");
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "textures/gui/container/kiln.png");
    private static final Component TOGGLE_SMELTABLE_TEXT = Component.translatable("gui.recipebook.toggleRecipes.smeltable");
    private static final List<RecipeBookComponent.TabInfo> TABS = List.of(new RecipeBookComponent.TabInfo(SearchRecipeBookCategory.FURNACE), new RecipeBookComponent.TabInfo(Items.COBBLESTONE, RecipeBookCategories.FURNACE_BLOCKS));

    public KilnScreen(KilnScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title, TOGGLE_SMELTABLE_TEXT, TEXTURE, LIT_PROGRESS_TEXTURE, BURN_PROGRESS_TEXTURE, TABS);
    }

}
