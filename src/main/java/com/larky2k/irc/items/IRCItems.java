package com.larky2k.irc.items;

import com.larky2k.irc.items.tools.IRCFlintAxe;
import com.larky2k.irc.items.tools.IRCFlintHoe;
import com.larky2k.irc.items.tools.IRCFlintPickaxe;
import com.larky2k.irc.items.tools.IRCFlintSpade;
import com.larky2k.irc.items.tools.IRCFlintSword;
import com.larky2k.irc.items.tools.IRCblacksmithHammer;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
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
	
	//Dusts
	public static Item bentoniteDust;
	public static Item coalDust;
	
	//Forging Sand
	public static Item bentoniteClay;
	
	////Miscellaneous
	public static Item plantFibre;
	public static Item handle;
	public static Item flintBlade;
	public static Item slateSlab;

	public static void initItems() {
		
		//Tools
		GameRegistry.registerItem(flintPickaxe =  new IRCFlintPickaxe("flintPickaxe", FLINTTOOLS), "flintPickaxe");
		GameRegistry.registerItem(flintAxe =  new IRCFlintAxe("flintAxe", FLINTTOOLS), "flintAxe");
		GameRegistry.registerItem(flintSpade =  new IRCFlintSpade("flintSpade", FLINTTOOLS), "flintSpade");
		GameRegistry.registerItem(flintHoe =  new IRCFlintHoe("flintHoe", FLINTTOOLS), "flintHoe");
		GameRegistry.registerItem(flintSword =  new IRCFlintSword("flintSword", FLINTTOOLS), "flintSword");
		GameRegistry.registerItem(blacksmithHammer =  new IRCblacksmithHammer("blacksmithHammer", IRONTOOL), "blacksmithHammer");
		
		//Ingots
		GameRegistry.registerItem(copperIngot = new IRCItem("copperIngot"), "copperIngot");
		GameRegistry.registerItem(zincIngot = new IRCItem("zincIngot"), "zincIngot");
		GameRegistry.registerItem(steelIngot = new IRCItem("steelIngot"), "steelIngot");
		
		//Dusts
		GameRegistry.registerItem(bentoniteDust = new IRCItem("bentoniteDust"), "bentoniteDust");
		GameRegistry.registerItem(coalDust = new IRCItem("coalDust"), "coalDust");
		
		//Forging Sand
		GameRegistry.registerItem(bentoniteClay = new IRCItem("bentoniteClay"), "bentoniteClay");
		
		//Miscellaneous
		GameRegistry.registerItem(plantFibre = new IRCItem("plantFibre"), "plantFibre");
		GameRegistry.registerItem(handle = new IRCItem("handle"), "handle");
		GameRegistry.registerItem(flintBlade = new IRCItem("flintBlade"), "flintBlade");
		GameRegistry.registerItem(slateSlab = new IRCItem("slateSlab"), "slateSlab");
		
		
	}
}

