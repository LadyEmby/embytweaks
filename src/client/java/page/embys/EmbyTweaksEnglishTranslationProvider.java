package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;
import page.embys.charred_wood.CharredWoodMain;
import page.embys.common.BlockSet;
import page.embys.concrete_blocks.ConcreteBlockSets;
import page.embys.datagen_common.EnglishTranslationProvider;
import page.embys.glazed_terracotta_blocks.GlazedTerracottaBlockSets;
import page.embys.kiln.KilnMain;
import page.embys.terracotta_blocks.TerracottaBlockSets;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class EmbyTweaksEnglishTranslationProvider extends EnglishTranslationProvider {
    public EmbyTweaksEnglishTranslationProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider wrapperLookup, @NonNull TranslationBuilder translationBuilder) {
        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            generateBlockSetTranslations(blockSet, translationBuilder);
        }

        translationBuilder.add(KilnMain.KILN_BLOCK, "Kiln");
        translationBuilder.add("container.emby_tweaks.kiln", "Kiln");
    }
}

