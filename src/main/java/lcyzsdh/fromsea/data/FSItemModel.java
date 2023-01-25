package lcyzsdh.fromsea.data;

import lcyzsdh.fromsea.FromSea;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FSItemModel extends ItemModelProvider {
    public static final String COMMON="item/generated";

    public FSItemModel(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FromSea.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("yellow_croaker",COMMON).texture("layer0",modLoc("item/yellow_croaker"));
        withExistingParent("grass_carp",COMMON).texture("layer0",modLoc("item/grass_carp"));
        withExistingParent("pomfret",COMMON).texture("layer0",modLoc("item/pomfret"));
    }
}
