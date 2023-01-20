package lcyzsdh.fromsea.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FSBlockRegistry {
    public static final DeferredRegister<Block> FSBLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, "fromsea");

    public static final RegistryObject<Block> SHELL_WALL = FSBLOCK.register("shell_wall", () -> new Block(Block.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> EARTHEN_JAR = FSBLOCK.register("earthen_jar", FSEarthenJar::new);

}
