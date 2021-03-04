package Principal.Comandos;

import static Principal.Main.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class fly implements CommandExecutor {

    public static ArrayList<Player> fly = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("fly")) {
            if (!p.hasPermission("fly.use")) {
                p.sendMessage("§cVocê não possui permissão para utilizar este comando.");

            } else {
                if (!fly.contains(p)) {
                    p.setAllowFlight(true);
                    fly.add(p);
                    p.sendMessage(getInstance().getConfig().getString("Config.ativado").replace("&", "§"));

                } else {
                    p.setAllowFlight(false);
                    fly.remove(p);
                    p.sendMessage(getInstance().getConfig().getString("Config.desativado").replace("&", "§"));
                }
            }

        }

        return false;
    }
}
