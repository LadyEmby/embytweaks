package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;
import page.embys.common.BlockSet;
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
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        itemModelGenerator.register(Registries.ITEM.get(Identifier.of(EmbyTweaks.MOD_ID, "charred_door")));
    }
}
