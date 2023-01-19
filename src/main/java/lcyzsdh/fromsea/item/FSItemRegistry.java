package lcyzsdh.fromsea.item;

import lcyzsdh.fromsea.FromSea;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FSItemRegistry {
    public static final DeferredRegister<Item> FSITEM = DeferredRegister.create(ForgeRegistries.ITEMS,"fromsea");
    public static final RegistryObject<Item> FISHWET = FSITEM.register("fishwet",FSItemFishWet::new);

    //materials
    public static final RegistryObject<Item> SALT=FSITEM.register("salt",FSBasicItem::new);

    //调味料
    public static final RegistryObject<Item> VINEGAR=FSITEM.register("vinegar",()->new Item(new Item.Properties().tab(FromSea.FSItemGroup).food(FSFoodItem.VINEGAR)));
    public static final RegistryObject<Item> SAUCE=FSITEM.register("sauce",()->new Item(new Item.Properties().tab(FromSea.FSItemGroup).food(FSFoodItem.SAUCE)));
    public static final RegistryObject<Item> FISH_SAUCE=FSITEM.register("fish-sauce",()->new Item(new Item.Properties().tab(FromSea.FSItemGroup).food(FSFoodItem.FISH_SAUCE)));


}
