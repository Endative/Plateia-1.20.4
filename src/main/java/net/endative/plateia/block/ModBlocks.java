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
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    //Smooth Dark Prismarine
    public static final Block SMOOTH_DARK_PRISMARINE = registerBlock("smooth_dark_prismarine",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Smooth Dark Prismarine Stairs
    public static final Block SMOOTH_DARK_PRISMARINE_STAIRS = registerBlock("smooth_dark_prismarine_stairs",
            new StairsBlock(ModBlocks.SMOOTH_DARK_PRISMARINE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Smooth Dark Prismarine Slab
    public static final Block SMOOTH_DARK_PRISMARINE_SLAB = registerBlock("smooth_dark_prismarine_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Searstone
    public static final Block SEARSTONE = registerBlock("searstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1.8f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Polished Searstone
    public static final Block POLISHED_SEARSTONE = registerBlock("polished_searstone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Searstone Wall
    public static final Block SEARSTONE_WALL = registerBlock("searstone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Polished Searstone Wall
    public static final Block POLISHED_SEARSTONE_WALL = registerBlock("polished_searstone_wall",
            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Searstone Stairs
    public static final Block SEARSTONE_STAIRS = registerBlock("searstone_stairs",
            new StairsBlock(ModBlocks.SEARSTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(1.8f).requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Polished Searstone Stairs
    public static final Block POLISHED_SEARSTONE_STAIRS = registerBlock("polished_searstone_stairs",
            new StairsBlock(ModBlocks.POLISHED_SEARSTONE.getDefaultState(),
                    FabricBlockSettings.of(Material.STONE).strength(2f)
                            .requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Searstone Slab
    public static final Block SEARSTONE_SLAB = registerBlock("searstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Polished Searstone Slab
    public static final Block POLISHED_SEARSTONE_SLAB = registerBlock("polished_searstone_slab",
            new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(2f)
                    .requiresTool().sounds(BlockSoundGroup.STONE)), ModItemGroup.PLATEIA);

    //Single Line
    public static final Block LINE = register("line",
            new LineBlock(FabricBlockSettings.of(Material.METAL).strength(0f).sounds(BlockSoundGroup.METAL).nonOpaque()));



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
        BlockRenderLayerMap.INSTANCE.putBlock(LINE, RenderLayer.getCutout());
    }
}
