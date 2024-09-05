package com.johan.johansmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(modid = JohansMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Config {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Configuration code here
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // Common setup code here
    }
}