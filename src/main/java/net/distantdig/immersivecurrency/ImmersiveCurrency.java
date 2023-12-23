package net.distantdig.immersivecurrency;

import net.distantdig.immersivecurrency.block.ModBlocks;
import net.distantdig.immersivecurrency.item.ModItemGroups;
import net.distantdig.immersivecurrency.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImmersiveCurrency implements ModInitializer {
	public static final String MOD_ID = "immersive_currency";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}