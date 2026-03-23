package page.embys.common;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.ChestBoatEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import page.embys.EmbyTweaks;

import java.util.function.Supplier;

public class WoodBlockSet extends BlockSet {
    public final Identifier identifier;
    private boolean isFlammable = true;

    public final Block logBlock;
    public final BlockItem logBlockItem;

    public final Block woodBlock;
    public final BlockItem woodBlockItem;

    public final Block strippedLogBlock;
    public final BlockItem strippedLogBlockItem;

    public final Block strippedWoodBlock;
    public final BlockItem strippedWoodBlockItem;

    public final Block planksBlock;
    public final BlockItem planksBlockItem;

    public final StairsBlock stairsBlock;
    public final BlockItem stairsBlockItem;

    public final SlabBlock slabBlock;
    public final BlockItem slabBlockItem;

    public final FenceBlock fenceBlock;
    public final BlockItem fenceBlockItem;

    public final FenceGateBlock fenceGateBlock;
    public final BlockItem fenceGateBlockItem;

    public final DoorBlock doorBlock;
    public final BlockItem doorBlockItem;

    public final TrapdoorBlock trapdoorBlock;
    public final BlockItem trapdoorBlockItem;

    public final ButtonBlock buttonBlock;
    public final BlockItem buttonBlockItem;

    public final PressurePlateBlock pressurePlateBlock;
    public final BlockItem pressurePlateBlockItem;

    public final ShelfBlock shelfBlock;
    public final BlockItem shelfBlockItem;

    public final SignBlock signBlock;
    public final WallSignBlock wallSignBlock;
    public final BlockItem signBlockItem;

    public final HangingSignBlock hangingSignBlock;
    public final WallHangingSignBlock wallHangingSignBlock;
    public final BlockItem hangingSignBlockItem;

    public final Supplier<Item> boatItem;
    public final Supplier<EntityType<BoatEntity>> boat;

    public final Supplier<Item> chestBoatItem;
    public final Supplier<EntityType<ChestBoatEntity>> chestBoat;

