package lcyzsdh.fromsea.tile.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FSContainerRegistry {
    public static final DeferredRegister<ContainerType<?>> FSCONTAINERTYPE=DeferredRegister.create(ForgeRegistries.CONTAINERS,"fromsea");

    public static final RegistryObject<ContainerType<EarthenJarContainer>> EARTHEN_JAR_CONTAINER=FSCONTAINERTYPE.register("earthen_jar_container",
            ()->IForgeContainerType.create(EarthenJarContainer::new));

}
