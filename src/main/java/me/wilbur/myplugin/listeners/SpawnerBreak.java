package me.wilbur.myplugin.listeners;

import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class SpawnerBreak implements Listener {

    @EventHandler
    public void onSpawnerBreak(me.wilbur.myplugin.events.SpawnerBreak event) {

        CreatureSpawner spawner = (CreatureSpawner) event.getSpawner().getState();
        EntityType mob = spawner.getSpawnedType();

        event.getBreaker().sendMessage("You broke a " + mob.name() + " spawner!");

        ItemStack spawnerItem = new ItemStack(Material.SPAWNER, 1);
        BlockStateMeta meta = (BlockStateMeta) spawnerItem.getItemMeta();
        assert meta != null;
        CreatureSpawner spawnerMeta = (CreatureSpawner) meta.getBlockState();
        spawnerMeta.setSpawnedType(mob);
        meta.setBlockState(spawnerMeta);
        spawnerItem.setItemMeta(meta);
        event.getBreaker().getInventory().addItem(spawnerItem);
    }

}
