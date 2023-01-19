package lcyzsdh.fromsea;

import lcyzsdh.fromsea.item.FSItemGroup;
import lcyzsdh.fromsea.item.FSItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("fromsea")
public class FromSea {
    public static final ItemGroup FSItemGroup = new FSItemGroup();
    public FromSea(){
        FSItemRegistry.FSITEM.register(FMLJavaModLoadingContext.get().getModEventBus());

    }
}
