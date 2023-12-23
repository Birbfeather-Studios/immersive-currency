package net.distantdig.immersivecurrency.item;

import net.distantdig.immersivecurrency.ImmersiveCurrency;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item COPPER_COIN = registerItem("copper_coin", new Item(new FabricItemSettings()));
    public static final Item IRON_COIN = registerItem("iron_coin", new Item(new FabricItemSettings()));
    public static final Item GOLD_COIN = registerItem("gold_coin", new Item(new FabricItemSettings()));
    public static final Item PLATINUM_COIN = registerItem("platinum_coin", new Item(new FabricItemSettings()));

    private static void addItemsToItemGroup(FabricItemGroupEntries entries) {
        entries.add(COPPER_COIN);
        entries.add(IRON_COIN);
        entries.add(GOLD_COIN);
        entries.add(PLATINUM_COIN);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ImmersiveCurrency.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ImmersiveCurrency.LOGGER.info("Registering Mod Items for", ImmersiveCurrency.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToItemGroup);
    }
}
