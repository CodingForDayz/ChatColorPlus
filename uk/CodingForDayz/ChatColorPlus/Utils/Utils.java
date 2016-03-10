package uk.CodingForDayz.ChatColorPlus.Utils;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import uk.CodingForDayz.ChatColorPlus.Main;

public class Utils {

	double time = 0;

	
	Color Color = new Color();
	Messages Messages = new Messages();;
	private void runIimer() {
		time = 0;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if (time == 1) {
					cancel();
					return;
				}
				time = time + 50;
			}
		}.runTaskTimer(Main.getPlugin(Main.class), 0, 1);
	}
	
	private void stopTimer() {
		time = 1; 	
	}
	
	
	public String color(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public double reload() 	{
		runIimer();
		
		Color.reload();
		Messages.reload();
		stopTimer();
		return time;
	}
}
