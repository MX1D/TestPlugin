package me.wilbur.myplugin.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpawnerBreak extends Event {

    private static final HandlerList handlers = new HandlerList();

    Player breaker;
    Block spawner;

    public Player getBreaker() {
        return breaker;
    }

    public Block getSpawner() {
        return spawner;
    }

    public SpawnerBreak(Player breaker, Block spawner) {
        this.breaker = breaker;
        this.spawner = spawner;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
