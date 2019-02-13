package com.samtaber.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.samtaber.main.addons.AddonHandler;

public class Main extends JavaPlugin{

	public void onEnable() {
		
		AddonHandler.Setup();
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Loaded TaberCore");
	}
	
	public void onDisable() {
		
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Unloading TaberCore");
		
	}
	
}
