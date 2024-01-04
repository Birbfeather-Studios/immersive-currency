package net.distantdig.immersive_currency;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class ImmersiveCurrencyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_COPPER_COIN_FLUID, ModFluids.FLOWING_COPPER_COIN_FLUID, new SimpleFluidRenderHandler(
                new ResourceLocation("immersive_currency:block/copper_coins_still"),
                new ResourceLocation("immersive_currency:block/copper_coins_flowing")
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_IRON_COIN_FLUID, ModFluids.FLOWING_IRON_COIN_FLUID, new SimpleFluidRenderHandler(
                new ResourceLocation("immersive_currency:block/iron_coins_still"),
                new ResourceLocation("immersive_currency:block/iron_coins_flowing")
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_GOLD_COIN_FLUID, ModFluids.FLOWING_GOLD_COIN_FLUID, new SimpleFluidRenderHandler(
                new ResourceLocation("immersive_currency:block/gold_coins_still"),
                new ResourceLocation("immersive_currency:block/gold_coins_flowing")
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_PLATINUM_COIN_FLUID, ModFluids.FLOWING_PLATINUM_COIN_FLUID, new SimpleFluidRenderHandler(
                new ResourceLocation("immersive_currency:block/platinum_coins_still"),
                new ResourceLocation("immersive_currency:block/platinum_coins_flowing")
        ));

//        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(),
//                ModFluids.STILL_COIN_FLUID, ModFluids.FLOWING_COIN_FLUID);

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
