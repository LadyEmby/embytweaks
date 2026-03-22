package page.embys.concrete_blocks;

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

public class ConcreteBlockSets {
    public static void init() {
        StoneBlockSet.register("white_concrete", Registries.BLOCK.getId(Blocks.WHITE_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE), Items.WHITE_CONCRETE);
        StoneBlockSet.register("light_gray_concrete", Registries.BLOCK.getId(Blocks.LIGHT_GRAY_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE), Items.LIGHT_GRAY_CONCRETE);
        StoneBlockSet.register("gray_concrete", Registries.BLOCK.getId(Blocks.GRAY_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE), Items.GRAY_CONCRETE);
        StoneBlockSet.register("black_concrete", Registries.BLOCK.getId(Blocks.BLACK_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE), Items.BLACK_CONCRETE);
        StoneBlockSet.register("brown_concrete", Registries.BLOCK.getId(Blocks.BROWN_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE), Items.BROWN_CONCRETE);
        StoneBlockSet.register("red_concrete", Registries.BLOCK.getId(Blocks.RED_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.RED_CONCRETE), Items.RED_CONCRETE);
        StoneBlockSet.register("orange_concrete", Registries.BLOCK.getId(Blocks.ORANGE_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE), Items.ORANGE_CONCRETE);
        StoneBlockSet.register("yellow_concrete", Registries.BLOCK.getId(Blocks.YELLOW_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE), Items.YELLOW_CONCRETE);
        StoneBlockSet.register("lime_concrete", Registries.BLOCK.getId(Blocks.LIME_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE), Items.LIME_CONCRETE);
        StoneBlockSet.register("green_concrete", Registries.BLOCK.getId(Blocks.GREEN_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE), Items.GREEN_CONCRETE);
        StoneBlockSet.register("cyan_concrete", Registries.BLOCK.getId(Blocks.CYAN_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE), Items.CYAN_CONCRETE);
        StoneBlockSet.register("light_blue_concrete", Registries.BLOCK.getId(Blocks.LIGHT_BLUE_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE), Items.LIGHT_BLUE_CONCRETE);
        StoneBlockSet.register("blue_concrete", Registries.BLOCK.getId(Blocks.BLUE_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE), Items.BLUE_CONCRETE);
        StoneBlockSet.register("purple_concrete", Registries.BLOCK.getId(Blocks.PURPLE_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE), Items.PURPLE_CONCRETE);
        StoneBlockSet.register("magenta_concrete", Registries.BLOCK.getId(Blocks.MAGENTA_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE), Items.MAGENTA_CONCRETE);
        StoneBlockSet.register("pink_concrete", Registries.BLOCK.getId(Blocks.PINK_CONCRETE), ItemGroups.COLORED_BLOCKS, AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE), Items.PINK_CONCRETE);
    }
}
