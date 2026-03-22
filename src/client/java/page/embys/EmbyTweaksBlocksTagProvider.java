package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
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

    public EmbyTweaksBlocksTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.@NonNull WrapperLookup wrapperLookup) {
        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            generateBlockSetTags(blockSet);
        }

        getTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("mineable/pickaxe")))
                .add(Registries.BLOCK.getId(KilnMain.KILN_BLOCK));
    }
}
