package com.johan.johansmod;

import com.johan.johansmod.items.DiamondHammerItem;
import com.johan.johansmod.items.IronHammerItem;
import com.johan.johansmod.items.NetheriteHammerItem;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.InteractionHand;

@Mod.EventBusSubscriber(modid = JohansMod.MODID)
public class AnvilEventHandler {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        Level level = player.getCommandSenderWorld();
        ItemStack offhandItem = player.getOffhandItem();

        if (!level.isClientSide && event.getHand() == InteractionHand.MAIN_HAND) {
            if (level.getBlockState(event.getPos()).getBlock() instanceof AnvilBlock) {
                if (!(offhandItem.getItem() instanceof IronHammerItem ||
                        offhandItem.getItem() instanceof DiamondHammerItem ||
                        offhandItem.getItem() instanceof NetheriteHammerItem)) {
                    player.displayClientMessage(Component.translatable("message.johansmod.need_hammer"), true);
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        Player player = event.getEntity();
        ItemStack offhandItem = player.getOffhandItem();

        if (offhandItem.getItem() instanceof IronHammerItem ||
                offhandItem.getItem() instanceof DiamondHammerItem ||
                offhandItem.getItem() instanceof NetheriteHammerItem) {
            // Check if the item was crafted using an anvil
            if (player.containerMenu instanceof net.minecraft.world.inventory.AnvilMenu) {
                offhandItem.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
                player.level.playSound(null, player.blockPosition(), SoundEvents.ANVIL_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        }
    }
}
