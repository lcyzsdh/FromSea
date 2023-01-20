package lcyzsdh.fromsea.items;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FSFoodItem {
    //tiaoweiliao
    public static final Food VINEGAR=(new Food.Builder()).nutrition(1).saturationMod(0.1F).effect(()->new EffectInstance(Effects.CONFUSION,200,0),0.75F).build();
    public static final Food SAUCE =(new Food.Builder()).nutrition(1).saturationMod(0.1F).build();
    public static final Food FISH_SAUCE =(new Food.Builder()).nutrition(1).saturationMod(0.2F).build();

    //fish
    public static final Food YELLOW_CROAKER =(new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final Food COOKED_YELLOW_CROAKER =(new Food.Builder()).nutrition(7).saturationMod(0.7F).build();
    public static final Food GRASS_CARP =(new Food.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final Food COOKED_GRASS_CARP =(new Food.Builder()).nutrition(5).saturationMod(0.7F).build();
    public static final Food POMFRET =(new Food.Builder()).nutrition(2).saturationMod(0.1F).build();//changyu
    public static final Food COOKED_POMFRET =(new Food.Builder()).nutrition(7).saturationMod(0.6F).build();



}
