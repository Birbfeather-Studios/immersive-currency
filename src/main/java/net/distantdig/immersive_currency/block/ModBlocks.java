package net.distantdig.immersive_currency.block;

import net.distantdig.immersive_currency.ImmersiveCurrency;
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

    public static final Block PURE_COPPER_ORE = registerBlock("pure_copper_ore", new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE)));
    public static final Block PURE_IRON_ORE = registerBlock("pure_iron_ore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block PURE_GOLD_ORE = registerBlock("pure_gold_ore", new Block(FabricBlockSettings.copyOf(Blocks.GOLD_ORE)));
    public static final Block PURE_PLATINUM_ORE = registerBlock("pure_platinum_ore", new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(ImmersiveCurrency.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(ImmersiveCurrency.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        ImmersiveCurrency.LOGGER.info("Registering Blocks for " + ImmersiveCurrency.MOD_ID);
    }
}
