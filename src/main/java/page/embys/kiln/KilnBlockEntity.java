package page.embys.kiln;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import page.embys.EmbyTweaks;

public class KilnBlockEntity extends AbstractFurnaceBlockEntity {
    public KilnBlockEntity(BlockPos pos, BlockState state) {
        super(KilnMain.KILN_BLOCK_ENTITY, pos, state, KilnMain.KILN_RECIPE_TYPE);
    }

    @Override
    protected int getBurnDuration(FuelValues fuelRegistry, ItemStack stack) {
        return super.getBurnDuration(fuelRegistry, stack) / 2;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container." + EmbyTweaks.MOD_ID + ".kiln");
    }

    @Override
    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return new KilnScreenHandler(syncId, playerInventory, this, this.dataAccess);
    }
}
