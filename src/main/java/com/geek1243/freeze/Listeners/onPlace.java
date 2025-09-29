package com.geek1243.freeze.Listeners;

import com.geek1243.freeze.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class onPlace implements Listener {
    main plugin;

    public onPlace(main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player breaker = e.getPlayer();
        if (this.plugin.frozen.contains(breaker.getName())) {
            e.setCancelled(true);
        }

    }
}
