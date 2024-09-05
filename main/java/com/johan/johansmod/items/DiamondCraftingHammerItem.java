package com.johan.johansmod.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DiamondCraftingHammerItem extends Item {
    public DiamondCraftingHammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true; // Gör så att föremålet ser förtrollat ut (foil)
    }
}
