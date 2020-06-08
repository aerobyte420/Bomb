package me.aerobyte.bomb.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.aerobyte.bomb.Main;
import me.aerobyte.bomb.utils.Utils;

public class ClearCommand implements CommandExecutor {

    private Main plugin = Main.getPlugin();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if(!(sender instanceof Player)) {
            sender.sendMessage(Utils.chat("&cOnly players may execute this command"));
            return true;
        }

        Player p = (Player) sender;

        if(p.hasPermission("bomb.clear")) {
            if(args.length == 0) {
                p.getInventory().clear();
                p.sendMessage(Utils.chat("&6» &eYou have cleared your inventory"));
            } else if(args.length == 1) {
                Player targetplayer = p.getServer().getPlayer(args[0]);
                targetplayer.getInventory().clear();
                p.sendMessage(Utils.chat("&6» &eYou have just cleared &f" + targetplayer.getName() + "&e's inventory"));
                targetplayer.sendMessage(Utils.chat("&6» &eYour inventory has been cleared by &f" + sender.getName()));
                return true;
            } else {
                p.sendMessage(Utils.chat("&cNo permission."));
            }
        }
        return false;
    }
}