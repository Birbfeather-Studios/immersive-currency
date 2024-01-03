package net.distantdig.immersive_currency.world;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURE_COPPER_ORE_KEY = registerKey("pure_copper_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURE_IRON_ORE_KEY = registerKey("pure_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURE_GOLD_ORE_KEY = registerKey("pure_gold_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PURE_PLATINUM_ORE_KEY = registerKey("pure_platinum_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest copperReplaceables = new BlockMatchTest(Blocks.COPPER_ORE);
        RuleTest deepslatecopperReplaceables = new BlockMatchTest(Blocks.DEEPSLATE_COPPER_ORE);
        RuleTest ironReplaceables = new BlockMatchTest(Blocks.IRON_ORE);
        RuleTest deepslateironReplaceables = new BlockMatchTest(Blocks.DEEPSLATE_IRON_ORE);
        RuleTest goldReplaceables = new BlockMatchTest(Blocks.GOLD_ORE);
        RuleTest deepslategoldReplaceables = new BlockMatchTest(Blocks.DEEPSLATE_GOLD_ORE);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> pureCopperOres =
                List.of(OreConfiguration.target(copperReplaceables, ModBlocks.PURE_COPPER_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslatecopperReplaceables, ModBlocks.PURE_COPPER_ORE.defaultBlockState())
                );
        List<OreConfiguration.TargetBlockState> pureIronOres =
                List.of(OreConfiguration.target(ironReplaceables, ModBlocks.PURE_IRON_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateironReplaceables, ModBlocks.PURE_IRON_ORE.defaultBlockState())
                );
        List<OreConfiguration.TargetBlockState> pureGoldOres =
                List.of(OreConfiguration.target(goldReplaceables, ModBlocks.PURE_GOLD_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslategoldReplaceables, ModBlocks.PURE_GOLD_ORE.defaultBlockState())
                );
        List<OreConfiguration.TargetBlockState> purePlatinumOres =
                List.of(OreConfiguration.target(deepslateReplaceables, ModBlocks.PURE_PLATINUM_ORE.defaultBlockState())
                );

        register(context, PURE_COPPER_ORE_KEY, Feature.ORE, new OreConfiguration(pureCopperOres, 13));
        register(context, PURE_IRON_ORE_KEY, Feature.ORE, new OreConfiguration(pureIronOres, 13));
        register(context, PURE_GOLD_ORE_KEY, Feature.ORE, new OreConfiguration(pureGoldOres, 13));
        register(context, PURE_PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(purePlatinumOres, 3));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ImmersiveCurrency.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
