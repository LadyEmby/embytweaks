package page.embys.common;

import net.minecraft.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import page.embys.EmbyTweaks;

public class StoneBlockSet extends BlockSet {
    private final Identifier identifier;

    public final Block block;
    public final BlockItem blockItem;

    public final StairBlock stairsBlock;
    public final BlockItem stairsBlockItem;

    public final WallBlock wallBlock;
    public final BlockItem wallBlockItem;

    public final SlabBlock slabBlock;
    public final BlockItem slabBlockItem;

    public StoneBlockSet(String name, Block block, BlockItem blockItem, StairBlock stairsBlock, BlockItem stairsBlockItem, SlabBlock slabBlock, BlockItem slabBlockItem, WallBlock wallBlock, BlockItem wallBlockItem) {
        this.identifier = Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name);
        this.block = block;
        this.stairsBlock = stairsBlock;
        this.wallBlock = wallBlock;
        this.slabBlock = slabBlock;
        this.blockItem = blockItem;
        this.stairsBlockItem = stairsBlockItem;
        this.slabBlockItem = slabBlockItem;
        this.wallBlockItem = wallBlockItem;
    }

    public static StoneBlockSet register(String name, Identifier baseBlockIdentifier, ResourceKey<CreativeModeTab> itemGroup, BlockBehaviour.Properties settings, Item itemPlacement) {
        Block block = BuiltInRegistries.BLOCK.getValue(baseBlockIdentifier);
        if (block == Blocks.AIR) {  // block registry returns minecraft:air if no block is found.
            block = ModBlockHelper.registerBlock(baseBlockIdentifier, Block::new, settings);
        }

        SlabBlock slabBlock = ModBlockHelper.registerSlabBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_slab"), BlockBehaviour.Properties.ofFullCopy(block));
        StairBlock stairsBlock = ModBlockHelper.registerStairsBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_stairs"), BlockBehaviour.Properties.ofFullCopy(block));
        WallBlock wallBlock = (WallBlock) ModBlockHelper.registerBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_wall"), WallBlock::new, BlockBehaviour.Properties.ofFullCopy(block));

        BlockItem blockItem = (BlockItem) block.asItem();
        BlockItem stairsBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_stairs"), stairsBlock, itemGroup, BlockItem::new, itemPlacement);
        BlockItem slabBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_slab"), slabBlock, itemGroup, BlockItem::new, stairsBlockItem);
        BlockItem wallBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_wall"), wallBlock, itemGroup, BlockItem::new, slabBlockItem);

        StoneBlockSet blockSet = new StoneBlockSet(name, block, blockItem, stairsBlock, stairsBlockItem, slabBlock, slabBlockItem, wallBlock, wallBlockItem);
        EmbyTweaks.BLOCK_SET_REGISTRY.register(blockSet.identifier, blockSet);

        return blockSet;
    }

    @Override
    public Identifier getIdentifier() {
        return this.identifier;
    }
}
