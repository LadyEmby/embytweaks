package page.embys.common;

import net.minecraft.resources.Identifier;

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
