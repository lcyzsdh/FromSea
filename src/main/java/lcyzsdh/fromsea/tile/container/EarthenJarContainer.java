package lcyzsdh.fromsea.tile.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EarthenJarContainer extends Container {
    public EarthenJarContainer(final int windowId, final PlayerInventory playerInventory, final BlockPos pos, World world){
        super(FSContainerRegistry.EARTHEN_JAR_CONTAINER.get(),windowId);
    }
    @Override
    public boolean stillValid(PlayerEntity player) {
        return true;
    }
}
