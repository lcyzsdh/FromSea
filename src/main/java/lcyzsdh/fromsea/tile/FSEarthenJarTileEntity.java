package lcyzsdh.fromsea.tile;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.crafting.FSEarthenJarRecipe;
import lcyzsdh.fromsea.tile.container.EarthenJarContainer;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class FSEarthenJarTileEntity extends TileEntity  implements ITickableTileEntity, INamedContainerProvider, IRecipeHolder {
    private final Object2IntOpenHashMap<ResourceLocation> usedRecipe=new Object2IntOpenHashMap<>();

    private final LazyOptional<IItemHandler> itemHandler;//output item
    private final ItemStackHandler jarInventory;
    private final IIntArray jarData;
    private int workTime;
    private int workTimeTotal;

    public FSEarthenJarTileEntity() {
        super(FSTileEntityRegistry.EARTHEN_JAR_TILE_ENTITY.get());
        this.jarInventory = createHandler();
        itemHandler =LazyOptional.of(ItemStackHandler::new);
        this.jarData= createJarData();
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(4);
    }

    private IIntArray createJarData() {
        return new IIntArray() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0:
                        return FSEarthenJarTileEntity.this.workTime;
                    case 1:
                        return FSEarthenJarTileEntity.this.workTimeTotal;
                    default:
                        return 0;
                }
            }

            @Override
            public void set(int index, int value) {

                switch (index){
                    case 0:
                        FSEarthenJarTileEntity.this.workTime=value;
                        break;
                    case 1:
                        FSEarthenJarTileEntity.this.workTimeTotal=value;
                        break;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        nbt.putInt("fermentTime",this.workTime);
        nbt.putInt("fermentTimeToal",this.workTimeTotal);
        CompoundNBT recipes=new CompoundNBT();
        this.usedRecipe.forEach((recipe,amount)->recipes.putInt(recipe.toString(),amount));
        nbt.put("RecipesUsed",recipes);
        return nbt;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.workTime=nbt.getInt("fermentTime");
        this.workTimeTotal=nbt.getInt("fermentTimeToal");
        CompoundNBT recipes=nbt.getCompound("RecipesUsed");
        for(String key:recipes.getAllKeys()){
            usedRecipe.put(new ResourceLocation(key),recipes.getInt(key));
        }
    }

    @Override
    public void setChanged() {
        super.setChanged();
        if (level!=null){
            level.sendBlockUpdated(getBlockPos(),getBlockState(),getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
        }
    }

    @Override
    public void tick() {
        boolean didChange=false;
        if (level==null) return;
        if(!level.isClientSide){
            if(hasIngredient()){
                Optional<FSEarthenJarRecipe> recipe=getMatchRecipe(new RecipeWrapper(jarInventory));
                if(recipe.isPresent()&&canFerment(recipe.get())){
                    didChange= processFermenting(recipe.get());
                }else {
                    workTime=0;
                }
            }
            else if(workTime>0){
                workTime= MathHelper.clamp(workTime-2,0,workTimeTotal);
            }
        }
        if(didChange){
            this.setChanged();
        }
    }



    private boolean processFermenting(FSEarthenJarRecipe recipe) {
        if (level==null) return false;
        ++workTime;
        workTimeTotal=recipe.getFermentTime();
        if (workTime<workTimeTotal){
            return false;
        }
        workTime=0;
        ItemStack result=recipe.getResultItem();
        ItemStack createdresult=jarInventory.getStackInSlot(3);
        if(createdresult.isEmpty()){
            jarInventory.setStackInSlot(3,result.copy());
        }else if (createdresult.sameItem(result)){
            createdresult.grow(result.getCount());
        }
        setRecipeUsed(recipe);
        return true;
    }

    private boolean canFerment(FSEarthenJarRecipe recipe) {
        ItemStack result=recipe.getResultItem();
        if (!result.isEmpty()) {
            ItemStack createdItem = jarInventory.getStackInSlot(3);
            if (createdItem.isEmpty()) {
                return true;
            } else if (createdItem.sameItem(result)) {
                return createdItem.getCount() + result.getCount() <= jarInventory.getSlotLimit(3)
                        && createdItem.getCount() + result.getCount() <= result.getMaxStackSize();
            }
        }
        return false;
    }

    private Optional<FSEarthenJarRecipe> getMatchRecipe(RecipeWrapper recipeWrapper) {
        if(level==null) return Optional.empty();
        return level.getRecipeManager().getRecipeFor(FSEarthenJarRecipe.TYPE,recipeWrapper,level);
    }

    private boolean hasIngredient() {
        for (int i=0;i<3;i++){
            if(!jarInventory.getStackInSlot(i).isEmpty()) return true;
        }
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("gui."+ FromSea.MOD_ID+"earthen_jar_container");
    }

    @Nullable
    @Override
    public Container createMenu(int ID, PlayerInventory inventory, PlayerEntity player) {
        if (this.level!=null){
            return new EarthenJarContainer(ID, inventory, this.worldPosition, this.level, this.jarData);
        }
        return null;
    }

    public ItemStackHandler getEarthenJarInv() {
        return jarInventory;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(side==Direction.UP&&cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)){
            return itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void setRecipeUsed(@Nullable IRecipe<?> recipe) {
        if(recipe!=null){
            ResourceLocation location=recipe.getId();
            usedRecipe.addTo(location,1);
        }
    }

    @Nullable
    @Override
    public IRecipe<?> getRecipeUsed() {
        return null;
    }

    @Override
    public void awardUsedRecipes(PlayerEntity player) {
        //TODO:spawn Experience
    }
}
