package com.johan.johansmod;

import com.johan.johansmod.items.DiamondHammerItem;
import com.johan.johansmod.items.IronHammerItem;
import com.johan.johansmod.items.NetheriteHammerItem;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JohansMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CraftingEventHandler {

    @SubscribeEvent
    public static void onItemCrafted(ItemCraftedEvent event) {
        Player player = event.getEntity();
        if (player != null && !player.getCommandSenderWorld().isClientSide) {
            ItemStack offhandItem = player.getOffhandItem();
            boolean hasHammerInOffhand = offhandItem.getItem() instanceof IronHammerItem ||
                    offhandItem.getItem() instanceof DiamondHammerItem ||
                    offhandItem.getItem() instanceof NetheriteHammerItem;

            if (hasHammerInOffhand) {
                // Reduce hammer durability
                offhandItem.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
            } else {
                // Add exhaustion to the player
                float exhaustion = getEnergyCost(player.getCommandSenderWorld().getDifficulty());
                player.getFoodData().addExhaustion(exhaustion);
            }
        }
    }

    private static float getEnergyCost(Difficulty difficulty) {
        switch (difficulty) {
            case HARD:
                return 4.0F; // Hard
            case NORMAL:
                return 2.0F; // Normal (half of Hard)
            case EASY:
                return 1.0F; // Easy (half of Normal)
            case PEACEFUL:
                return 0.0F; // No cost on Peaceful
            default:
                return 2.0F; // Default cost if no other difficulty fits
        }
    }
}









