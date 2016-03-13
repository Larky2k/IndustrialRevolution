package com.larky2k.irc.blocks;

import java.util.Random;

import com.larky2k.irc.IRCGlobal;
import com.larky2k.irc.items.IRCItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class IRCBlock extends Block {

	public IRCBlock(String unlocalizedName, Material material, float hardness, float resistance){
		super(material);
	
		this.setCreativeTab(IRCGlobal.ircCreativeTab);
		this.setUnlocalizedName(unlocalizedName);
		this.setHardness(hardness);
		this.setResistance(resistance);

	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this == IRCBlocks.bentoniteOre ? IRCItems.bentoniteDust : this ==IRCBlocks.slate? IRCItems.slateSlab : Item.getItemFromBlock(this);
	}
	
	public int quantityDropped(Random random) {
		return this == IRCBlocks.bentoniteOre ? 1 + random.nextInt(2) : this == IRCBlocks.slate? 4 +random.nextInt(8): 1;	
	}	
	
	
}

