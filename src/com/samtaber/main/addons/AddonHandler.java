package com.samtaber.main.addons;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddonHandler implements CommandExecutor{
static String Path = "plugins/TaberCore";
	
	public static void Setup() {	
		File MainDirectory = new File(Path);
		if(!MainDirectory.exists()) {
			MainDirectory.mkdir();	
		}
		File AddonDir = new File(Path + "/addons");
		if(!AddonDir.exists()) {
			
			AddonDir.mkdir();
			
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(sender.hasPermission("core.addon.load")) {
		if(label.equalsIgnoreCase("loadaddon")) {
			
				if(args.length == 0) {
					player.sendMessage(ChatColor.RED + "Requires ADDON_NAME");					
				}else if(args.length == 1) {
					LoadAddon.addonName = args[0];
					try {
						LoadAddon.download();
					} catch (Throwable e) {
						
						player.sendMessage(ChatColor.RED + "Unable to fetch data from deployment server.");
					}
					
				}
				
			
			
		}
		}
		return false;
	}
}