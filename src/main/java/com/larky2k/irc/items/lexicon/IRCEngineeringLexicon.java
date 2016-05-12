package com.larky2k.irc.items.lexicon;

import com.larky2k.irc.IRCGlobal;
import com.larky2k.irc.achievements.IRCAchievements;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatBase;
import net.minecraft.world.World;

public class IRCEngineeringLexicon extends Item{

	public IRCEngineeringLexicon(String unlocalizedName){
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
		this.setMaxStackSize(1);
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		player.displayGUIBook(stack);
		player.triggerAchievement(IRCAchievements.openEngineeringLexicon);
		return stack;
	}
}
