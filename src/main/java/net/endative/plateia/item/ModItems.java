package net.endative.plateia.item;

import net.endative.plateia.Plateia;
import net.endative.plateia.block.ModBlocks;
import net.endative.plateia.item.custom.AliasedLineBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item WHITE_ROAD_LINE = register("white_road_line", new AliasedLineBlockItem(ModBlocks.WHITE_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item OFF_CENTRED_WHITE_ROAD_LINE = register("off_centred_white_road_line", new AliasedLineBlockItem(ModBlocks.OFF_CENTRED_WHITE_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item DOUBLE_WHITE_ROAD_LINE = register("double_white_road_line", new AliasedLineBlockItem(ModBlocks.DOUBLE_WHITE_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item WHITE_CORNER_ROAD_LINE = register("white_corner_road_line", new AliasedLineBlockItem(ModBlocks.WHITE_CORNER_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item DOUBLE_WHITE_CORNER_ROAD_LINE = register("double_white_corner_road_line", new AliasedLineBlockItem(ModBlocks.DOUBLE_WHITE_CORNER_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item TWO_WAY_SINGLE_TO_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("2_way_single_to_double_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item THREE_WAY_WHITE_ROAD_LINE_CONNECTION = register("3_way_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.THREE_WAY_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("3_way_double_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item HOLLOW_THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("hollow_3_way_double_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.HOLLOW_THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item THREE_WAY_SINGLE_THROUGH_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("3_way_single_through_double_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item THREE_WAY_DOUBLE_THROUGH_SINGLE_WHITE_ROAD_LINE_CONNECTION = register("3_way_double_through_single_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item FOUR_WAY_WHITE_ROAD_LINE_CONNECTION = register("4_way_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.FOUR_WAY_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("4_way_double_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item HOLLOW_FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("hollow_4_way_double_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_ROAD_LINE_CONNECTION = register("4_way_single_and_double_white_road_line_connection", new AliasedLineBlockItem(ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item WHITE_DOT_ROAD_PATTERN = register("white_dot_road_pattern", new AliasedLineBlockItem(ModBlocks.WHITE_DOT_ROAD_PATTERN,
            new FabricItemSettings()));

    public static final Item WHITE_RECTANGLE_ROAD_PATTERN = register("white_rectangle_road_pattern", new AliasedLineBlockItem(ModBlocks.WHITE_RECTANGLE_ROAD_PATTERN,
            new FabricItemSettings()));






    public static final Item YELLOW_ROAD_LINE = register("yellow_road_line",
            new AliasedLineBlockItem(ModBlocks.YELLOW_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item OFF_CENTRED_YELLOW_ROAD_LINE = register("off_centred_yellow_road_line",
            new AliasedLineBlockItem(ModBlocks.OFF_CENTRED_YELLOW_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item DOUBLE_YELLOW_ROAD_LINE = register("double_yellow_road_line",
            new AliasedLineBlockItem(ModBlocks.DOUBLE_YELLOW_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item YELLOW_CORNER_ROAD_LINE = register("yellow_corner_road_line",
            new AliasedLineBlockItem(ModBlocks.YELLOW_CORNER_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item DOUBLE_YELLOW_CORNER_ROAD_LINE =
            register("double_yellow_corner_road_line", new AliasedLineBlockItem(ModBlocks.DOUBLE_YELLOW_CORNER_ROAD_LINE,
            new FabricItemSettings()));

    public static final Item TWO_WAY_SINGLE_TO_DOUBLE_YELLOW_ROAD_LINE_CONNECTION =
            register("2_way_single_to_double_yellow_road_line_connection",
                    new AliasedLineBlockItem(ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item THREE_WAY_YELLOW_ROAD_LINE_CONNECTION =
            register("3_way_yellow_road_line_connection", new AliasedLineBlockItem(ModBlocks.THREE_WAY_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION =
            register("3_way_double_yellow_road_line_connection",
                    new AliasedLineBlockItem(ModBlocks.THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item HOLLOW_THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION =
            register("hollow_3_way_double_yellow_road_line_connection",
                    new AliasedLineBlockItem(ModBlocks.HOLLOW_THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item THREE_WAY_SINGLE_THROUGH_DOUBLE_YELLOW_ROAD_LINE_CONNECTION =
            register("3_way_single_through_double_yellow_road_line_connection",
                    new AliasedLineBlockItem(ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item THREE_WAY_DOUBLE_THROUGH_SINGLE_YELLOW_ROAD_LINE_CONNECTION =
            register("3_way_double_through_single_yellow_road_line_connection",
                    new AliasedLineBlockItem(ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item FOUR_WAY_YELLOW_ROAD_LINE_CONNECTION = register("4_way_yellow_road_line_connection",
            new AliasedLineBlockItem(ModBlocks.FOUR_WAY_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION = register("4_way_double_yellow_road_line_connection",
            new AliasedLineBlockItem(ModBlocks.FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item HOLLOW_FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION =
            register("hollow_4_way_double_yellow_road_line_connection",
                    new AliasedLineBlockItem(ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item FOUR_WAY_SINGLE_AND_DOUBLE_YELLOW_ROAD_LINE_CONNECTION =
            register("4_way_single_and_double_yellow_road_line_connection",
                    new AliasedLineBlockItem(ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item YELLOW_DOT_ROAD_PATTERN = register("yellow_dot_road_pattern",
            new AliasedLineBlockItem(ModBlocks.YELLOW_DOT_ROAD_PATTERN,
            new FabricItemSettings()));

    public static final Item YELLOW_RECTANGLE_ROAD_PATTERN = register("yellow_rectangle_road_pattern",
            new AliasedLineBlockItem(ModBlocks.YELLOW_RECTANGLE_ROAD_PATTERN,
            new FabricItemSettings()));



    public static final Item FOUR_WAY_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION =
            register("4_way_double_white_and_yellow_road_line_connection",
            new AliasedLineBlockItem(ModBlocks.FOUR_WAY_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION,
            new FabricItemSettings()));

    public static final Item FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION =
            register("4_way_single_and_double_white_and_yellow_road_line_connection",
                    new AliasedLineBlockItem(ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION,
                            new FabricItemSettings()));




    private static Item register(String id, Block block, ItemGroup group) {
        return Registry.register(Registries.ITEM, new Identifier(Plateia.MOD_ID, id),
                new BlockItem(block, new FabricItemSettings()));

    }

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Plateia.MOD_ID, id), item);
    }

    public static void registerModItems() {
        Plateia.LOGGER.debug("Registering Mod Items for " + Plateia.MOD_ID);
    }
}
