package lcyzsdh.fromsea.tile;

import lcyzsdh.fromsea.blocks.FSBlockRegistry;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FSTileEntityRegistry {
    public static final DeferredRegister<TileEntityType<?>> FSTILEENTITY= DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,"fromsea");

    public static final RegistryObject<TileEntityType<FSEarthenJarTileEntity>> EARTHEN_JAR_TILE_ENTITY=FSTILEENTITY.register("earthen_jar_tileentity",()-> TileEntityType.Builder.of(FSEarthenJarTileEntity::new, FSBlockRegistry.EARTHEN_JAR.get()).build(null));
}
