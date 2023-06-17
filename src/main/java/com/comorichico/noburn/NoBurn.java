package com.comorichico.noburn;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoBurn extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
        if(null != event.getIgnitingBlock()){
            if(event.getIgnitingBlock().getType() == Material.FIRE){
                event.setCancelled(true);
                event.getIgnitingBlock().setType(Material.AIR);
            }
        }
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        if(null != event.getIgnitingBlock()){
            event.setCancelled(true);
            event.getIgnitingBlock().setType(Material.AIR);
        }
    }
}
