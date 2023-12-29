package net.distantdig.immersive_currency;

import net.distantdig.immersive_currency.fluid.ModFluids;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.resources.ResourceLocation;

public class ImmersiveCurrencyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_COIN_FLUID, ModFluids.FLOWING_COIN_FLUID, new SimpleFluidRenderHandler(
                new ResourceLocation("immersive_currency:block/coins_still"),
                new ResourceLocation("immersive_currency:block/coins_still")
        ));

//        BlockRenderLayerMap.INSTANCE.putFluids(RenderType.translucent(),
//                ModFluids.STILL_COIN_FLUID, ModFluids.FLOWING_COIN_FLUID);
    }
}
