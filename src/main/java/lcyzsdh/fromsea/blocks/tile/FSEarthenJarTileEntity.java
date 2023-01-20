package lcyzsdh.fromsea.blocks.tile;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class FSEarthenJarTileEntity extends TileEntity implements INamedContainerProvider {
    public FSEarthenJarTileEntity() {
        super(FSTileEntityRegistry.EARTHEN_JAR_TILE_ENTITY.get());
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("gui.fromsea.earthen_jar_container");
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return null;
    }
}
