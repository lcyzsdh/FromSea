package lcyzsdh.fromsea;

import lcyzsdh.fromsea.blocks.FSBlockRegistry;
import lcyzsdh.fromsea.crafting.FSRecipeSerializerRegistry;
import lcyzsdh.fromsea.items.FSItemGroup;
import lcyzsdh.fromsea.items.FSItemRegistry;
import lcyzsdh.fromsea.tile.FSTileEntityRegistry;
import lcyzsdh.fromsea.tile.container.FSContainerRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FromSea.MOD_ID)
public class FromSea {
    public static final String MOD_ID="fromsea";
    public static final ItemGroup FSItemGroup = new FSItemGroup();

    public FromSea() {
        FSItemRegistry.FSITEM.register(FMLJavaModLoadingContext.get().getModEventBus());
        FSBlockRegistry.FSBLOCK.register(FMLJavaModLoadingContext.get().getModEventBus());
        FSTileEntityRegistry.FSTILEENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
        FSContainerRegistry.FSCONTAINERTYPE.register(FMLJavaModLoadingContext.get().getModEventBus());
        FSRecipeSerializerRegistry.FSRECIPE_SERIALIZER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
