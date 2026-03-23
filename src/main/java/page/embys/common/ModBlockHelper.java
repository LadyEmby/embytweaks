package page.embys.common;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.TallBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import page.embys.EmbyTweaks;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlockHelper {
    public static Block registerBlock(Identifier identifier, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> blockIdentifierKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        blockSettings.registryKey(blockIdentifierKey);
        Block block = factory.apply(blockSettings);
        Registry.register(Registries.BLOCK, identifier, block);
        return block;
    }

    public static DoorBlock registerDoorBlock(Identifier identifier, BlockSetType blockSetType, AbstractBlock.Settings settings) {
        return (DoorBlock) registerTypeSetBlock(identifier, blockSetType, settings, DoorBlock::new);
    }

    public static TrapdoorBlock registerTrapdoorBlock(Identifier identifier, BlockSetType blockSetType, AbstractBlock.Settings settings) {
        return (TrapdoorBlock) registerTypeSetBlock(identifier, blockSetType, settings, TrapdoorBlock::new);
    }

    public static Block registerWoodTypeBlock(Identifier identifier, WoodType woodType, AbstractBlock.Settings settings, BiFunction<WoodType, AbstractBlock.Settings, Block> factory) {
        RegistryKey<Block> blockRegistryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        settings.registryKey(blockRegistryKey);
        Block block = factory.apply(woodType, settings);
        Registry.register(Registries.BLOCK, identifier, block);
        return block;
    }

    public static Block registerTypeSetBlock(Identifier identifier, BlockSetType blockSetType, AbstractBlock.Settings settings, BiFunction<BlockSetType, AbstractBlock.Settings, Block> factory) {
        RegistryKey<Block> blockRegistryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        settings.registryKey(blockRegistryKey);
        Block block = factory.apply(blockSetType, settings);
        Registry.register(Registries.BLOCK, identifier, block);
        return block;
    }

    public static PressurePlateBlock registerPressurePlateBlock(Identifier identifier, BlockSetType blockSetType, AbstractBlock.Settings settings) {
        return (PressurePlateBlock) registerTypeSetBlock(identifier, blockSetType, settings, PressurePlateBlock::new);
    }

    public static ButtonBlock registerButtonBlock(Identifier identifier, BlockSetType blockSetType, int pressTicks, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockRegistryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        settings.registryKey(blockRegistryKey);
        ButtonBlock buttonBlock = new ButtonBlock(blockSetType, pressTicks, settings);
        Registry.register(Registries.BLOCK, identifier, buttonBlock);
        return buttonBlock;
    }

    public static StairsBlock registerStairsBlock(Identifier identifier, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockIdentifierKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        StairsBlock block = new StairsBlock(Blocks.OAK_STAIRS.getDefaultState(), settings.registryKey(blockIdentifierKey));
        Registry.register(Registries.BLOCK, identifier, block);
        return block;
    }

    public static FenceBlock registerFenceBlock(Identifier identifier, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockIdentifierKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        FenceBlock block = new FenceBlock(settings.registryKey(blockIdentifierKey));
        Registry.register(Registries.BLOCK, identifier, block);
        return block;
    }

    public static FenceGateBlock registerFenceGateBlock(Identifier identifier, WoodType woodType, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockIdentifierKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        settings.registryKey(blockIdentifierKey);
        FenceGateBlock block = new FenceGateBlock(woodType, settings);
        Registry.register(Registries.BLOCK, identifier, block);
        return block;
    }

    public static SlabBlock registerSlabBlock(Identifier identifier, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockIdentifierKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        SlabBlock block = new SlabBlock(settings.registryKey(blockIdentifierKey));
        Registry.register(Registries.BLOCK, identifier, block);
        return block;
    }

    private static boolean tagChecker(BlockState blockState, Collection<TagKey<Block>> tagKeys) {
        return tagChecker(blockState, tagKeys, false);
    }

    public static boolean tagChecker(BlockState blockState, Collection<TagKey<Block>> tagKeys, boolean anyMatchPasses) {
        boolean allTagsMatch = true;
        for (TagKey<Block> tagKey : tagKeys) {
            if (!blockState.isIn(tagKey)) {
                allTagsMatch = false;
            } else if (anyMatchPasses) {
                return true;
            }
        }
        return allTagsMatch;
    }

    public static boolean blockIsInTagCollection(BlockState blockState, Collection<TagKey<Block>> tagKeyWhitelist) {
        return tagChecker(blockState, tagKeyWhitelist);
    }

    public static boolean blockIsInTagCollection(BlockState blockState, Collection<TagKey<Block>> tagKeyWhitelist, Collection<TagKey<Block>> tagKeyBlacklist) {
        boolean containsRequiredTags = tagChecker(blockState, tagKeyWhitelist);
        boolean missingBlockedTags = !tagChecker(blockState, tagKeyBlacklist, true);
        return (containsRequiredTags && missingBlockedTags);
    }
}
