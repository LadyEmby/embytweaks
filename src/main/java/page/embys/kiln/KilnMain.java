package page.embys.kiln;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.resources.Identifier;
import page.embys.EmbyTweaks;
import page.embys.common.ModItemHelper;

public class KilnMain {
    public static RecipeType<KilnRecipe> KILN_RECIPE_TYPE;
    public static Block KILN_BLOCK;
    public static Item KILN_ITEM;
    public static BlockEntityType<KilnBlockEntity> KILN_BLOCK_ENTITY;

    public static RecipeSerializer<KilnRecipe> KILN_RECIPE_SERIALIZER;

    public static MenuType<KilnScreenHandler> KILN_SCREEN_HANDLER;

    public static void init() {
        System.out.println("Hello! Let's do kiln stuff, shall we?");
        Identifier kilnIdentifier = Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "kiln");
        ResourceKey<Item> kilnItemIdentifierKey = ResourceKey.create(Registries.ITEM, kilnIdentifier);
        ResourceKey<Block> kilnBlockIdentifierKey = ResourceKey.create(Registries.BLOCK, kilnIdentifier);
        KILN_BLOCK = Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "kiln"), new KilnBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE).strength(3.5f).requiresCorrectToolForDrops().setId(kilnBlockIdentifierKey)));
        KILN_ITEM = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "kiln"), KILN_BLOCK, CreativeModeTabs.FUNCTIONAL_BLOCKS, BlockItem::new, Items.BLAST_FURNACE);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> entries.accept(KILN_ITEM));

        KILN_BLOCK_ENTITY = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "kiln"),
                FabricBlockEntityTypeBuilder.create(KilnBlockEntity::new, KILN_BLOCK).build());

        KILN_RECIPE_TYPE = Registry.register(BuiltInRegistries.RECIPE_TYPE, Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "kiln"), new RecipeType<KilnRecipe>() {
            @Override
            public String toString() {
                return "kiln";
            }
        });

        KILN_RECIPE_SERIALIZER = Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "kiln"), new AbstractCookingRecipe.Serializer<>(KilnRecipe::new, 100));
        KILN_SCREEN_HANDLER = new MenuType<>(KilnScreenHandler::new, FeatureFlagSet.of());
        Registry.register(BuiltInRegistries.MENU, Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "kiln"), KILN_SCREEN_HANDLER);
    }
}
