package uk.CodingForDayz.ChatColorPlus.Utils;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import uk.CodingForDayz.ChatColorPlus.Main;

public class Messages {
	
	private File f;
	private FileConfiguration fc;
	
	JavaPlugin plugin = Main.getPlugin(Main.class);
	private void saveDefault() {
		f = new File(plugin.getDataFolder(), "messages.yml");
		
		if (!f.exists()) {
			plugin.saveResource("messages.yml", true);
		}
		
		fc = YamlConfiguration.loadConfiguration(f);
	}
	
	public FileConfiguration get() {
		saveDefault();
		return fc;
	}
	
	public void reload() {
		f = new File(plugin.getDataFolder(), "messages.yml");
		fc = YamlConfiguration.loadConfiguration(f);
	}
		
}
