package lcyzsdh.fromsea.tile.container;

import lcyzsdh.fromsea.blocks.FSBlockRegistry;
import lcyzsdh.fromsea.tile.FSEarthenJarTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class EarthenJarContainer extends Container {
    public static final int MATERIAL_SLOT_NUMBER=3;
    public static final int RESULT_SLOT_NUMBER=1;
    public final FSEarthenJarTileEntity tile;
    public final ItemStackHandler inventory;
    private final IIntArray jarData;
    private final IWorldPosCallable worldPosCallable;

    public EarthenJarContainer(int windowId, PlayerInventory playerInventory, final BlockPos pos, World world,IIntArray jarDataIn){
        super(FSContainerRegistry.EARTHEN_JAR_CONTAINER.get(),windowId);
        this.tile= (FSEarthenJarTileEntity) world.getBlockEntity(pos);
        this.inventory=tile.getEarthenJarInv();
        this.jarData=jarDataIn;
        this.addDataSlots(this.jarData);
        this.worldPosCallable=IWorldPosCallable.create(world,pos);
        //TODO:fix the position
        layoutPlayerInventorySlots(playerInventory,8,84);
        layoutModInventorySlots(tile.getEarthenJarInv(),0,60,32);
    }

    private void layoutModInventorySlots(ItemStackHandler inv, int index, int leftCol, int topRow) {
        addSlotLine(inv,index,leftCol,topRow,3,18);
        addSlot(new EarthenJarResultSlot(inv,index,leftCol+18*3+1,topRow));
    }

    private int addSlotLine(ItemStackHandler inv, int index, int x, int y, int amount, int dx) {
        for (int i = 0; i < amount; i++) {
            addSlot(new SlotItemHandler(inv, index, x, y));
            x += dx;
            index++;
        }
        return index;
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
    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        return ItemStack.EMPTY;
        /*Slot slot=this.slots.get(index);
        if(slot!=null&&slot.hasItem()){
            ItemStack itemStack=slot.getItem();

        }*/
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return stillValid(worldPosCallable,player, FSBlockRegistry.EARTHEN_JAR.get());
    }

    @OnlyIn(Dist.CLIENT)
    public int getFermentProccession(){
        int nowTime=jarData.get(0);
        int totalTime=jarData.get(1);
        return (totalTime!=0&&nowTime!=0)?nowTime/totalTime:0;
    }
}
