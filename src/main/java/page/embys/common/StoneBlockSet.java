package page.embys.common;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import page.embys.EmbyTweaks;

public class StoneBlockSet extends BlockSet {
    private final Identifier identifier;

    public final Block block;
    public final BlockItem blockItem;

    public final StairsBlock stairsBlock;
    public final BlockItem stairsBlockItem;

    public final WallBlock wallBlock;
    public final BlockItem wallBlockItem;

    public final SlabBlock slabBlock;
    public final BlockItem slabBlockItem;

    public StoneBlockSet(String name, Block block, BlockItem blockItem, StairsBlock stairsBlock, BlockItem stairsBlockItem, SlabBlock slabBlock, BlockItem slabBlockItem, WallBlock wallBlock, BlockItem wallBlockItem) {
        this.identifier = Identifier.of(EmbyTweaks.MOD_ID, name);
        this.block = block;
        this.stairsBlock = stairsBlock;
        this.wallBlock = wallBlock;
        this.slabBlock = slabBlock;
        this.blockItem = blockItem;
        this.stairsBlockItem = stairsBlockItem;
        this.slabBlockItem = slabBlockItem;
        this.wallBlockItem = wallBlockItem;
    }

    public static StoneBlockSet register(String name, Identifier baseBlockIdentifier, RegistryKey<ItemGroup> itemGroup, AbstractBlock.Settings settings, Item itemPlacement) {
        Block block = Registries.BLOCK.get(baseBlockIdentifier);
        if (block == Blocks.AIR) {  // block registry returns minecraft:air if no block is found.
            block = ModBlockHelper.registerBlock(baseBlockIdentifier, Block::new, settings);
        }

        SlabBlock slabBlock = ModBlockHelper.registerSlabBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_slab"), AbstractBlock.Settings.copy(block));
        StairsBlock stairsBlock = ModBlockHelper.registerStairsBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_stairs"), AbstractBlock.Settings.copy(block));
        WallBlock wallBlock = (WallBlock) ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_wall"), WallBlock::new, AbstractBlock.Settings.copy(block));

        BlockItem blockItem = (BlockItem) block.asItem();
        BlockItem stairsBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_stairs"), stairsBlock, itemGroup, BlockItem::new, itemPlacement);
        BlockItem slabBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_slab"), slabBlock, itemGroup, BlockItem::new, stairsBlockItem);
        BlockItem wallBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_wall"), wallBlock, itemGroup, BlockItem::new, slabBlockItem);

        StoneBlockSet blockSet = new StoneBlockSet(name, block, blockItem, stairsBlock, stairsBlockItem, slabBlock, slabBlockItem, wallBlock, wallBlockItem);
        EmbyTweaks.BLOCK_SET_REGISTRY.register(blockSet.identifier, blockSet);

        return blockSet;
    }

    @Override
    public Identifier getIdentifier() {
        return this.identifier;
    }
}
