package net.distantdig.immersive_currency.block;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.block.custom.BarBlock;
import net.distantdig.immersive_currency.block.custom.CoinBlock;
import net.distantdig.immersive_currency.item.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ModBlocks {

    public static final CoinBlock COPPER_COIN = registerCoinBlock("copper_coin", new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final CoinBlock IRON_COIN = registerCoinBlock("iron_coin", new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final CoinBlock GOLD_COIN = registerCoinBlock("gold_coin", new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final CoinBlock PLATINUM_COIN = registerCoinBlock("platinum_coin", new CoinBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));

    public static final BarBlock PURE_COPPER_INGOT = registerBarBlock("pure_copper_ingot", new BarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final BarBlock PURE_IRON_INGOT = registerBarBlock("pure_iron_ingot", new BarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final BarBlock PURE_GOLD_INGOT = registerBarBlock("pure_gold_ingot", new BarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));
    public static final BarBlock PURE_PLATINUM_INGOT = registerBarBlock("pure_platinum_ingot", new BarBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).nonOpaque()));

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ImmersiveCurrency.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static BarBlock registerBarBlock(String name, BarBlock barBlock) {
        registerBlockItem(name, barBlock);
        BarBlock BlockRegistered = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ImmersiveCurrency.MOD_ID, name), barBlock);
        ModItemGroups.addToPriorityGroupList(BlockRegistered);
        return BlockRegistered;
    }

    private static CoinBlock registerCoinBlock(String name, CoinBlock coinBlock) {
        registerBlockItem(name, coinBlock);
        CoinBlock BlockRegistered = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ImmersiveCurrency.MOD_ID, name), coinBlock);
        ModItemGroups.addToPriorityGroupList(BlockRegistered);
        return BlockRegistered;
    }

    //do same for walls, stairs, slabs.
    //.register is broken because i copied it from GravyBoat's library thing. We should add this to our feather library so that we can easily acces it in future.

    public static void registerModBlocks() {
        //public static final Block PURE_COPPER_ORE = registerBlock("pure_copper_ore", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE)));
        BlockRegister.registerBlock("pure_copper_ore", Block::new, FabricBlockSettings.copyOf(Blocks.COPPER_ORE));
        BlockRegister.registerBlock("pure_deepslate_copper_ore", Block::new, FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COPPER_ORE));
        BlockRegister.registerBlock("pure_iron_ore", Block::new, FabricBlockSettings.copyOf(Blocks.IRON_ORE));
        BlockRegister.registerBlock("pure_deepslate_iron_ore", Block::new, FabricBlockSettings.copyOf(Blocks.DEEPSLATE_IRON_ORE));
        BlockRegister.registerBlock("pure_gold_ore", Block::new, FabricBlockSettings.copyOf(Blocks.GOLD_ORE));
        BlockRegister.registerBlock("pure_deepslate_gold_ore", Block::new, FabricBlockSettings.copyOf(Blocks.DEEPSLATE_GOLD_ORE));
        BlockRegister.registerBlock("pure_platinum_ore", Block::new, FabricBlockSettings.copyOf(Blocks.GOLD_ORE));
        BlockRegister.registerGildedBlockSet("copper", Block::new, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK));
        BlockRegister.registerGildedBlockSet("iron", Block::new, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK));
        BlockRegister.registerGildedBlockSet("gold", Block::new, FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK));
        BlockRegister.registerGildedBlockSet("platinum", Block::new, FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK));

        ImmersiveCurrency.LOGGER.info("Registering Blocks for " + ImmersiveCurrency.MOD_ID);
    }
}
