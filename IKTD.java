package me.devon.ItemKitDetect;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.devon.ItemKitDetect.ranks.*;

public class IKTD extends JavaPlugin implements Listener {

	public static Logger logger = Logger.getLogger("Minecraft");
	public static IKTD plugin;
	
	RankCoal coal = new RankCoal();
	RankIron iron = new RankIron();
	RankGold gold = new RankGold();
	RankLapis lapis = new RankLapis();
	RankRedstone redstone = new RankRedstone();
	RankDiamond diamond = new RankDiamond();
	RankObsidian obsidian = new RankObsidian();
	RankEmerald emerald = new RankEmerald();
	
	@Override
	public void onDisable() {
		getLogger().info("Something went full retard");
	}
	
	@Override
	public void onEnable() {
		getLogger().info("Ya did good");
		getServer().getPluginManager().registerEvents(this, this);
	}

	// Only Used to test if it works
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		Player player = (Player) sender;
		PlayerInventory pi = player.getInventory();
		
		ItemStack CoalRankKit = new ItemStack(Material.COAL_BLOCK);
		ItemMeta CoalRankKitMeta = CoalRankKit.getItemMeta();
		CoalRankKitMeta.setDisplayName(ChatColor.DARK_GRAY + "Coal Kit");
		CoalRankKit.setItemMeta(CoalRankKitMeta);
		
		ItemStack IronRankKit = new ItemStack(Material.IRON_BLOCK);
		ItemMeta IronRankKitMeta = IronRankKit.getItemMeta();
		IronRankKitMeta.setDisplayName(ChatColor.GRAY + "Iron Kit");
		IronRankKit.setItemMeta(IronRankKitMeta);
		
		ItemStack GoldRankKit = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta GoldRankKitMeta = GoldRankKit.getItemMeta();
		GoldRankKitMeta.setDisplayName(ChatColor.YELLOW + "Gold Kit");
		GoldRankKit.setItemMeta(GoldRankKitMeta);

		ItemStack LapRankKit = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta LapRankKitMeta = LapRankKit.getItemMeta();
		LapRankKitMeta.setDisplayName(ChatColor.BLUE + "Lapis Kit");
		LapRankKit.setItemMeta(LapRankKitMeta);
		
		ItemStack RedRankKit = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta RedRankKitMeta = RedRankKit.getItemMeta();
		RedRankKitMeta.setDisplayName(ChatColor.RED + "Redstone Kit");
		RedRankKit.setItemMeta(RedRankKitMeta);
		
		ItemStack DiaRankKit = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta DiaRankKitMeta = DiaRankKit.getItemMeta();
		DiaRankKitMeta.setDisplayName(ChatColor.AQUA + "Diamond Kit");
		DiaRankKit.setItemMeta(DiaRankKitMeta);
		
		ItemStack ObiRankKit = new ItemStack(Material.OBSIDIAN);
		ItemMeta ObiRankKitMeta = ObiRankKit.getItemMeta();
		ObiRankKitMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Obsidian Kit");
		ObiRankKit.setItemMeta(ObiRankKitMeta);
		
		ItemStack EmRankKit = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta EmRankKitMeta = EmRankKit.getItemMeta();
		EmRankKitMeta.setDisplayName(ChatColor.GREEN + "Emerald Kit");
		EmRankKit.setItemMeta(EmRankKitMeta);
		
