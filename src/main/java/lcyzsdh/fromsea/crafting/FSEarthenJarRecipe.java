package lcyzsdh.fromsea.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import lcyzsdh.fromsea.FromSea;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class FSEarthenJarRecipe implements IRecipe<RecipeWrapper> {
    public static IRecipeType<FSEarthenJarRecipe> TYPE = IRecipeType.register(FromSea.MOD_ID+"fermenting");

    private final ResourceLocation id;
    private final String group;
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final float experience;
    private final int fermentTime;

    public FSEarthenJarRecipe(ResourceLocation id, String group, NonNullList<Ingredient> inputItems, ItemStack output, float experience, int fermentTime) {
        this.id=id;
        this.group=group;
        this.fermentTime=fermentTime;
        this.inputItems = inputItems;
        this.output = output;
        this.experience = experience;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    public float getExperience() {
        return this.experience;
    }

    public int getFermentTime() {
        return this.fermentTime;
    }
    @Override
    public boolean matches(RecipeWrapper inv, World world) {
        List<ItemStack> inputs=new ArrayList<>();
        int num=0;
        for(int j=0;j<3;j++){
            ItemStack itemStack=inv.getItem(j);
            if(!itemStack.isEmpty()){
                num++;
                inputs.add(itemStack);
            }
        }
        return num==this.inputItems.size()&& RecipeMatcher.findMatches(inputs,this.inputItems)!=null;
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv) {
        return this.output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width*height>=this.inputItems.size();
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return FSRecipeSerializerRegistry.FERMENTING.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return FSEarthenJarRecipe.TYPE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Serilizer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<FSEarthenJarRecipe>{

        @Override
        public FSEarthenJarRecipe fromJson(ResourceLocation recipeID, JsonObject json) {
            final String group= JSONUtils.getAsString(json,"group","");
            final NonNullList<Ingredient> inputItems=read(JSONUtils.getAsJsonArray(json,"ingredients"));
            if(inputItems.isEmpty()){
                throw new JsonParseException("No ferment recipes!");
            }
            else if (inputItems.size()>3){
                throw new JsonParseException("Too many ingredients,the max is 3!");
            }
            else {
                final ItemStack output= CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json,"result"),true);
                final float experience = JSONUtils.getAsFloat(json, "experience", 0.0F);
                final int fermentTime = JSONUtils.getAsInt(json, "fermenttime", 200);
                return new FSEarthenJarRecipe(recipeID,group,inputItems,output,experience,fermentTime);
            }
        }
        private static NonNullList<Ingredient> read(JsonArray array){
            NonNullList<Ingredient> list=NonNullList.create();
            for(int i=0;i<array.size();i++){
                Ingredient ingredient=Ingredient.fromJson(array.get(i));
                if(!ingredient.isEmpty()){
                    list.add(ingredient);
                }
            }
            return list;
        }

        @Nullable
        @Override
        public FSEarthenJarRecipe fromNetwork(ResourceLocation recipeID, PacketBuffer buffer) {
            String group = buffer.readUtf(32767);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItems = NonNullList.withSize(i, Ingredient.EMPTY);
            for (int j = 0; j < inputItems.size(); ++j) {
                inputItems.set(j, Ingredient.fromNetwork(buffer));
            }
            ItemStack output = buffer.readItem();
            float experience = buffer.readFloat();
            int fermentTime = buffer.readVarInt();
            return new FSEarthenJarRecipe(recipeID,group,inputItems,output,experience,fermentTime);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, FSEarthenJarRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeVarInt(recipe.inputItems.size());
            for (Ingredient ingredient : recipe.inputItems) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItem(recipe.output);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.fermentTime);
        }
    }
}
