package me.TurtlesAreHot.CombatCommands.events;

import com.SirBlobman.combatlogx.api.ICombatLogX;
import com.SirBlobman.combatlogx.api.utility.ICombatManager;
import java.util.List;
import me.TurtlesAreHot.CombatCommands.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class onCommand implements Listener {
    @EventHandler
    public void onChat(PlayerCommandPreprocessEvent event) {
        if (!event.getPlayer().hasPermission("combatcommands.bypass")) {
            ICombatLogX plugin = (ICombatLogX)Bukkit.getPluginManager().getPlugin("CombatLogX");
            ICombatManager cm = plugin.getCombatManager();
            if (cm.isInCombat(event.getPlayer())) {
                String command = event.getMessage();
                List<String> commands = Config.getCommands();
                boolean notcommand = true;
                for (int i = 0; i < commands.size(); i++) {
                    String cmd = "/" + commands.get(i);
                    if(cmd.contains(" ")) {
                        if (command.contains(cmd)) {
                            if (command.length() >= cmd.length()) {
                                if (command.substring(0, cmd.length()).equalsIgnoreCase(cmd)) {
                                    notcommand = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        if(command.contains(" ")) {
                            if(command.substring(0, command.indexOf(" ")).equalsIgnoreCase(cmd)) {
                                notcommand = false;
                                break;
                            }
                        } else {
                            if(command.equalsIgnoreCase(cmd)) {
                                notcommand = false;
                                break;
                            }
                        }
                    }
                }
                if (notcommand) {
                    event.getPlayer().sendMessage(ChatColor.RED + "You cannot use this command while in combat.");
                    event.setCancelled(true);
                }
            }
        }
    }
}
