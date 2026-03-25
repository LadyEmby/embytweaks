package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import org.jspecify.annotations.NonNull;
import page.embys.common.BlockSet;
import page.embys.common.WoodBlockSet;
import page.embys.datagen_common.ModelProvider;
import page.embys.kiln.KilnMain;

public class EmbyTweaksBlocksModelProvider extends ModelProvider {
    public EmbyTweaksBlocksModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createFurnace(KilnMain.KILN_BLOCK, TexturedModel.ORIENTABLE_ONLY_TOP);
        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            generateBlockSetModels(blockSet, blockStateModelGenerator);
        }
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerator) {
        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            if (blockSet instanceof WoodBlockSet woodBlockSet) {
                // door and sign item models are handled by the family generator in ModelProvider.generateBlockSetModels
                itemModelGenerator.generateFlatItem(woodBlockSet.boatItem.get(), ModelTemplates.FLAT_ITEM);
                itemModelGenerator.generateFlatItem(woodBlockSet.chestBoatItem.get(), ModelTemplates.FLAT_ITEM);
            }
        }
    }
}
