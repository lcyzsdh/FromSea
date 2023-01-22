package lcyzsdh.fromsea;

import lcyzsdh.fromsea.blocks.FSBlockRegistry;
import lcyzsdh.fromsea.items.FSItemGroup;
import lcyzsdh.fromsea.items.FSItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("fromsea")
public class FromSea {
    public static final ItemGroup FSItemGroup = new FSItemGroup();

    public FromSea() {
        FSItemRegistry.FSITEM.register(FMLJavaModLoadingContext.get().getModEventBus());
        FSBlockRegistry.FSBLOCK.register(FMLJavaModLoadingContext.get().getModEventBus());
        //FSTileEntityRegistry.FSTILEENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
