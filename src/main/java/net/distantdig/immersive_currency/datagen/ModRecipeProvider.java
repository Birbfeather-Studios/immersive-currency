package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.BlockRegister;
import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemLike> PURE_COPPER_SMELTABLES =java.util.List.of(
            BlockRegister.getBlock("pure_copper_ore")
    );
    private static final List<ItemLike> PURE_IRON_SMELTABLES =java.util.List.of(
            BlockRegister.getBlock("pure_iron_ore")
    );
    private static final List<ItemLike> PURE_GOLD_SMELTABLES =java.util.List.of(
            BlockRegister.getBlock("pure_gold_ore")
    );
    private static final List<ItemLike> PURE_PLATINUM_SMELTABLES =java.util.List.of(
            BlockRegister.getBlock("pure_platinum_ore")
    );

    private static final List<ItemLike> COPPER_CUTTER_RESULTS =java.util.List.of(
            BlockRegister.getBlock("copper_gilded_creeper_trim"),
            BlockRegister.getBlock("copper_gilded_curly_trim"),
            BlockRegister.getBlock("copper_gilded_brick"),
            BlockRegister.getBlock("copper_gilded_bricks"),
            BlockRegister.getBlock("copper_gilded_pillar"),
            BlockRegister.getBlock("copper_gilded_plate"),
            BlockRegister.getBlock("polished_gilded_copper"),
            BlockRegister.getBlock("chiseled_gilded_copper")
    );
    private static final List<ItemLike> IRON_CUTTER_RESULTS =java.util.List.of(
            BlockRegister.getBlock("iron_gilded_creeper_trim"),
            BlockRegister.getBlock("iron_gilded_curly_trim"),
            BlockRegister.getBlock("iron_gilded_brick"),
            BlockRegister.getBlock("iron_gilded_bricks"),
            BlockRegister.getBlock("iron_gilded_pillar"),
            BlockRegister.getBlock("iron_gilded_plate"),
            BlockRegister.getBlock("polished_gilded_iron"),
            BlockRegister.getBlock("chiseled_gilded_iron")
    );
    private static final List<ItemLike> GOLD_CUTTER_RESULTS =java.util.List.of(
            BlockRegister.getBlock("gold_gilded_creeper_trim"),
            BlockRegister.getBlock("gold_gilded_curly_trim"),
            BlockRegister.getBlock("gold_gilded_brick"),
            BlockRegister.getBlock("gold_gilded_bricks"),
            BlockRegister.getBlock("gold_gilded_pillar"),
            BlockRegister.getBlock("gold_gilded_plate"),
            BlockRegister.getBlock("polished_gilded_gold"),
            BlockRegister.getBlock("chiseled_gilded_gold")
    );
    private static final List<ItemLike> PLATINUM_CUTTER_RESULTS =java.util.List.of(
            BlockRegister.getBlock("platinum_gilded_creeper_trim"),
            BlockRegister.getBlock("platinum_gilded_curly_trim"),
            BlockRegister.getBlock("platinum_gilded_brick"),
            BlockRegister.getBlock("platinum_gilded_bricks"),
            BlockRegister.getBlock("platinum_gilded_pillar"),
            BlockRegister.getBlock("platinum_gilded_plate"),
            BlockRegister.getBlock("polished_gilded_platinum"),
            BlockRegister.getBlock("chiseled_gilded_platinum")
    );

    private static void emeraldCompactingStep(ItemLike larger, ItemLike smaller, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, larger, 1)
                .pattern("NNN")
                .pattern("N N")
                .pattern("NNN")
                .define('N', smaller)
                .unlockedBy(getHasName(smaller), has(smaller))
                .save(exporter, new ResourceLocation(getSimpleRecipeName(larger) + "_from_" + getSimpleRecipeName(smaller)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, smaller, 8)
                .requires(larger)
                .unlockedBy(getHasName(larger), has(larger))
                .save(exporter, new ResourceLocation(getSimpleRecipeName(smaller) + "_from_" + getSimpleRecipeName(larger)));
    }
    private static void coinRecipeJsonBuilder(ItemLike currentCoin, ItemLike nugget, ItemLike gem, ItemLike previousCoin, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, currentCoin, 1)
                .pattern("NNN")
                .pattern("NEN")
                .pattern("NNN")
                .define('N', nugget)
                .define('E', gem)
                .unlockedBy(getHasName(nugget), has(nugget))
                .unlockedBy(getHasName(gem), has(gem))
                .save(exporter, new ResourceLocation(getSimpleRecipeName(currentCoin) + "_from_" + getSimpleRecipeName(nugget)));

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
                    .save(exporter, new ResourceLocation(getSimpleRecipeName(previousCoin) + "_from_" + getSimpleRecipeName(currentCoin)));
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

        COPPER_CUTTER_RESULTS.forEach(value -> stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, value, BlockRegister.blockMap.get("copper_gilded_stone").item));
        IRON_CUTTER_RESULTS.forEach(value -> stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, value, BlockRegister.blockMap.get("iron_gilded_stone").item));
        GOLD_CUTTER_RESULTS.forEach(value -> stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, value, BlockRegister.blockMap.get("gold_gilded_stone").item));
        PLATINUM_CUTTER_RESULTS.forEach(value -> stonecutterResultFromBase(exporter, RecipeCategory.BUILDING_BLOCKS, value, BlockRegister.blockMap.get("platinum_gilded_stone").item));

        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_COPPER_NUGGET, RecipeCategory.MISC, ModBlocks.PURE_COPPER_INGOT);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_IRON_NUGGET, RecipeCategory.MISC, ModBlocks.PURE_IRON_INGOT);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_GOLD_NUGGET, RecipeCategory.MISC, ModBlocks.PURE_GOLD_INGOT);
        nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_PLATINUM_NUGGET, RecipeCategory.MISC, ModBlocks.PURE_PLATINUM_INGOT);

        emeraldCompactingStep(ModItems.LARGE_EMERALD, Items.EMERALD,exporter);
        emeraldCompactingStep(Items.EMERALD, ModItems.EMERALD_CHUNK,exporter);
        emeraldCompactingStep(ModItems.EMERALD_CHUNK, ModItems.EMERALD_SHARD,exporter);

        coinRecipeJsonBuilder(ModBlocks.COPPER_COIN, ModItems.PURE_COPPER_NUGGET, ModItems.EMERALD_SHARD, null, exporter);
        coinRecipeJsonBuilder(ModBlocks.IRON_COIN, ModItems.PURE_IRON_NUGGET, ModItems.EMERALD_CHUNK, ModBlocks.COPPER_COIN, exporter);
        coinRecipeJsonBuilder(ModBlocks.GOLD_COIN, ModItems.PURE_GOLD_NUGGET, Items.EMERALD, ModBlocks.IRON_COIN, exporter);
        coinRecipeJsonBuilder(ModBlocks.PLATINUM_COIN, ModItems.PURE_PLATINUM_NUGGET, ModItems.LARGE_EMERALD, ModBlocks.GOLD_COIN, exporter);
    }
}
