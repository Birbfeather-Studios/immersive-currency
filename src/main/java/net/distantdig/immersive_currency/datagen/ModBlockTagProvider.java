package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.BlockRegister;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegister.getBlock("pure_copper_ore"))
                .add(BlockRegister.getBlock("pure_iron_ore"))
                .add(BlockRegister.getBlock("pure_gold_ore"))
                .add(BlockRegister.getBlock("pure_platinum_ore"));

        getOrCreateTagBuilder(BlockTags.COPPER_ORES)
                .add(ModBlocks.PURE_COPPER_ORE);
        getOrCreateTagBuilder(BlockTags.IRON_ORES)
                .add(ModBlocks.PURE_IRON_ORE);
        getOrCreateTagBuilder(BlockTags.GOLD_ORES)
                .add(ModBlocks.PURE_GOLD_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockRegister.getBlock("pure_copper_ore"))
                .add(BlockRegister.getBlock("pure_iron_ore"));

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegister.getBlock("pure_gold_ore"))
                .add(BlockRegister.getBlock("pure_platinum_ore"));
    }
}
