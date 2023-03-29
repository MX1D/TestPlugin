package me.wilbur.myplugin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameEnd extends Event {

    private static final HandlerList handlers = new HandlerList();

    private Player winner;
    private Player loser;

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }

    public GameEnd(Player winner, Player loser) {
        this.winner = winner;
        this.loser = loser;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
