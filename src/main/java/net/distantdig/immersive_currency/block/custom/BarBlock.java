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
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BarBlock extends Block implements SimpleWaterloggedBlock {
    public static final IntegerProperty BARS = IntegerProperty.create("bars", 1, 8);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape BAR_STACK_1 = Block.box(5, 0, 1, 11, 4, 15);
    private static final VoxelShape BAR_STACK_2 = Block.box(1,0,0,14,9,16);
    private static final VoxelShape BAR_STACK_3 = Block.box(1,0,1,15,8,15);
    private static final VoxelShape BAR_STACK_4 = Block.box(1,0,1,15,12,15);
    private static final VoxelShape BAR_STACK_5 = Block.box(1,0,1,15,12,15);
    private static final VoxelShape BAR_STACK_6 = Block.box(1,0,1,15,12,15);
    private static final VoxelShape BAR_STACK_7 = Block.box(1,0,1,15,16,15);
    private static final VoxelShape BAR_STACK_8 = Block.box(1,0,1,15,16,15);


    public BarBlock(Properties properties){
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(BARS, 1).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext blockPlaceContext) {
        return !blockPlaceContext.isSecondaryUseActive() &&
                blockPlaceContext.getItemInHand().getItem() ==
                        this.asItem() &&
                blockState.getValue(BARS) < 8 || super.canBeReplaced(blockState, blockPlaceContext);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockState blockstate = blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos());
        if (blockstate.is(this)) {
            return blockstate.cycle(BARS);
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
        switch(state.getValue(BARS)) {
            case 1:
            default:
                return BAR_STACK_1;
            case 2:
                return BAR_STACK_2;
            case 3:
                return BAR_STACK_3;
            case 4:
                return BAR_STACK_4;
            case 5:
                return BAR_STACK_5;
            case 6:
                return BAR_STACK_6;
            case 7:
                return BAR_STACK_7;
            case 8:
                return BAR_STACK_8;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{BARS,  WATERLOGGED});
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