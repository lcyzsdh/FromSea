package lcyzsdh.fromsea.blocks;

import lcyzsdh.fromsea.FromSea;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
@SuppressWarnings("unused")
public class FSBlockRegistry {
    public static final DeferredRegister<Block> FSBLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, FromSea.MOD_ID);

    public static final RegistryObject<Block> SHELL_WALL = FSBLOCK.register("shell_wall", () -> new Block(Block.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SALINE=FSBLOCK.register("saline_wall",FSSalineSoil::new);
    //TODO:Unknown mistakes
    /*public static final RegistryObject<Block> PALM_WALL = FSBLOCK.register("palm_wall", () -> new Block(Block.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> PALM_BLOCK = FSBLOCK.register("palm_block", () -> new Block(Block.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> STONE_POLE = FSBLOCK.register("stone_pole", () -> new Block(Block.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> BROAD_WALK = FSBLOCK.register("broad_walk", () -> new Block(Block.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> OIL_LAMP = FSBLOCK.register("oil_lamp", () -> new Block(Block.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> STONE_OIL_LAMP = FSBLOCK.register("stone_oil_lamp", () -> new Block(Block.Properties.copy(Blocks.STONE)));
*/
    public static final RegistryObject<Block> EARTHEN_JAR = FSBLOCK.register("earthen_jar", FSEarthenJar::new);

    //crop
    public static final RegistryObject<Block> SALINE_RICE_CROP=FSBLOCK.register("saline_rice",FSSalineRiceCrop::new);
}
