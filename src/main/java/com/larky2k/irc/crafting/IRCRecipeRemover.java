package com.larky2k.irc.crafting;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class IRCRecipeRemover {

	public static void RemoveCrafting(Item item) {
		
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		
		Iterator<IRecipe> remover = recipes.iterator();
		
			while(remover.hasNext()) {
				ItemStack itemstack = remover.next().getRecipeOutput();
				if(itemstack != null && itemstack.getItem() == item) {
					remover.remove();
				}
			}
		
	}

	public static void RemoveFurnace (ItemStack itemstack) {
		Map<ItemStack, ItemStack> recipe = FurnaceRecipes.instance().getSmeltingList();
		
		for (Iterator<Map.Entry<ItemStack, ItemStack>> entries = recipe.entrySet().iterator(); entries.hasNext(); ) {
			Map.Entry<ItemStack, ItemStack> entry = entries.next();
			ItemStack result = entry.getValue();
			if (ItemStack.areItemsEqual(result, itemstack)) {
				entries.remove();
			}
		}
	}
}
