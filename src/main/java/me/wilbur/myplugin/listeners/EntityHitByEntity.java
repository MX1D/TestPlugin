package me.wilbur.myplugin.listeners;

import me.wilbur.myplugin.enchantments.Glow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityHitByEntity implements Listener {
    @EventHandler
    public void onEntityHitByEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player p) {
            assert p.getInventory().getItemInMainHand().getItemMeta() != null;
            if (p.getInventory().getItemInMainHand().getItemMeta().hasEnchant(new Glow("glow"))) {
                e.getEntity().setGlowing(true);
            }
        }
    }
}
