package me.zsergio.scoreboard.manage;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import me.zsergio.scoreboard.Main;
import me.zsergio.scoreboard.util.Utils;

public class PlayerScoreboard {
	
	private Main plugin = Main.getInstance();
	private FileConfiguration config = plugin.getConfig();
	
	private UUID uuid;
	private Scoreboard score;
	private Objective obj;
	
	public PlayerScoreboard(UUID uuid) {
		this.uuid = uuid;
		score = Bukkit.getScoreboardManager().getNewScoreboard();
		obj = score.registerNewObjective("aaa", "bbb");
		Bukkit.getPlayer(uuid).getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
		setScoreboard(Bukkit.getPlayer(uuid));
	}
	
	private void setScoreboard(Player player) {
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName(Utils.string(config.getString("title")));
		
		int size = config.getStringList("board").size();
		
		for(String str : config.getStringList("board")) {
			Score score = obj.getScore(Utils.pstring(str, player));
			score.setScore(size--);
		}
		player.setScoreboard(score);
	}

}
