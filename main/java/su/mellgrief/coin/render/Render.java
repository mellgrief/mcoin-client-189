package su.mellgrief.coin.render;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import su.mellgrief.coin.utils.Utils;

public class Render {

	public static String moneyToRender = "0.0";
	public static final ResourceLocation ICON = new ResourceLocation("mcoin:icon.png");
	
	@SubscribeEvent
	public void renderPre(RenderGameOverlayEvent.Pre e) {
		ScaledResolution res = e.resolution;
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(moneyToRender, e.resolution.getScaledWidth() - 21 - Minecraft.getMinecraft().fontRendererObj.getStringWidth(moneyToRender) - 2, e.resolution.getScaledHeight() - 14, Color.YELLOW.getRGB());
		GlStateManager.color(1f, 1f, 1f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(ICON);
		GlStateManager.enableBlend();
		Gui.drawModalRectWithCustomSizedTexture(e.resolution.getScaledWidth() - 21 /*- Minecraft.getMinecraft().fontRendererObj.getStringWidth(moneyToRender)*/, e.resolution.getScaledHeight() - 18, 0, 0, 16, 16, 16, 16);
		GlStateManager.disableBlend();
		GlStateManager.color(1f, 1f, 1f);
		GlStateManager.popMatrix();
		Minecraft.getMinecraft().getTextureManager().bindTexture(Gui.icons);
	}
	
}
