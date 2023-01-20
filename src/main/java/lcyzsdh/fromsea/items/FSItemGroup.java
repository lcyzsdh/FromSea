package lcyzsdh.fromsea.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class FSItemGroup extends ItemGroup {
    public FSItemGroup(){
        super("from-sea-group");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(FSItemRegistry.FISHWET.get());
    }
}
