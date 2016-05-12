package com.larky2k.irc.handler;

import com.larky2k.irc.items.IRCItems;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class IRCCraftingHandler {

	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		
		final IInventory craftingMatrix = null;
		
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			
			if(event.craftMatrix.getStackInSlot(i) != null) {
				
				//Blacksmith Hammer
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
				if (item0 != null && item0.getItem() ==IRCItems.blacksmithHammer) {
					ItemStack k = new ItemStack(IRCItems.blacksmithHammer, 2, (item0.getItemDamage() + 1));
					
					if(k.getItemDamage() >= k.getMaxDamage()) {
						k.stackSize--;
					}
					event.craftMatrix.setInventorySlotContents(i, k);
				}
			}
		}
	}
}
