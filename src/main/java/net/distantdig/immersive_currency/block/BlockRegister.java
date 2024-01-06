package net.distantdig.immersive_currency.block;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.item.ModItemGroups;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.HashMap;
import java.util.function.Function;

public final class BlockRegister {

    public static class BlockData{
        public Block block;
        public BlockItem item;
    }

    public final static HashMap<String, BlockData> blockMap = new HashMap<>();

    public static <T extends Block> void registerBlock(String key, Function<BlockBehaviour.Properties,T> ctor, BlockBehaviour.Properties props) {
        BlockData data = new BlockData();
        data.block = Registry.register(
                BuiltInRegistries.BLOCK,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, key),
                ctor.apply(props)
        );
        data.item = Registry.register(
                BuiltInRegistries.ITEM,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, key),
                new BlockItem(data.block, new FabricItemSettings())
        );
        blockMap.put(key, data);
        ModItemGroups.addToBlockGroupList(data.item);
    }

    public static <T extends Block> void registerStairBlock(String key, String block,BlockBehaviour.Properties props) {
        BlockData data = new BlockData();
        data.block = Registry.register(
                BuiltInRegistries.BLOCK,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, key),
                new StairBlock(getBlock(block).defaultBlockState(), props)
        );
        data.item = Registry.register(
                BuiltInRegistries.ITEM,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, key),
                new BlockItem(data.block, new FabricItemSettings())
        );
        blockMap.put(key, data);
        ModItemGroups.addToBlockGroupList(data.item);
    }

    public static <T extends Block> void registerGildedBlockSet(String key, Function<BlockBehaviour.Properties,T> ctor, BlockBehaviour.Properties props) {
        registerBlock(key + "_gilded_stone", ctor, props);
        registerBlock(key + "_gilded_creeper_trim", ctor, props);
        registerBlock(key + "_gilded_curly_trim", ctor, props);
        registerBlock(key + "_gilded_brick", ctor, props);
        registerBlock(key + "_gilded_bricks", ctor, props);
        registerBlock(key + "_gilded_pillar", ctor, props);
        registerBlock(key + "_gilded_plate", ctor, props);
        registerBlock("polished_gilded_" + key, ctor, props);
        registerBlock("chiseled_gilded_" + key, ctor, props);
        registerStairBlock(key + "_gilded_stone_stair", key + "_gilded_stone", props);
        registerStairBlock(key + "_gilded_brick_stair", key + "_gilded_brick", props);
        registerBlock(key +"_gilded_stone_slab", SlabBlock::new, props);
        registerBlock(key +"_gilded_brick_slab", SlabBlock::new, props);
        registerBlock(key +"_gilded_stone_wall", WallBlock::new, props);
        registerBlock(key +"_gilded_brick_wall", WallBlock::new, props);
    }

    public static <T extends Block> T getBlock(String key){ return (T)blockMap.get(key).block;}

    public static BlockItem getBlockItem(String key) { return blockMap.get(key).item; }
}