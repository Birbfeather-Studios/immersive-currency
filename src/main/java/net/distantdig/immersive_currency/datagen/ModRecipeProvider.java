package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> PURE_COPPER_SMELTABLES =java.util.List.of(
            ModBlocks.PURE_COPPER_ORE
    );
    private static final List<ItemConvertible> PURE_IRON_SMELTABLES =java.util.List.of(
            ModBlocks.PURE_IRON_ORE
    );
    private static final List<ItemConvertible> PURE_GOLD_SMELTABLES =java.util.List.of(
            ModBlocks.PURE_GOLD_ORE
    );
    private static final List<ItemConvertible> PURE_PLATINUM_SMELTABLES =java.util.List.of(
            ModBlocks.PURE_PLATINUM_ORE
    );

    private static void emeraldCompactingStep(Item larger, Item smaller, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, larger, 1)
                .pattern("NNN")
                .pattern("N N")
                .pattern("NNN")
                .input('N', smaller)
                .criterion(hasItem(smaller), conditionsFromItem(smaller))
                .offerTo(exporter, new Identifier(getRecipeName(smaller) + "_to_" + getRecipeName(larger)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, smaller, 8)
                .input(larger)
                .criterion(hasItem(larger), conditionsFromItem(larger))
                .offerTo(exporter, new Identifier(getRecipeName(larger) + "_to_" + getRecipeName(smaller)));
    }
    private static void coinRecipeJsonBuilder(Item currentCoin, Item nugget, Item gem, Item previousCoin, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, currentCoin, 1)
                .pattern("NNN")
                .pattern("NEN")
                .pattern("NNN")
                .input('N', nugget)
                .input('E', gem)
                .criterion(hasItem(nugget), conditionsFromItem(nugget))
                .criterion(hasItem(gem), conditionsFromItem(gem))
                .offerTo(exporter, new Identifier(getRecipeName(currentCoin)));

        if (previousCoin != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, currentCoin, 1)
                    .pattern("CCC")
                    .pattern("C C")
                    .pattern("CCC")
                    .input('C', previousCoin)
                    .criterion(hasItem(previousCoin), conditionsFromItem(previousCoin))
                    .offerTo(exporter, new Identifier(getRecipeName(currentCoin) + "_from_" + getRecipeName(previousCoin)));

            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, previousCoin, 8)
                    .input(currentCoin)
                    .criterion(hasItem(currentCoin), conditionsFromItem(currentCoin))
                    .offerTo(exporter, new Identifier(getRecipeName(currentCoin) + "_to_" + getRecipeName(previousCoin)));
        }
    }

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COIN_POUCH, 1)
                .pattern("SLS")
                .pattern("L L")
                .pattern("LLL")
                .input('L', Items.LEATHER)
                .input('S', Items.STRING)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COIN_POUCH)));

        offerSmelting(exporter, PURE_COPPER_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_COPPER_NUGGET,
                0.7f, 200, "pure_copper");
        offerSmelting(exporter, PURE_IRON_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_IRON_NUGGET,
                0.7f, 200, "pure_iron");
        offerSmelting(exporter, PURE_GOLD_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_GOLD_NUGGET,
                0.7f, 200, "pure_gold");
        offerSmelting(exporter, PURE_PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_PLATINUM_NUGGET,
                0.7f, 200, "pure_platinum");

        offerBlasting(exporter, PURE_COPPER_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_COPPER_NUGGET,
                0.7f, 200, "pure_copper");
        offerBlasting(exporter, PURE_IRON_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_IRON_NUGGET,
                0.7f, 200, "pure_iron");
        offerBlasting(exporter, PURE_GOLD_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_GOLD_NUGGET,
                0.7f, 200, "pure_gold");
        offerBlasting(exporter, PURE_PLATINUM_SMELTABLES, RecipeCategory.MISC, ModItems.PURE_PLATINUM_NUGGET,
                0.7f, 200, "pure_platinum");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_COPPER_NUGGET, RecipeCategory.MISC, ModItems.PURE_COPPER_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_IRON_NUGGET, RecipeCategory.MISC, ModItems.PURE_IRON_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_GOLD_NUGGET, RecipeCategory.MISC, ModItems.PURE_GOLD_INGOT);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.PURE_PLATINUM_NUGGET, RecipeCategory.MISC, ModItems.PURE_PLATINUM_INGOT);

        emeraldCompactingStep(ModItems.LARGE_EMERALD, Items.EMERALD,exporter);
        emeraldCompactingStep(Items.EMERALD, ModItems.EMERALD_CHUNK,exporter);
        emeraldCompactingStep(ModItems.EMERALD_CHUNK, ModItems.EMERALD_SHARD,exporter);

        coinRecipeJsonBuilder(ModItems.COPPER_COIN, ModItems.PURE_COPPER_NUGGET, ModItems.EMERALD_SHARD, null, exporter);
        coinRecipeJsonBuilder(ModItems.IRON_COIN, ModItems.PURE_IRON_NUGGET, ModItems.EMERALD_CHUNK, ModItems.COPPER_COIN, exporter);
        coinRecipeJsonBuilder(ModItems.GOLD_COIN, ModItems.PURE_GOLD_NUGGET, Items.EMERALD, ModItems.IRON_COIN, exporter);
        coinRecipeJsonBuilder(ModItems.PLATINUM_COIN, ModItems.PURE_PLATINUM_NUGGET, ModItems.LARGE_EMERALD, ModItems.GOLD_COIN, exporter);
    }
}
