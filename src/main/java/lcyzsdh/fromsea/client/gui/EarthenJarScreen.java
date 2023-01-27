package lcyzsdh.fromsea.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import lcyzsdh.fromsea.FromSea;
import lcyzsdh.fromsea.tile.container.EarthenJarContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class EarthenJarScreen extends ContainerScreen<EarthenJarContainer> {
    private final ResourceLocation BACK_PICTURE=new ResourceLocation(FromSea.MOD_ID,"textures/gui/earthen_jar.png");

    public EarthenJarScreen(EarthenJarContainer container, PlayerInventory inv,ITextComponent textComponent) {
        super(container,inv,textComponent);
        this.leftPos=0;
        this.topPos=0;
        this.imageWidth=176;
        this.imageHeight=166;
        this.titleLabelX=28;
    }

    @Override
    public void render(MatrixStack ms, final int mouseX, final int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float particalTicks, int mouseX, int mouseY) {

        this.renderBackground(matrixStack);
        this.minecraft.textureManager.bind(BACK_PICTURE);
        this.blit(matrixStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }
}
