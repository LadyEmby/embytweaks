package page.embys.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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
    TagKey<Block> LOGS_THAT_BURN = TagKey.of(RegistryKeys.BLOCK, Identifier.of("logs_that_burn"));
    TagKey<Block> LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("logs"));
    TagKey<Block> NATURAL_WOODS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "natural_woods"));
    TagKey<Block> STRIPPED_WOODS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "stripped_woods"));
    TagKey<Block> WOODEN_SLABS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("wooden_slabs"));
    TagKey<Block> WOODEN_STAIRS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("wooden_stairs"));
    TagKey<Block> NON_FLAMMABLE_WOOD = TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"));
    TagKey<Block> STRIPPED_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "stripped_logs"));
    TagKey<Block> WOODEN_FENCES = TagKey.of(RegistryKeys.BLOCK, Identifier.of("wooden_fences"));
    TagKey<Block> PLANKS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("planks"));

    HashMap<Block, Collection<TagKey<Block>>> burntBlockTagMap = new HashMap<>();

    @WrapOperation(at = @At(value = "INVOKE", target = "net/minecraft/world/World.removeBlock (Lnet/minecraft/util/math/BlockPos;Z)Z"), method = "trySpreadingFire(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;ILnet/minecraft/util/math/random/Random;I)V")
    private boolean init(World instance, BlockPos pos, boolean move, Operation<Boolean> original) {
        BlockState blockState = instance.getBlockState(pos);
        if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(LOGS_THAT_BURN, LOGS), Arrays.asList(STRIPPED_LOGS, NON_FLAMMABLE_WOOD, NATURAL_WOODS, STRIPPED_WOODS))) {
            instance.setBlockState(pos, Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_log")).getStateWithProperties(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(PLANKS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockState(pos, Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_planks")).getStateWithProperties(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(WOODEN_SLABS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockState(pos, Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_slab")).getStateWithProperties(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(STRIPPED_LOGS, LOGS_THAT_BURN))) {
            instance.setBlockState(pos, Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "stripped_charred_log")).getStateWithProperties(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(WOODEN_STAIRS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockState(pos, Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_stairs")).getStateWithProperties(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(WOODEN_FENCES), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockState(pos, Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_fence")).getStateWithProperties(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(NATURAL_WOODS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockState(pos, Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_wood")).getStateWithProperties(blockState));
            return true;
        } else if (ModBlockHelper.blockIsInTagCollection(blockState, Arrays.asList(STRIPPED_WOODS), Arrays.asList(NON_FLAMMABLE_WOOD))) {
            instance.setBlockState(pos, Registries.BLOCK.get(Identifier.of(EmbyTweaks.MOD_ID, "stripped_charred_wood")).getStateWithProperties(blockState));
            return true;
        } else {
            return original.call(instance, pos, move);
        }
    }
}
