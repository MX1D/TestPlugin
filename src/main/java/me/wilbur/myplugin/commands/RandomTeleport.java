package me.wilbur.myplugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomTeleport implements CommandExecutor {

    private static Boolean isLocationSafe(Location location) {
        return !location.getBlock().getType().isSolid() && !location.getBlock().getRelative(0, 1, 0).getType().isSolid();
    }

    private static Location getRandomLocation(Player player) {
        Random random = new Random();

        int x = random.nextInt(10000);
        int y = 150;
        int z = random.nextInt(10000);

        Location location = new Location(player.getWorld(), x, y, z);

        int safeY = player.getWorld().getHighestBlockYAt(location);
        location.setY(safeY + 2);

        if (!isLocationSafe(location))
            return getRandomLocation(player);

        return location;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player player) {

            Location location = getRandomLocation(player);

            player.teleport(location);

            player.sendMessage("§a§lYou have been teleported to a random location!");
        } else {
            commandSender.sendMessage("§cYou must be a player to run this command!");
        }

        return true;
    }
}
