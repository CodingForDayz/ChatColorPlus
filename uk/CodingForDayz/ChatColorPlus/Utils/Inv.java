package uk.CodingForDayz.ChatColorPlus.Utils;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inv {

	Messages Messages = new Messages();
	Utils Utils = new Utils();
	Color Color = new Color();
	
	public Inventory menu(Player p) {
		Inventory menu = Bukkit.createInventory(null, 36, Utils.color(Messages.get().getString("GUI-TITLE")));
		
		createButton(Material.STAINED_GLASS_PANE, menu, 10, Utils.color("&7(&1Dark Blue&7)") , Utils.color("&7This will change your ChatColor to &1this."), 1, 11);
		createButton(Material.STAINED_GLASS_PANE, menu, 11, Utils.color("&7(&2Dark Green&7)") , Utils.color("&7This will change your ChatColor to &2this."), 1, 13);
		createButton(Material.STAINED_GLASS_PANE, menu, 12, Utils.color("&7(&3Cyan&7)") , Utils.color("&7This will change your ChatColor to &3this."), 1, 9);
		createButton(Material.STAINED_GLASS_PANE, menu, 13, Utils.color("&7(&4Dark Red&7)") , Utils.color("&7This will change your ChatColor to &4this."), 1, 14);
		createButton(Material.STAINED_GLASS_PANE, menu, 14, Utils.color("&7(&5Purple&7)") ,Utils.color("&7This will change your ChatColor to &5this."), 1, 10);
		createButton(Material.STAINED_GLASS_PANE, menu, 15, Utils.color("&7(&6Gold&7)") ,Utils.color("&7This will change your ChatColor to &6this."), 1, 1);
		createButton(Material.STAINED_GLASS_PANE, menu, 16, Utils.color("&7(&7Light Gray&7)") ,Utils.color("&7This will change your ChatColor to &7this."), 1, 7);
		createButton(Material.STAINED_GLASS_PANE, menu, 19, Utils.color("&7(&8Dark Gray&7)") ,Utils.color("&7This will change your ChatColor to &8this."), 1, 7);
		createButton(Material.STAINED_GLASS_PANE, menu, 20, Utils.color("&7(&9Blue&7)") ,Utils.color("&7This will change your ChatColor to &9this."), 1, 11);
		createButton(Material.STAINED_GLASS_PANE, menu, 21, Utils.color("&7(&aGreen&7)") ,Utils.color("&7This will change your ChatColor to &athis."), 1, 5);
		createButton(Material.STAINED_GLASS_PANE, menu, 22, Utils.color("&7(&bLight Blue&7)") ,Utils.color("&7This will change your ChatColor to &bthis."), 1, 11);
		createButton(Material.STAINED_GLASS_PANE, menu, 23, Utils.color("&7(&cRed&7)") ,Utils.color("&7This will change your ChatColor to &cthis."), 1, 14);
		createButton(Material.STAINED_GLASS_PANE, menu, 24, Utils.color("&7(&dPink&7)") ,Utils.color("&7This will change your ChatColor to &dthis."), 1, 6);
		createButton(Material.STAINED_GLASS_PANE, menu, 25, Utils.color("&7(&eYellow&7)") ,Utils.color("&7This will change your ChatColor to &ethis."), 1, 4);
		createButton(Material.ANVIL, menu, 31, Utils.color("&7(&rReset&7)"), Utils.color("&7This will change your ChatColor to &rthis."), 1, 0);
		if (Color.isBold(p)) {
			createButton(Material.WOOL,menu, 30, Utils.color("&7(&r&lBold&7)"), Utils.color("&7This will make your Messages bold."), 1, 14);
		}else{
			createButton(Material.WOOL,menu, 30, Utils.color("&7(&r&lBold&7)"), Utils.color("&7This will make your Messages bold."), 1, 5);
		}
		if (Color.isUnderlined(p)) {
			createButton(Material.WOOL, menu, 32, Utils.color("&7(&nUnderlined&7)"), Utils.color("&7This will make your Messages underlined."), 1, 14);
		}else{
			createButton(Material.WOOL, menu, 32, Utils.color("&7(&nUnderlined&7)"), Utils.color("&7This will make your Messages underlined."), 1, 5);
		}



		return menu;
	}
	
	  public void createButton(Material mat, Inventory inv, int Slot, String name, String lore, int amount, int data) {
		    ItemStack item = new ItemStack(mat, amount, (byte) data);
		    ItemMeta meta = item.getItemMeta();
		    meta.setDisplayName(name);
		    meta.setLore(Arrays.asList(new String[] { lore}));
		    item.setItemMeta(meta);
		    inv.setItem(Slot, item);
	}
	  
	  public ItemStack create(Material material, int ammount, String displayname, String lore, int data) {
		  ItemStack i = new ItemStack(material, ammount,(byte) data);
		  
		  ItemMeta imeta = i.getItemMeta();
		  
		  imeta.setDisplayName(displayname);
		  imeta.setLore(Arrays.asList(lore));
		  
		  i.setItemMeta(imeta);
		  
		  return i;
	  }
}
