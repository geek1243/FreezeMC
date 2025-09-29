package com.geek1243.freeze;

import com.geek1243.freeze.Commands.FreezeCommand;
import com.geek1243.freeze.Commands.FreezeInfo;
import com.geek1243.freeze.Commands.Kick;
import com.geek1243.freeze.Commands.Version;
import com.geek1243.freeze.Listeners.onBreak;
import com.geek1243.freeze.Listeners.onDamage;
import com.geek1243.freeze.Listeners.onDrop;
import com.geek1243.freeze.Listeners.onLogout;
import com.geek1243.freeze.Listeners.onMove;
import com.geek1243.freeze.Listeners.onPlace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
    public ArrayList<String> frozen = new ArrayList();
    public static String uid = "%%_USER_%%";
    public boolean sts = true;

    public main() {
    }

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§4[Freeze] By Geek1243");
        this.auth();
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.registerCommands();
        this.registerListeners();
    }

    public void registerCommands() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getCommand("ss").setExecutor(new FreezeCommand(this));
        this.getCommand("ssversion").setExecutor(new Version(this));
        this.getCommand("sshelp").setExecutor(new FreezeInfo(this));
        this.getCommand("sskick").setExecutor(new Kick(this));
    }

    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new onDrop(this), this);
        this.getServer().getPluginManager().registerEvents(new onMove(this), this);
        this.getServer().getPluginManager().registerEvents(new onLogout(this), this);
        this.getServer().getPluginManager().registerEvents(new onBreak(this), this);
        this.getServer().getPluginManager().registerEvents(new onPlace(this), this);
        this.getServer().getPluginManager().registerEvents(new onDamage(this), this);
    }

    public void auth() {
        try {
            URLConnection localURLConnection = (new URL("http://trashbin.cf/pirates.txt")).openConnection();
            localURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            localURLConnection.connect();
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localURLConnection.getInputStream(), Charset.forName("UTF-8")));
            StringBuilder localStringBuilder = new StringBuilder();

            String str1;
            while((str1 = localBufferedReader.readLine()) != null) {
                localStringBuilder.append(str1);
            }

            String str2 = localStringBuilder.toString();
            if (str2.contains(String.valueOf(uid))) {
                this.disableLeak();
            } else {
                this.sts = true;
            }
        } catch (IOException var6) {
            var6.printStackTrace();
            this.disableNoInternet();
        }
    }

    public void disableLeak() {
        for(int x = 0; x != 5000; ++x) {
            Bukkit.broadcastMessage(ChatColor.RED + "You leaked my plugin, 5k broadcast!");
        }

        this.getServer().getPluginManager().disablePlugin(this);
        this.sts = false;
    }

    public void disableNoInternet() {
        Bukkit.broadcastMessage(ChatColor.RED + "ERROR: Plugin could not verify its self: 0x0 Please Contact Geek1243");
        this.getServer().getPluginManager().disablePlugin(this);
        this.sts = false;
    }
}