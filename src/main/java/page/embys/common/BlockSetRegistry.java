package page.embys.common;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import page.embys.EmbyTweaks;

import java.util.Collection;
import java.util.HashMap;

public class BlockSetRegistry {
    private final HashMap<Identifier, BlockSet> blockSets = new HashMap<>();

    public void register(Identifier identifier, BlockSet blockSet) {
        blockSets.put(identifier, blockSet);
    }

    public BlockSet getBlockSet(String name) {
        return blockSets.get(Identifier.fromNamespaceAndPath(EmbyTweaks.MOD_ID, name));
    }

    public Collection<BlockSet> getBlockSets() {
        return blockSets.values();
    }
}
