package net.distantdig.immersive_currency.world;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> PURE_COPPER_ORE_PLACED_KEY = registerKey("pure_copper_ore_placed");
    public static final ResourceKey<PlacedFeature> PURE_IRON_ORE_PLACED_KEY = registerKey("pure_iron_ore_placed");
    public static final ResourceKey<PlacedFeature> PURE_GOLD_ORE_PLACED_KEY = registerKey("pure_gold_ore_placed");
    public static final ResourceKey<PlacedFeature> PURE_PLATINUM_ORE_PLACED_KEY = registerKey("pure_platinum_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PURE_COPPER_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURE_COPPER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(100,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(120))));
        register(context, PURE_IRON_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURE_IRON_ORE_KEY),
                ModOrePlacement.commonOrePlacement(175,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(256))));
        register(context, PURE_GOLD_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURE_GOLD_ORE_KEY),
                ModOrePlacement.commonOrePlacement(200,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(256))));
        register(context, PURE_PLATINUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURE_PLATINUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(0))));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ImmersiveCurrency.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }
}
