package com.samtaber.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.samtaber.main.addons.AddonHandler;
import com.samtaber.main.addons.AddonLoader;
import com.samtaber.main.addons.Downloader;
import com.samtaber.main.addons.LoadAddon;
import com.tabercore.main.AddonImplementation;
import com.tabercore.ranks.HelloCommand;

public class Main extends JavaPlugin{

	public static String addon1_DATA = null;
	
	
	
	public static AddonImplementation addon1;
	public static Main plugin;
	
	public void onEnable() {
		
		plugin = this;
		AddonHandler.Setup();
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Loaded TaberCore");
		this.getCommand("download").setExecutor((CommandExecutor)new Downloader());
		this.getCommand("loadaddon").setExecutor((CommandExecutor)new LoadAddon());
		onAddon();
	}
	
	public void onAddon() {
		
		if(AddonLoader.addon1.equals("TaberCore_RANKS")) {
			
			this.getCommand("hello").setExecutor((CommandExecutor)new HelloCommand());
			
		}
		
	}
	
	public void onDisable() {
		
		Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Unloading TaberCore");
		
	}
	
}
