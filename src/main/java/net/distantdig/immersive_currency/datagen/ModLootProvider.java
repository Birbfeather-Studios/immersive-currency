package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootProvider extends FabricBlockLootTableProvider {
    public ModLootProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PURE_COPPER_ORE, pureOreDrops(ModBlocks.PURE_COPPER_ORE, ModItems.PURE_COPPER_NUGGET, 2.0f, 5.0f));
        addDrop(ModBlocks.PURE_IRON_ORE, pureOreDrops(ModBlocks.PURE_IRON_ORE, ModItems.PURE_IRON_NUGGET, 1.0f, 3.0f));
        addDrop(ModBlocks.PURE_GOLD_ORE, pureOreDrops(ModBlocks.PURE_GOLD_ORE, ModItems.PURE_GOLD_NUGGET, 1.0f, 2.0f));
        addDrop(ModBlocks.PURE_PLATINUM_ORE, pureOreDrops(ModBlocks.PURE_PLATINUM_ORE, ModItems.PURE_PLATINUM_NUGGET, 1.0f, 1.0f));
    }

    public LootTable.Builder pureOreDrops(Block drop, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder) ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max))))
                        ));
    }
}
