package me.aerobyte.bomb.commands;

import me.aerobyte.bomb.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    private Object GameMode;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(Utils.chat("&cYou must be a player to execute this command"));
            return true;
        }

        Player player = (Player) commandSender;
        if(player.hasPermission("bomb.gm"))

        if (args.length < 1) {
        commandSender.sendMessage(Utils.chat("&4» &cUsage: /gamemode <0, 1>"));
        return true;
        }
        if (args.length < 2) {
        if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
        player.setGameMode(org.bukkit.GameMode.CREATIVE);
        player.sendMessage(Utils.chat("&6» &eYour gamemode has been updated to &fCREATIVE"));
        return true;
        } else if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
        player.setGameMode(org.bukkit.GameMode.SURVIVAL);
        player.sendMessage(Utils.chat("&6» &eYour gamemode has been updated to &fSURVIVAL"));
        return true;
        } else {
        player.sendMessage(Utils.chat("&4» &cInvalid gamemode"));
        return true;
        }
        }

        Player target = Bukkit.getServer().getPlayer(args[1]);

        if (target == null) {
        player.sendMessage(Utils.chat("&4» &cSpecified player is not online"));
        return true;
        }

        if (args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
        target.setGameMode(org.bukkit.GameMode.CREATIVE);
        target.sendMessage(Utils.chat("&6» &eYour gamemode has been set to &fCREATIVE"));
        player.sendMessage(Utils.chat("&6» &eYou have set &f" + target.getName() + "&e's gamemode to &fCREATIVE"));
        return true;
        } else if (args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
        target.setGameMode(org.bukkit.GameMode.SURVIVAL);
        target.sendMessage(Utils.chat("&6» &eYour gamemode has been set to &fSURVIVAL"));
        player.sendMessage(Utils.chat("&6» &eYou have set &f" + target.getName() + "&e's gamemode to &fSURVIVAL"));
        return true;
        } else {
        player.sendMessage(Utils.chat("&4» &cInvalid gamemode"));
        return false;
        }
        }
        }
