package net.distantdig.immersive_currency.item.custom;

import net.distantdig.immersive_currency.block.ModBlocks;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Optional;
import java.util.stream.Stream;

public class CoinPouchItem extends BundleItem {
    private static final String ITEMS_KEY = "Items";

    public CoinPouchItem(Properties settings) {
        super(settings);
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction clickAction, Player player) {
        if (clickAction != ClickAction.SECONDARY) {
            return false;
        }
        ItemStack itemStack = slot.getItem();
        if (itemStack.isEmpty()) {
            this.playRemoveOneSound(player);
            CoinPouchItem.removeFirstStack(stack).ifPresent(removedStack -> CoinPouchItem.addToBundle(stack, slot.safeInsert(removedStack)));
        } else if (checkIfCoin(itemStack)) {
            int i = (64 - CoinPouchItem.getBundleOccupancy(stack)) / CoinPouchItem.getItemOccupancy(itemStack);
            int j = CoinPouchItem.addToBundle(stack, slot.safeTake(itemStack.getCount(), i, player));
            if (j > 0) {
                this.playInsertSound(player);
            }
        }
        return true;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack otherStack, Slot slot, ClickAction clickAction, Player player, SlotAccess cursorSlotAccess) {
        if (clickAction != ClickAction.SECONDARY || !slot.allowModification(player)) {
            return false;
        }
        if (otherStack.isEmpty()) {
            CoinPouchItem.removeFirstStack(stack).ifPresent(itemStack -> {
                this.playRemoveOneSound(player);
                cursorSlotAccess.set(itemStack);
            });
        } else if (checkIfCoin(otherStack)){
            int i = CoinPouchItem.addToBundle(stack, otherStack);
            if (i > 0) {
                this.playInsertSound(player);
                otherStack.shrink(i);
            }
        }
        return true;
    }

    private static int getBundleOccupancy(ItemStack stack) {
        return CoinPouchItem.getBundledStacks(stack).mapToInt(itemStack -> CoinPouchItem.getItemOccupancy(itemStack) * itemStack.getCount()).sum();
    }
    private static int getItemOccupancy(ItemStack stack) {
        CompoundTag compoundTag;
        if (stack.is(Items.BUNDLE)) {
            return 4 + CoinPouchItem.getBundleOccupancy(stack);
        }
        if ((stack.is(Items.BEEHIVE) || stack.is(Items.BEE_NEST)) && stack.hasTag() && (compoundTag = BlockItem.getBlockEntityData(stack)) != null && !compoundTag.getList("Bees", Tag.TAG_COMPOUND).isEmpty()) {
            return 64;
        }
        return 64 / stack.getMaxStackSize();
    }
    private static Stream<ItemStack> getBundledStacks(ItemStack stack) {
        CompoundTag compoundTag = stack.getTag();
        if (compoundTag == null) {
            return Stream.empty();
        }
        ListTag nbtList = compoundTag.getList(ITEMS_KEY, Tag.TAG_COMPOUND);
        return nbtList.stream().map(CompoundTag.class::cast).map(ItemStack::of);
    }

    private static boolean checkIfCoin(ItemStack stack) {
        return stack.is(ModBlocks.COPPER_COIN.asItem())
                || stack.is(ModBlocks.IRON_COIN.asItem())
                || stack.is(ModBlocks.GOLD_COIN.asItem())
                || stack.is(ModBlocks.PLATINUM_COIN.asItem());
    }

    private static ItemStack convertCoin(ItemStack stack) {
        if (stack.is(ModBlocks.GOLD_COIN.asItem())) {
            int newCount = stack.getCount() / 8;
            return new ItemStack(ModBlocks.PLATINUM_COIN.asItem(), newCount);
        }
        if (stack.is(ModBlocks.IRON_COIN.asItem())) {
            int newCount = stack.getCount() / 8;
            return new ItemStack(ModBlocks.GOLD_COIN.asItem(), newCount);
        }
        if (stack.is(ModBlocks.COPPER_COIN.asItem())) {
            int newCount = stack.getCount() / 8;
            return new ItemStack(ModBlocks.IRON_COIN, newCount);
        }
        else {
            return stack;
        }
    }

    private static int addToBundle(ItemStack bundle, ItemStack stack) {
        if (!stack.is(ModBlocks.PLATINUM_COIN.asItem()) && stack.getCount() >= 8) {
            ItemStack newStack = new ItemStack(stack.getItem(), stack.getCount());
            stack.setCount(stack.getCount() % 8);
            newStack = convertCoin(newStack);
            addToBundle(bundle, newStack);
        }
        if (stack.isEmpty() || !checkIfCoin(stack)) {
            return 0;
        }
        CompoundTag compoundTag = bundle.getOrCreateTag();
        if (!compoundTag.contains(ITEMS_KEY)) {
            compoundTag.put(ITEMS_KEY, new ListTag());
        }
        int i = CoinPouchItem.getBundleOccupancy(bundle);
        int j = CoinPouchItem.getItemOccupancy(stack);
        int k = Math.min(stack.getCount(), (64 - i) / j);
        if (k == 0) {
            return 0;
        }
        ListTag listTag = compoundTag.getList(ITEMS_KEY, Tag.TAG_COMPOUND);
        Optional<CompoundTag> optional = CoinPouchItem.canMergeStack(stack, listTag);
        if (optional.isPresent()) {
            CompoundTag compoundTag2 = optional.get();
            ItemStack itemStack = ItemStack.of(compoundTag2);
            itemStack.grow(k);
            itemStack.save(compoundTag2);
            listTag.remove(compoundTag2);
            listTag.add(0, compoundTag2);
        } else {
            ItemStack itemStack2 = stack.copyWithCount(k);
            CompoundTag compoundTag3 = new CompoundTag();
            itemStack2.save(compoundTag3);
            listTag.add(0, compoundTag3);
        }
        return k;
    }

    private static Optional<CompoundTag> canMergeStack(ItemStack stack, ListTag items) {
        if (stack.is(Items.BUNDLE)) {
            return Optional.empty();
        }
        return items.stream().filter(CompoundTag.class::isInstance).map(CompoundTag.class::cast).filter(item -> ItemStack.isSameItemSameTags(ItemStack.of(item), stack)).findFirst();
    }

    private static Optional<ItemStack> removeFirstStack(ItemStack stack) {
        CompoundTag compoundTag = stack.getOrCreateTag();
        if (!compoundTag.contains(ITEMS_KEY)) {
            return Optional.empty();
        }
        ListTag listTag = compoundTag.getList(ITEMS_KEY, Tag.TAG_COMPOUND);
        if (listTag.isEmpty()) {
            return Optional.empty();
        }
        boolean i = false;
        CompoundTag compoundTag2 = listTag.getCompound(0);
        ItemStack itemStack = ItemStack.of(compoundTag2);
        listTag.remove(0);
        if (listTag.isEmpty()) {
            stack.removeTagKey(ITEMS_KEY);
        }
        return Optional.of(itemStack);
    }

    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8f, 0.8f + entity.level().getRandom().nextFloat() * 0.4f);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.8f, 0.8f + entity.level().getRandom().nextFloat() * 0.4f);
    }
}
