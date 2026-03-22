package page.embys.common;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import page.embys.EmbyTweaks;

import java.util.Collection;
import java.util.HashMap;

public class BlockSetRegistry {
    private final HashMap<Identifier, BlockSet> blockSets = new HashMap<>();

    public void register(Identifier identifier, BlockSet blockSet) {
        blockSets.put(identifier, blockSet);
    }

    public BlockSet getBlockSet(String name) {
        return blockSets.get(Identifier.of(EmbyTweaks.MOD_ID, name));
    }

    public Collection<BlockSet> getBlockSets() {
        return blockSets.values();
    }
}
