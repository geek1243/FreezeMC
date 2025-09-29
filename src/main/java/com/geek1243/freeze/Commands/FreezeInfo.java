package com.geek1243.freeze.Commands;

import com.geek1243.freeze.main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeInfo implements CommandExecutor {
    main plugin;

    public FreezeInfo(main instance) {
        this.plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Player Only");
            return false;
        } else {
            Player player = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("sshelp") && player.hasPermission("freeze.help")) {
                player.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "--------------------------------------");
                player.sendMessage(ChatColor.AQUA + "                            Fre" + ChatColor.AQUA + "eze");
                player.sendMessage(ChatColor.GRAY + "                     Developed By: " + ChatColor.RED + "Geek1243");
                player.sendMessage(" ");
                player.sendMessage(ChatColor.RED + "/ss [player]" + ChatColor.GRAY + " - (freezes a player)");
                player.sendMessage(ChatColor.GRAY + "    (alias) " + ChatColor.RED + "/ss [player]");
                player.sendMessage(" ");
                player.sendMessage(ChatColor.RED + "/sshelp" + ChatColor.GRAY + " - (Opens This Menu)");
                player.sendMessage(ChatColor.GRAY + "    (alias) " + ChatColor.RED + "/ssinfo");
                player.sendMessage(" ");
                player.sendMessage(ChatColor.RED + "/ssversion" + ChatColor.GRAY + " - (Shows The Version)");
                player.sendMessage(ChatColor.GRAY + "    (alias) " + ChatColor.RED + "/ssversion");
                player.sendMessage(" ");
                player.sendMessage(ChatColor.RED + "/sskick [Name] [Reason]" + ChatColor.GRAY + " - (Kicks A Player)");
                player.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "--------------------------------------");
            } else {
                player.sendMessage(ChatColor.RED + "You Do Not Have Permission To Preform This Command");
            }

            return false;
        }
    }
}
