package net.distantdig.immersive_currency.item;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.item.custom.CoinPouchItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item COIN_POUCH = registerItem("coin_pouch", new CoinPouchItem(new FabricItemSettings()));

    public static final Item COPPER_COIN = registerItem("copper_coin", new Item(new FabricItemSettings()));
    public static final Item IRON_COIN = registerItem("iron_coin", new Item(new FabricItemSettings()));
    public static final Item GOLD_COIN = registerItem("gold_coin", new Item(new FabricItemSettings()));
    public static final Item PLATINUM_COIN = registerItem("platinum_coin", new Item(new FabricItemSettings()));

    public static final Item PURE_COPPER_INGOT = registerItem("pure_copper_ingot", new Item(new FabricItemSettings()));
    public static final Item PURE_IRON_INGOT = registerItem("pure_iron_ingot", new Item(new FabricItemSettings()));
    public static final Item PURE_GOLD_INGOT = registerItem("pure_gold_ingot", new Item(new FabricItemSettings()));
    public static final Item PURE_PLATINUM_INGOT = registerItem("pure_platinum_ingot", new Item(new FabricItemSettings()));

    public static final Item PURE_COPPER_NUGGET = registerItem("pure_copper_nugget", new Item(new FabricItemSettings()));
    public static final Item PURE_IRON_NUGGET = registerItem("pure_iron_nugget", new Item(new FabricItemSettings()));
    public static final Item PURE_GOLD_NUGGET = registerItem("pure_gold_nugget", new Item(new FabricItemSettings()));
    public static final Item PURE_PLATINUM_NUGGET = registerItem("pure_platinum_nugget", new Item(new FabricItemSettings()));

    public static final Item LARGE_EMERALD = registerItem("large_emerald", new Item(new FabricItemSettings()));
    public static final Item EMERALD_CHUNK = registerItem("emerald_chunk", new Item(new FabricItemSettings()));
    public static final Item EMERALD_SHARD = registerItem("emerald_shard", new Item(new FabricItemSettings()));

    private static void acceptItemsToItemGroup(FabricItemGroupEntries entries) {
        entries.accept(COIN_POUCH);

        entries.accept(COPPER_COIN);
        entries.accept(IRON_COIN);
        entries.accept(GOLD_COIN);
        entries.accept(PLATINUM_COIN);

        entries.accept(PURE_COPPER_INGOT);
        entries.accept(PURE_IRON_INGOT);
        entries.accept(PURE_GOLD_INGOT);
        entries.accept(PURE_PLATINUM_INGOT);

        entries.accept(PURE_COPPER_NUGGET);
        entries.accept(PURE_IRON_NUGGET);
        entries.accept(PURE_GOLD_NUGGET);
        entries.accept(PURE_PLATINUM_NUGGET);

        entries.accept(LARGE_EMERALD);
        entries.accept(EMERALD_CHUNK);
        entries.accept(EMERALD_SHARD);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ImmersiveCurrency.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ImmersiveCurrency.LOGGER.info("Registering Mod Items for " + ImmersiveCurrency.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(ModItems::acceptItemsToItemGroup);
    }
}
