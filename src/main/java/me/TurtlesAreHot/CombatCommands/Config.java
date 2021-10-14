package me.TurtlesAreHot.CombatCommands;

import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
    private static FileConfiguration config;

    public static void reloadConfig() {
        config = (JavaPlugin.getPlugin(Main.class)).getConfig();
    }

    public static List<String> getCommands() {
        return config.getStringList("commands");
    }
}
