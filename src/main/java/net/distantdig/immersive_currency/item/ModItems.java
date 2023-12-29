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

    public static final Item PURE_COPPER_NUGGET = registerItem("pure_copper_nugget", new Item(new FabricItemSettings()));
    public static final Item PURE_IRON_NUGGET = registerItem("pure_iron_nugget", new Item(new FabricItemSettings()));
    public static final Item PURE_GOLD_NUGGET = registerItem("pure_gold_nugget", new Item(new FabricItemSettings()));
    public static final Item PURE_PLATINUM_NUGGET = registerItem("pure_platinum_nugget", new Item(new FabricItemSettings()));

    public static final Item LARGE_EMERALD = registerItem("large_emerald", new Item(new FabricItemSettings()));
    public static final Item EMERALD_CHUNK = registerItem("emerald_chunk", new Item(new FabricItemSettings()));
    public static final Item EMERALD_SHARD = registerItem("emerald_shard", new Item(new FabricItemSettings()));

    private static void acceptItemsToItemGroup(FabricItemGroupEntries entries) {
        entries.accept(COIN_POUCH);

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
