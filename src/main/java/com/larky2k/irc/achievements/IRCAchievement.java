package com.larky2k.irc.achievements;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;

public class IRCAchievement extends Achievement{

	public IRCAchievement(String map, String unlocalizedname, int column, int row, ItemStack stack,
			Achievement parent) {
		super(map, unlocalizedname, column, row, stack, parent);
		
	}
}
