package lcyzsdh.fromsea.data;

import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.items.FSItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class FSLangCN extends LanguageProvider {
    public FSLangCN(DataGenerator gen) {
        super(gen, FromSea.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {

        //items
        add(FSItemRegistry.FISHWET.get(),"渔网");
        add(FSItemRegistry.GRASS_CARP.get(),"草鱼");
        add(FSItemRegistry.COOKED_GRASS_CARP.get(),"熟草鱼");
        add(FSItemRegistry.COOKED_POMFRET.get(),"熟鲳鱼");
        add(FSItemRegistry.POMFRET.get(),"鲳鱼");
        add(FSItemRegistry.COOKED_YELLOW_CROAKER.get(),"熟黄鱼");
        add(FSItemRegistry.YELLOW_CROAKER.get(),"黄鱼");
        add(FSItemRegistry.FISH_SAUCE.get(),"鱼酱油");
        add(FSItemRegistry.VINEGAR.get(),"醋");
        add(FSItemRegistry.SALT.get(),"食盐");
        add(FSItemRegistry.SAUCE.get(),"酱油");

        //blocks
        //add(FSBlockRegistry.EARTHEN_JAR.get(),"坛");
    }
}
