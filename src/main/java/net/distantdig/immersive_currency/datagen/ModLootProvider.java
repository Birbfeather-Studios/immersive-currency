package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;


public class ModLootProvider extends FabricBlockLootTableProvider {
    public ModLootProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        add(ModBlocks.PURE_COPPER_ORE, pureOreDrops(ModBlocks.PURE_COPPER_ORE, ModItems.PURE_COPPER_NUGGET, 2.0f, 5.0f));
        add(ModBlocks.PURE_IRON_ORE, pureOreDrops(ModBlocks.PURE_IRON_ORE, ModItems.PURE_IRON_NUGGET, 1.0f, 3.0f));
        add(ModBlocks.PURE_GOLD_ORE, pureOreDrops(ModBlocks.PURE_GOLD_ORE, ModItems.PURE_GOLD_NUGGET, 1.0f, 2.0f));
        add(ModBlocks.PURE_PLATINUM_ORE, pureOreDrops(ModBlocks.PURE_PLATINUM_ORE, ModItems.PURE_PLATINUM_NUGGET, 1.0f, 1.0f));
    }

    public LootTable.Builder pureOreDrops(Block drop, Item item, float min, float max) {
        return BlockLootSubProvider.createSilkTouchDispatchTable(drop,
                (LootPoolEntryContainer.Builder)this.applyExplosionDecay(drop, ((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))))
                        ));
    }
}
