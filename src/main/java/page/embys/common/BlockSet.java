package page.embys.common;

import net.minecraft.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.resources.Identifier;
import page.embys.EmbyTweaks;

public abstract class BlockSet {
    private boolean uvLocked = false;
    public abstract Identifier getIdentifier();

    public BlockSet isUvLocked() {
        uvLocked = true;
        return this;
    }

    public boolean getUvLocked() {
        return this.uvLocked;
    }
}
