package com.johan.johansmod;

import com.johan.johansmod.items.WoodenTongsItem;
import com.johan.johansmod.items.IronTongsItem;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JohansMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TongsEventHandler {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        ItemStack offhandItem = player.getOffhandItem();

        if (player.level().getBlockState(event.getPos()).getBlock() instanceof AbstractFurnaceBlock) {
            if (!(offhandItem.getItem() instanceof WoodenTongsItem || offhandItem.getItem() instanceof IronTongsItem)) {
                player.displayClientMessage(Component.translatable("message.johansmod.need_tongs"), true);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        Player player = event.getEntity();
        ItemStack offhandItem = player.getOffhandItem();

        if (offhandItem.getItem() instanceof WoodenTongsItem || offhandItem.getItem() instanceof IronTongsItem) {
            offhandItem.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(player.getUsedItemHand()));
            player.level().playSound(null, player.blockPosition(), SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }
}



