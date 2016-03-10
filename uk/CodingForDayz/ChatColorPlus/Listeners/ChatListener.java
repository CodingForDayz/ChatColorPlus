package uk.CodingForDayz.ChatColorPlus.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import uk.CodingForDayz.ChatColorPlus.Utils.Color;
import uk.CodingForDayz.ChatColorPlus.Utils.Utils;

public class ChatListener implements Listener {
	
	Color Color = new Color();
	Utils Utils = new Utils();
	@EventHandler
	public void onAsyncChat(AsyncPlayerChatEvent e) {
		String code = "";
		if (Color.get().isString(e.getPlayer().getUniqueId().toString() + ".color")) {
			code = code + Color.get().getString(e.getPlayer().getUniqueId().toString() + ".color");
		}
		
		if (Color.get().isBoolean(e.getPlayer().getUniqueId().toString() + ".bold")) {
			if (Color.get().getBoolean(e.getPlayer().getUniqueId().toString() + ".bold")) {
				code = code + "&l";
			}
		}
		
		if (Color.get().isBoolean(e.getPlayer().getUniqueId().toString() + ".underlined")) {
			if (Color.get().getBoolean(e.getPlayer().getUniqueId().toString() + ".underlined")) {
				code = code + "&n";
			}
		}
		
		e.setMessage(Utils.color(code) + e.getMessage());
	}
}
