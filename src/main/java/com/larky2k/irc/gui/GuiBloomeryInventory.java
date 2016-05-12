package com.larky2k.irc.gui;

import java.util.ArrayList;
import java.util.List;

import com.larky2k.irc.containers.ContainerBloomeryInventory;
import com.larky2k.irc.tileentity.TileBloomeryInventory;

import javafx.scene.paint.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBloomeryInventory extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation("irc", "textures/gui/bloomeryGui.png");
	private TileBloomeryInventory tileEntity;
	private int FLAME_HEIGHT;
	
	public GuiBloomeryInventory(InventoryPlayer invPlayer, TileBloomeryInventory tileBloomeryInventory) {
		super (new ContainerBloomeryInventory(invPlayer, tileBloomeryInventory));
		
		xSize = 178;
		ySize = 176;
		
		this.tileEntity = tileBloomeryInventory;
	}
	
	final int COOK_BAR_XPOS = 82;
	final int COOK_BAR_YPOS = 15;
	final int COOK_BAR_ICON_U = 178;
	final int COOK_BAR_ICON_V = 5;
	final int COOK_BAR_WIDTH = 60;
	final int COOK_BAR_HEIGHT = 45;
	
	final int FLAME_XPOS = 41;
	final int FLAME_YPOS = 30;
	final int FLAME_ICON_U = 179;
	final int FLAME_ICON_V = 50;
	final int FLAME_WIDTH = 15;
	final int FLAME_HEIGHT = 15;
	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float particalTicks, int x, int y) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		double cookProgress = tileEntity.fractionOfCookTimeComplete();
		drawTexturedModalRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_ICON_U, COOK_BAR_ICON_V, (int)(cookProgress * COOK_BAR_WIDTH), COOK_BAR_HEIGHT); 
		
		for (int i = 0; i < tileEntity.FUEL_SLOT_COUNT; ++i) {
			double burnRemaining = tileEntity.fractionOfFuelRemaining(i);
			int yOffset = (int)((1.0 - burnRemaining) * FLAME_HEIGHT);
			drawTexturedModalRect(guiLeft + FLAME_XPOS, guiTop + FLAME_YPOS + yOffset, FLAME_ICON_U, FLAME_ICON_V + yOffset, FLAME_WIDTH, FLAME_HEIGHT - yOffset);
		}
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		final int LABEL_XPOS = 5;
		final int LABEL_YPOS = 5;
		fontRendererObj.drawString(tileEntity.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.DARKGREEN.getRGB());
		
		List<String> hoveringText = new ArrayList<String>();
		
		if (isInRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_WIDTH, COOK_BAR_HEIGHT, mouseX, mouseY)){
			hoveringText.add("Progress:");
			int cookPercentage = (int)(tileEntity.fractionOfCookTimeComplete() * 100);
			hoveringText.add(cookPercentage + "%");
		}
 		
		if (isInRect(guiLeft + FLAME_XPOS, guiTop + FLAME_YPOS, FLAME_WIDTH, FLAME_HEIGHT, mouseX, mouseY)) {
			hoveringText.add("Fuel Time:");
			hoveringText.add(tileEntity.secondsOfFuelRemaining() + "s");
			}
		
		if (!hoveringText.isEmpty()){
			drawHoveringText(hoveringText, mouseX - guiLeft, mouseY - guiTop, fontRendererObj);
			}
	
	public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
		return ((mouseX >= x && mouseX <= x+xSize) && (mouseY >= y && mouseY <= y+ySize));
	}
}
