package page.embys.common;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.function.TriFunction;
import page.embys.EmbyTweaks;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModItemHelper {
    public static BlockItem registerBlockItem(Identifier identifier, Block block, RegistryKey<ItemGroup> itemGroup) {
        return registerBlockItem(identifier, block, itemGroup, BlockItem::new, null);
    }

    public static BlockItem registerBlockItem(Identifier identifier, Block block, RegistryKey<ItemGroup> itemGroup, BiFunction<Block, Item.Settings, BlockItem> factory, Item itemPlacement) {
        RegistryKey<Item> itemIdentifierKey = RegistryKey.of(RegistryKeys.ITEM, identifier);
        BlockItem blockItem = factory.apply(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(itemIdentifierKey));
        Registry.register(Registries.ITEM, identifier, blockItem);
        if (itemPlacement != null) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.addAfter(itemPlacement, blockItem));
        } else {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(blockItem));
        }
        return blockItem;
    }

    public static Supplier<Item> registerBoatItem(String name, Function<Item.Settings, Item> item, Item.Settings settings, RegistryKey<ItemGroup> itemGroup, Item itemPlacement) {
        RegistryKey<Item> itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, EmbyTweaks.id(name));

        return EmbyTweaks.register(Registries.ITEM, name, () -> {
            Item item1 = item.apply(settings.maxCount(1).registryKey(itemRegistryKey));
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.addAfter(itemPlacement, item1));
            return item1;
        });
    }

    public static VerticallyAttachableBlockItem registerVerticallyAttachableBlockItem(Identifier identifier, Block standingBlock, Block wallBlock, Item.Settings settings, RegistryKey<ItemGroup> itemGroup, Item itemPlacement, TriFunction<Block, Block, Item.Settings, VerticallyAttachableBlockItem> factory) {
        RegistryKey<Item> itemRegistryKey = RegistryKey.of(RegistryKeys.ITEM, identifier);
        settings.registryKey(itemRegistryKey).maxCount(16);
        VerticallyAttachableBlockItem blockItem = factory.apply(standingBlock, wallBlock, settings);
        Registry.register(Registries.ITEM, identifier, blockItem);
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.addAfter(itemPlacement, blockItem));
        return blockItem;
    }
}
