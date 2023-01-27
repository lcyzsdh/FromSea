package lcyzsdh.fromsea.init;

import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.client.gui.EarthenJarScreen;
import lcyzsdh.fromsea.tile.container.FSContainerRegistry;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = FromSea.MOD_ID,value = Dist.CLIENT,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventHandler {
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event){
        event.enqueueWork(()->{
            ScreenManager.register(FSContainerRegistry.EARTHEN_JAR_CONTAINER.get(), EarthenJarScreen::new);
        });
    }
}
