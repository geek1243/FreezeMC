package com.geek1243.freeze.Listeners;

import com.geek1243.freeze.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onMove implements Listener {
    main plugin;

    public onMove(main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onPlayerDrop(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (this.plugin.frozen.contains(p.getName())) {
            e.setTo(e.getFrom());
        }

    }
}
