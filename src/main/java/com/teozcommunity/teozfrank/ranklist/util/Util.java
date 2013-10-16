package com.teozcommunity.teozfrank.ranklist.util;

import com.teozcommunity.teozfrank.ranklist.main.RankList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Origional Author: teozfrank
 * Date: 25/09/13
 * Time: 16:56
 * Project: RankList
 * -----------------------------
 * Removing this header is in breach of the license agreement,
 * please do not remove, move or edit it in any way.
 * -----------------------------
 */
public class Util {

    private RankList plugin;

    public Util(RankList plugin){
        this.plugin = plugin;
    }

    public void listRanks(Player sender){

        int x = 1;
        List<String> ranks = plugin.getConfig().getStringList("ranklist.ranks");

        sender.sendMessage(ChatColor.GOLD + "()---- " + ChatColorHelper.replaceColorCodes(plugin.getConfig().getString("ranklist.servername")) +
                ChatColor.GOLD + " ----()\n\n" +
                ChatColor.GOLD + "=--- These are the rank(s) on our server ---\n" +
                "=--- Listed from the least powerful to the most ---=\n");
        sender.sendMessage("");

        for(String rank: ranks){
           sender.sendMessage(ChatColor.GOLD+String.valueOf(x)+".-"+ChatColorHelper.replaceColorCodes(rank));
            x++;
        }
        sender.sendMessage("");
        sender.sendMessage(ChatColor.GOLD+"=-- RankList "+plugin.version+" for 1.6.4 available on Bukkit Dev --=");
        sender.sendMessage(ChatColor.GOLD+"==-- http://dev.bukkit.org/server-mods/rank-list/ --==");

    }

}
