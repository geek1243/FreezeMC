package com.geek1243.freeze.Listeners;

import com.geek1243.freeze.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class onDrop implements Listener {
    main plugin;

    public onDrop(main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (this.plugin.frozen.contains(p.getName())) {
            e.setCancelled(true);
        }

    }
}
