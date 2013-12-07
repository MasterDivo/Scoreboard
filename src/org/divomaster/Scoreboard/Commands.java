package org.divomaster.Scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{
	
	public Main plugin;
	public Commands(Main instance){
		this.plugin = instance;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("reload")) {
			if ((sender instanceof Player)) {
				Player player = (Player) sender;
				if (player.hasPermission("Scoreboard.reload"))
					;
				
				//Reload code
				player.sendMessage(ChatColor.GREEN + "Plugin Reloaded!");
		
			}
		
		return false;
	}
		return false;
	
	}
}
