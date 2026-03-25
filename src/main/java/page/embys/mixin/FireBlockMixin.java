package page.embys.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import page.embys.EmbyTweaks;
import page.embys.charred_wood.CharredWoodMain;
import page.embys.common.ModBlockHelper;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@Debug(export = true)
@Mixin(FireBlock.class)
public class FireBlockMixin {
    TagKey<Block> LOGS_THAT_BURN = TagKey.create(Registries.BLOCK, Identifier.parse("logs_that_burn"));
    TagKey<Block> LOGS = TagKey.create(Registries.BLOCK, Identifier.parse("logs"));
    TagKey<Block> NATURAL_WOODS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "natural_woods"));
    TagKey<Block> STRIPPED_WOODS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "stripped_woods"));
    TagKey<Block> WOODEN_SLABS = TagKey.create(Registries.BLOCK, Identifier.parse("wooden_slabs"));
    TagKey<Block> WOODEN_STAIRS = TagKey.create(Registries.BLOCK, Identifier.parse("wooden_stairs"));
    TagKey<Block> NON_FLAMMABLE_WOOD = TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"));
    TagKey<Block> STRIPPED_LOGS = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("c", "stripped_logs"));
    TagKey<Block> WOODEN_FENCES = TagKey.create(Registries.BLOCK, Identifier.parse("wooden_fences"));
    TagKey<Block> PLANKS = TagKey.create(Registries.BLOCK, Identifier.parse("planks"));

    HashMap<Block, Collection<TagKey<Block>>> burntBlockTagMap = new HashMap<>();

    // TODO(Ravel): wildcard and regex target are not supported
// TODO(Ravel): wildcard and regex target are not supported
    @WrapOperation(at = @At(value = "INVOKE", target = "net/minecraft/world/World.removeBlock (Lnet/minecraft/util/math/BlockPos;Z)Z"), method = "checkBurnOut(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;ILnet/minecraft/util/RandomSource;I)V")
    private boolean init(Level instance, BlockPos pos, boolean move, Operation<Boolean> original) {
        BlockState blockState = instance.getBlockState(pos);
        if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(LOGS_THAT_BURN, LOGS), Arrays.asList(STRIPPED_LOGS, NON_FLAMMABLE_WOOD, NATURAL_WOODS, STRIPPED_WOODS))) {
            instance.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred_log")).withPropertiesOf(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(PLANKS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred_planks")).withPropertiesOf(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(WOODEN_SLABS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred_slab")).withPropertiesOf(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(STRIPPED_LOGS, LOGS_THAT_BURN))) {
            instance.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "stripped_charred_log")).withPropertiesOf(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(WOODEN_STAIRS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred_stairs")).withPropertiesOf(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(WOODEN_FENCES), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred_fence")).withPropertiesOf(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(NATURAL_WOODS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "charred_wood")).withPropertiesOf(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(STRIPPED_WOODS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, "stripped_charred_wood")).withPropertiesOf(blockState));
            return true;
        } else {
            return original.call(instance, pos, move);
        }
    }
}
