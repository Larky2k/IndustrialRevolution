package com.larky2k.irc.render;

import com.larky2k.irc.IRCGlobal;
import com.larky2k.irc.items.IRCItems;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class IRCItemRender {
	
	public static void registerItemRender() {
		
		//Food
		regItem (IRCItems.foodPasty);
		regItem (IRCItems.foodDough);
		regItem (IRCItems.foodFlour);
		regItem (IRCItems.foodSwede);
		regItem (IRCItems.beefSkirt);
		regItem (IRCItems.uncookedPasty);
		regItem (IRCItems.pestleMortar);
		
		//Tools
		regItem (IRCItems.flintPickaxe);
		regItem (IRCItems.flintAxe);
		regItem (IRCItems.flintSpade);
		regItem (IRCItems.flintHoe);
		regItem (IRCItems.flintSword);
		regItem (IRCItems.blacksmithHammer);
		
		//Ingots
		regItem (IRCItems.copperIngot);
		regItem (IRCItems.zincIngot);
		regItem (IRCItems.steelIngot);
		
		//Plates
		regItem (IRCItems.ironPlate);
		regItem (IRCItems.copperPlate);
		regItem (IRCItems.steelPlate);
		
		//Dusts
		regItem (IRCItems.bentoniteDust);
		regItem (IRCItems.coalDust);
		
		//Forging Sand
		regItem (IRCItems.bentoniteClay);
		
		//Manual
		regItem (IRCItems.engineeringLexicon);
		
		//Miscellaneous 
		regItem (IRCItems.plantFibre);
		regItem (IRCItems.handle);
		regItem (IRCItems.flintBlade);
		regItem (IRCItems.slateSlab);
		regItem (IRCItems.stoneBowl);
		
	}
	
		private static void regItem(Item item) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(IRCGlobal.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
			
		
	}

}
