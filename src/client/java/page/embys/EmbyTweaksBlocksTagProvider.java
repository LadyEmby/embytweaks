package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import page.embys.charred_wood.CharredWoodMain;
import page.embys.common.BlockSet;
import page.embys.concrete_blocks.ConcreteBlockSets;
import page.embys.datagen_common.BlockTagProvider;
import page.embys.glazed_terracotta_blocks.GlazedTerracottaBlockSets;
import page.embys.kiln.KilnMain;
import page.embys.terracotta_blocks.TerracottaBlockSets;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class EmbyTweaksBlocksTagProvider extends BlockTagProvider {

    public EmbyTweaksBlocksTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            generateBlockSetTags(blockSet);
        }

        getOrCreateRawBuilder(TagKey.create(Registries.BLOCK, Identifier.parse("mineable/pickaxe")))
                .addElement(BuiltInRegistries.BLOCK.getKey(KilnMain.KILN_BLOCK));
    }
}
