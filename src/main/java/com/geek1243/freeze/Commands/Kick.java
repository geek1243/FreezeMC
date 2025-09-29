package com.geek1243.freeze.Commands;

import com.geek1243.freeze.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {
    main plugin;

    public Kick(main instance) {
        this.plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player)sender;
        if (label.equalsIgnoreCase("sskick")) {
            if (p.hasPermission("freeze.kick")) {
                if (args.length >= 2) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        String message = "";

                        for(int i = 1; i < args.length; ++i) {
                            message = message + args[i] + " ";
                        }

                        p.sendMessage("§4[§bFreeze§4] §aYou have kicked the Player!");
                        target.kickPlayer("§4[§bFreeze§4]\n§6You were kicked!\n§cReason: " + message);
                    } else {
                        p.sendMessage("§4[§bFreeze§4] §7This player is not Online!");
                    }
                } else {
                    p.sendMessage("§4[§bFreeze§4] §7Please uses §6/sskick §a<Player> §c<Reason>");
                }
            } else {
                p.sendMessage("§4[§bFreeze§4] §cYou don`t have Permissions for this command!");
            }
        }

        return true;
    }
}

