package page.embys.datagen_common;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import page.embys.EmbyTweaks;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public abstract class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void generateBlockSetTags(BlockSet blockSet) {
        if (blockSet instanceof StoneBlockSet stoneBlockSet) {
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("mineable/pickaxe"))).add(Registries.BLOCK.getId(stoneBlockSet.wallBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("walls"))).add(Registries.BLOCK.getId(stoneBlockSet.wallBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("stairs"))).add(Registries.BLOCK.getId(stoneBlockSet.stairsBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("mineable/pickaxe"))).add(Registries.BLOCK.getId(stoneBlockSet.slabBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("mineable/pickaxe"))).add(Registries.BLOCK.getId(stoneBlockSet.stairsBlock));
        }
        if (blockSet instanceof WoodBlockSet woodBlockSet) {
            if (woodBlockSet.getIsFlammable()) {
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("logs_that_burn"))).add(Registries.BLOCK.getId(woodBlockSet.logBlock));
            } else {
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.logBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.woodBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.strippedLogBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.strippedWoodBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.planksBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.fenceBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.fenceGateBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.doorBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.trapdoorBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.pressurePlateBlock));
                getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("non_flammable_wood"))).add(Registries.BLOCK.getId(woodBlockSet.buttonBlock));
            }
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("logs"))).add(Registries.BLOCK.getId(woodBlockSet.logBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("planks"))).add(Registries.BLOCK.getId(woodBlockSet.planksBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("pressure_plates"))).add(Registries.BLOCK.getId(woodBlockSet.pressurePlateBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("wooden_slabs"))).add(Registries.BLOCK.getId(woodBlockSet.slabBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("wooden_stairs"))).add(Registries.BLOCK.getId(woodBlockSet.stairsBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("wooden_fences"))).add(Registries.BLOCK.getId(woodBlockSet.fenceBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("mineable/axe"))).add(Registries.BLOCK.getId(woodBlockSet.fenceBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("doors"))).add(Registries.BLOCK.getId(woodBlockSet.doorBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("wooden_doors"))).add(Registries.BLOCK.getId(woodBlockSet.doorBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("trapdoors"))).add(Registries.BLOCK.getId(woodBlockSet.trapdoorBlock));
            getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fence_gates"))).add(Registries.BLOCK.getId(woodBlockSet.fenceGateBlock));
        }
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
