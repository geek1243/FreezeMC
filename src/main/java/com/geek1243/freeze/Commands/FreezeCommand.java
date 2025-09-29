package com.geek1243.freeze.Commands;

import com.geek1243.freeze.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCommand implements CommandExecutor {
    main plugin;

    public FreezeCommand(main instance) {
        this.plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("ss") && p.hasPermission("freeze.ss")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &cInvalid arguments use /ss (player)"));
                return true;
            }

            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &cInvalid player &a" + args[0]));
                return true;
            }

            int i;
            if (this.plugin.frozen.contains(target.getName())) {
                this.plugin.frozen.remove(target.getName());
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &aUnfroze &6&l" + target.getName()));

                for(i = 0; i < 100; ++i) {
                    target.sendMessage("");
                }

                target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou have been found notguilty and you were unfrozen!"));
                return true;
            }

            this.plugin.frozen.add(target.getName());
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c!&7] &aFroze and sent message to &6&l" + target.getName()));

            for(i = 0; i < 100; ++i) {
                target.sendMessage("");
            }

            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l██████████"));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l█&f█&f█&f█&f█&4█&f█&f█&f█&f█&f█&4&l You Have Been Frozen!"));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l█&f█&f█&f█&4█&0█&4█&f█&f█&f█&f█"));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l█&f█&f█&4█&e█&0█&e█&4█&f█&f█&f█&6&l Do NOT logout!"));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l█&f█&4█&e█&e█&0█&e█&e█&4█&f█&f█"));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l█&4█&e█&e█&e█&e█&e█&e█&e█&4█&f█&5&l 5 Minutes To Join Our Discord!"));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l█&e█&e█&e█&e█&0█&e█&e█&e█&e█&4█"));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l█&4█&4█&4█&4█&4█&4█&4█&4█&4█&4█"));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l██████████&b&l " + this.plugin.getConfig().getString("dc")));
        }

        return false;
    }
}
