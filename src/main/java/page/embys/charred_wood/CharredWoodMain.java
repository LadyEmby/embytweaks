package page.embys.charred_wood;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
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
            BlockSetType.ActivationRule.EVERYTHING,
            BlockSoundGroup.NETHER_WOOD,  // sounds more ashy
            SoundEvents.BLOCK_NETHER_WOOD_DOOR_CLOSE,
            SoundEvents.BLOCK_NETHER_WOOD_DOOR_OPEN,
            SoundEvents.BLOCK_NETHER_WOOD_TRAPDOOR_CLOSE,
            SoundEvents.BLOCK_NETHER_WOOD_TRAPDOOR_OPEN,
            SoundEvents.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_OFF,
            SoundEvents.BLOCK_NETHER_WOOD_BUTTON_CLICK_ON
    );

    public static WoodType CHARRED_WOOD_TYPE;
    public static AbstractBlock.Settings CHARRED_WOOD_BLOCK_SETTINGS;
    public static WoodBlockSet CHARRED_WOOD_BLOCKSET;

    public static void init() {
        CHARRED_WOOD_TYPE = WoodTypeBuilder.copyOf(WoodType.WARPED).register(Identifier.of(EmbyTweaks.MOD_ID, "charred"), CHARRED_BLOCK_SET);
        CHARRED_WOOD_BLOCK_SETTINGS = AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);

        CHARRED_WOOD_BLOCKSET = new WoodBlockSet("charred", CHARRED_WOOD_TYPE, CHARRED_BLOCK_SET, CHARRED_WOOD_BLOCK_SETTINGS, Items.WARPED_BUTTON).isFireproof();
    }
}
