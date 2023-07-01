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
			for (int i = 0; i < 6; ++i) {
				if (!(be.getItem(i).isEmpty())) {
					books = (books + 1);
				}
			}
		}
		return books;
	}
}