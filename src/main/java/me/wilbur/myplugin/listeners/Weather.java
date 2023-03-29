package me.wilbur.myplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Weather implements Listener {

    @EventHandler
    public void onWeatherChange(org.bukkit.event.weather.WeatherChangeEvent event) {
        if (event.toWeatherState()) {
            event.setCancelled(true);
        }
    }

}
