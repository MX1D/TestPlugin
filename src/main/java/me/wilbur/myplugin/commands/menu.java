package me.wilbur.myplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class menu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            Inventory inventory = Bukkit.createInventory(player, 9, "Menu");

            ItemStack suicide = new ItemStack(Material.REDSTONE_BLOCK);
            ItemMeta suicideMeta = suicide.getItemMeta();

            assert suicideMeta != null;
            suicideMeta.setDisplayName("§c§lSuicide");
            suicideMeta.setLore(List.of("", "§7§oKills the player character."));
            suicide.setItemMeta(suicideMeta);

            ItemStack feed = new ItemStack(Material.BREAD);
            ItemMeta feedMeta = feed.getItemMeta();

            assert feedMeta != null;
            feedMeta.setDisplayName("§a§lFeed");
            feedMeta.setLore(List.of("", "§7§oRegenerate the player's food level."));
            feed.setItemMeta(feedMeta);

            ItemStack heal = new ItemStack(Material.REDSTONE);
            ItemMeta healMeta = heal.getItemMeta();

            assert healMeta != null;
            healMeta.setDisplayName("§b§lHeal");
            healMeta.setLore(List.of("", "§7§oRegenerate the player's health to full."));
            heal.setItemMeta(healMeta);

            inventory.setItem(0, suicide);
            inventory.setItem(4, feed);
            inventory.setItem(8, heal);

            player.openInventory(inventory);
        }
        return true;
    }
}
