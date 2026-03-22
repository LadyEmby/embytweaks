package page.embys.datagen_common;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import page.embys.common.BlockSet;
import page.embys.common.StoneBlockSet;
import page.embys.common.WoodBlockSet;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public abstract class EnglishTranslationProvider extends FabricLanguageProvider {
    public EnglishTranslationProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    protected void generateBlockSetTranslations(BlockSet blockSet, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        String[] blockName = blockSet.getIdentifier().getPath().split("_");
        for (int i = 0; i < blockName.length; i++) {
            blockName[i] = blockName[i].substring(0, 1).toUpperCase() + blockName[i].substring(1);
        }
        String name = String.join(" ", blockName);

        if (blockSet instanceof WoodBlockSet woodBlockSet) {
            translationBuilder.add(woodBlockSet.logBlock, name + " Log");
            translationBuilder.add(woodBlockSet.woodBlock, name + " Wood");
            translationBuilder.add(woodBlockSet.strippedLogBlock, "Stripped " + name + " Log");
            translationBuilder.add(woodBlockSet.strippedWoodBlock, "Stripped " + name + " Wood");
            translationBuilder.add(woodBlockSet.planksBlock, name + " Planks");
            translationBuilder.add(woodBlockSet.stairsBlock, name + " Stairs");
            translationBuilder.add(woodBlockSet.slabBlock, name + " Slab");
            translationBuilder.add(woodBlockSet.fenceBlock, name + " Fence");
            translationBuilder.add(woodBlockSet.fenceGateBlock, name + " Fence Gate");
            translationBuilder.add(woodBlockSet.doorBlock, name + " Door");
            translationBuilder.add(woodBlockSet.trapdoorBlock, name + " Trapdoor");
            translationBuilder.add(woodBlockSet.pressurePlateBlock, name + " Pressure Plate");
            translationBuilder.add(woodBlockSet.buttonBlock, name + " Button");
        } else if (blockSet instanceof StoneBlockSet stoneBlockSet) {
            translationBuilder.add(stoneBlockSet.block, name);
            translationBuilder.add(stoneBlockSet.stairsBlock, name + " Stairs");
            translationBuilder.add(stoneBlockSet.slabBlock, name + " Slab");
            translationBuilder.add(stoneBlockSet.wallBlock, name + " Wall");
        }
    }

    public String getName() {
        return this.getClass().getName();
    }
}
