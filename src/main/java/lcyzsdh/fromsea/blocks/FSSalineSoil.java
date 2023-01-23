package lcyzsdh.fromsea.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class FSSalineSoil extends Block {
    public FSSalineSoil(){
        super(Properties.copy(Blocks.STONE));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(!world.isClientSide){
            BlockPos abovePos = pos.above();
            BlockState blockState=world.getBlockState(abovePos);
            Block blockAbove=blockState.getBlock();
            if(blockAbove.equals(Blocks.GLASS)){
                //TODO:to be down
                //System.out.println(123);
            }
        }
    }
}
