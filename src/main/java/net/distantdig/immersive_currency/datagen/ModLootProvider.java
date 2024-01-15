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
