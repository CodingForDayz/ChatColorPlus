package uk.CodingForDayz.ChatColorPlus;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import uk.CodingForDayz.ChatColorPlus.Commands.ChatColorCMD;
import uk.CodingForDayz.ChatColorPlus.Listeners.ChatListener;
import uk.CodingForDayz.ChatColorPlus.Listeners.GUIListener;
import uk.CodingForDayz.ChatColorPlus.Utils.Color;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("chatcolor").setExecutor(new ChatColorCMD());
		
		check();
		
		Bukkit.getPluginManager().registerEvents(new GUIListener(), this);
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);

	}
	
	public void check() {
		Color Color = new Color();
		
		if (Color.get().isBoolean("newConfig")) {
			return;
		}
		
		Color.forceCreation();
	}
}
