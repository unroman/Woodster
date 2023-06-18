package net.salju.woodster.mixins;

import org.spongepowered.asm.mixin.Mixin;
import net.salju.woodster.block.ChiseledBookshelfBlock;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

@Mixin(ChiseledBookShelfBlock.class)
public abstract class ChiseledBookShelfMixin extends BaseEntityBlock {
	public ChiseledBookShelfMixin(BlockBehaviour.Properties props) {
		super(props);
		BlockState state = this.stateDefinition.any().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH);
		for (BooleanProperty bool : ChiseledBookShelfBlock.SLOT_OCCUPIED_PROPERTIES) {
			state = state.setValue(bool, Boolean.valueOf(false));
		}
		this.registerDefaultState(state);
	}

	@Override
	public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		return state.getValue(HorizontalDirectionalBlock.FACING) == side;
	}

	@Override
	public boolean isSignalSource(BlockState state) {
		return true;
	}

	@Override
	public int getSignal(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
		BlockEntity target = world.getBlockEntity(pos);
		int i = (ChiseledBookshelfBlock.getBooks(target));
		return state.getValue(HorizontalDirectionalBlock.FACING) == side ? Integer.valueOf(Math.min(15, i * 2)) : 0;
	}

	@Override
	public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
		BlockEntity target = world.getBlockEntity(pos);
		return (ChiseledBookshelfBlock.getBooks(target) >= 3) ? 1f : 0f;
	}
}