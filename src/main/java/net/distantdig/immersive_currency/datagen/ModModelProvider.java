package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURE_COPPER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURE_IRON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURE_GOLD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PURE_PLATINUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COPPER_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_COIN, Models.GENERATED);

        itemModelGenerator.register(ModItems.PURE_COPPER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_IRON_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_GOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_PLATINUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.PURE_COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_IRON_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_GOLD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURE_PLATINUM_NUGGET, Models.GENERATED);
    }
}
