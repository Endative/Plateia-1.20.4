package net.endative.plateia.block.custom;

import net.endative.plateia.block.ModBlocks;
import net.endative.plateia.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CustomWireBlock extends CalciteWireBlock {
    public CustomWireBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getStackInHand(hand).getItem() == ModItems.CALCITE_DUST) {
            if (!world.isClient) {
                world.setBlockState(pos, ModBlocks.DOUBLE_CALCITE_WIRE.getDefaultState());
                if (!player.isCreative()) {
                    ItemStack stack = player.getStackInHand(hand);
                    if (stack.getItem() == ModItems.CALCITE_DUST) {
                        BlockState blockState = world.getBlockState(pos);
                        Block block = blockState.getBlock();
                        if (block == ModBlocks.CALCITE_WIRE) {
                            stack.decrement(1);
                            player.setStackInHand(hand, stack);
                        }
                        else return ActionResult.PASS;
                    }
                }
            }

        } else {
            BlockState blockState = isFullyConnected(state) ? this.getDefaultState() : this.dotState;
            blockState = (BlockState) blockState.with(POWER, (Integer) state.get(POWER));
            blockState = this.getPlacementState(world, blockState, pos);
            if (blockState != state) {
                world.setBlockState(pos, blockState, 3);
                this.updateForNewState(world, pos, state, blockState);
            }
        }
        return ActionResult.SUCCESS;
    }




    @Override
    public int getWeakCustomPower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    public int getStrongCustomPower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 0;
    }

    @Override
    public boolean addPoweredParticles(World world, Random random, BlockPos pos, Vec3d color, Direction direction, Direction direction2, float f, float g) {
        return false;
    }

}
