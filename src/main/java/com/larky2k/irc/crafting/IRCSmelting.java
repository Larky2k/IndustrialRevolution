package com.larky2k.irc.crafting;

import com.larky2k.irc.blocks.IRCBlocks;
import com.larky2k.irc.items.IRCItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IRCSmelting {

	public static void initSmelting(){
		GameRegistry.addSmelting(IRCBlocks.copperOre, new ItemStack(IRCItems.copperIngot), 5);
		GameRegistry.addSmelting(IRCBlocks.zincOre, new ItemStack(IRCItems.zincIngot), 5);
		
	}
	
}
