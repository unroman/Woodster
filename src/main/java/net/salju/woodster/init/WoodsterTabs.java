package net.salju.woodster.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class WoodsterTabs {
	public static CreativeModeTab WOODSTER;

	public static void load() {
		WOODSTER = new CreativeModeTab("woodster") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(WoodsterItems.OAK_CHISELED_BOOKSHELF.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}