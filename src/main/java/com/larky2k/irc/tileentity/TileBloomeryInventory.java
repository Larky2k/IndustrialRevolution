package com.larky2k.irc.tileentity;

import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;

public class TileBloomeryInventory extends TileEntity implements IInventory, ITickable {

	public static final int FUEL_SLOTS_COUNT = 1;
	public static final int INPUT_SLOTS_COUNT = 2;
	public static final int OUTPUT_SLOTS_COUNT = 2;
	public static final int TOTAL_SLOTS_COUNT = FUEL_SLOTS_COUNT + INPUT_SLOTS_COUNT + OUTPUT_SLOTS_COUNT;
	
	public static final int FIRST_FUEL_SLOT = 0;
	public static final int FIRST_INPUT_SLOT = FIRST_FUEL_SLOT + FUEL_SLOTS_COUNT;
	public static final int FIRST_OUTPUT_SLOT = FIRST_INPUT_SLOT + INPUT_SLOTS_COUNT;
	
	private ItemStack[] itemStacks = new ItemStack[TOTAL_SLOTS_COUNT];
	
	private int [] burnTimeRemaining = new int[FUEL_SLOTS_COUNT];
	
	private int [] burnTimeInitialValue = new int[FUEL_SLOTS_COUNT];
	
	private short cookTime;
	
	private static final short COOK_TIME_FOR_COMP = 100;
	
	private int cachedNumberOfBurningSlots = -1;
	
	public double fractionOfFuelRemaining(int fuelSlot) {
		if (burnTimeInitialValue[fuelSlot] <= 0) return 0;
		double fraction = burnTimeRemaining[fuelSlot] / (double)burnTimeInitialValue[fuelSlot];
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}
	
	public int secondsOfFuelRemaining(int fuelSlot) {
		if (burnTimeRemaining[fuelSlot] <= 0 ) return 0;
		return burnTimeRemaining[fuelSlot] / 20;
	}
	
	public int numberOfBurningFuelSlots() {
		int burningCount = 0;
		for (int burnTime : burnTimeRemaining) {
			if (burnTime > 0) ++burningCount;
		}
		return burningCount;
		
	public double fractionOfCookTimeComplete() {
		double fraction = cookTime / (double)COOK_TIME_FOR_COMP;
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}
	
	@Override
	public void update() {
		if (canSmelt()) {
			int numberOfFuelBurning = burnFuel();
			
			if (numberOfFuelBurning > 0) {
				cookTime += numberOfFuelBurning;
			}
				else {
				cookTime -= 2;
			}
			
			if (cookTime < 0) cookTime =  0;
			
			if (cookTime >= COOK_TIME_FOR_COMP) {
				smeltItem();
				cookTime = 0;
			}
			}
			else {
			cookTime = 0;
			}
		int numberBurning = numberOfBurningFuelSlots();
		if (cachedNumberOfBurningSlots != numberBurning) {
			cachedNumberOfBurningSlots = numberBurning;
			if (worldObj.isRemote) {
				worldObj.markBlockForUpdate(pos);
			}
			worldObj.checkLightFor(EnumSkyBlock.BLOCK, pos);
		}
		
	}
	
	private int burnFuel() {
		int burningCount = 0;
		boolean inventoryChanged = false;
		for (int i = 0; i < FUEL_SLOTS_COUNT; i++) {
			int fuelSlotNumber = i + FIRST_FUEL_SLOT;
			if (burnTimeRemaining[i] > 0) {
				--burnTimeRemaining[i];
				++burningCount;
			}
			if (burnTimeRemaining[i] == 0) {
				if (itemStacks[fuelSlotNumber] != null && getItemBurnTime(itemStacks[fuelSlotNumber]) > 0) {
					burnTimeRemaining[i] = burnTimeInitialValue[i] = getItemBurnTime(itemStacks[fuelSlotNumber]);
					--itemStacks[fuelSlotNumber].stackSize;
					++burningCount;
					inventoryChanged = true;
					if (itemStacks[fuelSlotNumber].stackSize == 0) {
						itemStacks[fuelSlotNumber] = itemStacks[fuelSlotNumber].getItem().getContainerItem(itemStacks[fuelSlotNumber]);
					}
				}
			}
		}
		if (inventoryChanged) markDirty();
		return burningCount;
	}
	
	private boolean canSmelt() {
		return smeltItem(false);
	}
	
	private void smeltItem() {
		smeltItem(true);
	}
	
	private boolean smeltItem(boolean performSmelt) {
		
		Integer firstSuitableInputSlot = null;
		Integer firstSuitableOutputSlot = null;
		ItemStack result = null;
	
		for (int inputSlot = FIRST_INPUT_SLOT; inputSlot < FIRST_INPUT_SLOT + INPUT_SLOTS_COUNT; inputSlot++) {
			if (itemStacks[inputSlot] != null) {
				result = getSmeltingResultForItem(itemStacks[inputSlot]);
			if (result != null) {
					for (int outputSlot = FIRST_OUTPUT_SLOT; outputSlot < FIRST_OUTPUT_SLOT + OUTPUT_SLOTS_COUNT; outputSlot++) {
						ItemStack outputStack = itemStacks[outputSlot];
						if  (outputSlot == null) {
							firstSuitableInputSlot = inputSlot;
							firstSuitableOutputSlot = outputSlot;
							break;
						}
						
						if (outputStack.getItem() == result.getItem() && (!outputStack.getHasSubtypes() || outputStack.getMetadata() == outputStack.getMetadata()) && ItemStack.areItemStacksEqual(outputStack, result)) {
							int combinedSize = itemStacks[outputSlot].stackSize + result.stackSize;
							if (combinedSize <= getInventoryStackLimit() && combinedSize <= itemStacks[outputSlot].getMaxStackSize()) {
								firstSuitableInputSlot = inputSlot;
								firstSuitableOutputSlot = outputSlot;
								break;
							}
						}
					}
					if (firstSuitableInputSlot != null) break;
					}
				}
			}
			if (firstSuitableInputSlot == null) return false;
			if (!performSmelt) return true;
			
			itemStacks[firstSuitableInputSlot].stackSize--;
			if (itemStacks[firstSuitableInputSlot].stackSize <=0) itemStacks[firstSuitableInputSlot] = null;
			if (itemStacks[firstSuitableOutputSlot] == null) {
				itemStacks[firstSuitableOutputSlot] = result.copy();
			}
			else {
				itemStacks[firstSuitableOutputSlot].stackSize += result.stackSize;
			}
			markDirty();
			return true;
	}
	
	public static ItemStack getSmeltingResultForItem(ItemStack stack) {
		return IRCSmelting.
	}
	}
	
	
	
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (this.worldObj.getTileEntity(this.pos) != this) return flase;
		final double X_CENTRE_OFFSET = 0.5;
		final double Y_CENTRE_OFFSET = 0.5;
		final double Z_CENTRE_OFFSET = 0.5;
		final double MAXIMUM_DISTANCE_SQ = 8.0 * 8.0;
		return player.getDistanceSq(pos.getX() + X_CENTRE_OFFSET, pos.getY() + Y_CENTRE_OFFSET, pos.getZ() + Z_CENTRE_OFFSET) < MAXIMUM_DISTANCE_SQ;
		
	}
}
