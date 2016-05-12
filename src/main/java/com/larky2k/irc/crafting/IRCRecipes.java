package com.larky2k.irc.crafting;

import com.larky2k.irc.blocks.IRCBlocks;
import com.larky2k.irc.items.IRCItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class IRCRecipes {

	public static void initRecipes(){
		
		//Recipe
		
			//Tools and weapons
			GameRegistry.addRecipe(new ItemStack(IRCItems.flintPickaxe), new Object [] { "Fp",	"HF", 'F', Items.flint, 'p', IRCItems.plantFibre, 'H', IRCItems.handle });
			GameRegistry.addRecipe(new ItemStack(IRCItems.flintAxe), new Object [] { "Fp",	"H ", 'F', Items.flint, 'p', IRCItems.plantFibre, 'H', IRCItems.handle });
			GameRegistry.addRecipe(new ItemStack(IRCItems.flintSpade), new Object [] { " F ",	" p ", " H ", 'F', Items.flint, 'p', IRCItems.plantFibre, 'H', IRCItems.handle });
			GameRegistry.addRecipe(new ItemStack(IRCItems.flintHoe), new Object [] { "FF ",	" p ", " H ", 'F', Items.flint,	'p', IRCItems.plantFibre, 'H', IRCItems.handle });
			GameRegistry.addRecipe(new ItemStack(IRCItems.flintSword), new Object [] { " S ",	" p ", " H ", 'S', IRCItems.flintBlade, 'p', IRCItems.plantFibre, 'H', IRCItems.handle	});
			GameRegistry.addRecipe(new ItemStack(IRCItems.blacksmithHammer), new Object [] { "III", "IpI", " h ", 'I', Items.iron_ingot, 'p', IRCItems.plantFibre, 'h', IRCItems.handle });
			
			//Blade
			GameRegistry.addRecipe(new ItemStack(IRCItems.flintBlade), new Object [] { "F",	"F", 'F', Items.flint });
		
			//Blocks
			GameRegistry.addRecipe(new ItemStack(IRCBlocks.copperBlock), new Object [] { "###",	"###", "###", '#', IRCItems.copperIngot	});
			GameRegistry.addRecipe(new ItemStack(IRCBlocks.steelBlock), new Object [] { "###",	"###", "###", '#', IRCItems.steelIngot	});
		
			//Coal dust
			GameRegistry.addRecipe(new ItemStack (Items.coal, 1), new Object []{ "CC", "CC", 'C', IRCItems.coalDust });
		
			//Materials
			GameRegistry.addRecipe(new ItemStack (IRCItems.handle), new Object [] { " S", "S ", 'S', Items.stick });
			
			//Misc
			GameRegistry.addRecipe(new ItemStack(IRCItems.stoneBowl), new Object [] { "   ", "c c", " c ", 'c', Blocks.stone_slab });
			GameRegistry.addRecipe(new ItemStack(IRCItems.pestleMortar), new Object [] { " s ",	"c  ", "S  ", 's', Items.stick , 'c', Blocks.cobblestone , 'S', IRCItems.stoneBowl });
				
		//Shapeless Recipe
			//Blocks -> Ingot's
			GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.copperIngot, 9), new Object[]{ IRCBlocks.copperBlock });
			GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.steelIngot, 9), new Object[]{ IRCBlocks.steelBlock });
			
			//Ingots -> Plate
			GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.ironPlate, 1), new Object[]{ Items.iron_ingot, new ItemStack(IRCItems.blacksmithHammer, 1, OreDictionary.WILDCARD_VALUE) });
			GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.copperPlate, 1), new Object[]{ IRCItems.copperIngot, new ItemStack(IRCItems.blacksmithHammer, 1, OreDictionary.WILDCARD_VALUE) });
			GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.steelPlate, 1), new Object[]{ IRCItems.steelIngot, new ItemStack(IRCItems.blacksmithHammer, 1, OreDictionary.WILDCARD_VALUE) });
			
			//Forging
			GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.bentoniteClay, 1), new Object [] { new ItemStack(IRCItems.bentoniteDust, 1), Items.clay_ball });
			GameRegistry.addShapelessRecipe(new ItemStack(IRCBlocks.forgingSand, 1), new Object []{	new ItemStack(IRCItems.bentoniteClay, 1), IRCItems.coalDust, Blocks.sand, Items.water_bucket });
			GameRegistry.addRecipe(new ItemStack(IRCBlocks.bloomeryIdle), new Object [] { "bbb", "bfb", "ccc", 'b', Items.brick, 'f', Blocks.furnace , 'c', Blocks.cobblestone});
			
			//Fuel
			GameRegistry.addShapelessRecipe(new ItemStack (IRCItems.coalDust, 4), new Object []{ Items.coal	});
		
			//Food
			GameRegistry.addShapelessRecipe(new ItemStack(IRCItems.foodFlour, 4), new Object[]{ Items.wheat, new ItemStack(IRCItems.pestleMortar, 1, OreDictionary.WILDCARD_VALUE) });
			GameRegistry.addShapelessRecipe(new ItemStack (IRCItems.foodDough, 1), new Object []{ new ItemStack (IRCItems.foodFlour, 1), Items.water_bucket });
			GameRegistry.addShapelessRecipe(new ItemStack (IRCItems.uncookedPasty, 1), new Object []{ new ItemStack (IRCItems.foodSwede, 1), IRCItems.beefSkirt, IRCItems.foodDough, Items.carrot });
			GameRegistry.addShapelessRecipe(new ItemStack (IRCItems.beefSkirt, 1), new Object []{ Items.beef, new ItemStack (Items.shears, 2, OreDictionary.WILDCARD_VALUE) });
			
			//Misc
			GameRegistry.addShapelessRecipe(new ItemStack (Items.flint, 2), new Object []{ Blocks.gravel });
		
	}

}	
	
	

