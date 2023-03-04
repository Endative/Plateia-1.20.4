package net.endative.plateia.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AliasedLineBlockItem extends BlockItem {
    public AliasedLineBlockItem(Block block, Item.Settings settings) {
        super(block, settings);
    }

    public String getTranslationKey() {
        return this.getOrCreateTranslationKey();
    }
}
