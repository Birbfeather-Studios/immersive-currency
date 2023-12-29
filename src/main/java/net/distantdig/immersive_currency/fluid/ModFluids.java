package net.distantdig.immersive_currency.fluid;

import net.distantdig.immersive_currency.ImmersiveCurrency;
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
    public static FlowingFluid STILL_COIN_FLUID;
    public static FlowingFluid FLOWING_COIN_FLUID;
    public static Block COIN_FLUID_BLOCK;
    public static Item COIN_BUCKET;

    public static void register() {
        STILL_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "coin_fluid"),
                new CoinFluid.Still());
        FLOWING_COIN_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "flowing_coin_fluid"),
                new CoinFluid.Flowing());

        COIN_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "coin_fluid_block"),
                new LiquidBlock(ModFluids.STILL_COIN_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));

        COIN_BUCKET = Registry.register(BuiltInRegistries.ITEM,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, "coin_bucket"),
                new BucketItem(ModFluids.STILL_COIN_FLUID, new FabricItemSettings().maxCount(1).recipeRemainder(Items.BUCKET)));
    }

    private static void acceptItemsToItemGroup(FabricItemGroupEntries entries) {
        entries.accept(COIN_BUCKET);
    }

    public static void registerModFluids() {
        ImmersiveCurrency.LOGGER.info("Registering Mod Fluids for " + ImmersiveCurrency.MOD_ID);
        register();
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(ModFluids::acceptItemsToItemGroup);
    }
}
