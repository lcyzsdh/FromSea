package lcyzsdh.fromsea.tile.container;

import lcyzsdh.fromsea.tile.FSEarthenJarTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
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
        this.addDataSlots(this.jarData);
        //this.addSlot(new Slot(tile.getEarthenJarInv(),0,80,32));
        layoutPlayerInventorySlots(playerInventory,8,84);//From Boson
        layoutModInventorySlots(tile.getEarthenJarInv(),0,60,32);
    }

    private void layoutModInventorySlots(Inventory inv, int index, int leftCol, int topRow) {
        addSlotLine(inv,index,leftCol,topRow,3,18);
        addSlot(new EarthenJarResultSlot(inv,index,leftCol+18*3+1,topRow));
    }

    private int addSlotLine(IInventory inv, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new Slot(inv, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotGroup(IInventory inventory, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0; j < verAmount; j++) {
            index = addSlotLine(inventory, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(PlayerInventory inv, int leftCol, int topRow) {
        // Player inventory
        addSlotGroup(inv, 9, leftCol, topRow, 9, 18, 3, 18);
        // Hotbar
        topRow += 58;
        addSlotLine(inv, 0, leftCol, topRow, 9, 18);
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
