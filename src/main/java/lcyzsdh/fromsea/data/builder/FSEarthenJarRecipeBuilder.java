package lcyzsdh.fromsea.data.builder;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.crafting.FSEarthenJarRecipe;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class FSEarthenJarRecipeBuilder {
    private final List<Ingredient> ingredients = Lists.newArrayList();
    private final Item result;
    private final float experience;
    private final int fermentTime;

    private FSEarthenJarRecipeBuilder(IItemProvider result, int fermentTime, float experience) {
        this.result = result.asItem();
        this.fermentTime = fermentTime;
        this.experience = experience;
    }

    public static FSEarthenJarRecipeBuilder fermentingRecipe(IItemProvider result, int fermentTime, float experience) {
        return new FSEarthenJarRecipeBuilder(result, fermentTime, experience);
    }

    public FSEarthenJarRecipeBuilder addIngredient(IItemProvider item) {
        return this.addIngredient(Ingredient.of(item));
    }

    public FSEarthenJarRecipeBuilder addIngredient(ITag<Item> item) {
        return this.addIngredient(Ingredient.of(item));
    }

    public FSEarthenJarRecipeBuilder addIngredient(Ingredient item) {
        this.ingredients.add(item);
        return this;
    }
    public void build(Consumer<IFinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(result);
        build(consumerIn, FromSea.MOD_ID + ":fermenting/" + location.getPath());
    }
    public void build(Consumer<IFinishedRecipe> consumerIn, String loc) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(result);
        if ((new ResourceLocation(loc)).equals(resourcelocation)) {
            throw new IllegalStateException("Cooking Recipe " + loc + " should remove its 'save' argument");
        } else {
            build(consumerIn, new ResourceLocation(loc));
        }
    }
    public void build(Consumer<IFinishedRecipe> consumer,ResourceLocation location){
        consumer.accept(new Result(location,this.ingredients,this.result,this.experience,this.fermentTime));
    }

    public static class Result implements IFinishedRecipe{
        private final ResourceLocation id;
        private final List<Ingredient> inputItems;
        private final Item output;
        private final float experience;
        private final int fermentTime;

        public Result(ResourceLocation id, List<Ingredient> inputItems, Item output, float experience, int fermentTime) {
            this.id = id;
            this.inputItems = inputItems;
            this.output = output;
            this.experience = experience;
            this.fermentTime = fermentTime;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray ingredients = new JsonArray();

            for (Ingredient ingredient : this.inputItems) {
                ingredients.add(ingredient.toJson());
            }
            json.add("ingredients", ingredients);
            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(this.output).toString());
            json.add("result", objectResult);
            if (this.experience > 0) {
                json.addProperty("experience", this.experience);
            }
            json.addProperty("fermenttime", this.fermentTime);

        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public IRecipeSerializer<?> getType() {
            return FSEarthenJarRecipe.SERILIZER;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
