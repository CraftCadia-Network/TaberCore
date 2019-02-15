package com.samtaber.base;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import com.tabercore.addon.main.commands.CommandVersion;

public class Base extends JavaPlugin{
	
	public static Base instance;
	
	public static String serverName = "TaberGames";
	public static String serverVersion = "TaberSpigot-1.0.4-SNAPSHOT developed by Sam Taber and Josh Hanson";
	public static String serverType = "This network is running TaberProxy-3.4.0-RELEASE developed by Sam Taber and Josh Hanson";
	public static String minigameType = null;
	public static String pluginList = "This network has protected their plugins using TaberCore-ADDON_PluginProtect developed by Sam Taber";
	public static String playpackVersion = "This network is running PLAYPACKcore-0.0.1-ALPHA, a system software developed by Sam Taber and Joshua Hanson alongside Lucas van Borkulo";	
	public void onEnable() {
		
		this.getCommand("version").setExecutor((CommandExecutor)new CommandVersion());
		System.out.println("loaded tabercore!");
		instance = this;
		
		
	}
	
	public void onDisable() {
		
		instance = null;
		
	}

}
