package page.embys.concrete_blocks;

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

public class ConcreteBlockSets {
    public static void init() {
        StoneBlockSet.register("white_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.WHITE_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE), Items.WHITE_CONCRETE);
        StoneBlockSet.register("light_gray_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.LIGHT_GRAY_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE), Items.LIGHT_GRAY_CONCRETE);
        StoneBlockSet.register("gray_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.GRAY_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE), Items.GRAY_CONCRETE);
        StoneBlockSet.register("black_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.BLACK_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE), Items.BLACK_CONCRETE);
        StoneBlockSet.register("brown_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.BROWN_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE), Items.BROWN_CONCRETE);
        StoneBlockSet.register("red_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.RED_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE), Items.RED_CONCRETE);
        StoneBlockSet.register("orange_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.ORANGE_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE), Items.ORANGE_CONCRETE);
        StoneBlockSet.register("yellow_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.YELLOW_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), Items.YELLOW_CONCRETE);
        StoneBlockSet.register("lime_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.LIME_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE), Items.LIME_CONCRETE);
        StoneBlockSet.register("green_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.GREEN_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE), Items.GREEN_CONCRETE);
        StoneBlockSet.register("cyan_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.CYAN_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE), Items.CYAN_CONCRETE);
        StoneBlockSet.register("light_blue_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.LIGHT_BLUE_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE), Items.LIGHT_BLUE_CONCRETE);
        StoneBlockSet.register("blue_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.BLUE_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE), Items.BLUE_CONCRETE);
        StoneBlockSet.register("purple_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.PURPLE_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE), Items.PURPLE_CONCRETE);
        StoneBlockSet.register("magenta_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.MAGENTA_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE), Items.MAGENTA_CONCRETE);
        StoneBlockSet.register("pink_concrete", BuiltInRegistries.BLOCK.getKey(Blocks.PINK_CONCRETE), CreativeModeTabs.COLORED_BLOCKS, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE), Items.PINK_CONCRETE);
    }
}