    public WoodBlockSet(String name,WoodType woodType, BlockSetType blockSetType, AbstractBlock.Settings settings, Item itemPlacement) {
        this.identifier = Identifier.of(EmbyTweaks.MOD_ID, name);

        this.logBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_log"), PillarBlock::new, settings);
        this.logBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_log"), logBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, itemPlacement);

        this.woodBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_wood"), PillarBlock::new, AbstractBlock.Settings.copy(logBlock));
        this.woodBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_wood"), woodBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, logBlockItem);

        this.strippedLogBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, "stripped_" + name + "_log"), PillarBlock::new, AbstractBlock.Settings.copy(logBlock));
        this.strippedLogBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, "stripped_" + name + "_log"), strippedLogBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, woodBlockItem);

        this.strippedWoodBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, "stripped_" + name + "_wood"), PillarBlock::new, AbstractBlock.Settings.copy(logBlock));
        this.strippedWoodBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, "stripped_" + name + "_wood"), strippedWoodBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, strippedLogBlockItem);

        this.planksBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_planks"), Block::new, AbstractBlock.Settings.copy(logBlock));
        this.planksBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_planks"), planksBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, strippedWoodBlockItem);

        this.stairsBlock = ModBlockHelper.registerStairsBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_stairs"), AbstractBlock.Settings.copy(logBlock));
        this.stairsBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_stairs"), stairsBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, planksBlockItem);

        this.slabBlock = ModBlockHelper.registerSlabBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_slab"), AbstractBlock.Settings.copy(logBlock));
        this.slabBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_slab"), slabBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, stairsBlockItem);

        this.fenceBlock = ModBlockHelper.registerFenceBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_fence"), AbstractBlock.Settings.copy(logBlock));
        this.fenceBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_fence"), fenceBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, slabBlockItem);

        this.fenceGateBlock = ModBlockHelper.registerFenceGateBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_fence_gate"), woodType, AbstractBlock.Settings.copy(logBlock));
        this.fenceGateBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_fence_gate"), fenceGateBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, fenceBlockItem);

        this.doorBlock = ModBlockHelper.registerDoorBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_door"), blockSetType, AbstractBlock.Settings.copy(logBlock).nonOpaque());
        this.doorBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_door"), doorBlock, ItemGroups.BUILDING_BLOCKS, TallBlockItem::new, fenceGateBlockItem);

        this.trapdoorBlock = ModBlockHelper.registerTrapdoorBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_trapdoor"), blockSetType, AbstractBlock.Settings.copy(logBlock).nonOpaque());
        this.trapdoorBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_trapdoor"), trapdoorBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, doorBlockItem);

        this.pressurePlateBlock = ModBlockHelper.registerPressurePlateBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_pressure_plate"), blockSetType, AbstractBlock.Settings.copy(logBlock));
        this.pressurePlateBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_pressure_plate"), pressurePlateBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, trapdoorBlockItem);

        this.buttonBlock = ModBlockHelper.registerButtonBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_button"), blockSetType, 30, AbstractBlock.Settings.copy(logBlock));
        this.buttonBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_button"), buttonBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, pressurePlateBlockItem);

        this.shelfBlock = (ShelfBlock) ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_shelf"), ShelfBlock::new, AbstractBlock.Settings.copy(logBlock));
        this.shelfBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_shelf"), shelfBlock, ItemGroups.FUNCTIONAL, BlockItem::new, Items.WARPED_SHELF);

        this.signBlock = (SignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_sign"), woodType, AbstractBlock.Settings.copy(Blocks.WARPED_SIGN), SignBlock::new);
        this.wallSignBlock = (WallSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_wall_sign"), woodType, AbstractBlock.Settings.copy(Blocks.WARPED_WALL_SIGN), WallSignBlock::new);
        this.signBlockItem = ModItemHelper.registerVerticallyAttachableBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_sign"), signBlock, wallSignBlock, new Item.Settings(), ItemGroups.FUNCTIONAL, Items.WARPED_HANGING_SIGN, SignItem::new);

        this.hangingSignBlock = (HangingSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_hanging_sign"), woodType, AbstractBlock.Settings.copy(Blocks.WARPED_HANGING_SIGN), HangingSignBlock::new);
        this.wallHangingSignBlock = (WallHangingSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_wall_hanging_sign"), woodType, AbstractBlock.Settings.copy(Blocks.WARPED_WALL_HANGING_SIGN), WallHangingSignBlock::new);
        this.hangingSignBlockItem = ModItemHelper.registerVerticallyAttachableBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_hanging_sign"), hangingSignBlock, wallHangingSignBlock, new Item.Settings(), ItemGroups.FUNCTIONAL, signBlockItem, HangingSignItem::new);

        this.boat = ModEntityHelper.registerBoat(name + "_boat", (type, world) -> new BoatEntity(type, world, boatItem()));
        this.boatItem = ModItemHelper.registerBoatItem(name + "_boat", itemSettings -> new BoatItem(boat().get(), itemSettings), new Item.Settings().maxCount(1), ItemGroups.TOOLS, Items.PALE_OAK_CHEST_BOAT);

        this.chestBoat = ModEntityHelper.registerBoat(name + "_chest_boat", (type, world) -> new ChestBoatEntity(type, world, chestBoatItem()));
        this.chestBoatItem = ModItemHelper.registerBoatItem(name + "_chest_boat", itemSettings -> new BoatItem(chestBoat().get(), itemSettings), new Item.Settings().maxCount(1), ItemGroups.TOOLS, boatItem().get());

        StrippableBlockRegistry.register(logBlock, strippedLogBlock);
        StrippableBlockRegistry.register(woodBlock, strippedWoodBlock);
        BlockEntityType.SHELF.addSupportedBlock(shelfBlock);
        BlockEntityType.SIGN.addSupportedBlock(signBlock);
        BlockEntityType.SIGN.addSupportedBlock(wallSignBlock);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(hangingSignBlock);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(wallHangingSignBlock);

        EmbyTweaks.BLOCK_SET_REGISTRY.register(this.identifier, this);
    }

    private Supplier<Item> boatItem() {
        return this.boatItem;
    }

    private Supplier<EntityType<BoatEntity>> boat() {
        return this.boat;
    }

    private Supplier<Item> chestBoatItem() {
        return this.chestBoatItem;
    }

    private Supplier<EntityType<ChestBoatEntity>> chestBoat() {
        return this.chestBoat;
    }

    public boolean getIsFlammable() {
        return isFlammable;
    }

    public WoodBlockSet isFireproof() {
        this.isFlammable = false;
        return this;
    }

    @Override
    public Identifier getIdentifier() {
        return this.identifier;
    }
}
