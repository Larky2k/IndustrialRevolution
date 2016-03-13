package com.larky2k.irc.items.tools;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.item.ItemSpade;

public class IRCFlintSpade extends ItemSpade {

	public IRCFlintSpade(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
		
	}

}
