package me.wilbur.myplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();

        if (block.getType() == Material.SPAWNER && event.getPlayer().hasPermission("myplugin.spawnerbreak") && event.getPlayer().getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
            Bukkit.getServer().getPluginManager().callEvent(new me.wilbur.myplugin.events.SpawnerBreak(event.getPlayer(), block));
        }
    }

}
