package net.distantdig.immersive_currency.item;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.fluid.ModFluids;
import net.distantdig.immersive_currency.item.custom.CoinPouchItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.Map;

public class ModItems {
    public static Map<String, Item> itemList = Map.of(
            "coin_pouch", registerItem("coin_pouch", new CoinPouchItem(new FabricItemSettings().maxCount(1))),
            "coin_bucket", ModFluids.GOLD_COIN_BUCKET,
            "pure_copper_nugget", registerItem("pure_copper_nugget", new Item(new FabricItemSettings())),
            "pure_iron_nugget", registerItem("pure_iron_nugget", new Item(new FabricItemSettings())),
            "pure_gold_nugget", registerItem("pure_gold_nugget", new Item(new FabricItemSettings())),
            "pure_platinum_nugget", registerItem("pure_platinum_nugget", new Item(new FabricItemSettings())),
            "large_emerald", registerItem("large_emerald", new Item(new FabricItemSettings())),
            "emerald_chunk", registerItem("emerald_chunk", new Item(new FabricItemSettings())),
            "emerald_shard", registerItem("emerald_shard", new Item(new FabricItemSettings()))
    );

    public static final Item COIN_POUCH = itemList.get("coin_pouch");

    public static final Item PURE_COPPER_NUGGET = itemList.get("pure_copper_nugget");
    public static final Item PURE_IRON_NUGGET = itemList.get("pure_iron_nugget");
    public static final Item PURE_GOLD_NUGGET = itemList.get("pure_gold_nugget");
    public static final Item PURE_PLATINUM_NUGGET = itemList.get("pure_platinum_nugget");

    public static final Item LARGE_EMERALD = itemList.get("large_emerald");
    public static final Item EMERALD_CHUNK = itemList.get("emerald_chunk");
    public static final Item EMERALD_SHARD = itemList.get("emerald_shard");

    private static void acceptItemsToItemGroup(FabricItemGroupEntries entries) {
        ModItemGroups.ItemGroupList.forEach(entries::accept);
    }

    private static Item registerItem(String name, Item item) {
        Item itemRegistered = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ImmersiveCurrency.MOD_ID, name), item);
        ModItemGroups.addToItemGroupList(itemRegistered);
        return itemRegistered;
    }
    public static void registerModItems() {
        ImmersiveCurrency.LOGGER.info("Registering Mod Items for " + ImmersiveCurrency.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(ModItems::acceptItemsToItemGroup);
    }


}






