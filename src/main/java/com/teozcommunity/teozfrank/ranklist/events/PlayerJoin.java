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

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(p.isOp()||p.hasPermission("ranklist.update.notify")){
           if(plugin.updateChecker.updateAvailable){
               p.sendMessage(ChatColor.GREEN+"There is an update available for "+ChatColor.AQUA+
                       "RankList,"+ChatColor.GREEN+" download it on bukkit dev.");
           }
        }
    }
}

