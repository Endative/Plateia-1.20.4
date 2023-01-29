package net.endative.plateia.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LineBlock extends Block {
    public static final BooleanProperty DOUBLE = BooleanProperty.of("double");
    public static final BooleanProperty CORNER = BooleanProperty.of("corner");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public LineBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(DOUBLE, false).with(CORNER, false));
    }

    private static VoxelShape SHAPE_NS = Block.createCuboidShape(3, 0, 0, 13, 1, 16);
    private static VoxelShape SHAPE_EW = Block.createCuboidShape(0, 0, 3, 16, 1, 13);

    private static VoxelShape SHAPE_CURVED_SW = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 3, 13, 1, 16),
            Block.createCuboidShape(0, 0, 3, 3, 1, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CURVED_NW = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 0, 13, 1, 13),
            Block.createCuboidShape(0, 0, 3, 3, 1, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CURVED_SE = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 3, 13, 1, 16),
            Block.createCuboidShape(13, 0, 3, 16, 1, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CURVED_NE = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 0, 13, 1, 13),
            Block.createCuboidShape(13, 0, 3, 16, 1, 13), BooleanBiFunction.OR);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        boolean isCorner = state.get(CORNER);
        Direction facing = state.get(FACING);

        if (state.get(CORNER)) {
            switch (facing) {
                case NORTH:
                    return SHAPE_CURVED_NW;
                case SOUTH:
                    return SHAPE_CURVED_SE;
                case EAST:
                    return SHAPE_CURVED_NE;
                case WEST:
                    return SHAPE_CURVED_SW;
            }
        }

        return switch (state.get(FACING)) {
            case EAST, WEST -> SHAPE_EW;
            default -> SHAPE_NS;
        };
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        BlockState northState = world.getBlockState(pos.north());
        BlockState southState = world.getBlockState(pos.south());
        BlockState eastState = world.getBlockState(pos.east());
        BlockState westState = world.getBlockState(pos.west());
        if (!world.isClient()) {
            if (southState.getBlock() instanceof LineBlock && !southState.get(LineBlock.DOUBLE)
                    && westState.getBlock() instanceof LineBlock && !westState.get(LineBlock.DOUBLE)) {
                world.setBlockState(pos, state.with(FACING, Direction.WEST).with(LineBlock.DOUBLE, false).with(LineBlock.CORNER, true));
            }
        }
        if (!world.isClient()) {
            if (northState.getBlock() instanceof LineBlock && !northState.get(LineBlock.DOUBLE)
                    && westState.getBlock() instanceof LineBlock && !westState.get(LineBlock.DOUBLE)) {
                world.setBlockState(pos, state.with(FACING, Direction.NORTH).with(LineBlock.DOUBLE, false).with(LineBlock.CORNER, true));
            }
        }
        if (!world.isClient()) {
            if (southState.getBlock() instanceof LineBlock && !southState.get(LineBlock.DOUBLE)
                    && eastState.getBlock() instanceof LineBlock && !eastState.get(LineBlock.DOUBLE)) {
                world.setBlockState(pos, state.with(FACING, Direction.SOUTH).with(LineBlock.DOUBLE, false).with(LineBlock.CORNER, true));
            }
        }
        if (!world.isClient()) {
            if (northState.getBlock() instanceof LineBlock && !northState.get(LineBlock.DOUBLE)
                    && eastState.getBlock() instanceof LineBlock && !eastState.get(LineBlock.DOUBLE)) {
                world.setBlockState(pos, state.with(FACING, Direction.EAST).with(LineBlock.DOUBLE, false).with(LineBlock.CORNER, true));
            }
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }



    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CORNER);
        builder.add(FACING);
        builder.add(DOUBLE);
    }
}
