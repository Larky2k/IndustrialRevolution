package com.larky2k.irc.gui;

import com.larky2k.irc.IRCGlobal;
import com.larky2k.irc.Main;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiEngineeringLexicon extends GuiScreen {
	
	private final int bookImageHeight = 353;
	private final int bookImageWidth = 466;
	private int currPage = 0;
	private static final int bookTotalPages = 2;
	private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
	private static String[] stringPageText = new String[bookTotalPages];
	private GuiButton buttonDone;
	private NextPageButton buttonNextPage;
	private PrevoiusPageButton buttonPrevoiusPage;
	
	public GuiEngineeringLexicon() {
		
		bookPageTextures[0] = new ResourceLocation(IRCGlobal.MODID+":textures/gui/engineeringLexiconGui");
		bookPageTextures[1] = new ResourceLocation(IRCGlobal.MODID+":textures/gui/engineeringLexiconGui");
		bookPageTextures[2] = new ResourceLocation(IRCGlobal.MODID+":textures/gui/engineeringLexiconGui");
		
		stringPageText[0]="";
		stringPageText[1]="Test";
		stringPageText[2]="Test";
	
	}
	
	@Override
	public void
	

}
