package com.samtaber.main.addons;

import java.io.File;

public class LoadAddon {
	public static String Path = "plugins/TaberCore/addons";	
	static File AddonDirectory = new File(Path);
	public static String addonName = null;
		
	
		public static void download() throws Throwable {
			
			AddonFetcher.downloadFileFromURL(addonName, AddonDirectory);	
			
		}
		

	
	
		
	
}

