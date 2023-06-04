package net.salju.woodster.init;

import net.minecraftforge.common.ForgeConfigSpec;

public class WoodsterConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec CONFIG;

	public static final ForgeConfigSpec.BooleanValue BOOKSHELF;
	public static final ForgeConfigSpec.BooleanValue LADDER;
	
	static {
		BUILDER.push("Registry");
		BOOKSHELF = BUILDER.comment("Should Bookshelves be added?").define("Bookshelves", true);
		LADDER = BUILDER.comment("Should Ladders be added?").define("Ladders", true);
		BUILDER.pop();
		CONFIG = BUILDER.build();
	}
}