package net.distantdig.immersive_currency;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.fluid.ModFluids;
import net.distantdig.immersive_currency.item.ModItemGroups;
import net.distantdig.immersive_currency.item.ModItems;
import net.distantdig.immersive_currency.util.ModLootTableModifiers;
import net.distantdig.immersive_currency.util.ModLootTables;
import net.distantdig.immersive_currency.world.gen.ModOreGen;
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
		ModFluids.registerModFluids();

		ModLootTables.registerLootTables();
		ModLootTableModifiers.ModifyLootTables();

		ModOreGen.generateOres();
	}
}