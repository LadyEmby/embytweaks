package page.embys.common;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.item.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import org.apache.commons.lang3.function.TriFunction;
import page.embys.EmbyTweaks;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModItemHelper {
    public static BlockItem registerBlockItem(Identifier identifier, Block block, ResourceKey<CreativeModeTab> itemGroup) {
        return registerBlockItem(identifier, block, itemGroup, BlockItem::new, null);
    }

    public static BlockItem registerBlockItem(Identifier identifier, Block block, ResourceKey<CreativeModeTab> itemGroup, BiFunction<Block, Item.Properties, BlockItem> factory, Item itemPlacement) {
        ResourceKey<Item> itemIdentifierKey = ResourceKey.create(Registries.ITEM, identifier);
        BlockItem blockItem = factory.apply(block, new Item.Properties().useBlockDescriptionPrefix().setId(itemIdentifierKey));
        Registry.register(BuiltInRegistries.ITEM, identifier, blockItem);
        if (itemPlacement != null) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.addAfter(itemPlacement, blockItem));
        } else {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.accept(blockItem));
        }
        return blockItem;
    }

    public static Supplier<Item> registerBoatItem(String name, Function<Item.Properties, Item> item, Item.Properties settings, ResourceKey<CreativeModeTab> itemGroup, Item itemPlacement) {
        ResourceKey<Item> itemRegistryKey = ResourceKey.create(Registries.ITEM, EmbyTweaks.id(name));

        return EmbyTweaks.register(BuiltInRegistries.ITEM, name, () -> {
            Item item1 = item.apply(settings.stacksTo(1).setId(itemRegistryKey));
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.addAfter(itemPlacement, item1));
            return item1;
        });
    }

    public static StandingAndWallBlockItem registerVerticallyAttachableBlockItem(Identifier identifier, Block standingBlock, Block wallBlock, Item.Properties settings, ResourceKey<CreativeModeTab> itemGroup, Item itemPlacement, TriFunction<Block, Block, Item.Properties, StandingAndWallBlockItem> factory) {
        ResourceKey<Item> itemRegistryKey = ResourceKey.create(Registries.ITEM, identifier);
        settings.setId(itemRegistryKey).stacksTo(16);
        StandingAndWallBlockItem blockItem = factory.apply(standingBlock, wallBlock, settings);
        Registry.register(BuiltInRegistries.ITEM, identifier, blockItem);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.addAfter(itemPlacement, blockItem));
        return blockItem;
    }
}
