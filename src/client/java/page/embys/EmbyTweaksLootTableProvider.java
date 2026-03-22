package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
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
    public EmbyTweaksLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(KilnMain.KILN_BLOCK);

        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            if (blockSet instanceof WoodBlockSet woodBlockSet) {
                addDrop(woodBlockSet.logBlock);
                addDrop(woodBlockSet.woodBlock);
                addDrop(woodBlockSet.strippedLogBlock);
                addDrop(woodBlockSet.strippedWoodBlock);
                addDrop(woodBlockSet.planksBlock);
                addDrop(woodBlockSet.stairsBlock);
                addDrop(woodBlockSet.slabBlock);
                addDrop(woodBlockSet.fenceBlock);
                addDrop(woodBlockSet.fenceGateBlock);
                addDrop(woodBlockSet.doorBlock);
                addDrop(woodBlockSet.trapdoorBlock);
                addDrop(woodBlockSet.pressurePlateBlock);
                addDrop(woodBlockSet.buttonBlock);
            }
        }

    }


}
