package net.distantdig.immersive_currency.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;

public class ModLootTableModifiers {

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

    public static void ModifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {

            if (MINESHAFT_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.pureNuggets.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
            }
            if (ANCIENT_CITY_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsHigh.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
                tableBuilder.pool(ModLootTables.emeraldsLow.build());
                tableBuilder.pool(ModLootTables.emeraldsHigh.build());
            }
            if (BASTION_TREASURE_ID.equals(id)
                    || NETHER_BRIDGE_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.goldOnly.build());
            }
            if (BURIED_TREASURE_ID.equals(id)
                    || DESERT_PYRAMID_ID.equals(id)
                    || SHIP_TREASURE_ID.equals(id)
                    || STRONGHOLD_CORRIDOR_ID.equals(id)
                    || STRONGHOLD_CROSSING_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
            }
            if (END_CITY_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.coinsHigh.build());
                tableBuilder.pool(ModLootTables.platOnly.build());
                tableBuilder.pool(ModLootTables.pureIngots.build());
                tableBuilder.pool(ModLootTables.goldOnly.build());
            }
            if (JUNGLE_TEMPLE_ID.equals(id)
                    || DUNGEON_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.pureNuggets.build());
            }
            if (PILLAGER_OUTPOST_ID.equals(id)
                    || WOODLAND_MANSION_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsLow.build());
                tableBuilder.pool(ModLootTables.emeraldsLow.build());
                tableBuilder.pool(ModLootTables.emeraldsHigh.build());
            }
            if (SPAWN_BONUS_CHEST_ID.equals(id)
                    || UNDERWATER_RUIN_BIG_ID.equals(id)
                    || UNDERWATER_RUIN_SMALL_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.coinsLow.build());
            }
            if (RUINED_PORTAL_ID.equals(id)) {
                tableBuilder.pool(ModLootTables.goldOnly.build());
            }
        }));
    }
}
