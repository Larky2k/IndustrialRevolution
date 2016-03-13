package com.larky2k.irc.crafting;

import com.larky2k.irc.blocks.IRCBlocks;
import com.larky2k.irc.items.IRCItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IRCRecipes {

	public static void initRecipes(){
		
		//Recipe
			//Tools and weapons
		GameRegistry.addRecipe(new ItemStack(IRCItems.flintPickaxe), new Object [] { "Fp",	"HF", 'F', Items.flint, 'p', IRCItems.plantFibre, 'H', IRCItems.handle });
		GameRegistry.addRecipe(new ItemStack(IRCItems.flintAxe), new Object [] { "Fp",	"H ", 'F', Items.flint, 'p', IRCItems.plantFibre, 'H', IRCItems.handle });
		GameRegistry.addRecipe(new ItemStack(IRCItems.flintSpade), new Object [] { " F ",	" p ", " H ", 'F', Items.flint, 'p', IRCItems.plantFibre, 'H', IRCItems.handle });
		GameRegistry.addRecipe(new ItemStack(IRCItems.flintHoe), new Object [] { "FF ",	" p ", " H ", 'F', Items.flint,	'p', IRCItems.plantFibre, 'H', IRCItems.handle });
		GameRegistry.addRecipe(new ItemStack(IRCItems.flintSword), new Object [] { " S ",	" p ", " H ", 'S', IRCItems.flintBlade, 'p', IRCItems.plantFibre, 'H', IRCItems.handle	});
		
			//Blade
		GameRegistry.addRecipe(new ItemStack(IRCItems.flintBlade), new Object [] { "F",	"F", 'F', Items.flint });
		
			//Blocks
		GameRegistry.addRecipe(new ItemStack(IRCBlocks.copperBlock), new Object [] { "###",	"###", "###", '#', IRCItems.copperIngot	});
		GameRegistry.addRecipe(new ItemStack(IRCBlocks.steelBlock), new Object [] { "###",	"###", "###", '#', IRCItems.steelIngot	});
		
			//Coal dust
		GameRegistry.addRecipe(new ItemStack (Items.coal, 1), new Object []{ "CC", "CC", 'C', IRCItems.coalDust });
		
			//Materials
		GameRegistry.addRecipe(new ItemStack (IRCItems.handle), new Object [] { " S", "S ", 'S', Items.stick });
				
		//Shapeless Recipe
			//Blocks -> Ingot's
		GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.copperIngot, 9), new Object[]{ IRCBlocks.copperBlock });
		GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.steelIngot, 9), new Object[]{ IRCBlocks.steelBlock });
		
			//Forging
		GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.bentoniteClay, 1), new Object [] { new ItemStack(IRCItems.bentoniteDust, 1), Items.clay_ball });
		GameRegistry.addShapelessRecipe(new ItemStack(IRCBlocks.forgingSand, 1), new Object []{	new ItemStack(IRCItems.bentoniteClay, 1), IRCItems.coalDust, Blocks.sand, Items.water_bucket });
			
			//Fuel
		GameRegistry.addShapelessRecipe(new ItemStack (IRCItems.coalDust, 4), new Object []{ Items.coal	});
		
			//Misc
		GameRegistry.addShapelessRecipe(new ItemStack (Items.flint, 2), new Object []{ Blocks.gravel });
		
	}

}	
	
	

