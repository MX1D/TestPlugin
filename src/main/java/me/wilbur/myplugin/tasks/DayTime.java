package me.wilbur.myplugin.tasks;

import me.wilbur.myplugin.myPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class DayTime extends BukkitRunnable {

    Plugin plugin = myPlugin.getInstance();

    @Override
    public void run() {
        if (!plugin.getConfig().getBoolean("dayTime")) {
            return;
        }
        String worldName = plugin.getConfig().getString("lobbyWorld");
        if (worldName == null) {
            return;
        }
        Objects.requireNonNull(Bukkit.getWorld(worldName)).setTime(0L);
    }
}
