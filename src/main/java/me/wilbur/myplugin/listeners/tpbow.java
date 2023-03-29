package me.wilbur.myplugin.listeners;

import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class tpbow implements Listener {

    @EventHandler
    public void onTPBowClick(org.bukkit.event.player.PlayerInteractEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() == null) return;
        if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§6Teleport Bow")) {
            if (event.getAction().equals(org.bukkit.event.block.Action.RIGHT_CLICK_AIR) || event.getAction().equals(org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK)) {
                if (event.getPlayer().getInventory().containsAtLeast(new ItemStack(org.bukkit.Material.ARROW), 1)) {
                    Projectile arrow = event.getPlayer().launchProjectile(org.bukkit.entity.Arrow.class);
                    arrow.setCustomName("§6Teleport Arrow");
                    arrow.setBounce(true);
                    arrow.setVelocity(arrow.getVelocity().multiply(2));
                    event.setCancelled(true);
                    if (!event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(org.bukkit.enchantments.Enchantment.ARROW_INFINITE)) {
                        event.getPlayer().getInventory().removeItem(new ItemStack(org.bukkit.Material.ARROW));
                    }
                } else {
                    event.getPlayer().sendMessage("§cYou do not have any arrows!");
                }
            }
        }
    }


    @EventHandler
    public void onArrowLand(org.bukkit.event.entity.ProjectileHitEvent event) {
        if (event.getEntity().getShooter() instanceof org.bukkit.entity.Player player) {
            if (event.getEntity().getCustomName() == null) return;
            if (event.getEntity().getCustomName().equals("§6Teleport Arrow")) {
                if (event.getHitBlock() != null) {
                    player.teleport(event.getHitBlock().getLocation().add(0.5, 1, 0.5).setDirection(player.getLocation().getDirection()));
                    player.playSound(player.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                }
            }
        }
    }
}
