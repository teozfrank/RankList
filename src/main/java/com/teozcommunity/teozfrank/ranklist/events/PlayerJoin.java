package com.teozcommunity.teozfrank.ranklist.events;

import com.teozcommunity.teozfrank.ranklist.main.RankList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Frank
 * Date: 18/08/13
 * Time: 00:11
 * To change this template use File | Settings | File Templates.
 */
public class PlayerJoin implements Listener {
    private RankList plugin;

    public PlayerJoin(RankList plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.isOp()||p.hasPermission("ranklist.update.notify")){
            if(plugin.updateChecker.updateAvailable()){
                e.setJoinMessage(ChatColor.GOLD+"[RankList] "+ChatColor.GREEN+"has an update!\n"+
                ChatColor.GOLD+"Your version: "+ChatColor.GREEN+plugin.version+"\n"+
                ChatColor.GOLD+"Latest version: "+ChatColor.GREEN+plugin.updateChecker.getVersion()+"\n"+
                ChatColor.GOLD+"Download: "+ChatColor.GREEN+plugin.updateChecker.getLink());
            }
        }

    }
}

