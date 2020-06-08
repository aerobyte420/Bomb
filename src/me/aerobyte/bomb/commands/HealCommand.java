package me.aerobyte.bomb.commands;

import me.aerobyte.bomb.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player player = (Player) commandSender;
        if (commandSender.hasPermission("bomb.heal")) {
            if (args.length < 1)
                player.setHealth(20);
            player.setFoodLevel(20);
            player.sendMessage(Utils.chat("&6» &eYou have been healed"));
            return true;
        } else {
            player.sendMessage(Utils.chat("&cNo permission"));
            return false;
        }
    }
}


