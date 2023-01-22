package lcyzsdh.fromsea.blocks;

//import lcyzsdh.fromsea.blocks.tile.FSEarthenJarTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class FSEarthenJar extends Block {
    public FSEarthenJar() {
        super(Properties.copy(Blocks.STONE));
    }
/*
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new FSEarthenJarTileEntity();
    }

    @Override
    public ActionResultType use(BlockState blockState, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if(!world.isClientSide&&hand==Hand.MAIN_HAND){
            FSEarthenJarTileEntity tile = (FSEarthenJarTileEntity) world.getBlockEntity(pos);
            NetworkHooks.openGui((ServerPlayerEntity) player,tile,pos);
        }
        return ActionResultType.SUCCESS;
    }*/
}
