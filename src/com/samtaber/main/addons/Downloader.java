package com.samtaber.main.addons;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Downloader
  implements CommandExecutor
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static Downloader plugin;
  @SuppressWarnings("unused")
private static final int BUFFER_SIZE = 4096;
  
  
  public static String downloadFile(String fileURL, String saveDir)
    throws IOException
  {
    String saveFilePath = "";
    URL url = new URL(fileURL);
    HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
    int responseCode = httpConn.getResponseCode();
    if (responseCode == 200)
    {
      String fileName = "";
      String disposition = httpConn.getHeaderField("Content-Disposition");
      String contentType = httpConn.getContentType();
      int contentLength = httpConn.getContentLength();
      if (disposition != null)
      {
        int index = disposition.indexOf("filename=");
        if (index > 0) {
          fileName = disposition.substring(index + 10, 
            disposition.length() - 1);
        }
      }
      else
      {
        fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1, 
          fileURL.length());
      }
      System.out.println("Content-Type = " + contentType);
      System.out.println("Content-Disposition = " + disposition);
      System.out.println("Content-Length = " + contentLength);
      System.out.println("fileName = " + fileName);
      
      InputStream inputStream = httpConn.getInputStream();
      if (saveDir == "none") {
        saveFilePath = fileName;
      } else {
        saveFilePath = saveDir + File.separator + fileName;
      }
      FileOutputStream outputStream = new FileOutputStream(saveFilePath);
      
      int bytesRead = -1;
      byte[] buffer = new byte['?'];
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
      }
      outputStream.close();
      inputStream.close();
      
      System.out.println("File downloaded");
    }
    else
    {
      System.out.println("No file to download. Server replied HTTP code: " + responseCode);
    }
    httpConn.disconnect();
    return saveFilePath;
  }
  
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    Player player = (Player)sender;
   
    if (((commandLabel.equalsIgnoreCase("download")) || (commandLabel.equalsIgnoreCase("dl"))) && 
      (player.hasPermission("Downloader.download"))) {
      if (args.length == 0)
      {
        player.sendMessage(ChatColor.RED + "Wait, I think you're missing some info |:I");
      }
      else
      {
        if (args.length == 1)
        {
          String url = args[0];
          String filename = "none";
          String saveFileDir = "";
          try
          {
            saveFileDir = downloadFile(url, filename);
          }
          catch (IOException e)
          {
            e.printStackTrace();
            player.sendMessage(ChatColor.RED + "Download failed! :(");
          }
          Path DirPath = Paths.get(saveFileDir, new String[0]);
          if (Files.exists(DirPath, new LinkOption[0])) {
            player.sendMessage(ChatColor.GREEN + "Download completed without errors! :)");
          } else {
            player.sendMessage(ChatColor.RED + "Wait... That file didn't download! :O");
          }
          return true;
        }
        if (args.length == 2)
        {
          String url = args[0];
          String filename = args[1];
          if (!args[1].equalsIgnoreCase("none"))
          {
            Path folderpath = Paths.get(filename, new String[0]);
            if (Files.exists(folderpath, new LinkOption[0]))
            {
              String saveFileDir = "";
              try
              {
                saveFileDir = downloadFile(url, filename);
              }
              catch (IOException e)
              {
                e.printStackTrace();
                player.sendMessage(ChatColor.RED + "Download failed! :(");
              }
              Path DirPath = Paths.get(saveFileDir, new String[0]);
              if (Files.exists(DirPath, new LinkOption[0])) {
                player.sendMessage(ChatColor.GREEN + "Download completed without errors! :)");
              } else {
                player.sendMessage(ChatColor.RED + "Wait... That file didn't download! :O");
              }
            }
            else
            {
              player.sendMessage(ChatColor.RED + "Can't find \"" + filename + "\" I'm sorry but I tried my hardest! :(");
            }
          }
          else
          {
            filename = "none";
            String saveFileDir = "";
            try
            {
              saveFileDir = downloadFile(url, filename);
            }
            catch (IOException e)
            {
              e.printStackTrace();
              player.sendMessage(ChatColor.RED + "Download failed! :(");
            }
            Path DirPath = Paths.get(saveFileDir, new String[0]);
            if (Files.exists(DirPath, new LinkOption[0])) {
              player.sendMessage(ChatColor.GREEN + "Download completed without errors! :)");
            } else {
              player.sendMessage(ChatColor.RED + "Wait... That file didn't download! :O");
            }
          }
          return true;
        }
        int length = args.length;
        String url = args[0];
        
        String[] list = new String[length - 1];
        for (int amount = 0; amount < length - 1; amount++) {
          list[amount] = args[(amount + 1)];
        }
        String folder = Arrays.toString(list);
        folder = folder.replace("[", "");
        folder = folder.replace("]", "");
        folder = folder.replace(",", "");
        Path folderpath = Paths.get(folder, new String[0]);
        if (Files.exists(folderpath, new LinkOption[0]))
        {
          try
          {
            downloadFile(url, folder);
          }
          catch (IOException e)
          {
            e.printStackTrace();
            player.sendMessage(ChatColor.RED + "Download failed! :(");
          }
          player.sendMessage(ChatColor.GREEN + "Download completed without errors! :)");
        }
        else
        {
          player.sendMessage(ChatColor.RED + "Can't find \"" + folder + "\" I'm sorry but I tried my hardest! :(");
        }
        return true;
      }
    }
    return false;
  }
}
