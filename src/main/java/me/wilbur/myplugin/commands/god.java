package me.wilbur.myplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class god implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPermission("learningplugin.commands.god")) {
                if (player.isInvulnerable()) {
                    player.setInvulnerable(false);
                    player.sendMessage("§cYou are no longer invulnerable!");
                } else {
                    player.setInvulnerable(true);
                    player.sendMessage("§aYou are now invulnerable!");
                }
                return true;
            }
        } else {
            sender.sendMessage("You must be a player to use this command!");
        }
        return false;
    }

}
