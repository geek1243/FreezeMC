package com.geek1243.freeze.Listeners;

import com.geek1243.freeze.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class onBreak implements Listener {
    main plugin;

    public onBreak(main instance) {
        this.plugin = instance;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player breaker = e.getPlayer();
        if (this.plugin.frozen.contains(breaker.getName())) {
            e.setCancelled(true);
        }

    }
}
