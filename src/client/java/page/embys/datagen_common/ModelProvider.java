package page.embys.datagen_common;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import net.minecraft.client.data.*;

import net.minecraft.client.data.models.BlockModelGenerators;
import page.embys.EmbyTweaksClient;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;


public abstract class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    protected void generateBlockSetModels(BlockSet blockSet, BlockModelGenerators blockStateModelGenerator) {
        if (blockSet instanceof StoneBlockSet stoneBlockSet && EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet) != null) {
            blockStateModelGenerator.family(EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet).getBaseBlock()).generateFor(EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet));
        } else if (blockSet instanceof WoodBlockSet woodBlockSet && EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet) != null) {
            blockStateModelGenerator.family(EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet).getBaseBlock()).generateFor(EmbyTweaksClient.BLOCK_FAMILY_MAP.get(blockSet));
            blockStateModelGenerator.woodProvider(woodBlockSet.logBlock).logWithHorizontal(woodBlockSet.logBlock).wood(woodBlockSet.woodBlock);
            blockStateModelGenerator.woodProvider(woodBlockSet.strippedLogBlock).logWithHorizontal(woodBlockSet.strippedLogBlock).wood(woodBlockSet.strippedWoodBlock);
            blockStateModelGenerator.createHangingSign(woodBlockSet.strippedLogBlock, woodBlockSet.hangingSignBlock, woodBlockSet.wallHangingSignBlock);
            blockStateModelGenerator.createShelf(woodBlockSet.shelfBlock, woodBlockSet.strippedLogBlock);
        }
    }

    public String getName() {
        return this.getClass().getName();
    }
}
