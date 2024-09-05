package com.johan.johansmod;

import com.johan.johansmod.items.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(JohansMod.MODID)
public class JohansMod {
    public static final String MODID = "johansmod";
    private static final Logger LOGGER = LogManager.getLogger();

    public JohansMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ModItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new AnvilEventHandler());
        MinecraftForge.EVENT_BUS.register(new TongsEventHandler());
        MinecraftForge.EVENT_BUS.register(new CraftingEventHandler()); // Registering the CraftingEventHandler
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Some common setup code
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Some client setup code
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Some server starting code
    }
}








