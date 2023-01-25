package lcyzsdh.fromsea.blocks;

import lcyzsdh.fromsea.items.FSItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class FSSalineRiceCrop extends CropsBlock {
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D)
    };
    public FSSalineRiceCrop(){
        super(Properties.copy(Blocks.WHEAT));
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        return FSBlockRegistry.SALINE_RICE_CROP.get().defaultBlockState();
    }

    @Override
    protected IItemProvider getBaseSeedId() {
        return FSItemRegistry.SALINE_RICE_SEEDS.get();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }
}
