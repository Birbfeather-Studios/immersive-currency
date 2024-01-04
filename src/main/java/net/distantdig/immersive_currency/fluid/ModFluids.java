package net.distantdig.immersive_currency.fluid;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.item.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;

public class ModFluids {
    public static FlowingFluid STILL_COPPER_COIN_FLUID;
    public static FlowingFluid FLOWING_COPPER_COIN_FLUID;
    public static Block COPPER_COIN_FLUID_BLOCK;
    public static Item COPPER_COIN_BUCKET;
    public static FlowingFluid STILL_IRON_COIN_FLUID;
    public static FlowingFluid FLOWING_IRON_COIN_FLUID;
    public static Block IRON_COIN_FLUID_BLOCK;
    public static Item IRON_COIN_BUCKET;
    public static FlowingFluid STILL_GOLD_COIN_FLUID;
    public static FlowingFluid FLOWING_GOLD_COIN_FLUID;
    public static Block GOLD_COIN_FLUID_BLOCK;
    public static Item GOLD_COIN_BUCKET;
    public static FlowingFluid STILL_PLATINUM_COIN_FLUID;
    public static FlowingFluid FLOWING_PLATINUM_COIN_FLUID;
    public static Block PLATINUM_COIN_FLUID_BLOCK;
    public static Item PLATINUM_COIN_BUCKET;

    public static void register() {
        STILL_COPPER_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "copper_coin_fluid"),
                new CopperCoinFluid.Still());
        FLOWING_COPPER_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "flowing_copper_coin_fluid"),
                new CopperCoinFluid.Flowing());
        COPPER_COIN_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "copper_coin_fluid_block"),
                new LiquidBlock(ModFluids.STILL_COPPER_COIN_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));
        COPPER_COIN_BUCKET = Registry.register(BuiltInRegistries.ITEM,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "copper_coin_bucket"),
                new BucketItem(ModFluids.STILL_COPPER_COIN_FLUID, new FabricItemSettings().maxCount(1).recipeRemainder(Items.BUCKET)));

        STILL_IRON_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "iron_coin_fluid"),
                new IronCoinFluid.Still());
        FLOWING_IRON_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "flowing_iron_coin_fluid"),
                new IronCoinFluid.Flowing());
        IRON_COIN_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "iron_coin_fluid_block"),
                new LiquidBlock(ModFluids.STILL_IRON_COIN_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));
        IRON_COIN_BUCKET = Registry.register(BuiltInRegistries.ITEM,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "iron_coin_bucket"),
                new BucketItem(ModFluids.STILL_IRON_COIN_FLUID, new FabricItemSettings().maxCount(1).recipeRemainder(Items.BUCKET)));

        STILL_GOLD_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "gold_coin_fluid"),
                new GoldCoinFluid.Still());
        FLOWING_GOLD_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "flowing_gold_coin_fluid"),
                new GoldCoinFluid.Flowing());
        GOLD_COIN_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "gold_coin_fluid_block"),
                new LiquidBlock(ModFluids.STILL_GOLD_COIN_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));
        GOLD_COIN_BUCKET = Registry.register(BuiltInRegistries.ITEM,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "gold_coin_bucket"),
                new BucketItem(ModFluids.STILL_GOLD_COIN_FLUID, new FabricItemSettings().maxCount(1).recipeRemainder(Items.BUCKET)));

        STILL_PLATINUM_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "platinum_coin_fluid"),
                new PlatinumCoinFluid.Still());
        FLOWING_PLATINUM_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "flowing_platinum_coin_fluid"),
                new PlatinumCoinFluid.Flowing());
        PLATINUM_COIN_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "platinum_coin_fluid_block"),
                new LiquidBlock(ModFluids.STILL_PLATINUM_COIN_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));
        PLATINUM_COIN_BUCKET = Registry.register(BuiltInRegistries.ITEM,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "platinum_coin_bucket"),
                new BucketItem(ModFluids.STILL_PLATINUM_COIN_FLUID, new FabricItemSettings().maxCount(1).recipeRemainder(Items.BUCKET)));

        ModItemGroups.addToItemGroupList(COPPER_COIN_BUCKET);
        ModItemGroups.addToItemGroupList(IRON_COIN_BUCKET);
        ModItemGroups.addToItemGroupList(GOLD_COIN_BUCKET);
        ModItemGroups.addToItemGroupList(PLATINUM_COIN_BUCKET);
    }

    private static void acceptItemsToItemGroup(FabricItemGroupEntries entries) {
        entries.accept(GOLD_COIN_BUCKET);
    }

    public static void registerModFluids() {
        ImmersiveCurrency.LOGGER.info("Registering Mod Fluids for " + ImmersiveCurrency.MOD_ID);
        register();
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(ModFluids::acceptItemsToItemGroup);
    }
}
