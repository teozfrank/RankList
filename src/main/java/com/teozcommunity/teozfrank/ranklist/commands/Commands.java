package com.teozcommunity.teozfrank.ranklist.commands;

import com.teozcommunity.teozfrank.ranklist.main.RankList;
import com.teozcommunity.teozfrank.ranklist.util.ChatColorHelper;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Commands extends JavaPlugin implements CommandExecutor {
	
	private RankList plugin;
	String[] ranks = new String[20];
	
	public Commands(RankList plugin) {
        this.plugin = plugin;
    }
	
	   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
	    {
	        	if(args.length<1&&sender instanceof Player){
	        		sender.sendMessage(ChatColor.GOLD+"()---- "+ ChatColorHelper.replaceColorCodes(plugin.getConfig().getString("ranklist.servername"))+
                            ChatColor.GOLD+" ----()\n\n"+
	        						ChatColor.GOLD+"=--- These are the rank(s) on our server ---\n"+
	            					"=--- Listed from the least powerful to the most ---=\n");
	        		sender.sendMessage("");
	            
	            
	        		for(int x=1;x<=ranks.length;x++){
	        			if(plugin.getConfig().contains("ranklist.rank"+x))
	        			{
		            	sender.sendMessage(ChatColor.GOLD+String.valueOf(x)+".- "+ChatColorHelper.replaceColorCodes(plugin.getConfig().getString("ranklist.rank"+x)));
	        			}	
	        		}
	            
	        		sender.sendMessage("");
	        		sender.sendMessage(ChatColor.GOLD+"=-- RankList "+plugin.version+" for 1.6.2 available on bukkit Dev --=");
	        		sender.sendMessage(ChatColor.GOLD+"==-- http://dev.bukkit.org/server-mods/rank-list/ --==");
	            
	        		return true;
	        	}
	        	
	        	if(args.length==1&&args[0].equals("reload")){
	        		if(sender.hasPermission("ranklist.reload")){
	        			plugin.reloadConfig();
	        			sender.sendMessage(ChatColor.GREEN+"[Ranklist] Config Reloaded from Disk.");
	        			return true;
	        		}
	        		
	        		else {
		        		sender.sendMessage(ChatColor.GREEN+"[Ranklist] "+ChatColor.RED+"You do not have permission to do this!");
		        		return true;
	        		}
	        	}
	        	
	        	else {
	        		sender.sendMessage(ChatColor.GREEN+"[Ranklist] "+ChatColor.RED+"Unknown Command!");
	        		return true;
	        	}
	            
		   
	        
	        
	            
	        }
	        
	        
	        
	        
	    

}
