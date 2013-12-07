package org.divomaster.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Main extends JavaPlugin implements Listener{
	public Main plugin;
	ScoreboardManager manager;
	Scoreboard board;
	Commands cmds = new Commands(this);
	
	public void onDisable() {
		
	}
	
	public void onEnable(){
		manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
		getCommand("reload").setExecutor(this.cmds);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		Objective o = board.registerNewObjective("test", "playerKillCount");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("Scoreboard");
		Score score = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Kills:")); 
		score.setScore(1);
		player.setScoreboard(board);
		
	}
	
	

	

}
