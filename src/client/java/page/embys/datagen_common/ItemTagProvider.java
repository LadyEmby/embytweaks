package page.embys.datagen_common;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void generateBlockSetTags(BlockSet blockSet) {
        if (blockSet instanceof StoneBlockSet stoneBlockSet) {
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("walls"))).addElement(BuiltInRegistries.ITEM.getKey(stoneBlockSet.wallBlockItem));
        }
        if (blockSet instanceof WoodBlockSet woodBlockSet) {
            if (woodBlockSet.getIsFlammable()) {
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("logs_that_burn"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.logBlockItem));
            } else {
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.logBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.woodBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.strippedLogBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.strippedWoodBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.planksBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.fenceBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.fenceGateBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.doorBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.trapdoorBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.pressurePlateBlockItem));
                getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("non_flammable_wood"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.buttonBlockItem));
            }
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("logs"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.logBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("planks"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.planksBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("pressure_plates"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.pressurePlateBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("wooden_slabs"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.slabBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("wooden_stairs"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.stairsBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("wooden_fences"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.fenceBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("doors"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.doorBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("wooden_doors"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.doorBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("trapdoors"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.trapdoorBlockItem));
            getOrCreateRawBuilder(TagKey.create(Registries.ITEM, Identifier.parse("fence_gates"))).addElement(BuiltInRegistries.ITEM.getKey(woodBlockSet.fenceGateBlockItem));
        }
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {

    }
}
