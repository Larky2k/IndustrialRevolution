package com.larky2k.irc;

import com.larky2k.irc.items.IRCItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IRCCreativeTab extends CreativeTabs {

	public IRCCreativeTab(String string) {
		super(string);
		
	}

	public Item getTabIconItem() {
		return IRCItems.copperIngot;
	}
}
