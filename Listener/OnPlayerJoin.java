package me.devon.ItemKitDetect.listener;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener{

	public void OnPlayerJoinEvent(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		@SuppressWarnings("deprecation")
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player.getName());
		
		if(!(offlinePlayer.hasPlayedBefore())) {
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate key " + player.getName() + "starting-crate");
		}
	}
	
}
