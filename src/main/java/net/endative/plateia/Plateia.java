package net.endative.plateia;

import net.endative.plateia.block.ModBlocks;
import net.endative.plateia.item.ModItemGroup;
import net.endative.plateia.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Plateia implements ModInitializer {
	public static final String MOD_ID = "plateia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroup.registerItemGroups();

	}
}
