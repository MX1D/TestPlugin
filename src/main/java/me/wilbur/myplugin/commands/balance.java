package me.wilbur.myplugin.commands;

import me.wilbur.myplugin.myPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class balance implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {

            player.sendMessage(String.format("§aYour balance is: §6" + myPlugin.getEconomy().format(myPlugin.getEconomy().getBalance(player)) + "§a!"));
        } else {
            sender.sendMessage("§cYou must be a player to use this command!");
        }
        return true;
    }
}
