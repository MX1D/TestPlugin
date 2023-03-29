package me.wilbur.myplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class armorstand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player player) {
            if (player.hasPermission("learningplugin.commands.armorstand")) {
                ArmorStand armorStand = player.getWorld().spawn(player.getLocation(), ArmorStand.class);

                if (args.length == 0) {
                    armorStand.setCustomName("§c§lArmor Stand");
                } else {
                    armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&', String.join(" ", args)));
                }
                armorStand.setCustomNameVisible(true);
                armorStand.setGravity(false);
                armorStand.setVisible(false);
                armorStand.setInvulnerable(true);
                armorStand.setArms(true);
                armorStand.setBasePlate(true);

                player.sendMessage("§aYou have spawned an armor stand!");
            } else {
                player.sendMessage("§cYou do not have permission to use this command!");
            }
        } else {
            commandSender.sendMessage("§cYou must be a player to use this command!");
        }

        return true;
    }
}
