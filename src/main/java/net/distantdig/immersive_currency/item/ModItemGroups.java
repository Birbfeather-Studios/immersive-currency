package net.distantdig.immersive_currency.item;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup IMMERSIVE_COINS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(ImmersiveCurrency.MOD_ID, "immersive_coins_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.immersive_coins_group"))
                    .icon(() -> new ItemStack(ModItems.IRON_COIN)).entries(((displayContext, entries) -> {
                        entries.add(ModItems.COPPER_COIN);
                        entries.add(ModItems.GOLD_COIN);
                        entries.add(ModItems.IRON_COIN);
                        entries.add(ModItems.PLATINUM_COIN);

                        entries.add(ModItems.PURE_COPPER_INGOT);
                        entries.add(ModItems.PURE_IRON_INGOT);
                        entries.add(ModItems.PURE_GOLD_INGOT);
                        entries.add(ModItems.PURE_PLATINUM_INGOT);

                        entries.add(ModItems.PURE_COPPER_NUGGET);
                        entries.add(ModItems.PURE_IRON_NUGGET);
                        entries.add(ModItems.PURE_GOLD_NUGGET);
                        entries.add(ModItems.PURE_PLATINUM_NUGGET);

                        entries.add(ModBlocks.PURE_COPPER_ORE);
                        entries.add(ModBlocks.PURE_IRON_ORE);
                        entries.add(ModBlocks.PURE_GOLD_ORE);
                        entries.add(ModBlocks.PURE_PLATINUM_ORE);
                    })).build());

    public static void registerItemGroups() {
        ImmersiveCurrency.LOGGER.info("Registering Item Groups for", ImmersiveCurrency.MOD_ID);
    }
}
