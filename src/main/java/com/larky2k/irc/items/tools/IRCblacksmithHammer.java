package com.larky2k.irc.items.tools;

import com.larky2k.irc.IRCGlobal;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class IRCblacksmithHammer extends ItemPickaxe {

	public IRCblacksmithHammer(String unlocalizedName, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
	
	}

}
