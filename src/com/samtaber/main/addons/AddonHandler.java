package com.samtaber.main.addons;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class AddonHandler{
static String Path = "plugins/TaberCore";

URL file;
File dest = new File("plugins/TaberCore/addons");


public static final List<String> AddonList = new ArrayList<String>();


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

	public static void enableAddon() {
		

		if(AddonList.contains("TaberCore_RANKS")) {
			
			
			
		}
		
	}
	

}