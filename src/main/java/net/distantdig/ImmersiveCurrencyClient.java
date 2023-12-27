package net.distantdig;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;


public class ImmersiveCurrencyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURE_COPPER_INGOT, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURE_IRON_INGOT, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURE_GOLD_INGOT, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURE_PLATINUM_INGOT, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COPPER_COIN, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.IRON_COIN, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLD_COIN, RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLATINUM_COIN, RenderType.translucent());
    }
}
