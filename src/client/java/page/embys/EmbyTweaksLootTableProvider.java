package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.HolderLookup;
import page.embys.common.BlockSet;
import page.embys.common.WoodBlockSet;
import page.embys.concrete_blocks.ConcreteBlockSets;
import page.embys.glazed_terracotta_blocks.GlazedTerracottaBlockSets;
import page.embys.kiln.KilnMain;
import page.embys.terracotta_blocks.TerracottaBlockSets;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class EmbyTweaksLootTableProvider extends FabricBlockLootTableProvider {
    public EmbyTweaksLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(KilnMain.KILN_BLOCK);

        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            if (blockSet instanceof WoodBlockSet woodBlockSet) {
                dropSelf(woodBlockSet.logBlock);
                dropSelf(woodBlockSet.woodBlock);
                dropSelf(woodBlockSet.strippedLogBlock);
                dropSelf(woodBlockSet.strippedWoodBlock);
                dropSelf(woodBlockSet.planksBlock);
                dropSelf(woodBlockSet.stairsBlock);
                dropSelf(woodBlockSet.slabBlock);
                dropSelf(woodBlockSet.fenceBlock);
                dropSelf(woodBlockSet.fenceGateBlock);
                dropSelf(woodBlockSet.doorBlock);
                dropSelf(woodBlockSet.trapdoorBlock);
                dropSelf(woodBlockSet.pressurePlateBlock);
                dropSelf(woodBlockSet.buttonBlock);
            }
        }

    }


}
