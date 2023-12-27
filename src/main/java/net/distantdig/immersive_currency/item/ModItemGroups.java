package net.distantdig.immersive_currency.item;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroups {
    public static final CreativeModeTab IMMERSIVE_COINS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(ImmersiveCurrency.MOD_ID, "immersive_coins_group"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.immersive_coins_group"))
                    .icon(() -> new ItemStack(ModItems.IRON_COIN)).displayItems(((displayContext, entries) -> {
                        entries.accept(ModItems.COIN_POUCH);

                        entries.accept(ModItems.COPPER_COIN);
                        entries.accept(ModItems.GOLD_COIN);
                        entries.accept(ModItems.IRON_COIN);
                        entries.accept(ModItems.PLATINUM_COIN);

                        entries.accept(ModItems.PURE_COPPER_INGOT);
                        entries.accept(ModItems.PURE_IRON_INGOT);
                        entries.accept(ModItems.PURE_GOLD_INGOT);
                        entries.accept(ModItems.PURE_PLATINUM_INGOT);

                        entries.accept(ModItems.PURE_COPPER_NUGGET);
                        entries.accept(ModItems.PURE_IRON_NUGGET);
                        entries.accept(ModItems.PURE_GOLD_NUGGET);
                        entries.accept(ModItems.PURE_PLATINUM_NUGGET);

                        entries.accept(ModItems.LARGE_EMERALD);
                        entries.accept(Items.EMERALD);
                        entries.accept(ModItems.EMERALD_CHUNK);
                        entries.accept(ModItems.EMERALD_SHARD);

                        entries.accept(ModBlocks.PURE_COPPER_ORE);
                        entries.accept(ModBlocks.PURE_IRON_ORE);
                        entries.accept(ModBlocks.PURE_GOLD_ORE);
                        entries.accept(ModBlocks.PURE_PLATINUM_ORE);
                    })).build());

    public static void registerItemGroups() {
        ImmersiveCurrency.LOGGER.info("Registering Item Groups for " + ImmersiveCurrency.MOD_ID);
    }
}
