package com.geek1243.freeze.Listeners;

import com.geek1243.freeze.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLogout implements Listener {
    main plugin;

    public onLogout(main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (this.plugin.frozen.contains(p)) {
        }

    }
}
