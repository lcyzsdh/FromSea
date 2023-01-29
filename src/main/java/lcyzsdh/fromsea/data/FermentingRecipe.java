package lcyzsdh.fromsea.data;

import lcyzsdh.fromsea.data.builder.FSEarthenJarRecipeBuilder;
import lcyzsdh.fromsea.items.FSItemRegistry;
import net.minecraft.data.IFinishedRecipe;

import java.util.function.Consumer;

public class FermentingRecipe {
    public static final int NORMAL_TIME=200;//test time
    public static void register(Consumer<IFinishedRecipe> consumer){
        //test recipe
        FSEarthenJarRecipeBuilder.fermentingRecipe(FSItemRegistry.COOKED_GRASS_CARP.get(),NORMAL_TIME,0.1F)
                .addIngredient(FSItemRegistry.GRASS_CARP.get())
                .build(consumer);
    }
}
