package lcyzsdh.fromsea.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Consumer;

public class FSRecipes extends ForgeRecipeProvider {
    public FSRecipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        FermentingRecipe.register(consumer);
    }
}
