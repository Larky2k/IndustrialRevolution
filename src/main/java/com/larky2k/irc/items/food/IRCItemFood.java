package com.larky2k.irc.items.food;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.item.ItemFood;

public class IRCItemFood extends ItemFood {
	
	public IRCItemFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		
		this.setUnlocalizedName(name);
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
	}

}
