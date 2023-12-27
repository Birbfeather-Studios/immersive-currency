package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemLike> PURE_COPPER_SMELTABLES =java.util.List.of(
            ModBlocks.PURE_COPPER_ORE
    );
    private static final List<ItemLike> PURE_IRON_SMELTABLES =java.util.List.of(
            ModBlocks.PURE_IRON_ORE
    );
    private static final List<ItemLike> PURE_GOLD_SMELTABLES =java.util.List.of(
            ModBlocks.PURE_GOLD_ORE
    );
    private static final List<ItemLike> PURE_PLATINUM_SMELTABLES =java.util.List.of(
            ModBlocks.PURE_PLATINUM_ORE
    );

    private static void emeraldCompactingStep(Item larger, Item smaller, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, larger, 1)
                .pattern("NNN")
                .pattern("N N")
                .pattern("NNN")
                .define('N', smaller)
                .unlockedBy(getHasName(smaller), has(smaller))
                .save(exporter, new ResourceLocation(getSimpleRecipeName(smaller) + "_to_" + getSimpleRecipeName(larger)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, smaller, 8)
                .requires(larger)
                .unlockedBy(getHasName(larger), has(larger))
                .save(exporter, new ResourceLocation(getSimpleRecipeName(larger) + "_to_" + getSimpleRecipeName(smaller)));
    }
    private static void coinRecipeJsonBuilder(Item currentCoin, Item nugget, Item gem, Item previousCoin, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, currentCoin, 1)
                .pattern("NNN")
                .pattern("NEN")
                .pattern("NNN")
                .define('N', nugget)
                .define('E', gem)
                .unlockedBy(getHasName(nugget), has(nugget))
                .unlockedBy(getHasName(gem), has(gem))
                .save(exporter, new ResourceLocation(getSimpleRecipeName(currentCoin)));

        if (previousCoin != null) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, currentCoin, 1)
                    .pattern("CCC")
                    .pattern("C C")
                    .pattern("CCC")
                    .define('C', previousCoin)
                    .unlockedBy(getHasName(previousCoin), has(previousCoin))
                    .save(exporter, new ResourceLocation(getSimpleRecipeName(currentCoin) + "_from_" + getSimpleRecipeName(previousCoin)));

            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, previousCoin, 8)
                    .requires(currentCoin)
                    .unlockedBy(getHasName(currentCoin), has(currentCoin))
                    .save(exporter, new ResourceLocation(getSimpleRecipeName(currentCoin) + "_to_" + getSimpleRecipeName(previousCoin)));
        }
    }

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COIN_POUCH, 1)
                .pattern("SLS")
                .pattern("L L")
                .pattern("LLL")
                .define('L', Items.LEATHER)
                .define('S', Items.STRING)
                .unlockedBy(getHasName(Items.LEATHER), has(Items.LEATHER))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(exporter, new ResourceLocation(getSimpleRecipeName(ModItems.COIN_POUCH)));

        oreSmelting(exporter, PURE_COPPER_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_COPPER_NUGGET,
                0.7f, 200, "pure_copper");
        oreSmelting(exporter, PURE_IRON_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_IRON_NUGGET,
                0.7f, 200, "pure_iron");
        oreSmelting(exporter, PURE_GOLD_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_GOLD_NUGGET,
                0.7f, 200, "pure_gold");
        oreSmelting(exporter, PURE_PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_PLATINUM_NUGGET,
                0.7f, 200, "pure_platinum");

        oreBlasting(exporter, PURE_COPPER_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_COPPER_NUGGET,
                0.7f, 200, "pure_copper");
        oreBlasting(exporter, PURE_IRON_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_IRON_NUGGET,
                0.7f, 200, "pure_iron");
        oreBlasting(exporter, PURE_GOLD_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_GOLD_NUGGET,
                0.7f, 200, "pure_gold");
        oreBlasting(exporter, PURE_PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_PLATINUM_NUGGET,
                0.7f, 200, "pure_platinum");

        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_COPPER_NUGGET, RecipeCategory.MISC, ModItems.PURE_COPPER_INGOT);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_IRON_NUGGET, RecipeCategory.MISC, ModItems.PURE_IRON_INGOT);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_GOLD_NUGGET, RecipeCategory.MISC, ModItems.PURE_GOLD_INGOT);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_PLATINUM_NUGGET, RecipeCategory.MISC, ModItems.PURE_PLATINUM_INGOT);

        emeraldCompactingStep(ModItems.LARGE_EMERALD, Items.EMERALD,exporter);
        emeraldCompactingStep(Items.EMERALD, ModItems.EMERALD_CHUNK,exporter);
        emeraldCompactingStep(ModItems.EMERALD_CHUNK, ModItems.EMERALD_SHARD,exporter);

        coinRecipeJsonBuilder(ModItems.COPPER_COIN, ModItems.PURE_COPPER_NUGGET, ModItems.EMERALD_SHARD, null, exporter);
        coinRecipeJsonBuilder(ModItems.IRON_COIN, ModItems.PURE_IRON_NUGGET, ModItems.EMERALD_CHUNK, ModItems.COPPER_COIN, exporter);
        coinRecipeJsonBuilder(ModItems.GOLD_COIN, ModItems.PURE_GOLD_NUGGET, Items.EMERALD, ModItems.IRON_COIN, exporter);
        coinRecipeJsonBuilder(ModItems.PLATINUM_COIN, ModItems.PURE_PLATINUM_NUGGET, ModItems.LARGE_EMERALD, ModItems.GOLD_COIN, exporter);
    }
}
