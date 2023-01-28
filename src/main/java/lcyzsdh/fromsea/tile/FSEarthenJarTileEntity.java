package lcyzsdh.fromsea.tile;

import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.tile.container.EarthenJarContainer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class FSEarthenJarTileEntity extends TileEntity  implements ITickableTileEntity, INamedContainerProvider {
    private int count=0;//test

    private Inventory testInv=new Inventory(5);
    private IIntArray jarData;
    private int workTime;
    private int workTimeTotal;

    public FSEarthenJarTileEntity() {
        super(FSTileEntityRegistry.EARTHEN_JAR_TILE_ENTITY.get());
        this.jarData=createRestTime();
    }

    private IIntArray createRestTime() {
        return new IIntArray() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0:
                        return FSEarthenJarTileEntity.this.workTime;
                    case 1:
                        return FSEarthenJarTileEntity.this.workTimeTotal;
                    default:
                        return 0;
                }
            }

            @Override
            public void set(int index, int value) {

                switch (index){
                    case 0:
                        FSEarthenJarTileEntity.this.workTime=value;
                        break;
                    case 1:
                        FSEarthenJarTileEntity.this.workTimeTotal=value;
                        break;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.putInt("count",count);//text
        return super.save(nbt);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        count=nbt.getInt("count");//text
        super.load(state, nbt);
    }

    @Override
    public void tick() {
        if(!level.isClientSide){

            //TODO:test
            this.jarData.set(0,10);
        }
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("gui."+ FromSea.MOD_ID+"earthen_jar_container");
    }

    @Nullable
    @Override
    public Container createMenu(int ID, PlayerInventory inventory, PlayerEntity player) {
        return new EarthenJarContainer(ID,inventory,this.worldPosition,this.level,this.jarData);
    }

    public Inventory getEarthenJarInv() {
        return testInv;
    }
}
