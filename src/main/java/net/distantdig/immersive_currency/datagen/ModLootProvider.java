package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.BlockRegister;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.block.custom.BarBlock;
import net.distantdig.immersive_currency.block.custom.CoinBlock;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;


public class ModLootProvider extends FabricBlockLootTableProvider {
    public ModLootProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        add(BlockRegister.getBlock("pure_copper_ore"), pureOreDrops(BlockRegister.getBlock("pure_copper_ore"), ModItems.PURE_COPPER_NUGGET, 2.0f, 5.0f));
        add(BlockRegister.getBlock("pure_deepslate_copper_ore"), pureOreDrops(BlockRegister.getBlock("pure_deepslate_copper_ore"), ModItems.PURE_COPPER_NUGGET, 2.0f, 5.0f));
        add(BlockRegister.getBlock("pure_iron_ore"), pureOreDrops(BlockRegister.getBlock("pure_iron_ore"), ModItems.PURE_IRON_NUGGET, 1.0f, 3.0f));
        add(BlockRegister.getBlock("pure_deepslate_iron_ore"), pureOreDrops(BlockRegister.getBlock("pure_deepslate_iron_ore"), ModItems.PURE_IRON_NUGGET, 1.0f, 3.0f));
        add(BlockRegister.getBlock("pure_gold_ore"), pureOreDrops(BlockRegister.getBlock("pure_gold_ore"), ModItems.PURE_GOLD_NUGGET, 1.0f, 2.0f));
        add(BlockRegister.getBlock("pure_deepslate_gold_ore"), pureOreDrops(BlockRegister.getBlock("pure_deepslate_gold_ore"), ModItems.PURE_GOLD_NUGGET, 1.0f, 2.0f));
        add(BlockRegister.getBlock("pure_platinum_ore"), pureOreDrops(BlockRegister.getBlock("pure_platinum_ore"), ModItems.PURE_PLATINUM_NUGGET, 1.0f, 1.0f));

        add(ModBlocks.COPPER_COIN, (this::createCoinDrops));
        add(ModBlocks.IRON_COIN, (this::createCoinDrops));
        add(ModBlocks.GOLD_COIN, (this::createCoinDrops));
        add(ModBlocks.PLATINUM_COIN, (this::createCoinDrops));

        add(ModBlocks.PURE_COPPER_INGOT, (this::createBarDrops));
        add(ModBlocks.PURE_IRON_INGOT, (this::createBarDrops));
        add(ModBlocks.PURE_GOLD_INGOT, (this::createBarDrops));
        add(ModBlocks.PURE_PLATINUM_INGOT, (this::createBarDrops));

