package page.embys.glazed_terracotta_blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import page.embys.common.BlockSet;
import page.embys.common.BlockSetRegistry;
import page.embys.common.StoneBlockSet;

import java.util.Collection;

public class GlazedTerracottaBlockSets {
    public static void init() {
        StoneBlockSet.register("white_glazed_terracotta", Registries.BLOCK.getId(Blocks.WHITE_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.WHITE_GLAZED_TERRACOTTA), Items.WHITE_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("light_gray_glazed_terracotta", Registries.BLOCK.getId(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA), Items.LIGHT_GRAY_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("gray_glazed_terracotta", Registries.BLOCK.getId(Blocks.GRAY_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.GRAY_GLAZED_TERRACOTTA), Items.GRAY_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("black_glazed_terracotta", Registries.BLOCK.getId(Blocks.BLACK_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BLACK_GLAZED_TERRACOTTA), Items.BLACK_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("brown_glazed_terracotta", Registries.BLOCK.getId(Blocks.BROWN_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BROWN_GLAZED_TERRACOTTA), Items.BROWN_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("red_glazed_terracotta", Registries.BLOCK.getId(Blocks.RED_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.RED_GLAZED_TERRACOTTA), Items.RED_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("orange_glazed_terracotta", Registries.BLOCK.getId(Blocks.ORANGE_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.ORANGE_GLAZED_TERRACOTTA), Items.ORANGE_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("yellow_glazed_terracotta", Registries.BLOCK.getId(Blocks.YELLOW_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.YELLOW_GLAZED_TERRACOTTA), Items.YELLOW_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("lime_glazed_terracotta", Registries.BLOCK.getId(Blocks.LIME_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIME_GLAZED_TERRACOTTA), Items.LIME_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("green_glazed_terracotta", Registries.BLOCK.getId(Blocks.GREEN_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.GREEN_GLAZED_TERRACOTTA), Items.GREEN_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("cyan_glazed_terracotta", Registries.BLOCK.getId(Blocks.CYAN_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.CYAN_GLAZED_TERRACOTTA), Items.CYAN_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("light_blue_glazed_terracotta", Registries.BLOCK.getId(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA), Items.LIGHT_BLUE_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("blue_glazed_terracotta", Registries.BLOCK.getId(Blocks.BLUE_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BLUE_GLAZED_TERRACOTTA), Items.BLUE_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("purple_glazed_terracotta", Registries.BLOCK.getId(Blocks.PURPLE_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.PURPLE_GLAZED_TERRACOTTA), Items.PURPLE_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("magenta_glazed_terracotta", Registries.BLOCK.getId(Blocks.MAGENTA_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.MAGENTA_GLAZED_TERRACOTTA), Items.MAGENTA_GLAZED_TERRACOTTA).isUvLocked();
        StoneBlockSet.register("pink_glazed_terracotta", Registries.BLOCK.getId(Blocks.PINK_GLAZED_TERRACOTTA), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.PINK_GLAZED_TERRACOTTA), Items.PINK_GLAZED_TERRACOTTA).isUvLocked();
    }
}
