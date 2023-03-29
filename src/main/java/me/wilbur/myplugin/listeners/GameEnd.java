package me.wilbur.myplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameEnd implements Listener {

    @EventHandler
    public void onGameEnd(me.wilbur.myplugin.events.GameEnd event) {
        Bukkit.getServer().broadcastMessage(event.getWinner().getName() + " has won the game!");
        Bukkit.getServer().broadcastMessage(event.getLoser().getName() + " has lost the game!");
    }

}
