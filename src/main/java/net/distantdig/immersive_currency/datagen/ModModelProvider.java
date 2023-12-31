package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.BlockRegister;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.fluid.ModFluids;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.BlockModelGenerators.BlockFamilyProvider;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    final BlockFamily emeraldbrickfamily = BlockFamilies
            .familyBuilder(BlockRegister.getBlock( "dense_emerald_brick"))
            .slab(BlockRegister.getBlock("dense_emerald_brick_slab"))
            .stairs(BlockRegister.getBlock("dense_emerald_brick_stair"))
            .wall(BlockRegister.getBlock("dense_emerald_brick_wall"))
            .getFamily();
    
    final BlockFamily emeraldgildedfamily = BlockFamilies
            .familyBuilder(BlockRegister.getBlock( "gilded_emerald_brick"))
            .slab(BlockRegister.getBlock("gilded_emerald_brick_slab"))
            .stairs(BlockRegister.getBlock("gilded_emerald_brick_stair"))
            .wall(BlockRegister.getBlock("gilded_emerald_brick_wall"))
            .getFamily();

    public void generateGildedBlockStateModels(BlockModelGenerators blockModelGenerators, String key) {
        final BlockFamily slabwallstairstonefamily = BlockFamilies.familyBuilder(BlockRegister.getBlock(key + "_gilded_stone")).slab(BlockRegister.getBlock(key + "_gilded_stone_slab")).stairs(BlockRegister.getBlock(key + "_gilded_stone_stair")).wall(BlockRegister.getBlock(key + "_gilded_stone_wall")).getFamily();
        final BlockFamily slabwallstairbrickfamily = BlockFamilies.familyBuilder(BlockRegister.getBlock(key + "_gilded_brick")).slab(BlockRegister.getBlock(key + "_gilded_brick_slab")).stairs(BlockRegister.getBlock(key + "_gilded_brick_stair")).wall(BlockRegister.getBlock(key + "_gilded_brick_wall")).getFamily();
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_creeper_trim"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_curly_trim"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_bricks"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_pillar"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock(key + "_gilded_plate"));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock("polished_gilded_" + key));
        blockModelGenerators.createTrivialCube(BlockRegister.getBlock("chiseled_gilded_" + key));
        blockModelGenerators.family(slabwallstairstonefamily.getBaseBlock()).generateFor(slabwallstairstonefamily);
        blockModelGenerators.family(slabwallstairbrickfamily.getBaseBlock()).generateFor(slabwallstairbrickfamily);
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
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("dense_emerald_block"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("dense_emerald_creeper_trim"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("dense_emerald_curly_trim"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("dense_emerald_bricks"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("dense_emerald_pillar"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("dense_emerald_plate"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("gilded_emerald_pillar"));
        blockStateModelGenerators.createTrivialCube(BlockRegister.getBlock("chiseled_dense_emerald"));
        blockStateModelGenerators.family(emeraldbrickfamily.getBaseBlock()).generateFor(emeraldbrickfamily);
        blockStateModelGenerators.family(emeraldgildedfamily.getBaseBlock()).generateFor(emeraldgildedfamily);
        generateGildedBlockStateModels(blockStateModelGenerators, "copper");
        generateGildedBlockStateModels(blockStateModelGenerators, "iron");
        generateGildedBlockStateModels(blockStateModelGenerators, "gold");
        generateGildedBlockStateModels(blockStateModelGenerators, "platinum");
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.COIN_POUCH, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModFluids.COPPER_COIN_BUCKET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModFluids.IRON_COIN_BUCKET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModFluids.GOLD_COIN_BUCKET, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModFluids.PLATINUM_COIN_BUCKET, ModelTemplates.FLAT_ITEM);

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
