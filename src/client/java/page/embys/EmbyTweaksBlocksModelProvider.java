package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
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
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCooker(KilnMain.KILN_BLOCK, TexturedModel.ORIENTABLE);
        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            generateBlockSetModels(blockSet, blockStateModelGenerator);
        }
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerator itemModelGenerator) {
        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            if (blockSet instanceof WoodBlockSet woodBlockSet) {
                // door and sign item models are handled by the family generator in ModelProvider.generateBlockSetModels
                itemModelGenerator.register(woodBlockSet.boatItem.get(), Models.GENERATED);
                itemModelGenerator.register(woodBlockSet.chestBoatItem.get(), Models.GENERATED);
            }
        }
    }
}
