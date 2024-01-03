package net.distantdig.immersive_currency.block;

import net.distantdig.immersive_currency.ImmersiveCurrency;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public final class BlockRegister {
    // Typedef
    public static class BlockData{
        public Block block;
        public BlockItem item;
    }
    private static class RecipeData<T extends Recipe<?>>{
        private RecipeType<T> type;
        private RecipeSerializer<T> serial;
    }

    // Member variables
    public final static HashMap<String, BlockData> blockMap = new HashMap<>();
    private final static HashMap<String, BlockEntityType<? extends BlockEntity>> blockEntityMap = new HashMap<>();
    private final static HashMap<String, RecipeData<? extends Recipe<?>>> recipeMap = new HashMap<>();
    private final static HashMap<String, MenuType<? extends AbstractContainerMenu>> menuMap = new HashMap<>();

    // Entry methods
    public static <T extends Block> void registerBlock(String key, Function<BlockBehaviour.Properties,T> ctor, BlockBehaviour.Properties props) {
        // Key is the block name which is both for the resource location and acts as a key in the BlockMap.
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
    };
    public static <T extends BlockEntity> void registerBlockEntity(String key, FabricBlockEntityTypeBuilder.Factory<T> ctor, Block... blocks){
        blockEntityMap.put(key, Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, key),
                FabricBlockEntityTypeBuilder
                        .create(ctor, blocks)
                        .build()
        ));
    }
    public static <T extends Recipe<?>> void registerRecipe(String key, Supplier<? extends RecipeSerializer<T>> ctor){
        RecipeData<T> data = new RecipeData<>();
        data.type = Registry.register(
                BuiltInRegistries.RECIPE_TYPE,
                new ResourceLocation(ImmersiveCurrency.MOD_ID, key),
                new RecipeType<T>(){
                    public String toString() { return key; }
                }
        );
        data.serial = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                ImmersiveCurrency.MOD_ID+":"+key,
                ctor.get()
        );
        recipeMap.put(key, data);
    }
    public static void registerMenu(String key, MenuType.MenuSupplier<? extends AbstractContainerMenu> ctor){
        menuMap.put(key, ScreenHandlerRegistry.registerSimple(
                new ResourceLocation(ImmersiveCurrency.MOD_ID, key),
                ctor::create
        ));
    }

    public static <T extends Block> void registerGildedBlockSet(String key, Function<BlockBehaviour.Properties,T> ctor, BlockBehaviour.Properties props) {
        registerBlock(key + "_gilded_creeper_trim", ctor, props);
        registerBlock(key + "_gilded_curly_trim", ctor, props);
        registerBlock(key + "_gilded_brick", ctor, props);
        registerBlock(key + "_gilded_bricks", ctor, props);
        registerBlock(key + "_gilded_pillar", ctor, props);
        registerBlock(key + "_gilded_plate", ctor, props);
        registerBlock(key + "_gilded_stone", ctor, props);
        registerBlock("polished_gilded_" + key, ctor, props);
        registerBlock("chiseled_gilded_" + key, ctor, props);
    }

    /*public static <T extends Block, U extends BlockEntity> void registerWithEntity(
            String key,
            Function<BlockBehaviour.Properties,T> ctor,
            FabricBlockEntityTypeBuilder.Factory<U> ctorEntity,
            BlockBehaviour.Properties props)
    {
        register(key, ctor, props);
        BlockData data = blockMap.get(key);

        Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                new ResourceLocation(ModInit.getModid(),key+"_entity"),
                FabricBlockEntityTypeBuilder.create(ctorEntity, data.block).build()
        );

        blockMap.replace(key,data);
    }

     */

    // Accessors
    public static <T extends Block> T getBlock(String key){ return (T)blockMap.get(key).block;}
    public static BlockItem getBlockItem(String key) { return blockMap.get(key).item; }
    public static Item getItem(String key){ return blockMap.get(key).item;}
    public static <T extends BlockEntity> BlockEntityType<T> getBlockEntity(String key) {
        return (BlockEntityType<T>)blockEntityMap.get(key);
    }
    public static <T extends Recipe<?>> RecipeType<T> getRecipeType(String key){
        return (RecipeType<T>)recipeMap.get(key).type;
    }
    public static <T extends Recipe<?>> RecipeSerializer<T> getRecipeSerial(String key){
        return (RecipeSerializer<T>)recipeMap.get(key).serial;
    }
    public static <T extends AbstractContainerMenu> MenuType<T> getMenu(String key){
        return (MenuType<T>) menuMap.get(key);
    }
}
