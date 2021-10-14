package me.TurtlesAreHot.CombatCommands;

import java.util.ArrayList;
import java.util.List;
import me.TurtlesAreHot.CombatCommands.commands.Reload;
import me.TurtlesAreHot.CombatCommands.events.onCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();
        List<String> commands = new ArrayList<>();
        commands.add("help");
        commands.add("b help");
        config.addDefault("commands", commands);
        config.options().copyDefaults(true);
        saveConfig();
        Config.reloadConfig();
        getServer().getPluginManager().registerEvents((Listener)new onCommand(), this);
        getCommand("ccreload").setExecutor((CommandExecutor)new Reload());
    }

    public void onDisable() {}
}
