package lcyzsdh.fromsea.items;

import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.blocks.FSBlockRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FSItemRegistry {
    public static final DeferredRegister<Item> FSITEM = DeferredRegister.create(ForgeRegistries.ITEMS, FromSea.MOD_ID);
    public static final RegistryObject<Item> FISHWET = FSITEM.register("fishwet", FSItemFishWet::new);
    private static final ItemGroup GROUP = FromSea.FSItemGroup;

    //materials
    public static final RegistryObject<Item> SALT = FSITEM.register("salt", () -> new Item(new Item.Properties().tab(GROUP)));

    //调味料
    public static final RegistryObject<Item> VINEGAR = FSITEM.register("vinegar", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.VINEGAR)));
    public static final RegistryObject<Item> SAUCE = FSITEM.register("sauce", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.SAUCE)));
    public static final RegistryObject<Item> FISH_SAUCE = FSITEM.register("fish_sauce", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.FISH_SAUCE)));

    //fish
    public static final RegistryObject<Item> YELLOW_CROAKER = FSITEM.register("yellow_croaker", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.YELLOW_CROAKER)));
    public static final RegistryObject<Item> COOKED_YELLOW_CROAKER = FSITEM.register("cooked_yellow_croaker", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.COOKED_YELLOW_CROAKER)));
    public static final RegistryObject<Item> GRASS_CARP = FSITEM.register("grass_carp", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.GRASS_CARP)));
    public static final RegistryObject<Item> COOKED_GRASS_CARP = FSITEM.register("cooked_grass_carp", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.COOKED_GRASS_CARP)));
    public static final RegistryObject<Item> POMFRET = FSITEM.register("pomfret", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.POMFRET)));
    public static final RegistryObject<Item> COOKED_POMFRET = FSITEM.register("cooked_pomfret", () -> new Item(new Item.Properties().tab(GROUP).food(FSFoodItem.COOKED_POMFRET)));

    //block
    public static final RegistryObject<Item> SHELL_WALL = FSITEM.register("shell_wall", () -> new BlockItem(FSBlockRegistry.SHELL_WALL.get(), new Item.Properties().tab(GROUP)));
    //public static final RegistryObject<Item> EARTHEN_JAR = FSITEM.register("earthen_jar", () -> new BlockItem(FSBlockRegistry.EARTHEN_JAR.get(), new Item.Properties().tab(GROUP)));
}
