package net.distantdig.immersive_currency.datagen;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.distantdig.immersive_currency.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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

    private static void coinRecipeJsonBuilder(Item result, Item nugget, Item gem, Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, result, 1)
                .pattern("NNN")
                .pattern("NEN")
                .pattern("NNN")
                .input('N', nugget)
                .input('E', gem)
                .criterion(hasItem(nugget), conditionsFromItem(nugget))
                .criterion(hasItem(gem), conditionsFromItem(gem))
                .offerTo(exporter, new Identifier(getRecipeName(result)));
    }

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
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

        coinRecipeJsonBuilder(ModItems.COPPER_COIN, ModItems.PURE_COPPER_NUGGET, Items.EMERALD, exporter);
        coinRecipeJsonBuilder(ModItems.IRON_COIN, ModItems.PURE_IRON_NUGGET, Items.EMERALD, exporter);
        coinRecipeJsonBuilder(ModItems.GOLD_COIN, ModItems.PURE_GOLD_NUGGET, Items.EMERALD, exporter);
        coinRecipeJsonBuilder(ModItems.PLATINUM_COIN, ModItems.PURE_PLATINUM_NUGGET, Items.EMERALD, exporter);
    }
}
