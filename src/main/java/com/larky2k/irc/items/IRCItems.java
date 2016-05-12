package com.larky2k.irc.items;

import com.larky2k.irc.items.food.IRCItemFood;
import com.larky2k.irc.items.lexicon.IRCEngineeringLexicon;
import com.larky2k.irc.items.tools.IRCFlintAxe;
import com.larky2k.irc.items.tools.IRCFlintHoe;
import com.larky2k.irc.items.tools.IRCFlintPickaxe;
import com.larky2k.irc.items.tools.IRCFlintSpade;
import com.larky2k.irc.items.tools.IRCFlintSword;
import com.larky2k.irc.items.tools.IRCPestleMortar;
import com.larky2k.irc.items.tools.IRCblacksmithHammer;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IRCItems {
	
	//Tool Setup
	public static ToolMaterial FLINTTOOLS = EnumHelper.addToolMaterial("FLINTTOOLS", 1, 200, 6.0F, 2.0F, 6);
	public static ToolMaterial IRONTOOL = EnumHelper.addToolMaterial("IRONTOOL", 3, 700, 12.0F, 8.0F, 12);
	
	//Tools
	public static Item flintPickaxe;
	public static Item flintAxe;
	public static Item flintSpade;
	public static Item flintHoe;
	public static Item flintSword;
	
	public static Item blacksmithHammer;

	//Ingots
	public static Item copperIngot;
	public static Item zincIngot;
	public static Item steelIngot;
	
	//Plates
	public static Item ironPlate;
	public static Item copperPlate;
	public static Item steelPlate;
	
	//Dusts
	public static Item bentoniteDust;
	public static Item coalDust;
	
	//Forging Sand
	public static Item bentoniteClay;
	
	//Food
	public static Item foodPasty;
	public static Item beefSkirt;
	public static Item foodDough;
	public static Item foodSwede;
	public static Item foodFlour;
	public static Item uncookedPasty;
	public static Item pestleMortar;
	
	//Manual
	public static Item engineeringLexicon;
		
	//Miscellaneous
	public static Item plantFibre;
	public static Item handle;
	public static Item flintBlade;
	public static Item slateSlab;
	public static Item stoneBowl;

	public static void initItems() {
		
		//Food
		GameRegistry.registerItem(foodPasty =  new IRCItemFood("foodPasty", 18, 2.0F, false).setPotionEffect(Potion.regeneration.id, 600, 0, 1.0F), "foodPasty", "foodPasty");
		GameRegistry.registerItem(beefSkirt =  new IRCItemFood("beefSkirt", 2, 0.2F, true).setPotionEffect(Potion.hunger.id, 10, 5, 0.5F), "beefSkirt");
		GameRegistry.registerItem(foodDough =  new IRCItemFood("foodDough", 2, 0.1F, false), "foodDough");
		GameRegistry.registerItem(foodSwede =  new IRCItemFood("foodSwede", 4, 0.4F, false), "foodSwede");
		GameRegistry.registerItem(foodFlour =  new IRCItemFood("foodFlour", 1, 0.1F, false), "foodFlour");
		GameRegistry.registerItem(uncookedPasty =  new IRCItemFood("uncookedPasty", 3, 0.3F, false).setPotionEffect(Potion.hunger.id, 8, 3, 0.5F), "uncookedPasty");
		GameRegistry.registerItem(pestleMortar =  new IRCPestleMortar("pestleMortar"), "pestleMortar");
		
		//Tools
		GameRegistry.registerItem(flintPickaxe =  new IRCFlintPickaxe("flintPickaxe", FLINTTOOLS), "flintPickaxe");
		GameRegistry.registerItem(flintAxe =  new IRCFlintAxe("flintAxe", FLINTTOOLS), "flintAxe");
		GameRegistry.registerItem(flintSpade =  new IRCFlintSpade("flintSpade", FLINTTOOLS), "flintSpade");
		GameRegistry.registerItem(flintHoe =  new IRCFlintHoe("flintHoe", FLINTTOOLS), "flintHoe");
		GameRegistry.registerItem(flintSword =  new IRCFlintSword("flintSword", FLINTTOOLS), "flintSword");
		GameRegistry.registerItem(blacksmithHammer =  new IRCblacksmithHammer("blacksmithHammer"), "blacksmithHammer");
		
		//Ingots
		GameRegistry.registerItem(copperIngot = new IRCItem("copperIngot"), "copperIngot");
		GameRegistry.registerItem(zincIngot = new IRCItem("zincIngot"), "zincIngot");
		GameRegistry.registerItem(steelIngot = new IRCItem("steelIngot"), "steelIngot");
		
		//Plates
		GameRegistry.registerItem(ironPlate = new IRCItem("ironPlate"), "ironPlate");
		GameRegistry.registerItem(copperPlate = new IRCItem("copperPlate"), "copperPlate");
		GameRegistry.registerItem(steelPlate = new IRCItem("steelPlate"), "steelPlate");
		
		//Dusts
		GameRegistry.registerItem(bentoniteDust = new IRCItem("bentoniteDust"), "bentoniteDust");
		GameRegistry.registerItem(coalDust = new IRCItem("coalDust"), "coalDust");
		
		//Forging Sand
		GameRegistry.registerItem(bentoniteClay = new IRCItem("bentoniteClay"), "bentoniteClay");
		
		//Manual
		GameRegistry.registerItem(engineeringLexicon = new IRCEngineeringLexicon("engineeringLexicon"), "engineeringLexicon");
		
		//Miscellaneous
		GameRegistry.registerItem(plantFibre = new IRCItem("plantFibre"), "plantFibre");
		GameRegistry.registerItem(handle = new IRCItem("handle"), "handle");
		GameRegistry.registerItem(flintBlade = new IRCItem("flintBlade"), "flintBlade");
		GameRegistry.registerItem(slateSlab = new IRCItem("slateSlab"), "slateSlab");
		GameRegistry.registerItem(stoneBowl = new IRCItem("stoneBowl"), "stoneBowl");
		
		
	}
}

