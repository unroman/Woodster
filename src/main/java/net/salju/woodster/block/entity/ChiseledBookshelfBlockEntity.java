package net.salju.woodster.block.entity;

import net.salju.woodster.world.inventory.BookshelfInventoryMenu;
import net.salju.woodster.init.WoodsterBlockEntities;
import net.salju.woodster.block.ChiseledBookshelfBlock;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

public class ChiseledBookshelfBlockEntity extends RandomizableContainerBlockEntity {
	public NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(9, ItemStack.EMPTY);

	public ChiseledBookshelfBlockEntity(BlockPos pos, BlockState state) {
		super(WoodsterBlockEntities.CHISELED_BOOKSHELF.get(), pos, state);
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks);
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks);
		}
	}

	@Override
	public Component getDefaultName() {
		return Component.translatable("gui.woodster.bookshelf");
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new BookshelfInventoryMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	public void updateBlockState(BlockState state) {
		int i = ((int) Math.round(ChiseledBookshelfBlock.getBooks(this) / 1.5));
		this.level.setBlock(this.getBlockPos(), state.setValue(ChiseledBookshelfBlock.BOOKS, Integer.valueOf(Math.min(6, i))), 3);
	}
}