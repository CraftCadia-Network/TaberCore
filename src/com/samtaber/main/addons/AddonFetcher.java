package com.samtaber.main.addons;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class AddonFetcher {
	
	
	
	public static void downloadFileFromURL(String addonName, File destination) throws Throwable {
		 
		URL website = new URL("http:/cadia.us.to/job/" + addonName + "/lastSuccessfulBuild/artifact/target/" + addonName + ".jar");
	      try(
	              ReadableByteChannel rbc = Channels.newChannel(website.openStream());
	              FileOutputStream fos = new FileOutputStream(destination);  
	              ){
	          fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
	      }

	  }
	
}
