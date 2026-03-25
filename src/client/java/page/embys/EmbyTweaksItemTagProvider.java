package page.embys;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;
import page.embys.common.BlockSet;
import page.embys.datagen_common.ItemTagProvider;

import java.util.concurrent.CompletableFuture;

public class EmbyTweaksItemTagProvider extends ItemTagProvider {

    public EmbyTweaksItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        for (BlockSet blockSet : EmbyTweaks.BLOCK_SET_REGISTRY.getBlockSets()) {
            generateBlockSetTags(blockSet);
        }
    }
}
