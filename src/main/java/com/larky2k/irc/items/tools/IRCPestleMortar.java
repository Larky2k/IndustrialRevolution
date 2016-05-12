package com.larky2k.irc.items.tools;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.item.Item;

public class IRCPestleMortar extends Item {

public IRCPestleMortar(String unlocalizedName) {
	super();
	this.setUnlocalizedName(unlocalizedName);
	this.maxStackSize = 1;
	this.setMaxDamage(10);
	this.setNoRepair();
	this.setCreativeTab(IRCGlobal.ircCreativeTab);

	}

}
