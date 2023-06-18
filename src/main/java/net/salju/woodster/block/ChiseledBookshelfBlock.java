package net.salju.woodster.block;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.ChiseledBookShelfBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.core.Direction;

public class ChiseledBookshelfBlock extends ChiseledBookShelfBlock {
	public ChiseledBookshelfBlock(BlockBehaviour.Properties props) {
		super(props);
		BlockState state = this.stateDefinition.any().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH);
		for (BooleanProperty bool : ChiseledBookShelfBlock.SLOT_OCCUPIED_PROPERTIES) {
			state = state.setValue(bool, Boolean.valueOf(false));
		}
		this.registerDefaultState(state);
	}

	public static int getBooks(BlockEntity target) {
		int books = 0;
		if (target instanceof ChiseledBookShelfBlockEntity be) {
			if (!(be.getItem(0).isEmpty())) {
				books = (books + 1);
			}
			if (!(be.getItem(1).isEmpty())) {
				books = (books + 1);
			}
			if (!(be.getItem(2).isEmpty())) {
				books = (books + 1);
			}
			if (!(be.getItem(3).isEmpty())) {
				books = (books + 1);
			}
			if (!(be.getItem(4).isEmpty())) {
				books = (books + 1);
			}
			if (!(be.getItem(5).isEmpty())) {
				books = (books + 1);
			}
		}
		return books;
	}
}