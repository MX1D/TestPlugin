package me.wilbur.myplugin.commands;

import me.wilbur.myplugin.myPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class configMessage implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (player.hasPermission("learningplugin.commands.configMessage")) {
                if (args.length == 0) {
                    String message = myPlugin.getInstance().getConfig().getString("config-message");
                    assert message != null;
                    player.sendMessage(message);
                } else if (args[0].equalsIgnoreCase("set")) {
                    if (args[1].isEmpty()) {
                        player.sendMessage("You must specify a message!");
                    } else {
                        myPlugin.getInstance().getConfig().set("config-message", args[1]);
                        myPlugin.getInstance().saveConfig();
                        player.sendMessage("Config message set to " + args[1]);
                    }
                }

            } else {
                player.sendMessage("You do not have permission to use this command!");
            }
        } else {
            sender.sendMessage("You must be a player to use this command!");
        }
        return true;
    }
}
