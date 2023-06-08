package net.salju.woodster.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CreativeModeTabEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WoodsterTabs {
	@SubscribeEvent
	public static void buildTabContentsModded(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation("woodster"), builder -> builder.title(Component.translatable("itemGroup.woodster")).icon(() -> new ItemStack(WoodsterBlocks.OAK_CHISELED_BOOKSHELF.get().asItem())).displayItems((parameters, tabData) -> {
			tabData.accept(WoodsterBlocks.OAK_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.SPRUCE_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.BIRCH_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.JUNGLE_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.ACACIA_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.DARK_OAK_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.MANGROVE_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.CRIMSON_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.WARPED_CHISELED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.SPRUCE_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.BIRCH_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.JUNGLE_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.ACACIA_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.DARK_OAK_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.MANGROVE_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.CRIMSON_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.WARPED_BOOKSHELF.get().asItem());
			tabData.accept(WoodsterBlocks.SPRUCE_LADDER.get().asItem());
			tabData.accept(WoodsterBlocks.BIRCH_LADDER.get().asItem());
			tabData.accept(WoodsterBlocks.JUNGLE_LADDER.get().asItem());
			tabData.accept(WoodsterBlocks.ACACIA_LADDER.get().asItem());
			tabData.accept(WoodsterBlocks.DARK_OAK_LADDER.get().asItem());
			tabData.accept(WoodsterBlocks.MANGROVE_LADDER.get().asItem());
			tabData.accept(WoodsterBlocks.CRIMSON_LADDER.get().asItem());
			tabData.accept(WoodsterBlocks.WARPED_LADDER.get().asItem());
		}));
	}
}