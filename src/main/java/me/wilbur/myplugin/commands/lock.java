package me.wilbur.myplugin.commands;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.wilbur.myplugin.utils.GUIManager.openLockGUI;

public class lock implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            Block target = player.getTargetBlockExact(10);
            if (target != null && target.getType().isInteractable()) {
                openLockGUI(player);
            } else {
                player.sendMessage("§cYou must be looking at a valid block to use this command!");
            }
        } else {
            sender.sendMessage("§cYou must be a player to use this command!");
        }

        return true;
    }
}
