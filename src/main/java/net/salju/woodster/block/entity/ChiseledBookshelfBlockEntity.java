package net.salju.woodster.block.entity;

import net.salju.woodster.world.inventory.BookshelfInventoryMenu;
import net.salju.woodster.init.WoodsterBlockEntities;
import net.salju.woodster.block.ChiseledBookshelfBlock;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;
import java.util.stream.IntStream;
import io.netty.buffer.Unpooled;

public class ChiseledBookshelfBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	public NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(9, ItemStack.EMPTY);
	
	public ChiseledBookshelfBlockEntity(BlockPos pos, BlockState state) {
		super(WoodsterBlockEntities.CHISELED_BOOKSHELF.get(), pos, state);
	}
	
	@Override
	public int getContainerSize() {
		return stacks.size();
	}
	
	@Override
	public Component getDefaultName() {
		return Component.translatable("gui.woodster.bookshelf_inventory.label_chiseled_bookshelf");
	}
	
	@Override
	public void load(CompoundTag tag) {
		super.load(tag);
		if (!this.tryLoadLootTable(tag))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(tag, this.stacks);
	}
	
	@Override
	public void saveAdditional(CompoundTag tag) {
		super.saveAdditional(tag);
		if (!this.trySaveLootTable(tag)) {
			ContainerHelper.saveAllItems(tag, this.stacks);
		}
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}
	
	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}
	@Override
	public int[] getSlotsForFace(Direction dir) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}
	
	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithoutMetadata();
	}
	
	@Override
	public void startOpen(Player player) {
		if (!this.remove && !player.isSpectator()) {
			double x = (double) this.worldPosition.getX() + 0.5D;
			double y = (double) this.worldPosition.getY() + 0.5D;
			double z = (double) this.worldPosition.getZ() + 0.5D;
			this.level.playSound(null, x, y, z, SoundEvents.BOOK_PUT, SoundSource.BLOCKS, 1, this.level.random.nextFloat() * 0.1F + 0.95F);
		}
	}
	
	@Override
	public void stopOpen(Player player) {
		if (!this.remove && !player.isSpectator()) {
			double x = (double) this.worldPosition.getX() + 0.5D;
			double y = (double) this.worldPosition.getY() + 0.5D;
			double z = (double) this.worldPosition.getZ() + 0.5D;
			this.level.playSound(null, x, y, z, SoundEvents.BOOK_PUT, SoundSource.BLOCKS, 1, this.level.random.nextFloat() * 0.1F + 0.85F);
		}
	}
	
	@Override
	public AbstractContainerMenu createMenu(int id, Inventory player) {
		return new BookshelfInventoryMenu(id, player, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}
	
	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		return stack.is(ItemTags.create(new ResourceLocation("woodster:books")));
	}
	
	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction dir) {
		return this.canPlaceItem(index, stack);
	}
	
	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction dir) {
		return this.canPlaceItem(index, stack);
	}
	
	public void updateBlockState(BlockState state) {
		int i = ((int) Math.round(ChiseledBookshelfBlock.getBooks(this) / 1.5));
		this.level.setBlock(this.getBlockPos(), state.setValue(ChiseledBookshelfBlock.BOOKS, Integer.valueOf(Math.min(6, i))), 3);
	}
}