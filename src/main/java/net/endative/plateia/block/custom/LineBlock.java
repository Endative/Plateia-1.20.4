package net.endative.plateia.block.custom;

import net.endative.plateia.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LineBlock extends Block {
    public static final BooleanProperty DOUBLE = BooleanProperty.of("double");
    public static final BooleanProperty CORNER = BooleanProperty.of("corner");

    //Colours

    public static final BooleanProperty WHITE = BooleanProperty.of("white");
    public static final BooleanProperty ORANGE = BooleanProperty.of("orange");
    public static final BooleanProperty MAGENTA = BooleanProperty.of("magenta");
    public static final BooleanProperty LIGHT_BLUE = BooleanProperty.of("light_blue");
    public static final BooleanProperty YELLOW = BooleanProperty.of("yellow");
    public static final BooleanProperty LIME = BooleanProperty.of("lime");
    public static final BooleanProperty PINK = BooleanProperty.of("pink");
    public static final BooleanProperty GREY = BooleanProperty.of("grey");
    public static final BooleanProperty LIGHT_GREY = BooleanProperty.of("light_grey");
    public static final BooleanProperty CYAN = BooleanProperty.of("cyan");
    public static final BooleanProperty PURPLE = BooleanProperty.of("purple");
    public static final BooleanProperty BLUE = BooleanProperty.of("blue");
    public static final BooleanProperty BROWN = BooleanProperty.of("brown");
    public static final BooleanProperty GREEN = BooleanProperty.of("green");
    public static final BooleanProperty RED = BooleanProperty.of("red");
    public static final BooleanProperty BLACK = BooleanProperty.of("black");


    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public LineBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(DOUBLE, false).with(CORNER, false));
    }

    private static VoxelShape SHAPE_NS = Block.createCuboidShape(3, 0, 0, 13, 0.5, 16);
    private static VoxelShape SHAPE_EW = Block.createCuboidShape(0, 0, 3, 16, 0.5, 13);

    private static VoxelShape SHAPE_CURVED_SW = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 3, 13, 0.5, 16),
            Block.createCuboidShape(0, 0, 3, 3, 0.5, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CURVED_NW = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 0, 13, 0.5, 13),
            Block.createCuboidShape(0, 0, 3, 3, 0.5, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CURVED_SE = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 3, 13, 0.5, 16),
            Block.createCuboidShape(13, 0, 3, 16, 0.5, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CURVED_NE = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 0, 13, 0.5, 13),
            Block.createCuboidShape(13, 0, 3, 16, 0.5, 13), BooleanBiFunction.OR);

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
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        ItemStack itemStack = super.getPickStack(world, pos, state);
        if (state.get(DOUBLE)) {
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putString(DOUBLE.getName(), String.valueOf(state.get(DOUBLE)));
            itemStack.setSubNbt("BlockStateTag", nbtCompound);
            itemStack.setSubNbt("Double", nbtCompound);
        }
        if (state.get(CORNER)) {
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putString(CORNER.getName(), String.valueOf(state.get(CORNER)));
            itemStack.setSubNbt("BlockStateTag", nbtCompound);
            itemStack.setSubNbt("Corner", nbtCompound);
        }
        if ((state.get(CORNER)) && (state.get(DOUBLE))) {
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putString(CORNER.getName(), String.valueOf(state.get(CORNER)));
            nbtCompound.putString(DOUBLE.getName(), String.valueOf(state.get(DOUBLE)));
            itemStack.setSubNbt("BlockStateTag", nbtCompound);
            itemStack.setSubNbt("Double Corner", nbtCompound);
        }

        return itemStack;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        NbtCompound tag = stack.getNbt();
        if (tag != null && tag.contains("Double") && tag.contains("Corner")) {
            tooltip.add(Text.translatable("Double Corner").formatted(Formatting.AQUA));
        }
        else if (tag != null && tag.contains("Double")) {
            tooltip.add(Text.translatable("Double").formatted(Formatting.AQUA));
        }
        else if (tag != null && tag.contains("Corner")) {
            tooltip.add(Text.translatable("Corner").formatted(Formatting.AQUA));
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);
        if (heldItem.getItem() == Items.WHITE_DYE) {
            BlockState newState = ModBlocks.LINE.getDefaultState().with(WHITE, true);
            world.setBlockState(pos, newState);
            if (!player.isCreative()) {
                heldItem.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        if (heldItem.getItem() == Items.ORANGE_DYE) {
            BlockState newState = ModBlocks.LINE.getDefaultState().with(ORANGE, true);
            world.setBlockState(pos, newState);
            if (!player.isCreative()) {
                heldItem.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CORNER);
        builder.add(FACING);
        builder.add(DOUBLE);

        builder.add(WHITE);
        builder.add(ORANGE);
        builder.add(MAGENTA);
        builder.add(LIGHT_BLUE);
        builder.add(YELLOW);
        builder.add(LIME);
        builder.add(PINK);
        builder.add(GREY);
        builder.add(LIGHT_GREY);
        builder.add(CYAN);
        builder.add(PURPLE);
        builder.add(BLUE);
        builder.add(BROWN);
        builder.add(GREEN);
        builder.add(RED);
        builder.add(BLACK);
    }
}
