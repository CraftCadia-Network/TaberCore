package com.samtaber.base;

import org.bukkit.plugin.java.JavaPlugin;

public class Base extends JavaPlugin{
	
	public static Base instance;
	
	public static String serverName = "TaberGames";
	public String serverVersion = "TaberSpigot-1.0.4-SNAPSHOT developed by Sam Taber and Josh Hanson";
	public String serverType = "This network is running TaberProxy-3.4.0-RELEASE developed by Sam Taber and Josh Hanson";
	public String minigameType = null;
	public String pluginList = "This network has protected their plugins using TaberCore-ADDON_PluginProtect developed by Sam Taber";
	public String playpackVersion = "PLAYPACKcore-0.0.1-ALPHA";	
	public void onEnable() {
		
		instance = this;
		
		
	}
	
	public void onDisable() {
		
		instance = null;
		
	}

}
