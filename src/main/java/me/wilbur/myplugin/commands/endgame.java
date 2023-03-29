package me.wilbur.myplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class endgame implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length < 2) {
            sender.sendMessage("§cYou must specify two players!");
            return true;
        } else {
            Player winner = Bukkit.getPlayer(args[0]);
            Player loser = Bukkit.getPlayer(args[1]);

            Bukkit.getServer().getPluginManager().callEvent(new me.wilbur.myplugin.events.GameEnd(winner, loser));
        }


        return true;
    }
}
