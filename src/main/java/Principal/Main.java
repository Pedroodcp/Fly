package Principal;

import Principal.Comandos.fly;
import Principal.Eventos.FlyEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    public void onEnable() {
        instance = this;
        loadCommands();
        loadConfig();
        loadEvents();
        Bukkit.getConsoleSender().sendMessage("§a[Fly] Plugin ativado com sucesso.");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c[Fly] Plugin desativado.");
    }

    public void loadCommands() {
        getCommand("fly").setExecutor(new fly());
    }

    public void loadEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new FlyEvent(), this);
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }

}
