package page.embys.terracotta_blocks;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.core.registries.BuiltInRegistries;
import page.embys.common.BlockSet;
import page.embys.common.BlockSetRegistry;
import page.embys.common.StoneBlockSet;

import java.util.Collection;

public class TerracottaBlockSets {
    private static final BlockSetRegistry blockSet = new BlockSetRegistry();

    public static void init() {
        StoneBlockSet.register("terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA), Items.TERRACOTTA);
        StoneBlockSet.register("white_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.WHITE_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA), Items.WHITE_TERRACOTTA);
        StoneBlockSet.register("light_gray_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.LIGHT_GRAY_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA), Items.LIGHT_GRAY_TERRACOTTA);
        StoneBlockSet.register("gray_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.GRAY_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA), Items.GRAY_TERRACOTTA);
        StoneBlockSet.register("black_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.BLACK_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA), Items.BLACK_TERRACOTTA);
        StoneBlockSet.register("brown_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.BROWN_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA), Items.BROWN_TERRACOTTA);
        StoneBlockSet.register("red_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.RED_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA), Items.RED_TERRACOTTA);
        StoneBlockSet.register("orange_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.ORANGE_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA), Items.ORANGE_TERRACOTTA);
        StoneBlockSet.register("yellow_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.YELLOW_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA), Items.YELLOW_TERRACOTTA);
        StoneBlockSet.register("lime_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.LIME_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA), Items.LIME_TERRACOTTA);
        StoneBlockSet.register("green_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.GREEN_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA), Items.GREEN_TERRACOTTA);
        StoneBlockSet.register("cyan_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.CYAN_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA), Items.CYAN_TERRACOTTA);
        StoneBlockSet.register("light_blue_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.LIGHT_BLUE_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA), Items.LIGHT_BLUE_TERRACOTTA);
        StoneBlockSet.register("blue_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.BLUE_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA), Items.BLUE_TERRACOTTA);
        StoneBlockSet.register("purple_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.PURPLE_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA), Items.PURPLE_TERRACOTTA);
        StoneBlockSet.register("magenta_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.MAGENTA_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA), Items.MAGENTA_TERRACOTTA);
        StoneBlockSet.register("pink_terracotta", BuiltInRegistries.BLOCK.getKey(Blocks.PINK_TERRACOTTA), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA), Items.PINK_TERRACOTTA);
    }

    public static Collection<BlockSet> getBlockSets() {
        return blockSet.getBlockSets();
    }
}
