package lcyzsdh.fromsea.blocks.tile.container;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FSContainerRegistry {
    public static final DeferredRegister<ContainerType<?>> FSCONTAINERTYPE=DeferredRegister.create(ForgeRegistries.CONTAINERS,"fromsea");

    public static final RegistryObject<ContainerType<EarthenJarContainer>> EARTHEN_JAR_CONTAINER=FSCONTAINERTYPE.register("earthen_jar_container",()-> IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data)->new EarthenJarContainer(windowId,inv,data.readBlockPos(), Minecraft.getInstance().level)));
}
