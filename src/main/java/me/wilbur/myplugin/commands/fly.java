package me.wilbur.myplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player && player.hasPermission("learningplugin.commands.fly")) {
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage("§cYou can no longer fly!");
            } else {
                player.setAllowFlight(true);
                player.sendMessage("§aYou can now fly!");
            }
        } else if (commandSender instanceof Player player && !player.hasPermission("learningplugin.commands.fly")) {
            player.sendMessage("§cYou do not have permission to use this command!");
        } else if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cYou must be a player to use this command!");
        }

        return true;
    }
}
