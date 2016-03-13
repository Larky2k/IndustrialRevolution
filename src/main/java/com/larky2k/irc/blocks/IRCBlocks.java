package com.larky2k.irc.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IRCBlocks {
	
	//Ores
	public static Block copperOre;
	public static Block zincOre;
	public static Block bentoniteOre;
	public static Block slate;
	
	//Blocks
	public static Block copperBlock;
	public static Block steelBlock;
 	
	//Forging Sand
	public static Block forgingSand;
	
	//Anvil
	public static Block steel_anvil;
	
	public static void initBlocks(){
		
		//Ores
		GameRegistry.registerBlock(copperOre = new IRCBlock("copperOre", Material.rock, 3, 15), "copperOre");
		GameRegistry.registerBlock(zincOre = new IRCBlock("zincOre", Material.rock, 3, 15), "zincOre");
		GameRegistry.registerBlock(bentoniteOre = new IRCBlock("bentoniteOre", Material.rock, 3, 15), "bentoniteOre");
		GameRegistry.registerBlock(slate = new IRCBlock("slate", Material.rock, 3, 15), "slate");
		
		//Blocks
		GameRegistry.registerBlock(copperBlock = new IRCBlock("copperBlock", Material.iron, 5, 10), "copperBlock");
		GameRegistry.registerBlock(steelBlock = new IRCBlock("steelBlock", Material.iron, 5, 10), "steelBlock");
		
		//Forging Sand
		GameRegistry.registerBlock(forgingSand = new IRCBlock("forgingSand", Material.sand, 0.5F, 0), "forgingSand");
		
		//Anvil
		GameRegistry.registerBlock(steel_anvil = new IRCBlock("steel_anvil", Material.anvil, 5, 10), "steel_anvil");
	
	}

}
