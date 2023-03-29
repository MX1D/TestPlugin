package me.wilbur.myplugin.commands;

import me.wilbur.myplugin.utils.TPBow;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class tpbow implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("learningplugin.commands.tpbow")) {
                ItemStack bow = TPBow.createTPBow();
                player.getInventory().addItem(bow);
                 if (!player.getInventory().containsAtLeast(new ItemStack(org.bukkit.Material.ARROW), 1)) {
                    player.getInventory().addItem(new ItemStack(org.bukkit.Material.ARROW));
                }
                player.sendMessage("§aYou have been given a TP Bow!");
            } else {
                player.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }
        } else {
            commandSender.sendMessage("§cYou must be a player to use this command!");
            return true;
        }

        return true;
    }
}
