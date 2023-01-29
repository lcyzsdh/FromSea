package lcyzsdh.fromsea.data;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataRegistry {
    @SubscribeEvent
    public static void dataGen(GatherDataEvent event){
        event.getGenerator().addProvider(new FSLangUS(event.getGenerator()));
        event.getGenerator().addProvider(new FSLangCN(event.getGenerator()));
        event.getGenerator().addProvider(new FSItemModel(event.getGenerator(),event.getExistingFileHelper()));
        event.getGenerator().addProvider(new FSRecipes(event.getGenerator()));
    }
}
