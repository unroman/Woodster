
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.salju.woodster.init;

import net.salju.woodster.client.gui.BookshelfInventoryScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WoodsterModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(WoodsterModMenus.BOOKSHELF_INVENTORY.get(), BookshelfInventoryScreen::new);
		});
	}
}
