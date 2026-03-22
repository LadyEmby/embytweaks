package page.embys.common;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
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

    public WoodBlockSet(String name,WoodType woodType, BlockSetType blockSetType, AbstractBlock.Settings settings, Item itemPlacement) {

        Block logBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_log"), PillarBlock::new, settings);
        BlockItem logBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_log"), logBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, itemPlacement);

        Block woodBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_wood"), PillarBlock::new, AbstractBlock.Settings.copy(logBlock));
        BlockItem woodBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_wood"), woodBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, logBlockItem);

        Block strippedLogBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, "stripped_" + name + "_log"), PillarBlock::new, AbstractBlock.Settings.copy(logBlock));
        BlockItem strippedLogBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, "stripped_" + name + "_log"), strippedLogBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, woodBlockItem);

        Block strippedWoodBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, "stripped_" + name + "_wood"), PillarBlock::new, AbstractBlock.Settings.copy(logBlock));
        BlockItem strippedWoodBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, "stripped_" + name + "_wood"), strippedWoodBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, strippedLogBlockItem);

        Block planksBlock = ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_planks"), Block::new, AbstractBlock.Settings.copy(logBlock));
        BlockItem planksBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_planks"), planksBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, strippedWoodBlockItem);

        StairsBlock stairsBlock = ModBlockHelper.registerStairsBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_stairs"), AbstractBlock.Settings.copy(logBlock));
        BlockItem stairsBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_stairs"), stairsBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, planksBlockItem);

        SlabBlock slabBlock = ModBlockHelper.registerSlabBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_slab"), AbstractBlock.Settings.copy(logBlock));
        BlockItem slabBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_slab"), slabBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, stairsBlockItem);

        FenceBlock fenceBlock = ModBlockHelper.registerFenceBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_fence"), AbstractBlock.Settings.copy(logBlock));
        BlockItem fenceBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_fence"), fenceBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, slabBlockItem);

        FenceGateBlock fenceGateBlock = ModBlockHelper.registerFenceGateBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_fence_gate"), woodType, AbstractBlock.Settings.copy(logBlock));
        BlockItem fenceGateBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_fence_gate"), fenceGateBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, fenceBlockItem);

        DoorBlock doorBlock = ModBlockHelper.registerDoorBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_door"), blockSetType, AbstractBlock.Settings.copy(logBlock).nonOpaque());
        BlockItem doorBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_door"), doorBlock, ItemGroups.BUILDING_BLOCKS, TallBlockItem::new, fenceGateBlockItem);

        TrapdoorBlock trapdoorBlock = ModBlockHelper.registerTrapdoorBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_trapdoor"), blockSetType, AbstractBlock.Settings.copy(logBlock).nonOpaque());
        BlockItem trapdoorBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_trapdoor"), trapdoorBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, doorBlockItem);

        PressurePlateBlock pressurePlateBlock = ModBlockHelper.registerPressurePlateBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_pressure_plate"), blockSetType, AbstractBlock.Settings.copy(logBlock));
        BlockItem pressurePlateBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_pressure_plate"), pressurePlateBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, trapdoorBlockItem);

        ButtonBlock buttonBlock = ModBlockHelper.registerButtonBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_button"), blockSetType, 30, AbstractBlock.Settings.copy(logBlock));
        BlockItem buttonBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_button"), buttonBlock, ItemGroups.BUILDING_BLOCKS, BlockItem::new, pressurePlateBlockItem);

        ShelfBlock shelfBlock = (ShelfBlock) ModBlockHelper.registerBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_shelf"), ShelfBlock::new, AbstractBlock.Settings.copy(logBlock));
        BlockItem shelfBlockItem = ModItemHelper.registerBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_shelf"), shelfBlock, ItemGroups.FUNCTIONAL, BlockItem::new, Items.WARPED_SHELF);

        SignBlock signBlock = (SignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_sign"), woodType, AbstractBlock.Settings.copy(Blocks.WARPED_SIGN), SignBlock::new);
        WallSignBlock wallSignBlock = (WallSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_wall_sign"), woodType, AbstractBlock.Settings.copy(Blocks.WARPED_WALL_SIGN), WallSignBlock::new);
        BlockItem signBlockItem = ModItemHelper.registerVerticallyAttachableBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_sign"), signBlock, wallSignBlock, new Item.Settings(), ItemGroups.FUNCTIONAL, Items.WARPED_HANGING_SIGN, SignItem::new);

        HangingSignBlock hangingSignBlock = (HangingSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_hanging_sign"), woodType, AbstractBlock.Settings.copy(Blocks.WARPED_HANGING_SIGN), HangingSignBlock::new);
        WallHangingSignBlock wallHangingSignBlock = (WallHangingSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.of(EmbyTweaks.MOD_ID, name + "_wall_hanging_sign"), woodType, AbstractBlock.Settings.copy(Blocks.WARPED_WALL_HANGING_SIGN), WallHangingSignBlock::new);
        BlockItem hangingSignBlockItem = ModItemHelper.registerVerticallyAttachableBlockItem(Identifier.of(EmbyTweaks.MOD_ID, name + "_hanging_sign"), hangingSignBlock, wallHangingSignBlock, new Item.Settings(), ItemGroups.FUNCTIONAL, signBlockItem, HangingSignItem::new);

        this.boat = ModEntityHelper.registerBoat(name + "_boat", (type, world) -> new BoatEntity(type, world, boatItem()));
        this.boatItem = ModItemHelper.registerBoatItem(name + "_boat", itemSettings -> new BoatItem(boat().get(), itemSettings), new Item.Settings().maxCount(1));

        StrippableBlockRegistry.register(logBlock, strippedLogBlock);
        StrippableBlockRegistry.register(woodBlock, strippedWoodBlock);
        BlockEntityType.SHELF.addSupportedBlock(shelfBlock);
        BlockEntityType.SIGN.addSupportedBlock(signBlock);
        BlockEntityType.SIGN.addSupportedBlock(wallSignBlock);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(hangingSignBlock);
        BlockEntityType.HANGING_SIGN.addSupportedBlock(wallHangingSignBlock);


        this.identifier = Identifier.of(EmbyTweaks.MOD_ID, name);
        this.logBlock = logBlock;
        this.logBlockItem = logBlockItem;

        this.woodBlock = woodBlock;
        this.woodBlockItem = woodBlockItem;

        this.strippedLogBlock = strippedLogBlock;
        this.strippedLogBlockItem = strippedLogBlockItem;

        this.strippedWoodBlock = strippedWoodBlock;
        this.strippedWoodBlockItem = strippedWoodBlockItem;

        this.planksBlock = planksBlock;
        this.planksBlockItem = planksBlockItem;

        this.stairsBlock = stairsBlock;
        this.stairsBlockItem = stairsBlockItem;

        this.slabBlock = slabBlock;
        this.slabBlockItem = slabBlockItem;

        this.fenceBlock = fenceBlock;
        this.fenceBlockItem = fenceBlockItem;

        this.fenceGateBlock = fenceGateBlock;
        this.fenceGateBlockItem = fenceGateBlockItem;

        this.doorBlock = doorBlock;
        this.doorBlockItem = doorBlockItem;

        this.trapdoorBlock = trapdoorBlock;
        this.trapdoorBlockItem = trapdoorBlockItem;

        this.buttonBlock = buttonBlock;
        this.buttonBlockItem = buttonBlockItem;

        this.pressurePlateBlock = pressurePlateBlock;
        this.pressurePlateBlockItem = pressurePlateBlockItem;

        this.shelfBlock = shelfBlock;
        this.shelfBlockItem = shelfBlockItem;

        this.signBlock = signBlock;
        this.wallSignBlock = wallSignBlock;
        this.signBlockItem = signBlockItem;

        this.hangingSignBlock = hangingSignBlock;
        this.wallHangingSignBlock = wallHangingSignBlock;
        this.hangingSignBlockItem = hangingSignBlockItem;
        
        EmbyTweaks.BLOCK_SET_REGISTRY.register(this.identifier, this);
    }

    private Supplier<Item> boatItem() {
        return this.boatItem;
    }

    private Supplier<EntityType<BoatEntity>> boat() {
        return this.boat;
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
