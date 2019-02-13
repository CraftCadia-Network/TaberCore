package com.samtaber.main.addons;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoadAddon implements CommandExecutor{
	public static String Path = "plugins/TaberCore";	
	static File AddonDirectory = new File(Path + "/addons");
	public static String addonName = null;
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(player.hasPermission("tabercore.load")) {
			
			if(label.equalsIgnoreCase("loadaddon")) {
				
				if(args.length == 0) {
					
					player.sendMessage(ChatColor.RED + "Missing ADDON_NAME");
					
				}else if(args.length == 1) {
					
					addonName = args[0];
					AddonLoader.load(player);
					
				}
				
			}
			
		}
		
		return false;
	}
		
	
			
			
			
	

	
	
		
	
}

