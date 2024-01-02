package net.distantdig.immersive_currency.util;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.Nullable;

public class ModLootTables {

    public static LootPool.Builder coinPouch;
    public static LootPool.Builder pureNuggets;
    public static LootPool.Builder pureIngots;
    public static LootPool.Builder coinsLow;
    public static LootPool.Builder coinsHigh;
    public static LootPool.Builder platOnly;
    public static LootPool.Builder goldOnly;
    public static LootPool.Builder emeraldsLow;
    public static LootPool.Builder emeraldsHigh;

    public static LootPool.Builder getLootPool(ItemLike itemLike1, @Nullable ItemLike itemLike2,
                                               @Nullable ItemLike itemLike3, @Nullable ItemLike itemLike4,
                                               Float chance, Float minCount, Float maxCount) {
        if (itemLike4 != null && itemLike3 == null) {
            itemLike3 = itemLike4;
        }
        if (itemLike3 != null && itemLike2 == null) {
            itemLike2 = itemLike3;
        }

        if (itemLike4 != null) {
            return LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(chance))
                    .add(LootItem.lootTableItem(itemLike1))
                    .add(LootItem.lootTableItem(itemLike2))
                    .add(LootItem.lootTableItem(itemLike3))
                    .add(LootItem.lootTableItem(itemLike4))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minCount, maxCount)).build());
        } else if (itemLike3 != null) {
            return LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(chance))
                    .add(LootItem.lootTableItem(itemLike1))
                    .add(LootItem.lootTableItem(itemLike2))
                    .add(LootItem.lootTableItem(itemLike3))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minCount, maxCount)).build());
        } else if (itemLike2 != null) {
            return LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(chance))
                    .add(LootItem.lootTableItem(itemLike1))
                    .add(LootItem.lootTableItem(itemLike2))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minCount, maxCount)).build());
        } else {
            return LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(chance))
                    .add(LootItem.lootTableItem(itemLike1))
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(minCount, maxCount)).build());
        }
    }

    public static void registerLootTables() {
        coinPouch = getLootPool(ModItems.COIN_POUCH, null,
                null, null, .1f, 1.0f, 1.0f);

        pureNuggets = getLootPool(ModItems.PURE_COPPER_NUGGET, ModItems.PURE_IRON_NUGGET,
                ModItems.PURE_GOLD_NUGGET, null, .75f, 1.0f, 4.0f);

        pureIngots = getLootPool(ModBlocks.PURE_COPPER_INGOT, ModBlocks.PURE_IRON_INGOT,
                ModBlocks.PURE_GOLD_INGOT, null, .75f, 1.0f, 3.0f);

        coinsLow = getLootPool(ModBlocks.COPPER_COIN, ModBlocks.IRON_COIN,
                null, null, .9f, 1.0f, 4.0f);

        coinsHigh = getLootPool(ModBlocks.GOLD_COIN, ModBlocks.IRON_COIN,
                null, null, .7f, 1.0f, 4.0f);

        platOnly = getLootPool(ModBlocks.PLATINUM_COIN, ModBlocks.PURE_PLATINUM_INGOT,
                null, null, .2f, 1.0f, 1.0f);

        goldOnly = getLootPool(ModItems.PURE_GOLD_NUGGET, ModBlocks.PURE_GOLD_INGOT,
                ModBlocks.GOLD_COIN, null, .5f, 1.0f, 2.0f);

        emeraldsLow = getLootPool(ModItems.EMERALD_SHARD, ModItems.EMERALD_CHUNK,
                null, null, .5f, 1.0f, 4.0f);

        emeraldsHigh = getLootPool(ModItems.LARGE_EMERALD, null,
                null, null, .3f, 1.0f, 1.0f);
    }
}
