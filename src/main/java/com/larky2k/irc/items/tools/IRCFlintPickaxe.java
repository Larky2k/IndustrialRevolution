package com.larky2k.irc.items.tools;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.item.ItemPickaxe;

public class IRCFlintPickaxe extends ItemPickaxe {

	public IRCFlintPickaxe (String unlocalizedName, ToolMaterial material){
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
	}
}
