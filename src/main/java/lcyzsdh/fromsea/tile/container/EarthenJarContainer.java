package lcyzsdh.fromsea.tile.container;

import lcyzsdh.fromsea.tile.FSEarthenJarTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EarthenJarContainer extends Container {
    public final FSEarthenJarTileEntity tile;
    //public final ItemStackHandler inventory;
    private final IIntArray jarData;
    public EarthenJarContainer(int windowId, PlayerInventory playerInventory, final BlockPos pos, World world,IIntArray jarDataIn){
        super(FSContainerRegistry.EARTHEN_JAR_CONTAINER.get(),windowId);
        this.tile= (FSEarthenJarTileEntity) world.getBlockEntity(pos);
        //this.inventory=tileIn.;
        this.jarData=jarDataIn;
        this.addDataSlots(jarData);
        this.addSlot(new Slot(tile.getTestInv(),0,80,32));
        layoutPlayerInventorySlots(playerInventory,8,84);//From Boson

    }

    private int addSlotRange(IInventory inventory, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new Slot(inventory, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IInventory inventory, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; j++) {
            index = addSlotRange(inventory, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(PlayerInventory inventory, int leftCol, int topRow) {
        // Player inventory
        addSlotBox(inventory, 9, leftCol, topRow, 9, 18, 3, 18);
        // Hotbar
        topRow += 58;
        addSlotRange(inventory, 0, leftCol, topRow, 9, 18);
    }

    public EarthenJarContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId,playerInventory,data.readBlockPos(), Minecraft.getInstance().level, new IntArray(2));
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        //TODO: judge the distance
        return true;
    }

    public IIntArray getJarData() {
        return jarData;
    }

}
