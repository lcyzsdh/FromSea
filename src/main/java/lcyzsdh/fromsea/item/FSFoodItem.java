package lcyzsdh.fromsea.item;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FSFoodItem {
    //调味料
    public static final Food VINEGAR=(new Food.Builder()).nutrition(1).saturationMod(0.1F).effect(()->new EffectInstance(Effects.CONFUSION,200,0),0.75F).build();
    public static final Food SAUCE =(new Food.Builder()).nutrition(1).saturationMod(0.2F).build();
    public static final Food FISH_SAUCE =(new Food.Builder()).nutrition(2).saturationMod(0.2F).build();

    //raw food
}
