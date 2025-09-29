package com.geek1243.freeze.Listeners;

import com.geek1243.freeze.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class onCommand implements Listener {
    main plugin;

    public onCommand(main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (this.plugin.frozen.contains(p.getName()) && e.getMessage().startsWith("/")) {
            e.setCancelled(true);
        }

    }
}
