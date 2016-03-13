package com.larky2k.irc.handler;

import java.util.Random;

import com.larky2k.irc.blocks.IRCBlocks;
import com.larky2k.irc.items.IRCItems;
import com.larky2k.irc.items.tools.IRCFlintPickaxe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class IRCDropHandler {
	
	@SubscribeEvent
	public void addBlockDrop (HarvestDropsEvent event) {
		if (event.state.getBlock() == Blocks.coal_ore){
			
			Random rand = new Random();
			
			ItemStack holding = event.harvester.inventory.getStackInSlot(event.harvester.inventory.currentItem);
			if (holding != null && holding.getItem() instanceof ItemPickaxe){	
				event.drops.add(new ItemStack(IRCItems.coalDust, rand.nextInt(4)));
			}	
		}
	}
}	

