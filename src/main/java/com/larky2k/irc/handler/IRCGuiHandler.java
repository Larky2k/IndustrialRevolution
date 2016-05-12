package com.larky2k.irc.handler;

import com.larky2k.irc.containers.ContainerBloomeryInventory;
import com.larky2k.irc.gui.GuiBloomeryInventory;
import com.larky2k.irc.tileentity.TileBloomeryInventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class IRCGuiHandler implements IGuiHandler {
	
	public static final int ENGINEERINGLEXICON_GUI = 0;
	public static final int BLOOMERY_GUI = 1;
		
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == BLOOMERY_GUI) {
			return new ContainerBloomeryInventory(player.inventory, (TileBloomeryInventory) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if (ID == ENGINEERINGLEXICON_GUI) {
			return null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		if (ID == BLOOMERY_GUI) {
			return new GuiBloomeryInventory(player.inventory, (TileBloomeryInventory) world.getTileEntity(new BlockPos(x, y, z)));
		}
		if (ID == ENGINEERINGLEXICON_GUI) {
			return new GuiEngineeringLexicon(player.inventory, (GuiEngineeringLexicon) world.get)
		}
		return null;
	}
}
