package page.embys.datagen_common;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;
import page.embys.EmbyTweaks;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public abstract class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void generateBlockSetTags(BlockSet blockSet) {
        if (blockSet instanceof StoneBlockSet stoneBlockSet) {
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("mineable/pickaxe"))).addElement(BuiltInRegistries.BLOCK.getKey(stoneBlockSet.wallBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("walls"))).addElement(BuiltInRegistries.BLOCK.getKey(stoneBlockSet.wallBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("stairs"))).addElement(BuiltInRegistries.BLOCK.getKey(stoneBlockSet.stairsBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("mineable/pickaxe"))).addElement(BuiltInRegistries.BLOCK.getKey(stoneBlockSet.slabBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("mineable/pickaxe"))).addElement(BuiltInRegistries.BLOCK.getKey(stoneBlockSet.stairsBlock));
        }
        if (blockSet instanceof WoodBlockSet woodBlockSet) {
            if (woodBlockSet.getIsFlammable()) {
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("logs_that_burn"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.logBlock));
            } else {
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.logBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.woodBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.strippedLogBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.strippedWoodBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.planksBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.fenceBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.fenceGateBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.doorBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.trapdoorBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.pressurePlateBlock));
                getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.buttonBlock));
            }
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("logs"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.logBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("planks"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.planksBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("pressure_plates"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.pressurePlateBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("wooden_slabs"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.slabBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("wooden_stairs"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.stairsBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("wooden_fences"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.fenceBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("mineable/axe"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.fenceBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("doors"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.doorBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("wooden_doors"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.doorBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("trapdoors"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.trapdoorBlock));
            getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("fence_gates"))).addElement(BuiltInRegistries.BLOCK.getKey(woodBlockSet.fenceGateBlock));
        }
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
