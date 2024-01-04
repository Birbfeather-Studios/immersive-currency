package net.distantdig.immersive_currency.item;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class ModItemGroups {

    public static ArrayList<ItemLike> PriorityGroupList = new ArrayList<>();
    public static ArrayList<ItemLike> ItemGroupList = new ArrayList<>();
    public static ArrayList<ItemLike> BlockGroupList = new ArrayList<>();

    private static BiConsumer<CreativeModeTab.ItemDisplayParameters, CreativeModeTab.Output> consumer = (displayContext, entries) -> {
        PriorityGroupList.forEach(entries::accept);
        ItemGroupList.forEach(entries::accept);
        BlockGroupList.forEach(entries::accept);
    };

    public static void addToPriorityGroupList(ItemLike itemLike){
        PriorityGroupList.add(itemLike);
    }
    public static void addToItemGroupList(ItemLike itemLike){
        ItemGroupList.add(itemLike);
    }
    public static void addToBlockGroupList(ItemLike itemLike){
        BlockGroupList.add(itemLike);
    }

    public static final CreativeModeTab IMMERSIVE_COINS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(ImmersiveCurrency.MOD_ID, "immersive_coins_group"),
            FabricItemGroup.builder().title(Component.translatable("itemGroup.immersive_coins_group"))
                    .icon(() -> new ItemStack(ModBlocks.IRON_COIN)).displayItems(consumer::accept).build());

    public static void registerItemGroups() {
        ImmersiveCurrency.LOGGER.info("Registering Item Groups for " + ImmersiveCurrency.MOD_ID);
    }
}