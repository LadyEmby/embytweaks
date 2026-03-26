package page.embys.common;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlockHelper {
    public static Block registerBlock(Identifier identifier, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties blockSettings) {
        ResourceKey<Block> blockIdentifierKey = ResourceKey.create(Registries.BLOCK, identifier);
        blockSettings.setId(blockIdentifierKey);
        Block block = factory.apply(blockSettings);
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        return block;
    }

    public static DoorBlock registerDoorBlock(Identifier identifier, BlockSetType blockSetType, BlockBehaviour.Properties settings) {
        return (DoorBlock) registerTypeSetBlock(identifier, blockSetType, settings, DoorBlock::new);
    }

    public static TrapDoorBlock registerTrapdoorBlock(Identifier identifier, BlockSetType blockSetType, BlockBehaviour.Properties settings) {
        return (TrapDoorBlock) registerTypeSetBlock(identifier, blockSetType, settings, TrapDoorBlock::new);
    }

    public static Block registerWoodTypeBlock(Identifier identifier, WoodType woodType, BlockBehaviour.Properties settings, BiFunction<WoodType, BlockBehaviour.Properties, Block> factory) {
        ResourceKey<Block> blockRegistryKey = ResourceKey.create(Registries.BLOCK, identifier);
        settings.setId(blockRegistryKey);
        Block block = factory.apply(woodType, settings);
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        return block;
    }

    public static Block registerTypeSetBlock(Identifier identifier, BlockSetType blockSetType, BlockBehaviour.Properties settings, BiFunction<BlockSetType, BlockBehaviour.Properties, Block> factory) {
        ResourceKey<Block> blockRegistryKey = ResourceKey.create(Registries.BLOCK, identifier);
        settings.setId(blockRegistryKey);
        Block block = factory.apply(blockSetType, settings);
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        return block;
    }

    public static PressurePlateBlock registerPressurePlateBlock(Identifier identifier, BlockSetType blockSetType, BlockBehaviour.Properties settings) {
        return (PressurePlateBlock) registerTypeSetBlock(identifier, blockSetType, settings, PressurePlateBlock::new);
    }

    public static ButtonBlock registerButtonBlock(Identifier identifier, BlockSetType blockSetType, int pressTicks, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockRegistryKey = ResourceKey.create(Registries.BLOCK, identifier);
        settings.setId(blockRegistryKey);
        ButtonBlock buttonBlock = new ButtonBlock(blockSetType, pressTicks, settings);
        Registry.register(BuiltInRegistries.BLOCK, identifier, buttonBlock);
        return buttonBlock;
    }

    public static StairBlock registerStairsBlock(Identifier identifier, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockIdentifierKey = ResourceKey.create(Registries.BLOCK, identifier);
        StairBlock block = new StairBlock(Blocks.OAK_STAIRS.defaultBlockState(), settings.setId(blockIdentifierKey));
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        return block;
    }

    public static FenceBlock registerFenceBlock(Identifier identifier, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockIdentifierKey = ResourceKey.create(Registries.BLOCK, identifier);
        FenceBlock block = new FenceBlock(settings.setId(blockIdentifierKey));
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        return block;
    }

    public static FenceGateBlock registerFenceGateBlock(Identifier identifier, WoodType woodType, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockIdentifierKey = ResourceKey.create(Registries.BLOCK, identifier);
        settings.setId(blockIdentifierKey);
        FenceGateBlock block = new FenceGateBlock(woodType, settings);
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        return block;
    }

    public static SlabBlock registerSlabBlock(Identifier identifier, BlockBehaviour.Properties settings) {
        ResourceKey<Block> blockIdentifierKey = ResourceKey.create(Registries.BLOCK, identifier);
        SlabBlock block = new SlabBlock(settings.setId(blockIdentifierKey));
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        return block;
    }

    private static boolean tagChecker(BlockState blockState, Collection<TagKey<Block>> tagKeys) {
        return tagChecker(blockState, tagKeys, false);
    }

    public static boolean tagChecker(BlockState blockState, Collection<TagKey<Block>> tagKeys, boolean anyMatchPasses) {
        boolean allTagsMatch = true;
        for (TagKey<Block> tagKey : tagKeys) {
            if (!blockState.is(tagKey)) {
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
