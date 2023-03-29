package me.wilbur.myplugin;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import me.wilbur.myplugin.commands.*;
import me.wilbur.myplugin.enchantments.Glow;
import me.wilbur.myplugin.listeners.JoinLeave;
import me.wilbur.myplugin.listeners.MenuClick;
import me.wilbur.myplugin.listeners.XPBottleBreak;
import me.wilbur.myplugin.tasks.DayTime;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.lang.reflect.Field;
import java.util.Objects;

public final class myPlugin extends JavaPlugin {
    private static myPlugin instance;
    private static Economy economy = null;
    public static myPlugin getInstance() {
        return instance;
    }

    private static MongoClient mongoClient;

    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(Objects.requireNonNull(getInstance().getConfig().getString("mongodb")));
        }
        return mongoClient;
    }

    @Override
    public void onEnable() {
        instance = this;

        if (!setupEconomy() ) {
            System.out.println(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getServer().getPluginManager().registerEvents(new XPBottleBreak(), this);
        getServer().getPluginManager().registerEvents(new JoinLeave(), this);
        getServer().getPluginManager().registerEvents(new MenuClick(), this);
        getServer().getPluginManager().registerEvents(new me.wilbur.myplugin.listeners.tpbow(), this);
        getServer().getPluginManager().registerEvents(new me.wilbur.myplugin.listeners.GameEnd(), this);
        getServer().getPluginManager().registerEvents(new me.wilbur.myplugin.listeners.BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new me.wilbur.myplugin.listeners.SpawnerBreak(), this);
        getServer().getPluginManager().registerEvents(new me.wilbur.myplugin.listeners.Weather(), this);
        getServer().getPluginManager().registerEvents(new me.wilbur.myplugin.listeners.EntityHitByEntity(), this);

        Objects.requireNonNull(getCommand("god")).setExecutor(new god());
        Objects.requireNonNull(getCommand("configMessage")).setExecutor(new configMessage());
        Objects.requireNonNull(getCommand("menu")).setExecutor(new menu());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new feed());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new fly());
        Objects.requireNonNull(getCommand("TPBow")).setExecutor(new tpbow());
        Objects.requireNonNull(getCommand("armorstand")).setExecutor(new armorstand());
        Objects.requireNonNull(getCommand("randomteleport")).setExecutor(new RandomTeleport());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new vanish());
        Objects.requireNonNull(getCommand("endgame")).setExecutor(new endgame());
        Objects.requireNonNull(getCommand("balance")).setExecutor(new balance());
        Objects.requireNonNull(getCommand("lock")).setExecutor(new lock());

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        BukkitTask dayTime = new DayTime().runTaskTimer(this, 0L, 20L);

        registerEnchantment(new Glow("glow"));
    }

    private boolean setupEconomy()  {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            // It's been registered!
            System.out.println("Enchantment registered!");
        }
    }
}
