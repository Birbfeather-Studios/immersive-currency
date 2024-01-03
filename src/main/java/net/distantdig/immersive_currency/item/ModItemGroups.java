package net.distantdig.immersive_currency.item;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.block.BlockRegister;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import java.util.function.BiConsumer;

public class ModItemGroups {

    private static final BiConsumer<CreativeModeTab.ItemDisplayParameters, CreativeModeTab.Output> consumer = (displayContext, entries) -> {
        //these few are added the old fasioned way because these are blocks which are special, aka, they have an item texture lmao
        entries.accept(ModBlocks.COPPER_COIN);
        entries.accept(ModBlocks.IRON_COIN);
        entries.accept(ModBlocks.GOLD_COIN);
        entries.accept(ModBlocks.PLATINUM_COIN);
        entries.accept(ModBlocks.PURE_COPPER_INGOT);
        entries.accept(ModBlocks.PURE_IRON_INGOT);
        entries.accept(ModBlocks.PURE_GOLD_INGOT);
        entries.accept(ModBlocks.PURE_PLATINUM_INGOT);
        //this generates the list for all generic items
        ModItems.itemList.forEach((key, value) -> {
            entries.accept(value);
        });
        //this generates the list for all generic blocks
        BlockRegister.blockMap.forEach((key, value) -> {
            entries.accept(value.item);
        });
    };

    public static final CreativeModeTab IMMERSIVE_COINS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(ImmersiveCurrency.MOD_ID, "immersive_coins_group"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.immersive_coins_group"))
                    .icon(() -> new ItemStack(ModBlocks.IRON_COIN)).displayItems(consumer::accept).build());

    public static void registerItemGroups() {
        ImmersiveCurrency.LOGGER.info("Registering Item Groups for " + ImmersiveCurrency.MOD_ID);
    }
}