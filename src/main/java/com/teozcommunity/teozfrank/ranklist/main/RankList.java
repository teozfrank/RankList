package com.teozcommunity.teozfrank.ranklist.main;

import java.io.*;
import com.teozcommunity.teozfrank.ranklist.commands.*;
import com.teozcommunity.teozfrank.MetricsLite;
import com.teozcommunity.teozfrank.ranklist.events.PlayerJoin;
import com.teozcommunity.teozfrank.ranklist.util.SendConsoleMessage;
import com.teozcommunity.teozfrank.ranklist.util.UpdateChecker;
import com.teozcommunity.teozfrank.ranklist.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RankList extends JavaPlugin {

    protected String serverName;
    public String version;
    //our update checker class
    public UpdateChecker updateChecker;

    // console message sender class
    public SendConsoleMessage sendConsoleMessage;

    public Util util;


    @Override
    public void onEnable(){
        this.version = this.getDescription().getVersion();
        this.sendConsoleMessage = new SendConsoleMessage(this);
        this.util = new Util(this);
        this.sendConsoleMessage.info("Enabling");
        this.updateChecker = new UpdateChecker(this,"http://dev.bukkit.org/bukkit-plugins/rank-list/files.rss");
        this.checkForUpdates();
        if(!(new File(getDataFolder(), "config.yml")).exists())
        {
            saveDefaultConfig();
        }
        try {
            MetricsLite metrics = new MetricsLite(this);
            metrics.start();
        } catch (IOException e) {
            System.out.println("Failed to submit the stats :-("); 
        }
        getCommand("ranklist").setExecutor(new Commands(this));
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(this),this);
        this.sendConsoleMessage.info("Enabled!");
    }

    public void checkForUpdates(){
        if(this.updateChecker.updateAvailable()&&this.getConfig().getBoolean("ranklist.checkforupdates")){
              this.sendConsoleMessage.info("A new version of this plugin is available: " + this.updateChecker.getVersion());
              this.sendConsoleMessage.info("Download it here " + this.updateChecker.getLink());
        }
        else {
            this.sendConsoleMessage.info("You are running the latest version! :)");
        }

    }

   	
}


