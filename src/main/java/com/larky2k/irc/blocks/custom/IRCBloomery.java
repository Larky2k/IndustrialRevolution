package com.larky2k.irc.blocks.custom;

import java.util.Random;

import com.larky2k.irc.IRCGlobal;
import com.larky2k.irc.Main;
import com.larky2k.irc.blocks.IRCBlocks;
import com.larky2k.irc.handler.IRCGuiHandler;
import com.larky2k.irc.tileentity.TileBloomery;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class IRCBloomery extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	private final boolean isBurning;
	private static boolean keepInventory;
	
	public IRCBloomery(boolean isBurning, String name) {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.isBurning = isBurning;
	}
	
	public Item getItemDropped(IBlockState block, Random rand, int fortune) {
		return Item.getItemFromBlock(IRCBlocks.bloomeryIdle);
		
	}
	
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		this.setDefaultFacing(world, pos, state);
	}
	
	private void setDefaultFacing(World world, BlockPos pos, IBlockState state) {
		
		if (!world.isRemote) {
			Block block0 = world.getBlockState(pos.north()).getBlock();
			Block block1 = world.getBlockState(pos.south()).getBlock();
			Block block2 = world.getBlockState(pos.east()).getBlock();
			Block block3 = world.getBlockState(pos.west()).getBlock();
			EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
			
			if (enumfacing == EnumFacing.NORTH && block0.isFullBlock() && !block1.isFullBlock()) {
				enumfacing = EnumFacing.SOUTH;
			}
			if (enumfacing == EnumFacing.SOUTH && block0.isFullBlock() && !block0.isFullBlock()) {
				enumfacing = EnumFacing.NORTH;
			}
			if (enumfacing == EnumFacing.WEST && block0.isFullBlock() && !block2.isFullBlock()) {
				enumfacing = EnumFacing.EAST;
			}
			if (enumfacing == EnumFacing.EAST && block0.isFullBlock() && !block3.isFullBlock()) {
				enumfacing = EnumFacing.WEST;
			}
			
			world.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		}
	}
	
	@SideOnly(Side.CLIENT)
    @SuppressWarnings("incomplete-switch")
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.isBurning)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
            double d2 = (double)pos.getZ() + 0.5D;
            double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;

            switch (enumfacing)
            {
                case WEST:
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case EAST:
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case NORTH:
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case SOUTH:
                    worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileBloomery();
	}
	
	public static void setState(boolean active, World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		TileEntity tile = world.getTileEntity(pos);
		keepInventory = true;
		
		if (active) {
			world.setBlockState(pos, IRCBlocks.bloomeryActive.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
			} 
			else {
				world.setBlockState(pos, IRCBlocks.bloomeryIdle.getDefaultState().withProperty(FACING, state.getValue(FACING)), 3);
			}
		
		keepInventory = false;
		
		if (tile != null) {
			tile.validate();
			world.setTileEntity(pos, tile);
		}
	}
	
	
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitz) {
		if (world.isRemote) return true;
		
		player.openGui(Main.instance, IRCGuiHandler.BLOOMERY_GUI,world, pos.getX(),pos.getY(), pos.getZ());
		return true;
		}
	}
