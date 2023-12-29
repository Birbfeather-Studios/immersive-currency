package net.distantdig.immersive_currency;

import net.distantdig.immersive_currency.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ImmersiveCurrencyDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModFluidTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
