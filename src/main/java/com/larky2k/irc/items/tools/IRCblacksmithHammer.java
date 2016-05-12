package com.larky2k.irc.items.tools;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.item.Item;

public class IRCblacksmithHammer extends Item {

	public IRCblacksmithHammer(String unlocalizedName) {
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.maxStackSize = 1;
		this.setMaxDamage(100);
		this.setNoRepair();
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
	
	}

}
