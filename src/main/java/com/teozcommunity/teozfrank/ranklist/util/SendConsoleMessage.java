package com.teozcommunity.teozfrank.ranklist.util;


import com.teozcommunity.teozfrank.ranklist.main.RankList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;


/**
 * Created with IntelliJ IDEA.
 * User: Frank
 * Date: 07/07/13
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class SendConsoleMessage {


    private RankList plugin;
    private ConsoleCommandSender _cs;
    private static final String prefix = ChatColor.GREEN + "[RankList] ";
    private static final String info = "[Info] ";
    private static final String severe = ChatColor.YELLOW + "[Severe] ";
    private static final String warning = ChatColor.RED + "[Warning] ";
    private static final String debug = ChatColor.AQUA + "[Debug] ";


    public SendConsoleMessage(RankList plugin){
        this.plugin = plugin;
        _cs = plugin.getServer().getConsoleSender();
    }

    public static void info(String message){
        Bukkit.getConsoleSender().sendMessage(prefix + info + message);
    }

    public void severe(String message){
        Bukkit.getConsoleSender().sendMessage(prefix + severe + message);
    }

    public void warning(String message){
        Bukkit.getConsoleSender().sendMessage(prefix + warning + message);
    }

    public void debug(String message){
        Bukkit.getConsoleSender().sendMessage(prefix + debug + message);
    }

}
