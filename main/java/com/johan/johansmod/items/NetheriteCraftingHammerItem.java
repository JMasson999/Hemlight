package com.johan.johansmod.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class NetheriteCraftingHammerItem extends Item {
    public NetheriteCraftingHammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true; // Makes the item appear enchanted (foil)
    }
}
