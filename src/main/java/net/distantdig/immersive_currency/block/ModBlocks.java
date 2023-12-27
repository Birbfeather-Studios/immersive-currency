package net.distantdig.immersive_currency.block;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.block.custom.BarBlock;
import net.distantdig.immersive_currency.block.custom.CoinBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.intellij.lang.annotations.Identifier;

public class ModBlocks {

    public static final Block PURE_COPPER_ORE = registerBlock("pure_copper_ore", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE)));
    public static final Block PURE_IRON_ORE = registerBlock("pure_iron_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block PURE_GOLD_ORE = registerBlock("pure_gold_ore", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE)));
    public static final Block PURE_PLATINUM_ORE = registerBlock("pure_platinum_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));
    public static final BarBlock PURE_COPPER_INGOT = registerBarBlock("pure_copper_ingot", new BarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final BarBlock PURE_IRON_INGOT = registerBarBlock("pure_iron_ingot", new BarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final BarBlock PURE_GOLD_INGOT = registerBarBlock("pure_gold_ingot", new BarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final BarBlock PURE_PLATINUM_INGOT = registerBarBlock("pure_platinum_ingot", new BarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final CoinBlock COPPER_COIN = registerCoinBlock("copper_coin", new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final CoinBlock IRON_COIN = registerCoinBlock("iron_coin", new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    public static final CoinBlock GOLD_COIN = registerCoinBlock("gold_coin", new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));
    //public static final CoinBlock PLATINUM_COIN = registerCoinBlock("platinum_coin", new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK)));

    public static final CoinBlock PLATINUM_COIN = new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK));

    public void onInitialize() {
        Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation("immersive_currency", "platinum_coin"), PLATINUM_COIN);
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation("immersive_currency", "platinum_coin"), new BlockItem(PLATINUM_COIN, new FabricItemSettings()));
    }



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ImmersiveCurrency.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ImmersiveCurrency.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static BarBlock registerBarBlock(String name, BarBlock barBlock) {
        registerBlockItem(name, barBlock);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ImmersiveCurrency.MOD_ID, name), barBlock);
    }

    private static CoinBlock registerCoinBlock(String name, CoinBlock coinBlock) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ImmersiveCurrency.MOD_ID, name), coinBlock);
    }

    public static void registerModBlocks() {
        ImmersiveCurrency.LOGGER.info("Registering Blocks for " + ImmersiveCurrency.MOD_ID);
    }
}
