package com.johan.johansmod.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.johan.johansmod.JohansMod;

public class ModCreativeModeTabs {
    // Creating a new creative tab instance using the builder
    public static final CreativeModeTab JOHANS_TAB = new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 0)
            .icon(() -> new ItemStack(ModItems.DIAMOND_CRAFTING_HAMMER.get()))
            .title(Component.translatable("itemGroup.johans_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.DIAMOND_CRAFTING_HAMMER.get());
                output.accept(ModItems.NETHERITE_CRAFTING_HAMMER.get());
                output.accept(ModItems.IRON_CRAFTING_HAMMER.get());
            })
            .build();

    public static void register(IEventBus eventBus) {
        // No need to register the creative mode tab itself, just the items
        ModItems.register(eventBus);
    }
}
