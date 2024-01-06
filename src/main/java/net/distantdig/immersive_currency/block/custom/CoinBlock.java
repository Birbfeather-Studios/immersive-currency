package net.distantdig.immersive_currency.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CoinBlock extends Block implements SimpleWaterloggedBlock {
    public static final IntegerProperty COINS = IntegerProperty.create("coins", 1, 16);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape COIN_STACK_1 = Shapes.or(
            box(8, 0, 4, 12, 2, 8));
    private static final VoxelShape COIN_STACK_2 = Shapes.or(
            box(4, 0, 10,8, 2, 14),
            box(9, 0, 4,13, 2, 8));
    private static final VoxelShape COIN_STACK_3 = Shapes.or(
            box(6, 0, 9,10, 2, 13),
            box(2, 0, 3,6, 2, 7),
            box(8, 0, 5,12, 2, 9));
    private static final VoxelShape COIN_STACK_4 = Shapes.or(
            COIN_STACK_3,
            box(8, 2, 8,12, 4, 12));
    private static final VoxelShape COIN_STACK_5 = Shapes.or(
            box(2, 0, 5,6, 2, 9),
            box(8, 0, 3,12, 2, 7),
            box(11, 0, 10,15, 2, 14),
            box(6, 0, 7,10, 4, 11));

    private static final VoxelShape COIN_STACK_6 = Shapes.or(
            box(6, 0, 6,10, 6, 10),
            box(11, 0, 4, 15, 2, 8),
            box(5, 0, 2,9, 2, 6),
            box(4, 0, 10, 8, 2, 14));
    private static final VoxelShape COIN_STACK_7 = Shapes.or(
            box(6, 0, 6,10, 8, 10),
            box(10, 0, 5, 14, 2, 9),
            box(5, 0, 2,9, 2, 6),
            box(4, 0, 10, 8, 4, 14));
    private static final VoxelShape COIN_STACK_8 = Shapes.or(
            box(6, 0, 6, 10, 6, 10),
            box(10, 0, 6,14, 2, 10),
            box(6, 0, 2,10, 4, 6),
            box(2, 0, 6,10, 2, 14),
            box(2, 2, 10,6, 4, 14));
    private static final VoxelShape COIN_STACK_9 = Shapes.or(
            box(6, 0, 6, 10, 8, 10),
            box(10, 0, 6,14, 2, 10),
            box(6, 0, 2,10, 6, 6),
            box(2, 0, 6,10, 2, 14),
            box(6, 2, 10,10, 4, 14),
            box(2, 2, 6,2, 4, 10));
    private static final VoxelShape COIN_STACK_10 = Shapes.or(
            box(0,0,0,16,10,16));
    private static final VoxelShape COIN_STACK_11 = Shapes.or(
            box(0,0,0,16,10,16));
    private static final VoxelShape COIN_STACK_12 = Shapes.or(
            box(0,0,0,16,12,16));
    private static final VoxelShape COIN_STACK_13 = Shapes.or(
            box(0,0,0,16,12,16));
    private static final VoxelShape COIN_STACK_14 = Shapes.or(
            box(0,0,0,16,16,16));
    private static final VoxelShape COIN_STACK_15 = Shapes.or(
            box(0,0,0,16,16,16));
    private static final VoxelShape COIN_STACK_16 = Shapes.or(
            box(0,0,0,16,16,16));


    public CoinBlock(Properties properties){
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(COINS, 1).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        return !blockPlaceContext.isSecondaryUseActive() &&
                blockPlaceContext.getItemInHand().getItem() ==
                        this.asItem() &&
                blockState.getValue(COINS) < 16 || super.canBeReplaced(blockState, blockPlaceContext);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockstate = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos());
        if (blockstate.is(this)) {
            return blockstate.cycle(COINS);
        } else {
            FluidState fluidState = blockPlaceContext.getLevel().getFluidState(blockPlaceContext.getClickedPos());
            boolean bl = fluidState.getType() == Fluids.WATER; //temporary, this should be changed to gold coins later!! :)
            return super.getStateForPlacement(blockPlaceContext).setValue(WATERLOGGED, bl);
        }
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState,direction,blockState2,levelAccessor,blockPos,blockPos2);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext collisionContext) {
        switch(state.getValue(COINS)) {
            case 1:
            default:
                return COIN_STACK_1;
            case 2:
                return COIN_STACK_2;
            case 3:
                return COIN_STACK_3;
            case 4:
                return COIN_STACK_4;
            case 5:
                return COIN_STACK_5;
            case 6:
                return COIN_STACK_6;
            case 7:
                return COIN_STACK_7;
            case 8:
                return COIN_STACK_8;
            case 9:
                return COIN_STACK_9;
            case 10:
                return COIN_STACK_10;
            case 11:
                return COIN_STACK_11;
            case 12:
                return COIN_STACK_12;
            case 13:
                return COIN_STACK_13;
            case 14:
                return COIN_STACK_14;
            case 15:
                return COIN_STACK_15;
            case 16:
                return COIN_STACK_16;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{COINS,  WATERLOGGED});
    }

    @Override
    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos blockPos, BlockState blockState, FluidState fluidState) {
        if (!blockState.getValue(WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            BlockState blockState2 = blockState.setValue(WATERLOGGED, true);
            levelAccessor.setBlock(blockPos, blockState2, 3);
            levelAccessor.scheduleTick(blockPos, fluidState.getType(), fluidState.getType().getTickDelay(levelAccessor));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return Block.canSupportCenter(levelReader, blockPos.below(), Direction.UP);
    }
}