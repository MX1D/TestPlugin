package me.wilbur.myplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class MenuClick implements Listener {
    @EventHandler
    public void onMenuOpen(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Menu")) {
            e.setCancelled(true);

            ItemStack item = e.getCurrentItem();
            if (item != null) {
                String name = ChatColor.stripColor(Objects.requireNonNull(item.getItemMeta()).getDisplayName());
                Player player = (Player) e.getWhoClicked();
                if (name.equalsIgnoreCase("suicide")) {
                    player.setHealth(0);
                    player.sendMessage("§c§lYou have chose to suicide. You have been §4killed§c.");
                } else if (name.equalsIgnoreCase("feed")) {
                    player.setFoodLevel(20);
                    player.sendMessage("§a§lYou have chose to regenerate your food level. You have been §2fed§a.");
                } else if (name.equalsIgnoreCase("heal")) {
                    player.setHealth(20);
                    player.sendMessage("§a§lYou have chose to regenerate your health level. You have been §2healed§a.");
                }
            }
        }
    }
}
