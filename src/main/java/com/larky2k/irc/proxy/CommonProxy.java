package com.larky2k.irc.proxy;

import com.larky2k.irc.blocks.IRCBlocks;
import com.larky2k.irc.crafting.IRCRecipeRemover;
import com.larky2k.irc.crafting.IRCRecipes;
import com.larky2k.irc.crafting.IRCSmelting;
import com.larky2k.irc.handler.IRCDropHandler;
import com.larky2k.irc.handler.IRCGrassDrop;
import com.larky2k.irc.items.IRCItems;
import com.larky2k.irc.world.IRCWorldGen;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent preEvent) {
		
		//Recipe Removed
		IRCRecipeRemover.RemoveCrafting(Items.wooden_pickaxe);
		IRCRecipeRemover.RemoveCrafting(Items.wooden_axe);
		IRCRecipeRemover.RemoveCrafting(Items.wooden_hoe);
		IRCRecipeRemover.RemoveCrafting(Items.wooden_shovel);
		IRCRecipeRemover.RemoveCrafting(Items.wooden_sword);
		
		//Vanilla Smelting Removed
		IRCRecipeRemover.RemoveFurnace(new ItemStack(Items.iron_ingot));
		IRCRecipeRemover.RemoveFurnace(new ItemStack(Items.gold_ingot));
				
		IRCBlocks.initBlocks();
		IRCItems.initItems();
	
		IRCRecipes.initRecipes();
		IRCSmelting.initSmelting();
		IRCGrassDrop.grassDrop();
		}
	
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new IRCWorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new IRCDropHandler());
		MinecraftForge.EVENT_BUS.register(new IRCGrassDrop());
	}
	
	public void postInit(FMLPostInitializationEvent postEvent) {
		
	}
}
