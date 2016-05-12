package com.larky2k.irc.achievements;

import com.larky2k.irc.items.IRCItems;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;


public class IRCAchievements {

public static Achievement openEngineeringLexicon;
	
	
public static void InitAchievements() {	
	
	
	//Achievements
	openEngineeringLexicon = new Achievement("achievement.openEngineeringLexicon", "openEngineeringLexicon", 0, 0, IRCItems.engineeringLexicon, (Achievement)null);

	//Achievements page
	AchievementPage.registerAchievementPage(new AchievementPage("Industrial Revolution", new Achievement[] {IRCAchievements.openEngineeringLexicon}));


	}
}