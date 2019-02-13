package com.samtaber.main.addons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class DirectorySearcher {


	  private String fileNameToSearch;
	  private List<String> result = new ArrayList<String>();
		
	  public String getFileNameToSearch() {
		return fileNameToSearch;
	  }

	  public void setFileNameToSearch(String fileNameToSearch) {
		this.fileNameToSearch = fileNameToSearch;
	  }

	  public List<String> getResult() {
		return result;
	  }

	  public static void DirectSearch(Player player) {
		 
		  DirectorySearcher fileSearch = new DirectorySearcher();

		  if(LoadAddon.addonName.equalsIgnoreCase("TaberCore_RANKS")) {
			  
			  fileSearch.searchDirectory(new File("D:\\CadiaHQ\\Test Server\\plugins\\TaberCore\\addons"), "TaberCore_RANKS.jar");
			  int count = fileSearch.getResult().size();
				if(count ==0){
				    System.out.println("\nNo result found!");
				    player.sendMessage("Unable to find the addon. Try checking the folder!");
				}else{
				    System.out.println("\nFound " + count + " result!\n");
				    AddonHandler.AddonList.add("TaberCore_RANKS");
				}
			  }
		  
	  }
	  
	  public static void main(String[] args) {

		
	  }
	        //try different directory and filename :)
		

		

	  public void searchDirectory(File directory, String fileNameToSearch) {

		setFileNameToSearch(fileNameToSearch);

		if (directory.isDirectory()) {
		    search(directory);
		} else {
		    System.out.println(directory.getAbsoluteFile() + " is not a directory!");
		}

	  }

	  private void search(File file) {

		if (file.isDirectory()) {
		  System.out.println("Searching directory ... " + file.getAbsoluteFile());
			
	            //do you have permission to read this directory?	
		    if (file.canRead()) {
			for (File temp : file.listFiles()) {
			    if (temp.isDirectory()) {
				search(temp);
			    } else {
				if (getFileNameToSearch().equals(temp.getName().toLowerCase())) {			
				    result.add(temp.getAbsoluteFile().toString());
			    }

			}
		    }

		 } else {
			System.out.println(file.getAbsoluteFile() + "Permission Denied");
		 }
	      }

	  }

	
}