		if(commandLabel.equalsIgnoreCase("grc")) {
			if(player.isOp()) {
				pi.addItem(CoalRankKit);
			} else { 
				sender.sendMessage(ChatColor.GREEN + "[NightFall] " + ChatColor.RED + "You Must Be OP to use this command");
			}
		} else if(commandLabel.equalsIgnoreCase("gri")) {
			if(player.isOp()) {
				pi.addItem(IronRankKit);
			} else {
				sender.sendMessage(ChatColor.GREEN + "[NightFall] " + ChatColor.RED + "You Must Be OP to use this command");
			}
		}else if(commandLabel.equalsIgnoreCase("grg")) {
			if(player.isOp()) {
				pi.addItem(GoldRankKit);
			} else {
				sender.sendMessage(ChatColor.GREEN + "[NightFall] " + ChatColor.RED + "You Must Be OP to use this command");
			}
		}else if(commandLabel.equalsIgnoreCase("grl")) {
			if(player.isOp()) {
				pi.addItem(LapRankKit);
			} else {
				sender.sendMessage(ChatColor.GREEN + "[NightFall] " + ChatColor.RED + "You Must Be OP to use this command");
			}
		}else if(commandLabel.equalsIgnoreCase("grr")) {
			if(player.isOp()) {
				pi.addItem(RedRankKit);
			} else {
				sender.sendMessage(ChatColor.GREEN + "[NightFall] " + ChatColor.RED + "You Must Be OP to use this command");
			}
		}else if(commandLabel.equalsIgnoreCase("grd")) {
			if(player.isOp()) {
				pi.addItem(DiaRankKit);
			} else {
				sender.sendMessage(ChatColor.GREEN + "[NightFall] " + ChatColor.RED + "You Must Be OP to use this command");
			}
		}else if(commandLabel.equalsIgnoreCase("gro")) {
			if(player.isOp()) {
				pi.addItem(ObiRankKit);
			} else {
				sender.sendMessage(ChatColor.GREEN + "[NightFall] " + ChatColor.RED + "You Must Be OP to use this command");
			}
		}else if(commandLabel.equalsIgnoreCase("gre")) {
			if(player.isOp()) {
				pi.addItem(EmRankKit);
			} else {
				sender.sendMessage(ChatColor.GREEN + "[NightFall] " + ChatColor.RED + "You Must Be OP to use this command");
			}
		}
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockPlaceEvent(BlockPlaceEvent event) {
		
		Player p = event.getPlayer();
		
		if(p.getItemInHand().getType()==Material.COAL_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().matches(ChatColor.DARK_GRAY + "Coal Kit")) {
			event.setCancelled(true);
		} else if(p.getItemInHand().getType()==Material.IRON_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().matches(ChatColor.GRAY + "Iron Kit")) {
			event.setCancelled(true);
		} else if(p.getItemInHand().getType()==Material.GOLD_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().matches(ChatColor.YELLOW + "Gold Kit")) {
			event.setCancelled(true);
		} else if(p.getItemInHand().getType()==Material.LAPIS_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().matches(ChatColor.BLUE + "Lapis Kit")) {
			event.setCancelled(true);
		} else if(p.getItemInHand().getType()==Material.REDSTONE_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().matches(ChatColor.RED + "Redstone Kit")) {
			event.setCancelled(true);
		} else if(p.getItemInHand().getType()==Material.DIAMOND_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().matches(ChatColor.AQUA + "Diamond Kit")) {
			event.setCancelled(true);
		} else if(p.getItemInHand().getType()==Material.OBSIDIAN && p.getItemInHand().getItemMeta().getDisplayName().matches(ChatColor.LIGHT_PURPLE + "Obsidian Kit")) {
			event.setCancelled(true);
		} else if(p.getItemInHand().getType()==Material.EMERALD_BLOCK && p.getItemInHand().getItemMeta().getDisplayName().matches(ChatColor.GREEN + "Emerald Kit")) {
			event.setCancelled(true);
		}
	}
	
	

	
	// Coal Kit
	@EventHandler
	public void onInventoryCoalConfClick(InventoryClickEvent event) {
		
		ItemStack CoalRankKit = new ItemStack(Material.COAL_BLOCK);
		ItemMeta CoalRankKitMeta = CoalRankKit.getItemMeta();
		CoalRankKitMeta.setDisplayName(ChatColor.DARK_GRAY + "Coal Kit");
		CoalRankKit.setItemMeta(CoalRankKitMeta);
	
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("do you want to open it? [kit coal]")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		PlayerInventory pi = player.getInventory();
		switch (event.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			player.closeInventory();
			pi.removeItem(CoalRankKit);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit coal " + player.getName());
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			break;
		default:
			break;
		
		}
	}
	// Iron Kit
	@EventHandler
	public void onInventoryIronConfClick(InventoryClickEvent event) {
		ItemStack IronRankKit = new ItemStack(Material.IRON_BLOCK);
		ItemMeta IronRankKitMeta = IronRankKit.getItemMeta();
		IronRankKitMeta.setDisplayName(ChatColor.GRAY + "Iron Kit");
		IronRankKit.setItemMeta(IronRankKitMeta);
		
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("do you want to open it? [iron kit]")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		PlayerInventory pi = player.getInventory();
		switch (event.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			player.closeInventory();
			pi.removeItem(IronRankKit);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit iron " + player.getName());
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			break;
		default:
			break;
		
		}
	}
	// Gold Kit
	@EventHandler
	public void onInventoryGoldConfClick(InventoryClickEvent event) {
		
		ItemStack GoldRankKit = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta GoldRankKitMeta = GoldRankKit.getItemMeta();
		GoldRankKitMeta.setDisplayName(ChatColor.YELLOW + "Gold Kit");
		GoldRankKit.setItemMeta(GoldRankKitMeta);
		
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("do you want to open it? [gold kit]")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		PlayerInventory pi = player.getInventory();
		switch (event.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			player.closeInventory();
			pi.removeItem(GoldRankKit);
			Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "kit gold "  + player.getName());
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			break;
		default:
			break;
		
		}
	}
	// Lapis Kit
	@EventHandler
	public void onInventoryLapisConfClick(InventoryClickEvent event) {

		ItemStack LapRankKit = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta LapRankKitMeta = LapRankKit.getItemMeta();
		LapRankKitMeta.setDisplayName(ChatColor.BLUE + "Lapis Kit");
		LapRankKit.setItemMeta(LapRankKitMeta);
		
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("do you want to open it? [lapis kit]")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		
		PlayerInventory pi = player.getInventory();
		switch (event.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			player.closeInventory();
			pi.removeItem(LapRankKit);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit Lapis "  + player.getName());
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			break;
		default:
			break;
		
		}
	}
	// Redstone Kit
	@EventHandler
	public void onInventoryRedstoneConfClick(InventoryClickEvent event) {
		
		ItemStack RedRankKit = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta RedRankKitMeta = RedRankKit.getItemMeta();
		RedRankKitMeta.setDisplayName(ChatColor.RED + "Redstone Kit");
		RedRankKit.setItemMeta(RedRankKitMeta);
		
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("do you want to open it? [redstone kit]")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		PlayerInventory pi = player.getInventory();
		switch (event.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			player.closeInventory();
			pi.removeItem(RedRankKit);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit redstone "  + player.getName());
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			break;
		default:
			break;
		
		}
	}
	// Diamond Kit
	@EventHandler
	public void onInventoryDiamondConfClick(InventoryClickEvent event) {
		
		
		ItemStack DiaRankKit = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta DiaRankKitMeta = DiaRankKit.getItemMeta();
		DiaRankKitMeta.setDisplayName(ChatColor.AQUA + "Diamond Kit");
		DiaRankKit.setItemMeta(DiaRankKitMeta);
		
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("do you want to open it? [diamond kit]")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		PlayerInventory pi = player.getInventory();
		switch (event.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			player.closeInventory();
			pi.removeItem(DiaRankKit);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit diamond "  + player.getName());
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			break;
		default:
			break;
		
		}
	}
	// Obsidian Kit
	@EventHandler
	public void onInventoryObsidianConfClick(InventoryClickEvent event) {
		
		ItemStack ObiRankKit = new ItemStack(Material.OBSIDIAN);
		ItemMeta ObiRankKitMeta = ObiRankKit.getItemMeta();
		ObiRankKitMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Obsidian Kit");
		ObiRankKit.setItemMeta(ObiRankKitMeta);
		
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("do you want to open it? [obsidian kit]")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		PlayerInventory pi = player.getInventory();
		switch (event.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			player.closeInventory();
			pi.removeItem(ObiRankKit);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit obsidian "  + player.getName());
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			break;
		default:
			break;
		
		}
	}
	// Emerald Kit
	@EventHandler
	public void onInventoryEmeraldConfClick(InventoryClickEvent event) {
		
		ItemStack EmRankKit = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta EmRankKitMeta = EmRankKit.getItemMeta();
		EmRankKitMeta.setDisplayName(ChatColor.GREEN + "Emerald Kit");
		EmRankKit.setItemMeta(EmRankKitMeta);
		
		if(!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("do you want to open it? [emerald kit]")) 
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR || !event.getCurrentItem().hasItemMeta()) {
			player.closeInventory();
			return;
		}
		PlayerInventory pi = player.getInventory();
		switch (event.getCurrentItem().getType()) {
		case EMERALD_BLOCK:
			player.closeInventory();
			pi.removeItem(EmRankKit);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kit emerald "  + player.getName());
			break;
		case REDSTONE_BLOCK:
			player.closeInventory();
			break;
		default:
			break;
		
		}
	}
}
