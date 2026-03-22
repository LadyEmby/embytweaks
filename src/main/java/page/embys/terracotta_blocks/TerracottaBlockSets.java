package page.embys.terracotta_blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import page.embys.common.BlockSet;
import page.embys.common.BlockSetRegistry;
import page.embys.common.StoneBlockSet;

import java.util.Collection;

public class TerracottaBlockSets {
    private static final BlockSetRegistry blockSet = new BlockSetRegistry();

    public static void init() {
        StoneBlockSet.register("terracotta", Registries.BLOCK.getId(Blocks.TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.TERRACOTTA), Items.TERRACOTTA);
        StoneBlockSet.register("white_terracotta", Registries.BLOCK.getId(Blocks.WHITE_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.WHITE_TERRACOTTA), Items.WHITE_TERRACOTTA);
        StoneBlockSet.register("light_gray_terracotta", Registries.BLOCK.getId(Blocks.LIGHT_GRAY_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_TERRACOTTA), Items.LIGHT_GRAY_TERRACOTTA);
        StoneBlockSet.register("gray_terracotta", Registries.BLOCK.getId(Blocks.GRAY_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.GRAY_TERRACOTTA), Items.GRAY_TERRACOTTA);
        StoneBlockSet.register("black_terracotta", Registries.BLOCK.getId(Blocks.BLACK_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BLACK_TERRACOTTA), Items.BLACK_TERRACOTTA);
        StoneBlockSet.register("brown_terracotta", Registries.BLOCK.getId(Blocks.BROWN_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BROWN_TERRACOTTA), Items.BROWN_TERRACOTTA);
        StoneBlockSet.register("red_terracotta", Registries.BLOCK.getId(Blocks.RED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.RED_TERRACOTTA), Items.RED_TERRACOTTA);
        StoneBlockSet.register("orange_terracotta", Registries.BLOCK.getId(Blocks.ORANGE_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.ORANGE_TERRACOTTA), Items.ORANGE_TERRACOTTA);
        StoneBlockSet.register("yellow_terracotta", Registries.BLOCK.getId(Blocks.YELLOW_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.YELLOW_TERRACOTTA), Items.YELLOW_TERRACOTTA);
        StoneBlockSet.register("lime_terracotta", Registries.BLOCK.getId(Blocks.LIME_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIME_TERRACOTTA), Items.LIME_TERRACOTTA);
        StoneBlockSet.register("green_terracotta", Registries.BLOCK.getId(Blocks.GREEN_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.GREEN_TERRACOTTA), Items.GREEN_TERRACOTTA);
        StoneBlockSet.register("cyan_terracotta", Registries.BLOCK.getId(Blocks.CYAN_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.CYAN_TERRACOTTA), Items.CYAN_TERRACOTTA);
        StoneBlockSet.register("light_blue_terracotta", Registries.BLOCK.getId(Blocks.LIGHT_BLUE_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_TERRACOTTA), Items.LIGHT_BLUE_TERRACOTTA);
        StoneBlockSet.register("blue_terracotta", Registries.BLOCK.getId(Blocks.BLUE_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BLUE_TERRACOTTA), Items.BLUE_TERRACOTTA);
        StoneBlockSet.register("purple_terracotta", Registries.BLOCK.getId(Blocks.PURPLE_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.PURPLE_TERRACOTTA), Items.PURPLE_TERRACOTTA);
        StoneBlockSet.register("magenta_terracotta", Registries.BLOCK.getId(Blocks.MAGENTA_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.MAGENTA_TERRACOTTA), Items.MAGENTA_TERRACOTTA);
        StoneBlockSet.register("pink_terracotta", Registries.BLOCK.getId(Blocks.PINK_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.PINK_TERRACOTTA), Items.PINK_TERRACOTTA);
    }

    public static Collection<BlockSet> getBlockSets() {
        return blockSet.getBlockSets();
    }
}
