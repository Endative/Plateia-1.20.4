package net.endative.plateia.block.custom;

import net.endative.plateia.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class LineBlock extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public LineBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(FACING, Direction.NORTH));
    }

    private static VoxelShape SHAPE_NS = Block.createCuboidShape(3, 0, 0, 13, 1, 16);
    private static VoxelShape SHAPE_EW = Block.createCuboidShape(0, 0, 3, 16, 1, 13);
    private static VoxelShape SHAPE_CORNER_N = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 0, 13, 1, 13),
            Block.createCuboidShape(13, 0, 3, 16, 1, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CORNER_E = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 3, 16, 1, 13),
            Block.createCuboidShape(3, 0, 13, 13, 1, 16), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CORNER_S = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 3, 13, 1, 16),
            Block.createCuboidShape(0, 0, 3, 3, 1, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_CORNER_W = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(0, 0, 3, 13, 1, 13),
            Block.createCuboidShape(3, 0, 0, 13, 1, 3), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_3WAY_N = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(0, 0, 3, 16, 1, 13),
            Block.createCuboidShape(3, 0, 0, 13, 1, 3), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_3WAY_E = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 0, 13, 1, 16),
            Block.createCuboidShape(13, 0, 3, 16, 1, 13), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_3WAY_S = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(0, 0, 3, 16, 1, 13),
            Block.createCuboidShape(3, 0, 13, 13, 1, 16), BooleanBiFunction.OR);
    private static VoxelShape SHAPE_3WAY_W = VoxelShapes.combineAndSimplify(
            Block.createCuboidShape(3, 0, 0, 13, 1, 16),
            Block.createCuboidShape(0, 0, 3, 3, 1, 13), BooleanBiFunction.OR);

    private static VoxelShape SHAPE_4WAY = Stream.of(
            Block.createCuboidShape(3, 0, 0, 13, 1, 16),
            Block.createCuboidShape(0, 0, 3, 3, 1, 13),
            Block.createCuboidShape(13, 0, 3, 16, 1, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static VoxelShape SHAPE_SQUARE = Block.createCuboidShape(3, 0, 3, 13, 1, 13);

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (world.getBlockState(pos.down()).getBlock() == Blocks.GRASS_BLOCK) {
            world.setBlockState(pos.down(), Blocks.GRASS_BLOCK.getDefaultState(), 3);
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getStackInHand(hand);

        if (heldItem.getItem() instanceof ShovelItem) {
            if (!world.isClient) {
                if (player.getAbilities().creativeMode) {
                    Block[] blockCycle1 = {
                            ModBlocks.WHITE_ROAD_LINE,
                            ModBlocks.OFF_CENTRED_WHITE_ROAD_LINE,
                            ModBlocks.DOUBLE_WHITE_ROAD_LINE,
                            ModBlocks.WHITE_CORNER_ROAD_LINE,
                            ModBlocks.DOUBLE_WHITE_CORNER_ROAD_LINE,
                            ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.THREE_WAY_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.HOLLOW_THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.FOUR_WAY_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
                            ModBlocks.WHITE_DOT_ROAD_PATTERN,
                            ModBlocks.WHITE_RECTANGLE_ROAD_PATTERN,
                    };

                    Block[] blockCycle2 = {
                            ModBlocks.YELLOW_ROAD_LINE,
                            ModBlocks.OFF_CENTRED_YELLOW_ROAD_LINE,
                            ModBlocks.DOUBLE_YELLOW_ROAD_LINE,
                            ModBlocks.YELLOW_CORNER_ROAD_LINE,
                            ModBlocks.DOUBLE_YELLOW_CORNER_ROAD_LINE,
                            ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.THREE_WAY_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.HOLLOW_THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.FOUR_WAY_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
                            ModBlocks.YELLOW_DOT_ROAD_PATTERN,
                            ModBlocks.YELLOW_RECTANGLE_ROAD_PATTERN,
                    };

                    int currentIndex1 = -1;
                    int currentIndex2 = -1;

                    for (int i = 0; i < blockCycle1.length; i++) {
                        if (state.getBlock() == blockCycle1[i]) {
                            currentIndex1 = i;
                            break;
                        }
                    }

                    for (int i = 0; i < blockCycle2.length; i++) {
                        if (state.getBlock() == blockCycle2[i]) {
                            currentIndex2 = i;
                            break;
                        }
                    }

                    if (currentIndex1 != -1) {
                        int nextIndex = (currentIndex1 + 1) % blockCycle1.length;
                        BlockState nextState = blockCycle1[nextIndex].getDefaultState();
                        nextState = nextState.with(Properties.HORIZONTAL_FACING, state.get(Properties.HORIZONTAL_FACING));
                        world.setBlockState(pos, nextState);

                        world.playSound(null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);

                        heldItem.damage(1, player, playerEntity -> playerEntity.sendToolBreakStatus(hand));

                        return ActionResult.SUCCESS;
                    } else if (currentIndex2 != -1) {
                        int nextIndex = (currentIndex2 + 1) % blockCycle2.length;
                        BlockState nextState = blockCycle2[nextIndex].getDefaultState();
                        nextState = nextState.with(Properties.HORIZONTAL_FACING, state.get(Properties.HORIZONTAL_FACING));
                        world.setBlockState(pos, nextState);

                        world.playSound(null, pos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);

                        return ActionResult.SUCCESS;
                    }
                }
            }
        } else if (heldItem.getItem() == Items.YELLOW_DYE) {
            if (!world.isClient) {
                BlockState nextState = null;

                Block block = state.getBlock();
                if (block.equals(ModBlocks.WHITE_ROAD_LINE)) {
                    nextState = ModBlocks.YELLOW_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.OFF_CENTRED_WHITE_ROAD_LINE)) {
                    nextState = ModBlocks.OFF_CENTRED_YELLOW_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.DOUBLE_WHITE_ROAD_LINE)) {
                    nextState = ModBlocks.DOUBLE_YELLOW_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.WHITE_CORNER_ROAD_LINE)) {
                    nextState = ModBlocks.YELLOW_CORNER_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.DOUBLE_WHITE_CORNER_ROAD_LINE)) {
                    nextState = ModBlocks.DOUBLE_YELLOW_CORNER_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.THREE_WAY_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.THREE_WAY_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.HOLLOW_THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.HOLLOW_THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.FOUR_WAY_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.FOUR_WAY_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_YELLOW_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.WHITE_DOT_ROAD_PATTERN)) {
                    nextState = ModBlocks.YELLOW_DOT_ROAD_PATTERN.getDefaultState();
                } else if (block.equals(ModBlocks.WHITE_RECTANGLE_ROAD_PATTERN)) {
                    nextState = ModBlocks.YELLOW_RECTANGLE_ROAD_PATTERN.getDefaultState();
                }

                if (nextState != null) {
                    nextState = nextState.with(Properties.HORIZONTAL_FACING, state.get(Properties.HORIZONTAL_FACING));
                    world.setBlockState(pos, nextState);

                    world.playSound(null, pos, SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);

                    if (!player.getAbilities().creativeMode) {
                        heldItem.decrement(1);
                    }
                    return ActionResult.CONSUME;
                }
            }
        } else if (heldItem.getItem() == Items.WHITE_DYE) {
            if (!world.isClient) {
                BlockState nextState = null;

                Block block = state.getBlock();
                if (block.equals(ModBlocks.YELLOW_ROAD_LINE)) {
                    nextState = ModBlocks.WHITE_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.OFF_CENTRED_YELLOW_ROAD_LINE)) {
                    nextState = ModBlocks.OFF_CENTRED_WHITE_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.DOUBLE_YELLOW_ROAD_LINE)) {
                    nextState = ModBlocks.DOUBLE_WHITE_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.YELLOW_CORNER_ROAD_LINE)) {
                    nextState = ModBlocks.WHITE_CORNER_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.DOUBLE_YELLOW_CORNER_ROAD_LINE)) {
                    nextState = ModBlocks.DOUBLE_WHITE_CORNER_ROAD_LINE.getDefaultState();
                } else if (block.equals(ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.THREE_WAY_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.THREE_WAY_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.HOLLOW_THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.HOLLOW_THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.FOUR_WAY_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.FOUR_WAY_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_YELLOW_ROAD_LINE_CONNECTION)) {
                    nextState = ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_ROAD_LINE_CONNECTION.getDefaultState();
                } else if (block.equals(ModBlocks.YELLOW_DOT_ROAD_PATTERN)) {
                    nextState = ModBlocks.WHITE_DOT_ROAD_PATTERN.getDefaultState();
                } else if (block.equals(ModBlocks.YELLOW_RECTANGLE_ROAD_PATTERN)) {
                    nextState = ModBlocks.WHITE_RECTANGLE_ROAD_PATTERN.getDefaultState();
                }

                if (nextState != null) {
                    nextState = nextState.with(Properties.HORIZONTAL_FACING, state.get(Properties.HORIZONTAL_FACING));
                    world.setBlockState(pos, nextState);

                    world.playSound(null, pos, SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0f, 1.0f);

                    if (!player.getAbilities().creativeMode) {
                        heldItem.decrement(1);
                    }
                    return ActionResult.CONSUME;
                }
            }
        }
        return ActionResult.PASS;
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        Block block = state.getBlock();

        if (block == ModBlocks.WHITE_ROAD_LINE || block == ModBlocks.DOUBLE_WHITE_ROAD_LINE ||
                block == ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_WHITE_ROAD_LINE_CONNECTION || block == ModBlocks.OFF_CENTRED_WHITE_ROAD_LINE ||
                block == ModBlocks.WHITE_RECTANGLE_ROAD_PATTERN || block == ModBlocks.YELLOW_ROAD_LINE ||
                block == ModBlocks.OFF_CENTRED_YELLOW_ROAD_LINE || block == ModBlocks.DOUBLE_YELLOW_ROAD_LINE ||
                block == ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_YELLOW_ROAD_LINE_CONNECTION || block == ModBlocks.YELLOW_RECTANGLE_ROAD_PATTERN) {

            if (facing == Direction.EAST || facing == Direction.WEST) {
                return SHAPE_EW;
            } else if (facing == Direction.NORTH || facing == Direction.SOUTH) {
                return SHAPE_NS;
            }
        } else if (block == ModBlocks.WHITE_CORNER_ROAD_LINE || block == ModBlocks.DOUBLE_WHITE_CORNER_ROAD_LINE ||
                block == ModBlocks.YELLOW_CORNER_ROAD_LINE || block == ModBlocks.DOUBLE_YELLOW_CORNER_ROAD_LINE) {

            if (facing == Direction.NORTH) {
                return SHAPE_CORNER_N;
            } else if (facing == Direction.EAST) {
                return SHAPE_CORNER_E;
            } else if (facing == Direction.SOUTH) {
                return SHAPE_CORNER_S;
            } else if (facing == Direction.WEST) {
                return SHAPE_CORNER_W;
            }
            return VoxelShapes.fullCube();
        } else if (block == ModBlocks.THREE_WAY_WHITE_ROAD_LINE_CONNECTION ||
                block == ModBlocks.THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION ||
                block == ModBlocks.HOLLOW_THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION ||
                block == ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_WHITE_ROAD_LINE_CONNECTION ||
                block == ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_WHITE_ROAD_LINE_CONNECTION ||
                block == ModBlocks.THREE_WAY_YELLOW_ROAD_LINE_CONNECTION || block == ModBlocks.THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION ||
                block == ModBlocks.HOLLOW_THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION ||
                block == ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_YELLOW_ROAD_LINE_CONNECTION ||
                block == ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_YELLOW_ROAD_LINE_CONNECTION) {

            if (facing == Direction.NORTH) {
                return SHAPE_3WAY_N;
            } else if (facing == Direction.EAST) {
                return SHAPE_3WAY_E;
            } else if (facing == Direction.SOUTH) {
                return SHAPE_3WAY_S;
            } else if (facing == Direction.WEST) {
                return SHAPE_3WAY_W;
            }
        } else if (block == ModBlocks.FOUR_WAY_WHITE_ROAD_LINE_CONNECTION || block == ModBlocks.FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION ||
                block == ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION ||
                block == ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_ROAD_LINE_CONNECTION ||
                block == ModBlocks.FOUR_WAY_YELLOW_ROAD_LINE_CONNECTION || block == ModBlocks.FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION ||
                block == ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION ||
                block == ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_YELLOW_ROAD_LINE_CONNECTION ||
                block == ModBlocks.FOUR_WAY_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION ||
                block == ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION) {

            return SHAPE_4WAY;
        } else if (block == ModBlocks.WHITE_DOT_ROAD_PATTERN || block == ModBlocks.YELLOW_DOT_ROAD_PATTERN) {

            return SHAPE_SQUARE;
        }
        return VoxelShapes.fullCube();
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        return hasTopRim(world, blockPos) || sideCoversSmallSquare(world, blockPos, Direction.UP);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction playerFacing = ctx.getPlayer().getHorizontalFacing().getOpposite();
        return this.getDefaultState().with(FACING, playerFacing);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
