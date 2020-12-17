package me.zsergio.scoreboard.util;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Utils {
	
	public static String string(String str) {
		
		return str.replace("&", "§");
	}
	
	public static String pstring(String str, Player target) {
		String finalstr = string(str).replace("%player%", target.getName());
		
		if(target.getGameMode() == GameMode.CREATIVE) {
			finalstr = finalstr.replace("%gamemode%", "CREATIVO");
		} if(target.getGameMode() == GameMode.SURVIVAL) {
			finalstr = finalstr.replace("%gamemode%", "SURVIVAL");
		} if(target.getGameMode() == GameMode.ADVENTURE) {
			finalstr = finalstr.replace("%gamemode%", "AVENTURA");
		}
		
		return finalstr;
	}

}
