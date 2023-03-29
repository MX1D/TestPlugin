package me.wilbur.myplugin.listeners;

import me.wilbur.myplugin.enchantments.Glow;
import me.wilbur.myplugin.myPlugin;
import me.wilbur.myplugin.commands.vanish;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class JoinLeave implements Listener {

    Plugin plugin = myPlugin.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.AQUA + "Welcome to the server, " + ChatColor.DARK_RED + e.getPlayer().getName() + ChatColor.AQUA + "!");

        new vanish().vanishedPlayers.forEach(player -> e.getPlayer().hidePlayer(myPlugin.getInstance(), e.getPlayer()));

        if (plugin.getConfig().getBoolean("motd.enabled")) {
            for (String message : plugin.getConfig().getStringList("motd.message")) {
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
            }
        }

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.AQUA + "Sword of the Gods");
        swordMeta.addEnchant(new Glow("glow"), 1, true);
        ArrayList<String> swordLore = new ArrayList<>();
        swordLore.add(ChatColor.DARK_RED + "This sword is very powerful!");
        swordLore.add(ChatColor.DARK_RED + "Enchantment: " + ChatColor.AQUA + "Glow");
        swordMeta.setLore(swordLore);
        sword.setItemMeta(swordMeta);
        e.getPlayer().getInventory().addItem(sword);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.AQUA + "Goodbye, " + ChatColor.DARK_RED + e.getPlayer().getName() + ChatColor.AQUA + "!");
    }
}
