package com.larky2k.irc.items.tools;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.item.ItemAxe;

public class IRCFlintAxe extends ItemAxe {

	public IRCFlintAxe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(IRCGlobal.ircCreativeTab);

	}
	

}
