package page.embys.common;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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

    public final StairBlock stairsBlock;
    public final BlockItem stairsBlockItem;

    public final SlabBlock slabBlock;
    public final BlockItem slabBlockItem;

    public final FenceBlock fenceBlock;
    public final BlockItem fenceBlockItem;

    public final FenceGateBlock fenceGateBlock;
    public final BlockItem fenceGateBlockItem;

    public final DoorBlock doorBlock;
    public final BlockItem doorBlockItem;

    public final TrapDoorBlock trapdoorBlock;
    public final BlockItem trapdoorBlockItem;

    public final ButtonBlock buttonBlock;
    public final BlockItem buttonBlockItem;

    public final PressurePlateBlock pressurePlateBlock;
    public final BlockItem pressurePlateBlockItem;

    public final ShelfBlock shelfBlock;
    public final BlockItem shelfBlockItem;

    public final StandingSignBlock signBlock;
    public final WallSignBlock wallSignBlock;
    public final BlockItem signBlockItem;

    public final CeilingHangingSignBlock hangingSignBlock;
    public final WallHangingSignBlock wallHangingSignBlock;
    public final BlockItem hangingSignBlockItem;

    public final Supplier<Item> boatItem;
    public final Supplier<EntityType<Boat>> boat;

    public final Supplier<Item> chestBoatItem;
    public final Supplier<EntityType<ChestBoat>> chestBoat;

    public WoodBlockSet(String name, WoodType woodType, BlockSetType blockSetType, BlockBehaviour.Properties settings, Item itemPlacement) {
        this.identifier = Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name);

        this.logBlock = ModBlockHelper.registerBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_log"), RotatedPillarBlock::new, settings);
        this.logBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_log"), logBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, itemPlacement);

        this.woodBlock = ModBlockHelper.registerBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_wood"), RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.woodBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_wood"), woodBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, logBlockItem);

        this.strippedLogBlock = ModBlockHelper.registerBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "stripped_" + name + "_log"), RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.strippedLogBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "stripped_" + name + "_log"), strippedLogBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, woodBlockItem);

        this.strippedWoodBlock = ModBlockHelper.registerBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "stripped_" + name + "_wood"), RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.strippedWoodBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "stripped_" + name + "_wood"), strippedWoodBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, strippedLogBlockItem);

        this.planksBlock = ModBlockHelper.registerBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_planks"), Block::new, BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.planksBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_planks"), planksBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, strippedWoodBlockItem);

        this.stairsBlock = ModBlockHelper.registerStairsBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_stairs"), BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.stairsBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_stairs"), stairsBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, planksBlockItem);

        this.slabBlock = ModBlockHelper.registerSlabBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_slab"), BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.slabBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_slab"), slabBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, stairsBlockItem);

        this.fenceBlock = ModBlockHelper.registerFenceBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_fence"), BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.fenceBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_fence"), fenceBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, slabBlockItem);

        this.fenceGateBlock = ModBlockHelper.registerFenceGateBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_fence_gate"), woodType, BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.fenceGateBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_fence_gate"), fenceGateBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, fenceBlockItem);

        this.doorBlock = ModBlockHelper.registerDoorBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_door"), blockSetType, BlockBehaviour.Properties.ofFullCopy(logBlock).noOcclusion());
        this.doorBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_door"), doorBlock, CreativeModeTabs.BUILDING_BLOCKS, DoubleHighBlockItem::new, fenceGateBlockItem);

        this.trapdoorBlock = ModBlockHelper.registerTrapdoorBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_trapdoor"), blockSetType, BlockBehaviour.Properties.ofFullCopy(logBlock).noOcclusion());
        this.trapdoorBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_trapdoor"), trapdoorBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, doorBlockItem);

        this.pressurePlateBlock = ModBlockHelper.registerPressurePlateBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_pressure_plate"), blockSetType, BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.pressurePlateBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_pressure_plate"), pressurePlateBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, trapdoorBlockItem);

        this.buttonBlock = ModBlockHelper.registerButtonBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_button"), blockSetType, 30, BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.buttonBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_button"), buttonBlock, CreativeModeTabs.BUILDING_BLOCKS, BlockItem::new, pressurePlateBlockItem);

        this.shelfBlock = (ShelfBlock) ModBlockHelper.registerBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_shelf"), ShelfBlock::new, BlockBehaviour.Properties.ofFullCopy(logBlock));
        this.shelfBlockItem = ModItemHelper.registerBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_shelf"), shelfBlock, CreativeModeTabs.FUNCTIONAL_BLOCKS, BlockItem::new, Items.WARPED_SHELF);

        this.signBlock = (StandingSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_sign"), woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_SIGN), StandingSignBlock::new);
        this.wallSignBlock = (WallSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_wall_sign"), woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_SIGN), WallSignBlock::new);
        this.signBlockItem = ModItemHelper.registerVerticallyAttachableBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_sign"), signBlock, wallSignBlock, new net.minecraft.world.item.Item.Properties(), CreativeModeTabs.FUNCTIONAL_BLOCKS, Items.WARPED_HANGING_SIGN, SignItem::new);

        this.hangingSignBlock = (CeilingHangingSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_hanging_sign"), woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HANGING_SIGN), CeilingHangingSignBlock::new);
        this.wallHangingSignBlock = (WallHangingSignBlock) ModBlockHelper.registerWoodTypeBlock(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_wall_hanging_sign"), woodType, BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_WALL_HANGING_SIGN), WallHangingSignBlock::new);
        this.hangingSignBlockItem = ModItemHelper.registerVerticallyAttachableBlockItem(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name + "_hanging_sign"), hangingSignBlock, wallHangingSignBlock, new net.minecraft.world.item.Item.Properties(), CreativeModeTabs.FUNCTIONAL_BLOCKS, signBlockItem, HangingSignItem::new);

        this.boat = ModEntityHelper.registerBoat(name + "_boat", (type, world) -> new Boat(type, world, boatItem()));
        this.boatItem = ModItemHelper.registerBoatItem(name + "_boat", itemSettings -> new BoatItem(boat().get(), itemSettings), new net.minecraft.world.item.Item.Properties().stacksTo(1), CreativeModeTabs.TOOLS_AND_UTILITIES, Items.PALE_OAK_CHEST_BOAT);

        this.chestBoat = ModEntityHelper.registerBoat(name + "_chest_boat", (type, world) -> new ChestBoat(type, world, chestBoatItem()));
        this.chestBoatItem = ModItemHelper.registerBoatItem(name + "_chest_boat", itemSettings -> new BoatItem(chestBoat().get(), itemSettings), new net.minecraft.world.item.Item.Properties().stacksTo(1), CreativeModeTabs.TOOLS_AND_UTILITIES, boatItem().get());

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

    private Supplier<EntityType<Boat>> boat() {
        return this.boat;
    }

    private Supplier<Item> chestBoatItem() {
        return this.chestBoatItem;
    }

    private Supplier<EntityType<ChestBoat>> chestBoat() {
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
