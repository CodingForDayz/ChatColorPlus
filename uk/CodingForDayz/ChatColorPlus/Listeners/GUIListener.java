package uk.CodingForDayz.ChatColorPlus.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import uk.CodingForDayz.ChatColorPlus.Utils.Color;
import uk.CodingForDayz.ChatColorPlus.Utils.Inv;
import uk.CodingForDayz.ChatColorPlus.Utils.Messages;
import uk.CodingForDayz.ChatColorPlus.Utils.Utils;

public class GUIListener implements Listener{

	Utils Utils = new Utils();
	Messages Messages = new Messages();
	Color Color = new Color();
	Inv Inv = new Inv();
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getInventory().getName().equals(Utils.color(Messages.get().getString("GUI-TITLE")))) {
			Player p = (Player) e.getWhoClicked();
			if (e.getCurrentItem().hasItemMeta()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&1Dark Blue&7)"))) {
					if (p.hasPermission("ChatColor.DARK_BLUE")) {
						e.setCancelled(true);
						Color.addColor(p,"&1");
					}
				}
					
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&2Dark Green&7)"))) {
					if (p.hasPermission("ChatColor.DARK_GREEN")) {
						e.setCancelled(true);
						Color.addColor(p,"&2");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&3Cyan&7)"))) {
					if (p.hasPermission("ChatColor.CYAN")) {
						e.setCancelled(true);
						Color.addColor(p,"&3");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&4Dark Red&7)"))) {
					if (p.hasPermission("ChatColor.DARK_RED")) {
						e.setCancelled(true);
						Color.addColor(p,"&4");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&5Purple&7)"))) {
					if (p.hasPermission("ChatColor.PURPLE")) {
						e.setCancelled(true);
						Color.addColor(p,"&5");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&6Gold&7)"))) {
					if (p.hasPermission("ChatColor.GOLD")) {
						e.setCancelled(true);
						Color.addColor(p,"&6");
					}				
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&7Light Gray&7)") )) {
					if (p.hasPermission("ChatColor.LIGHT_GRAY")) {
						e.setCancelled(true);
						Color.addColor(p,"&7");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&8Dark Gray&7)"))) {
					if (p.hasPermission("ChatColor.DARK_GRAY")) {
						e.setCancelled(true);
						Color.addColor(p,"&8");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&9Blue&7)") )) {
					if (p.hasPermission("ChatColor.BLUE")) {
						e.setCancelled(true);
						Color.addColor(p,"&9");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&aGreen&7)"))) {
					if (p.hasPermission("ChatColor.GREEN")) {
						e.setCancelled(true);
						Color.addColor(p,"&a");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&bLight Blue&7)"))) {
					if (p.hasPermission("ChatColor.LIGHT_BLUE")) {
						e.setCancelled(true);
						Color.addColor(p,"&b");
					}
				}
				
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&cRed&7)"))) {
					if (p.hasPermission("ChatColor.RED")) {
						e.setCancelled(true);
						Color.addColor(p,"&c");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&dPink&7)"))) {
					if (p.hasPermission("ChatColor.PINK")) {
						e.setCancelled(true);
						Color.addColor(p,"&d");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&eYellow&7)"))) {
					if (p.hasPermission("ChatColor.YELLOW")) {
						e.setCancelled(true);
						Color.addColor(p,"&e");
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&rReset&7)"))) {
					if (p.hasPermission("ChatColor.RESET")) {
						e.setCancelled(true);
						Color.get().set(e.getWhoClicked().getUniqueId().toString(), null);
						Color.save();
						p.sendMessage(Utils.color(Messages.get().getString("COLOR-CHANGE").replace("%color%", Color.getCode(p))));
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&r&lBold&7)"))) {
					if (p.hasPermission("ChatColor.BOLD")) {
						e.setCancelled(true);
						Color.setBold(p, !Color.isBold(p));
						
						if (Color.isBold(p)) {
							e.getInventory().setItem(30, Inv.create(Material.WOOL, 1, Utils.color("&7(&r&lBold&7)"), Utils.color("&7This will make your Messages bold."), 5));
							p.updateInventory();
						}else{
							e.getInventory().setItem(30, Inv.create(Material.WOOL, 1, Utils.color("&7(&r&lBold&7)"), Utils.color("&7This will make your Messages bold."), 14));
							p.updateInventory();
						}
					}
				}
				
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&7(&nUnderlined&7)"))) {
					if (p.hasPermission("ChatColor.UNDERLINED")) {
						e.setCancelled(true);
						Color.setUnderlined(p, !Color.isUnderlined(p));
						
						if (Color.isUnderlined(p)) {
							e.getInventory().setItem(32, Inv.create(Material.WOOL, 1, Utils.color("&7(&nUnderlined&7)"), Utils.color("&7This will make your Messages underlined."), 5));
							p.updateInventory();
						}else{
							e.getInventory().setItem(32, Inv.create(Material.WOOL, 1, Utils.color("&7(&nUnderlined&7)"), Utils.color("&7This will make your Messages underlined."), 14));
							p.updateInventory();
						}
					}
				}
			}
				
				
				
				
				
				
			e.setCancelled(true);
		}
	}
}
