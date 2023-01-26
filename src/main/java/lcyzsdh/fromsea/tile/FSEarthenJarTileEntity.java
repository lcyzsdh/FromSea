package lcyzsdh.fromsea.tile;

import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.tile.container.EarthenJarContainer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class FSEarthenJarTileEntity extends TileEntity  implements ITickableTileEntity, INamedContainerProvider {
    private int count=0;//test
    private int time=0;
    public FSEarthenJarTileEntity() {
        super(FSTileEntityRegistry.EARTHEN_JAR_TILE_ENTITY.get());
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
        if(level!=null&&!level.isClientSide){
            if(time==100){
                PlayerEntity player=level.getNearestPlayer(worldPosition.getX(),worldPosition.getY(),worldPosition.getZ(),10,false);
                StringTextComponent textComponent=new StringTextComponent("233");//test
                if(player!=null){
                    player.displayClientMessage(textComponent,false);
                }
                time=0;
            }
            time++;
        }
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("gui."+ FromSea.MOD_ID+"earthen_jar_container");
    }

    @Nullable
    @Override
    public Container createMenu(int ID, PlayerInventory inventory, PlayerEntity player) {
        return new EarthenJarContainer(ID,inventory,this.worldPosition,this.level);
    }
}
