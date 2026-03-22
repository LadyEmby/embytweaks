package page.embys.common;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
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
