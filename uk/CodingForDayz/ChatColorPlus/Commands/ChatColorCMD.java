package uk.CodingForDayz.ChatColorPlus.Commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import uk.CodingForDayz.ChatColorPlus.Utils.Color;
import uk.CodingForDayz.ChatColorPlus.Utils.Inv;
import uk.CodingForDayz.ChatColorPlus.Utils.Messages;
import uk.CodingForDayz.ChatColorPlus.Utils.Utils;

public class ChatColorCMD implements CommandExecutor {

	Utils Utils = new Utils();
	Inv Inv = new Inv();
	Color Color = new Color();
	
	List <String> cmds = Arrays.asList("reload", "version", "reset");
	Messages Messages = new Messages();
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if (s instanceof Player) {
			Player p = (Player) s;
			if (p.hasPermission("ChatColor.Use")) {
				if (args.length < 1) {
					p.openInventory(Inv.menu(p));
					return true;
				}
				
				if (args.length == 1) {
					if (isArgument(args[0])) {
						if (args[0].equalsIgnoreCase("reload")) {
							if (p.hasPermission("ChatColor.admin")) {
								double time = 0;
								time = Utils.reload();
								p.sendMessage(Utils.color(Messages.get().getString("RELOAD-SUCCESS").replace("%ms%", String.valueOf(time))));
							}
						}
 					}else{
 						for (String o: Messages.get().getStringList("HELP-MESSAGE")) {
 							p.sendMessage(Utils.color(o));
 						}
 					}
				}
				
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("reset")) {
						if (p.hasPermission("ChatColor.admin")) {
							OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
							
							if (!op.isOnline()) {
								p.sendMessage(Utils.color(Messages.get().getString("INVALID-PLAYER").replace("%player", args[1])));
								return true;
							}
							Player target = (Player) op;
							
							Color.get().set(target.getUniqueId().toString(), null);
							p.sendMessage(Utils.color(Messages.get().getString("RESET-SUCCESS").replace("%player%", args[1])));
							Color.save();
							return true;
						}
					}
				}
			}else{
				p.sendMessage(Utils.color(Messages.get().getString("NO-PERMISSION")));
			}
			
		}else{
			s.sendMessage(Messages.get().getString("PLAYER-ONLY-COMMAND"));
		}
		return false;
	}
	private boolean isArgument(String string) {
		if (cmds.contains(string.toLowerCase())) {
			return true;
		}
		return false;
	}

}