package me.zsergio.scoreboard;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.zsergio.scoreboard.listener.Mechanics;
import me.zsergio.scoreboard.manage.ScoreboardManager;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	private ScoreboardManager scoreboardManager;
	
	@Override
	public void onEnable() {
		instance = this;
		scoreboardManager = new ScoreboardManager();
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new Mechanics(), this);
		regConfig();
	}
	
	private void regConfig() {
		File config = new File(this.getDataFolder(), "config.yml");
		if(!config.exists()) {
			getConfig().options().copyDefaults(true);
		}
		saveConfig();
	}
	
	public ScoreboardManager getScoreboardManager() {
		return scoreboardManager;
	}
	
	public static Main getInstance() {
		return instance;
	}

}
