package com.teozcommunity.teozfrank;

import java.io.*;
import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

public class RankList extends JavaPlugin {

    Logger log;
    protected String serverName;
    
    
    
    

    public RankList()
    {
    	
    
    }

    public void onEnable()
    {
        log = getLogger();
        
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
        
    }

    public void onDisable()
    {
       
        
    }
   	
}


