package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.BlockRegister;
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

    public void generateGildedBlockStateModels(BlockModelGenerators blockModelGenerators, String key) {
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_creeper_trim"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_curly_trim"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_brick"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_bricks"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_pillar"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_plate"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_stone"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock("polished_gilded_" + key));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock("chiseled_gilded_" + key));
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerators) {
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("pure_copper_ore"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("pure_deepslate_copper_ore"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("pure_iron_ore"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("pure_deepslate_iron_ore"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("pure_gold_ore"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("pure_deepslate_gold_ore"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("pure_platinum_ore"));
        generateGildedBlockStateModels(blockStateModelGenerators, "copper");
        generateGildedBlockStateModels(blockStateModelGenerators, "iron");
        generateGildedBlockStateModels(blockStateModelGenerators, "gold");
        generateGildedBlockStateModels(blockStateModelGenerators, "platinum");
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.COIN_POUCH, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModFluids.GOLD_COIN_BUCKET, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModBlocks.COPPER_COIN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModBlocks.IRON_COIN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModBlocks.GOLD_COIN.asItem(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModBlocks.PLATINUM_COIN.asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.PURE_COPPER_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PURE_IRON_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PURE_GOLD_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PURE_PLATINUM_NUGGET, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.LARGE_EMERALD, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.EMERALD_CHUNK, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.EMERALD_SHARD, ModelTemplates.FLAT_ITEM);
    }
}
