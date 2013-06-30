package com.teozcommunity.teozfrank;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Commands extends JavaPlugin implements CommandExecutor {
	
	private final RankList plugin;
	String[] ranks = new String[20];
	
	public Commands(RankList instance) {
        this.plugin = instance;
    }
	
	   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String args[])
	    {
	        	if(args.length<1&&sender instanceof Player){
	        		sender.sendMessage("--------------------------------------");
	        		sender.sendMessage("\247f----"+ChatColorHelper.replaceColorCodes(plugin.getConfig().getString("ranklist.servername"))+"\247f----\n"
	        						+"\247a=---These are the rank(s) on our server---=\n"
	            					+"\247a=---Listed from the least powerful to the most---=\n");
	        		sender.sendMessage("");
	            
	            
	        		for(int x=1;x<=ranks.length;x++){
	        			if(plugin.getConfig().contains("ranklist.rank"+x))
	        			{
		            	sender.sendMessage(x+".- "+ChatColorHelper.replaceColorCodes(plugin.getConfig().getString("ranklist.rank"+x)));
	        			}	
	        		}
	            
	        		sender.sendMessage("");
	        		sender.sendMessage("--------------------------------------");
	            
	        		sender.sendMessage("--------------------------------------");
	        		sender.sendMessage("\247b=--RankList 0.5.1 for 1.5.2 available on bukkit Dev--=");
	        		sender.sendMessage("\247b==--http://dev.bukkit.org/server-mods/rank-list/--==");
	            
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
