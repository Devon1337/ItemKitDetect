package me.devon.ItemKitDetect.ranks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RankObsidian {
	public void openObsidianGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 18, ChatColor.GREEN + "Do you want to open it? [Obsidian Kit]");
		
		ItemStack BlockerStack = new ItemStack(Material.BARRIER);
		ItemMeta BlockerMeta = BlockerStack.getItemMeta();
		
		BlockerMeta.setDisplayName(ChatColor.RED + " ");
		BlockerStack.setItemMeta(BlockerMeta);
		
		ItemStack YesItem = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta YesMeta = YesItem.getItemMeta();
		
		YesMeta.setDisplayName(ChatColor.GREEN + "YES!");
		YesItem.setItemMeta(YesMeta);
		
		ItemStack NoItem = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta NoMeta = NoItem.getItemMeta();
		
		NoMeta.setDisplayName(ChatColor.RED + "NO!");
		NoItem.setItemMeta(NoMeta);
		
		inv.setItem(4, BlockerStack);
		inv.setItem(13, BlockerStack);
		
		for(int x = 0; x <= 3; x++) {
			inv.setItem(x, YesItem);	
		}
		for(int x = 9; x <= 12; x++) {
			inv.setItem(x, YesItem);
		}	
		
		for(int x = 5; x <= 8; x++) {
			inv.setItem(x, NoItem);
		}
		for(int x = 14; x <= 17; x++) {
			inv.setItem(x, NoItem);
		}
		
		player.openInventory(inv);
	}
}
