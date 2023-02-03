package lcyzsdh.fromsea.tile.container;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class EarthenJarResultSlot extends SlotItemHandler {
    public EarthenJarResultSlot(ItemStackHandler inv, int index, int x, int y) {
        super(inv, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack itemStack) {
        return false;
    }
}
