package net.endative.plateia.item;

import net.endative.plateia.Plateia;
import net.endative.plateia.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Calcite Dust
    public static final Item CALCITE_DUST = register("calcite_dust", new AliasedBlockItem(ModBlocks.CALCITE_WIRE,
            new FabricItemSettings().group(ModItemGroup.PLATEIA)));
    public static final Item DOUBLE_CALCITE_DUST = register("double_calcite_dust", new AliasedBlockItem(ModBlocks.DOUBLE_CALCITE_WIRE,
            new FabricItemSettings().group(ModItemGroup.PLATEIA)));

    private static Item register(String id, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Plateia.MOD_ID, id),
                new BlockItem(block, new FabricItemSettings().group(group)));

    }

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Plateia.MOD_ID, id), item);
    }

    public static void registerModItems() {
        Plateia.LOGGER.debug("Registering Mod Items for " + Plateia.MOD_ID);
    }
}
