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

                .add(BlockRegister.getBlock("pure_deepslate_copper_ore"))
                .add(BlockRegister.getBlock("pure_deepslate_iron_ore"))
                .add(BlockRegister.getBlock("pure_deepslate_gold_ore"))
                .add(BlockRegister.getBlock("pure_platinum_ore"))

                .add(BlockRegister.getBlock("copper_gilded_stone"))
                .add(BlockRegister.getBlock("copper_gilded_creeper_trim"))
                .add(BlockRegister.getBlock("copper_gilded_curly_trim"))
                .add(BlockRegister.getBlock("copper_gilded_brick"))
                .add(BlockRegister.getBlock("copper_gilded_bricks"))
                .add(BlockRegister.getBlock("copper_gilded_pillar"))
                .add(BlockRegister.getBlock("copper_gilded_plate"))
                .add(BlockRegister.getBlock("polished_gilded_copper"))
                .add(BlockRegister.getBlock("chiseled_gilded_copper"))
                .add(BlockRegister.getBlock("copper_gilded_stone_stair"))
                .add(BlockRegister.getBlock("copper_gilded_brick_stair"))
                .add(BlockRegister.getBlock("copper_gilded_stone_slab"))
                .add(BlockRegister.getBlock("copper_gilded_brick_slab"))
                .add(BlockRegister.getBlock("copper_gilded_stone_wall"))
                .add(BlockRegister.getBlock("copper_gilded_brick_wall"))

                .add(BlockRegister.getBlock("iron_gilded_stone"))
                .add(BlockRegister.getBlock("iron_gilded_creeper_trim"))
                .add(BlockRegister.getBlock("iron_gilded_curly_trim"))
                .add(BlockRegister.getBlock("iron_gilded_brick"))
                .add(BlockRegister.getBlock("iron_gilded_bricks"))
                .add(BlockRegister.getBlock("iron_gilded_pillar"))
                .add(BlockRegister.getBlock("iron_gilded_plate"))
                .add(BlockRegister.getBlock("polished_gilded_iron"))
                .add(BlockRegister.getBlock("chiseled_gilded_iron"))
                .add(BlockRegister.getBlock("iron_gilded_stone_stair"))
                .add(BlockRegister.getBlock("iron_gilded_brick_stair"))
                .add(BlockRegister.getBlock("iron_gilded_stone_slab"))
                .add(BlockRegister.getBlock("iron_gilded_brick_slab"))
                .add(BlockRegister.getBlock("iron_gilded_stone_wall"))
                .add(BlockRegister.getBlock("iron_gilded_brick_wall"))

                .add(BlockRegister.getBlock("gold_gilded_stone"))
                .add(BlockRegister.getBlock("gold_gilded_creeper_trim"))
                .add(BlockRegister.getBlock("gold_gilded_curly_trim"))
                .add(BlockRegister.getBlock("gold_gilded_brick"))
                .add(BlockRegister.getBlock("gold_gilded_bricks"))
                .add(BlockRegister.getBlock("gold_gilded_pillar"))
                .add(BlockRegister.getBlock("gold_gilded_plate"))
                .add(BlockRegister.getBlock("polished_gilded_gold"))
                .add(BlockRegister.getBlock("chiseled_gilded_gold"))
                .add(BlockRegister.getBlock("gold_gilded_stone_stair"))
                .add(BlockRegister.getBlock("gold_gilded_brick_stair"))
                .add(BlockRegister.getBlock("gold_gilded_stone_slab"))
                .add(BlockRegister.getBlock("gold_gilded_brick_slab"))
                .add(BlockRegister.getBlock("gold_gilded_stone_wall"))
                .add(BlockRegister.getBlock("gold_gilded_brick_wall"))

                .add(BlockRegister.getBlock("platinum_gilded_stone"))
                .add(BlockRegister.getBlock("platinum_gilded_creeper_trim"))
                .add(BlockRegister.getBlock("platinum_gilded_curly_trim"))
                .add(BlockRegister.getBlock("platinum_gilded_brick"))
                .add(BlockRegister.getBlock("platinum_gilded_bricks"))
                .add(BlockRegister.getBlock("platinum_gilded_pillar"))
                .add(BlockRegister.getBlock("platinum_gilded_plate"))
                .add(BlockRegister.getBlock("polished_gilded_platinum"))
                .add(BlockRegister.getBlock("chiseled_gilded_platinum"))
                .add(BlockRegister.getBlock("platinum_gilded_stone_stair"))
                .add(BlockRegister.getBlock("platinum_gilded_brick_stair"))
                .add(BlockRegister.getBlock("platinum_gilded_stone_slab"))
                .add(BlockRegister.getBlock("platinum_gilded_brick_slab"))
                .add(BlockRegister.getBlock("platinum_gilded_stone_wall"))
                .add(BlockRegister.getBlock("platinum_gilded_brick_wall"))

                .add(BlockRegister.getBlock("platinum_gilded_stone"))
                .add(BlockRegister.getBlock("platinum_gilded_creeper_trim"))
                .add(BlockRegister.getBlock("platinum_gilded_curly_trim"))
                .add(BlockRegister.getBlock("platinum_gilded_brick"))
                .add(BlockRegister.getBlock("platinum_gilded_bricks"))
                .add(BlockRegister.getBlock("platinum_gilded_pillar"))
                .add(BlockRegister.getBlock("platinum_gilded_plate"))
                .add(BlockRegister.getBlock("polished_gilded_platinum"))
                .add(BlockRegister.getBlock("chiseled_gilded_platinum"))
                .add(BlockRegister.getBlock("platinum_gilded_stone_stair"))
                .add(BlockRegister.getBlock("platinum_gilded_brick_stair"))
                .add(BlockRegister.getBlock("platinum_gilded_stone_slab"))
                .add(BlockRegister.getBlock("platinum_gilded_brick_slab"))
                .add(BlockRegister.getBlock("platinum_gilded_stone_wall"))
                .add(BlockRegister.getBlock("platinum_gilded_brick_wall"))

                .add(BlockRegister.getBlock("dense_emerald_block"))
                .add(BlockRegister.getBlock("dense_emerald_plate"))
                .add(BlockRegister.getBlock("chiseled_dense_emerald"))
                .add(BlockRegister.getBlock("dense_emerald_pillar"))
                .add(BlockRegister.getBlock("dense_emerald_curly_trim"))
                .add(BlockRegister.getBlock("dense_emerald_creeper_trim"))
                .add(BlockRegister.getBlock("dense_emerald_brick"))
                .add(BlockRegister.getBlock("dense_emerald_bricks"))
                .add(BlockRegister.getBlock("gilded_emerald_brick"))
                .add(BlockRegister.getBlock("gilded_emerald_pillar"))
                .add(BlockRegister.getBlock("dense_emerald_brick_stair"))
                .add(BlockRegister.getBlock("gilded_emerald_brick_stair"))
                .add(BlockRegister.getBlock("dense_emerald_brick_slab"))
                .add(BlockRegister.getBlock("gilded_emerald_brick_slab"))
                .add(BlockRegister.getBlock("dense_emerald_brick_wall"))
                .add(BlockRegister.getBlock("gilded_emerald_brick_wall"))

                .add(ModBlocks.PURE_COPPER_INGOT)
                .add(ModBlocks.PURE_IRON_INGOT)
                .add(ModBlocks.PURE_GOLD_INGOT)
                .add(ModBlocks.PURE_PLATINUM_INGOT);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.COPPER_COIN)
                .add(ModBlocks.IRON_COIN)
                .add(ModBlocks.GOLD_COIN)
                .add(ModBlocks.PLATINUM_COIN);

        getOrCreateTagBuilder(BlockTags.COPPER_ORES)
                .add(BlockRegister.getBlock("pure_copper_ore"))
                .add(BlockRegister.getBlock("pure_deepslate_copper_ore"));
        getOrCreateTagBuilder(BlockTags.IRON_ORES)
                .add(BlockRegister.getBlock("pure_iron_ore"))
                .add(BlockRegister.getBlock("pure_deepslate_iron_ore"));
        getOrCreateTagBuilder(BlockTags.GOLD_ORES)
                .add(BlockRegister.getBlock("pure_gold_ore"))
                .add(BlockRegister.getBlock("pure_deepslate_gold_ore"));

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(BlockRegister.getBlock("pure_copper_ore"))
                .add(BlockRegister.getBlock("pure_iron_ore"))

                .add(BlockRegister.getBlock("pure_deepslate_copper_ore"))
                .add(BlockRegister.getBlock("pure_deepslate_iron_ore"));

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegister.getBlock("pure_gold_ore"))
                .add(BlockRegister.getBlock("pure_deepslate_gold_ore"))
                .add(BlockRegister.getBlock("pure_platinum_ore"));
    }
}
