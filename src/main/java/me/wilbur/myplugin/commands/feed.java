package me.wilbur.myplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class feed implements CommandExecutor {

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (player.hasPermission("learningplugin.commands.feed")) {
                // check if the player is in the cooldown
                if (cooldowns.containsKey(player.getUniqueId())) {
                    // check if the cooldown is over
                    if (cooldowns.get(player.getUniqueId()) + 10000 > System.currentTimeMillis()) {
                        player.sendMessage("You must wait " + ((cooldowns.get(player.getUniqueId()) + 10000) - System.currentTimeMillis()) / 1000 + " seconds before using this command again!");
                        return true;
                    }
                }
                player.setFoodLevel(20);
                player.sendMessage("You have been fed!");

                // add the player to the cooldown using the current time in milliseconds
                cooldowns.put(player.getUniqueId(), System.currentTimeMillis());
            } else {
                player.sendMessage("You do not have permission to use this command!");
            }
        } else {
            commandSender.sendMessage("You must be a player to use this command!");
        }

        return true;
    }
}
