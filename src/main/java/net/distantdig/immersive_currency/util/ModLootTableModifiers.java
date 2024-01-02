package net.distantdig.immersive_currency.util;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {

    private static final ResourceLocation VILLAGE_ARMORER =
            new ResourceLocation("minecraft", "chests/village/village_armorer");
    private static final ResourceLocation VILLAGE_BUTCHER =
            new ResourceLocation("minecraft", "chests/village/village_butcher");
    private static final ResourceLocation VILLAGE_CARTOGRAPHER =
            new ResourceLocation("minecraft", "chests/village/village_cartographer");
    private static final ResourceLocation VILLAGE_DESERT_HOUSE =
            new ResourceLocation("minecraft", "chests/village/village_desert_house");
    private static final ResourceLocation VILLAGE_FISHER =
            new ResourceLocation("minecraft", "chests/village/village_fisher");
    private static final ResourceLocation VILLAGE_FLETCHER =
            new ResourceLocation("minecraft", "chests/village/village_fletcher");
    private static final ResourceLocation VILLAGE_MASON =
            new ResourceLocation("minecraft", "chests/village/village_mason");
    private static final ResourceLocation VILLAGE_PLAINS_HOUSE =
            new ResourceLocation("minecraft", "chests/village/village_plains_house");
    private static final ResourceLocation VILLAGE_SAVANNA_HOUSE =
            new ResourceLocation("minecraft", "chests/village/village_savanna_house");
    private static final ResourceLocation VILLAGE_SHEPHERD =
            new ResourceLocation("minecraft", "chests/village/village_shepherd");
    private static final ResourceLocation VILLAGE_SNOWY_HOUSE =
            new ResourceLocation("minecraft", "chests/village/village_snowy_house");
    private static final ResourceLocation VILLAGE_TAIGA_HOUSE =
            new ResourceLocation("minecraft", "chests/village/village_taiga_house");
    private static final ResourceLocation VILLAGE_TANNERY =
            new ResourceLocation("minecraft", "chests/village/village_tannery");
    private static final ResourceLocation VILLAGE_TEMPLE =
            new ResourceLocation("minecraft", "chests/village/village_temple");
    private static final ResourceLocation VILLAGE_TOOLSMITH =
            new ResourceLocation("minecraft", "chests/village/village_toolsmith");
    private static final ResourceLocation VILLAGE_WEAPONSMITH =
            new ResourceLocation("minecraft", "chests/village/village_weaponsmith");

    private static final ResourceLocation MINESHAFT_ID =
            new ResourceLocation("minecraft", "chests/abandoned_mineshaft");
    private static final ResourceLocation ANCIENT_CITY_ID =
            new ResourceLocation("minecraft", "chests/ancient_city");
    private static final ResourceLocation BASTION_TREASURE_ID =
            new ResourceLocation("minecraft", "chests/bastion_treasure");
    private static final ResourceLocation BURIED_TREASURE_ID =
            new ResourceLocation("minecraft", "chests/buried_treasure");
    private static final ResourceLocation DESERT_PYRAMID_ID =
            new ResourceLocation("minecraft", "chests/desert_pyramid");
    private static final ResourceLocation END_CITY_ID =
            new ResourceLocation("minecraft", "chests/end_city_treasure");
    private static final ResourceLocation JUNGLE_TEMPLE_ID =
            new ResourceLocation("minecraft", "chests/jungle_temple");
    private static final ResourceLocation NETHER_BRIDGE_ID =
            new ResourceLocation("minecraft", "chests/nether_bridge");
    private static final ResourceLocation PILLAGER_OUTPOST_ID =
            new ResourceLocation("minecraft", "chests/pillager_outpost");
    private static final ResourceLocation RUINED_PORTAL_ID =
            new ResourceLocation("minecraft", "chests/ruined_portal");
    private static final ResourceLocation SHIP_TREASURE_ID =
            new ResourceLocation("minecraft", "chests/shipwreck_treasure");
    private static final ResourceLocation DUNGEON_ID =
            new ResourceLocation("minecraft", "chests/simple_dungeon");
    private static final ResourceLocation SPAWN_BONUS_CHEST_ID =
            new ResourceLocation("minecraft", "chests/spawn_bonus_chest");
    private static final ResourceLocation STRONGHOLD_CORRIDOR_ID =
            new ResourceLocation("minecraft", "chests/stronghold_corridor");
    private static final ResourceLocation STRONGHOLD_CROSSING_ID =
            new ResourceLocation("minecraft", "chests/stronghold_crossing");
    private static final ResourceLocation UNDERWATER_RUIN_BIG_ID =
            new ResourceLocation("minecraft", "chests/underwater_ruin_big");
    private static final ResourceLocation UNDERWATER_RUIN_SMALL_ID =
            new ResourceLocation("minecraft", "chests/underwater_ruin_small");
    private static final ResourceLocation WOODLAND_MANSION_ID =
            new ResourceLocation("minecraft", "chests/woodland_mansion");

    private static final ResourceLocation FISHING_TREASURE =
            new ResourceLocation("minecraft", "gameplay/fishing/treasure");

    public static void ModifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {

            if (VILLAGE_ARMORER.equals(id)
                    || VILLAGE_TOOLSMITH.equals(id)
                    || VILLAGE_WEAPONSMITH.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
                tableBuilder.pool(ModLootTables.emeraldsLow.build());
            }
            if (VILLAGE_BUTCHER.equals(id)
                    || VILLAGE_CARTOGRAPHER.equals(id)
                    || VILLAGE_FISHER.equals(id)
                    || VILLAGE_FLETCHER.equals(id)
                    || VILLAGE_MASON.equals(id)
                    || VILLAGE_SHEPHERD.equals(id)
                    || VILLAGE_TANNERY.equals(id)
                    || VILLAGE_TEMPLE.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.emeraldsLow.build());
            }
            if (VILLAGE_DESERT_HOUSE.equals(id)
                    || VILLAGE_PLAINS_HOUSE.equals(id)
                    || VILLAGE_SAVANNA_HOUSE.equals(id)
                    || VILLAGE_SNOWY_HOUSE.equals(id)
                    || VILLAGE_TAIGA_HOUSE.equals(id)) {
                tableBuilder.pool(ModLootTables.coinPouch.build());
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.emeraldsLow.build());
            }

            if (MINESHAFT_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.pureNuggets.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinPouch.build());
                tableBuilder.pool(ModLootTables.coinsHigh.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
                tableBuilder.pool(ModLootTables.emeraldsLow.build());
                tableBuilder.pool(ModLootTables.emeraldsHigh.build());
            }
            if (BASTION_TREASURE_ID.equals(id)
                    || NETHER_BRIDGE_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinPouch.build());
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.goldOnly.build());
            }
            if (BURIED_TREASURE_ID.equals(id)
                    || DESERT_PYRAMID_ID.equals(id)
                    || SHIP_TREASURE_ID.equals(id)
                    || STRONGHOLD_CORRIDOR_ID.equals(id)
                    || STRONGHOLD_CROSSING_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinPouch.build());
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
            }
            if (END_CITY_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinPouch.build());
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.coinsHigh.build());
                tableBuilder.pool(ModLootTables.platOnly.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
                tableBuilder.pool(ModLootTables.goldOnly.build());
            }
            if (JUNGLE_TEMPLE_ID.equals(id)
                    || DUNGEON_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinPouch.build());
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.pureNuggets.build());
            }
            if (PILLAGER_OUTPOST_ID.equals(id)
                    || WOODLAND_MANSION_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinPouch.build());
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.emeraldsLow.build());
                tableBuilder.pool(ModLootTables.emeraldsHigh.build());
            }
            if (SPAWN_BONUS_CHEST_ID.equals(id)
                    || UNDERWATER_RUIN_BIG_ID.equals(id)
                    || UNDERWATER_RUIN_SMALL_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinPouch.build());
                tableBuilder.pool(ModLootTables.coinsLow.build());
            }
            if (RUINED_PORTAL_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.goldOnly.build());
            }
        }));

        LootTableEvents.REPLACE.register(((resourceManager, lootManager, id, original, source) -> {
            if (FISHING_TREASURE.equals(id)) {
                List<LootPoolEntryContainer> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(LootItem.lootTableItem(ModBlocks.COPPER_COIN).build());
                entries.add(LootItem.lootTableItem(ModBlocks.IRON_COIN).build());
                entries.add(LootItem.lootTableItem(ModBlocks.GOLD_COIN).build());

                LootPool.Builder pool = LootPool.lootPool().with(entries);
                return LootTable.lootTable().withPool(pool).build();
            }
            return null;
        }));
    }
}
