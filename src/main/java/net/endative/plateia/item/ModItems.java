package net.endative.plateia.item;

import net.endative.plateia.Plateia;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //Add items here

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Plateia.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Plateia.LOGGER.debug("Registering Mod Items for " + Plateia.MOD_ID);
    }
}
