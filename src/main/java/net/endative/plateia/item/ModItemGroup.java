package net.endative.plateia.item;

import net.endative.plateia.Plateia;
import net.endative.plateia.block.ModBlocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup PLATEIA = FabricItemGroupBuilder.build(new Identifier(Plateia.MOD_ID, "plateia"),
            () -> new ItemStack(ModBlocks.SEARSTONE));
}
