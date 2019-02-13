package com.samtaber.main.addons;

import org.bukkit.entity.Player;

public class AddonLoader {

	public static String addonName = null;
	public static String addon1 = null;
	public static String addon2 = null;
	public static String addon3 = null;
	public static String addon4 = null;
	public static String addon5 = null;
	public static String addon6 = null;
	public static String addon7 = null;
	public static String addon8 = null;
	public static String addon9 = null;
	public static String addon10 = null;
	
	
	public static void load(Player player) {
		
		if(LoadAddon.addonName.equalsIgnoreCase("TaberCore_RANKS")) {
			
			DirectorySearcher.DirectSearch(player);
			
			if(AddonHandler.AddonList.contains("TaberCore_RANKS")) {
				
				addon1 = "TaberCore_RANKS";
				
			}
			
			
		}
		
	}
	
}
