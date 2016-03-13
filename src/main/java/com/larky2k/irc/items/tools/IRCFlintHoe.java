package com.larky2k.irc.items.tools;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.item.ItemHoe;

public class IRCFlintHoe extends ItemHoe {

	public IRCFlintHoe(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
		
	}

}
