package com.larky2k.irc.world;

import java.util.Random;

import com.larky2k.irc.blocks.IRCBlocks;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class IRCWorldGen implements IWorldGenerator {

	//Ores
	private WorldGenerator copperOre;
	private WorldGenerator zincOre;
	private WorldGenerator bentoniteOre;
	private WorldGenerator slate;
	
	public IRCWorldGen(){
		
		//Ores
		this.copperOre = new IRCWorldGenMinable(IRCBlocks.copperOre.getDefaultState(), 8);
		this.zincOre = new IRCWorldGenMinable(IRCBlocks.zincOre.getDefaultState(), 10);
		this.bentoniteOre = new IRCWorldGenMinable(IRCBlocks.bentoniteOre.getDefaultState(), 5);
		this.slate = new IRCWorldGenMinable(IRCBlocks.slate.getDefaultState(), 64);
	
	}
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimensionId()) {
		case 0: //OverWorld
			
			//Ores
			this.runGenerator(this.copperOre, world, random, chunkX, chunkZ, 20, 0, 228);
			this.runGenerator(this.zincOre, world, random, chunkX, chunkZ, 20, 0, 228);
			this.runGenerator(bentoniteOre, world, random, chunkX, chunkZ, 15, 50, 75);
			this.runGenerator(slate, world, random, chunkX, chunkZ, 30, 60, 70);
			break;
			
		case -1: //Nether
			
			break;
			
		case 1: //The End
			
			break;
		}
		
	}

	private void runGenerator (WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chanceToSpawn, int minHeight, int maxHeight){
		
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Minimum or Maximum Height out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chanceToSpawn; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}

