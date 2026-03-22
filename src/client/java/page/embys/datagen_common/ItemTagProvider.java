package page.embys.datagen_common;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jspecify.annotations.NonNull;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void generateBlockSetTags(BlockSet blockSet) {
        String toolType;
        if (blockSet instanceof StoneBlockSet stoneBlockSet) {
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("walls"))).add(Registries.ITEM.getId(stoneBlockSet.wallBlockItem));
        }
        if (blockSet instanceof WoodBlockSet woodBlockSet) {
            if (woodBlockSet.getIsFlammable()) {
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("logs_that_burn"))).add(Registries.ITEM.getId(woodBlockSet.logBlockItem));
            } else {
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.logBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.woodBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.strippedLogBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.strippedWoodBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.planksBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.fenceBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.fenceGateBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.doorBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.trapdoorBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.pressurePlateBlockItem));
                getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("non_flammable_wood"))).add(Registries.ITEM.getId(woodBlockSet.buttonBlockItem));
            }
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("logs"))).add(Registries.ITEM.getId(woodBlockSet.logBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("planks"))).add(Registries.ITEM.getId(woodBlockSet.planksBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("pressure_plates"))).add(Registries.ITEM.getId(woodBlockSet.pressurePlateBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("wooden_slabs"))).add(Registries.ITEM.getId(woodBlockSet.slabBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("wooden_stairs"))).add(Registries.ITEM.getId(woodBlockSet.stairsBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("wooden_fences"))).add(Registries.ITEM.getId(woodBlockSet.fenceBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("doors"))).add(Registries.ITEM.getId(woodBlockSet.doorBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("wooden_doors"))).add(Registries.ITEM.getId(woodBlockSet.doorBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("trapdoors"))).add(Registries.ITEM.getId(woodBlockSet.trapdoorBlockItem));
            getTagBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of("fence_gates"))).add(Registries.ITEM.getId(woodBlockSet.fenceGateBlockItem));
        }
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup wrapperLookup) {

    }
}
