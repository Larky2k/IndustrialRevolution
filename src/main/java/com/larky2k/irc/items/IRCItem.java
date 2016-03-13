package com.larky2k.irc.items;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IRCItem extends Item{
	public IRCItem(String name) {
		super();
		
		this.setUnlocalizedName(name);
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
		
	}
}
