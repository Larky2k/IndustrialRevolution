package com.larky2k.irc.blocks;

import com.larky2k.irc.IRCGlobal;
//import com.larky2k.irc.blocks.custom.IRCBloomery;
import com.larky2k.irc.blocks.custom.IRCBloomery;
import com.larky2k.irc.blocks.custom.IRCCrate;

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
	
	//Furnace
	public static Block bloomeryIdle;
	public static Block bloomeryActive;
 	
	//Forging Sand
	public static Block forgingSand;
	
	//Anvil
	public static Block steel_anvil;
	
	//Storage
	public static Block crate;
	
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
		
		//Furnace
		//GameRegistry.registerBlock(bloomeryIdle = new IRCBloomery(false, "bloomeryIdle").setCreativeTab(IRCGlobal.ircCreativeTab), "bloomeryIdle");
		//GameRegistry.registerBlock(bloomeryActive = new IRCBloomery(true, "bloomeryActive"), "bloomeryActive");
		
		//Anvil
		GameRegistry.registerBlock(steel_anvil = new IRCBlock("steel_anvil", Material.anvil, 5, 10), "steel_anvil");
		
		//Storage
		GameRegistry.registerBlock(crate = new IRCCrate("crate", Material.wood, 1, 5), "crate");
	
	}

}
