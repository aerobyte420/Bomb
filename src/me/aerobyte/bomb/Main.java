package me.aerobyte.bomb;

import me.aerobyte.bomb.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;

    public void onEnable() {
        plugin = this;
        getCommand("clear").setExecutor(new ClearCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
    }

    public static Main getPlugin() {
        return plugin;
    }

}
