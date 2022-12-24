package net.endative.plateia.block;

import net.endative.plateia.Plateia;
import net.endative.plateia.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    //Dark Prismarine
    public static final Block DARK_PRISMARINE = registerBlock("dark_prismarine",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Searstone
    public static final Block SEARSTONE = registerBlock("searstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Raw Searstone
    public static final Block RAW_SEARSTONE = registerBlock("raw_searstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Stone Tiles
    public static final Block STONE_TILES = registerBlock("stone_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Smooth Stone Tiles
    public static final Block SMOOTH_STONE_TILES = registerBlock("smooth_stone_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Granite Tiles
    public static final Block GRANITE_TILES = registerBlock("granite_tiles",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.5f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Calcite Dust
    public static final Block CALCITE_WIRE = register("calcite_wire",
            new RedstoneWireBlock(FabricBlockSettings.of(Material.STONE).strength(0f).sounds(BlockSoundGroup.STONE)));

    //Warped Wart Carpet
    public static final Block WARPED_WART_CARPET = registerBlock("warped_wart_carpet",
            new CarpetBlock(FabricBlockSettings.of(Material.MOSS_BLOCK).strength(0.1f).sounds(BlockSoundGroup.WART_BLOCK)), ModItemGroup.PLATEIA);

    //Nether Wart Carpet
    public static final Block NETHER_WART_CARPET = registerBlock("nether_wart_carpet",
            new CarpetBlock(FabricBlockSettings.of(Material.MOSS_BLOCK).strength(0.1f).sounds(BlockSoundGroup.WART_BLOCK)), ModItemGroup.PLATEIA);






    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Plateia.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Plateia.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Plateia.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        Plateia.LOGGER.debug("Registering ModBlocks for " + Plateia.MOD_ID);
    }

}