        add(BlockRegister.getBlock("copper_gilded_stone"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_stone").asItem())));
                add(BlockRegister.getBlock("copper_gilded_creeper_trim"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_creeper_trim").asItem())));
                add(BlockRegister.getBlock("copper_gilded_curly_trim"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_curly_trim").asItem())));
                add(BlockRegister.getBlock("copper_gilded_brick"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_brick").asItem())));
                add(BlockRegister.getBlock("copper_gilded_bricks"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_bricks").asItem())));
                add(BlockRegister.getBlock("copper_gilded_pillar"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_pillar").asItem())));
                add(BlockRegister.getBlock("copper_gilded_plate"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_plate").asItem())));
                add(BlockRegister.getBlock("polished_gilded_copper"), (this.createSingleItemTable(BlockRegister.getBlock("polished_gilded_copper").asItem())));
                add(BlockRegister.getBlock("chiseled_gilded_copper"), (this.createSingleItemTable(BlockRegister.getBlock("chiseled_gilded_copper").asItem())));
                add(BlockRegister.getBlock("copper_gilded_stone_stair"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_stone_stair").asItem())));
                add(BlockRegister.getBlock("copper_gilded_brick_stair"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_brick_stair").asItem())));
                add(BlockRegister.getBlock("copper_gilded_stone_slab"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_stone_slab").asItem())));
                add(BlockRegister.getBlock("copper_gilded_brick_slab"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_brick_slab").asItem())));
                add(BlockRegister.getBlock("copper_gilded_stone_wall"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_stone_wall").asItem())));
                add(BlockRegister.getBlock("copper_gilded_brick_wall"), (this.createSingleItemTable(BlockRegister.getBlock("copper_gilded_brick_wall").asItem())));

                add(BlockRegister.getBlock("iron_gilded_stone"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_stone").asItem())));
                add(BlockRegister.getBlock("iron_gilded_creeper_trim"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_creeper_trim").asItem())));
                add(BlockRegister.getBlock("iron_gilded_curly_trim"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_curly_trim").asItem())));
                add(BlockRegister.getBlock("iron_gilded_brick"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_brick").asItem())));
                add(BlockRegister.getBlock("iron_gilded_bricks"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_bricks").asItem())));
                add(BlockRegister.getBlock("iron_gilded_pillar"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_pillar").asItem())));
                add(BlockRegister.getBlock("iron_gilded_plate"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_plate").asItem())));
                add(BlockRegister.getBlock("polished_gilded_iron"), (this.createSingleItemTable(BlockRegister.getBlock("polished_gilded_iron").asItem())));
                add(BlockRegister.getBlock("chiseled_gilded_iron"), (this.createSingleItemTable(BlockRegister.getBlock("chiseled_gilded_iron").asItem())));
                add(BlockRegister.getBlock("iron_gilded_stone_stair"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_stone_stair").asItem())));
                add(BlockRegister.getBlock("iron_gilded_brick_stair"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_brick_stair").asItem())));
                add(BlockRegister.getBlock("iron_gilded_stone_slab"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_stone_slab").asItem())));
                add(BlockRegister.getBlock("iron_gilded_brick_slab"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_brick_slab").asItem())));
                add(BlockRegister.getBlock("iron_gilded_stone_wall"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_stone_wall").asItem())));
                add(BlockRegister.getBlock("iron_gilded_brick_wall"), (this.createSingleItemTable(BlockRegister.getBlock("iron_gilded_brick_wall").asItem())));

                add(BlockRegister.getBlock("gold_gilded_stone"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_stone").asItem())));
                add(BlockRegister.getBlock("gold_gilded_creeper_trim"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_creeper_trim").asItem())));
                add(BlockRegister.getBlock("gold_gilded_curly_trim"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_curly_trim").asItem())));
                add(BlockRegister.getBlock("gold_gilded_brick"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_brick").asItem())));
                add(BlockRegister.getBlock("gold_gilded_bricks"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_bricks").asItem())));
                add(BlockRegister.getBlock("gold_gilded_pillar"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_pillar").asItem())));
                add(BlockRegister.getBlock("gold_gilded_plate"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_plate").asItem())));
                add(BlockRegister.getBlock("polished_gilded_gold"), (this.createSingleItemTable(BlockRegister.getBlock("polished_gilded_gold").asItem())));
                add(BlockRegister.getBlock("chiseled_gilded_gold"), (this.createSingleItemTable(BlockRegister.getBlock("chiseled_gilded_gold").asItem())));
                add(BlockRegister.getBlock("gold_gilded_stone_stair"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_stone_stair").asItem())));
                add(BlockRegister.getBlock("gold_gilded_brick_stair"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_brick_stair").asItem())));
                add(BlockRegister.getBlock("gold_gilded_stone_slab"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_stone_slab").asItem())));
                add(BlockRegister.getBlock("gold_gilded_brick_slab"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_brick_slab").asItem())));
                add(BlockRegister.getBlock("gold_gilded_stone_wall"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_stone_wall").asItem())));
                add(BlockRegister.getBlock("gold_gilded_brick_wall"), (this.createSingleItemTable(BlockRegister.getBlock("gold_gilded_brick_wall").asItem())));

                add(BlockRegister.getBlock("platinum_gilded_stone"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_stone").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_creeper_trim"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_creeper_trim").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_curly_trim"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_curly_trim").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_brick"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_brick").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_bricks"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_bricks").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_pillar"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_pillar").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_plate"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_plate").asItem())));
                add(BlockRegister.getBlock("polished_gilded_platinum"), (this.createSingleItemTable(BlockRegister.getBlock("polished_gilded_platinum").asItem())));
                add(BlockRegister.getBlock("chiseled_gilded_platinum"), (this.createSingleItemTable(BlockRegister.getBlock("chiseled_gilded_platinum").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_stone_stair"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_stone_stair").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_brick_stair"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_brick_stair").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_stone_slab"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_stone_slab").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_brick_slab"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_brick_slab").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_stone_wall"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_stone_wall").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_brick_wall"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_brick_wall").asItem())));

                add(BlockRegister.getBlock("platinum_gilded_stone"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_stone").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_creeper_trim"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_creeper_trim").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_curly_trim"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_curly_trim").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_brick"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_brick").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_bricks"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_bricks").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_pillar"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_pillar").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_plate"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_plate").asItem())));
                add(BlockRegister.getBlock("polished_gilded_platinum"), (this.createSingleItemTable(BlockRegister.getBlock("polished_gilded_platinum").asItem())));
                add(BlockRegister.getBlock("chiseled_gilded_platinum"), (this.createSingleItemTable(BlockRegister.getBlock("chiseled_gilded_platinum").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_stone_stair"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_stone_stair").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_brick_stair"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_brick_stair").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_stone_slab"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_stone_slab").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_brick_slab"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_brick_slab").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_stone_wall"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_stone_wall").asItem())));
                add(BlockRegister.getBlock("platinum_gilded_brick_wall"), (this.createSingleItemTable(BlockRegister.getBlock("platinum_gilded_brick_wall").asItem())));

                add(BlockRegister.getBlock("dense_emerald_block"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_block").asItem())));
                add(BlockRegister.getBlock("dense_emerald_plate"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_plate").asItem())));
                add(BlockRegister.getBlock("chiseled_dense_emerald"), (this.createSingleItemTable(BlockRegister.getBlock("chiseled_dense_emerald").asItem())));
                add(BlockRegister.getBlock("dense_emerald_pillar"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_pillar").asItem())));
                add(BlockRegister.getBlock("dense_emerald_curly_trim"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_curly_trim").asItem())));
                add(BlockRegister.getBlock("dense_emerald_creeper_trim"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_creeper_trim").asItem())));
                add(BlockRegister.getBlock("dense_emerald_brick"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_brick").asItem())));
                add(BlockRegister.getBlock("dense_emerald_bricks"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_bricks").asItem())));
                add(BlockRegister.getBlock("gilded_emerald_brick"), (this.createSingleItemTable(BlockRegister.getBlock("gilded_emerald_brick").asItem())));
                add(BlockRegister.getBlock("gilded_emerald_pillar"), (this.createSingleItemTable(BlockRegister.getBlock("gilded_emerald_pillar").asItem())));
                add(BlockRegister.getBlock("dense_emerald_brick_stair"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_brick_stair").asItem())));
                add(BlockRegister.getBlock("gilded_emerald_brick_stair"), (this.createSingleItemTable(BlockRegister.getBlock("gilded_emerald_brick_stair").asItem())));
                add(BlockRegister.getBlock("dense_emerald_brick_slab"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_brick_slab").asItem())));
                add(BlockRegister.getBlock("gilded_emerald_brick_slab"), (this.createSingleItemTable(BlockRegister.getBlock("gilded_emerald_brick_slab").asItem())));
                add(BlockRegister.getBlock("dense_emerald_brick_wall"), (this.createSingleItemTable(BlockRegister.getBlock("dense_emerald_brick_wall").asItem())));
                add(BlockRegister.getBlock("gilded_emerald_brick_wall"), (this.createSingleItemTable(BlockRegister.getBlock("gilded_emerald_brick_wall").asItem())));
    }

    public LootTable.Builder pureOreDrops(Block drop, Item item, float min, float max) {
        return BlockLootSubProvider.createSilkTouchDispatchTable(drop,
                (LootPoolEntryContainer.Builder)this.applyExplosionDecay(drop, ((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))))
                        ));
    }

    public LootTable.Builder createCoinDrops(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)
                        .apply(List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16),
                                (integer) -> SetItemCountFunction.setCount(ConstantValue.exactly((float)integer))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(CoinBlock.COINS, integer)))))));
    }

    public LootTable.Builder createBarDrops(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block)
                        .apply(List.of(2, 3, 4, 5, 6, 7, 8),
                                (integer) -> SetItemCountFunction.setCount(ConstantValue.exactly((float)integer))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(BarBlock.BARS, integer)))))));
    }
}
