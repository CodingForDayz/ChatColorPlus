package uk.CodingForDayz.ChatColorPlus.Utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import uk.CodingForDayz.ChatColorPlus.Main;

public class Color {

	private String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	private Messages messages = new Messages();
	private File f;
	private FileConfiguration fc;	
	private JavaPlugin plugin = Main.getPlugin(Main.class);
	private void create() {
		f = new File(plugin.getDataFolder(), "colors.yml");
		if (!f.exists()) {
			plugin.saveResource("colors.yml", true);
		}
		
		fc = YamlConfiguration.loadConfiguration(f);
	}	
	public void addColor(Player p, String color) {
		p.closeInventory();
		get().set(p.getUniqueId().toString() + ".color", color);
		save();
		
		String change_message = messages.get().getString("COLOR-CHANGE");
		change_message = change_message.replace("%color%", getCode(p));
		p.sendMessage(color(change_message));
	}
	
	public void setBold(Player p, boolean toggle) {
		p.closeInventory();
		get().set(p.getUniqueId().toString() + ".bold", toggle);
		save();
		
		String change_message = messages.get().getString("COLOR-CHANGE");
		change_message = change_message.replace("%color%", getCode(p));
		p.sendMessage(color(change_message));
		return;
	}
	
	public boolean isBold(Player p) {
		if (get().getBoolean(p.getUniqueId().toString() + ".bold")) {
			return true;
		}
		return false;
	}
	
	public boolean isUnderlined(Player p) {
		if (get().getBoolean(p.getUniqueId().toString() + ".underlined")) {
			return true;
		}
		return false;
	}
	
	public void setUnderlined(Player p, boolean toggle) {
		p.closeInventory();
		get().set(p.getUniqueId().toString() + ".underlined", toggle);
		save();
		
		String change_message = messages.get().getString("COLOR-CHANGE");
		change_message = change_message.replace("%color%", getCode(p));
		p.sendMessage(color(change_message));
		return;
	}
	
	public FileConfiguration get() {
		create();
		return fc;
	}
	
	public String getCode(Player p) {
		String code = "";
		if (get().isString(p.getUniqueId().toString() + ".color")) {
			code = code + get().getString(p.getUniqueId().toString() + ".color");
		}
		if (get().isBoolean(p.getUniqueId().toString() + ".bold")) {
			if (get().getBoolean(p.getUniqueId().toString() + ".bold")) {
				code = code + "&l";
			}
		}
		
		if (get().isBoolean(p.getUniqueId().toString() + ".underlined")) {
			if (get().getBoolean(p.getUniqueId().toString() + ".underlined")) {
				code = code + "&n";
			}
		}
		
		return code;
	}
	
	public void save() {
		try {
			fc.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void forceCreation() {
		plugin.saveResource("colors.yml", true);
	}
	public void reload(){
		f = new File(plugin.getDataFolder(), "messages.yml");
		fc = YamlConfiguration.loadConfiguration(f);
	}
}
