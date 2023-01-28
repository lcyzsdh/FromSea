package lcyzsdh.fromsea.crafting;

import lcyzsdh.fromsea.FromSea;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FSRecipeSerializerRegistry {
    public static final DeferredRegister<IRecipeSerializer<?>> FSRECIPE_SERIALIZER=DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FromSea.MOD_ID);
    public static final RegistryObject<IRecipeSerializer<?>> FERMENTING=FSRECIPE_SERIALIZER.register("fermenting",FSEarthenJarRecipe.Serilizer::new);
}
