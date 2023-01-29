package net.endative.plateia.item;

import net.endative.plateia.Plateia;
import net.endative.plateia.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item LINE = register("line", new AliasedBlockItem(ModBlocks.LINE,
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
