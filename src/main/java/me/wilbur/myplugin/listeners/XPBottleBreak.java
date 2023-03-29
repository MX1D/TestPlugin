package me.wilbur.myplugin.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreak implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e) {
        Entity entity = e.getEntity();

        entity.getWorld().createExplosion(entity.getLocation(), 0);

        e.setShowEffect(false);
    }
}
