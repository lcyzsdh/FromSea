package lcyzsdh.fromsea.init;

import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.items.FSItemRegistry;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FromSea.MOD_ID)
public class CommonEventHandler {
    @SubscribeEvent
    public static void fishLootRegistry(LootTableLoadEvent event) {
        ResourceLocation name = event.getName();
        if (name.equals(LootTables.FISHING_FISH)) {
            ConstantRange rang = new ConstantRange(1);
            //TODO: more fish to be added
            LootPool pool = new LootPool.Builder().setRolls(rang).add(ItemLootEntry.lootTableItem(FSItemRegistry.POMFRET.get()).setQuality(-2).setWeight(30)).build();
            event.getTable().addPool(pool);
        }
    }
}
