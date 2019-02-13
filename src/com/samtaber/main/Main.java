package com.samtaber.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.samtaber.main.addons.AddonHandler;
import com.samtaber.main.addons.Downloader;



public class Main extends JavaPlugin{

	public static Main plugin;
	
	public void onEnable() {
		plugin = this;
		AddonHandler.Setup();
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Loaded TaberCore");
		this.getCommand("download").setExecutor((CommandExecutor)new Downloader());
	}
	
	public void onDisable() {
		
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Unloading TaberCore");
		
	}
	
}
