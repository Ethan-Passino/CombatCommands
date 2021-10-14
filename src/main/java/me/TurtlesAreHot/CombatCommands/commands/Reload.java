package me.TurtlesAreHot.CombatCommands.commands;

import me.TurtlesAreHot.CombatCommands.Config;
import me.TurtlesAreHot.CombatCommands.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Reload implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("ccreload"))
            if (sender.hasPermission("combatcommands.reload")) {
                (JavaPlugin.getPlugin(Main.class)).reloadConfig();
                Config.reloadConfig();
                sender.sendMessage("CombatCommands has been reloaded");
            } else {
                sender.sendMessage("You do not have permission for this command.");
            }
        return false;
    }
}
