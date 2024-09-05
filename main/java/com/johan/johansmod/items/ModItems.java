package com.johan.johansmod.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.johan.johansmod.JohansMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JohansMod.MODID);

    public static final RegistryObject<Item> DIAMOND_CRAFTING_HAMMER = ITEMS.register("diamond_crafting_hammer",
            () -> new DiamondHammerItem(new Item.Properties().stacksTo(1).durability(750)));
    public static final RegistryObject<Item> NETHERITE_CRAFTING_HAMMER = ITEMS.register("netherite_crafting_hammer",
            () -> new NetheriteHammerItem(new Item.Properties().stacksTo(1).durability(2000)));
    public static final RegistryObject<Item> IRON_CRAFTING_HAMMER = ITEMS.register("iron_crafting_hammer",
            () -> new IronHammerItem(new Item.Properties().stacksTo(1).durability(250)));

    public static final RegistryObject<Item> WOODEN_TONGS = ITEMS.register("wooden_tongs",
            () -> new WoodenTongsItem(new Item.Properties().stacksTo(1).durability(100)));
    public static final RegistryObject<Item> IRON_TONGS = ITEMS.register("iron_tongs",
            () -> new IronTongsItem(new Item.Properties().stacksTo(1).durability(500))); // Updated durability to 500

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}



