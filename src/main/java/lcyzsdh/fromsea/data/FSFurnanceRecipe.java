package lcyzsdh.fromsea.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraftforge.common.data.ForgeRecipeProvider;

import java.util.function.Consumer;

public class FSFurnanceRecipe extends ForgeRecipeProvider {
    public FSFurnanceRecipe(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        //CookingRecipeBuilder.cooking(Ingredient.of())
    }
}
