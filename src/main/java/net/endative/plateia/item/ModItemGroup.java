package net.endative.plateia.item;

import net.endative.plateia.Plateia;
import net.endative.plateia.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup PLATEIA = Registry.register(Registries.ITEM_GROUP, new Identifier(Plateia.MOD_ID, "plateia"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemGroup.plateia.plateia"))
                    .icon(() -> new ItemStack(ModBlocks.SEARSTONE)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.SMOOTH_DARK_PRISMARINE);
                        entries.add(ModBlocks.SMOOTH_DARK_PRISMARINE_STAIRS);
                        entries.add(ModBlocks.SMOOTH_DARK_PRISMARINE_SLAB);
                        entries.add(ModBlocks.SEARSTONE);
                        entries.add(ModBlocks.POLISHED_SEARSTONE);
                        entries.add(ModBlocks.SEARSTONE_WALL);
                        entries.add(ModBlocks.POLISHED_SEARSTONE_WALL);
                        entries.add(ModBlocks.SEARSTONE_STAIRS);
                        entries.add(ModBlocks.POLISHED_SEARSTONE_STAIRS);
                        entries.add(ModBlocks.SEARSTONE_SLAB);
                        entries.add(ModBlocks.POLISHED_SEARSTONE_SLAB);
                        
                        entries.add(ModBlocks.WHITE_ROAD_LINE);
                        entries.add(ModBlocks.OFF_CENTRED_WHITE_ROAD_LINE);
                        entries.add(ModBlocks.DOUBLE_WHITE_ROAD_LINE);
                        entries.add(ModBlocks.WHITE_CORNER_ROAD_LINE);
                        entries.add(ModBlocks.DOUBLE_WHITE_CORNER_ROAD_LINE);
                        entries.add(ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.THREE_WAY_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.HOLLOW_THREE_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.FOUR_WAY_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_WHITE_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.WHITE_DOT_ROAD_PATTERN);
                        entries.add(ModBlocks.WHITE_RECTANGLE_ROAD_PATTERN);
                        entries.add(ModBlocks.FOUR_WAY_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.FOUR_WAY_SINGLE_AND_DOUBLE_WHITE_AND_YELLOW_ROAD_LINE_CONNECTION);
                        
                        entries.add(ModBlocks.YELLOW_ROAD_LINE);
                        entries.add(ModBlocks.OFF_CENTRED_YELLOW_ROAD_LINE);
                        entries.add(ModBlocks.DOUBLE_YELLOW_ROAD_LINE);
                        entries.add(ModBlocks.YELLOW_CORNER_ROAD_LINE);
                        entries.add(ModBlocks.DOUBLE_YELLOW_CORNER_ROAD_LINE);
                        entries.add(ModBlocks.TWO_WAY_SINGLE_TO_DOUBLE_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.THREE_WAY_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.HOLLOW_THREE_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.THREE_WAY_SINGLE_THROUGH_DOUBLE_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.THREE_WAY_DOUBLE_THROUGH_SINGLE_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.FOUR_WAY_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.HOLLOW_FOUR_WAY_DOUBLE_YELLOW_ROAD_LINE_CONNECTION);
                        entries.add(ModBlocks.YELLOW_DOT_ROAD_PATTERN);
                        entries.add(ModBlocks.YELLOW_RECTANGLE_ROAD_PATTERN);
                    }).build());

    public static void registerItemGroups() {
    }

}
