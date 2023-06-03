
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.salju.woodster.init;

import net.salju.woodster.world.inventory.BookshelfInventoryMenu;
import net.salju.woodster.WoodsterMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class WoodsterModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, WoodsterMod.MODID);
	public static final RegistryObject<MenuType<BookshelfInventoryMenu>> BOOKSHELF_INVENTORY = REGISTRY.register("bookshelf_inventory", () -> IForgeMenuType.create(BookshelfInventoryMenu::new));
}
