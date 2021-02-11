package Principal;

import Principal.Comandos.fly;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;

    public void onEnable() {
        instance = this;
        loadCommands();
        loadConfig();
        Bukkit.getConsoleSender().sendMessage("§a[Fly] Plugin ativado com sucesso.");
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c[Fly] Plugin desativado.");
    }

    public void loadCommands() {
        getCommand("fly").setExecutor(new fly());
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }

}
