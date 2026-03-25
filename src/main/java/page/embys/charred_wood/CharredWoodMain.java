package page.embys.charred_wood;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import page.embys.EmbyTweaks;
import page.embys.common.BlockSetRegistry;
import page.embys.common.ModBlockHelper;
import page.embys.common.ModItemHelper;
import page.embys.common.WoodBlockSet;

public class CharredWoodMain {
    public static final BlockSetRegistry blockSetRegistry = new BlockSetRegistry();

    public static final BlockSetType CHARRED_BLOCK_SET = new BlockSetType(
            "charred",
            true,
            true,
            true,
            BlockSetType.PressurePlateSensitivity.EVERYTHING,
            SoundType.NETHER_WOOD,  // sounds more ashy
            SoundEvents.NETHER_WOOD_DOOR_CLOSE,
            SoundEvents.NETHER_WOOD_DOOR_OPEN,
            SoundEvents.NETHER_WOOD_TRAPDOOR_CLOSE,
            SoundEvents.NETHER_WOOD_TRAPDOOR_OPEN,
            SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.NETHER_WOOD_BUTTON_CLICK_OFF,
            SoundEvents.NETHER_WOOD_BUTTON_CLICK_ON
    );

    public static WoodType CHARRED_WOOD_TYPE;
    public static BlockBehaviour.Properties CHARRED_WOOD_BLOCK_SETTINGS;
    public static WoodBlockSet CHARRED_WOOD_BLOCKSET;

    public static void init() {
        CHARRED_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.WARPED).register(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred"), CHARRED_BLOCK_SET);
        CHARRED_WOOD_BLOCK_SETTINGS = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD);

        CHARRED_WOOD_BLOCKSET = new WoodBlockSet("charred", CHARRED_WOOD_TYPE, CHARRED_BLOCK_SET, CHARRED_WOOD_BLOCK_SETTINGS, Items.WARPED_BUTTON).isFireproof();
    }
}
