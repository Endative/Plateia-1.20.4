package net.endative.plateia.block;

import net.endative.plateia.Plateia;
import net.endative.plateia.block.custom.LineBlock;
import net.endative.plateia.item.ModItemGroup;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //Smooth Dark Prismarine
    public static final Block SMOOTH_DARK_PRISMARINE = registerBlock("smooth_dark_prismarine",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(1f).requiresTool().sounds(BlockSoundGroup.STONE)));

    //Smooth Dark Prismarine Stairs
    public static final Block SMOOTH_DARK_PRISMARINE_STAIRS = registerBlock("smooth_dark_prismarine_stairs",
            new StairsBlock(ModBlocks.SMOOTH_DARK_PRISMARINE.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.STONE).strength(1f).requiresTool().sounds(BlockSoundGroup.STONE)));

    //Smooth Dark Prismarine Slab
    public static final Block SMOOTH_DARK_PRISMARINE_SLAB = registerBlock("smooth_dark_prismarine_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(1f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    //Searstone
    public static final Block SEARSTONE = registerBlock("searstone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(1.8f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    //Polished Searstone
    public static final Block POLISHED_SEARSTONE = registerBlock("polished_searstone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f).requiresTool().sounds(BlockSoundGroup.STONE)));

    //Searstone Wall
    public static final Block SEARSTONE_WALL = registerBlock("searstone_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(1.8f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    //Polished Searstone Wall
    public static final Block POLISHED_SEARSTONE_WALL = registerBlock("polished_searstone_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    //Searstone Stairs
    public static final Block SEARSTONE_STAIRS = registerBlock("searstone_stairs",
            new StairsBlock(ModBlocks.SEARSTONE.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.STONE).strength(1.8f).requiresTool().sounds(BlockSoundGroup.STONE)));

    //Polished Searstone Stairs
    public static final Block POLISHED_SEARSTONE_STAIRS = registerBlock("polished_searstone_stairs",
            new StairsBlock(ModBlocks.POLISHED_SEARSTONE.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)
                            .requiresTool().sounds(BlockSoundGroup.STONE)));

    //Searstone Slab
    public static final Block SEARSTONE_SLAB = registerBlock("searstone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(1.8f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));

    //Polished Searstone Slab
    public static final Block POLISHED_SEARSTONE_SLAB = registerBlock("polished_searstone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)));







    //White Road Line
    public static final Block WHITE_ROAD_LINE = register("white_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Off-Centred White Road Line
    public static final Block OFF_CENTRED_WHITE_ROAD_LINE = register("off_centred_white_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Double White Road Line
    public static final Block DOUBLE_WHITE_ROAD_LINE = register("double_white_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //White Corner Road Line
    public static final Block WHITE_CORNER_ROAD_LINE = register("white_corner_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Double White Corner Road Line
    public static final Block DOUBLE_WHITE_CORNER_ROAD_LINE = register("double_white_corner_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //2-Way Single to Double White Road Line Connection
    public static final Block TWO_WAY_SINGLE_TO_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("2_way_single_to_double_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //3-Way White Road Line Connection
    public static final Block THREE_WAY_WHITE_ROAD_LINE_CONNECTION = register("3_way_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //3-Way Double White Road Line Connection
    public static final Block THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("3_way_double_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Hollow 3-Way Double White Road Line Connection
    public static final Block HOLLOW_THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("hollow_3_way_double_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //3-Way Single Through Double White Road Line Connection
    public static final Block THREE_WAY_SINGLE_THROUGH_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("3_way_single_through_double_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //3-Way Double Through Single White Road Line Connection
    public static final Block THREE_WAY_DOUBLE_THROUGH_SINGLE_WHITE_ROAD_LINE_CONNECTION = register("3_way_double_through_single_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //4-Way White Road Line Connection
    public static final Block FOUR_WAY_WHITE_ROAD_LINE_CONNECTION = register("4_way_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //4-Way Double White Road Line Connection
    public static final Block FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("4_way_double_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Hollow 4-Way Double White Road Line Connection
    public static final Block HOLLOW_FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("hollow_4_way_double_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //4-Way Single and Double White Road Line Connection
    public static final Block FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("4_way_single_and_double_white_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //White Dot Road Pattern
    public static final Block WHITE_DOT_ROAD_PATTERN = register("white_dot_road_pattern",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //White Rectangle Road Pattern
    public static final Block WHITE_RECTANGLE_ROAD_PATTERN = register("white_rectangle_road_pattern",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //4-Way Double White and Yellow Road Line Connection
    public static final Block FOUR_WAY_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION = register("4_way_double_white_and_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //4-Way Single and Double White and Yellow Road Line Connection
    public static final Block FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION = register("4_way_single_and_double_white_and_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));







    //Yellow Road Line
    public static final Block YELLOW_ROAD_LINE = register("yellow_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Off-Centred Yellow Road Line
    public static final Block OFF_CENTRED_YELLOW_ROAD_LINE = register("off_centred_yellow_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Double Yellow Road Line
    public static final Block DOUBLE_YELLOW_ROAD_LINE = register("double_yellow_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Yellow Corner Road Line
    public static final Block YELLOW_CORNER_ROAD_LINE = register("yellow_corner_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Double Yellow Corner Road Line
    public static final Block DOUBLE_YELLOW_CORNER_ROAD_LINE = register("double_yellow_corner_road_line",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //2-Way Single to Double Yellow Road Line Connection
    public static final Block TWO_WAY_SINGLE_TO_DOUBLE_YELLOW_ROAD_LINE_CONNECTION = register("2_way_single_to_double_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //3-Way Yellow Road Line Connection
    public static final Block THREE_WAY_YELLOW_ROAD_LINE_CONNECTION = register("3_way_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //3-Way Double Yellow Road Line Connection
    public static final Block THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION = register("3_way_double_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Hollow 3-Way Double Yellow Road Line Connection
    public static final Block HOLLOW_THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION = register("hollow_3_way_double_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //3-Way Single Through Double Yellow Road Line Connection
    public static final Block THREE_WAY_SINGLE_THROUGH_DOUBLE_YELLOW_ROAD_LINE_CONNECTION = register("3_way_single_through_double_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //3-Way Double Through Single Yellow Road Line Connection
    public static final Block THREE_WAY_DOUBLE_THROUGH_SINGLE_YELLOW_ROAD_LINE_CONNECTION = register("3_way_double_through_single_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //4-Way Yellow Road Line Connection
    public static final Block FOUR_WAY_YELLOW_ROAD_LINE_CONNECTION = register("4_way_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //4-Way Double Yellow Road Line Connection
    public static final Block FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION = register("4_way_double_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Hollow 4-Way Double Yellow Road Line Connection
    public static final Block HOLLOW_FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION = register("hollow_4_way_double_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //4-Way Single and Double Yellow Road Line Connection
    public static final Block FOUR_WAY_SINGLE_AND_DOUBLE_YELLOW_ROAD_LINE_CONNECTION = register("4_way_single_and_double_yellow_road_line_connection",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Yellow Dot Road Pattern
    public static final Block YELLOW_DOT_ROAD_PATTERN = register("yellow_dot_road_pattern",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));

    //Yellow Rectangle Road Pattern
    public static final Block YELLOW_RECTANGLE_ROAD_PATTERN = register("yellow_rectangle_road_pattern",
            new LineBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque().noCollision()));





    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Plateia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Plateia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Plateia.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        Plateia.LOGGER.debug("Registering ModBlocks for " + Plateia.MOD_ID);
        BlockRenderLayerMap.INSTANCE.putBlock(WHITE_ROAD_LINE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DOUBLE_WHITE_ROAD_LINE, RenderLayer.getCutout());
    }
}
