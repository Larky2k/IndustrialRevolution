package com.larky2k.irc.render;

import com.larky2k.irc.IRCGlobal;
import com.larky2k.irc.blocks.IRCBlocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class IRCBlockRender {
	
	public static void regsterBlockRender() {
		
		//Ores
		regBlock (IRCBlocks.copperOre);
		regBlock (IRCBlocks.zincOre);
		regBlock (IRCBlocks.bentoniteOre);
		regBlock (IRCBlocks.slate);
		
		//Blocks
		regBlock (IRCBlocks.copperBlock);
		regBlock (IRCBlocks.steelBlock);
		
		//Furnace
		//regBlock (IRCBlocks.bloomeryIdle);
		//regBlock (IRCBlocks.bloomeryActive);
		
		//Forging Sand
		regBlock (IRCBlocks.forgingSand);
		
		//Anvil
		regBlock (IRCBlocks.steel_anvil);
		
	}

	private static void regBlock(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(IRCGlobal.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	
	}
}
