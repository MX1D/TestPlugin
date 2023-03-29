package me.wilbur.myplugin.commands;

import me.wilbur.myplugin.myPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class vanish implements CommandExecutor {
    public ArrayList<Player> vanishedPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {
            if (!player.hasPermission("LearningPlugin.commands.vanish")) player.sendMessage("§cYou don't have permissions to run this command!");

            if (vanishedPlayers.contains(player)) {
                vanishedPlayers.remove(player);
                player.sendMessage("§cYou are no longer vanished!");
                for (Player p : vanishedPlayers) p.showPlayer(myPlugin.getInstance(), player);
            } else {
                vanishedPlayers.add(player);
                player.sendMessage("§aYou are now vanished!");
                for (Player p : vanishedPlayers) p.hidePlayer(myPlugin.getInstance(), player);
            }
        } else {
            commandSender.sendMessage("§cYou must be a player to use this command!");
        }

        return true;
    }
}
