package lcyzsdh.fromsea.data;

import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.blocks.FSBlockRegistry;
import lcyzsdh.fromsea.items.FSItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class FSLangUS extends LanguageProvider {
    public FSLangUS(DataGenerator gen) {
        super(gen, FromSea.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        //items
        add(FSItemRegistry.FISHWET.get(),"fishwet");
        add(FSItemRegistry.GRASS_CARP.get(),"grass carp");
        add(FSItemRegistry.COOKED_GRASS_CARP.get(),"cooked grass carp");
        add(FSItemRegistry.COOKED_POMFRET.get(),"cooked pomfret");
        add(FSItemRegistry.POMFRET.get(),"pomfret");
        add(FSItemRegistry.COOKED_YELLOW_CROAKER.get(),"cooked yellow croaker");
        add(FSItemRegistry.YELLOW_CROAKER.get(),"yellow croaker");
        add(FSItemRegistry.FISH_SAUCE.get(),"fish sauce");
        add(FSItemRegistry.VINEGAR.get(),"vinegar");
        add(FSItemRegistry.SALT.get(),"salt");
        add(FSItemRegistry.SAUCE.get(),"sauce");

        //blocks
        add(FSBlockRegistry.EARTHEN_JAR.get(),"earthen jar");

    }
}
