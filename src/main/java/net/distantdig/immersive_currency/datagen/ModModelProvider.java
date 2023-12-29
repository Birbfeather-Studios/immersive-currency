package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.fluid.ModFluids;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerators) {
        blockStateModelGenerators.createTrivialCube(ModBlocks.PURE_COPPER_ORE);
        blockStateModelGenerators.createTrivialCube(ModBlocks.PURE_IRON_ORE);
        blockStateModelGenerators.createTrivialCube(ModBlocks.PURE_GOLD_ORE);
        blockStateModelGenerators.createTrivialCube(ModBlocks.PURE_PLATINUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.COIN_POUCH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModFluids.COIN_BUCKET, ModelTemplates.FLAT_ITEM);

//        itemModelGenerators.generateFlatItem(ModBlocks.COPPER_COIN.asItem(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModBlocks.IRON_COIN.asItem(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModBlocks.GOLD_COIN.asItem(), ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModBlocks.PLATINUM_COIN.asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.PURE_COPPER_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PURE_IRON_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PURE_GOLD_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PURE_PLATINUM_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.LARGE_EMERALD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.EMERALD_CHUNK, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.EMERALD_SHARD, ModelTemplates.FLAT_ITEM);
    }
}
