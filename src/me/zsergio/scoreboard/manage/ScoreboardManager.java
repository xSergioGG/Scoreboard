package me.zsergio.scoreboard.manage;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class ScoreboardManager {
	
	private HashMap<UUID, PlayerScoreboard> scoreboards = new HashMap<>();
	
	public void regPlayer(Player player) {
		UUID uuid = player.getUniqueId();
		if(!scoreboards.containsKey(uuid)) {
			scoreboards.put(uuid, new PlayerScoreboard(uuid));
		}
	}
	
	public HashMap<UUID, PlayerScoreboard> getScoreboards() {
		return scoreboards;
	}

}
