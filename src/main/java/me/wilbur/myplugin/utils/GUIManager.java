package me.wilbur.myplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUIManager {

    private static Inventory lockGUI;

    public static void openLockGUI(Player player) {
        lockGUI = Bukkit.createInventory(null, 9, "§bDo you want to lock this block?");

        ItemStack yes = new ItemStack(Material.GREEN_TERRACOTTA, 1);
        ItemStack no = new ItemStack(Material.RED_TERRACOTTA, 1);
        ItemStack target = player.getTargetBlockExact(10).getState().getData().toItemStack(1);

        ItemMeta yesMeta = yes.getItemMeta();
        ItemMeta noMeta = no.getItemMeta();

        yesMeta.setDisplayName("§aYes");
        yesMeta.setLore(List.of("§7Only you are going to be able to", "§7interact with this block."));
        noMeta.setDisplayName("§cNo");
        noMeta.setLore(List.of("§7Anyone can interact with this block."));

        yes.setItemMeta(yesMeta);
        no.setItemMeta(noMeta);

        lockGUI.setItem(0, yes);
        lockGUI.setItem(8, no);
        lockGUI.setItem(4, target);

        player.openInventory(lockGUI);

        // NOTE: This isn't complete, I was working on it then just closed it.
    }

}
