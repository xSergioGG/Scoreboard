package me.zsergio.scoreboard.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.zsergio.scoreboard.Main;
import me.zsergio.scoreboard.manage.ScoreboardManager;

public class Mechanics implements Listener {
	
	private Main plugin = Main.getInstance();
	private ScoreboardManager smanager = plugin.getScoreboardManager();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		smanager.regPlayer(player);
	}

}
