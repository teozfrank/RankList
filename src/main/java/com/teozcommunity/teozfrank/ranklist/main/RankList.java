package com.teozcommunity.teozfrank.ranklist.main;

import java.io.*;
import com.teozcommunity.teozfrank.ranklist.commands.*;
import com.teozcommunity.teozfrank.MetricsLite;
import com.teozcommunity.teozfrank.ranklist.events.PlayerJoin;
import com.teozcommunity.teozfrank.ranklist.threads.UpdateCheckThread;
import com.teozcommunity.teozfrank.ranklist.util.SendConsoleMessage;
import com.teozcommunity.teozfrank.ranklist.util.UpdateChecker;
import com.teozcommunity.teozfrank.ranklist.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RankList extends JavaPlugin {

    protected String serverName;
    public String version;
    //our update checker class
    public Commands commands;

    public Util util;


    @Override
    public void onEnable(){
        this.version = this.getDescription().getVersion();
        this.util = new Util(this);
        SendConsoleMessage.info("Enabling");
        if(this.getConfig().getBoolean("ranklist.checkforupdates")){
            this.checkForUpdates();
            Bukkit.getPluginManager().registerEvents(new PlayerJoin(this),this);
        }
        if(!(new File(getDataFolder(), "config.yml")).exists())
        {
            this.saveDefaultConfig();
        }
        try {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        } catch (IOException e) {
            System.out.println("Failed to submit the stats :-("); 
        }
        getCommand("ranklist").setExecutor(new Commands(this));

        SendConsoleMessage.info("Enabled!");
    }

    public void checkForUpdates(){
        getServer().getScheduler().runTask(this, new UpdateCheckThread(this));
    }

   	
}


