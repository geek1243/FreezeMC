package com.geek1243.freeze.Commands;

import com.geek1243.freeze.main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Version implements CommandExecutor {
    main plugin;

    public Version(main instance) {
        this.plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("ssversion")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4running Freeze v5.0 coded by Geek1243"));
        }

        return false;
    }
}

