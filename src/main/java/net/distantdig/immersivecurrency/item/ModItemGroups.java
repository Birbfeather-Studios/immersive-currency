package net.distantdig.immersivecurrency.item;

import net.distantdig.immersivecurrency.ImmersiveCurrency;
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
                    })).build());

    public static void registerItemGroups() {
        ImmersiveCurrency.LOGGER.info("Registering Item Groups for", ImmersiveCurrency.MOD_ID);
    }
}
